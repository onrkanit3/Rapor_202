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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import static rapor.Proje.CheckProjeNumarasiExists;

/**
 * FXML Controller class
 *
 * @author izmir
 */
public class ProjeEkleController implements Initializable 
{

    @FXML private TableView<Proje> tableView;
    @FXML private TableColumn<Proje, String> ProjeNumarasiColumn;
    @FXML private TableColumn<Proje, String> ProjeAdiColumn;
   
    
    @FXML private TextField ProjeNumarasiTextField;
    @FXML private TextField ProjeAdiTextField;
    
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
    
      public void anaSayfayaDonRaporsuzPersonelsiz(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("MainPage_1.fxml"));
                        Parent MainPageParent = loader.load();
                        Scene MainPageScene = new Scene (MainPageParent);
                        MainPageController mainpagecontroller = loader.getController();
                        mainpagecontroller.getID(ID2,firstName1,lastName1,level);
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
                        mainpagecontroller.getID(ID2,firstName1,lastName1,level);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(MainPageScene);
                        window.show(); 
    }
    
    public void newProjeButtonPushed() throws SQLException
    {
        if (ProjeNumarasiTextField.getText().length()==0 || ProjeAdiTextField.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen tüm boşlukları doldurunuz.",
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else if(CheckProjeNumarasiExists(ProjeNumarasiTextField.getText())==false){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Bu Proje Numarası mevcut.\nLütfen farklı bir Proje Numarası deneyiniz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else if(Proje.UzunlukKontrol(ProjeNumarasiTextField.getText(), ProjeAdiTextField.getText())==false){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen 25 haneden uzun girdi yapmayınız.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        
        else{
            Proje newProje = new Proje(ProjeNumarasiTextField.getText(),ProjeAdiTextField.getText());
            tableView.getItems().add(newProje);
            newProje.InsertintoDATABASE();
        }
                
    }
    
    public void changeProjeAdiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Proje ProjeSelected =  tableView.getSelectionModel().getSelectedItem();
        if(edittedCell.getNewValue().toString().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen tüm boşlukları doldurunuz.",
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        
        else if(edittedCell.getNewValue().toString().length()>25){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen 25 haneden uzun girdi yapmayınız.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else{
         ProjeSelected.setProjeAdi(edittedCell.getNewValue().toString());
         ProjeSelected.UpdateProjeAdi();   
        }
        
    }
    
    public void deleteButtonPushed() throws SQLException
    {
        ObservableList<Proje> selectedRows, allProje;
        allProje = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Proje proje : selectedRows)
        {
            allProje.removeAll(selectedRows);  
            proje.DeleteFromDATABASE();
        }    
          
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ProjeNumarasiColumn.setCellValueFactory(new PropertyValueFactory<Proje, String>("ProjeNumarasi"));
        ProjeAdiColumn.setCellValueFactory(new PropertyValueFactory<Proje, String>("ProjeAdi"));
        
       
        
        tableView.setItems(getProje());
        tableView.setEditable(true);
        ProjeNumarasiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ProjeAdiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        try{
            LoadProje();
        }
        
        catch(SQLException e){
            
            System.err.println(e.getMessage());
        }
    }
    
    
    public void LoadProje() throws SQLException
    {
        
        ObservableList<Proje> proje = FXCollections.observableArrayList();
        Connection con= null;
        Statement statement = null;
        ResultSet ResultSet = null;
        
        try
        {
           con = DataBase.getConnection();
           statement = con.createStatement();
           ResultSet = statement.executeQuery("SELECT *FROM Proje");
           while (ResultSet.next())
           {
                Proje newProje = new Proje (ResultSet.getString("ProjeNumarasi"),
                                                             ResultSet.getString("ProjeAdi"));
                                                           
               
                proje.add(newProje);
              
           }
           tableView.getItems().addAll(proje);
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

    public ObservableList<Proje>  getProje()
    {
        ObservableList<Proje> proje = FXCollections.observableArrayList();
        
        
        
        return proje;
    }
}    
    

