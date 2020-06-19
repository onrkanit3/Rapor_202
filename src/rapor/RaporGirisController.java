// Onur Kanıt 170503026
package rapor;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author izmir
 */


public class RaporGirisController implements Initializable 
{
    String EkipmanNo = null;
    String Cihaz = null;
    String KutupMesafesi = null;
    String MpTasiyiciOrtam = null;
    String MiknatislamaTeknigi = null;
    String UVIsikSiddeti = null;
    String IsikMesafesi = null;
    String ID2 = null;
    String firstName1 = null;
    String lastName1 = null;
    String Musteriad= null;
    String MusteriIl = null;
    String MusteriIlce = null;
    String level = null;
    
    @FXML private TextField RaporNumarasiTextField;
    @FXML private DatePicker RaporTarihiDatePicker;
    @FXML private DatePicker MuayeneTarihiDatePicker;
    @FXML private TextField personel;
    @FXML private ChoiceBox ekipmanchoicebox;
    @FXML private ChoiceBox MusteriChoiceBox;
    
    
    public String getID(String ID,String firstName, String lastName, String lvl){
        ID2 = ID;
        firstName1 = firstName;
        lastName1 = lastName;
        level = lvl;
        personel.setText(firstName1 + " "+ lastName1);
        return ID+firstName+lastName+lvl;
    }
    public void anaSayfayaDon(ActionEvent event) throws IOException
    {
        
        
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("MainPage.fxml"));
                        Parent MainPageParent = loader.load();
                        Scene MainPageScene = new Scene (MainPageParent);
                        MainPageController mainpagecontroller = loader.getController();
                        mainpagecontroller.getID(ID2,firstName1,lastName1,level);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(MainPageScene);
                        window.show(); 
    }
    
        public void anaSayfayaDonPersonelsiz(ActionEvent event) throws IOException
    {
        
        
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("MainPage_1_1.fxml"));
                        Parent MainPageParent = loader.load();
                        Scene MainPageScene = new Scene (MainPageParent);
                        MainPageController mainpagecontroller = loader.getController();
                        mainpagecontroller.getID(ID2,firstName1,lastName1,level);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(MainPageScene);
                        window.show(); 
    }
        
        
    
    public void ManyetikMuayeneRaporuOlustur(ActionEvent event) throws IOException, SQLException
    {         
                    
        if (RaporNumarasiTextField.getText()==null || RaporTarihiDatePicker.getValue()==null || MuayeneTarihiDatePicker.getValue()==null || ekipmanchoicebox.getValue()== null || MusteriChoiceBox==null){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                            "Lütfen tüm alanları doldurunuz.", 
                            ButtonType.CLOSE);

                Optional<ButtonType> result = alert.showAndWait();
        }
        
        else if(RaporTarihiDatePicker.getValue().isBefore(LocalDate.now())){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                            "Lütfen geçerli bir rapor tarihi giriniz.", 
                            ButtonType.CLOSE);

                Optional<ButtonType> result = alert.showAndWait();
        }
        else{
            Connection conx = null;
            PreparedStatement preparedStatementx = null;
            ResultSet resultSetx = null;

            try
            {
                
                conx= DataBase.getConnection();
                String sqlx = "SELECT EkipmanNo, Cihaz,KutupMesafesi, MpTasiyiciOrtam, MiknatislamaTeknigi, UVIsikSiddeti, IsikMesafesi FROM Ekipman WHERE Cihaz = ?"; 
                

                preparedStatementx = conx.prepareStatement(sqlx);
                preparedStatementx.setString(1, ekipmanchoicebox.getValue().toString());
                resultSetx = preparedStatementx.executeQuery();
                
                
                while(resultSetx.next())
                {
                    EkipmanNo = resultSetx.getString("EkipmanNo");
                    Cihaz = resultSetx.getString("Cihaz");
                    KutupMesafesi = resultSetx.getString("KutupMesafesi");
                    MpTasiyiciOrtam = resultSetx.getString("MpTasiyiciOrtam");
                    MiknatislamaTeknigi = resultSetx.getString("MiknatislamaTeknigi");
                    UVIsikSiddeti = resultSetx.getString("UVIsikSiddeti");
                    IsikMesafesi = resultSetx.getString("IsikMesafesi");
                    
                    
                }
                
            }
                catch(Exception e){
                        
                        }
            
            Connection conxt = null;
            PreparedStatement preparedStatementxt = null;
            ResultSet resultSetxt = null;

            try
            {
                
                conxt= DataBase.getConnection();
                String sqlxt = "SELECT MusteriIsmi, Il,Ilce FROM Firma WHERE MusteriIsmi = ?"; 
                

                preparedStatementxt = conxt.prepareStatement(sqlxt);
                preparedStatementxt.setString(1, MusteriChoiceBox.getValue().toString());
                resultSetxt = preparedStatementxt.executeQuery();
                
                
                while(resultSetxt.next())
                {
                    Musteriad = resultSetxt.getString("MusteriIsmi");
                    MusteriIl = resultSetxt.getString("Il");
                    MusteriIlce = resultSetxt.getString("Ilce");
                    
                    
                }
                
            }
                catch(Exception e){
                        
                        }
          FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ManyetikMuayene.fxml"));
                        Parent ManyetikMuayeneParent = loader.load();
                        Scene ManyetikMuayeneScene = new Scene (ManyetikMuayeneParent);
                        ManyetikMuayeneController manyetikmuayenecontroller = loader.getController();
                        manyetikmuayenecontroller.getID(ID2,firstName1,lastName1,level);
                        manyetikmuayenecontroller.getInfo(RaporTarihiDatePicker.getValue().toString(),MuayeneTarihiDatePicker.getValue().toString(), RaporNumarasiTextField.getText());
                        manyetikmuayenecontroller.verilerial(Musteriad, MusteriIl,MusteriIlce, KutupMesafesi, Cihaz, MpTasiyiciOrtam, MiknatislamaTeknigi, UVIsikSiddeti, IsikMesafesi);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(ManyetikMuayeneScene);
                        window.show();  
                        
                       
        }
        
    }
    
    public void ManyetikMuayeneRaporuOlustur_1(ActionEvent event) throws IOException
    {
        if (RaporNumarasiTextField.getText()==null || RaporTarihiDatePicker.getValue()==null || MuayeneTarihiDatePicker.getValue()==null || ekipmanchoicebox.getValue()== null || MusteriChoiceBox.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                            "Lütfen tüm alanları doldurunuz.", 
                            ButtonType.CLOSE);

                Optional<ButtonType> result = alert.showAndWait();
        }
        
        else if(RaporTarihiDatePicker.getValue().isBefore(LocalDate.now())){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                            "Lütfen geçerli bir rapor tarihi giriniz.", 
                            ButtonType.CLOSE);

                Optional<ButtonType> result = alert.showAndWait();
        }
        else{
            Connection conx = null;
            PreparedStatement preparedStatementx = null;
            ResultSet resultSetx = null;

            try
            {
                
                conx= DataBase.getConnection();
                String sqlx = "SELECT EkipmanNo, Cihaz,KutupMesafesi, MpTasiyiciOrtam, MiknatislamaTeknigi, UVIsikSiddeti, IsikMesafesi FROM Ekipman WHERE Cihaz = ?"; 
                

                preparedStatementx = conx.prepareStatement(sqlx);
                preparedStatementx.setString(1, ekipmanchoicebox.getValue().toString());
                resultSetx = preparedStatementx.executeQuery();
                
                
                while(resultSetx.next())
                {
                    EkipmanNo = resultSetx.getString("EkipmanNo");
                    Cihaz = resultSetx.getString("Cihaz");
                    KutupMesafesi = resultSetx.getString("KutupMesafesi");
                    MpTasiyiciOrtam = resultSetx.getString("MpTasiyiciOrtam");
                    MiknatislamaTeknigi = resultSetx.getString("MiknatislamaTeknigi");
                    UVIsikSiddeti = resultSetx.getString("UVIsikSiddeti");
                    IsikMesafesi = resultSetx.getString("IsikMesafesi");
                    
                    
                }
                
            }
                catch(Exception e){
                        
                        }
            
            Connection conxt = null;
            PreparedStatement preparedStatementxt = null;
            ResultSet resultSetxt = null;

            try
            {
                
                conxt= DataBase.getConnection();
                String sqlxt = "SELECT MusteriIsmi, Il,Ilce FROM Firma WHERE MusteriIsmi = ?"; 
                

                preparedStatementxt = conxt.prepareStatement(sqlxt);
                preparedStatementxt.setString(1, MusteriChoiceBox.getValue().toString());
                resultSetxt = preparedStatementxt.executeQuery();
                
                
                while(resultSetxt.next())
                {
                    Musteriad = resultSetxt.getString("MusteriIsmi");
                    MusteriIl = resultSetxt.getString("Il");
                    MusteriIlce = resultSetxt.getString("Ilce");
                    
                    
                }
                
            }
                catch(Exception e){
                        
                        }
          FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ManyetikMuayene_1.fxml"));
                        Parent ManyetikMuayeneParent = loader.load();
                        Scene ManyetikMuayeneScene = new Scene (ManyetikMuayeneParent);
                        ManyetikMuayeneController manyetikmuayenecontroller = loader.getController();
                        manyetikmuayenecontroller.getID(ID2,firstName1,lastName1,level);
                        manyetikmuayenecontroller.getInfo(RaporTarihiDatePicker.getValue().toString(),MuayeneTarihiDatePicker.getValue().toString(), RaporNumarasiTextField.getText());
                        manyetikmuayenecontroller.verilerial(Musteriad, MusteriIl,MusteriIlce, KutupMesafesi, Cihaz, MpTasiyiciOrtam, MiknatislamaTeknigi, UVIsikSiddeti, IsikMesafesi);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(ManyetikMuayeneScene);
                        window.show();  
                        
                       
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        ObservableList<Ekipman> ekipman = FXCollections.observableArrayList();
        Connection con= null;
        Statement statement = null;
        ResultSet ResultSet = null;
        
        try
        {
           con = DataBase.getConnection();
           statement = con.createStatement();
           String cihaz = null;
           ResultSet = statement.executeQuery("SELECT *FROM Ekipman");
           while (ResultSet.next())
           {
                Ekipman newEkipman = new Ekipman (ResultSet.getString("EkipmanNo"),
                                                             ResultSet.getString("Cihaz"),
                                                             ResultSet.getString("KutupMesafesi"),
                                                             ResultSet.getString("MpTasiyiciOrtam"),
                                                             ResultSet.getString("MiknatislamaTeknigi"),
                                                             ResultSet.getString("UVIsikSiddeti"),
                                                             ResultSet.getString("IsikMesafesi"));
                cihaz = ResultSet.getString("Cihaz");
                ekipmanchoicebox.getItems().add(cihaz);
                
                ekipman.add(newEkipman);
              
           }
           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        ObservableList<Firma> firma = FXCollections.observableArrayList();
        Connection con1= null;
        Statement statement1 = null;
        ResultSet ResultSet1 = null;
        
        try
        {
           con1 = DataBase.getConnection();
           statement1 = con1.createStatement();
           String MusteriIsmi = null;
           ResultSet1 = statement.executeQuery("SELECT *FROM Firma");
           while (ResultSet1.next())
           {
                Firma newFirma = new Firma (ResultSet1.getString("MusteriIsmi"),
                                                             ResultSet1.getString("Il"),
                                                             ResultSet1.getString("Ilce"),
                                                             ResultSet1.getString("IsEmriNumarasi"),
                                                             ResultSet1.getString("TeklifNo"));
                MusteriIsmi = ResultSet1.getString("MusteriIsmi");
                MusteriChoiceBox.getItems().add(MusteriIsmi);
                
                firma.add(newFirma);
              
           }
           
        }
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        
            
        
        
        
    }    
    
    
    
}
