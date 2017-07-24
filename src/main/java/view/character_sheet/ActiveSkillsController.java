/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.character_sheet;

import com.sun.javafx.collections.ObservableListWrapper;
import controller.character.helpers.StartingSkillPointsHelper;
import controller.skill.helpers.SampleActiveSkillsHelper;
import controller.skill.helpers.SkillAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.character.AbstractCharacter;
import model.character.PriorityClassEnum;
import model.character.skill.Skill;
import shadowrunchargenproto_v0.pkg0.LaunchFXApp;

/**
 * FXML Controller class
 *
 * @author Dr.Chase
 */
public class ActiveSkillsController {

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
    AbstractCharacter character;

    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }
    
    private void setActiveSkillpointsLabel(boolean isCharacterLoadedFromFile)    {
        if(isCharacterLoadedFromFile)   {
            SkillPointsLeftLabel.setText(Integer.toString(character.getAvailableActiveSkillPoints()));
        }
        else    {
            Integer cInteger = StartingSkillPointsHelper.getMaxSkillpointsFromCharacter(character);
            SkillPointsLeftLabel.setText(cInteger.toString());
        }
    }
    
    @FXML
    TableView<SkillAdapter> AvailableSkillsTableView;
    @FXML
    TableColumn<SkillAdapter, String> AvailableSkillsTableColumn;
    @FXML
    TableView<SkillAdapter> YourSkillsTableView;
    @FXML
    TableColumn<SkillAdapter, String> YourSkillsNameTableColumn;
    @FXML
    TableColumn<SkillAdapter, String> YourSkillsLevelTableColumn;
    @FXML
    Button AddSkillButton;
    @FXML
    Button RemoveSkillButton;
    
    @FXML
    private Label NameOfSkillLabel;
    @FXML
    private Label LevelOfSkillLabel;
    @FXML
    private Button PlusOneLevelButton;
    @FXML
    private Button SubstractOneLevelButton;
    @FXML
    private TextArea DescriptionTextArea;
    
    @FXML
    private Label SkillPointsLeftLabel;
    @FXML
    private Button OkButton;
    @FXML
    private Button CancelButton;
    
    private ObservableList<SkillAdapter> availableSkillObservableList;
    
    private ObservableList<SkillAdapter> yourSkillObservableList;
    
    void fillAvailableSkillsInTable()   {
        availableSkillObservableList = 
                new ObservableListWrapper<>(SampleActiveSkillsHelper.getSampleSkillsAsAdapterSkillList());
    }
    
    boolean doYouHaveAvailabelSkillPoints() {
        boolean bResult = false;
        Integer cIntegerOfAvailableSkillPoints = Integer.parseUnsignedInt(SkillPointsLeftLabel.getText());
        Integer cIntegerOfSkillCost = Integer.parseUnsignedInt(LevelOfSkillLabel.getText());
        Integer temp = cIntegerOfAvailableSkillPoints - cIntegerOfSkillCost;
        if(temp > 0)    {
            bResult = true;
        }
        return bResult;
    }
    
    void changeLabelsWhenNewItemIsSelectedFromAvalableSkillsTable(SkillAdapter skillAdapter)   {
        if(skillAdapter != null)    {
            System.out.println(skillAdapter.getNameOfSkillString());
            NameOfSkillLabel.setText(skillAdapter.getNameOfSkillString());
            System.out.println(Integer.toString(skillAdapter.getLevelOfSkillInt()));
            LevelOfSkillLabel.setText(Integer.toString(skillAdapter.getLevelOfSkillInt()));
            System.out.println(skillAdapter.getDescriptionString());
            DescriptionTextArea.setText(skillAdapter.getDescriptionString());
        }
    }
    
    
    @FXML
    void onPlusOneLevelButtonClicked()  {
        Integer cInteger = Integer.parseUnsignedInt(LevelOfSkillLabel.getText());
        if(AvailableSkillsTableView.getSelectionModel().selectedIndexProperty().getValue() > -1)    {
            if(cInteger < 6)   {
            cInteger = cInteger + 1;
            LevelOfSkillLabel.setText(cInteger.toString());
            }
        }
    }
    
    @FXML
    void onMinusOneLevelButtonClicked()  {
        Integer cInteger = Integer.parseUnsignedInt(LevelOfSkillLabel.getText());
        if(AvailableSkillsTableView.getSelectionModel().selectedIndexProperty().getValue() > -1)    {
            if(cInteger > 1)   {
            cInteger = cInteger - 1;
            LevelOfSkillLabel.setText(cInteger.toString());
            }
        }
    }
    
    @FXML
    void onAddSkillButtonClicked()  {
        int selctedIndex = AvailableSkillsTableView.getSelectionModel().getSelectedIndex();
        if (selctedIndex > -1 && doYouHaveAvailabelSkillPoints())  {
            Integer cIntegerOfAvailableSkillPoints = Integer.parseUnsignedInt(SkillPointsLeftLabel.getText());
            Integer cIntegerOfSkillCost = Integer.parseUnsignedInt(LevelOfSkillLabel.getText());
            Integer temp = cIntegerOfAvailableSkillPoints - cIntegerOfSkillCost;
            SkillPointsLeftLabel.setText(temp.toString());
            
            SkillAdapter yourNewSkill = AvailableSkillsTableView.getItems().get(selctedIndex);
            yourNewSkill.setLevelOfSkill(cIntegerOfSkillCost);
            YourSkillsTableView.getItems().add(yourNewSkill);
            
            AvailableSkillsTableView.getItems().remove(selctedIndex);
        }
    }
    
    @FXML
    void onRemoveSkillButtonClicked()  {
        int selctedIndex = YourSkillsTableView.getSelectionModel().getSelectedIndex();
        if (selctedIndex > -1 )  {
            SkillAdapter yourUnnecessarySkill = YourSkillsTableView.getItems().get(selctedIndex);
            Integer cIntegerOfAvailableSkillPoints = Integer.parseUnsignedInt(SkillPointsLeftLabel.getText());
            Integer temp = cIntegerOfAvailableSkillPoints + yourUnnecessarySkill.getLevelOfSkillInt();
            SkillPointsLeftLabel.setText(temp.toString());
            
            YourSkillsTableView.getItems().remove(selctedIndex);
            
            yourUnnecessarySkill.setLevelOfSkill(1);
            
            AvailableSkillsTableView.getItems().add(yourUnnecessarySkill);
        }
    }
    
    @FXML
    void onCancelButtonClicked()    {
        mainApp.getRootLayout().setCenter(mainApp.getCharEditorStep3AnchorPane());
    }
    
    @FXML 
    void onOkButtonClicked()    {
        System.out.println(character.getListOfSkills());
        character.setAvailableActiveSkillPoints(Integer.parseUnsignedInt(SkillPointsLeftLabel.getText()));
        List<SkillAdapter> skillAdapterList = YourSkillsTableView.getItems();
        Set<Skill> foo = new HashSet<>(character.getListOfSkills());
        for(int iii = 0; iii < skillAdapterList.size() ; iii++  )    {
            
            foo.add(skillAdapterList.get(iii).getConvertToSkillWithoutProperties());
        }
        character.setListOfSkills(new ArrayList<>(Arrays.asList(foo.toArray(new Skill[foo.size()]))));
        mainApp.getRootLayout().setCenter(mainApp.getCharEditorStep3AnchorPane());
        CharacterTransferHelper.transferCharacter = character;
        System.out.println(character.getAvailableActiveSkillPoints());
        System.out.println(character.getListOfSkills());
        CharacterTransferHelper.isSkillSpent = true;
        mainApp.getCharEditorStep3Controller().ActiveSkillPointsLabel.setText(Integer.toString(character.getAvailableActiveSkillPoints()));
        
    }
    
    void initializeLabels() {
        NameOfSkillLabel.setText("");
        LevelOfSkillLabel.setText("");
        DescriptionTextArea.setText("");
        
        setActiveSkillpointsLabel(CharacterTransferHelper.isCharacterLoadedFromFile);
    }
    
    public void initialize() {
        character = CharacterTransferHelper.transferCharacter;
        initializeLabels();
        availableSkillObservableList = FXCollections.observableArrayList();
        System.out.println(SampleActiveSkillsHelper.getSampleSkillsAsAdapterSkillList());
        availableSkillObservableList.setAll(SampleActiveSkillsHelper.getSampleSkillsAsAdapterSkillList());
        AvailableSkillsTableView.setItems(availableSkillObservableList);
        AvailableSkillsTableColumn.setCellValueFactory(cellData -> cellData.getValue().getNameOfSkill());
        
        AvailableSkillsTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> 
                        changeLabelsWhenNewItemIsSelectedFromAvalableSkillsTable(newValue));
        
        if(!CharacterTransferHelper.isCharacterLoadedFromFile)  {
            yourSkillObservableList = FXCollections.observableArrayList();
            //yourSkillObservableList.setAll(SampleActiveSkillsHelper.getSampleSkillsAsAdapterSkillList());
            YourSkillsTableView.setItems(yourSkillObservableList);
        }
        else    {
            yourSkillObservableList = FXCollections.observableArrayList();
            for (Skill skill : character.getListOfSkills()) {
                yourSkillObservableList.add(SkillAdapter.skillToSkillAdapter(skill));
            }
            YourSkillsTableView.setItems(yourSkillObservableList);
        }
        
        YourSkillsNameTableColumn.setCellValueFactory(cellData -> cellData.getValue().getNameOfSkill());
        YourSkillsLevelTableColumn.setCellValueFactory(cellData -> cellData.getValue().getLevelOfSkill().asString());
        
        YourSkillsTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    changeLabelsWhenNewItemIsSelectedFromAvalableSkillsTable(observable.getValue());
                    changeLabelsWhenNewItemIsSelectedFromAvalableSkillsTable(newValue);
                    
                }
                        
        );
        
        
        
        
        //AvailableSkillsTableColumn.setCellValueFactory(cellData -> cellData.getValue().getNameOfSkillProperty());
//        final ObservableList<Skill> data =
//            FXCollections.observableArrayList(SampleActiveSkillsHelper.getSampleSkillsAsList());
//        AvailableSkillsTableColumn.setCellValueFactory(
//                new PropertyValueFactory<>("Skill Name"));
        //AvailableSkillsTableView.getItems().addAll(SampleActiveSkillsHelper.getSampleSkillsAsList());
    }    
    
}
