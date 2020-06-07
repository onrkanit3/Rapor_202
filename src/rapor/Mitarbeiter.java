 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

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

    public Mitarbeiter(String firstName, String lastName, String ID, String password,String level, LocalDate sertifikatarihi)
    {
        setFirstName(firstName);
        setLastName (lastName);
        setID (ID);
        setPassword (password);
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
            String sql = "INSERT INTO Mitarbeiter (firstName, lastName,MitarbeiterID, passw, lvl, sertifikatarihi)"
                 +"VALUES(?,?,?,?,?,?)"; 

            preparedStatement = con.prepareStatement(sql);

            Date db = Date.valueOf(sertifikatarihi);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, ID);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, level);
            preparedStatement.setDate(6, db);

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
            boolean usernameExists = false;
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
                       System.out.println("It already exists");
                      usernameExists = true;
                   }
                 }


             }

             catch (SQLException e) 
             {
               System.out.println("SQL Exception: "+ e.toString());
             }

             return usernameExists;
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
