/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.character_sheet;

import com.sun.javafx.collections.ObservableListWrapper;
import controller.character.helpers.RaceChoiceBoxHelper;
import controller.character.helpers.SpellCasterChoiceBoxHelper;
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
import java.util.ArrayDeque;
import java.util.Deque;
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
     Label SpellcasterTypePriorityLabel;
    @FXML
     Label RaceProrityLabel;
    @FXML
     Label AttributePriorityLabel;
    @FXML
     Label SkillsPriorityLabel;
    @FXML
     Label MoneyPriorityLabel;
    
    @FXML
     Label NameOfCharLabel;
    @FXML
     Label AgeOfCharLabel;
    @FXML
     Label GenderOfCharLabel;
    @FXML
    private Label WarningLabel;
    
    @FXML
     ChoiceBox SpellcasterTypePriorityChoiceBox;
    @FXML
     ChoiceBox RaceProrityChoiceBox;
    @FXML
     ChoiceBox AttributePriorityChoiceBox;
    @FXML
     ChoiceBox SkillsPriorityChoiceBox;
    @FXML
     ChoiceBox MoneyPriorityChoiceBox;
    @FXML
     TextField NameOfCharTextField;
    @FXML
     TextField AgeOfCharTextField;
    @FXML
    private ChoiceBox GenderChoiceBox;
    
    @FXML
    private Button ResetButton;
    @FXML
    public Button CancelButton;
    @FXML
    private Button NextButton;
    
    // Reference to the main application.
    private LaunchFXApp mainApp;
    
    private SpellcasterTypeEnum lastSelectedSpellcasterTypeEnum;
    private RaceEnum lastSelectedRaceEnum;
    private PriorityClassEnum lastSelectedAttributePriorityEnum;
    private PriorityClassEnum lastSelectedSkillPriorityEnum;
    private PriorityClassEnum lastSelectedMoneyPriorityEnum;
    
    private Deque<PriorityClassEnum> stackForLastSelectedPrio = new ArrayDeque<PriorityClassEnum>();
    
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
        
        NameOfCharTextField.setText("");
        AgeOfCharTextField.setText("");
    }
    
    private void resetChoiceBoxes() {
        SpellcasterTypePriorityChoiceBox.getSelectionModel().clearSelection();
        SpellcasterTypePriorityChoiceBox.setValue(null);
        SpellcasterTypePriorityChoiceBox.setDisable(false);
        RaceProrityChoiceBox.getSelectionModel().clearSelection();
        RaceProrityChoiceBox.setValue(null);
        RaceProrityChoiceBox.setDisable(false);
        AttributePriorityChoiceBox.getSelectionModel().clearSelection();
        AttributePriorityChoiceBox.setValue(null);
        AttributePriorityChoiceBox.setDisable(false);
        SkillsPriorityChoiceBox.getSelectionModel().clearSelection();
        SkillsPriorityChoiceBox.setValue(null);
        SkillsPriorityChoiceBox.setDisable(false);
        MoneyPriorityChoiceBox.getSelectionModel().clearSelection();
        MoneyPriorityChoiceBox.setValue(null);
        MoneyPriorityChoiceBox.setDisable(false);
        
        //MoneyPriorityChoiceBox.getItems().removeAll((Object[])PriorityClassEnum.values());
        
        GenderChoiceBox.getSelectionModel().clearSelection();
    }
    
    private void remainingPriosHelper(EnumSet<PriorityClassEnum> remainingPrios) {
        
        logger.info("remainingPriosHelper() method called.");
        logger.info("Remaining prios:");
        logger.info(remainingPrios.toString());

        List<PriorityClassEnum> possibleValues = new ArrayList<>(remainingPrios);
        
        ObservableList<PriorityClassEnum> possibleValuesObservable = new ObservableListWrapper<>(
                possibleValues);
        
        List<SpellcasterTypeEnum> possibleSpellcasterTypes = 
                SpellCasterChoiceBoxHelper.determineRemainingSpellcasterEnumChoices(remainingPrios);
        
        ObservableList<SpellcasterTypeEnum> possibleSpellcasterTypesObservable = new ObservableListWrapper<>(
                possibleSpellcasterTypes);
        
        List<RaceEnum> possibleRaceTypes = 
                RaceChoiceBoxHelper.determineRemainingRaceEnumChoices(remainingPrios);
        
        ObservableList<RaceEnum> possibleRaceTypesObservable = new ObservableListWrapper<>(
                possibleRaceTypes);
        
        if(SpellcasterTypePriorityChoiceBox.getSelectionModel().isEmpty())  {
            logger.info("Rearranging empty SpellcasterTypeChoiceBox...");
            SpellcasterTypePriorityChoiceBox.setItems(possibleSpellcasterTypesObservable);
        }
        if(RaceProrityChoiceBox.getSelectionModel().isEmpty())  {
            logger.info("Rearranging empty RaceChoiceBox...");
            RaceProrityChoiceBox.setItems(possibleRaceTypesObservable);
        }
        if(AttributePriorityChoiceBox.getSelectionModel().isEmpty())    {
            logger.info("Rearranging empty AttributesChoiceBox...");
            AttributePriorityChoiceBox.setItems(possibleValuesObservable);
        }
        if(SkillsPriorityChoiceBox.getSelectionModel().isEmpty())    {
            logger.info("Rearranging empty SkillsChoiceBox...");
            SkillsPriorityChoiceBox.setItems(possibleValuesObservable);
        }
        if(MoneyPriorityChoiceBox.getSelectionModel().isEmpty())    {
            logger.info("Rearranging empty MoneyChoiceBox...");
            MoneyPriorityChoiceBox.setItems(possibleValuesObservable);
        }
    }
    
    private void remainingPriosHelper(EnumSet<PriorityClassEnum> remainingPrios, ChoiceBox inActionChoiceBox) {
        
        logger.info("remainingPriosHelper() method called.");
        logger.info("Remaining prios:");
        logger.info(remainingPrios.toString());

        List<PriorityClassEnum> possibleValues = new ArrayList<>(remainingPrios);
        
        ObservableList<PriorityClassEnum> possibleValuesObservable = new ObservableListWrapper<>(
                possibleValues);
        
        List<SpellcasterTypeEnum> possibleSpellcasterTypes = 
                SpellCasterChoiceBoxHelper.determineRemainingSpellcasterEnumChoices(remainingPrios);
        
        ObservableList<SpellcasterTypeEnum> possibleSpellcasterTypesObservable = new ObservableListWrapper<>(
                possibleSpellcasterTypes);
        
        List<RaceEnum> possibleRaceTypes = 
                RaceChoiceBoxHelper.determineRemainingRaceEnumChoices(remainingPrios);
        
        ObservableList<RaceEnum> possibleRaceTypesObservable = new ObservableListWrapper<>(
                possibleRaceTypes);
        
        if(SpellcasterTypePriorityChoiceBox.getSelectionModel().isEmpty())  {
            logger.info("Rearranging empty SpellcasterTypeChoiceBox...");
            
            SpellcasterTypePriorityChoiceBox.setItems(possibleSpellcasterTypesObservable);
            
        }
        else  {
            logger.info("Rearranging not empty SpellcasterTypeChoiceBox...");
            if(!inActionChoiceBox.equals(SpellcasterTypePriorityChoiceBox))    {
                SpellcasterTypePriorityChoiceBox.getItems()
                        .remove(
                                SpellCasterChoiceBoxHelper
                                        .PrioEnumToSpellcasterEnum(
                                                stackForLastSelectedPrio.peek(), lastSelectedRaceEnum
                                        )
                        );
//                SpellcasterTypePriorityChoiceBox.getItems().retainAll(
//                        SpellCasterChoiceBoxHelper.retainableSpellcasterTypes(remainingPrios, lastSelectedSpellcasterTypeEnum, lastSelectedRaceEnum)
//                );
            }
        }
        
        if(RaceProrityChoiceBox.getSelectionModel().isEmpty())  {
            logger.info("Rearranging empty RaceChoiceBox...");
            RaceProrityChoiceBox.setItems(possibleRaceTypesObservable);
        }
        else  {
            logger.info("Rearranging not empty RaceProrityChoiceBox...");
            if(!inActionChoiceBox.equals(RaceProrityChoiceBox))    {
                
                RaceProrityChoiceBox.getItems()
                        .removeAll(
                                RaceChoiceBoxHelper
                                        .priorityEnumToRaceEnum(
                                                stackForLastSelectedPrio.peek()
                                        )
                                        
                        );
            }
        }
        
        
        if(AttributePriorityChoiceBox.getSelectionModel().isEmpty())    {
            logger.info("Rearranging empty AttributesChoiceBox...");
            AttributePriorityChoiceBox.setItems(possibleValuesObservable);
        }
        else  {
            logger.info("Rearranging not empty AttributePriorityChoiceBox...");
            if(!inActionChoiceBox.equals(AttributePriorityChoiceBox))    {
                AttributePriorityChoiceBox.getItems()
                        .remove(stackForLastSelectedPrio.peek());
            }
        }
        
        if(SkillsPriorityChoiceBox.getSelectionModel().isEmpty())    {
            logger.info("Rearranging empty SkillsChoiceBox...");
            SkillsPriorityChoiceBox.setItems(possibleValuesObservable);
        }
        else  {
            logger.info("Rearranging not empty SkillsPriorityChoiceBox...");
            if(!inActionChoiceBox.equals(SkillsPriorityChoiceBox))    {
                SkillsPriorityChoiceBox.getItems()
                        .remove(stackForLastSelectedPrio.peek());
            }
        }
        
        if(MoneyPriorityChoiceBox.getSelectionModel().isEmpty())    {
            logger.info("Rearranging empty MoneyChoiceBox...");
            MoneyPriorityChoiceBox.setItems(possibleValuesObservable);
        }
        else  {
            logger.info("Rearranging not empty MoneyPriorityChoiceBox...");
            if(!inActionChoiceBox.equals(MoneyPriorityChoiceBox))    {
                MoneyPriorityChoiceBox.getItems()
                        .remove(stackForLastSelectedPrio.peek());
            }
        }
    }
    
    private void remainingPriosHelperForResetButton(EnumSet<PriorityClassEnum> remainingPrios) {
        final List<PriorityClassEnum> possibleValues = new ArrayList<>(remainingPrios);
        logger.info("remainingPriosHelperForREsetButton() method called.");
        logger.info("Remaining prios:");
        logger.info(remainingPrios.toString());

        final ObservableList<PriorityClassEnum> possibleValuesObservable = new ObservableListWrapper<>(
                possibleValues);
        
        final List<SpellcasterTypeEnum> possibleSpellcasterTypes = 
                SpellCasterChoiceBoxHelper.determineRemainingSpellcasterEnumChoices(remainingPrios);
        
        final ObservableList<SpellcasterTypeEnum> possibleSpellcasterTypesObservable = new ObservableListWrapper<>(
                possibleSpellcasterTypes);
        
        final List<RaceEnum> possibleRaceTypes = 
                RaceChoiceBoxHelper.determineRemainingRaceEnumChoices(remainingPrios);
        
        final ObservableList<RaceEnum> possibleRaceTypesObservable = new ObservableListWrapper<>(
                possibleRaceTypes);
        

        SpellcasterTypePriorityChoiceBox.setItems(possibleSpellcasterTypesObservable);

        
        RaceProrityChoiceBox.setItems(possibleRaceTypesObservable);

        
        AttributePriorityChoiceBox.setItems(possibleValuesObservable);

        SkillsPriorityChoiceBox.setItems(possibleValuesObservable);
        
        MoneyPriorityChoiceBox.setItems(possibleValuesObservable);
    }
    
    private void remainingPriosHelperOLD(EnumSet<PriorityClassEnum> remainingPrios) {
        final List<PriorityClassEnum> possibleValues = new ArrayList<>(remainingPrios);
        logger.info(remainingPrios.toString());

        final ObservableList<PriorityClassEnum> possibleValuesObservable = new ObservableListWrapper<>(
                possibleValues);
        SpellcasterTypePriorityChoiceBox.getItems().setAll(model.character.SpellcasterTypeEnum.values());
        RaceProrityChoiceBox.getItems().setAll(model.character.RaceEnum.values());
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
    
    void resetValues()  {
        resetChoiceBoxes();
//        remainingPriosHelperOLD(remainingPrios);
        resetChoiceBoxes();
        resetPrios();
//        remainingPriosHelperOLD(remainingPrios);
        resetChoiceBoxes();
        resetLabels();
//        remainingPriosHelperOLD(remainingPrios);
        resetChoiceBoxes();
//        remainingPriosHelperOLD(remainingPrios);
        resetChoiceBoxes();
        resetPrios();
        remainingPriosHelperOLD(remainingPrios);
        //remainingPriosHelperForResetButton(remainingPrios);
        resetLabels();
        lastSelectedSpellcasterTypeEnum = null;
        lastSelectedRaceEnum = null;
        lastSelectedAttributePriorityEnum = null;
        lastSelectedSkillPriorityEnum = null;
        lastSelectedMoneyPriorityEnum = null;
    }
    
    @FXML
    private void onResetButtonAction()  {
        resetValues();
    }
    
    @FXML
    void onCancelButtonAction(ActionEvent event) throws IOException  {
        System.out.println("Cancel button clicked behore show, a logger szar");
        logger.info("Cancel button clicked behore show...");
        CharacterTransferHelper.isStep1Visited = true;
        showFirstMenu();
        logger.info("Cancel button clicked after show...");
        
    }
    private void showFirstMenu() {
        try {
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/fxml/FirstMenu.fxml"));
            AnchorPane firstMenuView = (AnchorPane) loader1.load();
            loader1.setRoot(this);

            mainApp.getRootLayout().setCenter(firstMenuView);

            FirstMenuController firstMenuController = loader1.getController();
            firstMenuController.setMainApp(mainApp);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            mainApp.setCharEditorStep2AnchorPane(characterSheetEditorStep2);
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

        //SpellcasterTypePriorityChoiceBox.getItems().setAll(model.character.SpellcasterTypeEnum.values());
        
        remainingPriosHelper(remainingPrios);
        SpellcasterTypePriorityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, value, newValue) -> {
                    // LOGGING HERE
                    // ez itt jelenleg azt loggolja hogy MIRŐL váltunk
                    logger.info(SpellcasterTypePriorityChoiceBox.getSelectionModel().selectedItemProperty().toString());
                    List<SpellcasterTypeEnum> possibleSpellcasterValues = SpellcasterTypePriorityChoiceBox.getItems();
                    //logger.info(SpellcasterTypePriorityChoiceBox.getValue().toString());
                    
                    try {
                        switch(newValue.intValue()) {
                        case 0: /*non-spellcaster*/   
                            SpellcasterTypePriorityLabel.setText(possibleSpellcasterValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    SpellCasterChoiceBoxHelper
                                    .spellcasterEnumToPriorityEnumAdapter(
                                            possibleSpellcasterValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios )
                            );
                            break;
                        case 1: /*Wizard*/   
                            SpellcasterTypePriorityLabel.setText(possibleSpellcasterValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    SpellCasterChoiceBoxHelper
                                    .spellcasterEnumToPriorityEnumAdapter(
                                            possibleSpellcasterValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios)
                            );
                            break;
                        case 2: /*Adept*/   
                            SpellcasterTypePriorityLabel.setText(possibleSpellcasterValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    SpellCasterChoiceBoxHelper
                                    .spellcasterEnumToPriorityEnumAdapter(
                                            possibleSpellcasterValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios)
                            );
                            
                            break;
                        case 3: /*Specialized-Wizard*/   
                            SpellcasterTypePriorityLabel.setText(possibleSpellcasterValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    SpellCasterChoiceBoxHelper
                                    .spellcasterEnumToPriorityEnumAdapter(
                                            possibleSpellcasterValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios)
                            );
                            break;
                        
                        }
                        if(newValue.intValue() > -1)    {
                            lastSelectedSpellcasterTypeEnum = possibleSpellcasterValues.get(newValue.intValue());
                        }
                        stackForLastSelectedPrio.push(SpellCasterChoiceBoxHelper
                                .spellcasterEnumToPriorityEnumAdapter(
                                        lastSelectedSpellcasterTypeEnum,
                                        lastSelectedRaceEnum)
                        );
                        logger.info("Selected Wizard type: {}", lastSelectedSpellcasterTypeEnum);
                    // this switch is for managing the remainingPrios synched with the comboboxes
                    
                        if(value.intValue() > -1 )  {
                            logger.info("In SpellcasterTypeListener: 2nd switch");
                            switch(value.intValue()) {
                            case 0: /*non-spellcaster*/   
                                logger.info("In SpellcasterTypeListener: adding back to remining prios case1");
                                logger.info("{}",possibleSpellcasterValues.get(value.intValue()));
                                logger.info("{}",SpellCasterChoiceBoxHelper
                                        .spellcasterEnumToPriorityEnumAdapter(possibleSpellcasterValues.get(value.intValue())));
                                remainingPrios.add(
                                        SpellCasterChoiceBoxHelper
                                        .spellcasterEnumToPriorityEnumAdapter(
                                                possibleSpellcasterValues
                                                        .get(value.intValue()
                                                        ))
                                );
                                break;
                            case 1: /*Wizard*/   
                                logger.info("In SpellcasterTypeListener: adding back to remining prios case2");
                                logger.info("{}",possibleSpellcasterValues.get(value.intValue()));
                                logger.info("{}",SpellCasterChoiceBoxHelper
                                        .spellcasterEnumToPriorityEnumAdapter(possibleSpellcasterValues.get(value.intValue())));
                                remainingPrios.add(
                                        SpellCasterChoiceBoxHelper
                                        .spellcasterEnumToPriorityEnumAdapter(
                                                possibleSpellcasterValues
                                                        .get(value.intValue()
                                                        ))
                                );
                                break;
                            case 2: /*Adept*/  
                                logger.info("In SpellcasterTypeListener: adding back to remining prios case3");
                                logger.info("{}",possibleSpellcasterValues.get(value.intValue()));
                                logger.info("{}",SpellCasterChoiceBoxHelper
                                        .spellcasterEnumToPriorityEnumAdapter(possibleSpellcasterValues.get(value.intValue())));
                                remainingPrios.add(
                                        SpellCasterChoiceBoxHelper
                                        .spellcasterEnumToPriorityEnumAdapter(
                                                possibleSpellcasterValues
                                                        .get(value.intValue()
                                                        ))
                                );
                                break;
                            case 3: /*Specialized-Wizard*/   
                                logger.info("In SpellcasterTypeListener: adding back to remining prios case4");
                                logger.info("{}",possibleSpellcasterValues.get(value.intValue()));
                                logger.info("{}",SpellCasterChoiceBoxHelper
                                        .spellcasterEnumToPriorityEnumAdapter(possibleSpellcasterValues.get(value.intValue())));
                                remainingPrios.add(
                                        SpellCasterChoiceBoxHelper
                                        .spellcasterEnumToPriorityEnumAdapter(
                                                possibleSpellcasterValues
                                                        .get(value.intValue()
                                                        ))
                                );
                                break;
                            }                            
                        }
                    }
                    catch (NullPointerException e)    {
                        logger.info("FUCK ITS AN ERROR AT SpellcasterTypePriorityChoiceBox");
                    }
                    catch (IndexOutOfBoundsException e)   {
                        logger.info("FUCK ITS AN ERROR AT SpellcasterTypePriorityChoiceBox, IndexoutofBounds, but now worries");
                    }
                    
                    logger.info(remainingPrios.toString());
                    remainingPriosHelper(remainingPrios, SpellcasterTypePriorityChoiceBox);
//                    remainingPriosHelper(remainingPrios);
//                    SpellcasterTypePriorityChoiceBox.setDisable(true);
                }
        );
        
        // Race selection
        //RaceProrityChoiceBox.getItems().setAll(model.character.RaceEnum.values());
        
        //remainingPriosHelper(remainingPrios);
        RaceProrityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, value, newValue) -> {
                    // LOGGING HERE
                    // ez itt jelenleg azt loggolja hogy MIRŐL váltunk
                    logger.info(RaceProrityChoiceBox.getSelectionModel().selectedItemProperty().toString());
                    List<RaceEnum> possibleRaceValues = RaceProrityChoiceBox.getItems();
                    
                    switch(newValue.intValue()) {
                        case 0: /*human*/   
                            RaceProrityLabel.setText(possibleRaceValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    RaceChoiceBoxHelper
                                    .raceEnumToPriorityEnumAdapter(
                                            possibleRaceValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios)
                            );
                            
                            break;
                        case 1: /*Elf*/   
                            RaceProrityLabel.setText(possibleRaceValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    RaceChoiceBoxHelper
                                    .raceEnumToPriorityEnumAdapter(
                                            possibleRaceValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios)
                            );
                            break;
                        case 2: /*Troll*/   
                            RaceProrityLabel.setText(possibleRaceValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    RaceChoiceBoxHelper
                                    .raceEnumToPriorityEnumAdapter(
                                            possibleRaceValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios)
                            );
                            break;
                        case 3: /*Dwarf*/   
                            RaceProrityLabel.setText(possibleRaceValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    RaceChoiceBoxHelper
                                    .raceEnumToPriorityEnumAdapter(
                                            possibleRaceValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios)
                            );
                            
                            break;
                        case 4: /*Orc*/
                            RaceProrityLabel.setText(possibleRaceValues.get(newValue.intValue()).toString());
                            remainingPrios.remove(
                                    RaceChoiceBoxHelper
                                    .raceEnumToPriorityEnumAdapter(
                                            possibleRaceValues
                                                    .get(newValue.intValue()
                                                    ), remainingPrios)
                            );
                            
                            break;
                    }
                    // this switch is for managing the remainingPrios synched with the comboboxes
                    try {
                        if( (value.intValue() > -1) && (
                                RaceChoiceBoxHelper.raceEnumToPriorityEnumAdapter(
                                        possibleRaceValues.get(value.intValue())) != 
                                                RaceChoiceBoxHelper.raceEnumToPriorityEnumAdapter(possibleRaceValues.get(newValue.intValue())))
                                &&
                                    !(
                                        (SpellcasterTypePriorityChoiceBox.getValue() == SpellcasterTypeEnum.NON_SPELLCASTER)
                                        &&
                                        (
                                            (
                                                (
                                                    (possibleRaceValues.get(newValue.intValue()) == RaceEnum.HUMAN || possibleRaceValues.get(value.intValue()) == RaceEnum.HUMAN)
                                                    &&
                                                    (possibleRaceValues.get(newValue.intValue()) == RaceEnum.DWARF || possibleRaceValues.get(value.intValue()) == RaceEnum.DWARF)
                                                )
                                                ||
                                                (
                                                    (possibleRaceValues.get(newValue.intValue()) == RaceEnum.ORC || possibleRaceValues.get(value.intValue()) == RaceEnum.ORC)
                                                    &&
                                                    (possibleRaceValues.get(newValue.intValue()) == RaceEnum.HUMAN || possibleRaceValues.get(value.intValue()) == RaceEnum.HUMAN)
                                                )
                                            )
                                        )
                                    )
                          )   {
                            switch(value.intValue()) {
                                case 0: 
                                    remainingPrios.add(
                                            RaceChoiceBoxHelper
                                            .raceEnumToPriorityEnumAdapter(
                                                    possibleRaceValues
                                                            .get(value.intValue()
                                                            ))
                                    );
                                    break;
                                case 1: 
                                    remainingPrios.add(
                                            RaceChoiceBoxHelper
                                            .raceEnumToPriorityEnumAdapter(
                                                    possibleRaceValues
                                                            .get(value.intValue()
                                                            ))
                                    );
                                    break;
                                case 2:  
                                    remainingPrios.add(
                                            RaceChoiceBoxHelper
                                            .raceEnumToPriorityEnumAdapter(
                                                    possibleRaceValues
                                                            .get(value.intValue()
                                                            ))
                                    );
                                    break;
                                case 3:
                                    remainingPrios.add(
                                            RaceChoiceBoxHelper
                                            .raceEnumToPriorityEnumAdapter(
                                                    possibleRaceValues
                                                            .get(value.intValue()
                                                            ))
                                    );
                                    break;
                                case 4: remainingPrios.add(
                                            RaceChoiceBoxHelper
                                            .raceEnumToPriorityEnumAdapter(
                                                    possibleRaceValues
                                                            .get(value.intValue()
                                                            ))
                                    );
                                    break;
                            }
                        }
                    }
                    catch (IndexOutOfBoundsException e)   {
                        logger.info("FUCK ITS AN ERROR AT SpellcasterTypePriorityChoiceBox, IndexoutofBounds, but now worries");
                    }
                    
//                    lastSelectedRaceEnum = (RaceEnum) RaceProrityChoiceBox.getValue();
                    if(newValue.intValue() > -1)    {
                        lastSelectedRaceEnum = possibleRaceValues.get(newValue.intValue());
                    }
                    stackForLastSelectedPrio.push(
                            RaceChoiceBoxHelper
                                    .raceEnumToPriorityEnumAdapter(lastSelectedRaceEnum, 
                                            lastSelectedSpellcasterTypeEnum)
                    );
                    logger.info("Selected race: {}", lastSelectedRaceEnum);
                    logger.info("Remaining prios:");
                    logger.info(remainingPrios.toString());
                    remainingPriosHelper(remainingPrios, RaceProrityChoiceBox);
//                    RaceProrityChoiceBox.setDisable(true);
                }
        );

        //remainingPriosHelper(remainingPrios);
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
//                                AttributePriorityLabel.setText("");
                        }
                    }
                    catch(IndexOutOfBoundsException e)  {
                        //AttributePriorityLabel.setText("");
                        logger.error("Exception caught: ");
                        logger.error("While trying to set new attr label or remove from remaining prios.");

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
                    }
                    if(newValue.intValue() > -1)    {
                        lastSelectedAttributePriorityEnum = possibleAttrValues.get(newValue.intValue());
                    }
                    stackForLastSelectedPrio.push(lastSelectedAttributePriorityEnum);
                    logger.info("Attribute prio choosen. Remaining prios:");
                    logger.info(remainingPrios.toString());
                    remainingPriosHelper(remainingPrios, AttributePriorityChoiceBox);
