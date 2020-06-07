/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
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



public class ManyetikMuayeneController implements Initializable 
{   
    @FXML private AnchorPane ManyetikMuayene;
    @FXML private ScrollPane ManMuayene;
    @FXML private VBox MMuayene;
    @FXML private Button PDF;
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
    @FXML private TextField SiraNo7;
    @FXML private TextField SiraNo8;
    @FXML private TextField SiraNo9;
    @FXML private TextField SiraNo10;
    @FXML private TextField KaynakParcaNo1;
    @FXML private TextField KaynakParcaNo2;
    @FXML private TextField KaynakParcaNo3;
    @FXML private TextField KaynakParcaNo4;
    @FXML private TextField KaynakParcaNo5;
    @FXML private TextField KaynakParcaNo6;
    @FXML private TextField KaynakParcaNo7;
    @FXML private TextField KaynakParcaNo8;
    @FXML private TextField KaynakParcaNo9;
    @FXML private TextField KaynakParcaNo10;
    @FXML private TextField KontrolUzun1;
    @FXML private TextField KontrolUzun2;
    @FXML private TextField KontrolUzun3;
    @FXML private TextField KontrolUzun4;
    @FXML private TextField KontrolUzun5;
    @FXML private TextField KontrolUzun6;
    @FXML private TextField KontrolUzun7;
    @FXML private TextField KontrolUzun8;
    @FXML private TextField KontrolUzun9;
    @FXML private TextField KontrolUzun10;
    @FXML private TextField KaynakYon1;
    @FXML private TextField KaynakYon2;
    @FXML private TextField KaynakYon3;
    @FXML private TextField KaynakYon4;
    @FXML private TextField KaynakYon5;
    @FXML private TextField KaynakYon6;
    @FXML private TextField KaynakYon7;
    @FXML private TextField KaynakYon8;
    @FXML private TextField KaynakYon9;
    @FXML private TextField KaynakYon10;
    @FXML private TextField Kalinlik1;
    @FXML private TextField Kalinlik2;
    @FXML private TextField Kalinlik3;
    @FXML private TextField Kalinlik4;
    @FXML private TextField Kalinlik5;
    @FXML private TextField Kalinlik6;
    @FXML private TextField Kalinlik7;
    @FXML private TextField Kalinlik8;
    @FXML private TextField Kalinlik9;
    @FXML private TextField Kalinlik10;
    @FXML private TextField Cap1;
    @FXML private TextField Cap2;
    @FXML private TextField Cap3;
    @FXML private TextField Cap4;
    @FXML private TextField Cap5;
    @FXML private TextField Cap6;
    @FXML private TextField Cap7;
    @FXML private TextField Cap8;
    @FXML private TextField Cap9;
    @FXML private TextField Cap10;
    @FXML private TextField HataTipi1;
    @FXML private TextField HataTipi2;
    @FXML private TextField HataTipi3;
    @FXML private TextField HataTipi4;
    @FXML private TextField HataTipi5;
    @FXML private TextField HataTipi6;
    @FXML private TextField HataTipi7;
    @FXML private TextField HataTipi8;
    @FXML private TextField HataTipi9;
    @FXML private TextField HataTipi10;
    @FXML private TextField HataninYeri1;
    @FXML private TextField HataninYeri2;
    @FXML private TextField HataninYeri3;
    @FXML private TextField HataninYeri4;
    @FXML private TextField HataninYeri5;
    @FXML private TextField HataninYeri6;
    @FXML private TextField HataninYeri7;
    @FXML private TextField HataninYeri8;
    @FXML private TextField HataninYeri9;
    @FXML private TextField HataninYeri10;
    @FXML private TextField Sonuc1;
    @FXML private TextField Sonuc2;
    @FXML private TextField Sonuc3;
    @FXML private TextField Sonuc4;
    @FXML private TextField Sonuc5;
    @FXML private TextField Sonuc6;
    @FXML private TextField Sonuc7;
    @FXML private TextField Sonuc8;
    @FXML private TextField Sonuc9;
    @FXML private TextField Sonuc10;
    @FXML private TextField OperatorAdSoyad;
    @FXML private TextField DegerlendirenAdSoyad;
    @FXML private TextField OnayAdSoyad;
    @FXML private TextField MusteriAdSoyad;
    @FXML private TextField OperatorLevel;
    @FXML private TextField DegerlendirenLevel;
    @FXML private TextField OnayLevel;
    @FXML private TextField MusteriLevel;
    @FXML private TextField OperatorTarih;
    @FXML private TextField DegerlendirenTarih;
    @FXML private TextField OnayTarih;
    @FXML private TextField MusteriTarih;
    @FXML private TextField OperatorImza;
    @FXML private TextField DegerlendirenImza;
    @FXML private TextField OnayImza;
    @FXML private TextField MusteriImza;
    @FXML private ImageView Logo;
    
    
   @FXML
    public void toPDF(ActionEvent event) {
        
            VBox root = new VBox();
            root=MMuayene;
        
            try {
                WritableImage nodeshot = root.snapshot(new SnapshotParameters(), null);

                // store image in-memory
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", output);
                output.close();

                PDDocument doc = new PDDocument();
                PDPage page = new PDPage();
                PDImageXObject pdimage;
                PDPageContentStream content;

                pdimage = PDImageXObject.createFromByteArray(doc, output.toByteArray(), "png");
                content = new PDPageContentStream(doc, page);
          
                // fit image to media box of page
               PDRectangle box = page.getMediaBox();
                double factor = Math.max(box.getWidth() / nodeshot.getWidth(), box.getHeight() / nodeshot.getHeight());
                
                float height = (float) (nodeshot.getHeight() * factor);
                

                // beware of inverted y axis here
                content.drawImage(pdimage, 0, (float)-200.6146,  612, 1031);
                
                
                content.close();
                doc.addPage(page);

                File outputFile = new File("C:\\Users\\izmir\\OneDrive\\Masaüstü\\PDF\\PDFNode.pdf");

                doc.save(outputFile);
                doc.close();

                
            } catch (Exception e) {
            }

        
    } 
    
    

   

    
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
             
             //STYLE 8 //9 İnce  Siyah yazar pembe boyar. Solu borderlamaz.
             CellStyle style8 = wb.createCellStyle(); // Creating Style  
             style8.setBorderRight(BorderStyle.THICK);  
             style8.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style8.setBorderBottom(BorderStyle.THICK);  
             style8.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style8.setBorderTop(BorderStyle.THICK);  
             style8.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
             Font font8 = wb.createFont();  
             font8.setFontHeightInPoints((short)9);  
             style8.setAlignment(HorizontalAlignment.LEFT);
             style8.setVerticalAlignment(VerticalAlignment.CENTER);
             font8.setFontName("Arial");
             style8.setFont(font8);
             style8.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style8.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
             
             //STYLE 9 //9 Kalın Siyah yazar pembeye boyar. Sağı borderlamaz
             CellStyle style9 = wb.createCellStyle(); // Creating Style  
             style9.setBorderLeft(BorderStyle.THICK);  
             style9.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style9.setBorderBottom(BorderStyle.THICK);  
             style9.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style9.setBorderTop(BorderStyle.THICK);  
             style9.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font9 = wb.createFont();  
             style9.setAlignment(HorizontalAlignment.RIGHT);
             style9.setVerticalAlignment(VerticalAlignment.CENTER);
             font9.setFontHeightInPoints((short)9);  
             font9.setFontName("Arial");
             font9.setBold(true);
             style9.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style9.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             style9.setFont(font9);
             
             //STYLE 10 //7.5 Kalın Siyah yazar altı boyamaz alta inmeli wrap
             CellStyle style10 = wb.createCellStyle(); // Creating Style  
             style10.setBorderLeft(BorderStyle.THICK);  
             style10.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style10.setBorderRight(BorderStyle.THICK);  
             style10.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style10.setBorderTop(BorderStyle.THICK);  
             style10.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font10 = wb.createFont();  
             font10.setFontHeightInPoints((short)7.5);  
             font10.setFontName("Arial");
             font10.setBold(true);
             style10.setWrapText(true);
             style10.setFont(font10);
             style10.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style10.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             
             //STYLE 11 //7.5 İnce italic Siyah yazar üstü boyamaz altı boyamaz
             CellStyle style11 = wb.createCellStyle(); // Creating Style  
             style11.setBorderLeft(BorderStyle.THICK);  
             style11.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style11.setBorderRight(BorderStyle.THICK);  
             style11.setRightBorderColor(IndexedColors.BLACK.getIndex());
             Font font11 = wb.createFont();  
             font11.setFontHeightInPoints((short)7.5);  
             font11.setFontName("Arial");
             font11.setItalic(true);
             style11.setFont(font11);
             style11.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style11.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
             
