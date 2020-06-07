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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import static rapor.Mitarbeiter.CheckUsernameExists;


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
    
    public void newFirmaButtonPushed() throws SQLException
    {
         Firma newFirma = new Firma(MusteriIsmiTextField.getText(),IlTextField.getText(),IlceTextField.getText(),IsEmriNumarasiTextField.getText(),TeklifNoTextField.getText());
         if(CheckUsernameExists(IsEmriNumarasiTextField.getText())==false)
        {
           tableView.getItems().add(newFirma);
           newFirma.InsertintoDATABASE();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                        "Bu İş Emri Numarası mevcut.\nLütfen farklı bir İş Emri Numarası deneyiniz.", 
                        ButtonType.CLOSE);
            
            Optional<ButtonType> result = alert.showAndWait();
                        
            
        }
                
      
    }        
        
    public void changeFirmaIsmiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setMusteriIsmi(edittedCell.getNewValue().toString());
        FirmaSelected.UpdateMusteriIsmi();
    }
    
    public void changeIlCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setIl(edittedCell.getNewValue().toString());
        FirmaSelected.UpdateIl();
    }
    
    public void changeIlceCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setIlce(edittedCell.getNewValue().toString());
        FirmaSelected.UpdateIlce();
        
    }
    
    
    public void changeTeklifNoCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException
    {
        Firma FirmaSelected =  tableView.getSelectionModel().getSelectedItem();
        FirmaSelected.setTeklifNo(edittedCell.getNewValue().toString());
        FirmaSelected.UpdateTeklifNo();
    }
    
    public void deleteButtonPushed() throws SQLException
    {
        ObservableList<Firma> selectedRows, allFirma;
        allFirma = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Firma firma : selectedRows)
        {
            allFirma.removeAll(selectedRows); 
            firma.DeleteFromDATABASE();
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
        MusteriIsmiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IlColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IlceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IsEmriNumarasiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TeklifNoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        try{
            LoadFirma();
        }
        
        catch(SQLException e){
            
            System.err.println(e.getMessage());
        }
       
    }
    public void LoadFirma() throws SQLException
    {
        
        ObservableList<Firma> firma = FXCollections.observableArrayList();
        Connection con= null;
        Statement statement = null;
        ResultSet ResultSet = null;
        
        try
        {
           con = DataBase.getConnection();
           statement = con.createStatement();
           ResultSet = statement.executeQuery("SELECT *FROM Firma");
           while (ResultSet.next())
           {
                Firma newFirma = new Firma (ResultSet.getString("MusteriIsmi"),
                                                             ResultSet.getString("Il"),
                                                             ResultSet.getString("Ilce"),
                                                             ResultSet.getString("IsEmriNumarasi"),
                                                             ResultSet.getString("TeklifNo"));
                                                             
               
                firma.add(newFirma);
              
           }
           tableView.getItems().addAll(firma);
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
    public ObservableList<Firma>  getFirma()
    {
        ObservableList<Firma> firma = FXCollections.observableArrayList();
        
        
        return firma;
    }
}    
    
