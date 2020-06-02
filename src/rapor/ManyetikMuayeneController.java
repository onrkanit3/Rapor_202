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
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.PropertyTemplate;



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
         
        try(OutputStream fileOut = new FileOutputStream("C:\\Users\\izmir\\OneDrive\\Masaüstü\\Excel\\Javapoint.xls")) { 
            Workbook wb = new HSSFWorkbook();  
             Sheet sheet = wb.createSheet("Sheet"); 
             //STYLE 1
             CellStyle style = wb.createCellStyle(); // Creating Style  
             style.setBorderLeft(BorderStyle.THICK);  
             style.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style.setBorderRight(BorderStyle.THICK);  
             style.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style.setBorderBottom(BorderStyle.THICK);  
             style.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style.setBorderTop(BorderStyle.THICK);  
             style.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font = wb.createFont();  
             font.setFontHeightInPoints((short)14);  
             font.setFontName("Arial");
             style.setAlignment(HorizontalAlignment.CENTER);
             style.setFont(font);
             style.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
             
             //STYLE 2 14'le kırmızı yazar.
             
             CellStyle style2 = wb.createCellStyle(); // Creating Style  
             style2.setBorderLeft(BorderStyle.THICK);  
             style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style2.setBorderRight(BorderStyle.THICK);  
             style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style2.setBorderBottom(BorderStyle.THICK);  
             style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style2.setBorderTop(BorderStyle.THICK);  
             style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font2 = wb.createFont();  
             font2.setFontHeightInPoints((short)14);  
             font2.setFontName("Arial");
             font2.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
             font2.setBold(true);
             style2.setAlignment(HorizontalAlignment.CENTER);
             style2.setFont(font2);
             style2.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
             
             //STYLE 3 14'le ince siyah yazar. Üstü çizmez
             CellStyle style3 = wb.createCellStyle(); // Creating Style  
             style3.setBorderLeft(BorderStyle.THICK);  
             style3.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style3.setBorderRight(BorderStyle.THICK);  
             style3.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style3.setBorderBottom(BorderStyle.THICK);  
             style3.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             Font font3 = wb.createFont();  
             font3.setFontHeightInPoints((short)14);  
             font3.setFontName("Arial");
             style3.setAlignment(HorizontalAlignment.CENTER);
             style3.setFont(font3);
             style3.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style3.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
             
             //STYLE 4 kalın 18 yazar. Altı çizmez
             CellStyle style4 = wb.createCellStyle(); // Creating Style  
             style4.setBorderLeft(BorderStyle.THICK);  
             style4.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style4.setBorderRight(BorderStyle.THICK);  
             style4.setRightBorderColor(IndexedColors.BLACK.getIndex()); 
             style4.setBorderTop(BorderStyle.THICK);  
             style4.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font4 = wb.createFont();  
             font4.setFontHeightInPoints((short)18);  
             font4.setBold(true);
             font4.setFontName("Arial");
             style4.setAlignment(HorizontalAlignment.CENTER);
             style4.setFont(font4);
             style4.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style4.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
             
             //STYLE 5 //7.5 Kalın Siyah yazar altı boyamaz
             CellStyle style5 = wb.createCellStyle(); // Creating Style  
             style5.setBorderLeft(BorderStyle.THICK);  
             style5.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style5.setBorderRight(BorderStyle.THICK);  
             style5.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style5.setBorderTop(BorderStyle.THICK);  
             style5.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font5 = wb.createFont();  
             font5.setFontHeightInPoints((short)7.5);  
             font5.setFontName("Arial");
             font5.setBold(true);
             style5.setFont(font5);
             style5.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style5.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
             
             //STYLE 6 //7.5 İnce italic Siyah yazar üstü boyamaz
             CellStyle style6 = wb.createCellStyle(); // Creating Style  
             style6.setBorderLeft(BorderStyle.THICK);  
             style6.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style6.setBorderRight(BorderStyle.THICK);  
             style6.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style6.setBorderBottom(BorderStyle.THICK);  
             style6.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             Font font6 = wb.createFont();  
             font6.setFontHeightInPoints((short)7.5);  
             font6.setFontName("Arial");
             font6.setItalic(true);
             style6.setFont(font6);
             style6.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style6.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
             
             //STYLE 7 //8 Kalın Siyah yazar beyaza boyar.
             CellStyle style7 = wb.createCellStyle(); // Creating Style  
             style7.setBorderLeft(BorderStyle.THICK);  
             style7.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style7.setBorderRight(BorderStyle.THICK);  
             style7.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style7.setBorderBottom(BorderStyle.THICK);  
             style7.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style5.setBorderTop(BorderStyle.THICK);  
             style5.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font7 = wb.createFont();  
             style7.setAlignment(HorizontalAlignment.CENTER);
             style7.setVerticalAlignment(VerticalAlignment.CENTER);
             font7.setFontHeightInPoints((short)8);  
             font7.setFontName("Arial");
             font7.setBold(true);
             style7.setFont(font7);
             

             Row row= sheet.createRow(0);
             
              org.apache.poi.ss.usermodel.Cell cell;
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style);
             }
             
             
            
             
               
             
             //Buraya resim konacak.
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
            Drawing drawing = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();
            //set top-left corner for the image
            anchor.setCol1(1);
            anchor.setRow1(0);

            //Creates a picture
            Picture pict = drawing.createPicture(anchor, pictureIdx);
            //Reset the image to the original size
            pict.resize(3.05,6.27);
            
            sheet.addMergedRegion(new CellRangeAddress(0,6,0,4));
            
              
             
             //Gözetim Muayene yazısı
             
             
             
              
             cell =  row.createCell(5); 
             
             
             
             
             cell.setCellValue("GÖZETİM MUAYENE VE EĞİTİM HİZMETLERİ");  
             sheet.addMergedRegion(new CellRangeAddress(0,2,5,20));

             cell.setCellStyle(style2);
             row= sheet.createRow(1);
             
             
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style2);
             }
             
             row= sheet.createRow(2);
             
             
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style);
             }
              
             
                    
             
             
             
             row= sheet.createRow(3);
             
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style);
             }
             cell =  row.createCell(5); 
             
             cell.setCellValue("MANYETİK PARÇACIK MUAYENE RAPORU");  
             sheet.addMergedRegion(new CellRangeAddress(3,4,5,20));  
             cell.setCellStyle(style4);
             
             
             
              
             
             
             
             row= sheet.createRow(4);
             
             
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style4);
             }
             
            row= sheet.createRow(5);
             
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style3);
             }
             cell =  row.createCell(5); 
             
             cell.setCellValue("MAGNETIC PARTICLE INSPECTION REPORT");  
             sheet.addMergedRegion(new CellRangeAddress(5,6,5,20));  
             cell.setCellStyle(style3);
             
             row= sheet.createRow(6);
             
             
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style);
             }
           
            
             //Müşteri kısmı pembe
             row= sheet.createRow(7);
             
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Müşteri");  
             sheet.addMergedRegion(new CellRangeAddress(7,7,0,1));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(2); 
             
             cell.setCellValue((String)Musteri.getSelectionModel().getSelectedItem());  
             sheet.addMergedRegion(new CellRangeAddress(7,8,2,9));  
             cell.setCellStyle(style7);
             
             //Muayene Prosedürü pembe 
             for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Muayene Prosedürü");  
             sheet.addMergedRegion(new CellRangeAddress(7,7,10,12));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(13); 
             
             cell.setCellValue(MuayeneProseduru.getText());  
             sheet.addMergedRegion(new CellRangeAddress(7,8,13,15));  
             cell.setCellStyle(style7);
             
             
             
             //Sayfa No Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Sayfa No");  
             sheet.addMergedRegion(new CellRangeAddress(7,7,16,18));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(19); 
             
             cell.setCellValue(SayfaNo.getText());  
             sheet.addMergedRegion(new CellRangeAddress(7,8,19,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(8);
             //Customer pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Customer");  
             sheet.addMergedRegion(new CellRangeAddress(8,8,0,1));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Inspection Procedure
              for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Inspection Procedure");  
             sheet.addMergedRegion(new CellRangeAddress(8,8,10,12));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Page No Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Page No");  
             sheet.addMergedRegion(new CellRangeAddress(8,8,16,18));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              
              
              
            
             
            // ------GENİŞLİK AYARLAMA-----
            sheet.setColumnWidth(0,2280);   //A
            sheet.setColumnWidth(1,3120);   //B
            sheet.setColumnWidth(2,270);    //C
            sheet.setColumnWidth(3,1300);   //D
            sheet.setColumnWidth(4,1440);   //E
            sheet.setColumnWidth(5,1050);   //F
            sheet.setColumnWidth(6,2460);   //G
            sheet.setColumnWidth(7,1720);   //H
            sheet.setColumnWidth(8,2180);   //I
            sheet.setColumnWidth(9,2530);   //J
            sheet.setColumnWidth(10,960);   //K
            sheet.setColumnWidth(11,3200);  //L
            sheet.setColumnWidth(12,1465);  //M
            sheet.setColumnWidth(13,1270);  //N
            sheet.setColumnWidth(14,1460);  //O
            sheet.setColumnWidth(15,3200);  //P
            sheet.setColumnWidth(16,910);   //Q
            sheet.setColumnWidth(17,1820);  //R
            sheet.setColumnWidth(18,1550);  //S
            sheet.setColumnWidth(19,2100);  //T
            sheet.setColumnWidth(20,3290);  //U
            
            //
            
             
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
