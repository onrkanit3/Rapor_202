// Onur Kanıt 170503026
package rapor;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    
    
    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException, SQLException
    {  
        if(username.getText().length()==0||password.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen tüm boş alanları doldurunuz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
            
            
        }
        else{
            
            Connection con = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try
            {
                
                con= DataBase.getConnection();
                String sql = "SELECT passw, salt FROM Mitarbeiter WHERE MitarbeiterID = ?"; 
                

                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, username.getText());
                resultSet = preparedStatement.executeQuery();
                String dbPassword = null;
                byte[] salt = null;
                while(resultSet.next())
                {
                    dbPassword = resultSet.getString("passw");

                    Blob blob = resultSet.getBlob("salt");

                    int blobLength = (int) blob.length();
                    salt = blob.getBytes(1, blobLength);
                    
                }
                
                String userPW = PasswordGenerator.getSHA512Password(password.getText(), salt);
                
                
                if(userPW.equals(dbPassword)){
                    
                    Parent MainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                    Scene MainPageScene = new Scene(MainPageParent);


                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                    window.setScene(MainPageScene);
                    window.show();
                    
                }else{
                    
                    Alert alert2 = new Alert(Alert.AlertType.WARNING, 
                                "Kullanıcı adı ya da şifre yanlış.", 
                                ButtonType.CLOSE);

                    Optional<ButtonType> result = alert2.showAndWait();
                    
                }
                



            }

            catch (NoSuchAlgorithmException e)
            {
                 
                    
                
                
            }
            
            catch (NullPointerException a){
                
                Alert alert2 = new Alert(Alert.AlertType.WARNING, 
                                "Kullanıcı adı ya da şifre yanlış.", 
                                ButtonType.CLOSE);

                    Optional<ButtonType> result = alert2.showAndWait();
                
            }

            
        }
        
        
    }
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    
    
}
