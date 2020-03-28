/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;


public class YuzeyDurumu {
    private SimpleStringProperty YuzeyDurumNumarasi,YuzeyDurumu;
    

    public YuzeyDurumu(String YuzeyDurumNumarasi, String YuzeyDurumu) {
        this.YuzeyDurumNumarasi = new SimpleStringProperty(YuzeyDurumNumarasi);
        this.YuzeyDurumu = new SimpleStringProperty(YuzeyDurumu);
        
        
        
    }
    
     public String getYuzeyDurumNumarasi() {
        return YuzeyDurumNumarasi.get();
    }

    public void setYuzeyDurumNumarasi(String YuzeyDurumNumarasi) {
        this.YuzeyDurumNumarasi = new SimpleStringProperty(YuzeyDurumNumarasi);
    }
    
     public String getYuzeyDurumu() {
        return YuzeyDurumu.get();
    }
     
    public void setYuzeyDurumu(String YuzeyDurumu) {
        this.YuzeyDurumu = new SimpleStringProperty(YuzeyDurumu);
    }
    
    public String toString(){
        return String.format("%s %s", YuzeyDurumNumarasi,YuzeyDurumu);
    }
}
