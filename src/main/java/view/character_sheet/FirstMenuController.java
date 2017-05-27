/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.character_sheet;

import controller.xml.savecharacter.XMLLoader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.character.AbstractCharacter;
import shadowrunchargenproto_v0.pkg0.LaunchFXApp;

/**
 * FXML Controller class
 *
 * @author Dr.Chase
 */
public class FirstMenuController {

    /**
     * Initializes the controller class.
     */
    private static void configureFileChooser(final FileChooser fileChooser){                           
        fileChooser.setTitle("Choose character xml");
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.dir"))
        ); 
    }
    
    LaunchFXApp mainApp;

    public LaunchFXApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(LaunchFXApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private Button CreateNewButton;
    
    @FXML
    private Button LoadButton;
    
    final FileChooser fileChooser = new FileChooser();
    
    @FXML
    private void onCreateNewButtonClicked() {
        showCharacterSheetEditorStep1();
    }
    
    private void showCharacterSheetEditorStep1() {
        try {
            // Load person overview.
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/fxml/CharacterSheetEditorStep1.fxml"));
            AnchorPane characterSheetEditorStep1 = (AnchorPane) loader1.load();
            
            CharacterSheetEditorStep1Controller controller1 = loader1.getController();
            controller1.setMainApp(mainApp);
            mainApp.getRootLayout().setCenter(characterSheetEditorStep1);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void showCharacterSheetEditorStep3(AbstractCharacter character)  {
        try {
            CharacterTransferHelper.transferCharacter = character;
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/CharacterSheetEditorStep3.fxml"));
            AnchorPane characterSheetEditorStep3 = (AnchorPane) loader.load();
            loader.setRoot(this);
            
            mainApp.setCharacter(character);
            CharacterSheetEditorStep3Controller controller = loader.getController();
            controller.setMainApp(mainApp);
//            controller.setCharacterSheetEditorStep1Controller(this);

            // Set person overview into the center of root layout.
            mainApp.getRootLayout().setCenter(characterSheetEditorStep3);
            
            // Give the controller access to the main app.
            // These 2 lines below belong to Tutorial 2.

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void onLoadButtonClicked() {
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (file != null) {
            CharacterTransferHelper.transferCharacter = XMLLoader.loadXMLFromFileAndPrint(file);
            showCharacterSheetEditorStep3(CharacterTransferHelper.transferCharacter);
        }
        
        
    }
    
    public void initialize() {
        // TODO
    }    
    
}
