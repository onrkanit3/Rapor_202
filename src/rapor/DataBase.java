// Onur Kanıt 170503026
package rapor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author izmir
 */
public class DataBase
{  
    private static Connection con;

    public static Connection getConnection()
    {
        try 
        {
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\izmir\\OneDrive\\Masaüstü\\DataBase\\;shutdown=true";
            con = DriverManager.getConnection(url, "onrkanit3", "123Onur123+");
            
        } 
        
        catch (SQLException e) 
        {
             System.err.println(e); 
        } 
        catch (ClassNotFoundException e){  
             System.err.println(e); 
        }
        return con;
    }
    
    
}