             //STYLE 12 //8 Kalın Siyah yazar beyaza boyar altı borderlamaz.
             CellStyle style12 = wb.createCellStyle(); // Creating Style  
             style12.setBorderLeft(BorderStyle.THICK);  
             style12.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style12.setBorderRight(BorderStyle.THICK);  
             style12.setRightBorderColor(IndexedColors.BLACK.getIndex()); 
             style12.setBorderTop(BorderStyle.THICK);  
             style12.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font12 = wb.createFont();  
             style12.setAlignment(HorizontalAlignment.CENTER);
             style12.setVerticalAlignment(VerticalAlignment.CENTER);
             font12.setFontHeightInPoints((short)8);  
             font12.setFontName("Arial");
             font12.setBold(true);
             style12.setFont(font12);
             
             //STYLE 13 //8 Kalın Siyah yazar beyaza boyar.
             CellStyle style13 = wb.createCellStyle(); // Creating Style  
             style13.setBorderRight(BorderStyle.THICK);  
             style13.setRightBorderColor(IndexedColors.BLACK.getIndex());
             Font font13 = wb.createFont();  
             style13.setAlignment(HorizontalAlignment.CENTER);
             style13.setVerticalAlignment(VerticalAlignment.CENTER);
             font13.setFontHeightInPoints((short)8);  
             font13.setFontName("Arial");
             font13.setBold(true);
             style13.setFont(font7);
             
             //STYLE 14 //7.5 Kalın Siyah yazar pembeye boyar. Sağı borderlamaz
             CellStyle style14 = wb.createCellStyle(); // Creating Style  
             style14.setBorderLeft(BorderStyle.THICK);  
             style14.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style14.setBorderBottom(BorderStyle.THICK);  
             style14.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style14.setBorderTop(BorderStyle.THICK);  
             style14.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font14 = wb.createFont();  
             style14.setAlignment(HorizontalAlignment.RIGHT);
             style14.setVerticalAlignment(VerticalAlignment.CENTER);
             font14.setFontHeightInPoints((short)7.5);  
             font14.setFontName("Arial");
             font14.setBold(true);
             style14.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style14.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             style14.setFont(font14);
             
             //STYLE 15 //7.5 İnce  Siyah yazar pembe boyar. Solu borderlamaz.
             CellStyle style15 = wb.createCellStyle(); // Creating Style  
             style15.setBorderRight(BorderStyle.THICK);  
             style15.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style15.setBorderBottom(BorderStyle.THICK);  
             style15.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style15.setBorderTop(BorderStyle.THICK);  
             style15.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
             Font font15 = wb.createFont();  
             font15.setFontHeightInPoints((short)7.5);  
             style15.setAlignment(HorizontalAlignment.LEFT);
             style15.setVerticalAlignment(VerticalAlignment.CENTER);
             font15.setFontName("Arial");
             style15.setFont(font15);
             style15.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style15.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             
            //STYLE 16 //7.5 Kalın Siyah yazar pembeye boyar. Solu borderlamaz. Ortalar
             CellStyle style16 = wb.createCellStyle(); // Creating Style    
             style16.setBorderBottom(BorderStyle.THICK);  
             style16.setBottomBorderColor(IndexedColors.BLACK.getIndex());
             style16.setBorderRight(BorderStyle.THICK);  
             style16.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style16.setBorderTop(BorderStyle.THICK);  
             style16.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font16 = wb.createFont();  
             style16.setAlignment(HorizontalAlignment.CENTER);
             style16.setVerticalAlignment(VerticalAlignment.CENTER);
             font16.setFontHeightInPoints((short)7.5);  
             font16.setFontName("Arial");
             font16.setBold(true);
             style16.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style16.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             style16.setFont(font16); 
             
             //STYLE 17 //7.5 İnce  Siyah yazar pembe boyar. Sağı ve solu borderlamaz.
             CellStyle style17 = wb.createCellStyle(); // Creating Style  
             style17.setBorderBottom(BorderStyle.THICK);  
             style17.setBottomBorderColor(IndexedColors.BLACK.getIndex());
             style17.setBorderTop(BorderStyle.THICK);  
             style17.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
             Font font17 = wb.createFont();  
             font17.setFontHeightInPoints((short)7.5);  
             style17.setAlignment(HorizontalAlignment.LEFT);
             style17.setVerticalAlignment(VerticalAlignment.CENTER);
             font17.setFontName("Arial");
             style17.setFont(font17);
             style17.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style17.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             
             
             //STYLE 18 //7.5 Kalın Siyah yazar pembeye boyar. Sağı borderlamaz. Sola yaslanır
             CellStyle style18 = wb.createCellStyle(); // Creating Style  
             style18.setBorderLeft(BorderStyle.THICK);  
             style18.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style18.setBorderBottom(BorderStyle.THICK);  
             style18.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style18.setBorderTop(BorderStyle.THICK);  
             style18.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font18 = wb.createFont();  
             style18.setAlignment(HorizontalAlignment.CENTER);
             style18.setVerticalAlignment(VerticalAlignment.CENTER);
             font18.setFontHeightInPoints((short)7.5);  
             font18.setFontName("Arial");
             font18.setBold(true);
             style18.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style18.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             style18.setFont(font18);
             
             //STYLE 19 //8 Kalın Siyah yazar altı boyamaz
             CellStyle style19 = wb.createCellStyle(); // Creating Style  
             style19.setBorderLeft(BorderStyle.THICK);  
             style19.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style19.setBorderRight(BorderStyle.THICK);  
             style19.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style19.setBorderTop(BorderStyle.THICK);  
             style19.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font19 = wb.createFont(); 
             style19.setVerticalAlignment(VerticalAlignment.CENTER);
             font19.setFontHeightInPoints((short)8);  
             font19.setFontName("Arial");
             font19.setBold(true);
             style19.setFont(font19);
             style19.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style19.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
             
             //STYLE 20 //8 Kalın Siyah yazar beyaza boyar.
             CellStyle style20 = wb.createCellStyle(); // Creating Style  
             style20.setBorderLeft(BorderStyle.THICK);  
             style20.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style20.setBorderRight(BorderStyle.THICK);  
             style20.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style20.setBorderBottom(BorderStyle.THICK);  
             style20.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style20.setBorderTop(BorderStyle.THICK);  
             style20.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font20 = wb.createFont();  
             style20.setAlignment(HorizontalAlignment.LEFT);
             style20.setVerticalAlignment(VerticalAlignment.CENTER);
             font20.setFontHeightInPoints((short)8);  
             font20.setFontName("Arial");
             font20.setBold(true);
             style20.setFont(font20);
             
