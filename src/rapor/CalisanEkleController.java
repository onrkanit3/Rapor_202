// Onur Kanıt 170503026
package rapor;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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


public class CalisanEkleController implements Initializable
{
    
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
    @FXML private Button personelEkle;
    
    String ID2 = null;
    String firstName1 = null;
    String lastName1 = null;
    String level = null;
    public String getID(String ID,String firstName, String lastName, String lvl){
        ID2 = ID;
        firstName1 = firstName;
        lastName1 = lastName;
        level = lvl;
        
        return ID + firstName + lastName+ lvl;
    }
    

     
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy.MM.dd");
     
   
    public void newMitarbeiterButtonPushed() throws SQLException, NoSuchAlgorithmException
    {
        if(firstNameTextField.getText().length()==0 || lastNameTextField.getText().length()==0 || IDTextField.getText().length()==0 ||
           ŞifreTextField.getText().length()==0 || LevelTextField.getText().length()==0 || sertifikatarihiDatePicker.getValue()==null){
            Alert alert = new Alert(AlertType.WARNING, 
                        "Lütfen tüm boşlukları doldurunuz.",
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else if(Mitarbeiter.CheckUsernameExists(IDTextField.getText())==false){
            Alert alert = new Alert(AlertType.WARNING, 
                        "Bu ID başkası tarafından kullanılıyor.\nLütfen farklı bir ID deneyiniz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        
        else if(Mitarbeiter.sifreUzunlukKontrol(ŞifreTextField.getText())==false){
            Alert alert = new Alert(AlertType.WARNING, 
                        "Şifre 6 haneden kısa 30 haneden uzun olamaz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
            
        }
        
        else if(Mitarbeiter.UzunlukKontrol(firstNameTextField.getText(),lastNameTextField.getText(),IDTextField.getText())==false){
            Alert alert = new Alert(AlertType.WARNING, 
                        "İsim, soyisim ve ID 30 haneden uzun olamaz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
            
        }
        
        else if(Mitarbeiter.LevelKontrol(LevelTextField.getText())==false){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen Level için aşağıdakilerden birini giriniz ve sadece rakam girişi yapınız: \n"
                                + "1, 2, 3", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
            
        }
        
        else if(Mitarbeiter.DateControl(sertifikatarihiDatePicker.getValue())==false){
            Alert alert = new Alert(AlertType.WARNING, 
                        "Lütfen geçerli bir sertifika tarihi giriniz. ", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
            
        }
        
        else{
             Mitarbeiter newMitarbeiter = new Mitarbeiter(firstNameTextField.getText(),lastNameTextField.getText(),IDTextField.getText(),ŞifreTextField.getText(),LevelTextField.getText(),sertifikatarihiDatePicker.getValue());
             tableView.getItems().add(newMitarbeiter);
             newMitarbeiter.InsertintoDATABASE();
            
        }
            
        
    }
        
        
                 
    
    
    public void changeSertifikaTarihi(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            Mitarbeiter MitarbeiterSelected = tableView.getSelectionModel().getSelectedItem();
            String date = edittedCell.getNewValue().toString();
            LocalDate localDate = LocalDate.parse(date, formatter);
            if(edittedCell.getNewValue().toString().length()==0){
                Alert alert = new Alert(Alert.AlertType.WARNING, 
                            "Lütfen tüm boşlukları doldurunuz.",
                            ButtonType.CLOSE);

                Optional<ButtonType> result = alert.showAndWait();
            }
            else if(Mitarbeiter.DateControl(localDate)==false){
                Alert alert = new Alert(AlertType.WARNING, 
                            "Lütfen geçerli bir sertifika tarihi giriniz. ", 
                            ButtonType.CLOSE);

                Optional<ButtonType> result = alert.showAndWait();
            }
            else{

                MitarbeiterSelected.setSertifikatarihi(localDate);
                MitarbeiterSelected.UpdateSertifikaTarihi(); 
            }
        }
        
        
        catch(DateTimeParseException e){
            Alert alert = new Alert(AlertType.WARNING, 
                            "Lütfen sertifika tarihini doğru formatta giriniz. GG.AA.YYYY ", 
                            ButtonType.CLOSE);

                Optional<ButtonType> result = alert.showAndWait();
        }
        
        catch(Exception e){
                Alert alert = new Alert(AlertType.WARNING, 
                            "Lütfen geçerli bir sertifika tarihi giriniz. ", 
                            ButtonType.CLOSE);

                Optional<ButtonType> result = alert.showAndWait();
            
        }
        
       
    }
    
    
        
    public void changeFirstNameCellEvent(CellEditEvent edittedCell) throws SQLException
    {
        Mitarbeiter MitarbeiterSelected =  tableView.getSelectionModel().getSelectedItem();
        if(edittedCell.getNewValue().toString().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen tüm boşlukları doldurunuz.",
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        
        else if(edittedCell.getNewValue().toString().length()>30){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen 30 haneden uzun girdi yapmayınız.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else{
          MitarbeiterSelected.setFirstName(edittedCell.getNewValue().toString());
          MitarbeiterSelected.UpdateFirstName();  
        }
        
    }
    
     public void changeLastNameCellEvent(CellEditEvent edittedCell) throws SQLException
    {
        Mitarbeiter MitarbeiterSelected =  tableView.getSelectionModel().getSelectedItem();
        if(edittedCell.getNewValue().toString().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen tüm boşlukları doldurunuz.",
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        
        else if(edittedCell.getNewValue().toString().length()>30){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen 30 haneden uzun girdi yapmayınız.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else{
            MitarbeiterSelected.setLastName(edittedCell.getNewValue().toString());
            MitarbeiterSelected.UpdateLastName();    
        }
        
    }
     
    
    
      public void changePasswordCellEvent(CellEditEvent edittedCell) throws SQLException
    {
        Mitarbeiter MitarbeiterSelected =  tableView.getSelectionModel().getSelectedItem();
        if(edittedCell.getNewValue().toString().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen tüm boşlukları doldurunuz.",
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        
        else if(edittedCell.getNewValue().toString().length()>30||edittedCell.getNewValue().toString().length()<5){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen 25 haneden uzun ve 5 haneden kısa girdi yapmayınız.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else{
         MitarbeiterSelected.setPassword(edittedCell.getNewValue().toString());
         MitarbeiterSelected.UpdatePassword();   
        }
        
    }
      
      
    
      public void changeLevelCellEvent(CellEditEvent edittedCell) throws SQLException
    {
        Mitarbeiter MitarbeiterSelected =  tableView.getSelectionModel().getSelectedItem();
        if(edittedCell.getNewValue().toString().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen tüm boşlukları doldurunuz.",
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        
        else if(Mitarbeiter.LevelKontrol(edittedCell.getNewValue().toString())==false){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen Level için aşağıdakilerden birini giriniz ve sadece rakam girişi yapınız: \n"
                                + "1, 2, 3", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
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
   
   public void excelButtonPushed(){
       
   }
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("lastName"));
        IDColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("ID"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("password"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("level"));
        sertifikatarihiColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, LocalDate>("sertifikatarihi"));
       
        
        tableView.setItems(getPeople());
        tableView.setEditable(true);
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
    
    public void LoadMitarbeiter() throws SQLException
    {
        
        ObservableList<Mitarbeiter> mitarbeiter = FXCollections.observableArrayList();
        Connection con= null;
        Statement statement = null;
        ResultSet ResultSet = null;
        
        try
        {
           con = DataBase.getConnection();
           statement = con.createStatement();
           ResultSet = statement.executeQuery("SELECT *FROM Mitarbeiter");
           while (ResultSet.next())
           {
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
        
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally 
        {
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
    

