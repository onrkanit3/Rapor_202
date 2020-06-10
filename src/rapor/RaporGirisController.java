// Onur Kanıt 170503026
package rapor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void anaSayfayaDon(ActionEvent event) throws IOException
    {
        Parent MainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene MainPageScene = new Scene(MainPageParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MainPageScene);
        window.show();
    }
    
    public void ManyetikMuayeneRaporuOlustur(ActionEvent event) throws IOException
    {
        Parent ManyetikMuayeneRaporuOlusturParent = FXMLLoader.load(getClass().getResource("ManyetikMuayene.fxml"));
        Scene ManyetikMuayeneRaporuScene = new Scene(ManyetikMuayeneRaporuOlusturParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(ManyetikMuayeneRaporuScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
