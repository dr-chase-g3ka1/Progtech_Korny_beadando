/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Dr.Chase
 */
@XmlRootElement(name = "skill")
@XmlAccessorType (XmlAccessType.FIELD)

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
}
