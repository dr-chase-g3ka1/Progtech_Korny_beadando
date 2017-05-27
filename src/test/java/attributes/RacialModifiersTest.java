/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributes;


import model.character.Modifier;
import model.character.constants.RacialModifiers;
import model.character.nonspellcaster.NonSpellcaster;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author Dr.Chase
 */

//Faji módosítók
//-------------------------------------------------------------------------------------------------------------------------------------------------------
//Törpe	|	+1 Test; +2 Erő +1 Akaraterő, Hőlátás, Ellenállás (+2 Test mindenfajta betegséggel és méreggel szemben)
//Tünde	|	+1 Gyorsaság +2 Karizma, Éjszakai Látás
//Ork	|	+3 Test, +2 Erő, -1 Karizma, -1 Intelligencia, Éjszakai Látás
//Troll	|	+5 Test, -1 Gyorsaság, +4 Erő, -2 Intelligencia, -2 Karizma, Hőlátás, +1 Elérés Fegyveres/Fegyvertelen harcban, Bőrpáncélzat (+1 Test)
//-------------------------------------------------------------------------------------------------------------------------------------------------------

public class RacialModifiersTest {
    NonSpellcaster testDwarf = new NonSpellcaster();
    
    NonSpellcaster testOrc = new NonSpellcaster();
    
    NonSpellcaster testTroll = new NonSpellcaster();
    
    NonSpellcaster testElf = new NonSpellcaster();
    
    NonSpellcaster testHuman = new NonSpellcaster();
    
    @BeforeClass
    void initializeChar()    {
        testDwarf.setBaseBody(5);
        testDwarf.setBaseAgility(5);
        testDwarf.setBaseStrength(5);
        testDwarf.setBaseCharisma(5);
        testDwarf.setBaseIntelligence(5);
        testDwarf.setBaseWillpower(5);
        
        Modifier dwarfModifier = RacialModifiers.DWARF_MODIFIER;
        testDwarf.setRacialModifier(dwarfModifier);
        
        //----------------------------------------------------------
        testOrc.setBaseBody(5);
        testOrc.setBaseAgility(5);
        testOrc.setBaseStrength(5);
        testOrc.setBaseCharisma(5);
        testOrc.setBaseIntelligence(5);
        testOrc.setBaseWillpower(5);
        
        Modifier orcModifier = RacialModifiers.ORC_MODIFIER;
        testOrc.setRacialModifier(dwarfModifier);
        
        //----------------------------------------------------------
        testTroll.setBaseBody(5);
        testTroll.setBaseAgility(5);
        testTroll.setBaseStrength(5);
        testTroll.setBaseCharisma(5);
        testTroll.setBaseIntelligence(5);
        testTroll.setBaseWillpower(5);
        
        Modifier trollModifier = RacialModifiers.TROLL_MODIFIER;
        testTroll.setRacialModifier(dwarfModifier);
        
        //----------------------------------------------------------
        testElf.setBaseBody(5);
        testElf.setBaseAgility(5);
        testElf.setBaseStrength(5);
        testElf.setBaseCharisma(5);
        testElf.setBaseIntelligence(5);
        testElf.setBaseWillpower(5);
        
        Modifier elfModifier = RacialModifiers.TROLL_MODIFIER;
        testElf.setRacialModifier(dwarfModifier);
        
        //----------------------------------------------------------
        testHuman.setBaseBody(5);
        testHuman.setBaseAgility(5);
        testHuman.setBaseStrength(5);
        testHuman.setBaseCharisma(5);
        testHuman.setBaseIntelligence(5);
        testHuman.setBaseWillpower(5);
        
        Modifier humanModifier = RacialModifiers.TROLL_MODIFIER;
        testHuman.setRacialModifier(dwarfModifier);
    }
}
