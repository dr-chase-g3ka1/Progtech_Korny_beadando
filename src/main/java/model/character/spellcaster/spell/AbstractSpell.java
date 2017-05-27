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
public abstract class AbstractSpell {
    protected String name;
    protected String description;
    protected int maxLevelOfSpell; // the maximum level which the caster can use
    protected model.character.spellcaster.TraditionTypeEnum usableByTradition;
    protected model.character.spellcaster.SpellcasterTypeEnum usableBySpellcasterType;
}
