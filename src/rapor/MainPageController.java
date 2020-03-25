/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author izmir
 */
public class MainPageController implements Initializable {

    @FXML
    private Button calisanekle;
    
    @FXML
    private Button projeekle;
    
    @FXML
    private Button radyoaktifekle;
    
    @FXML
    private Button ekipmanekle;
    
    @FXML
    private Button firmaekle;
    
    @FXML
    private Button manyetikekle;
    
    public void calisanEkle(ActionEvent event) throws IOException
    {
        Parent CalisanEkleParent = FXMLLoader.load(getClass().getResource("CalisanEkle.fxml"));
        Scene CalisanEkleScene = new Scene(CalisanEkleParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(CalisanEkleScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
