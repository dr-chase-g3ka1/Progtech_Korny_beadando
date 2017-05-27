/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.character.helpers;

import model.character.AbstractCharacter;

/**
 *
 * @author Dr.Chase
 */
public class StartingAttributesHelper {
    private static final int CLASS_A_MAX_ATTRIBUTES = 30;
    private static final int CLASS_B_MAX_ATTRIBUTES = 27;
    private static final int CLASS_C_MAX_ATTRIBUTES = 24;
    private static final int CLASS_D_MAX_ATTRIBUTES = 21;
    private static final int CLASS_E_MAX_ATTRIBUTES = 18;
    
    private AbstractCharacter character;

    public StartingAttributesHelper(AbstractCharacter character) {
        this.character = character;
    }

    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }
    
    public static int getMaxAttributesFromCharacter(AbstractCharacter character)   {
        int nTemp = 0;
        switch (character.getPrioAttributes())  {
            case PRIORITY_A:
                nTemp = CLASS_A_MAX_ATTRIBUTES;
                break;
            case PRIORITY_B:
                nTemp = CLASS_B_MAX_ATTRIBUTES;
                break;
            case PRIORITY_C:
                nTemp = CLASS_C_MAX_ATTRIBUTES;
                break;
            case PRIORITY_D:
                nTemp = CLASS_D_MAX_ATTRIBUTES;
                break;
            case PRIORITY_E:
                nTemp = CLASS_E_MAX_ATTRIBUTES;
                break;
        }
        return nTemp;
    }
    
}
