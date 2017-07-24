/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character.skill;

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
/**
 * This class represents active skills.
 * Each skill is tied to an attribute. When a character's skill level reaches
 * the level of the attribute, improving that skill will cost more.
 * At character generation the user can buy a skill with skill points
 * but when the character finsihed generation, skills can be bought with 
 * good charma points.
 * Active skills are used for example when the character shoots with a firearm.
 * Shooting a pistol uses the pistol skill. Shooting an assault rifle uses the
 * assault rifle skill and so on.
 * Characters can specialize their active skills. For example if one character
 * wants to specialize to "Ares Predator" pistol, he can do that. His 
 * specialization level will be added to the level of the skill when he or she
 * is using the Ares Predator pistol, but the specialization level will be 
 * subtracted from the level of the skill, when he is using any other type
 * of pistol.
 * Example: character has level 4 pistol skill, and level 1 specialization to
 * Ares Predator. When he is using the Ares Predator, his pistol skill will be
 * level 5, but when he is using a Glock his pistol skill will be 3.
 * At character generation, only one specialization is allowed.
 * When a character "level ups" by spending good charma, he or she can
 * get another specialization. In game specializations don't have skill penalty
 * so the specialization's level will not be subtracted from the skill level.
 * Other constraints:
 * Specialization level can't exceed the level of the base skill.
 * For example:
 * With level 3 pistol skill, Ares Predator specialization can't be more than 
 * level 3.
 * The character can't have more specialization than the level of the attribute
 * tied to the actual skill.
 * For example:
 * Character has agility level 4, then he can havea maximum of
 * 4 specializations for pistol skill.
 */
public class Skill {
    private String nameOfSkill;
    SkillAttrEnum attrOfSkill;
    ActiveSkillCategoryEnum skillCategoryEnum;
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