//                    AttributePriorityChoiceBox.setDisable(true);
                }
        );
        
        //remainingPriosHelper(remainingPrios);
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
//                        SkillsPriorityLabel.setText("");
                        logger.error("Exception caught: ");
                        logger.error("While add back to remainingPrios varaible at SkillChoiceBox.");        
                        remainingPrios.add((PriorityClassEnum)SkillsPriorityChoiceBox.getValue());
                    }
                    finally {
                        
                    }
//                    lastSelectedSkillPriorityEnum = (PriorityClassEnum) SkillsPriorityChoiceBox.getValue();
                    if(newValue.intValue() > -1)    {
                        lastSelectedSkillPriorityEnum = possibleSkillValues.get(newValue.intValue());    
                    }
                    stackForLastSelectedPrio.push(lastSelectedSkillPriorityEnum);
                    logger.info("Selected Skill priority: {}", lastSelectedSkillPriorityEnum);
                    logger.info("Attribute skill choosen. Remaining prios:");
                    logger.info(remainingPrios.toString());
                    remainingPriosHelper(remainingPrios, SkillsPriorityChoiceBox);
//                    SkillsPriorityChoiceBox.setDisable(true);
                }
        );
        
        //remainingPriosHelper(remainingPrios);
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
                    }
                    finally {
                        
                    }
//                    lastSelectedMoneyPriorityEnum = (PriorityClassEnum) MoneyPriorityChoiceBox.getValue();
                    if(newValue.intValue() > -1)    {
                        lastSelectedMoneyPriorityEnum = possibleMoneyValues.get(newValue.intValue());
                    }
                    stackForLastSelectedPrio.push(lastSelectedMoneyPriorityEnum);
                    logger.info("Selected money prio: {}", lastSelectedMoneyPriorityEnum);
                    logger.info("Attribute skill choosen. Remaining prios:");
                    logger.info(remainingPrios.toString());
                    remainingPriosHelper(remainingPrios, MoneyPriorityChoiceBox);
//                    MoneyPriorityChoiceBox.setDisable(true);
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
        NameOfCharTextField.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable,
                String oldValue, String newValue) {

            NameOfCharLabel.setText(newValue);
            }
        });
        
        AgeOfCharTextField.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable,
                String oldValue, String newValue) {

            AgeOfCharLabel.setText(newValue);
            }
        });
        //CancelButton = new Button();
//        CancelButton.setOnAction(event -> {
//            logger.info("Cancel Button event listener is working!");
//            //showFirstMenu();
//        });

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
