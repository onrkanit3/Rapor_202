/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import javafx.beans.property.SimpleStringProperty;


public class Proje {
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
}
