/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrunchargenproto_v0.pkg0;

import model.character.nonspellcaster.NonSpellcaster;
import model.character.Skill;
import controller.skill.save.Skills;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import model.character.SkillAttrEnum;

/**
 *
 * @author Dr.Chase
 */
public class ShadowrunCharGenProto_v001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NonSpellcaster myFighter = new NonSpellcaster();
        String  s = myFighter.toString();
        System.out.println(s);
        
        //----------------------------------------------------------------------------
        Skills skills = new Skills(new ArrayList<Skill>());
        
        Skill skill1 = new Skill();
        Skill skill2 = new Skill();
        
        skill1.setNameOfSkill("Pistol skill");
        skill1.setAttrOfSkill(SkillAttrEnum.INTELLIGENCE);
        skill1.setDescription("Allows you to aim well with pistols.");
        skill1.setIsSpecialized(false);
        skill1.setLevelOfSkill(1);
        
        skill2.setAttrOfSkill(SkillAttrEnum.STRENGTH);
        skill2.setNameOfSkill("Unarmed fight");
        skill2.setDescription("Lets you fight with your fist well.");
        skill2.setLevelOfSkill(2);
        skill2.setIsSpecialized(false);
        
        skills.getSkills().add(skill1);
        skills.getSkills().add(skill2);
        
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Skills.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in console
            jaxbMarshaller.marshal(skills, System.out);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(skills, new File("D:/programming/Java/beadando_2017_progtech/temp/skills.xml"));
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
    }
    
}
