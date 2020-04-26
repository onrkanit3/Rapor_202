 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import java.sql.Connection;
import java.sql.Date;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;


public class Mitarbeiter {
    private SimpleStringProperty ID,password,level;
    private SimpleStringProperty firstName, lastName;
    private LocalDate sertifikatarihi;

    public Mitarbeiter(String firstName, String lastName, String ID, String password,String level, LocalDate sertifikatarihi) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.ID = new SimpleStringProperty(ID);
        this.password = new SimpleStringProperty(password);
        this.level=new SimpleStringProperty(level);
        this.sertifikatarihi= sertifikatarihi;
        
        
    }

    public LocalDate getSertifikatarihi() {
        return sertifikatarihi;
    }

    public void setSertifikatarihi(LocalDate sertifikatarihi) {
        this.sertifikatarihi = sertifikatarihi;
    }
    
   
     public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }

    public String getID() {
        return ID.get();
    }

    public void setID(String ID) {
        this.ID = new SimpleStringProperty(ID);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }
    
    public String getLevel(){
        return level.get();
    }
    
    public void setLevel(String level){
        this.level= new SimpleStringProperty(level );
    }
    
    public String toString(){
        return String.format("%s %s %s %s %s", firstName,lastName,ID,password,level);
    }
    
    public void InsertintoDATABASE() throws SQLException{
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try{
           con= DataBase.getConnection();
           String sql = "INSERT INTO Mitarbeiter (firstName, lastName,MitarbeiterID, passw, lvl, sertifikatarihi)"
                    +"VALUES(?,?,?,?,?,?)"; 
           
           preparedStatement = con.prepareStatement(sql);
           
           Date db = Date.valueOf(sertifikatarihi);
           preparedStatement.setString(1, firstName.toString());
           preparedStatement.setString(2, lastName.toString());
           preparedStatement.setString(3, ID.toString());
           preparedStatement.setString(4, password.toString());
           preparedStatement.setString(5, level.toString());
           preparedStatement.setDate(6, db);
           
           preparedStatement.executeUpdate();


           
        }
        
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        finally{
            if(preparedStatement !=null)
               preparedStatement.close();
            
            if(con != null)
               con.close();
        }
           
        
        
    }
    
}
