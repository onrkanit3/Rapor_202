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
public class FirmaController implements Initializable 
{

    @FXML private TableView<Firma> tableView;
    @FXML private TableColumn<Firma, String> MusteriIsmiColumn;
    @FXML private TableColumn<Firma, String> IlColumn;
    @FXML private TableColumn<Firma, String> IlceColumn;
    @FXML private TableColumn<Firma, String> IsEmriNumarasiColumn;  
    @FXML private TableColumn<Firma, String> TeklifNoColumn;
    
    
    @FXML private TextField MusteriIsmiTextField;
    @FXML private TextField IlTextField;
    @FXML private TextField IlceTextField;
    @FXML private TextField IsEmriNumarasiTextField;
    @FXML private TextField TeklifNoTextField;
    
    public void anaSayfayaDon(ActionEvent event) throws IOException
    {
        Parent MainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene MainPageScene = new Scene(MainPageParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MainPageScene);
        window.show();
    }
    
    public void newFirmaButtonPushed()
    {
         Firma newFirma = new Firma(MusteriIsmiTextField.getText(),IlTextField.getText(),IlceTextField.getText(),IsEmriNumarasiTextField.getText(),TeklifNoTextField.getText());
         tableView.getItems().add(newFirma);
                
    }        
        
    public void changeFirmaIsmiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setMusteriIsmi(edittedCell.getNewValue().toString());
    }
    
    public void changeIlCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setIl(edittedCell.getNewValue().toString());
    }
    
    public void changeIlceCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setIlce(edittedCell.getNewValue().toString());
    }
    
    public void changeIsEmriNumarasiiCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setIsEmriNumarasi(edittedCell.getNewValue().toString());
    }
    
    public void changeTeklifNoCellEvent(TableColumn.CellEditEvent edittedCell)
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setTeklifNo(edittedCell.getNewValue().toString());
    }
    
    public void deleteButtonPushed()
    {
        ObservableList<Firma> selectedRows, allFirma;
        allFirma = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Firma firma : selectedRows)
        {
            allFirma.removeAll(selectedRows);  
        }    
          
    }     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MusteriIsmiColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("MusteriIsmi"));
        IlColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("Il"));
        IlceColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("Ilce"));
        IsEmriNumarasiColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("IsEmriNumarasi"));
        TeklifNoColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("TeklifNo"));
        


       
        
        tableView.setItems(getFirma());
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        MusteriIsmiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IlColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IlceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IsEmriNumarasiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TeklifNoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       
    }
    public ObservableList<Firma>  getFirma()
    {
        ObservableList<Firma> firma = FXCollections.observableArrayList();
        firma.add(new Firma("TAG GEMİ","İZMİT","İZMİT","2604","330-2018"));
        
        
        return firma;
    }
}    
    
