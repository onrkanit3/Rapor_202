// Onur Kanıt 170503026
package rapor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class YuzeyDurumu 
{
    private String YuzeyDurumNumarasi,YuzeyDurumu;
    

    public YuzeyDurumu(String YuzeyDurumNumarasi, String YuzeyDurumu) 
    {
        this.YuzeyDurumNumarasi = YuzeyDurumNumarasi;
        this.YuzeyDurumu = YuzeyDurumu;
        
        
        
    }
    
     public String getYuzeyDurumNumarasi() 
     {
        return YuzeyDurumNumarasi;
    }

    public void setYuzeyDurumNumarasi(String YuzeyDurumNumarasi)
    {
        this.YuzeyDurumNumarasi = YuzeyDurumNumarasi;
    }
    
     public String getYuzeyDurumu()
    {
        return YuzeyDurumu;
    }
     
    public void setYuzeyDurumu(String YuzeyDurumu)
    {
        this.YuzeyDurumu = YuzeyDurumu;
    }
    
    public String toString(){
        return String.format("%s %s", YuzeyDurumNumarasi,YuzeyDurumu);
    }
     public void DeleteFromDATABASE () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
            con= DataBase.getConnection();
            String sql = "DELETE FROM YuzeyDurumu WHERE YuzeyDurumNumarasi = ?"; 

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, YuzeyDurumNumarasi);
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
            String sql = "INSERT INTO YuzeyDurumu (YuzeyDurumNumarasi, YuzeyDurumu)"
                 +"VALUES(?,?)"; 

            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, YuzeyDurumNumarasi);
            preparedStatement.setString(2, YuzeyDurumu);

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
    
     public static boolean CheckYuzeyDurumNumarasiExists(String yuzeydurumnumarasi)
        {
            boolean YuzeyDurumNumarasiExists = false;
            Connection con = null;
            PreparedStatement preparedStatement = null;

            try
            {
            con= DataBase.getConnection();
            String sql = "select YuzeyDurumNumarasi from YuzeyDurumu "; 
                

                PreparedStatement st = con.prepareStatement(sql);
                ResultSet r1=st.executeQuery();
                String YuzeyDurumNumarasiCounter;
                 while(r1.next()) 
                 {
                   YuzeyDurumNumarasiCounter =  r1.getString("YuzeyDurumNumarasi");
                   if(YuzeyDurumNumarasiCounter.equals(yuzeydurumnumarasi)) 
                   {
                       System.out.println("It already exists");
                      YuzeyDurumNumarasiExists = true;
                   }
                 }


             }

             catch (SQLException e) 
             {
               System.out.println("SQL Exception: "+ e.toString());
             }

             return YuzeyDurumNumarasiExists;
        }
        
            
    
    
    
    
    public void UpdateYuzeyDurumu () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE YuzeyDurumu SET YuzeyDurumu =?" + "WHERE YuzeyDurumNumarasi = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, YuzeyDurumu);
           preparedStatement.setString(2, YuzeyDurumNumarasi);
           
           
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
