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
public class StartingSkillPointsHelper {
    private static final int CLASS_A_MAX_SKILLPOINTS = 50;
    private static final int CLASS_B_MAX_SKILLPOINTS = 40;
    private static final int CLASS_C_MAX_SKILLPOINTS = 34;
    private static final int CLASS_D_MAX_SKILLPOINTS = 30;
    private static final int CLASS_E_MAX_SKILLPOINTS = 27;
    
    private AbstractCharacter character;

    public StartingSkillPointsHelper(AbstractCharacter character) {
        this.character = character;
    }

    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }
    
    public static int getMaxSkillpointsFromCharacter(AbstractCharacter character)   {
        int nTemp = 0;
        switch (character.getPrioSkills())  {
            case PRIORITY_A:
                nTemp = CLASS_A_MAX_SKILLPOINTS;
                break;
            case PRIORITY_B:
                nTemp = CLASS_B_MAX_SKILLPOINTS;
                break;
            case PRIORITY_C:
                nTemp = CLASS_C_MAX_SKILLPOINTS;
                break;
            case PRIORITY_D:
                nTemp = CLASS_D_MAX_SKILLPOINTS;
                break;
            case PRIORITY_E:
                nTemp = CLASS_E_MAX_SKILLPOINTS;
                break;
        }
        return nTemp;
    }
}
