package rapor;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

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
    @FXML private TableColumn<Mitarbeiter, LocalDate> sertifikatarihiColumn;
    
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField IDTextField;
    @FXML private TextField ŞifreTextField;
    @FXML private TextField LevelTextField;
    @FXML private DatePicker sertifikatarihiDatePicker;

     
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy.MM.dd");
     
        public  String merhaba(LocalDate date) {
        return date == null ? null : date.format(DATE_FORMAT);
    }
    public void newMitarbeiterButtonPushed() throws SQLException
    {
        Mitarbeiter newMitarbeiter = new Mitarbeiter(firstNameTextField.getText(),lastNameTextField.getText(),IDTextField.getText(),ŞifreTextField.getText(),LevelTextField.getText(),sertifikatarihiDatePicker.getValue());
        tableView.getItems().add(newMitarbeiter);
        newMitarbeiter.InsertintoDATABASE();
                 
    }
    
    public void changeSertifikaTarihi(TableColumn.CellEditEvent edittedCell) throws SQLException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        Mitarbeiter MitarbeiterSelected = tableView.getSelectionModel().getSelectedItem();
        String date = edittedCell.getNewValue().toString();
        LocalDate localDate = LocalDate.parse(date, formatter);
        MitarbeiterSelected.setSertifikatarihi(localDate);
        MitarbeiterSelected.UpdateSertifikaTarihi();
    }
        
    public void changeFirstNameCellEvent(CellEditEvent edittedCell) throws SQLException
    {
        Mitarbeiter MitarbeiterSelected =  tableView.getSelectionModel().getSelectedItem();
        MitarbeiterSelected.setFirstName(edittedCell.getNewValue().toString());
        MitarbeiterSelected.UpdateFirstName();
    }
    
     public void changeLastNameCellEvent(CellEditEvent edittedCell) throws SQLException
    {
        Mitarbeiter MitarbeiterSelected =  tableView.getSelectionModel().getSelectedItem();
        MitarbeiterSelected.setLastName(edittedCell.getNewValue().toString());
        MitarbeiterSelected.UpdateLastName();
    }
     
    
    
      public void changePasswordCellEvent(CellEditEvent edittedCell) throws SQLException
    {
        Mitarbeiter MitarbeiterSelected =  tableView.getSelectionModel().getSelectedItem();
        MitarbeiterSelected.setPassword(edittedCell.getNewValue().toString());
        MitarbeiterSelected.UpdatePassword();
    }
      
      
    
      public void changeLevelCellEvent(CellEditEvent edittedCell) throws SQLException
    {
        Mitarbeiter MitarbeiterSelected =  tableView.getSelectionModel().getSelectedItem();
        MitarbeiterSelected.setLevel(edittedCell.getNewValue().toString());
        MitarbeiterSelected.UpdateLevel();
    }
      
      public void deleteButtonPushed() throws SQLException
    {
        ObservableList<Mitarbeiter> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Mitarbeiter mitarbeiter : selectedRows)
        {
            allPeople.removeAll(selectedRows);
            mitarbeiter.DeleteFromDATABASE();
        }    
          
    }          
      
    
    
    

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
        sertifikatarihiColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, LocalDate>("sertifikatarihi"));
       
        
        tableView.setItems(getPeople());
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IDColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        levelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IDColumn.setEditable(false);
        LocalDateStringConverter converter = new LocalDateStringConverter();
        sertifikatarihiColumn.setCellFactory(TextFieldTableCell.<Mitarbeiter, LocalDate>forTableColumn(converter));
        
        try{
            LoadMitarbeiter();
        }
        
        catch(SQLException e){
            
            System.err.println(e.getMessage());
        }
       
    }
    
    public void LoadMitarbeiter() throws SQLException{
        
        ObservableList<Mitarbeiter> mitarbeiter = FXCollections.observableArrayList();
        Connection con= null;
        Statement statement = null;
        ResultSet ResultSet = null;
        
        try {
           con = DataBase.getConnection();
           statement = con.createStatement();
           ResultSet = statement.executeQuery("SELECT *FROM Mitarbeiter");
           while (ResultSet.next()){
               Mitarbeiter newMitarbeiter = new Mitarbeiter (ResultSet.getString("firstName"),
                                                             ResultSet.getString("lastName"),
                                                             ResultSet.getString("MitarbeiterID"),
                                                             ResultSet.getString("passw"),
                                                             ResultSet.getString("lvl"),
                                                             ResultSet.getDate("sertifikatarihi").toLocalDate());
               
              mitarbeiter.add(newMitarbeiter);
              
           }
           tableView.getItems().addAll(mitarbeiter);
        }
        
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        finally {
            if(con != null)
               con.close();
            if(statement != null)
               statement.close();
            if(ResultSet != null)
                ResultSet.close(); 
        }
    }
    public ObservableList<Mitarbeiter>  getPeople()
    {
        ObservableList<Mitarbeiter> people = FXCollections.observableArrayList();
        
        
        return people;
    }
}
    

