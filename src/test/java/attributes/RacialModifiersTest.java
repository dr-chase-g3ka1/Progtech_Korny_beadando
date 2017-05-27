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
    static NonSpellcaster testDwarf = new NonSpellcaster();
    
    static NonSpellcaster testOrc = new NonSpellcaster();
    
    static NonSpellcaster testTroll = new NonSpellcaster();
    
    static NonSpellcaster testElf = new NonSpellcaster();
    
    static NonSpellcaster testHuman = new NonSpellcaster();
    
    @BeforeClass
    public static void initializeChar()    {
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
        testOrc.setRacialModifier(orcModifier);
        
        //----------------------------------------------------------
        testTroll.setBaseBody(5);
        testTroll.setBaseAgility(5);
        testTroll.setBaseStrength(5);
        testTroll.setBaseCharisma(5);
        testTroll.setBaseIntelligence(5);
        testTroll.setBaseWillpower(5);
        
        Modifier trollModifier = RacialModifiers.TROLL_MODIFIER;
        testTroll.setRacialModifier(trollModifier);
        
        //----------------------------------------------------------
        testElf.setBaseBody(5);
        testElf.setBaseAgility(5);
        testElf.setBaseStrength(5);
        testElf.setBaseCharisma(5);
        testElf.setBaseIntelligence(5);
        testElf.setBaseWillpower(5);
        
        Modifier elfModifier = RacialModifiers.ELF_MODIFIER;
        testElf.setRacialModifier(elfModifier);
        
        //----------------------------------------------------------
        testHuman.setBaseBody(5);
        testHuman.setBaseAgility(5);
        testHuman.setBaseStrength(5);
        testHuman.setBaseCharisma(5);
        testHuman.setBaseIntelligence(5);
        testHuman.setBaseWillpower(5);
        
        Modifier humanModifier = RacialModifiers.HUMAN_MODIFIER;
        testHuman.setRacialModifier(humanModifier);
    }
    
    @Test
    public void HumanTestCase()    {
        assertEquals("FAILED! - HumanTestCase (Racial Modifiers - Body) ===> getModifiedBody()", 5, testHuman.getModifiedBody() );
        assertEquals("FAILED! - HumanTestCase (Racial Modifiers - Agility) ===> getModifiedBody()", 5, testHuman.getModifiedAgility());
        assertEquals("FAILED! - HumanTestCase (Racial Modifiers - Strength) ===> getModifiedBody()", 5, testHuman.getModifiedStrength());
        assertEquals("FAILED! - HumanTestCase (Racial Modifiers - Charisma) ===> getModifiedBody()", 5, testHuman.getModifiedCharisma());
        assertEquals("FAILED! - HumanTestCase (Racial Modifiers - Intelligence) ===> getModifiedBody()", 5, testHuman.getModifiedIntelligence());
        assertEquals("FAILED! - HumanTestCase (Racial Modifiers - Willpower) ===> getModifiedBody()", 5, testHuman.getModifiedWillpower());
    }
    
    @Test
    public void DwarfTestCase()    {
        assertEquals("FAILED! - DwarfTestCase (Racial Modifiers - Body) ===> getModifiedBody()", 6, testDwarf.getModifiedBody() );
        assertEquals("FAILED! - DwarfTestCase (Racial Modifiers - Agility) ===> getModifiedBody()", 5, testDwarf.getModifiedAgility());
        assertEquals("FAILED! - DwarfTestCase (Racial Modifiers - Strength) ===> getModifiedBody()", 7, testDwarf.getModifiedStrength());
        assertEquals("FAILED! - DwarfTestCase (Racial Modifiers - Charisma) ===> getModifiedBody()", 5, testDwarf.getModifiedCharisma());
        assertEquals("FAILED! - DwarfTestCase (Racial Modifiers - Intelligence) ===> getModifiedBody()", 5, testDwarf.getModifiedIntelligence());
        assertEquals("FAILED! - DwarfTestCase (Racial Modifiers - Willpower) ===> getModifiedBody()", 6, testDwarf.getModifiedWillpower());
    }
    
    @Test
    public void OrcTestCase()    {
        assertEquals("FAILED! - OrcTestCase (Racial Modifiers - Body) ===> getModifiedBody()", 8, testOrc.getModifiedBody() );
        assertEquals("FAILED! - OrcTestCase (Racial Modifiers - Agility) ===> getModifiedBody()", 5, testOrc.getModifiedAgility());
        assertEquals("FAILED! - OrcTestCase (Racial Modifiers - Strength) ===> getModifiedBody()", 7, testOrc.getModifiedStrength());
        assertEquals("FAILED! - OrcTestCase (Racial Modifiers - Charisma) ===> getModifiedBody()", 4, testOrc.getModifiedCharisma());
        assertEquals("FAILED! - OrcTestCase (Racial Modifiers - Intelligence) ===> getModifiedBody()", 4, testOrc.getModifiedIntelligence());
        assertEquals("FAILED! - OrcTestCase (Racial Modifiers - Willpower) ===> getModifiedBody()", 5, testOrc.getModifiedWillpower());
    }
    
    @Test
    public void TrollTestCase()    {
        assertEquals("FAILED! - TrollTestCase (Racial Modifiers - Body) ===> getModifiedBody()", 10, testTroll.getModifiedBody() );
        assertEquals("FAILED! - TrollTestCase (Racial Modifiers - Agility) ===> getModifiedBody()", 4, testTroll.getModifiedAgility());
        assertEquals("FAILED! - TrollTestCase (Racial Modifiers - Strength) ===> getModifiedBody()", 9, testTroll.getModifiedStrength());
        assertEquals("FAILED! - TrollTestCase (Racial Modifiers - Charisma) ===> getModifiedBody()", 3, testTroll.getModifiedCharisma());
        assertEquals("FAILED! - TrollTestCase (Racial Modifiers - Intelligence) ===> getModifiedBody()", 3, testTroll.getModifiedIntelligence());
        assertEquals("FAILED! - TrollTestCase (Racial Modifiers - Willpower) ===> getModifiedBody()", 5, testTroll.getModifiedWillpower());
    }
    
    @Test
    public void ElfTestCase()    {
        assertEquals("FAILED! - ElfTestCase (Racial Modifiers - Body) ===> getModifiedBody()", 5, testElf.getModifiedBody() );
        assertEquals("FAILED! - ElfTestCase (Racial Modifiers - Agility) ===> getModifiedBody()", 6, testElf.getModifiedAgility());
        assertEquals("FAILED! - ElfTestCase (Racial Modifiers - Strength) ===> getModifiedBody()", 5, testElf.getModifiedStrength());
        assertEquals("FAILED! - ElfTestCase (Racial Modifiers - Charisma) ===> getModifiedBody()", 7, testElf.getModifiedCharisma());
        assertEquals("FAILED! - ElfTestCase (Racial Modifiers - Intelligence) ===> getModifiedBody()", 5, testElf.getModifiedIntelligence());
        assertEquals("FAILED! - ElfTestCase (Racial Modifiers - Willpower) ===> getModifiedBody()", 5, testElf.getModifiedWillpower());
    }
    
}
