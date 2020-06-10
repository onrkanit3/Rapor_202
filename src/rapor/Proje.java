// Onur Kanıt 170503026
package rapor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class Proje
{
    private String ProjeNumarasi,ProjeAdi;
    

    public Proje(String ProjeNumarasi, String ProjeAdi) {
        setProjeNumarasi(ProjeNumarasi);
        setProjeAdi(ProjeAdi);
        
        
        
        
    }
    
    public String getProjeNumarasi() {
        return ProjeNumarasi;
    }

    public void setProjeNumarasi(String ProjeNumarasi) {
        this.ProjeNumarasi = ProjeNumarasi;
    }
    
    public String getProjeAdi() {
        return ProjeAdi;
    }

    public void setProjeAdi(String ProjeAdi) {
        this.ProjeAdi = ProjeAdi;
    }
    
    public String toString(){
        return String.format("%s %s", ProjeNumarasi,ProjeAdi);
    }
    
     public void DeleteFromDATABASE () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
            con= DataBase.getConnection();
            String sql = "DELETE FROM Proje WHERE ProjeNumarasi = ?"; 

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ProjeNumarasi);
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
            String sql = "INSERT INTO Proje (ProjeNumarasi, ProjeAdi)"
                 +"VALUES(?,?)"; 

            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, ProjeNumarasi);
            preparedStatement.setString(2, ProjeAdi);

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
    
     public static boolean CheckProjeNumarasiExists(String projenumarasi)
        {
            boolean projenumarasiExists = true;
            Connection con = null;
            PreparedStatement preparedStatement = null;

            try
            {
            con= DataBase.getConnection();
            String sql = "select ProjeNumarasi from Proje "; 
                

                PreparedStatement st = con.prepareStatement(sql);
                ResultSet r1=st.executeQuery();
                String ProjeNumarasiCounter;
                 while(r1.next()) 
                 {
                   ProjeNumarasiCounter =  r1.getString("ProjeNumarasi");
                   if(ProjeNumarasiCounter.equals(projenumarasi)) 
                   {
                      
                      projenumarasiExists = false;
                   }
                 }


             }

             catch (SQLException e) 
             {
               System.out.println("SQL Exception: "+ e.toString());
             }

             return projenumarasiExists;
        }
        
            
    
    
     public static boolean  UzunlukKontrol(String ProjeNumarasi, String ProjeAdi){
        
        if(ProjeNumarasi.length()>=25 || ProjeAdi.length()>=25){
            
           return false; 
            
        }
        else{
            
            return true;
        }
    }
    
    public void UpdateProjeAdi () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Proje SET ProjeAdi =?" + "WHERE ProjeNumarasi = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, ProjeAdi);
           preparedStatement.setString(2, ProjeNumarasi);
           
           
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
