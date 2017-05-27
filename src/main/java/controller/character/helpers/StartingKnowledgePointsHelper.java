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
public class StartingKnowledgePointsHelper {
    public static int getStartingKnowledgePointsFromCharacter(AbstractCharacter character)  {
        int nResult;
        nResult = character.getBaseIntelligence() * 5;
        return nResult;
    }
}
