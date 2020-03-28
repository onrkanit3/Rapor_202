/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import javafx.beans.property.SimpleStringProperty;


public class Firma {
    private SimpleStringProperty MusteriIsmi, Il, Ilce, IsEmriNumarasi, TeklifNo;
    

    public Firma(String MusteriIsmi, String Il, String Ilce, String IsEmriNumarasi, String TeklifNo) {
        this.MusteriIsmi = new SimpleStringProperty(MusteriIsmi);
        this.Il = new SimpleStringProperty(Il);
        this.Ilce= new SimpleStringProperty(Ilce);
        this.IsEmriNumarasi= new SimpleStringProperty(IsEmriNumarasi);
        this.TeklifNo= new SimpleStringProperty(TeklifNo);
        
        
        
    }
    
    public String getMusteriIsmi() {
        return MusteriIsmi.get();
    }

    public void setMusteriIsmi(String MusteriIsmi) {
        this.MusteriIsmi = new SimpleStringProperty(MusteriIsmi);
    }
    
    public String getIl() {
        return Il.get();
    }

    public void setIl(String Il) {
        this.Il = new SimpleStringProperty(Il);
    }
    
    public String getIlce() {
        return Ilce.get();
    }

    public void setIlce(String Ilce) {
        this.Ilce = new SimpleStringProperty(Ilce);
    }
    
    public String getIsEmriNumarasi() {
        return IsEmriNumarasi.get();
    }

    public void setIsEmriNumarasi(String IsEmriNumarasi) {
        this.IsEmriNumarasi = new SimpleStringProperty(IsEmriNumarasi);
    }
    
    public String getTeklifNo() {
        return TeklifNo.get();
    }

    public void setTeklifNo(String TeklifNo) {
        this.TeklifNo = new SimpleStringProperty(TeklifNo);
    }
    
    public String toString(){
        return String.format("%s %s %s %s %s", MusteriIsmi,Il,Ilce,IsEmriNumarasi,TeklifNo);
    }
}
