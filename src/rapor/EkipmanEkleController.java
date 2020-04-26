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
    
    public void newEkipmanButtonPushed()
    {
        Ekipman newEkipman = new Ekipman(EkipmanNoTextField.getText(),CihazTextField.getText(),KutupMesafesiTextField.getText(),MpTasiyiciOrtamTextField.getText(),MiknatislamaTeknigiTextField.getText(),UVIsikSiddetiTextField.getText(),IsikMesafesiTextField.getText());
        tableView.getItems().add(newEkipman);
                
    }
    
    public void changeEkipmanNoCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setEkipmanNo(edittedCell.getNewValue().toString());
    }
    
    public void changeCihazCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setCihaz(edittedCell.getNewValue().toString());
    }
    
    public void changeKutupMesafesiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setKutupMesafesi(edittedCell.getNewValue().toString());
    }
    
    public void changeMpTasiyiciOrtamCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setMpTasiyiciOrtam(edittedCell.getNewValue().toString());
    }
    
    public void changeMiknatislamaTeknigiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setMiknatislamaTeknigi(edittedCell.getNewValue().toString());
    }
    
    public void changeUVIsikSiddetiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setUVIsikSiddeti(edittedCell.getNewValue().toString());
    }
    
    public void changeIsikMesafesiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Ekipman EkipmanSelected =  tableView.getSelectionModel().getSelectedItem();
        EkipmanSelected.setIsikMesafesi(edittedCell.getNewValue().toString());
    }
    
     public void deleteButtonPushed()
    {
        ObservableList<Ekipman> selectedRows, allEkipman;
        allEkipman = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Ekipman ekipman : selectedRows)
        {
            allEkipman.removeAll(selectedRows);  
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
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        EkipmanNoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CihazColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        MpTasiyiciOrtamColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        KutupMesafesiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        MiknatislamaTeknigiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        UVIsikSiddetiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IsikMesafesiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
    

    }  
    
        public ObservableList<Ekipman> getEkipman()
    {
        ObservableList<Ekipman> ekipman = FXCollections.observableArrayList();
        ekipman.add(new Ekipman("1","NAWOO Sn:1701020","100 mm","BT-20 LOT:B036P01  BT-10 LOT:B083P01","","W/m2","mm"));
        
        
        return ekipman;
    }
    
}
