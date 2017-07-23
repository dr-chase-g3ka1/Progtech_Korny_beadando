/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.character.helpers;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
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
        
    public static SpellcasterTypeEnum PrioEnumToSpellcasterEnum(PriorityClassEnum prioEnum /*, RaceEnum raceEnum*/) {
        SpellcasterTypeEnum spellcasterTypeEnumOutput = null;
        switch(prioEnum)    {
            case PRIORITY_A:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.WIZARD;
                break;
            case PRIORITY_B:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.ADEPT;
                break;
            case PRIORITY_C:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.SPECIALIZED_WIZARD;
                break;
            case PRIORITY_D:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.NON_SPELLCASTER;
                break;
            case PRIORITY_E:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.NON_SPELLCASTER;
                break;
        }
        return spellcasterTypeEnumOutput;
    }
    
    public static SpellcasterTypeEnum PrioEnumToSpellcasterEnum(PriorityClassEnum prioEnum , RaceEnum raceEnum) {
        SpellcasterTypeEnum spellcasterTypeEnumOutput = null;
        switch(prioEnum)    {
            case PRIORITY_A:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.WIZARD;
                break;
            case PRIORITY_B:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.ADEPT;
                break;
            case PRIORITY_C:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.SPECIALIZED_WIZARD;
                break;
            case PRIORITY_D:
//                if(raceEnum == RaceEnum.HUMAN)  {
//                    spellcasterTypeEnumOutput = SpellcasterTypeEnum.NON_SPELLCASTER;
//                }
                break;
            case PRIORITY_E:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.NON_SPELLCASTER;
                break;
        }
        return spellcasterTypeEnumOutput;
    }
    public static SpellcasterTypeEnum PrioEnumToSpellcasterEnum(PriorityClassEnum prioEnum ,
            RaceEnum raceEnum, SpellcasterTypeEnum spellcasterEnum) {
        SpellcasterTypeEnum spellcasterTypeEnumOutput = null;
        switch(prioEnum)    {
            case PRIORITY_A:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.WIZARD;
                break;
            case PRIORITY_B:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.ADEPT;
                break;
            case PRIORITY_C:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.SPECIALIZED_WIZARD;
                break;
            case PRIORITY_D:
                if(raceEnum == RaceEnum.HUMAN)  {
                    spellcasterTypeEnumOutput = SpellcasterTypeEnum.NON_SPELLCASTER;
                }
                break;
            case PRIORITY_E:
                spellcasterTypeEnumOutput = SpellcasterTypeEnum.NON_SPELLCASTER;
                break;
        }
        return spellcasterTypeEnumOutput;
    }
    
    public static List<SpellcasterTypeEnum> retainableSpellcasterTypes(Set<PriorityClassEnum> prioSet, 
            SpellcasterTypeEnum spellcasterEnum, RaceEnum raceEnum)  {
        List<SpellcasterTypeEnum> outputList = new ArrayList<>();
        if(prioSet.contains(PriorityClassEnum.PRIORITY_A))  {
            outputList.add(SpellcasterTypeEnum.WIZARD);
        }
        if(prioSet.contains(PriorityClassEnum.PRIORITY_B))  {
            outputList.add(SpellcasterTypeEnum.ADEPT);
        }
        if(prioSet.contains(PriorityClassEnum.PRIORITY_C))  {
            outputList.add(SpellcasterTypeEnum.SPECIALIZED_WIZARD);
        }
        if(prioSet.contains(PriorityClassEnum.PRIORITY_E) && (spellcasterEnum != SpellcasterTypeEnum.NON_SPELLCASTER))  {
            outputList.add(SpellcasterTypeEnum.NON_SPELLCASTER);
        }
        if(prioSet.contains(PriorityClassEnum.PRIORITY_D) && (raceEnum == RaceEnum.HUMAN))  {
            outputList.add(SpellcasterTypeEnum.NON_SPELLCASTER);
        }
        return outputList;
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
                if(raceEnum == RaceEnum.HUMAN )   {
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
