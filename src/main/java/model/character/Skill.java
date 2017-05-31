/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Dr.Chase
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement(name = "skill")
//@XmlAccessorType (XmlAccessType.FIELD)

public class Skill {
    private String nameOfSkill;
    SkillAttrEnum attrOfSkill;
    private int levelOfSkill;
    
    private String description;
    
    private boolean isSpecialized;
    private String specialization;

    public String getNameOfSkill() {
        return nameOfSkill;
    }

    public void setNameOfSkill(String nameOfSkill) {
        this.nameOfSkill = nameOfSkill;
    }

    public SkillAttrEnum getAttrOfSkill() {
        return attrOfSkill;
    }

    public void setAttrOfSkill(SkillAttrEnum attrOfSkill) {
        this.attrOfSkill = attrOfSkill;
    }

    public int getLevelOfSkill() {
        return levelOfSkill;
    }

    public void setLevelOfSkill(int levelOfSkill) {
        this.levelOfSkill = levelOfSkill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsSpecialized() {
        return isSpecialized;
    }

    public void setIsSpecialized(boolean isSpecialized) {
        this.isSpecialized = isSpecialized;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
//    public SimpleStringProperty getNameOfSkillProperty() {
//        return new SimpleStringProperty(nameOfSkill);
//    }
//
//    public void setNameOfSkill(SimpleStringProperty nameOfSkill) {
//        this.nameOfSkill = nameOfSkill.getValue();
//    }
//
//
//    
//
//    public SimpleIntegerProperty getLevelOfSkillProperty() {
//        return new SimpleIntegerProperty(levelOfSkill);
//    }
//
//    public void setLevelOfSkill(SimpleIntegerProperty levelOfSkill) {
//        this.levelOfSkill = levelOfSkill.getValue();
//    }
//
//    public SimpleStringProperty getDescriptionProperty() {
//        return new SimpleStringProperty(description);
//    }
//
//    public void setDescription(SimpleStringProperty description) {
//        this.description = description.getValue();
//    }
}
