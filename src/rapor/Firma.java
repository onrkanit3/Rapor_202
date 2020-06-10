// Onur Kanıt 170503026
package rapor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Firma
{
    private String MusteriIsmi, Il, Ilce, IsEmriNumarasi, TeklifNo;
    

    public Firma(String MusteriIsmi, String Il, String Ilce, String IsEmriNumarasi, String TeklifNo) 
    {
        setMusteriIsmi (MusteriIsmi);
        setIl(Il);
        setIlce(Ilce);
        setIsEmriNumarasi(IsEmriNumarasi);
        setTeklifNo(TeklifNo);
        
        
        
    }
    
    public String getMusteriIsmi() {
        return MusteriIsmi;
    }

    public void setMusteriIsmi(String MusteriIsmi) {
        this.MusteriIsmi =MusteriIsmi;
    }
    
    public String getIl() {
        return Il;
    }

    public void setIl(String Il) {
        this.Il =Il;
    }
    
    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String Ilce) {
        this.Ilce = Ilce;
    }
    
    public String getIsEmriNumarasi() {
        return IsEmriNumarasi;
    }

    public void setIsEmriNumarasi(String IsEmriNumarasi) {
        this.IsEmriNumarasi = IsEmriNumarasi;
    }
    
    public String getTeklifNo() {
        return TeklifNo;
    }

    public void setTeklifNo(String TeklifNo) {
        this.TeklifNo = TeklifNo;
    }
    
    public String toString(){
        return String.format("%s %s %s %s %s", MusteriIsmi,Il,Ilce,IsEmriNumarasi,TeklifNo);
    }
    
    public void InsertintoDATABASE() throws SQLException{
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
       
        try
        {
            con= DataBase.getConnection();
            String sql = "INSERT INTO Firma (MusteriIsmi,Il,Ilce,IsEmriNumarasi,TeklifNo)"
                 +"VALUES(?,?,?,?,?)"; 

            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, MusteriIsmi);
            preparedStatement.setString(2, Il);
            preparedStatement.setString(3, Ilce);
            preparedStatement.setString(4, IsEmriNumarasi);
            preparedStatement.setString(5, TeklifNo);
            
            

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
    public static boolean CheckIsEmriNoExists(String isemrino)
        {
            boolean IsEmriNoExists = true;
            Connection con = null;
            PreparedStatement preparedStatement = null;

            try
            {
            con= DataBase.getConnection();
            String sql = "select IsEmriNumarasi from Firma "; 
                

                PreparedStatement st = con.prepareStatement(sql);
                ResultSet r1=st.executeQuery();
                String IsEmriNumarasiCounter;
                 while(r1.next()) 
                 {
                   IsEmriNumarasiCounter =  r1.getString("IsEmriNumarasi");
                   if(IsEmriNumarasiCounter.equals(isemrino)) 
                   {
                       
                      IsEmriNoExists = false;
                   }
                 }


             }

             catch (SQLException e) 
             {
               System.out.println("SQL Exception: "+ e.toString());
             }

             return IsEmriNoExists;
        }
    
    public static boolean  UzunlukKontrol(String MusteriIsmi, String Il, String Ilce, String IsEmriNo,
            String TeklifNo){
        
        if(MusteriIsmi.length()>=25 || Il.length()>=25 || Ilce.length()>=25 || IsEmriNo.length()>=25 || TeklifNo.length()>=25){
            
           return false; 
            
        }
        else{
            
            return true;
        }
    }
     public void DeleteFromDATABASE () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
            con= DataBase.getConnection();
            String sql = "DELETE FROM Firma WHERE IsEmriNumarasi = ?"; 

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, IsEmriNumarasi);
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
    public void UpdateMusteriIsmi () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Firma SET MusteriIsmi =?" + "WHERE IsEmriNumarasi = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, MusteriIsmi);
           preparedStatement.setString(2, IsEmriNumarasi);
           
           
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
    
    public void UpdateIl() throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Firma SET Il =?" + "WHERE IsEmriNumarasi = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, Il);
           preparedStatement.setString(2, IsEmriNumarasi);
           
           
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
    
    
    public void UpdateIlce() throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Firma SET Ilce =?" + "WHERE IsEmriNumarasi = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, Ilce);
           preparedStatement.setString(2, IsEmriNumarasi);
           
           
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
    
    public void UpdateTeklifNo() throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Firma SET TeklifNo =?" + "WHERE IsEmriNumarasi = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, TeklifNo);
           preparedStatement.setString(2, IsEmriNumarasi);
           
           
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
