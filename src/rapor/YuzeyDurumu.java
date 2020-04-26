/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;



public class YuzeyDurumu {
    private String YuzeyDurumNumarasi,YuzeyDurumu;
    

    public YuzeyDurumu(String YuzeyDurumNumarasi, String YuzeyDurumu) {
        this.YuzeyDurumNumarasi = YuzeyDurumNumarasi;
        this.YuzeyDurumu = YuzeyDurumu;
        
        
        
    }
    
     public String getYuzeyDurumNumarasi() {
        return YuzeyDurumNumarasi;
    }

    public void setYuzeyDurumNumarasi(String YuzeyDurumNumarasi) {
        this.YuzeyDurumNumarasi = YuzeyDurumNumarasi;
    }
    
     public String getYuzeyDurumu() {
        return YuzeyDurumu;
    }
     
    public void setYuzeyDurumu(String YuzeyDurumu) {
        this.YuzeyDurumu = YuzeyDurumu;
    }
    
    public String toString(){
        return String.format("%s %s", YuzeyDurumNumarasi,YuzeyDurumu);
    }
}
