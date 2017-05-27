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
public class StartingMoneyHelper {
    private static final long CLASS_A_MAX_MONEY = 1000000;
    private static final long CLASS_B_MAX_MONEY = 400000;
    private static final long CLASS_C_MAX_MONEY = 90000;
    private static final long CLASS_D_MAX_MONEY = 20000;
    private static final long CLASS_E_MAX_MONEY = 9000;
    
    private AbstractCharacter character;

    public StartingMoneyHelper(AbstractCharacter character) {
        this.character = character;
    }

    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }
    
    public static long getStartingMoneyFromCharacter(AbstractCharacter character)   {
        long nTemp = 0;
        switch (character.getPrioResources())  {
            case PRIORITY_A:
                nTemp = CLASS_A_MAX_MONEY;
                break;
            case PRIORITY_B:
                nTemp = CLASS_B_MAX_MONEY;
                break;
            case PRIORITY_C:
                nTemp = CLASS_C_MAX_MONEY;
                break;
            case PRIORITY_D:
                nTemp = CLASS_D_MAX_MONEY;
                break;
            case PRIORITY_E:
                nTemp = CLASS_E_MAX_MONEY;
                break;
        }
        return nTemp;
    }
}
