// Onur Kanıt 170503026
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
public class MainPageController implements Initializable 
{

    @FXML
    private Button calisanekle;
    
    @FXML
    private Button projeekle;
    
    
    @FXML
    private Button ekipmanekle;
    
    @FXML
    private Button firmaekle;
    
    @FXML
    private Button manyetikekle;
    
    @FXML
    private Button yuzeydurumuekle;
    
    String ID1 = null;
    String firstName1 = null;
    String lastName1 =null;
    
         
    
    public void calisanEkle(ActionEvent event) throws IOException
    {
       
        
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("CalisanEkle.fxml"));
                        Parent CalisanEkleParent = loader.load();
                        Scene CalisanEkleScene = new Scene (CalisanEkleParent);
                        CalisanEkleController calisaneklecontroller = loader.getController();
                        calisaneklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(CalisanEkleScene);
                        window.show(); 
    }
    
    public void YuzeyDurumuEkle(ActionEvent event) throws IOException
    {
        
        
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("YuzeyDurumuEkle.fxml"));
                        Parent YuzeyDurumuEkleParent = loader.load();
                        Scene YuzeyDurumuEkleScene = new Scene (YuzeyDurumuEkleParent);
                        YuzeyDurumuEkleController yuzeydurumueklecontroller = loader.getController();
                        yuzeydurumueklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(YuzeyDurumuEkleScene);
                        window.show(); 
    }
    
    public void YuzeyDurumuEkle1(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("YuzeyDurumuEkle_1.fxml"));
                        Parent YuzeyDurumuEkleParent = loader.load();
                        Scene YuzeyDurumuEkleScene = new Scene (YuzeyDurumuEkleParent);
                        YuzeyDurumuEkleController yuzeydurumueklecontroller = loader.getController();
                        yuzeydurumueklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(YuzeyDurumuEkleScene);
                        window.show(); 
    }
    
    public void YuzeyDurumuEkle11(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("YuzeyDurumuEkle_1_1.fxml"));
                        Parent YuzeyDurumuEkleParent = loader.load();
                        Scene YuzeyDurumuEkleScene = new Scene (YuzeyDurumuEkleParent);
                        YuzeyDurumuEkleController yuzeydurumueklecontroller = loader.getController();
                        yuzeydurumueklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(YuzeyDurumuEkleScene);
                        window.show(); 
    }
    
    public String getID(String ID, String firstName, String lastName){
        ID1 = ID;
        firstName1 = firstName;
        lastName1 = lastName;
        
        
        
        return ID+firstName+lastName;
    }
    
    public  void RaporEkle(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("RaporGiris.fxml"));
                        Parent RaporEkleParent = loader.load();
                        Scene RaporEkleScene = new Scene (RaporEkleParent);
                        RaporGirisController raporgiriscontroller = loader.getController();
                        raporgiriscontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(RaporEkleScene);
                        window.show(); 
       
    }
    
     public void RaporEkle11(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("RaporGiris_1.fxml"));
                        Parent RaporEkleParent = loader.load();
                        Scene RaporEkleScene = new Scene (RaporEkleParent);
                        RaporGirisController raporgiriscontroller = loader.getController();
                        raporgiriscontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(RaporEkleScene);
                        window.show(); 
    }
    
     
    public void FirmaEkle(ActionEvent event) throws IOException
    {
      
        
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Firma.fxml"));
                        Parent FirmaEkleParent = loader.load();
                        Scene FirmaEkleScene = new Scene (FirmaEkleParent);
                        FirmaController firmaeklecontroller = loader.getController();
                        firmaeklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(FirmaEkleScene);
                        window.show(); 
    }
    
    public void FirmaEkle1(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Firma_1.fxml"));
                        Parent FirmaEkleParent = loader.load();
                        Scene FirmaEkleScene = new Scene (FirmaEkleParent);
                        FirmaController firmaeklecontroller = loader.getController();
                        firmaeklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(FirmaEkleScene);
                        window.show(); 
    }
    
     public void FirmaEkle11(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Firma_1_1.fxml"));
                        Parent FirmaEkleParent = loader.load();
                        Scene FirmaEkleScene = new Scene (FirmaEkleParent);
                        FirmaController firmaeklecontroller = loader.getController();
                        firmaeklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(FirmaEkleScene);
                        window.show(); 
    }
    
    public void ProjeEkle(ActionEvent event) throws IOException
    {
        
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ProjeEkle.fxml"));
                        Parent ProjeEkleParent = loader.load();
                        Scene ProjeEkleScene = new Scene (ProjeEkleParent);
                        ProjeEkleController projeeklecontroller = loader.getController();
                        projeeklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(ProjeEkleScene);
                        window.show(); 
    }
    
    public void ProjeEkle1(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ProjeEkle_1.fxml"));
                        Parent ProjeEkleParent = loader.load();
                        Scene ProjeEkleScene = new Scene (ProjeEkleParent);
                        ProjeEkleController projeeklecontroller = loader.getController();
                        projeeklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(ProjeEkleScene);
                        window.show(); 
    }
    
     public void ProjeEkle11(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ProjeEkle_1_1.fxml"));
                        Parent ProjeEkleParent = loader.load();
                        Scene ProjeEkleScene = new Scene (ProjeEkleParent);
                        ProjeEkleController projeeklecontroller = loader.getController();
                        projeeklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(ProjeEkleScene);
                        window.show(); 
    }
    
    public void EkipmanEkle(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("EkipmanEkle.fxml"));
                        Parent EkipmanEkleParent = loader.load();
                        Scene EkipmanEkleScene = new Scene (EkipmanEkleParent);
                        EkipmanEkleController ekipmaneklecontroller = loader.getController();
                        ekipmaneklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(EkipmanEkleScene);
                        window.show(); 
    }
    
     public void EkipmanEkle1(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("EkipmanEkle_1.fxml"));
                        Parent EkipmanEkleParent = loader.load();
                        Scene EkipmanEkleScene = new Scene (EkipmanEkleParent);
                        EkipmanEkleController ekipmaneklecontroller = loader.getController();
                        ekipmaneklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(EkipmanEkleScene);
                        window.show(); 
    }
     
      public void EkipmanEkle2(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("EkipmanEkle_2.fxml"));
                        Parent EkipmanEkleParent = loader.load();
                        Scene EkipmanEkleScene = new Scene (EkipmanEkleParent);
                        EkipmanEkleController ekipmaneklecontroller = loader.getController();
                        ekipmaneklecontroller.getID(ID1,firstName1,lastName1);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(EkipmanEkleScene);
                        window.show(); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
