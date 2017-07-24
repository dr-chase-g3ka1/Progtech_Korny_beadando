/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.character_sheet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import shadowrunchargenproto_v0.pkg0.LaunchFXApp;

/**
 * FXML Controller class
 *
 * @author Dr.Chase
 */
public class ManageActiveSkillsViewController  {

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
    
    Logger logger;

    void initialize() {
        
    }    
    
}
