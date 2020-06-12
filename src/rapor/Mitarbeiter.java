// Onur Kanıt 170503026
package rapor;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class Mitarbeiter
{
    private String ID,password;
    private String level;
    private String firstName, lastName;
    private LocalDate sertifikatarihi;
    private byte [] salt;

    public Mitarbeiter(String firstName, String lastName, String ID, String password,String level, LocalDate sertifikatarihi) throws NoSuchAlgorithmException
    {
        setFirstName(firstName);
        setLastName (lastName);
        setID (ID);
        salt = PasswordGenerator.getSalt();
        this.password = PasswordGenerator.getSHA512Password(password, salt);
        setLevel(level);
        setSertifikatarihi(sertifikatarihi);
        
        
    }

    public LocalDate getSertifikatarihi() {
        return sertifikatarihi;
    }

    public void setSertifikatarihi(LocalDate sertifikatarihi) {
        
        this.sertifikatarihi = sertifikatarihi;
    }
    
     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName =firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getLevel(){
        return level;
    }
    
    public void setLevel(String level){
        this.level= level ;
    }
    
    public String toString(){
        return String.format("%s %s %s %s %s", firstName,lastName,ID,password,level);
    }
    
    public void DeleteFromDATABASE () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
            con= DataBase.getConnection();
            String sql = "DELETE FROM Mitarbeiter WHERE MitarbeiterID = ?"; 

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ID);
            preparedStatement.executeUpdate();
           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally
        {
            if(preparedStatement !=null)
               preparedStatement.close();
            
            if(con != null)
               con.close();
        }
    }
    
    public void InsertintoDATABASE() throws SQLException{
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
       
        try
        {
            con= DataBase.getConnection();
            String sql = "INSERT INTO Mitarbeiter (firstName, lastName,MitarbeiterID, passw, lvl, sertifikatarihi, salt)"
                 +"VALUES(?,?,?,?,?,?,?)"; 

            preparedStatement = con.prepareStatement(sql);

            Date db = Date.valueOf(sertifikatarihi);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, ID);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, level);
            preparedStatement.setDate(6, db);
            preparedStatement.setBlob(7, new javax.sql.rowset.serial.SerialBlob(salt));

            preparedStatement.executeUpdate();
           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally
        {
            if(preparedStatement !=null)
               preparedStatement.close();
            
            if(con != null)
               con.close();
        }
        
    }
    
     public static boolean CheckUsernameExists(String username)
        {
            boolean usernameExists = true;
            Connection con = null;
            PreparedStatement preparedStatement = null;

            try
            {
            con= DataBase.getConnection();
            String sql = "select MitarbeiterID from Mitarbeiter "; 
                

                PreparedStatement st = con.prepareStatement(sql);
                ResultSet r1=st.executeQuery();
                String MitarbeiterIDCounter;
                 while(r1.next()) 
                 {
                   MitarbeiterIDCounter =  r1.getString("MitarbeiterID");
                   if(MitarbeiterIDCounter.equals(username)) 
                   {
                       
                      usernameExists = false;
                   }
                 }


             }

             catch (SQLException e) 
             {
               System.out.println("SQL Exception: "+ e.toString());
             }

             return usernameExists;
        }
        
    public static boolean  sifreUzunlukKontrol(String sifre){
        
        if(sifre.length()<=5 || sifre.length()>=31){
            
           return false; 
            
        }
        else{
            
            return true;
        }
    }
    
    public static boolean  UzunlukKontrol(String isim, String soyisim, String ID){
        
        if(isim.length()>=30 || soyisim.length()>=30 || ID.length()>=30){
            
           return false; 
            
        }
        else{
            
            return true;
        }
    }
    
    public static boolean LevelKontrol (String level){
        try{
          int i=Integer.parseInt(level);  
        if (i>0 && i<4){
            return true;
        }
        else{
            return false;
        }  
        }
        catch (Exception e){
            
            return false;
        }
        
        
    }
    
    public static boolean DateControl (LocalDate Date){
        if(Date.isBefore(LocalDate.now())){
            return false;
        }
        else{
            return true;
        }
    }
            
    
    
    
    
    public void UpdateFirstName () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Mitarbeiter SET firstName =?" + "WHERE MitarbeiterID = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, firstName);
           preparedStatement.setString(2, ID);
           
           
           preparedStatement.executeUpdate();
           preparedStatement.close();


           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally
        {
            if(preparedStatement !=null)
               preparedStatement.close();
            
            if(con != null)
               con.close();
        }
    }
    
    public void UpdateSertifikaTarihi () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
           con= DataBase.getConnection();
           String sql = "UPDATE Mitarbeiter SET sertifikatarihi =?" + "WHERE MitarbeiterID = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           Date bd = Date.valueOf(sertifikatarihi);

           
           preparedStatement.setDate(1, bd);
           preparedStatement.setString(2, ID);
           
           
           preparedStatement.executeUpdate();
           preparedStatement.close();


           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally
        {
            if(preparedStatement !=null)
               preparedStatement.close();
            
            if(con != null)
               con.close();
        }
    }
    
    public void UpdateLastName () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
           con= DataBase.getConnection();
           String sql = "UPDATE Mitarbeiter SET lastName =?" + "WHERE MitarbeiterID = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, lastName);
           preparedStatement.setString(2, ID);
           
           
           preparedStatement.executeUpdate();
           preparedStatement.close();


           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally{
            if(preparedStatement !=null)
               preparedStatement.close();
            
            if(con != null)
               con.close();
        }
    }
    
    
    
    public void UpdatePassword () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
           con= DataBase.getConnection();
           String sql = "UPDATE Mitarbeiter SET passw = ?" + "WHERE MitarbeiterID = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, password);
           preparedStatement.setString(2, ID);
           
           
           preparedStatement.executeUpdate();
           preparedStatement.close();


           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally
        {
            if(preparedStatement !=null)
               preparedStatement.close();
            
            if(con != null)
               con.close();
        }
    }
    
    public void UpdateLevel () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
           con= DataBase.getConnection();
           String sql = "UPDATE Mitarbeiter SET lvl = ?" + "WHERE MitarbeiterID = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, level);
           preparedStatement.setString(2, ID);
           
           
           preparedStatement.executeUpdate();
           preparedStatement.close();


           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally
        {
            if(preparedStatement !=null)
               preparedStatement.close();
            
            if(con != null)
               con.close();
        }
    }
    
}
