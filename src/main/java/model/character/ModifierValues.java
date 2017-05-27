/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character;

/**
 *
 * @author Dr.Chase
 */
public class ModifierValues {
    
    // These values will modify the Character's values
    // These are added values to the Character's values
    // Like char has 4 Body and there is a 1 bodyModifier then the modified value will be 5
    // 
    private int bodyModifier;
    private int agilityModifier;
    private int strengthModifier;
    private int charismaModifier;
    private int intelligenceModifier;
    private int willpowerModifier;
    
    private double essenceModifier;
    private int    reactionModifier;
    
    private int    NumOfInitiativeDiceModifier;
    
    private int combatDiceReserveModifier;
    private int magicDiceReserveModifier;
    private int astralDiceReserveModifier;
    private int dekasDiceReserveModifier;

    public ModifierValues(int bodyModifier, int agilityModifier, int strengthModifier, int charismaModifier, int intelligenceModifier, int willpowerModifier) {
        this.bodyModifier = bodyModifier;
        this.agilityModifier = agilityModifier;
        this.strengthModifier = strengthModifier;
        this.charismaModifier = charismaModifier;
        this.intelligenceModifier = intelligenceModifier;
        this.willpowerModifier = willpowerModifier;
    }

    public ModifierValues() { }
    
    

    public int getBodyModifier() {
        return bodyModifier;
    }

    public void setBodyModifier(int bodyModifier) {
        this.bodyModifier = bodyModifier;
    }

    public int getAgilityModifier() {
        return agilityModifier;
    }

    public void setAgilityModifier(int agilityModifier) {
        this.agilityModifier = agilityModifier;
    }

    public int getStrengthModifier() {
        return strengthModifier;
    }

    public void setStrengthModifier(int strengthModifier) {
        this.strengthModifier = strengthModifier;
    }

    public int getCharismaModifier() {
        return charismaModifier;
    }

    public void setCharismaModifier(int charismaModifier) {
        this.charismaModifier = charismaModifier;
    }

    public int getIntelligenceModifier() {
        return intelligenceModifier;
    }

    public void setIntelligenceModifier(int intelligenceModifier) {
        this.intelligenceModifier = intelligenceModifier;
    }

    public int getWillpowerModifier() {
        return willpowerModifier;
    }

    public void setWillpowerModifier(int willpowerModifier) {
        this.willpowerModifier = willpowerModifier;
    }

    public double getEssenceModifier() {
        return essenceModifier;
    }

    public void setEssenceModifier(double essenceModifier) {
        this.essenceModifier = essenceModifier;
    }

    public int getReactionModifier() {
        return reactionModifier;
    }

    public void setReactionModifier(int reactionModifier) {
        this.reactionModifier = reactionModifier;
    }

    public int getNumOfInitiativeDiceModifier() {
        return NumOfInitiativeDiceModifier;
    }

    public void setNumOfInitiativeDiceModifier(int NumOfInitiativeDiceModifier) {
        this.NumOfInitiativeDiceModifier = NumOfInitiativeDiceModifier;
    }

    public int getCombatDiceReserveModifier() {
        return combatDiceReserveModifier;
    }

    public void setCombatDiceReserveModifier(int combatDiceReserveModifier) {
        this.combatDiceReserveModifier = combatDiceReserveModifier;
    }

    public int getMagicDiceReserveModifier() {
        return magicDiceReserveModifier;
    }

    public void setMagicDiceReserveModifier(int magicDiceReserveModifier) {
        this.magicDiceReserveModifier = magicDiceReserveModifier;
    }

    public int getAstralDiceReserveModifier() {
        return astralDiceReserveModifier;
    }

    public void setAstralDiceReserveModifier(int astralDiceReserveModifier) {
        this.astralDiceReserveModifier = astralDiceReserveModifier;
    }

    public int getDekasDiceReserveModifier() {
        return dekasDiceReserveModifier;
    }

    public void setDekasDiceReserveModifier(int dekasDiceReserveModifier) {
        this.dekasDiceReserveModifier = dekasDiceReserveModifier;
    }
    
    
}
