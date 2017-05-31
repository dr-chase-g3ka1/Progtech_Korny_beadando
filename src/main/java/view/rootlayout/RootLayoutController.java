/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.rootlayout;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import shadowrunchargenproto_v0.pkg0.LaunchFXApp;

/**
 * FXML Controller class
 *
 * @author Dr.Chase
 */
public class RootLayoutController {

    /**
     * Initializes the controller class.
     */
    
    LaunchFXApp mainApp;

    public LaunchFXApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(LaunchFXApp mainApp) {
        this.mainApp = mainApp;
    }
    
    
    @FXML
    MenuItem AboutMenuItem;
    
    @FXML
    MenuItem CloseMenuItem;
    
    
    
    
    public void initialize() {
        AboutMenuItem.setOnAction((event) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("About");
            alert.setHeaderText("Balla Tibi a kedvenc tanárom!");
            alert.setContentText("Imádom!");

            alert.showAndWait();
        });
        
        
        CloseMenuItem.setOnAction((event) -> {
            Platform.exit();
            System.exit(0);
        });
    }    
    
}
