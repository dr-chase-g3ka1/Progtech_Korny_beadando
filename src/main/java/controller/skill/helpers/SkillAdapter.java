/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.skill.helpers;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import model.character.Skill;
import model.character.SkillAttrEnum;

/**
 *
 * @author Dr.Chase
 */
public final class SkillAdapter {
    private SimpleStringProperty nameOfSkill;
    SkillAttrEnum attrOfSkill;
    private SimpleIntegerProperty levelOfSkill;
    
    private SimpleStringProperty description;
    
    private SimpleBooleanProperty isSpecialized;
    private SimpleStringProperty specialization;

    public SimpleStringProperty getNameOfSkill() {
        return nameOfSkill;
    }

    public void setNameOfSkill(SimpleStringProperty nameOfSkill) {
        this.nameOfSkill = nameOfSkill;
    }

    public SkillAttrEnum getAttrOfSkill() {
        return attrOfSkill;
    }

    public void setAttrOfSkill(SkillAttrEnum attrOfSkill) {
        this.attrOfSkill = attrOfSkill;
    }

    public SimpleIntegerProperty getLevelOfSkill() {
        return levelOfSkill;
    }

    public void setLevelOfSkill(SimpleIntegerProperty levelOfSkill) {
        this.levelOfSkill = levelOfSkill;
    }

    public SimpleStringProperty getDescription() {
        return description;
    }

    public void setDescription(SimpleStringProperty description) {
        this.description = description;
    }

    public SimpleBooleanProperty getIsSpecialized() {
        return isSpecialized;
    }

    public void setIsSpecialized(SimpleBooleanProperty isSpecialized) {
        this.isSpecialized = isSpecialized;
    }

    public SimpleStringProperty getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SimpleStringProperty specialization) {
        this.specialization = specialization;
    }
    
    
    public String getNameOfSkillString() {
        return nameOfSkill.getValue();
    }

    public void setNameOfSkill(String nameOfSkill) {
        this.nameOfSkill.setValue(nameOfSkill);
    }



    public int getLevelOfSkillInt() {
        return levelOfSkill.getValue();
    }

    public void setLevelOfSkill(int levelOfSkill) {
        this.levelOfSkill.setValue(levelOfSkill);
    }

    public String getDescriptionString() {
        return description.getValue();
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }

    public boolean getIsSpecializedBoolean() {
        return isSpecialized.getValue();
    }

    public void setIsSpecialized(boolean isSpecialized) {
        this.isSpecialized.setValue(isSpecialized); 
    }

    public String getSpecializationString() {
        return specialization.getValue();
    }

    public void setSpecializationFromString(String specialization) {
        this.specialization.setValue(specialization);
    }

    public SkillAdapter(model.character.Skill skill) {
        nameOfSkill.setValue(skill.getNameOfSkill());
        this.attrOfSkill = skill.getAttrOfSkill();
        levelOfSkill.setValue(skill.getLevelOfSkill());
        description.setValue(skill.getDescription());
        isSpecialized.setValue(skill.isIsSpecialized());
        specialization.setValue(skill.getSpecialization());
    }

    public SkillAdapter() {
        nameOfSkill = new SimpleStringProperty();
        attrOfSkill =  SkillAttrEnum.STRENGTH;
        levelOfSkill = new SimpleIntegerProperty();
        description = new SimpleStringProperty();
        isSpecialized = new SimpleBooleanProperty();
        specialization = new SimpleStringProperty();
    }
    
    public static SkillAdapter skillToSkillAdapter(model.character.Skill skill) {
        SkillAdapter skillAdapter = new SkillAdapter();
        skillAdapter.nameOfSkill.setValue(skill.getNameOfSkill());
        skillAdapter.attrOfSkill = skill.getAttrOfSkill();
        skillAdapter.levelOfSkill.setValue(skill.getLevelOfSkill());
        skillAdapter.description.setValue(skill.getDescription());
        skillAdapter.isSpecialized.setValue(skill.isIsSpecialized());
        skillAdapter.specialization.setValue(skill.getSpecialization());
        return skillAdapter;
    }
    
    public model.character.Skill getConvertToSkillWithoutProperties()    {
        model.character.Skill outputSkill = new model.character.Skill();
        outputSkill.setNameOfSkill(this.nameOfSkill.getValue());
        outputSkill.setAttrOfSkill(this.attrOfSkill);
        outputSkill.setLevelOfSkill(this.levelOfSkill.getValue());
        outputSkill.setDescription(this.description.getValue());
        outputSkill.setSpecialization(this.specialization.getValue());
        outputSkill.setIsSpecialized(this.getIsSpecializedBoolean());
        return outputSkill;
    }
    
    
    
}
