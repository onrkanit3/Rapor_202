/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;


public class Ekipman {
    private SimpleStringProperty EkipmanNo,Cihaz,KutupMesafesi,MpTasiyiciOrtam,MiknatislamaTeknigi,UVIsikSiddeti,IsikMesafesi;

    public Ekipman(String EkipmanNo, String Cihaz, String KutupMesafesi, String MpTasiyiciOrtam,String MiknatislamaTeknigi, String UVIsikSiddeti,String IsikMesafesi) {
        this.EkipmanNo = new SimpleStringProperty(EkipmanNo);
        this.Cihaz = new SimpleStringProperty(Cihaz);
        this.KutupMesafesi = new SimpleStringProperty(KutupMesafesi);
        this.MpTasiyiciOrtam = new SimpleStringProperty(MpTasiyiciOrtam);
        this.MiknatislamaTeknigi= new SimpleStringProperty(MiknatislamaTeknigi);
        this.UVIsikSiddeti=new SimpleStringProperty(UVIsikSiddeti);
        this.IsikMesafesi = new SimpleStringProperty(IsikMesafesi);
        
        
    }
    
    public String getEkipmanNo() {
        return EkipmanNo.get();
    }

    public void setEkipmanNo(String EkipmanNo) {
        this.EkipmanNo = new SimpleStringProperty(EkipmanNo);
    }
    
    public String getCihaz() {
        return Cihaz.get();
    }

    public void setCihaz(String Cihaz) {
        this.Cihaz = new SimpleStringProperty(Cihaz);
    }
    
    public String getKutupMesafesi() {
        return KutupMesafesi.get();
    }

    public void setKutupMesafesi(String KutupMesafesi) {
        this.KutupMesafesi = new SimpleStringProperty(KutupMesafesi);
    }
    
    public String getMpTasiyiciOrtam() {
        return MpTasiyiciOrtam.get();
    }

    public void setMpTasiyiciOrtam(String MpTasiyiciOrtam) {
        this.MpTasiyiciOrtam = new SimpleStringProperty(MpTasiyiciOrtam);
    }
    
    public String getMiknatislamaTeknigi() {
        return MiknatislamaTeknigi.get();
    }

    public void setMiknatislamaTeknigi(String MiknatislamaTeknigi) {
        this.MiknatislamaTeknigi = new SimpleStringProperty(MiknatislamaTeknigi);
    }
    
    public String getUVIsikSiddeti() {
        return UVIsikSiddeti.get();
    }

    public void setUVIsikSiddeti(String UVIsikSiddeti) {
        this.UVIsikSiddeti = new SimpleStringProperty(UVIsikSiddeti);
    }
    
    public String getIsikMesafesi() {
        return IsikMesafesi.get();
    }

    public void setIsikMesafesi(String IsikMesafesi) {
        this.IsikMesafesi = new SimpleStringProperty(IsikMesafesi);
    }
    
    public String toString(){
        return String.format("%s %s %s %s %s %s &s", EkipmanNo,Cihaz,KutupMesafesi,MpTasiyiciOrtam,MiknatislamaTeknigi,UVIsikSiddeti,IsikMesafesi);
    }
    
    
}