             //STYLE 21 //8 Kalın Siyah yazar beyaza boyar.
             CellStyle style21 = wb.createCellStyle(); // Creating Style  
             style21.setBorderLeft(BorderStyle.THICK);  
             style21.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style21.setBorderRight(BorderStyle.THICK);  
             style21.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style21.setBorderBottom(BorderStyle.THICK);  
             style21.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style21.setBorderTop(BorderStyle.THICK);  
             style21.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font21 = wb.createFont();  
             font21.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
             style21.setAlignment(HorizontalAlignment.LEFT);
             style21.setVerticalAlignment(VerticalAlignment.CENTER);
             font21.setFontHeightInPoints((short)8);  
             font21.setFontName("Arial");
             font21.setBold(true);
             style21.setFont(font21);
             
             
             //STYLE 22 //10 Kalın Siyah yazar beyaza boyar.
             CellStyle style22 = wb.createCellStyle(); // Creating Style  
             style22.setBorderLeft(BorderStyle.THICK);  
             style22.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style22.setBorderRight(BorderStyle.THICK);  
             style22.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style22.setBorderBottom(BorderStyle.THICK);  
             style22.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style22.setBorderTop(BorderStyle.THICK);  
             style22.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font22 = wb.createFont();  
             style22.setAlignment(HorizontalAlignment.CENTER);
             style22.setVerticalAlignment(VerticalAlignment.CENTER);
             font22.setFontHeightInPoints((short)10);  
             font22.setFontName("Arial");
             font22.setBold(true);
             style22.setFont(font22);
             
             
             //STYLE 23 //10 İnce Siyah yazar beyaza boyar.
             CellStyle style23 = wb.createCellStyle(); // Creating Style  
             style23.setBorderLeft(BorderStyle.THICK);  
             style23.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style23.setBorderRight(BorderStyle.THICK);  
             style23.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style23.setBorderBottom(BorderStyle.THICK);  
             style23.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style23.setBorderTop(BorderStyle.THICK);  
             style23.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font23 = wb.createFont();  
             style23.setAlignment(HorizontalAlignment.CENTER);
             style23.setVerticalAlignment(VerticalAlignment.CENTER);
             font23.setFontHeightInPoints((short)10);  
             font23.setFontName("Arial");
             style23.setFont(font23);
             
             
             //STYLE 24 //8 İnce Siyah yazar beyaza boyar.
             CellStyle style24 = wb.createCellStyle(); // Creating Style  
             style24.setBorderLeft(BorderStyle.THICK);  
             style24.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style24.setBorderRight(BorderStyle.THICK);  
             style24.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style24.setBorderBottom(BorderStyle.THICK);  
             style24.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style24.setBorderTop(BorderStyle.THICK);  
             style24.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font24 = wb.createFont();  
             style24.setAlignment(HorizontalAlignment.CENTER);
             style24.setVerticalAlignment(VerticalAlignment.CENTER);
             font24.setFontHeightInPoints((short)8);  
             font24.setFontName("Arial");
             style24.setFont(font24);
             
             
             //STYLE 25 //8 Kalın Siyah yazar altı boyamaz ortalar
             CellStyle style25 = wb.createCellStyle(); // Creating Style  
             style25.setBorderLeft(BorderStyle.THICK);  
             style25.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style25.setBorderRight(BorderStyle.THICK);  
             style25.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style25.setBorderTop(BorderStyle.THICK);  
             style25.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font25 = wb.createFont();  
             style25.setAlignment(HorizontalAlignment.CENTER);
             style25.setVerticalAlignment(VerticalAlignment.CENTER);
             font25.setFontHeightInPoints((short)8);  
             font25.setFontName("Arial");
             font25.setBold(true);
             style25.setFont(font25);
             style25.setFillForegroundColor(IndexedColors.ROSE.getIndex());  
             style25.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
             
             
             //STYLE 26 //8 Kalın Siyah yazar beyaza boyar.
             CellStyle style26 = wb.createCellStyle(); // Creating Style  
             style26.setBorderLeft(BorderStyle.THICK);  
             style26.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
             style26.setBorderRight(BorderStyle.THICK);  
             style26.setRightBorderColor(IndexedColors.BLACK.getIndex());
             style26.setBorderBottom(BorderStyle.THICK);  
             style26.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
             style26.setBorderTop(BorderStyle.THICK);  
             style26.setTopBorderColor(IndexedColors.BLACK.getIndex());
             Font font26 = wb.createFont();  
             style26.setAlignment(HorizontalAlignment.CENTER);
             style26.setVerticalAlignment(VerticalAlignment.CENTER);
             font26.setFontHeightInPoints((short)8);  
             font26.setFontName("Arial");
             font26.setBold(true);
             style26.setFont(font26);

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
              
              //--------------o------------------------
              
              
             row= sheet.createRow(9);
             //Proje Adı kısmı pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Proje Adı");  
             sheet.addMergedRegion(new CellRangeAddress(9,9,0,1));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(2); 
             
             cell.setCellValue((String)ProjeAdi.getSelectionModel().getSelectedItem());  
             sheet.addMergedRegion(new CellRangeAddress(9,10,2,9));  
             cell.setCellStyle(style7);
             
             //Muayene Kapsamı pembe 
             for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Muayene Kapsamı");  
             sheet.addMergedRegion(new CellRangeAddress(9,9,10,12));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(13); 
             
             cell.setCellValue(MuayeneKapsami.getText());  
             sheet.addMergedRegion(new CellRangeAddress(9,10,13,15));  
             cell.setCellStyle(style7);
             
             
             
             //Rapor No Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Rapor No");  
             sheet.addMergedRegion(new CellRangeAddress(9,9,16,18));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(19); 
             
