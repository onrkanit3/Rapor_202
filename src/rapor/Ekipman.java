/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;


public class Ekipman {
    private String EkipmanNo,Cihaz,KutupMesafesi,MpTasiyiciOrtam,MiknatislamaTeknigi,UVIsikSiddeti,IsikMesafesi;

    public Ekipman(String EkipmanNo, String Cihaz, String KutupMesafesi, String MpTasiyiciOrtam,
                   String MiknatislamaTeknigi, String UVIsikSiddeti,String IsikMesafesi)
    {
        setEkipmanNo (EkipmanNo);
        setCihaz(Cihaz);
        setKutupMesafesi (KutupMesafesi);
        setMpTasiyiciOrtam (MpTasiyiciOrtam);
        setMiknatislamaTeknigi(MiknatislamaTeknigi);
        setUVIsikSiddeti(UVIsikSiddeti);
        setIsikMesafesi (IsikMesafesi);
        
        
    }
    
    public String getEkipmanNo()
    {
        return EkipmanNo;
    }

    public void setEkipmanNo(String EkipmanNo) 
    {
        this.EkipmanNo = EkipmanNo;
    }
    
    public String getCihaz() 
    {
        return Cihaz;
    }

    public void setCihaz(String Cihaz) 
    {
        this.Cihaz = Cihaz;
    }
    
    public String getKutupMesafesi() 
    {
        return KutupMesafesi;
    }

    public void setKutupMesafesi(String KutupMesafesi) 
    {
        this.KutupMesafesi = KutupMesafesi;
    }
    
    public String getMpTasiyiciOrtam() 
    {
        return MpTasiyiciOrtam;
    }

    public void setMpTasiyiciOrtam(String MpTasiyiciOrtam) 
    {
        this.MpTasiyiciOrtam = MpTasiyiciOrtam;
    }
    
    public String getMiknatislamaTeknigi() 
    {
        return MiknatislamaTeknigi;
    }

    public void setMiknatislamaTeknigi(String MiknatislamaTeknigi) 
    {
        this.MiknatislamaTeknigi = MiknatislamaTeknigi;
    }
    
    public String getUVIsikSiddeti() 
    {
        return UVIsikSiddeti;
    }

    public void setUVIsikSiddeti(String UVIsikSiddeti) 
    {
        this.UVIsikSiddeti = UVIsikSiddeti;
    }
    
    public String getIsikMesafesi() 
    {
        return IsikMesafesi;
    }

    public void setIsikMesafesi(String IsikMesafesi) 
    {
        this.IsikMesafesi = IsikMesafesi;
    }
    
    public String toString()
    {
        return String.format("%s %s %s %s %s %s &s", EkipmanNo,Cihaz,KutupMesafesi,MpTasiyiciOrtam,MiknatislamaTeknigi,UVIsikSiddeti,IsikMesafesi);
    }
    
    
}
