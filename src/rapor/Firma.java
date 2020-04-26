/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;



public class Firma
{
    private String MusteriIsmi, Il, Ilce, IsEmriNumarasi, TeklifNo;
    

    public Firma(String MusteriIsmi, String Il, String Ilce, String IsEmriNumarasi, String TeklifNo) 
    {
        setMusteriIsmi (MusteriIsmi);
        setIl(Il);
        setIlce(Ilce);
        IsEmriNumarasi=(IsEmriNumarasi);
        setTeklifNo(TeklifNo);
        
        
        
    }
    
    public String getMusteriIsmi() {
        return MusteriIsmi;
    }

    public void setMusteriIsmi(String MusteriIsmi) {
        this.MusteriIsmi =MusteriIsmi;
    }
    
    public String getIl() {
        return Il;
    }

    public void setIl(String Il) {
        this.Il =Il;
    }
    
    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String Ilce) {
        this.Ilce = Ilce;
    }
    
    public String getIsEmriNumarasi() {
        return IsEmriNumarasi;
    }

    public void setIsEmriNumarasi(String IsEmriNumarasi) {
        this.IsEmriNumarasi = IsEmriNumarasi;
    }
    
    public String getTeklifNo() {
        return TeklifNo;
    }

    public void setTeklifNo(String TeklifNo) {
        this.TeklifNo = TeklifNo;
    }
    
    public String toString(){
        return String.format("%s %s %s %s %s", MusteriIsmi,Il,Ilce,IsEmriNumarasi,TeklifNo);
    }
}
