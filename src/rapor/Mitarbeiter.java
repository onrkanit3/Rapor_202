/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import javafx.beans.property.SimpleStringProperty;


public class Mitarbeiter {
    private SimpleStringProperty ID,password,level;
    private SimpleStringProperty firstName, lastName;

    public Mitarbeiter(String firstName, String lastName, String ID, String password,String level) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.ID = new SimpleStringProperty(ID);
        this.password = new SimpleStringProperty(password);
        this.level=new SimpleStringProperty(level);
        
        
    }

   
     public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID.get();
    }

    public void setID(SimpleStringProperty ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }
    
    public String getLevel(){
        return level.get();
    }
    
    public void setLevel(SimpleStringProperty level){
        this.level= level;
    }
    public String toString(){
        return String.format("%s %s %s %s %s", firstName,lastName,ID,password,level);
    }
    
}
