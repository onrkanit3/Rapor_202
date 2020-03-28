/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

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
    
}
