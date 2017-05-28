/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.character_sheet;

import com.sun.javafx.collections.ObservableListWrapper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.SingleSelectionModel;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import model.character.AbstractCharacter;
import shadowrunchargenproto_v0.pkg0.LaunchFXApp;
import model.character.GenderEnum;
import model.character.PriorityClassEnum;
import model.character.RaceEnum;
import model.character.constants.RacialModifiers;
import model.character.SpellcasterTypeEnum;
import controller.character.helpers.StartingAttributesHelper;
import controller.character.helpers.StartingMoneyHelper;
import controller.character.helpers.StartingSkillPointsHelper;
import model.character.nonspellcaster.NonSpellcaster;
import model.character.spellcaster.chartypes.Adept;
import model.character.spellcaster.chartypes.SpecializedWizard;
import model.character.spellcaster.chartypes.Wizard;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * FXML Controller class
 *
 * @author Dr.Chase
 */
public class CharacterSheetEditorStep1Controller {
    
    org.slf4j.Logger logger;
    
    private AbstractCharacter character;
    
    private PriorityClassEnum magicPrioClass;
    private PriorityClassEnum racePrioClass;
    private PriorityClassEnum attributesPrioClass;
    private PriorityClassEnum skillsPrioClass;
    private PriorityClassEnum moneyPrioClass;
    
    @FXML
    private Label SpellcasterTypePriorityLabel;
    @FXML
    private Label RaceProrityLabel;
    @FXML
    private Label AttributePriorityLabel;
    @FXML
    private Label SkillsPriorityLabel;
    @FXML
    private Label MoneyPriorityLabel;
    
    @FXML
    private Label NameOfCharLabel;
    @FXML
    private Label AgeOfCharLabel;
    @FXML
    private Label GenderOfCharLabel;
    @FXML
    private Label WarningLabel;
    
    @FXML
    private ChoiceBox SpellcasterTypePriorityChoiceBox;
    @FXML
    private ChoiceBox RaceProrityChoiceBox;
    @FXML
    private ChoiceBox AttributePriorityChoiceBox;
    @FXML
    private ChoiceBox SkillsPriorityChoiceBox;
    @FXML
    private ChoiceBox MoneyPriorityChoiceBox;
    @FXML
    private TextField NameOfCharTextField;
    @FXML
    private TextField AgeOfCharTextField;
    @FXML
    private ChoiceBox GenderChoiceBox;
    
    @FXML
    private Button ResetButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button NextButton;
    
    // Reference to the main application.
    private LaunchFXApp mainApp;
    
    private CharacterSheetEditorStep2Controller characterSheetEditorStep2Controller;

    public CharacterSheetEditorStep2Controller getCharacterSheetEditorStep2Controller() {
        return characterSheetEditorStep2Controller;
    }

