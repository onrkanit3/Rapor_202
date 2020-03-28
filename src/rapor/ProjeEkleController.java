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
public class ProjeEkleController implements Initializable {

    @FXML private TableView<Proje> tableView;
    @FXML private TableColumn<Proje, String> ProjeNumarasiColumn;
    @FXML private TableColumn<Proje, String> ProjeAdiColumn;
   
    
    @FXML private TextField ProjeNumarasiTextField;
    @FXML private TextField ProjeAdiTextField;
    
    public void anaSayfayaDon(ActionEvent event) throws IOException
    {
        Parent MainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene MainPageScene = new Scene(MainPageParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MainPageScene);
        window.show();
    }
    
    public void newProjeButtonPushed()
    {
        Proje newProje = new Proje(ProjeNumarasiTextField.getText(),ProjeAdiTextField.getText());
        tableView.getItems().add(newProje);
                
    }
    
    public void changeProjeNumarasiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Proje ProjeSelected =  tableView.getSelectionModel().getSelectedItem();
        ProjeSelected.setProjeNumarasi(edittedCell.getNewValue().toString());
    }
    
    public void changeProjeAdiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Proje ProjeSelected =  tableView.getSelectionModel().getSelectedItem();
        ProjeSelected.setProjeAdi(edittedCell.getNewValue().toString());
    }
    
    public void deleteButtonPushed()
    {
        ObservableList<Proje> selectedRows, allProje;
        allProje = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Proje proje : selectedRows)
        {
            allProje.removeAll(selectedRows);  
        }    
          
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProjeNumarasiColumn.setCellValueFactory(new PropertyValueFactory<Proje, String>("ProjeNumarasi"));
        ProjeAdiColumn.setCellValueFactory(new PropertyValueFactory<Proje, String>("ProjeAdi"));
        
       
        
        tableView.setItems(getProje());
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ProjeNumarasiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ProjeAdiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }

    public ObservableList<Proje>  getProje()
    {
        ObservableList<Proje> proje = FXCollections.observableArrayList();
        proje.add(new Proje("1","Kaynakçı Testi"));
        
        
        return proje;
    }
    }    
    

