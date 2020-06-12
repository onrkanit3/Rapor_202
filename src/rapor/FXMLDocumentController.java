// Onur Kanıt 170503026
package rapor;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
    
    private RaporGirisController otherController;
    
    
    
    
    
    
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
                String sql = "SELECT passw, salt,MitarbeiterID, lvl, sertifikatarihi, firstName, lastName FROM Mitarbeiter WHERE MitarbeiterID = ?"; 
                

                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, username.getText());
                resultSet = preparedStatement.executeQuery();
                String dbPassword = null;
                String dbID = null;
                Date DbSertifika = null;
                String dbLevel = null;
                String firstName = null;
                String lastName = null;
                byte[] salt = null;
                while(resultSet.next())
                {
                    dbPassword = resultSet.getString("passw");
                    dbID = resultSet.getString("MitarbeiterID");
                    DbSertifika = resultSet.getDate("sertifikatarihi");
                    dbLevel = resultSet.getString("lvl");
                    firstName = resultSet.getString("firstName");
                    lastName = resultSet.getString("lastName");
                    
                    
                    

                    Blob blob = resultSet.getBlob("salt");

                    int blobLength = (int) blob.length();
                    salt = blob.getBytes(1, blobLength);
                    
                }
                
                int i=Integer.parseInt(dbLevel);  
                
                LocalDate localDate = Instant.ofEpochMilli(DbSertifika.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                
                
                String userPW = PasswordGenerator.getSHA512Password(password.getText(), salt);
                
                
                if(userPW.equals(dbPassword)){
                    
                    if(dbID.equals("admin")){
                        
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("MainPage.fxml"));
                        Parent MainPageParent = loader.load();
                        Scene MainPageScene = new Scene (MainPageParent);
                        MainPageController mainpagecontroller = loader.getController();
                        mainpagecontroller.getID(dbID,firstName,lastName);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(MainPageScene);
                        window.show(); 
                    }
                    
                    else if(i<2 || localDate.isBefore(LocalDate.now())){
                        Alert alert2 = new Alert(Alert.AlertType.WARNING, 
                                "Bu kullanıcının personel işlemlerini yapmasına ve yetersiz level veya kalibrasyonu geçirilmiş sertifika tarihi nedeniyle forum oluşturmasına izin verilmez. ", 
                                ButtonType.CLOSE);

                        Optional<ButtonType> result = alert2.showAndWait();
                        
                        Parent MainPageParent = FXMLLoader.load(getClass().getResource("MainPage_1.fxml"));
                        Scene MainPageScene = new Scene(MainPageParent);


                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(MainPageScene);
                        window.show();
                        
                    }
                    
                    else{
                       Alert alert2 = new Alert(Alert.AlertType.WARNING, 
                                "Bu kullanıcının personel işlemlerini yapmasına izin verilmez. ", 
                                ButtonType.CLOSE);

                        Optional<ButtonType> result = alert2.showAndWait();
                        
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("MainPage_1_1.fxml"));
                        Parent MainPageParent = loader.load();
                        Scene MainPageScene = new Scene (MainPageParent);
                        MainPageController mainpagecontroller = loader.getController();
                        mainpagecontroller.getID(dbID,firstName,lastName);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(MainPageScene);
                        window.show(); 
                    }
                    
                   
                    
                    
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
            
            catch (Exception x){
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
