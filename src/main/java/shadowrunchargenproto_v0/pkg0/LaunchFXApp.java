/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrunchargenproto_v0.pkg0;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.character.AbstractCharacter;
import view.character_sheet.CharacterSheetEditorStep1Controller;
import view.character_sheet.CharacterSheetEditorStep2Controller;
import view.character_sheet.FirstMenuController;


/**
 *
 * @author Dr.Chase
 */
public class LaunchFXApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private AbstractCharacter character;
    
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     //old one
    public void showCharacterSheetEditorStep1() {
        try {
            // Load person overview.
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/fxml/CharacterSheetEditorStep1.fxml"));
            AnchorPane characterSheetEditorStep1 = (AnchorPane) loader1.load();
            //loader1.setRoot(this);

            // Set person overview into the center of root layout.
            rootLayout.setCenter(characterSheetEditorStep1);
            
            // Give the controller1 access to the main app.
            // These 2 lines below belong to Tutorial 2.
            CharacterSheetEditorStep1Controller controller1 = loader1.getController();
            controller1.setMainApp(this);
            //controller1.
            
            // Giving access to this class' reference to all other controllers!
//            FXMLLoader loader2 = new FXMLLoader();
//            loader2.setLocation(LaunchFXApp.class.getResource("../../view/character_sheet/CharacterSheetEditorStep2.fxml"));
//            AnchorPane characterSheetEditorStep2 = (AnchorPane) loader2.load();
//            
//            CharacterSheetEditorStep2Controller controller2 = loader2.getController();
//            controller2.setMainApp(this);
//            
//            // hogy lássa egymást a két kép és tudjon adatot cserélni
//            controller1.setCharacterSheetEditorStep2Controller(controller2);
//            controller2.setCharacterSheetEditorStep1Controller(controller1);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showFirstMenu() {
        try {
            // Load person overview.
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/fxml/FirstMenu.fxml"));
            AnchorPane firstMenuView = (AnchorPane) loader1.load();
            //loader1.setRoot(this);

            // Set person overview into the center of root layout.
            rootLayout.setCenter(firstMenuView);
            
            // Give the controller1 access to the main app.
            // These 2 lines below belong to Tutorial 2.
            FirstMenuController firstMenuController = loader1.getController();
            firstMenuController.setMainApp(this);
            //controller1.
            
            // Giving access to this class' reference to all other controllers!
//            FXMLLoader loader2 = new FXMLLoader();
//            loader2.setLocation(LaunchFXApp.class.getResource("../../view/character_sheet/CharacterSheetEditorStep2.fxml"));
//            AnchorPane characterSheetEditorStep2 = (AnchorPane) loader2.load();
//            
//            CharacterSheetEditorStep2Controller controller2 = loader2.getController();
//            controller2.setMainApp(this);
//            
//            // hogy lássa egymást a két kép és tudjon adatot cserélni
//            controller1.setCharacterSheetEditorStep2Controller(controller2);
//            controller2.setCharacterSheetEditorStep1Controller(controller1);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ShadowRun character manager app");

        initRootLayout();

        showFirstMenu();
        //showCharacterSheetEditorStep1();
        
    }
    
    public static void main(String[] args)  {
        launch(args);
    }
    
    // setters and getters come here

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }
    
}
