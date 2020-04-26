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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author izmir
 */
public class FXMLDocumentController implements Initializable
{
    
    @FXML
    private Label label;
    
    @FXML
    private ImageView deneme;
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Button login;
    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        Parent MainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene MainPageScene = new Scene(MainPageParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MainPageScene);
        window.show();
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    
    
}