    public void setCharacterSheetEditorStep2Controller(CharacterSheetEditorStep2Controller characterSheetEditorStep2Controller) {
        this.characterSheetEditorStep2Controller = characterSheetEditorStep2Controller;
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    EnumSet<PriorityClassEnum> remainingPrios;
    
    private void resetPrios()   {
        remainingPrios = EnumSet.of(
                                    PriorityClassEnum.PRIORITY_A,
                                    PriorityClassEnum.PRIORITY_B,
                                    PriorityClassEnum.PRIORITY_C,
                                    PriorityClassEnum.PRIORITY_D,
                                    PriorityClassEnum.PRIORITY_E
                                    );
    }
        
    
    private void resetLabels()  {
        SpellcasterTypePriorityLabel.setText("Set this first!");
        RaceProrityLabel.setText("Set this second!");
        AttributePriorityLabel.setText("Set this third!");
        SkillsPriorityLabel.setText("Set this fourth!");
        MoneyPriorityLabel.setText("Set this fifth!");
        
        NameOfCharLabel.setText("");
        AgeOfCharLabel.setText("");
        GenderOfCharLabel.setText("");
        WarningLabel.setText("");
    }
    
    private void remainingPriosHelper(EnumSet<PriorityClassEnum> remainingPrios) {
        final List<PriorityClassEnum> possibleValues = new ArrayList<>(remainingPrios);
        logger.info(remainingPrios.toString());

        final ObservableList<PriorityClassEnum> possibleValuesObservable = new ObservableListWrapper<>(
                possibleValues);
        AttributePriorityChoiceBox.setItems(possibleValuesObservable);
        SkillsPriorityChoiceBox.setItems(possibleValuesObservable);
        MoneyPriorityChoiceBox.setItems(possibleValuesObservable);
    }
    
    private void remainingPriosHelperSkillsAndMoney(EnumSet<PriorityClassEnum> remainingPrios) {
        final List<PriorityClassEnum> possibleValues = new ArrayList<>(remainingPrios);
        logger.info(remainingPrios.toString());

        final ObservableList<PriorityClassEnum> possibleValuesObservable = new ObservableListWrapper<>(
                possibleValues);
        SkillsPriorityChoiceBox.setItems(possibleValuesObservable);
        MoneyPriorityChoiceBox.setItems(possibleValuesObservable);
    }
    
    private void remainingPriosHelperMoney(EnumSet<PriorityClassEnum> remainingPrios) {
        final List<PriorityClassEnum> possibleValues = new ArrayList<>(remainingPrios);
        logger.info(remainingPrios.toString());

        final ObservableList<PriorityClassEnum> possibleValuesObservable = new ObservableListWrapper<>(
                possibleValues);
        MoneyPriorityChoiceBox.setItems(possibleValuesObservable);
    }
    
    private String niceTextForPriorityLabel(String strInput)    {
        String strOutput;
        switch (strInput)   {
            case "PRIORITY_A":
                strOutput = "Attributes: 30";
                break;
            case "PRIORITY_B":
                strOutput = "Attributes: 27";
                break;
            
            case "PRIORITY_C":
                strOutput = "Attributes: 24";
                break;
            
            case "PRIORITY_D":
                strOutput = "Attributes: 21";
                break;
            
            case "PRIORITY_E":
                strOutput = "Attributes: 18";
                break;
            default:
                strOutput = "";
                
        }
        return strOutput;
    }
    
    private String niceTextForSkillLabel(String strInput)    {
        String strOutput;
        switch (strInput)   {
            case "PRIORITY_A":
                strOutput = "Skill points: 50";
                break;
            case "PRIORITY_B":
                strOutput = "Skill points: 40";
                break;
            
            case "PRIORITY_C":
                strOutput = "Skill points: 34";
                break;
            
            case "PRIORITY_D":
                strOutput = "Skill points: 30";
                break;
            
            case "PRIORITY_E":
                strOutput = "Skill points: 27";
                break;
            default:
                strOutput = "";
                
        }
        return strOutput;
    }
    private String niceTextForMoneyLabel(String strInput)    {
        String strOutput;
        switch (strInput)   {
            case "PRIORITY_A":
                strOutput = "Money: 1.000.000";
                break;
            case "PRIORITY_B":
                strOutput = "Money: 400.000";
                break;
            
            case "PRIORITY_C":
                strOutput = "Money: 90.000";
                break;
            
            case "PRIORITY_D":
                strOutput = "Money: 20.000";
                break;
            
            case "PRIORITY_E":
                strOutput = "Money: 5.000";
                break;
            default:
                strOutput = "";
                
        }
        return strOutput;
    }
    
    @FXML
    private void onResetButtonAction()  {
        resetLabels();
        resetPrios();
        SpellcasterTypePriorityChoiceBox.getItems().setAll(model.character.SpellcasterTypeEnum.values());
        RaceProrityChoiceBox.getItems().setAll(model.character.RaceEnum.values());
        remainingPriosHelper(remainingPrios);
    }
    
    public void showCharacterSheetEditorStep2() {
        try {
            CharacterTransferHelper.transferCharacter = character;
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/CharacterSheetEditorStep2.fxml"));
            AnchorPane characterSheetEditorStep2 = (AnchorPane) loader.load();
            loader.setRoot(this);
            
            mainApp.setCharacter(character);
            CharacterSheetEditorStep2Controller controller = loader.getController();
            controller.setMainApp(mainApp);
            controller.setCharacterSheetEditorStep1Controller(this);
            //controller.setMyCharacter(character);

            // Set person overview into the center of root layout.
            mainApp.getRootLayout().setCenter(characterSheetEditorStep2);
            
            // Give the controller access to the main app.
            // These 2 lines below belong to Tutorial 2.

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private boolean checkInputValues() {
        boolean isGood = true;
        //StringBuilder sb = new StringBuilder();
        if(SpellcasterTypePriorityChoiceBox.getValue() == null)    {
            isGood = false;
        }
        if(RaceProrityChoiceBox.getValue() == null)    {
            isGood = false;
        }
        if(AttributePriorityChoiceBox.getValue() == null)    {
            isGood = false;
        }
        if(SkillsPriorityChoiceBox.getValue() == null)    {
            isGood = false;
        }
        if(MoneyPriorityChoiceBox.getValue() == null)    {
            isGood = false;
        }
        
        // empty string matches ^$
        if (NameOfCharLabel.getText().matches("^$"))  {
            isGood = false;
        }
        // regexp from stackoverflow: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
        // ha üres az age
        if ((AgeOfCharLabel.getText().matches("^$")) )  {
            isGood = false;
        }
        // ha nem szám
        if (!AgeOfCharLabel.getText().matches("^-?\\d+$") )  {
            isGood = false;
            AgeOfCharLabel.setTextFill(Color.web("#ff0000"));
            AgeOfCharLabel.setText("Age must be a number!");
        }
        
        if(GenderChoiceBox.getValue() == null)    {
            isGood = false;
        }
        
        // one more special case: Troll and Elf can't be specialized vizard.
        if(SpellcasterTypePriorityChoiceBox.getValue() == SpellcasterTypeEnum.SPECIALIZED_WIZARD &&
                (RaceProrityChoiceBox.getValue() == RaceEnum.TROLL ||
                 RaceProrityChoiceBox.getValue() == RaceEnum.ELF
                )
           )
        {
            isGood = false;
            RaceProrityLabel.setText("Troll and Elf can't be specialized Wizard!");
            SpellcasterTypePriorityLabel.setText("Troll and Elf can't be specialized Wizard!");
        }
        return isGood;
    }
    
    private void setCharacterValuesFromInput()  {
        switch((SpellcasterTypeEnum)SpellcasterTypePriorityChoiceBox.getValue())    {
            case NON_SPELLCASTER:
                character = new NonSpellcaster();
                character.setSpellcasterType(SpellcasterTypeEnum.NON_SPELLCASTER);
                character.setPrioMagic(PriorityClassEnum.PRIORITY_E);
                break;
            case WIZARD:
                character = new Wizard();
                character.setSpellcasterType(SpellcasterTypeEnum.WIZARD);
                character.setPrioMagic(PriorityClassEnum.PRIORITY_A);
                break;
            case ADEPT:
                character = new Adept();
                character.setSpellcasterType(SpellcasterTypeEnum.ADEPT);
                character.setPrioMagic(PriorityClassEnum.PRIORITY_B);
                break;
            case SPECIALIZED_WIZARD:
                character = new SpecializedWizard();
                character.setSpellcasterType(SpellcasterTypeEnum.SPECIALIZED_WIZARD);
                character.setPrioMagic(PriorityClassEnum.PRIORITY_C);
                break;
        }
        
        switch((RaceEnum)RaceProrityChoiceBox.getValue())   {
            case HUMAN:
                character.setRace(RaceEnum.HUMAN);
                if(character.getSpellcasterType() == SpellcasterTypeEnum.NON_SPELLCASTER) {
                    character.setPrioRace(PriorityClassEnum.PRIORITY_D);
                }
                else    {
                    character.setPrioRace(PriorityClassEnum.PRIORITY_E);
                }
                character.setRacialModifier(RacialModifiers.HUMAN_MODIFIER);
                break;
            case ELF:
                character.setRace(RaceEnum.ELF);
                character.setPrioRace(PriorityClassEnum.PRIORITY_C);
                character.setRacialModifier(RacialModifiers.ELF_MODIFIER);
                break;
            case TROLL:
                character.setRace(RaceEnum.TROLL);
                character.setPrioRace(PriorityClassEnum.PRIORITY_C);
                character.setRacialModifier(RacialModifiers.TROLL_MODIFIER);
                break;
            case DWARF:
                character.setRace(RaceEnum.DWARF);
                character.setPrioRace(PriorityClassEnum.PRIORITY_D);
                character.setRacialModifier(RacialModifiers.DWARF_MODIFIER);
                break;
            case ORC:
                character.setRace(RaceEnum.ORC);
                character.setPrioRace(PriorityClassEnum.PRIORITY_D);
                character.setRacialModifier(RacialModifiers.ORC_MODIFIER);
                break;
        }
        switch((PriorityClassEnum) AttributePriorityChoiceBox.getValue())    {
            case PRIORITY_A:
                character.setPrioAttributes(PriorityClassEnum.PRIORITY_A);
                break;
            case PRIORITY_B:
                character.setPrioAttributes(PriorityClassEnum.PRIORITY_B);
                break;
            case PRIORITY_C:
                character.setPrioAttributes(PriorityClassEnum.PRIORITY_C);
                break;
            case PRIORITY_D:
                character.setPrioAttributes(PriorityClassEnum.PRIORITY_D);
                break;
            case PRIORITY_E:
                character.setPrioAttributes(PriorityClassEnum.PRIORITY_E);
                break;
        }
        character.setAvailableAttributePoints(StartingAttributesHelper.getMaxAttributesFromCharacter(character));
        switch((PriorityClassEnum) SkillsPriorityChoiceBox.getValue())  {
            case PRIORITY_A:
                character.setPrioSkills(PriorityClassEnum.PRIORITY_A);
                break;
            case PRIORITY_B:
                character.setPrioSkills(PriorityClassEnum.PRIORITY_B);
                break;
            case PRIORITY_C:
                character.setPrioSkills(PriorityClassEnum.PRIORITY_C);
                break;
            case PRIORITY_D:
                character.setPrioSkills(PriorityClassEnum.PRIORITY_D);
                break;
            case PRIORITY_E:
                character.setPrioSkills(PriorityClassEnum.PRIORITY_E);
                break;
        }
        character.setAvailableSkillPoints(StartingSkillPointsHelper.getMaxSkillpointsFromCharacter(character));
        
        switch((PriorityClassEnum) MoneyPriorityChoiceBox.getValue() )  {
            case PRIORITY_A:
                character.setPrioResources(PriorityClassEnum.PRIORITY_A);
                break;
            case PRIORITY_B:
                character.setPrioResources(PriorityClassEnum.PRIORITY_B);
                break;
            case PRIORITY_C:
                character.setPrioResources(PriorityClassEnum.PRIORITY_C);
                break;
            case PRIORITY_D:
                character.setPrioResources(PriorityClassEnum.PRIORITY_D);
                break;
            case PRIORITY_E:
                character.setPrioResources(PriorityClassEnum.PRIORITY_E);
                break;
        }
        character.setMoney(StartingMoneyHelper.getStartingMoneyFromCharacter(character));
        
        character.setName(NameOfCharLabel.getText());
        
        character.setAge(Integer.parseUnsignedInt(AgeOfCharLabel.getText()));
        
        if(GenderOfCharLabel.getText().equalsIgnoreCase("Male")){
            character.setGender(GenderEnum.MALE);
        }
        if(GenderOfCharLabel.getText().equalsIgnoreCase("Female")){
            character.setGender(GenderEnum.FEMALE);
        }
        
        //**********************************************************************
        //              MUST LOG HERE
        //**********************************************************************
//        System.out.println("*************************************************");
//        System.out.println("\t\tSaving datas");
//        System.out.println("*************************************************");
//        
//        System.out.println("Attributes prio:" + character.getPrioAttributes());
//        System.out.println("Magic prio:" +character.getPrioMagic());
//        System.out.println("Race prio:" +character.getPrioRace());
//        System.out.println("Resource prio:" +character.getPrioResources());
//        System.out.println("Skills prio:" +character.getPrioSkills());
        
        logger.info("Saving datas");
        logger.info("Attributes prio:" + character.getPrioAttributes().toString());
        logger.info("Magic prio:" +character.getPrioMagic().toString());
        logger.info("Race prio:" +character.getPrioRace().toString());
        logger.info("Resource prio:" +character.getPrioResources().toString());
        logger.info("Skills prio:" +character.getPrioSkills().toString());
        
    }
    
    @FXML
    void onNextButtonClicked(ActionEvent event) throws IOException  {
        if(checkInputValues())    {
            setCharacterValuesFromInput();
            //characterSheetEditorStep2Controller.setMyCharacter(character);
            mainApp.setCharacter(character);
            showCharacterSheetEditorStep2();
            
        }
        else    {
            WarningLabel.setText("You Are Not Finished!");
            WarningLabel.setVisible(true);
        }
    }
    
    @FXML
    private void onNameOfCharTextFieldAction()  {
        NameOfCharLabel.setText(NameOfCharTextField.getText());
    }
    @FXML
    private void onAgeOfCharextFieldAction()  {
        AgeOfCharLabel.setText(AgeOfCharTextField.getText());
    }

    public void initialize() {
        
        logger = LoggerFactory.getLogger(CharacterSheetEditorStep1Controller.class);
        logger.info("Initializing CharacterSheetEditorStep1Controller...");
        resetLabels();

        resetPrios();
        // Log here later

        SpellcasterTypePriorityChoiceBox.getItems().setAll(model.character.SpellcasterTypeEnum.values());
        
        SpellcasterTypePriorityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, value, newValue) -> {
                    // LOGGING HERE
                    // ez itt jelenleg azt loggolja hogy MIRŐL váltunk
                    logger.info(SpellcasterTypePriorityChoiceBox.getSelectionModel().selectedItemProperty().toString());
                    //logger.info(SpellcasterTypePriorityChoiceBox.getValue().toString());
                    
                    switch(newValue.intValue()) {
                        case 0: /*non-spellcaster*/   
                            SpellcasterTypePriorityLabel.setText("Class D or E");
                            remainingPrios.remove(PriorityClassEnum.PRIORITY_E);
                            break;
                        case 1: /*Wizard*/   
                            SpellcasterTypePriorityLabel.setText("Class A");
                            remainingPrios.remove(PriorityClassEnum.PRIORITY_A);
                            break;
                        case 2: /*Adept*/   
                            SpellcasterTypePriorityLabel.setText("Class B");
                            remainingPrios.remove(PriorityClassEnum.PRIORITY_B);
                            break;
                        case 3: /*Specialized-Wizard*/   
                            SpellcasterTypePriorityLabel.setText("Class C");
                            remainingPrios.remove(PriorityClassEnum.PRIORITY_C);
                            break;
                    }
                    // this switch is for managing the remainingPrios synched with the comboboxes
                    switch(value.intValue()) {
                        case 0: /*non-spellcaster*/   
                            remainingPrios.add(PriorityClassEnum.PRIORITY_E);
                            break;
                        case 1: /*Wizard*/   
                            remainingPrios.add(PriorityClassEnum.PRIORITY_A);
                            break;
                        case 2: /*Adept*/   
                            remainingPrios.add(PriorityClassEnum.PRIORITY_B);
                            break;
                        case 3: /*Specialized-Wizard*/   
                            remainingPrios.add(PriorityClassEnum.PRIORITY_C);
                            break;
                    }
                    logger.info(remainingPrios.toString());
                    // This line updates 3 choiceboxes with reamining priorities
                    remainingPriosHelper(remainingPrios);
                }
        );
        
        // Race selection
        RaceProrityChoiceBox.getItems().setAll(model.character.RaceEnum.values());
        
        RaceProrityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, value, newValue) -> {
                    // LOGGING HERE
                    // ez itt jelenleg azt loggolja hogy MIRŐL váltunk
                    logger.info(RaceProrityChoiceBox.getSelectionModel().selectedItemProperty().toString());
                    
                    switch(newValue.intValue()) {
                        case 0: /*human*/   
                            RaceProrityLabel.setText("Class D or E");
                            if(remainingPrios.contains(PriorityClassEnum.PRIORITY_E))   {
                                remainingPrios.remove(PriorityClassEnum.PRIORITY_E);
                            }
                            else    {
                                remainingPrios.remove(PriorityClassEnum.PRIORITY_D);
                            }
                            
                            break;
                        case 1: /*Elf*/   
                            //RaceProrityLabel.setText("Class A");
                        case 2: /*Troll*/   
                            RaceProrityLabel.setText("Class C");
                            remainingPrios.remove(PriorityClassEnum.PRIORITY_C);
                            break;
                        case 3: /*Dwarf*/   
                            //RaceProrityLabel.setText("Class D");
                        case 4: /*Orc*/
                            
                            RaceProrityLabel.setText("Class D");
                            remainingPrios.remove(PriorityClassEnum.PRIORITY_D);
                            
                            break;
                    }
                    // this switch is for managing the remainingPrios synched with the comboboxes
                    switch(value.intValue()) {
                        case 0: /*human*/  
                            if(!remainingPrios.contains(PriorityClassEnum.PRIORITY_E))  {
                                remainingPrios.add(PriorityClassEnum.PRIORITY_E);
                            }
                                
                            else    {    
                                remainingPrios.add(PriorityClassEnum.PRIORITY_D);
                            }
                            break;
                        case 1: /*Elf*/  
                        case 2:  /*Troll*/
                            if( (newValue.intValue() == 1) || (newValue.intValue() == 2) )    {
                                //remainingPrios.add(PriorityClassEnum.PRIORITY_D);
                                break;
                            }
                            remainingPrios.add(PriorityClassEnum.PRIORITY_C);
                            break;
                        case 3:/*Dwarf*/      
                        case 4: /*Orc*/
                            if( (newValue.intValue() == 3) || (newValue.intValue() == 4) )    {
                                //remainingPrios.add(PriorityClassEnum.PRIORITY_D);
                                break;
                            }
                                
                            remainingPrios.add(PriorityClassEnum.PRIORITY_D);
                            break;
                    }
                    logger.info("Remaining prios:");
                    logger.info(remainingPrios.toString());
                    remainingPriosHelper(remainingPrios);
                }
        );

