// Onur Kanıt 170503026
package rapor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Ekipman {
    private String EkipmanNo,Cihaz,KutupMesafesi,MpTasiyiciOrtam,MiknatislamaTeknigi,UVIsikSiddeti,IsikMesafesi;

    public Ekipman(String EkipmanNo, String Cihaz, String KutupMesafesi, String MpTasiyiciOrtam,
                   String MiknatislamaTeknigi, String UVIsikSiddeti,String IsikMesafesi)
    {
        setEkipmanNo (EkipmanNo);
        setCihaz(Cihaz);
        setKutupMesafesi (KutupMesafesi);
        setMpTasiyiciOrtam (MpTasiyiciOrtam);
        setMiknatislamaTeknigi(MiknatislamaTeknigi);
        setUVIsikSiddeti(UVIsikSiddeti);
        setIsikMesafesi (IsikMesafesi);
        
        
    }
    
    public String getEkipmanNo()
    {
        return EkipmanNo;
    }

    public void setEkipmanNo(String EkipmanNo) 
    {
        this.EkipmanNo = EkipmanNo;
    }
    
    public String getCihaz() 
    {
        return Cihaz;
    }

    public void setCihaz(String Cihaz) 
    {
        this.Cihaz = Cihaz;
    }
    
    public String getKutupMesafesi() 
    {
        return KutupMesafesi;
    }

    public void setKutupMesafesi(String KutupMesafesi) 
    {
        this.KutupMesafesi = KutupMesafesi;
    }
    
    public String getMpTasiyiciOrtam() 
    {
        return MpTasiyiciOrtam;
    }

    public void setMpTasiyiciOrtam(String MpTasiyiciOrtam) 
    {
        this.MpTasiyiciOrtam = MpTasiyiciOrtam;
    }
    
    public String getMiknatislamaTeknigi() 
    {
        return MiknatislamaTeknigi;
    }

    public void setMiknatislamaTeknigi(String MiknatislamaTeknigi) 
    {
        this.MiknatislamaTeknigi = MiknatislamaTeknigi;
    }
    
    public String getUVIsikSiddeti() 
    {
        return UVIsikSiddeti;
    }

    public void setUVIsikSiddeti(String UVIsikSiddeti) 
    {
        this.UVIsikSiddeti = UVIsikSiddeti;
    }
    
    public String getIsikMesafesi() 
    {
        return IsikMesafesi;
    }

    public void setIsikMesafesi(String IsikMesafesi) 
    {
        this.IsikMesafesi = IsikMesafesi;
    }
    
    public String toString()
    {
        return String.format("%s %s %s %s %s %s &s", EkipmanNo,Cihaz,KutupMesafesi,MpTasiyiciOrtam,MiknatislamaTeknigi,UVIsikSiddeti,IsikMesafesi);
    }
    
    
    public void InsertintoDATABASE() throws SQLException{
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
       
        try
        {
            con= DataBase.getConnection();
            String sql = "INSERT INTO Ekipman (EkipmanNo,Cihaz,KutupMesafesi,MpTasiyiciOrtam,MiknatislamaTeknigi,UVIsikSiddeti,IsikMesafesi)"
                 +"VALUES(?,?,?,?,?,?,?)"; 

            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, EkipmanNo);
            preparedStatement.setString(2, Cihaz);
            preparedStatement.setString(3, KutupMesafesi);
            preparedStatement.setString(4, MpTasiyiciOrtam);
            preparedStatement.setString(5, MiknatislamaTeknigi);
            preparedStatement.setString(6, UVIsikSiddeti);
            preparedStatement.setString(7, IsikMesafesi);
            

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
    
    public static boolean  UzunlukKontrol(String EkipmanNo, String Cihaz, String KutupMesafesi, String MpTasyiciOrtam,
            String MiknatislamaTeknigi, String UVIsikSiddeti, String IsikMesafesi){
        
        if(EkipmanNo.length()>=50 || Cihaz.length()>=50 || KutupMesafesi.length()>=50 || MpTasyiciOrtam.length()>=50 || MiknatislamaTeknigi.length()>=50 || UVIsikSiddeti.length()>=50 || IsikMesafesi.length()>=50){
            
           return false; 
            
        }
        else{
            
            return true;
        }
    }
     
    public static boolean CheckEkipmanNoExists(String ekipmanno)
        {
            boolean ekipmanNoExists = true;
            Connection con = null;
            PreparedStatement preparedStatement = null;

            try
            {
            con= DataBase.getConnection();
            String sql = "select EkipmanNo from Ekipman "; 
                

                PreparedStatement st = con.prepareStatement(sql);
                ResultSet r1=st.executeQuery();
                String EkipmanNoCounter;
                 while(r1.next()) 
                 {
                   EkipmanNoCounter =  r1.getString("EkipmanNo");
                   if(EkipmanNoCounter.equals(ekipmanno)) 
                   {
                      ekipmanNoExists = false;
                   }
                 }


             }

             catch (SQLException e) 
             {
               System.out.println("SQL Exception: "+ e.toString());
             }

             return ekipmanNoExists;
        }
    public void DeleteFromDATABASE () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
            con= DataBase.getConnection();
            String sql = "DELETE FROM Ekipman WHERE EkipmanNo = ?"; 

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, EkipmanNo);
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
    public void UpdateCihaz () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Ekipman SET Cihaz =?" + "WHERE EkipmanNo = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, Cihaz);
           preparedStatement.setString(2, EkipmanNo);
           
           
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
    
    public void UpdateKutupMesafesi () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Ekipman SET KutupMesafesi =?" + "WHERE EkipmanNo = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, KutupMesafesi);
           preparedStatement.setString(2, EkipmanNo);
           
           
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
      
       public void UpdateMpTasiyiciOrtam () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Ekipman SET MpTasiyiciOrtam =?" + "WHERE EkipmanNo = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, MpTasiyiciOrtam);
           preparedStatement.setString(2, EkipmanNo);
           
           
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
       
        public void UpdateMiknatislamaTeknigi () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Ekipman SET MiknatislamaTeknigi =?" + "WHERE EkipmanNo = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, MiknatislamaTeknigi);
           preparedStatement.setString(2, EkipmanNo);
           
           
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
       
              public void UpdateUVIsikSiddeti () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Ekipman SET UVIsikSiddeti =?" + "WHERE EkipmanNo = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, UVIsikSiddeti);
           preparedStatement.setString(2, EkipmanNo);
           
           
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
              
              
        public void UpdateIsikMesafesi () throws SQLException
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "UPDATE Ekipman SET IsikMesafesi =?" + "WHERE EkipmanNo = ?"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1, IsikMesafesi);
           preparedStatement.setString(2, EkipmanNo);
           
           
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