/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import javafx.beans.property.SimpleStringProperty;


public class Proje {
    private SimpleStringProperty ProjeNumarasi,ProjeAdi;
    

    public Proje(String ProjeNumarasi, String ProjeAdi) {
        this.ProjeNumarasi = new SimpleStringProperty(ProjeNumarasi);
        this.ProjeAdi = new SimpleStringProperty(ProjeAdi);
        
        
        
        
    }
    
    public String getProjeNumarasi() {
        return ProjeNumarasi.get();
    }

    public void setProjeNumarasi(String ProjeNumarasi) {
        this.ProjeNumarasi = new SimpleStringProperty(ProjeNumarasi);
    }
    
    public String getProjeAdi() {
        return ProjeAdi.get();
    }

    public void setProjeAdi(String ProjeAdi) {
        this.ProjeAdi = new SimpleStringProperty(ProjeAdi);
    }
    
    public String toString(){
        return String.format("%s %s", ProjeNumarasi,ProjeAdi);
    }
}
