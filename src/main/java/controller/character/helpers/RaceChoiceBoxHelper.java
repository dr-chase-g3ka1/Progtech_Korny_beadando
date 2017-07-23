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
import model.character.RaceEnum;
import model.character.SpellcasterTypeEnum;

/**
 *
 * @author Dr.Chase
 */
public class RaceChoiceBoxHelper {
    public static List<RaceEnum> 
        determineRemainingRaceEnumChoices
            (EnumSet<PriorityClassEnum> reminingPrios)  {
        List<RaceEnum> raceList = new ArrayList<>();
        if(reminingPrios.contains(PriorityClassEnum.PRIORITY_C))    {
            raceList.add(RaceEnum.TROLL);
            raceList.add(RaceEnum.ELF);
        }
        if(reminingPrios.contains(PriorityClassEnum.PRIORITY_D))    {
            raceList.add(RaceEnum.DWARF);
            raceList.add(RaceEnum.ORC);
        }
        if(reminingPrios.contains(PriorityClassEnum.PRIORITY_E) || reminingPrios.contains(PriorityClassEnum.PRIORITY_D))    {
            raceList.add(RaceEnum.HUMAN);
        }
        return raceList;
    }
    public static PriorityClassEnum 
        raceEnumToPriorityEnumAdapter(RaceEnum raceEnum)  {
            PriorityClassEnum prioEnum = null;
            if(raceEnum == RaceEnum.HUMAN)  {
                prioEnum = PriorityClassEnum.PRIORITY_E;
            }
            if(raceEnum == RaceEnum.ELF)  {
                prioEnum = PriorityClassEnum.PRIORITY_C;
            }
            if(raceEnum == RaceEnum.TROLL)  {
                prioEnum = PriorityClassEnum.PRIORITY_C;
            }
            if(raceEnum == RaceEnum.DWARF)  {
                prioEnum = PriorityClassEnum.PRIORITY_D;
            }
            if(raceEnum == RaceEnum.ORC)  {
                prioEnum = PriorityClassEnum.PRIORITY_D;
            }
            return prioEnum;
    }
    public static PriorityClassEnum 
        raceEnumToPriorityEnumAdapter(RaceEnum raceEnum, SpellcasterTypeEnum spellcasterEnum)  {
            PriorityClassEnum prioEnum = null;
            if(raceEnum == RaceEnum.HUMAN)  {
                prioEnum = PriorityClassEnum.PRIORITY_E;
                if(spellcasterEnum == SpellcasterTypeEnum.NON_SPELLCASTER)   {
                    prioEnum = PriorityClassEnum.PRIORITY_D;
                }
            }
            if(raceEnum == RaceEnum.ELF)  {
                prioEnum = PriorityClassEnum.PRIORITY_C;
            }
            if(raceEnum == RaceEnum.TROLL)  {
                prioEnum = PriorityClassEnum.PRIORITY_C;
            }
            if(raceEnum == RaceEnum.DWARF)  {
                prioEnum = PriorityClassEnum.PRIORITY_D;
            }
            if(raceEnum == RaceEnum.ORC)  {
                prioEnum = PriorityClassEnum.PRIORITY_D;
            }
            return prioEnum;
    }
    public static List<RaceEnum> priorityEnumToRaceEnum(PriorityClassEnum prioEnum)    {
        List<RaceEnum> raceEnumListOutput = new ArrayList<>();
        if(prioEnum == PriorityClassEnum.PRIORITY_E)  {
            raceEnumListOutput.add(RaceEnum.HUMAN);
        }
        if(prioEnum == PriorityClassEnum.PRIORITY_C)  {
            raceEnumListOutput.add(RaceEnum.ELF);
            raceEnumListOutput.add(RaceEnum.TROLL);
        }
        if(prioEnum == PriorityClassEnum.PRIORITY_D)  {
            raceEnumListOutput.add(RaceEnum.DWARF);
            raceEnumListOutput.add(RaceEnum.ORC);
        }
        return raceEnumListOutput;
    }    
    public static List<RaceEnum> priorityEnumToRaceEnum(PriorityClassEnum prioEnum, 
            SpellcasterTypeEnum spellcasterEnum, RaceEnum raceEnum)    {
        List<RaceEnum> raceEnumListOutput = new ArrayList<>();
        if(prioEnum == PriorityClassEnum.PRIORITY_E)  {
            raceEnumListOutput.add(RaceEnum.HUMAN);
        }
        if(prioEnum == PriorityClassEnum.PRIORITY_C)  {
            raceEnumListOutput.add(RaceEnum.ELF);
            raceEnumListOutput.add(RaceEnum.TROLL);
        }
        if(prioEnum == PriorityClassEnum.PRIORITY_D)  {
            raceEnumListOutput.add(RaceEnum.DWARF);
            raceEnumListOutput.add(RaceEnum.ORC);
//            if(spellcasterEnum == SpellcasterTypeEnum.NON_SPELLCASTER
//                &&
//                raceEnum == RaceEnum.HUMAN) {
//                raceEnumListOutput.add(RaceEnum.HUMAN);
//            }
        }
        return raceEnumListOutput;
    }   
    
    public static PriorityClassEnum 
        raceEnumToPriorityEnumAdapter(RaceEnum raceEnum, EnumSet<PriorityClassEnum> reminingPrios)  {
            PriorityClassEnum prioEnum = null;
            if(raceEnum == RaceEnum.HUMAN)  {
                prioEnum = PriorityClassEnum.PRIORITY_E;
                if(!reminingPrios.contains(PriorityClassEnum.PRIORITY_E))   {
                    prioEnum = PriorityClassEnum.PRIORITY_D;
                }
            }
            if(raceEnum == RaceEnum.ELF)  {
                prioEnum = PriorityClassEnum.PRIORITY_C;
            }
            if(raceEnum == RaceEnum.TROLL)  {
                prioEnum = PriorityClassEnum.PRIORITY_C;
            }
            if(raceEnum == RaceEnum.DWARF)  {
                prioEnum = PriorityClassEnum.PRIORITY_D;
            }
            if(raceEnum == RaceEnum.ORC)  {
                prioEnum = PriorityClassEnum.PRIORITY_D;
            }
            return prioEnum;
    }
}