             cell.setCellValue(RaporNo.getText());  
             sheet.addMergedRegion(new CellRangeAddress(9,10,19,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(10);
             //Projekt Name pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Project Name");  
             sheet.addMergedRegion(new CellRangeAddress(10,10,0,1));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Inspection Scope
              for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Inspection Scope");  
             sheet.addMergedRegion(new CellRangeAddress(10,10,10,12));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Report No Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Report No");  
             sheet.addMergedRegion(new CellRangeAddress(10,10,16,18));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             //--------------o--------------------------
             
             row= sheet.createRow(11);
             //Test Yeri kısmı pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Test Yeri");  
             sheet.addMergedRegion(new CellRangeAddress(11,11,0,1));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(2); 
             
             cell.setCellValue(TestYeri.getText());  
             sheet.addMergedRegion(new CellRangeAddress(11,12,2,9));  
             cell.setCellStyle(style7);
             
             //Muayene Kapsamı pembe 
             for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Resim No");  
             sheet.addMergedRegion(new CellRangeAddress(11,11,10,12));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(13); 
             
             cell.setCellValue(ResimNo.getText());  
             sheet.addMergedRegion(new CellRangeAddress(11,12,13,15));  
             cell.setCellStyle(style7);
             
             
             
             //Rapor Tarihi Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Rapor Tarihi");  
             sheet.addMergedRegion(new CellRangeAddress(11,11,16,18));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(19); 
             
             cell.setCellValue(RaporTarihi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(11,12,19,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(12);
             //Inspection Place pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Inspection Place");  
             sheet.addMergedRegion(new CellRangeAddress(12,12,0,1));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Drawing No
              for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Drawing No");  
             sheet.addMergedRegion(new CellRangeAddress(12,12,10,12));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Report Date Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Report Date");  
             sheet.addMergedRegion(new CellRangeAddress(12,12,16,18));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //--------------------o-------------------------------
              
               row= sheet.createRow(13);
             //Muayene Standardı kısmı pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Muayene Standardı");  
             sheet.addMergedRegion(new CellRangeAddress(13,13,0,1));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(2); 
             
             cell.setCellValue(MuayeneStandardi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(13,14,2,9));  
             cell.setCellStyle(style7);
             
             //Yuzey Durumu pembe 
             for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Yuzey Durumu");  
             sheet.addMergedRegion(new CellRangeAddress(13,13,10,12));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(13); 
             
             cell.setCellValue((String)YuzeyDurumu.getSelectionModel().getSelectedItem());  
             sheet.addMergedRegion(new CellRangeAddress(13,14,13,15));  
             cell.setCellStyle(style7);
             
             
             
             //İş Emri No Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("İş Emri No");  
             sheet.addMergedRegion(new CellRangeAddress(13,13,16,18));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(19); 
             
             cell.setCellValue((String)IsEmriNo.getSelectionModel().getSelectedItem());  
             sheet.addMergedRegion(new CellRangeAddress(13,14,19,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(14);
             //Inspection Standart pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Inspection Standart");  
             sheet.addMergedRegion(new CellRangeAddress(14,14,0,1));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Surface Condition
              for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Surface Condition");  
             sheet.addMergedRegion(new CellRangeAddress(14,14,10,12));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Job Order No Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Job Order No");  
             sheet.addMergedRegion(new CellRangeAddress(14,14,16,18));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
             //--------------o--------------------- 
              
              row= sheet.createRow(15);
             //Değerlen standardı kısmı pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Değerlen. Standardı");  
             sheet.addMergedRegion(new CellRangeAddress(15,15,0,1));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(2); 
             
             cell.setCellValue(EvaluationStandard.getText());  
             sheet.addMergedRegion(new CellRangeAddress(15,16,2,9));  
             cell.setCellStyle(style7);
             
             //Muayene Aşaması pembe 
             for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Muayene Aşaması");  
             sheet.addMergedRegion(new CellRangeAddress(15,15,10,12));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(13); 
             
             cell.setCellValue((String)MuayeneAsamasi.getSelectionModel().getSelectedItem());  
             sheet.addMergedRegion(new CellRangeAddress(15,16,13,15));  
             cell.setCellStyle(style7);
             
             
             
             //Teklif No Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Teklif No");  
             sheet.addMergedRegion(new CellRangeAddress(15,15,16,18));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(19); 
             
                cell.setCellValue((String)TeklifNo.getSelectionModel().getSelectedItem());  
             sheet.addMergedRegion(new CellRangeAddress(15,16,19,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(16);
             //Evaluation Standart pembe
             for (int i=0;i<=1;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Evaluation Standart");  
             sheet.addMergedRegion(new CellRangeAddress(16,16,0,1));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=2;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Stage of Examination
              for (int i=10;i<=12;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Stage of Examination");  
             sheet.addMergedRegion(new CellRangeAddress(16,16,10,12));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=13;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Offer No Pembe
             for (int i=16;i<=18;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("Offer No");  
             sheet.addMergedRegion(new CellRangeAddress(16,16,16,18));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=19;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
            //----------------------o------------------------
            
            //Başlık: Ekipman Bilgileri
            row= sheet.createRow(17);
            for (int i=0;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style9);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Ekipman Bilgileri");  
             sheet.addMergedRegion(new CellRangeAddress(17,17,0,10));  
             cell.setCellStyle(style9);
             
             //Başlık: Equipment Informations
             for (int i=11;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style8);
             }
             cell =  row.createCell(11); 
             
             cell.setCellValue("/Equipment Informations");  
             sheet.addMergedRegion(new CellRangeAddress(17,17,11,20));  
             cell.setCellStyle(style8);
             
            //------------------o------------------
            
            row= sheet.createRow(18);
             //Kutup Mesafesi pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Kutup Mesafesi,mm");  
             sheet.addMergedRegion(new CellRangeAddress(18,18,0,2));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(3); 
             
             cell.setCellValue(KutupMesafesi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(18,19,3,6));  
             cell.setCellStyle(style7);
             
             //Muayene Bölgesi pembe 
             for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Muayene Bölgesi");  
             sheet.addMergedRegion(new CellRangeAddress(18,18,7,9));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue(MuayeneBolgesi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(18,19,10,14));  
             cell.setCellStyle(style7);
             
             
             
             //Yüzey Sıcaklığı Pembe
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Yüzey Sıcaklığı");  
             sheet.addMergedRegion(new CellRangeAddress(18,18,15,17));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(18); 
             
             cell.setCellValue(YuzeySicakligi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(18,19,18,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(19);
             //Pole Distance pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Pole Distance");  
             sheet.addMergedRegion(new CellRangeAddress(19,19,0,2));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Examination Area
              for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Examination Area");  
             sheet.addMergedRegion(new CellRangeAddress(19,19,7,9));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Surface Temperature Pembe
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Surface Temperature");  
             sheet.addMergedRegion(new CellRangeAddress(19,19,15,17));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              //----------------------o----------------
             row= sheet.createRow(20);
             //Cihaz pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Cihaz");  
             sheet.addMergedRegion(new CellRangeAddress(20,20,0,2));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(3); 
             
             cell.setCellValue(Cihaz.getText());  
             sheet.addMergedRegion(new CellRangeAddress(20,21,3,6));  
             cell.setCellStyle(style7);
             
             //Akım Tipi pembe 
             for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Akım Tipi");  
             sheet.addMergedRegion(new CellRangeAddress(20,20,7,9));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue(AkimTipi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(20,21,10,14));  
             cell.setCellStyle(style7);
             
             
             
             //Muayene Bölgesindeki Alan Şiddeti Pembe
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style10);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Muayene Bölgesindeki Alan Şiddeti. kA/m");  
             sheet.addMergedRegion(new CellRangeAddress(20,21,15,17));  
             cell.setCellStyle(style10);
             
             //Text kısmı beyaz
             for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style12);
             }
             cell =  row.createCell(20); 
             
             cell.setCellValue(MuayeneBolgesiAlanSiddeti.getText());  
             sheet.addMergedRegion(new CellRangeAddress(20,23,18,20));  
             cell.setCellStyle(style10);
             
             
             
             
             row= sheet.createRow(21);
             //Equipment pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Equipment");  
             sheet.addMergedRegion(new CellRangeAddress(21,21,0,2));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Current Type 
              for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Current Type");  
             sheet.addMergedRegion(new CellRangeAddress(21,21,7,9));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              //Gauss Field Beyaz kısmı text
              for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style12);
             }
              
              //----------------------o---------------------
              
              
             row= sheet.createRow(22);
             //Mp Taşıyıcı Ortam pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Mp Taşıyıcı Ortam");  
             sheet.addMergedRegion(new CellRangeAddress(22,22,0,2));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(3); 
             
             cell.setCellValue(MpTasiyiciOrtam.getText());  
             sheet.addMergedRegion(new CellRangeAddress(22,23,3,6));  
             cell.setCellStyle(style7);
             
             //Luxmetre/Işık Şiddeti pembe 
             for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Luxmetre/Işık Şiddeti");  
             sheet.addMergedRegion(new CellRangeAddress(22,22,7,9));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue(Luxmetre.getText());  
             sheet.addMergedRegion(new CellRangeAddress(22,23,10,14));  
             cell.setCellStyle(style7);
             
             
             
             //Gaus Field Strength Pembe
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Gaus Field Strength");  
             sheet.addMergedRegion(new CellRangeAddress(22,23,15,17));  
             cell.setCellStyle(style6);
             
             
             for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style13);
             }
             
             
             
             row= sheet.createRow(23);
             //Mp Carrier Medium
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Mp Carrier Medium");  
             sheet.addMergedRegion(new CellRangeAddress(23,23,0,2));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Luxmeter Type 
              for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Luxmeter");  
             sheet.addMergedRegion(new CellRangeAddress(23,23,7,9));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Pembe kısmı text
              for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
              
              //Gauss Field Beyaz kısmı text
              for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
              
             //-------------------------------o----------------------
             
              row= sheet.createRow(24);
             //Mıknatıslama Tekniği pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Mıknatıslama Tekniği");  
             sheet.addMergedRegion(new CellRangeAddress(24,24,0,2));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(3); 
             
             cell.setCellValue(MiknatislamaTeknigi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(24,25,3,6));  
             cell.setCellStyle(style7);
             
             //Muayene Bölgesi pembe 
             for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Muayene Ortamı");  
             sheet.addMergedRegion(new CellRangeAddress(24,24,7,9));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue(MuayeneOrtami.getText());  
             sheet.addMergedRegion(new CellRangeAddress(24,25,10,14));  
             cell.setCellStyle(style7);
             
             
             
             //Yüzey  Pembe
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Yüzey");  
             sheet.addMergedRegion(new CellRangeAddress(24,24,15,17));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(18); 
             
             cell.setCellValue(Yuzey.getText());  
             sheet.addMergedRegion(new CellRangeAddress(24,25,18,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(25);
             //Mag.Tech. pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Mag.Tech");  
             sheet.addMergedRegion(new CellRangeAddress(25,25,0,2));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Test Medium
              for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Test Medium");  
             sheet.addMergedRegion(new CellRangeAddress(25,25,7,9));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Surface Condition Pembe
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Surface Condition");  
             sheet.addMergedRegion(new CellRangeAddress(25,25,15,17));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             //----------o----------------------
             
              row= sheet.createRow(26);
             //Mıknatıslama Tekniği pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("UV Işık Şiddeti");  
             sheet.addMergedRegion(new CellRangeAddress(26,26,0,2));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(3); 
             
             cell.setCellValue(UVIsıkSiddeti.getText());  
             sheet.addMergedRegion(new CellRangeAddress(26,27,3,6));  
             cell.setCellStyle(style7);
             
             //Mıknatıs Giderimi pembe 
             for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Mıknatıs Giderimi");  
             sheet.addMergedRegion(new CellRangeAddress(26,26,7,9));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue(MiknatisGiderimi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(26,27,10,14));  
             cell.setCellStyle(style7);
             
             
             
             //Işık Cihaz Tanımı Pembe
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Işık Cihaz Tanımı");  
             sheet.addMergedRegion(new CellRangeAddress(26,26,15,17));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(18); 
             
             cell.setCellValue(IsikCihaziTanimi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(26,27,18,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(27);
             //Mag.Tech. pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("UV Light Intensity");  
             sheet.addMergedRegion(new CellRangeAddress(27,27,0,2));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Demegnelization
              for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Demegnelization");  
             sheet.addMergedRegion(new CellRangeAddress(27,27,7,9));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Identification of Light Equip Pembe
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Identification of Light Equip");  
             sheet.addMergedRegion(new CellRangeAddress(27,27,15,17));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //----------o----------------------
             
              row= sheet.createRow(28);
             //Işık Mesafesi pembe
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Işık Mesafesi");  
             sheet.addMergedRegion(new CellRangeAddress(28,28,0,2));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(3); 
             
             cell.setCellValue(IsikMesafesi.getText());  
             sheet.addMergedRegion(new CellRangeAddress(28,29,3,6));  
             cell.setCellStyle(style7);
             
             //Isıl İşlem pembe 
             for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Isıl İşlem");  
             sheet.addMergedRegion(new CellRangeAddress(28,28,7,9));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue(IsilIslem.getText());  
             sheet.addMergedRegion(new CellRangeAddress(28,29,10,14));  
             cell.setCellStyle(style7);
             
             
             
             //Kaldırma Testi Tarih
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style5);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Kaldırma Testi Tarih / No");  
             sheet.addMergedRegion(new CellRangeAddress(28,28,15,17));  
             cell.setCellStyle(style5);
             
             //Text kısmı beyaz
             for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             cell =  row.createCell(18); 
             
             cell.setCellValue(KaldirmaTestiTarih.getText());  
             sheet.addMergedRegion(new CellRangeAddress(28,29,18,20));  
             cell.setCellStyle(style7);
             
             
             
             
             row= sheet.createRow(29);
             //Distance of Light
             for (int i=0;i<=2;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Distance of Light");  
             sheet.addMergedRegion(new CellRangeAddress(29,29,0,2));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=3;i<=6;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Heat Treatment
              for (int i=7;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(7); 
             
             cell.setCellValue("Heat Treatment");  
             sheet.addMergedRegion(new CellRangeAddress(29,29,7,9));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=10;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              //Lifting Case Date
             for (int i=15;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Lifting Case / Date");  
             sheet.addMergedRegion(new CellRangeAddress(29,29,15,17));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             //------------------------------o--------------------------------------
             //ROW 30 *******************************
             
             row= sheet.createRow(30);
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             
             //RESİM 1 Alın Kaynağı
             //Buraya resim konacak.
             //FileInputStream obtains input bytes from the image file
            InputStream inputStream1 = new FileInputStream("C:\\Users\\izmir\\OneDrive\\Documents\\NetBeansProjects\\Rapor\\src\\rapor\\Icons\\ForumFoto1.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes1 = IOUtils.toByteArray(inputStream1);
            //Adds a picture to the workbook
            int pictureIdx1 = wb.addPicture(bytes1, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper1 = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing1 = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor1 = helper1.createClientAnchor();
            //set top-left corner for the image
            anchor1.setCol1(0);
            anchor1.setRow1(31);

            //Creates a picture
            Picture pict1 = drawing1.createPicture(anchor1, pictureIdx1);
            //Reset the image to the original size
            pict1.resize(3.5,5.5);
            
            sheet.addMergedRegion(new CellRangeAddress(30,36,0,4));
            
            //RESİM 2 Köşe Kaynağı****************
            for (int i=5;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
            
            //Buraya resim konacak.
             //FileInputStream obtains input bytes from the image file
            InputStream inputStream4 = new FileInputStream("C:\\Users\\izmir\\OneDrive\\Documents\\NetBeansProjects\\Rapor\\src\\rapor\\Icons\\ForumFoto22.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes4 = IOUtils.toByteArray(inputStream4);
            //Adds a picture to the workbook
            int pictureIdx4 = wb.addPicture(bytes4, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper4 = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing4 = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor4 = helper4.createClientAnchor();
            //set top-left corner for the image
            anchor4.setCol1(6);
            anchor4.setRow1(31);

            //Creates a picture
            Picture pict4 = drawing4.createPicture(anchor4, pictureIdx4);
            //Reset the image to the original size
            pict4.resize(3.5,5.5);
            
            sheet.addMergedRegion(new CellRangeAddress(30,36,5,9));
            
            
            //RESİMLERİN YANINDAKİ YAZI KISIMLARI
            
            //Başlık: Süreksizliğin yeri
            
            for (int i=10;i<=15;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style9);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("Süreksizliğin Yeri");  
             sheet.addMergedRegion(new CellRangeAddress(30,32,10,15));  
             cell.setCellStyle(style14);
             
             //Başlık: Equipment Informations
             for (int i=16;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style8);
             }
             cell =  row.createCell(16); 
             
             cell.setCellValue("/Location of Discontinuity");  
             sheet.addMergedRegion(new CellRangeAddress(30,32,16,20));  
             cell.setCellStyle(style15);
            
            //ROW 31 *******************************
             
             row= sheet.createRow(31);
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             for (int i=5;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             for (int i=10;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style17);
             }
             cell=row.createCell(20);
             cell.setCellStyle(style15);
             
             
             
             
             
             //ROW 32 *******************************
             
             row= sheet.createRow(32);
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             for (int i=5;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             for (int i=10;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style17);
             }
             cell=row.createCell(20);
             cell.setCellStyle(style15);
             //ROW 33 *******************************
             
             row= sheet.createRow(33);
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             for (int i=5;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             //Başlık: BM
            
            for (int i=10;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style15);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("BM");  
             sheet.addMergedRegion(new CellRangeAddress(33,33,10,11));  
             cell.setCellStyle(style16);
             
             //Başlık: Ana metal
            
            for (int i=12;i<=13;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style9);
             }
             cell =  row.createCell(12); 
             
             cell.setCellValue("Ana Metal");  
             sheet.addMergedRegion(new CellRangeAddress(33,33,12,13));  
             cell.setCellStyle(style18);
             
             //Başlık: Base Metal
             for (int i=14;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style8);
             }
             cell =  row.createCell(14); 
             
             cell.setCellValue("/Base Metal");  
             sheet.addMergedRegion(new CellRangeAddress(33,33,14,20));  
             cell.setCellStyle(style15);
            
             
            
              
             
             //ROW 34 *******************************
             
             row= sheet.createRow(34);
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             for (int i=5;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             if(AlinKaynagiRadio.isSelected()){
             //Buraya resim konacak.
             //FileInputStream obtains input bytes from the image file
            InputStream inputStream2 = new FileInputStream("C:\\Users\\izmir\\OneDrive\\Documents\\NetBeansProjects\\Rapor\\src\\rapor\\Icons\\Checkli0.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes2 = IOUtils.toByteArray(inputStream2);
            //Adds a picture to the workbook
            int pictureIdx2 = wb.addPicture(bytes2, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper2 = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing2 = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor2 = helper2.createClientAnchor();
            //set top-left corner for the image
            anchor2.setCol1(3);
            anchor2.setRow1(35);

            //Creates a picture
            Picture pict2 = drawing2.createPicture(anchor2, pictureIdx2);
            //Reset the image to the original size
            pict2.resize(0.45,0.8);
             }
             else{
            //Buraya resim konacak.
             //FileInputStream obtains input bytes from the image file
            InputStream inputStream3 = new FileInputStream("C:\\Users\\izmir\\OneDrive\\Documents\\NetBeansProjects\\Rapor\\src\\rapor\\Icons\\Checksiz.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes3 = IOUtils.toByteArray(inputStream3);
            //Adds a picture to the workbook
            int pictureIdx3 = wb.addPicture(bytes3, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper3 = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing3 = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor3 = helper3.createClientAnchor();
            //set top-left corner for the image
            anchor3.setCol1(3);
            anchor3.setRow1(35);

            //Creates a picture
            Picture pict3 = drawing3.createPicture(anchor3, pictureIdx3);
            //Reset the image to the original size
            pict3.resize(0.45,0.8);     
             }
             
             
             if(KoseKaynagiRadio.isSelected()){
             //Buraya resim konacak.
             //FileInputStream obtains input bytes from the image file
            InputStream inputStream5 = new FileInputStream("C:\\Users\\izmir\\OneDrive\\Documents\\NetBeansProjects\\Rapor\\src\\rapor\\Icons\\Checkli0.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes5 = IOUtils.toByteArray(inputStream5);
            //Adds a picture to the workbook
            int pictureIdx5 = wb.addPicture(bytes5, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper5 = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing5 = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor5 = helper5.createClientAnchor();
            //set top-left corner for the image
            anchor5.setCol1(9);
            anchor5.setRow1(35);

            //Creates a picture
            Picture pict5 = drawing5.createPicture(anchor5, pictureIdx5);
            //Reset the image to the original size
            pict5.resize(0.27,0.8);
             }
             else{
            //Buraya resim konacak.
             //FileInputStream obtains input bytes from the image file
            InputStream inputStream6 = new FileInputStream("C:\\Users\\izmir\\OneDrive\\Documents\\NetBeansProjects\\Rapor\\src\\rapor\\Icons\\Checksiz.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes6 = IOUtils.toByteArray(inputStream6);
            //Adds a picture to the workbook
            int pictureIdx6 = wb.addPicture(bytes6, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper6 = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing6 = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor6 = helper6.createClientAnchor();
            //set top-left corner for the image
            anchor6.setCol1(9);
            anchor6.setRow1(35);

            //Creates a picture
            Picture pict6 = drawing6.createPicture(anchor6, pictureIdx6);
            //Reset the image to the original size
            pict6.resize(0.27,0.8);     
             }
             
             //Başlık: HAZ
            
            for (int i=10;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style15);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("HAZ");  
             sheet.addMergedRegion(new CellRangeAddress(34,34,10,11));  
             cell.setCellStyle(style16); 
             
               //Başlık: Isıdan etkilenen bölge
            
            for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style9);
             }
             cell =  row.createCell(12); 
             
             cell.setCellValue("Isıdan etkilenen bölge");  
             sheet.addMergedRegion(new CellRangeAddress(34,34,12,14));  
             cell.setCellStyle(style18);
             
             //Başlık: Base Metal
             for (int i=15;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style8);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("/Heat afffected zone");  
             sheet.addMergedRegion(new CellRangeAddress(34,34,15,20));  
             cell.setCellStyle(style15);
            
             
             //ROW 35 *******************************
             
             row= sheet.createRow(35);
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             for (int i=5;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
              //Başlık: W
            
            for (int i=10;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style15);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("W");  
             sheet.addMergedRegion(new CellRangeAddress(35,35,10,11));  
             cell.setCellStyle(style16);
             
                //Başlık: Kaynak
            
            for (int i=12;i<=13;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style9);
             }
             cell =  row.createCell(12); 
             
             cell.setCellValue("Kaynak");  
             sheet.addMergedRegion(new CellRangeAddress(35,35,12,13));  
             cell.setCellStyle(style18);
             
             //Başlık: Weld
             for (int i=14;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style8);
             }
             cell =  row.createCell(14); 
             
             cell.setCellValue("/Weld");  
             sheet.addMergedRegion(new CellRangeAddress(35,35,14,20));  
             cell.setCellStyle(style15);
             
             //ROW 36 *******************************
             
             row= sheet.createRow(36);
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             
             for (int i=5;i<=9;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
             //Başlık: B
            
            for (int i=10;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style15);
             }
             cell =  row.createCell(10); 
             
             cell.setCellValue("B");  
             sheet.addMergedRegion(new CellRangeAddress(36,36,10,11));  
             cell.setCellStyle(style16);
             
                 //Başlık: Kaynak ağzı
            
            for (int i=12;i<=13;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style9);
             }
             cell =  row.createCell(12); 
             
             cell.setCellValue("Kaynak Ağzı");  
             sheet.addMergedRegion(new CellRangeAddress(36,36,12,13));  
             cell.setCellStyle(style18);
             
             //Başlık: Weld
             for (int i=14;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style8);
             }
             cell =  row.createCell(14); 
             
             cell.setCellValue("/Bewel");  
             sheet.addMergedRegion(new CellRangeAddress(36,36,14,20));  
             cell.setCellStyle(style15);
             
             // ROW 37 *******************
             
             row= sheet.createRow(37);
             //Standarttan Sapmalar
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Standarttan Sapmalar");  
             sheet.addMergedRegion(new CellRangeAddress(37,37,0,4));  
             cell.setCellStyle(style19);
             
             //Text kısmı beyaz
             for (int i=5;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style20);
             }
             cell =  row.createCell(5); 
             
             cell.setCellValue(StandartSapmalar.getText());  
             sheet.addMergedRegion(new CellRangeAddress(37,38,5,20));  
             cell.setCellStyle(style20);
             
             //ROW 38**************************
             row= sheet.createRow(38);
             //Standard Deviations
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Standard Deviations");  
             sheet.addMergedRegion(new CellRangeAddress(38,38,0,4));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=5;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              // ROW 39 *******************
             
             row= sheet.createRow(39);
             //Muayene Tarihleri
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Muayene Tarihleri");  
             sheet.addMergedRegion(new CellRangeAddress(39,39,0,4));  
             cell.setCellStyle(style19);
             
             //Text kısmı beyaz
             for (int i=5;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style20);
             }
             cell =  row.createCell(5); 
             
             cell.setCellValue(MuayeneTarihleri.getText());  
             sheet.addMergedRegion(new CellRangeAddress(39,40,5,20));  
             cell.setCellStyle(style21);
             
             //ROW 40**************************
             row= sheet.createRow(40);
             //Inspection Dates
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Inspection Dates");  
             sheet.addMergedRegion(new CellRangeAddress(40,40,0,4));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=5;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
                // ROW 41 *******************
             
             row= sheet.createRow(41);
             //Açıklamalar ve Ekler
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Açıklamalar ve Ekler");  
             sheet.addMergedRegion(new CellRangeAddress(41,41,0,4));  
             cell.setCellStyle(style19);
             
             //Text kısmı beyaz
             for (int i=5;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style20);
             }
             cell =  row.createCell(5); 
             
             cell.setCellValue(AciklamalarVeEkler.getText());  
             sheet.addMergedRegion(new CellRangeAddress(41,42,5,20));  
             cell.setCellStyle(style20);
             
             //ROW 42**************************
             row= sheet.createRow(42);
             //Description and Attachments
             for (int i=0;i<=4;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Description and Attachments");  
             sheet.addMergedRegion(new CellRangeAddress(42,42,0,4));  
             cell.setCellStyle(style6);
             
             //Beyaz kısmı text
              for (int i=5;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style7);
             }
              
              
              //Başlık: Muayene Sonuçları Row 43
            row= sheet.createRow(43);
            for (int i=0;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style9);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Muayene Sonuçları");  
             sheet.addMergedRegion(new CellRangeAddress(43,43,0,10));  
             cell.setCellStyle(style9);
             
             //Başlık: Inspection Results
             for (int i=11;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style8);
             }
             cell =  row.createCell(11); 
             
             cell.setCellValue("/Inspection Results");  
             sheet.addMergedRegion(new CellRangeAddress(43,43,11,20));  
             cell.setCellStyle(style8);
             
             //ROW 44 ---------------o------------------------
             row= sheet.createRow(44);
             //Sıra No
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Sıra No");   
             cell.setCellStyle(style19);
             
             
             //Kaynak/Parça No
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(1); 
             
             cell.setCellValue("Kaynak/Parça No");  
             sheet.addMergedRegion(new CellRangeAddress(44,44,1,5));  
             cell.setCellStyle(style19);
             
             
             //Kontrol Uzun.
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(6); 
             
             cell.setCellValue("Kontrol Uzun.");  
             sheet.addMergedRegion(new CellRangeAddress(44,44,6,7));  
             cell.setCellStyle(style19);
             
             
             //Kaynak yön.
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(8); 
             
             cell.setCellValue("Kaynak Yön.");  
             sheet.addMergedRegion(new CellRangeAddress(44,44,8,10));  
             cell.setCellStyle(style19);
             
             
             
             //Kalınlık (mm)
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(11); 
             
             cell.setCellValue("Kalınlık (mm)");   
             cell.setCellStyle(style19);
             
             
             //Çap(mm)
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(12); 
             
             cell.setCellValue("Çap (mm)");  
             sheet.addMergedRegion(new CellRangeAddress(44,44,12,14));  
             cell.setCellStyle(style19);
             
             
             //Hata Tipi
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Hata Tipi");  
             sheet.addMergedRegion(new CellRangeAddress(44,44,15,16));  
             cell.setCellStyle(style19);
             
             
             //Hatanın Yeri
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(17); 
             
             cell.setCellValue("Hatanın Yeri");  
             sheet.addMergedRegion(new CellRangeAddress(44,44,17,19));  
             cell.setCellStyle(style19);
             
             
             //Sonuç
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(20); 
             
             cell.setCellValue("Sonuç");    
             cell.setCellStyle(style19);
             
             
             //ROW 45 ---------------o------------------------
             row= sheet.createRow(45);
             //Serial No
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Serial No");    
             cell.setCellStyle(style6);
             
             
             //Weld/Piece No
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(1); 
             
             cell.setCellValue("Weld/Piece No");  
             sheet.addMergedRegion(new CellRangeAddress(45,45,1,5));  
             cell.setCellStyle(style6);
             
             
             //Test Length
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(6); 
             
             cell.setCellValue("Test Length");  
             sheet.addMergedRegion(new CellRangeAddress(45,45,6,7));  
             cell.setCellStyle(style6);
             
             
             //Welding Process
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(8); 
             
             cell.setCellValue("Welding Process");  
             sheet.addMergedRegion(new CellRangeAddress(45,45,8,10));  
             cell.setCellStyle(style6);
             
             
             
             //Thickness
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(11); 
             
             cell.setCellValue("Thickness");  
             cell.setCellStyle(style6);
             
             
             //Diameter
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(12); 
             
             cell.setCellValue("Diameter");  
             sheet.addMergedRegion(new CellRangeAddress(45,45,12,14));  
             cell.setCellStyle(style6);
             
             
             //Defect Type
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(15); 
             
             cell.setCellValue("Defect Type");  
             sheet.addMergedRegion(new CellRangeAddress(45,45,15,16));  
             cell.setCellStyle(style6);
             
             
             //Defect Loc.
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(17); 
             
             cell.setCellValue("Defect Loc.");  
             sheet.addMergedRegion(new CellRangeAddress(45,45,17,19));  
             cell.setCellStyle(style6);
             
             
             //Result
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style6);
             }
             cell =  row.createCell(20); 
             
             cell.setCellValue("Result");  
             cell.setCellStyle(style6);
             
             //ROW 46 ***********************
             //Sıra No1
             row= sheet.createRow(46);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No1
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun1
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön1
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık1
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,11,11));  
             cell.setCellStyle(style23);
             
             //Çap1
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi1
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri1
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc1
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc1.getText());  
             sheet.addMergedRegion(new CellRangeAddress(46,47,20,20));  
             cell.setCellStyle(style22);
             
             
             
             
             //ROW 47*************
             row= sheet.createRow(47);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             //ROW 48 ***********************
             //Sıra No2
             row= sheet.createRow(48);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No2
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun2
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön2
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık2
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,11,11));  
             cell.setCellStyle(style23);
             
             //Çap2
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi2
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri2
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc2
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc2.getText());  
             sheet.addMergedRegion(new CellRangeAddress(48,49,20,20));  
             cell.setCellStyle(style22);
             
             
            //ROW 49*************
             row= sheet.createRow(49);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             //ROW 50 ***********************
             //Sıra No3
             row= sheet.createRow(50);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No3
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun3
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön3
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık3
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,11,11));  
             cell.setCellStyle(style23);
             
             //Çap3
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi3
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri3
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc3
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc3.getText());  
             sheet.addMergedRegion(new CellRangeAddress(50,51,20,20));  
             cell.setCellStyle(style22);
             
             //ROW 51*************
             row= sheet.createRow(51);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             //ROW 52 ***********************
             //Sıra No4
             row= sheet.createRow(52);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No4
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun4
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön4
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık4
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,11,11));  
             cell.setCellStyle(style23);
             
             //Çap4
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi4
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri4
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc4
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc4.getText());  
             sheet.addMergedRegion(new CellRangeAddress(52,53,20,20));  
             cell.setCellStyle(style22);
             
             
             //ROW 53*************
             row= sheet.createRow(53);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             //ROW 54 ***********************
             //Sıra No5
             row= sheet.createRow(54);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No5
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun5
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön5
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık5
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,11,11));  
             cell.setCellStyle(style23);
             
             //Çap5
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi5
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri5
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc5
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc5.getText());  
             sheet.addMergedRegion(new CellRangeAddress(54,55,20,20));  
             cell.setCellStyle(style22);
             
             //ROW 55*************
             row= sheet.createRow(55);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             
             //ROW 56 ***********************
             //Sıra No6
             row= sheet.createRow(56);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No6
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun6
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön6
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık6
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,11,11));  
             cell.setCellStyle(style23);
             
             //Çap6
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi6
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri6
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc6
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc6.getText());  
             sheet.addMergedRegion(new CellRangeAddress(56,57,20,20));  
             cell.setCellStyle(style22);
             
             //ROW 57*************
             row= sheet.createRow(57);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             //ROW 58 ***********************
             //Sıra No7
             row= sheet.createRow(58);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No7
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun7
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön7
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık7
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,11,11));  
             cell.setCellStyle(style23);
             
             //Çap7
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi7
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,15,16));  
             cell.setCellStyle(style23);
             
            
             //Hatanin Yeri7
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc7
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc7.getText());  
             sheet.addMergedRegion(new CellRangeAddress(58,59,20,20));  
             cell.setCellStyle(style22);
             
             //ROW 59*************
             row= sheet.createRow(59);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             //ROW 60 ***********************
             //Sıra No8
             row= sheet.createRow(60);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No8
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun8
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön8
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık8
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,11,11));  
             cell.setCellStyle(style23);
             
             //Çap8
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi8
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri8
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc8
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc8.getText());  
             sheet.addMergedRegion(new CellRangeAddress(60,61,20,20));  
             cell.setCellStyle(style22);
             
             //ROW 61*************
             row= sheet.createRow(61);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             //ROW 62 ***********************
             //Sıra No9
             row= sheet.createRow(62);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No9
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun9
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön9
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık9
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,11,11));  
             cell.setCellStyle(style23);
             
             //Çap9
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi9
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri9
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc9
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc9.getText());  
             sheet.addMergedRegion(new CellRangeAddress(62,63,20,20));  
             cell.setCellStyle(style22);
              
             
             //ROW 63*************
             row= sheet.createRow(63);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
             
             //ROW 64 ***********************
             //Sıra No10
             row= sheet.createRow(64);
             for (int i=0;i<=0;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             }
              
             cell =  row.createCell(0); 
             cell.setCellValue(SiraNo10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,0,0));  
             cell.setCellStyle(style24);
             
             //Kaynak/Parça No10
             
             for (int i=1;i<=5;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(1); 
             cell.setCellValue(KaynakParcaNo10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,1,5));  
             cell.setCellStyle(style22);
             
             //Kontrol Uzun10
             
             for (int i=6;i<=7;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(6); 
             cell.setCellValue(KontrolUzun10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,6,7));  
             cell.setCellStyle(style23);
             
             //Kaynak Yön10
             
             for (int i=8;i<=10;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(8); 
             cell.setCellValue(KaynakYon10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,8,10));  
             cell.setCellStyle(style23);
             
             //Kalınlık10
             
             for (int i=11;i<=11;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(11); 
             cell.setCellValue(Kalinlik10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,11,11));  
             cell.setCellStyle(style23);
             
             //Çap10
             
             for (int i=12;i<=14;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(12); 
             cell.setCellValue(Cap10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,12,14));  
             cell.setCellStyle(style23);
             
              //Hata Tipi10
             
             for (int i=15;i<=16;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(15); 
             cell.setCellValue(HataTipi10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,15,16));  
             cell.setCellStyle(style23);
             
             
             //Hatanin Yeri10
             
             for (int i=17;i<=19;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style23);
             }
              
             cell =  row.createCell(17); 
             cell.setCellValue(HataninYeri10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,17,19));  
             cell.setCellStyle(style23);
             
             
             //Sonuc10
             
             for (int i=20;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style22);
             }
              
             cell =  row.createCell(20); 
             cell.setCellValue(Sonuc10.getText());  
             sheet.addMergedRegion(new CellRangeAddress(64,65,20,20));  
             cell.setCellStyle(style22);
             
             //ROW 65*************
             row= sheet.createRow(65);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style24);
             } 
             
             
             //ROW 66******************
               //Başlık: Personel Bilgileri
            row= sheet.createRow(66);
            for (int i=0;i<=3;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Personel Bilgileri/Person.Infor.");    
             sheet.addMergedRegion(new CellRangeAddress(66,67,0,3)); 
             cell.setCellStyle(style19);
             
             
             
             //Başlık: Operatör
            for (int i=4;i<=8;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style25);
             }
             cell =  row.createCell(4); 
             
             cell.setCellValue("Operatör/Operator");    
             sheet.addMergedRegion(new CellRangeAddress(66,67,4,8)); 
             cell.setCellStyle(style25);
             
             
              //Başlık: Değerlendiren
            for (int i=9;i<=13;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style25);
             }
             cell =  row.createCell(9); 
             
             cell.setCellValue("Değerlendiren/Evaluated By");    
             sheet.addMergedRegion(new CellRangeAddress(66,67,9,13)); 
             cell.setCellStyle(style25);
             
             
               //Başlık: Onay/Confirmation
            for (int i=14;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style25);
             }
             cell =  row.createCell(14); 
             
             cell.setCellValue("Onay/Confirmation");    
             sheet.addMergedRegion(new CellRangeAddress(66,67,14,17)); 
             cell.setCellStyle(style25);
             
             
                //Başlık: Müşteri/Customer
            for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style25);
             }
             cell =  row.createCell(18); 
             
             cell.setCellValue("Müşteri/Customer");    
             sheet.addMergedRegion(new CellRangeAddress(66,67,18,20)); 
             cell.setCellStyle(style25);
             
             
             //ROW 67*************
             row= sheet.createRow(67);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style);
             } 
             
             //ROW 68******************
               //Başlık: Adı Soyadı / Name Surname
            row= sheet.createRow(68);
            for (int i=0;i<=3;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Adı Soyadı / Name Surname");    
             sheet.addMergedRegion(new CellRangeAddress(68,69,0,3)); 
             cell.setCellStyle(style19);
             
             for (int i=4;i<=8;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(4); 
             cell.setCellValue(OperatorAdSoyad.getText());  
             sheet.addMergedRegion(new CellRangeAddress(68,69,4,8));  
             cell.setCellStyle(style26);
             
             for (int i=9;i<=13;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(9); 
             cell.setCellValue(DegerlendirenAdSoyad.getText());  
             sheet.addMergedRegion(new CellRangeAddress(68,69,9,13));  
             cell.setCellStyle(style26);
             
              for (int i=14;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(14); 
             cell.setCellValue(OnayAdSoyad.getText());  
             sheet.addMergedRegion(new CellRangeAddress(68,69,14,17));  
             cell.setCellStyle(style26);
             
               for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(18); 
             cell.setCellValue(MusteriAdSoyad.getText());  
             sheet.addMergedRegion(new CellRangeAddress(68,69,18,20));  
             cell.setCellStyle(style26);
             
             
             //ROW 69**********************
             row= sheet.createRow(69);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style20);
             } 
             
             
             //ROW 70******************
               //Başlık: Seviye / Level
            row= sheet.createRow(70);
            for (int i=0;i<=3;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Seviye / Level");    
             sheet.addMergedRegion(new CellRangeAddress(70,71,0,3)); 
             cell.setCellStyle(style19);
             
             
             for (int i=4;i<=8;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(4); 
             cell.setCellValue(OperatorLevel.getText());  
             sheet.addMergedRegion(new CellRangeAddress(70,71,4,8));  
             cell.setCellStyle(style26);
             
             for (int i=9;i<=13;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(9); 
             cell.setCellValue(DegerlendirenLevel.getText());  
             sheet.addMergedRegion(new CellRangeAddress(70,71,9,13));  
             cell.setCellStyle(style26);
             
              for (int i=14;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(14); 
             cell.setCellValue(OnayLevel.getText());  
             sheet.addMergedRegion(new CellRangeAddress(70,71,14,17));  
             cell.setCellStyle(style26);
             
               for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(18); 
             cell.setCellValue(MusteriLevel.getText());  
             sheet.addMergedRegion(new CellRangeAddress(70,71,18,20));  
             cell.setCellStyle(style26);
             
             //ROW 71**********************
             row= sheet.createRow(71);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style20);
             } 
             
              //ROW 72******************
               //Başlık: Tarih / Date
            row= sheet.createRow(72);
            for (int i=0;i<=3;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("Tarih / Date");    
             sheet.addMergedRegion(new CellRangeAddress(72,73,0,3)); 
             cell.setCellStyle(style19);
             
             for (int i=4;i<=8;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(4); 
             cell.setCellValue(OperatorTarih.getText());  
             sheet.addMergedRegion(new CellRangeAddress(72,73,4,8));  
             cell.setCellStyle(style26);
             
             for (int i=9;i<=13;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(9); 
             cell.setCellValue(DegerlendirenTarih.getText());  
             sheet.addMergedRegion(new CellRangeAddress(72,73,9,13));  
             cell.setCellStyle(style26);
             
              for (int i=14;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(14); 
             cell.setCellValue(OnayTarih.getText());  
             sheet.addMergedRegion(new CellRangeAddress(72,73,14,17));  
             cell.setCellStyle(style26);
             
               for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(18); 
             cell.setCellValue(MusteriTarih.getText());  
             sheet.addMergedRegion(new CellRangeAddress(72,73,18,20));  
             cell.setCellStyle(style26);
             
             //ROW 73**********************
             row= sheet.createRow(73);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style20);
             } 
             
               //ROW 74******************
               //Başlık: İmza / Signature
            row= sheet.createRow(74);
            for (int i=0;i<=3;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style19);
             }
             cell =  row.createCell(0); 
             
             cell.setCellValue("İmza / Signature");    
             sheet.addMergedRegion(new CellRangeAddress(74,76,0,3)); 
             cell.setCellStyle(style19);
             
             for (int i=4;i<=8;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(4); 
             cell.setCellValue(OperatorImza.getText());  
             sheet.addMergedRegion(new CellRangeAddress(74,76,4,8));  
             cell.setCellStyle(style26);
             
             for (int i=9;i<=13;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(9); 
             cell.setCellValue(DegerlendirenImza.getText());  
             sheet.addMergedRegion(new CellRangeAddress(74,76,9,13));  
             cell.setCellStyle(style26);
             
              for (int i=14;i<=17;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(14); 
             cell.setCellValue(OnayImza.getText());  
             sheet.addMergedRegion(new CellRangeAddress(74,76,14,17));  
             cell.setCellStyle(style26);
             
               for (int i=18;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style26);
             }
              
             cell =  row.createCell(18); 
             cell.setCellValue(MusteriImza.getText());  
             sheet.addMergedRegion(new CellRangeAddress(74,76,18,20));  
             cell.setCellStyle(style26);
             
             //ROW 75**********************
             row= sheet.createRow(75);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style20);
             } 
             
             //ROW 76**********************
             row= sheet.createRow(76);
             for (int i=0;i<=20;i++){
               cell=row.createCell(i);
               cell.setCellStyle(style20);
             } 
             
             
             
             
            // ------GENİŞLİK -------------o---------------
            sheet.setColumnWidth(0,2212);   
            sheet.setColumnWidth(1,3026);   
            sheet.setColumnWidth(2,262);    
            sheet.setColumnWidth(3,1261);   
            sheet.setColumnWidth(4,1397);   
            sheet.setColumnWidth(5,1018);   
            sheet.setColumnWidth(6,2386);   
            sheet.setColumnWidth(7,1668);   
            sheet.setColumnWidth(8,2114);   
            sheet.setColumnWidth(9,2454);   
            sheet.setColumnWidth(10,931);   
            sheet.setColumnWidth(11,3104);  
            sheet.setColumnWidth(12,1421);  
            sheet.setColumnWidth(13,1232);  
            sheet.setColumnWidth(14,1416);  
            sheet.setColumnWidth(15,3104);  
            sheet.setColumnWidth(16,882);   
            sheet.setColumnWidth(17,1765);  
            sheet.setColumnWidth(18,1503);  
            sheet.setColumnWidth(19,2037);  
            sheet.setColumnWidth(20,3191);  
            
            //----------------------o-----------------------
            
             
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