        remainingPriosHelper(remainingPrios);
        AttributePriorityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    
                    //List<PriorityClassEnum> possibleAttrValues = new ArrayList<>(remainingPrios);
                    List<PriorityClassEnum> possibleAttrValues = AttributePriorityChoiceBox.getItems();
                    
                    // LOGGING HERE
                    // ez itt jelenleg azt loggolja hogy MIRŐL váltunk
                    logger.info("Possible Attr values:");
                    logger.info(possibleAttrValues.toString());
                    logger.info("Setting text label.");

                    try {
                        switch(newValue.intValue()) {
                            case -1:
                                break;
                            case 0:  
                                //PriorityClassEnum prioClassTemp = (PriorityClassEnum)AttributePriorityChoiceBox.getSelectionModel().getSelectedItem();
                                //AttributePriorityLabel.setText(prioClassTemp.toString());
                                AttributePriorityLabel.setText(niceTextForPriorityLabel(possibleAttrValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleAttrValues.get(newValue.intValue()));
                                break;
                            case 1:   
                                AttributePriorityLabel.setText(niceTextForPriorityLabel(possibleAttrValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleAttrValues.get(newValue.intValue()));
                                break;
                            case 2:    
                                AttributePriorityLabel.setText(niceTextForPriorityLabel(possibleAttrValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleAttrValues.get(newValue.intValue()));
                                break;
                            case 3:    
                                AttributePriorityLabel.setText(niceTextForPriorityLabel(possibleAttrValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleAttrValues.get(newValue.intValue()));
                                break;
                            case 4:    
                                AttributePriorityLabel.setText(niceTextForPriorityLabel(possibleAttrValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleAttrValues.get(newValue.intValue()));
                                break;
                            default:
                                AttributePriorityLabel.setText("");
                        }
                    }
                    catch(IndexOutOfBoundsException e)  {
                        AttributePriorityLabel.setText("");
                        logger.error("Exception caught: ");
                        logger.error("While trying to set new attr label or remove from remaining prios.");

                        //remainingPriosHelperSkillsAndMoney(remainingPrios);
                    }
                    logger.info("removing from remaining prios at attributes.");
                    try {
                        switch(oldValue.intValue()) {
                            case -1:
                                //AttributePriorityLabel.setText("");
                                break;
                            case 0:  
                                remainingPrios.add(possibleAttrValues.get(oldValue.intValue()));
                                //System.out.println(AttributePriorityChoiceBox.getValue().toString());
                                break;
                            case 1:   
                                remainingPrios.add(possibleAttrValues.get(oldValue.intValue()));
                                break;
                            case 2:    
                                remainingPrios.add(possibleAttrValues.get(oldValue.intValue()));
                                break;
                            case 3:    
                                remainingPrios.add(possibleAttrValues.get(oldValue.intValue()));
                                break;
                            case 4:    
                                remainingPrios.add(possibleAttrValues.get(oldValue.intValue()));
                                break;
                            default:
                                AttributePriorityLabel.setText("");
                        }
                    }
                    catch(IndexOutOfBoundsException e)  {
                        AttributePriorityLabel.setText("");
                        logger.error("Exception caught: ");
                        logger.error("While add back to remainingPrios varaible at AttributeChoicebox.");
                        remainingPrios.add((PriorityClassEnum)AttributePriorityChoiceBox.getValue());
                        //remainingPriosHelperSkillsAndMoney(remainingPrios);
                    }
                    logger.info("Attribute prio choosen. Remaining prios:");
                    logger.info(remainingPrios.toString());
                    remainingPriosHelperSkillsAndMoney(remainingPrios);
                }
        );
        
        remainingPriosHelperSkillsAndMoney(remainingPrios);
        SkillsPriorityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    List<PriorityClassEnum> possibleSkillValues = SkillsPriorityChoiceBox.getItems();
                    
                    // LOGGING HERE
                    // ez itt jelenleg azt loggolja hogy MIRŐL váltunk
                    logger.info("Possible Skill values:");
                    logger.info(possibleSkillValues.toString());
                    logger.info("Setting text label for skill points.");
                    try {
                        switch(newValue.intValue()) {
                            case -1:
                                //SkillsPriorityLabel.setText("");
                                //remainingPrios.add((PriorityClassEnum)SkillsPriorityChoiceBox.getValue());
                                //remainingPriosHelperSkillsAndMoney(remainingPrios);
                                break;
                            case 0:  
                                SkillsPriorityLabel.setText(niceTextForSkillLabel(possibleSkillValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleSkillValues.get(newValue.intValue()));
                                break;
                            case 1:   
                                SkillsPriorityLabel.setText(niceTextForSkillLabel(possibleSkillValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleSkillValues.get(newValue.intValue()));
                                break;
                            case 2:    
                                SkillsPriorityLabel.setText(niceTextForSkillLabel(possibleSkillValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleSkillValues.get(newValue.intValue()));
                                break;
                            case 3:    
                                SkillsPriorityLabel.setText(niceTextForSkillLabel(possibleSkillValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleSkillValues.get(newValue.intValue()));
                                break;
                            case 4:    
                                SkillsPriorityLabel.setText(niceTextForSkillLabel(possibleSkillValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleSkillValues.get(newValue.intValue()));
                                break;
                            default:
                                SkillsPriorityLabel.setText("");
                        }
                    }
                    catch(IndexOutOfBoundsException e)  {
                        SkillsPriorityLabel.setText("");
                        logger.error("Exception caught: ");
                        logger.error("While trying to set new skill label or remove from remaining prios.");
                        //remainingPriosHelperSkillsAndMoney(remainingPrios);
                    }
                    finally {
                        
                    }
                    try {
                        switch(oldValue.intValue()) {
                            case -1:
                                break;
                            case 0:  
                                remainingPrios.add(possibleSkillValues.get(oldValue.intValue()));
                                //System.out.println(AttributePriorityChoiceBox.getValue().toString());
                                break;
                            case 1:   
                                remainingPrios.add(possibleSkillValues.get(oldValue.intValue()));
                                break;
                            case 2:    
                                remainingPrios.add(possibleSkillValues.get(oldValue.intValue()));
                                break;
                            case 3:    
                                remainingPrios.add(possibleSkillValues.get(oldValue.intValue()));
                                break;
                            case 4:    
                                remainingPrios.add(possibleSkillValues.get(oldValue.intValue()));
                                break;
                            default:
                        }
                    }
                    catch(IndexOutOfBoundsException e)  {
                        SkillsPriorityLabel.setText("");
                        logger.error("Exception caught: ");
                        logger.error("While add back to remainingPrios varaible at SkillChoiceBox.");        
                        remainingPrios.add((PriorityClassEnum)SkillsPriorityChoiceBox.getValue());
                        //remainingPriosHelperSkillsAndMoney(remainingPrios);
                    }
                    finally {
                        
                    }
                    logger.info("Attribute skill choosen. Remaining prios:");
                    logger.info(remainingPrios.toString());
                    remainingPriosHelperMoney(remainingPrios);
                }
        );
        
        MoneyPriorityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    List<PriorityClassEnum> possibleMoneyValues = MoneyPriorityChoiceBox.getItems();
                    // LOGGING HERE
                    // ez itt jelenleg azt loggolja hogy MIRŐL váltunk
                    logger.info("Possible Skill values:");
                    logger.info(possibleMoneyValues.toString());
                    logger.info("Setting text label for money.");
                    try {
                        switch(newValue.intValue()) {
                            case -1:
                                //MoneyPriorityLabel.setText("");
                                //remainingPrios.add((PriorityClassEnum)SkillsPriorityChoiceBox.getValue());
                                //remainingPriosHelperSkillsAndMoney(remainingPrios);
                                break;
                            case 0:  
                                MoneyPriorityLabel.setText(niceTextForMoneyLabel(possibleMoneyValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleMoneyValues.get(newValue.intValue()));
                                break;
                            case 1:   
                                MoneyPriorityLabel.setText(niceTextForMoneyLabel(possibleMoneyValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleMoneyValues.get(newValue.intValue()));
                                break;
                            case 2:    
                                MoneyPriorityLabel.setText(niceTextForMoneyLabel(possibleMoneyValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleMoneyValues.get(newValue.intValue()));
                                break;
                            case 3:    
                                MoneyPriorityLabel.setText(niceTextForMoneyLabel(possibleMoneyValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleMoneyValues.get(newValue.intValue()));
                                break;
                            case 4:    
                                MoneyPriorityLabel.setText(niceTextForMoneyLabel(possibleMoneyValues.get(newValue.intValue()).toString()));
                                remainingPrios.remove(possibleMoneyValues.get(newValue.intValue()));
                                break;
                            default:
                                MoneyPriorityLabel.setText("");
                        }
                    }
                    catch(IndexOutOfBoundsException e)  {
                        MoneyPriorityLabel.setText("");
                        logger.error("Exception caught: ");
                        logger.error("While trying to set new money label or remove from remaining prios.");
                        //remainingPriosHelperSkillsAndMoney(remainingPrios);
                    }
                    finally {
                        
                    }
                    try {
                        switch(oldValue.intValue()) {
                            case -1:
                                break;
                            case 0:  
                                remainingPrios.add(possibleMoneyValues.get(oldValue.intValue()));
                                //System.out.println(AttributePriorityChoiceBox.getValue().toString());
                                break;
                            case 1:   
                                remainingPrios.add(possibleMoneyValues.get(oldValue.intValue()));
                                break;
                            case 2:    
                                remainingPrios.add(possibleMoneyValues.get(oldValue.intValue()));
                                break;
                            case 3:    
                                remainingPrios.add(possibleMoneyValues.get(oldValue.intValue()));
                                break;
                            case 4:    
                                remainingPrios.add(possibleMoneyValues.get(oldValue.intValue()));
                                break;
                            default:
                        }
                    }
                    catch(IndexOutOfBoundsException e)  {
                        SkillsPriorityLabel.setText("");
                        logger.error("Exception caught: ");
                        logger.error("While add back to remainingPrios varaible at SkillChoiceBox.");
                        remainingPrios.add((PriorityClassEnum)SkillsPriorityChoiceBox.getValue());
                        //remainingPriosHelperSkillsAndMoney(remainingPrios);
                    }
                    finally {
                        
                    }
                    logger.info("Attribute skill choosen. Remaining prios:");
                    logger.info(remainingPrios.toString());
                }
        );
        
        GenderChoiceBox.getItems().setAll("Male", "Female");
        GenderChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    switch(newValue.intValue()) {
                        case -1:
                            break;
                        case 0:  
                            GenderOfCharLabel.setText("Male");
                            break;
                        case 1:   
                            GenderOfCharLabel.setText("Female");
                            break;
                    }
                }
        );

    }
    public void setMainApp(LaunchFXApp mainApp) {
        this.mainApp = mainApp;
    }
    
    // Setters and Getters after this line
    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }
}
