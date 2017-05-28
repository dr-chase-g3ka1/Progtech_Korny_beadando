/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.character_sheet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.character.AbstractCharacter;
import controller.character.helpers.StartingAttributesHelper;
import shadowrunchargenproto_v0.pkg0.LaunchFXApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Dr.Chase
 */
public class CharacterSheetEditorStep2Controller {
    
    /**
     * Initializes the controller class.
     */
    public CharacterSheetEditorStep2Controller() {  }
    
    private AbstractCharacter character;
    
    private CharacterSheetEditorStep1Controller characterSheetEditorStep1Controller;

    public CharacterSheetEditorStep1Controller getCharacterSheetEditorStep1Controller() {
        return characterSheetEditorStep1Controller;
    }

    public void setCharacterSheetEditorStep1Controller(CharacterSheetEditorStep1Controller characterSheetEditorStep1Controller) {
        this.characterSheetEditorStep1Controller = characterSheetEditorStep1Controller;
    }
    
    

    public AbstractCharacter getMyCharacter() {
        return character;
    }

    public void setMyCharacter(AbstractCharacter myCharacter) {
        this.character = myCharacter;
    }
    
    LaunchFXApp mainApp;
    
    public void setMainApp(LaunchFXApp mainApp) {
        this.mainApp = mainApp;
    }

    public LaunchFXApp getMainApp() {
        return mainApp;
    }
    
    Logger logger;
    
    @FXML
    private Button BodyAdderButton;
    @FXML
    private Button AgilityAdderButton;
    @FXML
    private Button StrengthAdderButton;
    @FXML
    private Button CharismaAdderButton;
    @FXML
    private Button IntelligenceAdderButton;
    @FXML
    private Button WillAdderButton;
    
    @FXML
    private Button BodyDividerButton;
    @FXML
    private Button AgilityDividerButton;
    @FXML
    private Button StrengthDividerButton;
    @FXML
    private Button CharismaDividerButton;
    @FXML
    private Button IntelligenceDividerButton;
    @FXML
    private Button WillDividerButton;
    
    @FXML
    private Button FinalizeButton;
    @FXML
    private Button NextButton;
    
    @FXML
    private Label BodyBaseLabel;
    @FXML
    private Label AgilityBaseLabel;
    @FXML
    private Label StrengthBaseLabel;
    @FXML
    private Label CharismaBaseLabel;
    @FXML
    private Label IntelligenceBaseLabel;
    @FXML
    private Label WillBaseLabel;
    

    @FXML
    private Label BodyCalculatedLabel;
    @FXML
    private Label AgilityCalculatedLabel;
    @FXML
    private Label StrengthCalculatedLabel;
    @FXML
    private Label CharismaCalculatedLabel;
    @FXML
    private Label IntelligenceCalculatedLabel;
    @FXML
    private Label WillCalculatedLabel;
    
    @FXML
    private Label WarningLabel;
    
    @FXML
    private Label DistributableAttributesLabel;
    
    private Integer nMaxAttributesOfChar;
    
    private void InitializeMaxAttrs ()  {
        nMaxAttributesOfChar = StartingAttributesHelper.getMaxAttributesFromCharacter(character);
    }
    
    private void InitializeBaseLabels() {
        BodyBaseLabel.setText("0");
        AgilityBaseLabel.setText("0");
        StrengthBaseLabel.setText("0");
        CharismaBaseLabel.setText("0");
        IntelligenceBaseLabel.setText("0"); 
        WillBaseLabel.setText("0");
        
        WarningLabel.setText("");
    }
    
    private void InitializeDistributableAttributesLabel()   {
        DistributableAttributesLabel.setText(nMaxAttributesOfChar.toString());
    }
    
    private void GeneralAdderFunction( Label baseLabel) {
        if(    Integer.parseUnsignedInt(baseLabel.getText()) < 6 && 
               Integer.parseUnsignedInt(DistributableAttributesLabel.getText()) > 0
           )   
        {
            Integer nTempFromTF = Integer.parseUnsignedInt(baseLabel.getText());
            nTempFromTF++;
            Integer nTempFromDistributable = Integer.parseUnsignedInt(DistributableAttributesLabel.getText());
            nTempFromDistributable--;
            baseLabel.setText(nTempFromTF.toString());
            DistributableAttributesLabel.setText(nTempFromDistributable.toString());
            logger.info("+1 added to a label");
        }
    }
    
