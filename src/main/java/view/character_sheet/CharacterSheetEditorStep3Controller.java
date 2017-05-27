/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.character_sheet;

import controller.xml.savecharacter.XMLSaver;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import model.character.AbstractCharacter;
import model.character.GenderEnum;
import model.character.PriorityClassEnum;
import controller.character.helpers.StartingLanguagelPointsHelper;
import controller.character.helpers.StartingSkillPointsHelper;
import model.character.SpellcasterTypeEnum;
import controller.character.helpers.StartingKnowledgePointsHelper;
import shadowrunchargenproto_v0.pkg0.LaunchFXApp;

/**
 * FXML Controller class
 *
 * @author Dr.Chase
 */
public class CharacterSheetEditorStep3Controller {

    /**
     * Initializes the controller class.
     */
    private CharacterSheetEditorStep2Controller characterSheetEditorStep2Controller;
    
    private CharacterSheetEditorStep1Controller characterSheetEditorStep1Controller;
    
    private LaunchFXApp mainApp;
    
    private AbstractCharacter character;
    
    @FXML
    Label NameOfCharLabel;
    
    @FXML
    Label GenderCharLabel;
    
    @FXML
    Label RaceOfCharLabel;
    
    // ***************************************************************************
    //                              Attributes
    // ***************************************************************************
    
    @FXML
    Label BaseBodyLabel;
    
    @FXML
    Label BaseAgilityLabel;
    
    @FXML
    Label BaseStrengthLabel;
    
    @FXML
    Label BaseCharismaLabel;
    
    @FXML
    Label BaseIntelligenceLabel;
    
    @FXML
    Label BaseWillpowerLabel;
    
    
    @FXML
    Label ModifiedBodyLabel;
    
    @FXML
    Label ModifiedAgilityLabel;
    
    @FXML
    Label ModifiedStrengthLabel;
    
    @FXML
    Label ModifiedCharismaLabel;
    
    @FXML
    Label ModifiedIntelligenceLabel;
    
    @FXML
    Label ModifiedWillpowerLabel;
    
    
    @FXML
    Label EssenceLabel;
    
    @FXML
    Label MagicianTypeLabel;
    
    @FXML
    Label ReactionLabel;
    
    
    @FXML
    Label ActiveSkillPointsLabel;
    
    @FXML
    Label KnowledgeSkillPointsLabel;
    
    @FXML
    Label LanguageSkillPointsLabel;
    
    @FXML
    Label MoneyLabel;
    
    @FXML
    Button SaveButton;
    

    public CharacterSheetEditorStep2Controller getCharacterSheetEditorStep2Controller() {
        return characterSheetEditorStep2Controller;
    }

    public void setCharacterSheetEditorStep2Controller(CharacterSheetEditorStep2Controller characterSheetEditorStep2Controller) {
        this.characterSheetEditorStep2Controller = characterSheetEditorStep2Controller;
    }

    public CharacterSheetEditorStep1Controller getCharacterSheetEditorStep1Controller() {
        return characterSheetEditorStep1Controller;
    }

    public void setCharacterSheetEditorStep1Controller(CharacterSheetEditorStep1Controller characterSheetEditorStep1Controller) {
        this.characterSheetEditorStep1Controller = characterSheetEditorStep1Controller;
    }

