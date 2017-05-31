/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.skill.helpers;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableArray;
import model.character.Skill;
import model.character.SkillAttrEnum;

/**
 *
 * @author Dr.Chase
 */
public class SampleActiveSkillsHelper {
    public static final Skill sampleSkill1;
    
    public static final Skill sampleSkill2;
    
    public static final Skill sampleSkill3;
    
    public static List<Skill> getSampleSkillsAsList() {
        List<Skill> skillList = new ArrayList<>();
        skillList.add(sampleSkill1);
        skillList.add(sampleSkill2);
        skillList.add(sampleSkill3);
        
        return skillList;
    }
    
    public static List<SkillAdapter> getSampleSkillsAsAdapterSkillList() {
        List<SkillAdapter> skillAdapterList = new ArrayList<>();
        skillAdapterList.add(SkillAdapter.skillToSkillAdapter(sampleSkill1));
        skillAdapterList.add(SkillAdapter.skillToSkillAdapter(sampleSkill2));
        skillAdapterList.add(SkillAdapter.skillToSkillAdapter(sampleSkill3));
        
        return skillAdapterList;
    }
    
    
    
    static  {
        sampleSkill1 = new Skill();
        sampleSkill1.setNameOfSkill("Kávéfőzés");
        sampleSkill1.setDescription("A karakter szinttől függően tud kávét főzni.\n"
                + "1-es szinten borzalmas kávét főz, de  legalább meg tudja csinálni.\n"
                + "6-os szinten ő csinálja a város legjobb kávéját!\n");
        sampleSkill1.setLevelOfSkill(1);
        sampleSkill1.setAttrOfSkill(SkillAttrEnum.STRENGTH);
        sampleSkill1.setIsSpecialized(false);
        sampleSkill1.setSpecialization("none");
        
        sampleSkill2 = new Skill();
        sampleSkill2.setNameOfSkill("Fegyvertelen harc");
        sampleSkill2.setDescription("A karakter képessége hogy fegyverek nélkül el tudjon intézni ellenségeket.\n"
                + "1-es szinten ismeri az alap ütéseket és rugásokat.\n"
                + "6-os szinten körbepörgő-rugásával még Chuck Norrist is leterítené!\n");
        sampleSkill2.setLevelOfSkill(1);
        sampleSkill2.setAttrOfSkill(SkillAttrEnum.STRENGTH);
        sampleSkill2.setIsSpecialized(false);
        sampleSkill2.setSpecialization("none");
        
        sampleSkill3 = new Skill();
        sampleSkill3.setNameOfSkill("Lopakodás");
        sampleSkill3.setDescription("A karakter képessége hogy zajtalanul mozogjon.\n"
                + "1-es szinten zajos környezetben észrevétlen tud maradni éjjel.\n"
                + "6-os teljesen észrevehetetlen mint egy fekete macska a sötét éjszakában!\n");
        sampleSkill3.setLevelOfSkill(1);
        sampleSkill3.setAttrOfSkill(SkillAttrEnum.STRENGTH);
        sampleSkill3.setIsSpecialized(false);
        sampleSkill3.setSpecialization("none");
    }
    
    
}
