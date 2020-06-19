// Onur Kanıt 170503026
package rapor;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
    
    @FXML private TextField RaporNumarasiTextField;
    @FXML private DatePicker RaporTarihiDatePicker;
    @FXML private DatePicker MuayeneTarihiDatePicker;
    @FXML private TextField personel;
    @FXML private ChoiceBox ekipmanchoicebox;
    String ID2 = null;
    String firstName1 = null;
    String lastName1 = null;
    public String getID(String ID,String firstName, String lastName){
        ID2 = ID;
        firstName1 = firstName;
        lastName1 = lastName;
        personel.setText(firstName1 + " "+ lastName1);
        return ID;
    }
    public void anaSayfayaDon(ActionEvent event) throws IOException
    {
        
        
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("MainPage.fxml"));
                        Parent MainPageParent = loader.load();
                        Scene MainPageScene = new Scene (MainPageParent);
                        MainPageController mainpagecontroller = loader.getController();
                        mainpagecontroller.getID(ID2,firstName1,lastName1);
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
                        mainpagecontroller.getID(ID2,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(MainPageScene);
                        window.show(); 
    }
        
        
    
    public void ManyetikMuayeneRaporuOlustur(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ManyetikMuayene.fxml"));
                        Parent ManyetikMuayeneParent = loader.load();
                        Scene ManyetikMuayeneScene = new Scene (ManyetikMuayeneParent);
                        ManyetikMuayeneController manyetikmuayenecontroller = loader.getController();
                        manyetikmuayenecontroller.getID(ID2,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(ManyetikMuayeneScene);
                        window.show(); 
    }
    
    public void ManyetikMuayeneRaporuOlustur_1(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ManyetikMuayene_1.fxml"));
                        Parent ManyetikMuayeneParent = loader.load();
                        Scene ManyetikMuayeneScene = new Scene (ManyetikMuayeneParent);
                        ManyetikMuayeneController manyetikmuayenecontroller = loader.getController();
                        manyetikmuayenecontroller.getID(ID2,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(ManyetikMuayeneScene);
                        window.show(); 
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
        
        
        
    }    
    
    
    
}
