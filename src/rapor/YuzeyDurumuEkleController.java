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
import static rapor.YuzeyDurumu.CheckYuzeyDurumNumarasiExists;

/**
 * FXML Controller class
 *
 * @author izmir
 */
public class YuzeyDurumuEkleController implements Initializable {
    
    @FXML private TableView<YuzeyDurumu> tableView;
    @FXML private TableColumn<YuzeyDurumu, String> YuzeyDurumNumarasiColumn;
    @FXML private TableColumn<YuzeyDurumu, String> YuzeyDurumuColumn;
   
    
    @FXML private TextField YuzeyDurumNumarasiTextField;
    @FXML private TextField YuzeyDurumuTextField;
    
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
   
    public void newYuzeyDurumuButtonPushed() throws SQLException
    {
        if (YuzeyDurumNumarasiTextField.getText().length()==0 || YuzeyDurumuTextField.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen tüm boşlukları doldurunuz.",
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else if(CheckYuzeyDurumNumarasiExists(YuzeyDurumNumarasiTextField.getText())==false){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Bu Yuzey Durum Numarası mevcut.\nLütfen farklı bir Yuzey Durum Numarası deneyiniz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        else if(YuzeyDurumu.UzunlukKontrol(YuzeyDurumNumarasiTextField.getText(), YuzeyDurumuTextField.getText())==false){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Lütfen 25 haneden uzun girdi yapmayınız.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
        }
        
        else{
            YuzeyDurumu newYuzeyDurumu = new YuzeyDurumu(YuzeyDurumNumarasiTextField.getText(),YuzeyDurumuTextField.getText());
            tableView.getItems().add(newYuzeyDurumu);
            newYuzeyDurumu.InsertintoDATABASE();
        }
            
                        
          
                
    }

                
    
    
    public void changeYuzeyDurumuCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        YuzeyDurumu YuzeyDurumuSelected =  tableView.getSelectionModel().getSelectedItem();
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
            YuzeyDurumuSelected.setYuzeyDurumu(edittedCell.getNewValue().toString());
            YuzeyDurumuSelected.UpdateYuzeyDurumu();
        }
        
    }
    
    public void deleteButtonPushed() throws SQLException
    {
        ObservableList<YuzeyDurumu> selectedRows, allYuzeyDurumu;
        allYuzeyDurumu = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(YuzeyDurumu yuzeydurumu : selectedRows)
        {
            allYuzeyDurumu.removeAll(selectedRows); 
            yuzeydurumu.DeleteFromDATABASE();
        }    
          
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        YuzeyDurumNumarasiColumn.setCellValueFactory(new PropertyValueFactory<YuzeyDurumu, String>("YuzeyDurumNumarasi"));
        YuzeyDurumuColumn.setCellValueFactory(new PropertyValueFactory<YuzeyDurumu, String>("YuzeyDurumu"));
        
       
        
        tableView.setItems(getYuzeyDurumu());
        tableView.setEditable(true);
        YuzeyDurumNumarasiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        YuzeyDurumuColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        try{
            LoadYuzeyDurumu();
        }
        
        catch(SQLException e){
            
            System.err.println(e.getMessage());
        }
    }
    public void LoadYuzeyDurumu() throws SQLException
    {
        
        ObservableList<YuzeyDurumu> yuzeydurumu = FXCollections.observableArrayList();
        Connection con= null;
        Statement statement = null;
        ResultSet ResultSet = null;
        
        try
        {
           con = DataBase.getConnection();
           statement = con.createStatement();
           ResultSet = statement.executeQuery("SELECT *FROM YuzeyDurumu");
           while (ResultSet.next())
           {
                YuzeyDurumu newYuzeyDurumu = new YuzeyDurumu (ResultSet.getString("YuzeyDurumNumarasi"),
                                                             ResultSet.getString("YuzeyDurumu"));
                                                           
               
                yuzeydurumu.add(newYuzeyDurumu);
              
           }
           tableView.getItems().addAll(yuzeydurumu);
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


    public ObservableList<YuzeyDurumu>  getYuzeyDurumu()
    {
        ObservableList<YuzeyDurumu> yuzey = FXCollections.observableArrayList();
        
        
        return yuzey;
    }
    
}
