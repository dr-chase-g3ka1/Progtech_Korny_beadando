/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.character.helpers;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import model.character.AbstractCharacter;
import model.character.PriorityClassEnum;
import model.character.RaceEnum;
import model.character.SpellcasterTypeEnum;

/**
 *
 * @author Dr.Chase
 */
public class SpellCasterChoiceBoxHelper {
    
    public static List<SpellcasterTypeEnum> 
        determineRemainingSpellcasterEnumChoices
            (EnumSet<PriorityClassEnum> reminingPrios)  {
        List<SpellcasterTypeEnum> spellcasterList = new ArrayList<>();
        if(reminingPrios.contains(PriorityClassEnum.PRIORITY_A))    {
            spellcasterList.add(SpellcasterTypeEnum.WIZARD);
        }
        if(reminingPrios.contains(PriorityClassEnum.PRIORITY_B))    {
            spellcasterList.add(SpellcasterTypeEnum.ADEPT);
        }
        if(reminingPrios.contains(PriorityClassEnum.PRIORITY_C))    {
            spellcasterList.add(SpellcasterTypeEnum.SPECIALIZED_WIZARD);
        }
        if(reminingPrios.contains(PriorityClassEnum.PRIORITY_D)
                || reminingPrios.contains(PriorityClassEnum.PRIORITY_E))    {
            spellcasterList.add(SpellcasterTypeEnum.NON_SPELLCASTER);
        }
        return spellcasterList;
    }
            
    public static PriorityClassEnum 
        spellcasterEnumToPriorityEnumAdapter(SpellcasterTypeEnum spellcasterEnum)  {
            PriorityClassEnum prioEnum = null;
            if(spellcasterEnum == SpellcasterTypeEnum.WIZARD)  {
                prioEnum = PriorityClassEnum.PRIORITY_A;
            }
            if(spellcasterEnum == SpellcasterTypeEnum.ADEPT)  {
                prioEnum = PriorityClassEnum.PRIORITY_B;
            }
            if(spellcasterEnum == SpellcasterTypeEnum.SPECIALIZED_WIZARD)  {
                prioEnum = PriorityClassEnum.PRIORITY_C;
            }
            if(spellcasterEnum == SpellcasterTypeEnum.NON_SPELLCASTER)  {
                prioEnum = PriorityClassEnum.PRIORITY_E;
            }
            return prioEnum;
    }
        
    public static PriorityClassEnum 
        spellcasterEnumToPriorityEnumAdapter(SpellcasterTypeEnum spellcasterEnum, RaceEnum raceEnum)  {
            PriorityClassEnum prioEnum = null;
            if(spellcasterEnum == SpellcasterTypeEnum.WIZARD)  {
                prioEnum = PriorityClassEnum.PRIORITY_A;
            }
            if(spellcasterEnum == SpellcasterTypeEnum.ADEPT)  {
                prioEnum = PriorityClassEnum.PRIORITY_B;
            }
            if(spellcasterEnum == SpellcasterTypeEnum.SPECIALIZED_WIZARD)  {
                prioEnum = PriorityClassEnum.PRIORITY_C;
            }
            if(spellcasterEnum == SpellcasterTypeEnum.NON_SPELLCASTER)  {
                prioEnum = PriorityClassEnum.PRIORITY_E;
                if(raceEnum == RaceEnum.HUMAN | raceEnum == null)   {
                    prioEnum = PriorityClassEnum.PRIORITY_D;
                }
            }
            return prioEnum;
    }
    public static PriorityClassEnum 
    spellcasterEnumToPriorityEnumAdapter(SpellcasterTypeEnum spellcasterEnum, EnumSet<PriorityClassEnum> reminingPrios)  {
        PriorityClassEnum prioEnum = null;
        if(spellcasterEnum == SpellcasterTypeEnum.WIZARD)  {
            prioEnum = PriorityClassEnum.PRIORITY_A;
        }
        if(spellcasterEnum == SpellcasterTypeEnum.ADEPT)  {
            prioEnum = PriorityClassEnum.PRIORITY_B;
        }
        if(spellcasterEnum == SpellcasterTypeEnum.SPECIALIZED_WIZARD)  {
            prioEnum = PriorityClassEnum.PRIORITY_C;
        }
        if(spellcasterEnum == SpellcasterTypeEnum.NON_SPELLCASTER)  {
            prioEnum = PriorityClassEnum.PRIORITY_E;
            if(!reminingPrios.contains(PriorityClassEnum.PRIORITY_E))   {
                prioEnum = PriorityClassEnum.PRIORITY_D;
            }
        }
        return prioEnum;
    }
}
