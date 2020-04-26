/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author izmir
 */
public class YuzeyDurumuEkleController implements Initializable {
    
    @FXML private TableView<YuzeyDurumu> tableView01;
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
   
    public void newYuzeyDurumuButtonPushed()
    {
        YuzeyDurumu newYuzeyDurumu = new YuzeyDurumu(YuzeyDurumNumarasiTextField.getText(),YuzeyDurumuTextField.getText());
        tableView01.getItems().add(newYuzeyDurumu);
                
    } 
    
    public void changeYuzeyDurumNumarasiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        YuzeyDurumu YuzeyDurumuSelected =  tableView01.getSelectionModel().getSelectedItem();
        YuzeyDurumuSelected.setYuzeyDurumNumarasi(edittedCell.getNewValue().toString());
    }
    
    public void changeYuzeyDurumuCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        YuzeyDurumu YuzeyDurumuSelected =  tableView01.getSelectionModel().getSelectedItem();
        YuzeyDurumuSelected.setYuzeyDurumu(edittedCell.getNewValue().toString());
    }
    
    public void deleteButtonPushed()
    {
        ObservableList<YuzeyDurumu> selectedRows, allYuzeyDurumu;
        allYuzeyDurumu = tableView01.getItems();
        
        selectedRows = tableView01.getSelectionModel().getSelectedItems();
        
        for(YuzeyDurumu yuzeydurumu : selectedRows)
        {
            allYuzeyDurumu.removeAll(selectedRows);  
        }    
          
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        YuzeyDurumNumarasiColumn.setCellValueFactory(new PropertyValueFactory<YuzeyDurumu, String>("YuzeyDurumNumarasi"));
        YuzeyDurumuColumn.setCellValueFactory(new PropertyValueFactory<YuzeyDurumu, String>("YuzeyDurumu"));
        
       
        
        tableView01.setItems(getYuzeyDurumu());
        tableView01.setEditable(true);
        tableView01.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        YuzeyDurumNumarasiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        YuzeyDurumuColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }

    public ObservableList<YuzeyDurumu>  getYuzeyDurumu()
    {
        ObservableList<YuzeyDurumu> yuzey = FXCollections.observableArrayList();
        yuzey.add(new YuzeyDurumu("1","After Welding"));
        
        
        return yuzey;
    }
    
}
