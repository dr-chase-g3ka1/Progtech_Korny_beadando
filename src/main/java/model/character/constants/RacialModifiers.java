/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character.constants;

import model.character.Modifier;
import model.character.ModifierValues;

/**
 *
 * @author Dr.Chase
 */
public final class RacialModifiers {
    /**
     * Modifiers for humans.
     */
    public static final ModifierValues HumanModifierValues;
    public static final Modifier HUMAN_MODIFIER;
    
    public static final ModifierValues DwarfModifierValues;
    public static final Modifier DWARF_MODIFIER;
    
    public static final ModifierValues ElfModifierValues;
    public static final Modifier ELF_MODIFIER;
    
    public static final ModifierValues OrcModifierValues;
    public static final Modifier ORC_MODIFIER;
    
    public static final ModifierValues TrollModifierValues;
    public static final Modifier TROLL_MODIFIER;
    
    static  {
        // ModifierValues(int bodyModifier, int agilityModifier, int strengthModifier, int charismaModifier, int intelligenceModifier, int willpowerModifier)
        
        HumanModifierValues = new ModifierValues(0, 0, 0, 0, 0, 0);
        HUMAN_MODIFIER = new Modifier(false, HumanModifierValues);
        
        DwarfModifierValues = new ModifierValues(1, 0, 2, 0, 0, 1);
        DWARF_MODIFIER = new Modifier(true, DwarfModifierValues);
        
        ElfModifierValues = new ModifierValues(0, 1, 0, 2, 0, 1);
        ELF_MODIFIER = new Modifier(true, ElfModifierValues);
        
        OrcModifierValues = new ModifierValues(3, 0, 2, -1, -1, 0);
        ORC_MODIFIER = new Modifier(true, OrcModifierValues);
        
        TrollModifierValues = new ModifierValues(5, -1, 4, -2, -2, 0);
        TROLL_MODIFIER = new Modifier(true, TrollModifierValues);
    }
}
