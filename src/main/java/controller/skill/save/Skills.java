/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.skill.save;

import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.character.Skill;

/**
 *
 * @author Dr.Chase
 */
@XmlRootElement(name = "skills")
@XmlAccessorType (XmlAccessType.FIELD)
public class Skills {
    @XmlElement(name = "skill")
    private List<Skill> skills = null;

    public List<Skill> getSkills() {
        return skills;
    }

    public Skills(List<Skill> skills) {
        this.skills = skills;
    }

    public Skills() {
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
