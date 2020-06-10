// Onur Kanıt 170503026
package rapor;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import static rapor.Ekipman.CheckEkipmanNoExists;

/**
 * FXML Controller class
 *
 * @author izmir
 */
public class EkipmanEkleController implements Initializable 
{

    @FXML private TableView<Ekipman> tableView;
    @FXML private TableColumn<Ekipman, String> EkipmanNoColumn;
    @FXML private TableColumn<Ekipman, String> CihazColumn;
    @FXML private TableColumn<Ekipman, String> KutupMesafesiColumn;
    @FXML private TableColumn<Ekipman, String> MpTasiyiciOrtamColumn;
    @FXML private TableColumn<Ekipman, String> MiknatislamaTeknigiColumn;
    @FXML private TableColumn<Ekipman, String> UVIsikSiddetiColumn;
    @FXML private TableColumn<Ekipman, String> IsikMesafesiColumn;
    
    
    
    @FXML private TextField EkipmanNoTextField;
    @FXML private TextField CihazTextField;
    @FXML private TextField KutupMesafesiTextField;
    @FXML private TextField MpTasiyiciOrtamTextField;
    @FXML private TextField MiknatislamaTeknigiTextField;
    @FXML private TextField UVIsikSiddetiTextField;
    @FXML private TextField IsikMesafesiTextField;
    
    public void newEkipmanButtonPushed() throws SQLException
    {
        Ekipman newEkipman = new Ekipman(EkipmanNoTextField.getText(),CihazTextField.getText(),KutupMesafesiTextField.getText(),MpTasiyiciOrtamTextField.getText(),MiknatislamaTeknigiTextField.getText(),UVIsikSiddetiTextField.getText(),IsikMesafesiTextField.getText());
        if(CheckEkipmanNoExists(EkipmanNoTextField.getText())==false)
        {
           tableView.getItems().add(newEkipman);
           newEkipman.InsertintoDATABASE();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Bu Ekipman No mevcut.\nLütfen farklı bir Ekipman No deneyiniz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
                        
            
        }
        
                
    }
    
    
    
    public void changeCihazCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setCihaz(edittedCell.getNewValue().toString());
        EkipmanSelected.UpdateCihaz();
    }
    
    public void changeKutupMesafesiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setKutupMesafesi(edittedCell.getNewValue().toString());
        EkipmanSelected.UpdateKutupMesafesi();
    }
    
    public void changeMpTasiyiciOrtamCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setMpTasiyiciOrtam(edittedCell.getNewValue().toString());
        EkipmanSelected.UpdateMpTasiyiciOrtam();
    }
    
    public void changeMiknatislamaTeknigiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setMiknatislamaTeknigi(edittedCell.getNewValue().toString());
        EkipmanSelected.UpdateMiknatislamaTeknigi();
    }
    
    public void changeUVIsikSiddetiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setUVIsikSiddeti(edittedCell.getNewValue().toString());
        EkipmanSelected.UpdateUVIsikSiddeti();
    }
    
    public void changeIsikMesafesiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setIsikMesafesi(edittedCell.getNewValue().toString());
        EkipmanSelected.UpdateIsikMesafesi();
    }
    
     public void deleteButtonPushed() throws SQLException
    {
        ObservableList<Ekipman> selectedRows, allEkipman;
        allEkipman = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Ekipman ekipman : selectedRows)
        {
            allEkipman.removeAll(selectedRows); 
            ekipman.DeleteFromDATABASE();
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
    public void initialize(URL url, ResourceBundle rb) 
    {
        EkipmanNoColumn.setCellValueFactory(new PropertyValueFactory<Ekipman, String>("EkipmanNo"));
        CihazColumn.setCellValueFactory(new PropertyValueFactory<Ekipman, String>("Cihaz"));
        MpTasiyiciOrtamColumn.setCellValueFactory(new PropertyValueFactory<Ekipman, String>("MpTasiyiciOrtam"));
        KutupMesafesiColumn.setCellValueFactory(new PropertyValueFactory<Ekipman, String>("KutupMesafesi"));
        MiknatislamaTeknigiColumn.setCellValueFactory(new PropertyValueFactory<Ekipman, String>("MiknatislamaTeknigi"));
        UVIsikSiddetiColumn.setCellValueFactory(new PropertyValueFactory<Ekipman, String>("UVIsikSiddeti"));
        IsikMesafesiColumn.setCellValueFactory(new PropertyValueFactory<Ekipman, String>("IsikMesafesi"));
        
        tableView.setItems(getEkipman());
        tableView.setEditable(true);
        EkipmanNoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CihazColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        MpTasiyiciOrtamColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        KutupMesafesiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        MiknatislamaTeknigiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        UVIsikSiddetiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IsikMesafesiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        try{
            LoadEkipman();
        }
        
        catch(SQLException e){
            
            System.err.println(e.getMessage());
        }
    

    }  
    
    public void LoadEkipman() throws SQLException
    {
        
        ObservableList<Ekipman> ekipman = FXCollections.observableArrayList();
        Connection con= null;
        Statement statement = null;
        ResultSet ResultSet = null;
        
        try
        {
           con = DataBase.getConnection();
           statement = con.createStatement();
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
               
                ekipman.add(newEkipman);
              
           }
           tableView.getItems().addAll(ekipman);
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
    
        public ObservableList<Ekipman> getEkipman()
    {
        ObservableList<Ekipman> ekipman = FXCollections.observableArrayList();
        
        
        
        return ekipman;
    }
    
}