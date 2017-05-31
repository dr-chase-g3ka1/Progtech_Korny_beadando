/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrunchargenproto_v0.pkg0;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.character.AbstractCharacter;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import view.character_sheet.CharacterSheetEditorStep1Controller;
import view.character_sheet.CharacterSheetEditorStep2Controller;
import view.character_sheet.CharacterSheetEditorStep3Controller;
import view.character_sheet.FirstMenuController;
import view.rootlayout.RootLayoutController;


/**
 *
 * @author Dr.Chase
 */
public class LaunchFXApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private AnchorPane FirstMenuAnchorPane;
    private AnchorPane CharEditorStep1AnchorPane;
    private AnchorPane CharEditorStep2AnchorPane;
    private AnchorPane CharEditorStep3AnchorPane;
    
    private FirstMenuController FirstMenuController;
    private CharacterSheetEditorStep1Controller CharEditorStep1Controller;
    private CharacterSheetEditorStep2Controller CharEditorStep2Controller;
    private CharacterSheetEditorStep3Controller CharEditorStep3Controller;
    
    private AbstractCharacter character;
    
    
    private static final Logger logger = LoggerFactory.getLogger(LaunchFXApp.class);

    public AnchorPane getFirstMenuAnchorPane() {
        return FirstMenuAnchorPane;
    }

    public void setFirstMenuAnchorPane(AnchorPane FirstMenuAnchorPane) {
        this.FirstMenuAnchorPane = FirstMenuAnchorPane;
    }

    public AnchorPane getCharEditorStep1AnchorPane() {
        return CharEditorStep1AnchorPane;
    }

    public void setCharEditorStep1AnchorPane(AnchorPane CharEditorStep1AnchorPane) {
        this.CharEditorStep1AnchorPane = CharEditorStep1AnchorPane;
    }

    public AnchorPane getCharEditorStep2AnchorPane() {
        return CharEditorStep2AnchorPane;
    }

    public void setCharEditorStep2AnchorPane(AnchorPane CharEditorStep2AnchorPane) {
        this.CharEditorStep2AnchorPane = CharEditorStep2AnchorPane;
    }

    public AnchorPane getCharEditorStep3AnchorPane() {
        return CharEditorStep3AnchorPane;
    }

    public void setCharEditorStep3AnchorPane(AnchorPane CharEditorStep3AnchorPane) {
        this.CharEditorStep3AnchorPane = CharEditorStep3AnchorPane;
    }

    public FirstMenuController getFirstMenuController() {
        return FirstMenuController;
    }

    public void setFirstMenuController(FirstMenuController FirstMenuController) {
        this.FirstMenuController = FirstMenuController;
    }

    public CharacterSheetEditorStep1Controller getCharEditorStep1Controller() {
        return CharEditorStep1Controller;
    }

    public void setCharEditorStep1Controller(CharacterSheetEditorStep1Controller CharEditorStep1Controller) {
        this.CharEditorStep1Controller = CharEditorStep1Controller;
    }

    public CharacterSheetEditorStep2Controller getCharEditorStep2Controller() {
        return CharEditorStep2Controller;
    }

    public void setCharEditorStep2Controller(CharacterSheetEditorStep2Controller CharEditorStep2Controller) {
        this.CharEditorStep2Controller = CharEditorStep2Controller;
    }

    public CharacterSheetEditorStep3Controller getCharEditorStep3Controller() {
        return CharEditorStep3Controller;
    }

    public void setCharEditorStep3Controller(CharacterSheetEditorStep3Controller CharEditorStep3Controller) {
        this.CharEditorStep3Controller = CharEditorStep3Controller;
    }
    
    
    
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            RootLayoutController rootLayoutController = loader.getController();
            
            rootLayoutController.setMainApp(this);

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
            this.FirstMenuAnchorPane = firstMenuView;
            //loader1.setRoot(this);

            // Set person overview into the center of root layout.
            rootLayout.setCenter(firstMenuView);
            
            // Give the controller1 access to the main app.
            // These 2 lines below belong to Tutorial 2.
            FirstMenuController firstMenuController = loader1.getController();
            this.FirstMenuController = firstMenuController;
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
        logger.info("Starting Charactergenerator...");
        
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

        
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
