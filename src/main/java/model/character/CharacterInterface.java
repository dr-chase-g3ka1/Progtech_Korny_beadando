/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character;

import java.util.List;
import model.character.spellcaster.TraditionTypeEnum;
import model.character.spellcaster.spell.AbstractSpell;
import model.item.AbstractItem;
import model.item.implant.CyberWare;

/**
 *
 * @author Dr.Chase
 */
public interface CharacterInterface {
    public TraditionTypeEnum getSpellcasterTradition();
    public void setSpellcasterTradition(TraditionTypeEnum traditionTypeEnum);
    
    public SpellcasterTypeEnum getSpellcasterType();
    public void setSpellcasterType(SpellcasterTypeEnum spellcasterTypeEnum);
    
    public String getName();

    public void setName(String name);

    public int getAge();

    public void setAge(int age);

    public GenderEnum getGender();

    public void setGender(GenderEnum gender);

    public RaceEnum getRace();

    public void setRace(RaceEnum race);

    public Modifier getRacialModifier();

    public void setRacialModifier(Modifier racialModifier);

    public int getEndurance() ;

    public void setEndurance(int endurance);

    public int getHealth();

    public void setHealth(int health) ;

    public int getPhysicalDamageOverflow();

    public void setPhysicalDamageOverflow(int physicalDamageOverflow);

    public int getBaseBody();

    public void setBaseBody(int baseBody);

    public int getBaseAgility();

    public void setBaseAgility(int baseAgility);

    public int getBaseStrength();

    public void setBaseStrength(int baseStrength);

    public int getBaseCharisma();

    public void setBaseCharisma(int baseCharisma);

    public int getBaseIntelligence();

    public void setBaseIntelligence(int baseIntelligence);

    public int getBaseWillpower() ;

    public void setBaseWillpower(int baseWillpower);

    public int getAvailableAttributePoints() ;

    public void setAvailableAttributePoints(int availableAttributePoints) ;

    public int getModifiedBody() ;

    public int getModifiedAgility() ;

    public int getModifiedStrength() ;

    public int getModifiedCharisma() ;

    public int getModifiedIntelligence() ;

    public int getModifiedWillpower() ;

    public double getEssence() ;

    public void setEssence(double essence) ;

    public int getMagic() ;

    public void setMagic(int magic);

    public int getReaction() ;

    public void setReaction(int reaction) ;

    public int getModifiedNumOfInitiativeDice() ;

    public void setModifiedNumOfInitiativeDice(int modifiedNumOfInitiativeDice);

    public int getCharmaReserve();

    public void setCharmaReserve(int charmaReserve);

    public int getGoodCharma() ;

    public void setGoodCharma(int goodCharma);

    public int getCombatDiceReserve() ;

    public void setCombatDiceReserve(int combatDiceReserve) ;

    public int getMagicDiceReserve() ;

    public void setMagicDiceReserve(int magicDiceReserve) ;

    public int getAstralDiceReserve() ;

    public void setAstralDiceReserve(int astralDiceReserve) ;

    public int getDekasDiceReserve() ;

    public void setDekasDiceReserve(int dekasDiceReserve) ;

    public long getMoney() ;

    public void setMoney(long money) ;

    public PriorityClassEnum getPrioRace() ;

    public void setPrioRace(PriorityClassEnum prioRace) ;

    public PriorityClassEnum getPrioMagic() ;

    public void setPrioMagic(PriorityClassEnum prioMagic);

    public PriorityClassEnum getPrioAttributes();

    public void setPrioAttributes(PriorityClassEnum prioAttributes);

    public PriorityClassEnum getPrioSkills() ;

    public void setPrioSkills(PriorityClassEnum prioSkills);

    public PriorityClassEnum getPrioResources();

    public void setPrioResources(PriorityClassEnum prioResources);

    public int getAvailableSkillPoints();

    public void setAvailableSkillPoints(int availableSkillPoints);

    public List<Skill> getListOfSkills();

    public void setListOfSkills(List<Skill> listOfSkills);

    public List<Knowledge> getListOfKnowledges();

    public void setListOfKnowledges(List<Knowledge> listOfKnowledges);

    public List<LanguageSkill> getListOfLanguageSkills();

    public void setListOfLanguageSkills(List<LanguageSkill> listOfLanguageSkills) ;

    public List<CyberWare> getCyberImplants();

    public void setCyberImplants(List<CyberWare> cyberImplants);

    public List<AbstractItem> getInventory();

    public void setInventory(List<AbstractItem> inventory) ;
    
    public List<AbstractSpell> getSpellList();
    
    public void setSpellList(List<AbstractSpell> spellList);

}
