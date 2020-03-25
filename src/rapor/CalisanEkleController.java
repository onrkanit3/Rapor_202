package rapor;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author izmir
 */
public class CalisanEkleController implements Initializable {
    
    @FXML private TableView<Mitarbeiter> tableView;
    @FXML private TableColumn<Mitarbeiter, String> firstNameColumn;
    @FXML private TableColumn<Mitarbeiter, String> lastNameColumn;
    @FXML private TableColumn<Mitarbeiter, String> IDColumn;
    @FXML private TableColumn<Mitarbeiter, String> passwordColumn;  
    @FXML private TableColumn<Mitarbeiter, String> levelColumn;
    
    
    

   public void anaSayfayaDon(ActionEvent event) throws IOException
    {
        Parent MainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene MainPageScene = new Scene(MainPageParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MainPageScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("lastName"));
        IDColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("ID"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("password"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("level"));
        
        
        tableView.setItems(getPeople());

    }
    public ObservableList<Mitarbeiter>  getPeople()
    {
        ObservableList<Mitarbeiter> people = FXCollections.observableArrayList();
        people.add(new Mitarbeiter("Onur","Kanit","onrkanit3","123Onur123+","Level2"));
        
        
        return people;
    }
}
    