    public LaunchFXApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(LaunchFXApp mainApp) {
        this.mainApp = mainApp;
    }

    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }
    
    @FXML
    private void setNameOfCharLabel()   {
        NameOfCharLabel.setText(character.getName());
    }
    
    @FXML
    private void setGenderLabel()   {
        GenderEnum genderEnum = character.getGender();
        switch(genderEnum)  {
            case MALE:
                GenderCharLabel.setText("Male");
                break;
            case FEMALE:
                GenderCharLabel.setText("Female");
                break;
            default:
                GenderCharLabel.setText("WTF");
        }
    }
    
    private void setRaceLabelNiceText() {
        switch(character.getRace()) {
            case HUMAN:
                RaceOfCharLabel.setText("Human");
                break;
            case DWARF:
                RaceOfCharLabel.setText("Dwarf");
                break;
            case ORC:
                RaceOfCharLabel.setText("Orc");
                break;
            case TROLL:
                RaceOfCharLabel.setText("Troll");
                break;
            case ELF:
                RaceOfCharLabel.setText("Elf");
                break;
        }
    }
    
    @FXML
    private void setBaseBodyLabel() {
        Integer cInteger = new Integer(character.getBaseBody());
        BaseBodyLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setBaseAgilityLabel() {
        Integer cInteger = character.getBaseAgility();
        BaseAgilityLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setBaseStrengthLabel() {
        Integer cInteger = character.getBaseStrength();
        BaseStrengthLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setBaseCharismaLabel() {
        Integer cInteger = character.getBaseCharisma();
        BaseCharismaLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setBaseIntelligenceodyLabel() {
        Integer cInteger = character.getBaseIntelligence();
        BaseIntelligenceLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setBaseWillpowerLabel() {
        Integer cInteger = character.getBaseWillpower();
        BaseWillpowerLabel.setText(cInteger.toString());
    }
    
    // ************************************************************
    
    @FXML
    private void setModifiedBodyLabel() {
        System.out.println("setModifiedBodyLabel:");
        System.out.println(character.getModifiedBody());
        Integer cInteger = character.getModifiedBody();
        ModifiedBodyLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setModifiedAgilityLabel() {
        Integer cInteger = character.getModifiedAgility();
        ModifiedAgilityLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setModifiedStrengthLabel() {
        Integer cInteger = character.getModifiedStrength();
        ModifiedStrengthLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setModifiedCharismaLabel() {
        Integer cInteger = character.getModifiedCharisma();
        ModifiedCharismaLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setModifiedIntelligenceodyLabel() {
        Integer cInteger = character.getModifiedIntelligence();
        ModifiedIntelligenceLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setModifiedWillpowerLabel() {
        Integer cInteger = character.getModifiedWillpower();
        ModifiedWillpowerLabel.setText(cInteger.toString());
    }
    
    // ***********************************************************************
    //                          Second column, 1st grid
    // ***********************************************************************
    
    @FXML
    private void setActiveSkillPointsLabel() {
        PriorityClassEnum skillsPrio = character.getPrioSkills();
        Integer cInteger = StartingSkillPointsHelper.getMaxSkillpointsFromCharacter(character);
        ActiveSkillPointsLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setKnowledgeSkillPointsLabel() {
        Integer cInteger = StartingKnowledgePointsHelper.getStartingKnowledgePointsFromCharacter(character);
        KnowledgeSkillPointsLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setLanguageSkillPointsLabelLabel() {
        Integer cInteger = StartingLanguagelPointsHelper.getStartingLanguagePointsFromCharacter(character);
        LanguageSkillPointsLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void setMoneyLabel() {
        Long cLong = character.getMoney();
        MoneyLabel.setText(cLong.toString());
    }
    
    @FXML
    private void setEssenceLabel()  {
        Double cDouble = character.getEssence();
        EssenceLabel.setText(cDouble.toString());
    }
    
    @FXML
    private void setMagicianTypeLabel()  {
        model.character.SpellcasterTypeEnum spellcasterTypeEnum = character.getSpellcasterType();
        String strOutput;
        switch(spellcasterTypeEnum) {
            case NON_SPELLCASTER:
                strOutput = "Can't do any magic";
                break;
            case WIZARD:
                strOutput = "Full featured wizard";
                break;
            case ADEPT:
                strOutput = "Adept";
                break;
            case SPECIALIZED_WIZARD:
                strOutput = "Specialized wizard";
                break;
            default:
                strOutput = "WTF";
        }
        MagicianTypeLabel.setText(strOutput);
    }
    
    @FXML
    private void setReactionLabel()  {
        Integer cInteger = character.getReaction();
        ReactionLabel.setText(cInteger.toString());
    }
    
    @FXML
    private void onSaveButtonClicked()  {
        //Logging
        System.out.println("Step3 - Save button clicked!");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Character");
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.dir"))
        ); 
        System.out.println("Saving Character");
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (file != null) {
            XMLSaver.saveCharacterToFileXML(character, file);
            System.out.println("Step3 - character saved as xml file.");
        }
    }
    
    
    
    private void setFirstGridDatas()  {
        setNameOfCharLabel();
        setGenderLabel();
        setRaceLabelNiceText();
    }
    
    private void setSecondGridAttributeDatas()  {
        setBaseBodyLabel();
        setBaseAgilityLabel();
        setBaseStrengthLabel();
        setBaseCharismaLabel();
        setBaseIntelligenceodyLabel();
        setBaseWillpowerLabel();
        
        setModifiedBodyLabel();
        setModifiedAgilityLabel();
        setModifiedStrengthLabel();
        setModifiedCharismaLabel();
        setModifiedIntelligenceodyLabel();
        setModifiedWillpowerLabel();
    }
    
    private void setThirdGridDatas() {
        setEssenceLabel();
        setMagicianTypeLabel();
        setReactionLabel();
    }
    
    private void setFirstGridInSecondColumnDatas() {
        setActiveSkillPointsLabel();
        setKnowledgeSkillPointsLabel();
        setLanguageSkillPointsLabelLabel();
        setMoneyLabel();
    }
    
    public void initialize() {
        character = CharacterTransferHelper.transferCharacter;
        setFirstGridDatas();
        setSecondGridAttributeDatas();
        setThirdGridDatas();
        setFirstGridInSecondColumnDatas();
//        XMLSaver.printOutCharacterXML(character);
//        XMLSaver.saveCharacterToFileXML(character);
    }    
    
}
