/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item.implant;

import model.character.Modifier;

/**
 *
 * @author Dr.Chase
 */
public class CyberWare extends model.item.AbstractItem {
    
    private int level;
    private int isLevelExist;
    
    private boolean isAlpha;
    private double costInEssence;
    
    ImplantBodyTypeEnum onPartOfBody;
    
    private model.character.Modifier modifier;
    
    public static final double alphaEssenceCostMultiplier = 0.8;
    public static final int    alphaPriceMultiplier = 2;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIsLevelExist() {
        return isLevelExist;
    }

    public void setIsLevelExist(int isLevelExist) {
        this.isLevelExist = isLevelExist;
    }

    public boolean getIsAlpha() {
        return isAlpha;
    }

    public void setIsAlpha(boolean isAlpha) {
        this.isAlpha = isAlpha;
    }

    public double getCostInEssence() {
        return costInEssence;
    }

    public void setCostInEssence(double costInEssence) {
        this.costInEssence = costInEssence;
    }

    public ImplantBodyTypeEnum getOnPartOfBody() {
        return onPartOfBody;
    }

    public void setOnPartOfBody(ImplantBodyTypeEnum onPartOfBody) {
        this.onPartOfBody = onPartOfBody;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }
}
