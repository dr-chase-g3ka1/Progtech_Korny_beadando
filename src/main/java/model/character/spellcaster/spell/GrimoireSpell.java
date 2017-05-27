/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character.spellcaster.spell;

/**
 *
 * @author Dr.Chase
 */
public class GrimoireSpell extends AbstractSpell {
    SpellTypeEnum type;
    // it sometimes based on a character attribute
    // we should count it based on that later
    private int targetNum;
    SpellDiceTargetNumberEnum targetNumType;
    SpellDurationEnum duration;
    
    //Exhaust
    // It's quite complex to evaluate it, so the exact calculations are TODO
    // For now I'll just write it out as text
    private String exhaust;
}
