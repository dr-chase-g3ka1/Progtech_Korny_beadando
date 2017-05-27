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
public class Modifier {
    private boolean isModificationPresent;
    private ModifierValues modifiedValues;

    public boolean getIsModificationPresent() {
        return isModificationPresent;
    }

    public void setIsModificationPresent(boolean isModificationPresent) {
        this.isModificationPresent = isModificationPresent;
    }

    public ModifierValues getModifiedValues() {
        return modifiedValues;
    }

    public void setModifiedValues(ModifierValues modifiedValues) {
        this.modifiedValues = modifiedValues;
    }

    public Modifier(boolean isModificationPresent, ModifierValues modifiedValues) {
        this.isModificationPresent = isModificationPresent;
        this.modifiedValues = modifiedValues;
    }

    public Modifier() {
    }
    
    
    
}
