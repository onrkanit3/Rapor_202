/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author izmir
 */
public class MainPageController implements Initializable {

    @FXML
    private Button calisanekle;
    
    @FXML
    private Button projeekle;
    
    @FXML
    private Button radyoaktifekle;
    
    @FXML
    private Button ekipmanekle;
    
    @FXML
    private Button firmaekle;
    
    @FXML
    private Button manyetikekle;
    
    @FXML
    private Button yuzeydurumuekle;
    
    public void calisanEkle(ActionEvent event) throws IOException
    {
        Parent CalisanEkleParent = FXMLLoader.load(getClass().getResource("CalisanEkle.fxml"));
        Scene CalisanEkleScene = new Scene(CalisanEkleParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(CalisanEkleScene);
        window.show();
    }
    
    public void YuzeyDurumuEkle(ActionEvent event) throws IOException
    {
        Parent YuzeyDurumuEkleParent = FXMLLoader.load(getClass().getResource("YuzeyDurumuEkle.fxml"));
        Scene YuzeyDurumuEkleScene = new Scene(YuzeyDurumuEkleParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(YuzeyDurumuEkleScene);
        window.show();
    }
    
    public void FirmaEkle(ActionEvent event) throws IOException
    {
        Parent FirmaEkleParent = FXMLLoader.load(getClass().getResource("Firma.fxml"));
        Scene FirmaEkleScene = new Scene(FirmaEkleParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(FirmaEkleScene);
        window.show();
    }
    
    public void ProjeEkle(ActionEvent event) throws IOException
    {
        Parent ProjeEkleParent = FXMLLoader.load(getClass().getResource("ProjeEkle.fxml"));
        Scene ProjeEkleScene = new Scene(ProjeEkleParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(ProjeEkleScene);
        window.show();
    }
    
    public void EkipmanEkle(ActionEvent event) throws IOException
    {
        Parent EkipmanEkleParent = FXMLLoader.load(getClass().getResource("EkipmanEkle.fxml"));
        Scene EkipmanEkleScene = new Scene(EkipmanEkleParent);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(EkipmanEkleScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