    private void GeneralSubstractFunction( Label baseLabel) {
        if(    Integer.parseUnsignedInt(baseLabel.getText()) > 0 && 
               Integer.parseUnsignedInt(DistributableAttributesLabel.getText()) < nMaxAttributesOfChar //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
           )   
        {
            Integer nTempFromTF = Integer.parseUnsignedInt(baseLabel.getText());
            nTempFromTF--;
            Integer nTempFromDistributable = Integer.parseUnsignedInt(DistributableAttributesLabel.getText());
            nTempFromDistributable++;
            baseLabel.setText(nTempFromTF.toString());
            DistributableAttributesLabel.setText(nTempFromDistributable.toString());
            logger.info("-1 substracted from a label");
        }
    }
    
    @FXML
    private void onBodyAddButtonPressed(ActionEvent event)   {
        GeneralAdderFunction(BodyBaseLabel);
    }
    
    @FXML
    private void onAgilityAddButtonPressed()   {
        GeneralAdderFunction(AgilityBaseLabel);
    }
    
    @FXML
    private void onStrengthAddButtonPressed()   {
        GeneralAdderFunction(StrengthBaseLabel);
    }
    
    @FXML
    private void onCharismaAddButtonPressed()   {
        GeneralAdderFunction(CharismaBaseLabel);
    }
    
    @FXML
    private void onIntelligenceAddButtonPressed()   {
        GeneralAdderFunction(IntelligenceBaseLabel);
    }
    
    @FXML
    private void onWillAddButtonPressed()   {
        GeneralAdderFunction(WillBaseLabel);
    }
    ////////////////////////////////////
    @FXML
    private void onBodyDivideButtonPressed()   {
        GeneralSubstractFunction(BodyBaseLabel);
    }
    
    @FXML
    private void onAgilityDivideButtonPressed()   {
        GeneralSubstractFunction(AgilityBaseLabel);
    }
    
    @FXML
    private void onStrengthDivideButtonPressed()   {
        GeneralSubstractFunction(StrengthBaseLabel);
    }
    
    @FXML
    private void onCharismaDivideButtonPressed()   {
        GeneralSubstractFunction(CharismaBaseLabel);
    }
    
    @FXML
    private void onIntelligenceDivideButtonPressed()   {
        GeneralSubstractFunction(IntelligenceBaseLabel);
    }
    
    @FXML
    private void onWillDivideButtonPressed()   {
        GeneralSubstractFunction(WillBaseLabel);
    }
    
    private boolean checkBeforeNextButton()    {
        boolean isGood = true;
        Integer nTemp;
        nTemp = Integer.parseUnsignedInt(BodyBaseLabel.getText());
        if(nTemp < 1)   {
            isGood = false;
        }
        nTemp = Integer.parseUnsignedInt(AgilityBaseLabel.getText());
        if(nTemp < 1)   {
            isGood = false;
        }
        nTemp = Integer.parseUnsignedInt(StrengthBaseLabel.getText());
        if(nTemp < 1)   {
            isGood = false;
        }
        nTemp = Integer.parseUnsignedInt(CharismaBaseLabel.getText());
        if(nTemp < 1)   {
            isGood = false;
        }
        nTemp = Integer.parseUnsignedInt(IntelligenceBaseLabel.getText());
        if(nTemp < 1)   {
            isGood = false;
        }
        nTemp = Integer.parseUnsignedInt(WillBaseLabel.getText());
        if(nTemp < 1)   {
            isGood = false;
        }
        nTemp = Integer.parseUnsignedInt(DistributableAttributesLabel.getText());
        if(nTemp != 0)   {
            isGood = false;
        }
        return isGood;
    }
    
    private void setCharacterValuesFromInput()  {
        character.setBaseBody(Integer.parseUnsignedInt(BodyBaseLabel.getText()));
        character.setBaseAgility(Integer.parseUnsignedInt(AgilityBaseLabel.getText()));
        character.setBaseStrength(Integer.parseUnsignedInt(StrengthBaseLabel.getText()));
        character.setBaseCharisma(Integer.parseUnsignedInt(CharismaBaseLabel.getText()));
        character.setBaseIntelligence(Integer.parseUnsignedInt(IntelligenceBaseLabel.getText()));
        character.setBaseWillpower(Integer.parseUnsignedInt(WillBaseLabel.getText()));
    }
    
    private void showCharacterSheetEditorStep3()  {
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
    private void onNextButtonClicked()  {
        if(checkBeforeNextButton())    {
            setCharacterValuesFromInput();
            //characterSheetEditorStep2Controller.setMyCharacter(character);
            mainApp.setCharacter(character);
            showCharacterSheetEditorStep3();
            
        }
        else    {
            WarningLabel.setText("All attribute must be more than zero. Spend all points!");
            WarningLabel.setVisible(true);
        }
    }

    
    public void initialize() {
        logger = LoggerFactory.getLogger(CharacterSheetEditorStep2Controller.class);

        character = CharacterTransferHelper.transferCharacter;
        InitializeMaxAttrs ();
        InitializeBaseLabels();
        InitializeDistributableAttributesLabel();
    }    
    
}
