/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ManyetikMuayeneController implements Initializable 
{
    @FXML private ChoiceBox Musteri;
    @FXML private ChoiceBox ProjeAdi;
    @FXML private TextField TestYeri;
    @FXML private TextField MuayeneStandardi;
    @FXML private TextField EvaluationStandard;
    @FXML private TextField MuayeneProseduru;
    @FXML private TextField MuayeneKapsami;
    @FXML private TextField ResimNo;
    @FXML private ChoiceBox YuzeyDurumu;
    @FXML private ChoiceBox MuayeneAsamasi;
    @FXML private TextField SayfaNo;
    @FXML private TextField RaporNo;
    @FXML private TextField RaporTarihi;
    @FXML private ChoiceBox IsEmriNo;
    @FXML private ChoiceBox TeklifNo;
    @FXML private TextField KutupMesafesi;
    @FXML private TextField Cihaz;
    @FXML private TextField MpTasiyiciOrtam;
    @FXML private TextField MiknatislamaTeknigi;
    @FXML private TextField UVIsıkSiddeti;
    @FXML private TextField IsikMesafesi;
    @FXML private TextField MuayeneBolgesi;
    @FXML private TextField AkimTipi;
    @FXML private TextField Luxmetre;
    @FXML private TextField MuayeneOrtami;
    @FXML private TextField MiknatisGiderimi;
    @FXML private TextField IsilIslem;
    @FXML private TextField YuzeySicakligi;
    @FXML private TextField MuayeneBolgesiAlanSiddeti;
    @FXML private TextField Yuzey;
    @FXML private TextField IsikCihaziTanimi;
    @FXML private TextField KaldirmaTestiTarih;
    @FXML private ImageView AlinKaynagi;
    @FXML private RadioButton AlinKaynagiRadio;
    @FXML private ImageView KoseKaynagi;
    @FXML private RadioButton KoseKaynagiRadio;
    @FXML private TextField StandartSapmalar;
    @FXML private TextField MuayeneTarihleri;
    @FXML private TextField AciklamalarVeEkler;
    @FXML private TextField SiraNo1;
    @FXML private TextField SiraNo2;
    @FXML private TextField SiraNo3;
    @FXML private TextField SiraNo4;
    @FXML private TextField SiraNo5;
    @FXML private TextField SiraNo6;
    @FXML private TextField KaynakParcaNo1;
    @FXML private TextField KaynakParcaNo2;
    @FXML private TextField KaynakParcaNo3;
    @FXML private TextField KaynakParcaNo4;
    @FXML private TextField KaynakParcaNo5;
    @FXML private TextField KaynakParcaNo6;
    @FXML private TextField KontrolUzun1;
    @FXML private TextField KontrolUzun2;
    @FXML private TextField KontrolUzun3;
    @FXML private TextField KontrolUzun4;
    @FXML private TextField KontrolUzun5;
    @FXML private TextField KontrolUzun6;
    @FXML private TextField KaynakYon1;
    @FXML private TextField KaynakYon2;
    @FXML private TextField KaynakYon3;
    @FXML private TextField KaynakYon4;
    @FXML private TextField KaynakYon5;
    @FXML private TextField KaynakYon6;
    @FXML private TextField Kalinlik1;
    @FXML private TextField Kalinlik2;
    @FXML private TextField Kalinlik3;
    @FXML private TextField Kalinlik4;
    @FXML private TextField Kalinlik5;
    @FXML private TextField Kalinlik6;
    @FXML private TextField Cap1;
    @FXML private TextField Cap2;
    @FXML private TextField Cap3;
    @FXML private TextField Cap4;
    @FXML private TextField Cap5;
    @FXML private TextField Cap6;
    @FXML private TextField HataTipi1;
    @FXML private TextField HataTipi2;
    @FXML private TextField HataTipi3;
    @FXML private TextField HataTipi4;
    @FXML private TextField HataTipi5;
    @FXML private TextField HataTipi6;
    @FXML private TextField HataninYeri1;
    @FXML private TextField HataninYeri2;
    @FXML private TextField HataninYeri3;
    @FXML private TextField HataninYeri4;
    @FXML private TextField HataninYeri5;
    @FXML private TextField HataninYeri6;
    @FXML private TextField Sonuc1;
    @FXML private TextField Sonuc2;
    @FXML private TextField Sonuc3;
    @FXML private TextField Sonuc4;
    @FXML private TextField Sonuc5;
    @FXML private TextField Sonuc6;
    @FXML private TextField OperatorAdSoyad;
    @FXML private TextField DegerlendirenAdSoyad;
    @FXML private TextField OnayAdSoyad;
    @FXML private TextField MusteriAdSoyad;
    @FXML private TextField OperatorLevel;
    @FXML private TextField DegerlendirenLevel;
    @FXML private TextField OnayLevel;
    @FXML private TextField MusteriLevel;
    @FXML private TextField OperatorTarih;
    @FXML private TextField DegerlendierenTarih;
    @FXML private TextField OnayTarih;
    @FXML private TextField MusteriTarih;
    @FXML private TextField OperatorImza;
    @FXML private TextField DegerlendirenImza;
    @FXML private TextField OnayImza;
    @FXML private TextField MusteriImza;
    @FXML private ImageView Logo;
    
    
    
    
    

    

    
    public void giriseDon(ActionEvent event) throws IOException
    {
        Parent RaporGirisParent = FXMLLoader.load(getClass().getResource("RaporGiris.fxml"));
        Scene RaporGirisScene = new Scene(RaporGirisParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RaporGirisScene);
        window.show();
    }
    
    public void Workbook() throws FileNotFoundException, IOException
     {
     Workbook wb = new HSSFWorkbook();  
        try(OutputStream fileOut = new FileOutputStream("C:\\Users\\izmir\\OneDrive\\Masaüstü\\Excel\\Javapoint.xls")) {  
            Sheet sheet1 = wb.createSheet("First Sheet");
            //FileInputStream obtains input bytes from the image file
            InputStream inputStream = new FileInputStream("C:\\Users\\izmir\\OneDrive\\Documents\\NetBeansProjects\\Rapor\\src\\rapor\\Icons\\eye-insurance.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes = IOUtils.toByteArray(inputStream);
            //Adds a picture to the workbook
            int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing = sheet1.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();
            //set top-left corner for the image
            anchor.setCol1(1);
            anchor.setRow1(2);

            //Creates a picture
            Picture pict = drawing.createPicture(anchor, pictureIdx);
            //Reset the image to the original size
            pict.resize(2.0,7.0);
             
            
            wb.write(fileOut);  
        }catch(Exception e) {  
            System.out.println(e.getMessage());  
        }  
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
