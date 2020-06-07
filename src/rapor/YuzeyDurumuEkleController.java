/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    

   public void anaSayfayaDon(ActionEvent event) throws IOException
    {
        Parent MainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene MainPageScene = new Scene(MainPageParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MainPageScene);
        window.show();
    }
   
    public void newYuzeyDurumuButtonPushed() throws SQLException
    {
        YuzeyDurumu newYuzeyDurumu = new YuzeyDurumu(YuzeyDurumNumarasiTextField.getText(),YuzeyDurumuTextField.getText());
        if(CheckYuzeyDurumNumarasiExists(YuzeyDurumNumarasiTextField.getText())==false)
        {
           tableView.getItems().add(newYuzeyDurumu);
           newYuzeyDurumu.InsertintoDATABASE();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Bu Yuzey Durum Numarası mevcut.\nLütfen farklı bir Yuzey Durum Numarası deneyiniz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
                        
            
        }
                
    }

                
    
    
    public void changeYuzeyDurumuCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        YuzeyDurumu YuzeyDurumuSelected =  tableView.getSelectionModel().getSelectedItem();
        YuzeyDurumuSelected.setYuzeyDurumu(edittedCell.getNewValue().toString());
        YuzeyDurumuSelected.UpdateYuzeyDurumu();
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
