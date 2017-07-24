/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character;

import model.character.skill.LanguageSkill;
import model.character.skill.Knowledge;
import model.character.skill.Skill;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import model.character.spellcaster.spell.AbstractSpell;
import model.item.AbstractItem;
import model.item.implant.CyberWare;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import model.character.nonspellcaster.NonSpellcaster;
import model.character.spellcaster.chartypes.Adept;
import model.character.spellcaster.chartypes.SpecializedWizard;
import model.character.spellcaster.chartypes.Wizard;

/**
 *
 * @author Dr.Chase
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement(name = "character")
@XmlSeeAlso({Adept.class, SpecializedWizard.class, Wizard.class, NonSpellcaster.class})
public abstract class AbstractCharacter implements CharacterInterface {
    
    //Name of character
    protected String name;
    
    // Age of Character
    protected int age;
    
    //  General datas of character
    GenderEnum gender;  // non-modifier
    RaceEnum race;      // modifies attributes
    SpellcasterTypeEnum spellcasterType; // is it a magician, and if yes hat kind of magician is it?
    
    protected Modifier racialModifier;
    
    // health of character
    // health and endurance has base of 10 of an intact character
    // if endurance goes below or equal to zero, the character faints
    // if character takes to much physical damage and it's health goes below zero
    //      then it the number below zero goes to overflow
    //      when overflow presents character takes + 1 damage every turn (in fight)
    //      if overflow reaches (Body + 10) the character dies
    protected int endurance;  //
    protected int health;
    protected int physicalDamageOverflow;
    
    // Base attributes of the character
    // You can only modify theese at character Level Up!
    protected int baseBody;
    protected int baseAgility;
    protected int baseStrength;
    protected int baseCharisma;
    protected int baseIntelligence;
    protected int baseWillpower;
    
    // Starting points. Depends on choosen prioAttributes
    protected int availableAttributePoints;
    
    // these are dinamic attributes
    // modified by base and/or modified attributes, and (magic or cyberver)
    public static final int MAX_ESSENCE = 6;
    protected double essence;
    protected int    magic;
    protected int    reaction;
    
    // base is always 1 (= (1D6))
    protected final int    baseNumOfInitiativeDice = 1;
    protected int    modifiedNumOfInitiativeDice;
    
    // karmák
    protected int charmaReserve;
    protected int goodCharma;
    
    // dice reserves - kockatartalékok
    protected int combatDiceReserve;
    /* a kettő itt alattam csak mágusnak való és arra külön osztály lesz */
    // ˘˘˘˘ (Intelligence + Will + Magic) / 3
    protected int magicDiceReserve;
    protected int astralDiceReserve;
    // dekás angolul nemtom hogy van?
    protected int dekasDiceReserve;
    
    // money resources
    protected long money;
    
    PriorityClassEnum prioRace;
    PriorityClassEnum prioMagic;
    PriorityClassEnum prioAttributes;
    PriorityClassEnum prioSkills;
    PriorityClassEnum prioResources;
    
    // Available skill points depend on prioSkills
    protected int availableActiveSkillPoints;
    protected int availablePassiveSkillPoints;
    protected int availableLanguageSkillPoints;
    
    // skill containers
    @XmlElementWrapper(name="listOfActiveSkills")
    @XmlElement(name="skill")
    protected List<Skill> listOfSkills;
    
    protected List<Knowledge> listOfKnowledges;
    
    protected List<LanguageSkill> listOfLanguageSkills;
    
    protected List<CyberWare> cyberImplants;

    
    protected List<model.item.AbstractItem> inventory;

    public AbstractCharacter() {
        listOfSkills = new ArrayList<>();
        listOfKnowledges = new ArrayList<>();
        listOfLanguageSkills = new ArrayList<>();
        cyberImplants = new ArrayList<>();
        inventory = new ArrayList<>();
    }
    
    
    
    // Abstract Class Functions
    
    // Setters and getters come now

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public RaceEnum getRace() {
        return race;
    }

    public void setRace(RaceEnum race) {
        this.race = race;
    }

    public Modifier getRacialModifier() {
        return racialModifier;
    }

    public void setRacialModifier(Modifier racialModifier) {
        this.racialModifier = racialModifier;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPhysicalDamageOverflow() {
        return physicalDamageOverflow;
    }

    public void setPhysicalDamageOverflow(int physicalDamageOverflow) {
        this.physicalDamageOverflow = physicalDamageOverflow;
    }

    public int getBaseBody() {
        return baseBody;
    }

    public void setBaseBody(int baseBody) {
        this.baseBody = baseBody;
    }

    public int getBaseAgility() {
        return baseAgility;
    }

    public void setBaseAgility(int baseAgility) {
        this.baseAgility = baseAgility;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getBaseCharisma() {
        return baseCharisma;
    }

    public void setBaseCharisma(int baseCharisma) {
        this.baseCharisma = baseCharisma;
    }

    public int getBaseIntelligence() {
        return baseIntelligence;
    }

    public void setBaseIntelligence(int baseIntelligence) {
        this.baseIntelligence = baseIntelligence;
    }

    public int getBaseWillpower() {
        return baseWillpower;
    }

    public void setBaseWillpower(int baseWillpower) {
        this.baseWillpower = baseWillpower;
    }

    public int getAvailableAttributePoints() {
        return availableAttributePoints;
    }

    public void setAvailableAttributePoints(int availableAttributePoints) {
        this.availableAttributePoints = availableAttributePoints;
    }

    public int getModifiedBody() {
        int result;
        if(cyberImplants != null)   {
            result = cyberImplants.stream()
                .map( implants -> implants.getModifier() )
                .filter ( modifier -> modifier.getIsModificationPresent())
                .mapToInt( modifier -> modifier.getModifiedValues().getBodyModifier())
                .sum();
            
        }
        else    {
            result = 0;
        }
        return result + baseBody + racialModifier.getModifiedValues().getBodyModifier();
    }

    public int getModifiedAgility() {
        int result = 0;
        if(cyberImplants != null)   {
            result = cyberImplants.stream()
                    .map( implants -> implants.getModifier() )
                    .filter ( modifier -> modifier.getIsModificationPresent())
                    .mapToInt( modifier -> modifier.getModifiedValues().getAgilityModifier())
                    .sum();
        }
        return result + baseAgility + racialModifier.getModifiedValues().getAgilityModifier();
    }

    public int getModifiedStrength() {
        int result = 0;
        if(cyberImplants != null)   {
            result = cyberImplants.stream()
                    .map( implants -> implants.getModifier() )
                    .filter ( modifier -> modifier.getIsModificationPresent())
                    .mapToInt( modifier -> modifier.getModifiedValues().getStrengthModifier())
                    .sum();
        }
        return result + baseStrength + racialModifier.getModifiedValues().getStrengthModifier();
    }

    public int getModifiedCharisma() {
        int result = 0;
        if(cyberImplants != null)   {
            result = cyberImplants.stream()
                    .map( implants -> implants.getModifier() )
                    .filter ( modifier -> modifier.getIsModificationPresent())
                    .mapToInt( modifier -> modifier.getModifiedValues().getCharismaModifier())
                    .sum();
        }
        return result + baseCharisma + racialModifier.getModifiedValues().getCharismaModifier();
    }

    public int getModifiedIntelligence() {
        int result = 0;
        if(cyberImplants != null)   {
            result = cyberImplants.stream()
                    .map( implants -> implants.getModifier() )
                    .filter ( modifier -> modifier.getIsModificationPresent())
                    .mapToInt( modifier -> modifier.getModifiedValues().getIntelligenceModifier())
                    .sum();
        }
        return result + baseIntelligence + racialModifier.getModifiedValues().getIntelligenceModifier();
    }

    public int getModifiedWillpower() {
        int result = 0;
        if(cyberImplants != null)   {
            result = cyberImplants.stream()
                    .map( implants -> implants.getModifier() )
                    .filter ( modifier -> modifier.getIsModificationPresent())
                    .mapToInt( modifier -> modifier.getModifiedValues().getWillpowerModifier())
                    .sum();
        }
        return result + baseWillpower + racialModifier.getModifiedValues().getWillpowerModifier();
    }

    public double getEssence() {
        double dResult;
        if(cyberImplants != null)    {
            dResult = cyberImplants.stream()
                    .mapToDouble(implant -> implant.getCostInEssence())
                    .sum();
            dResult = AbstractCharacter.MAX_ESSENCE - dResult;
        }
        else    {
            // just to make sure rounding it will give 6 which is
            dResult = 6.001;
        }
        return dResult;
    }

    public void setEssence(double essence) {
        this.essence = essence;
    }

    public int getMagic() {
        int nResult;
        if( cyberImplants != null )    {
            // rounding down like: 5.999999 should be 5
            nResult = (int)getEssence();
        }
        else    {
            nResult = AbstractCharacter.MAX_ESSENCE;
        }
        return nResult;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getReaction() {
        int nResult;
        nResult = (getModifiedAgility() + getModifiedIntelligence()) / 2;
        return nResult;
    }

    public void setReaction(int reaction) {
        this.reaction = reaction;
    }
    
    /* TODO */
    public int getModifiedNumOfInitiativeDice() {
        return modifiedNumOfInitiativeDice;
    }

    /* TODO */
    public void setModifiedNumOfInitiativeDice(int modifiedNumOfInitiativeDice) {
        this.modifiedNumOfInitiativeDice = modifiedNumOfInitiativeDice;
    }

    public int getCharmaReserve() {
        return charmaReserve;
    }

    public void setCharmaReserve(int charmaReserve) {
        this.charmaReserve = charmaReserve;
    }

    public int getGoodCharma() {
        return goodCharma;
    }

    public void setGoodCharma(int goodCharma) {
        this.goodCharma = goodCharma;
    }

    public int getCombatDiceReserve() {
        return combatDiceReserve;
    }

    public void setCombatDiceReserve(int combatDiceReserve) {
        this.combatDiceReserve = combatDiceReserve;
    }
    
    /* TODO */
    public int getMagicDiceReserve() {
        return magicDiceReserve;
    }

    /* TODO */
    public void setMagicDiceReserve(int magicDiceReserve) {
        this.magicDiceReserve = magicDiceReserve;
    }

    /* TODO */
    public int getAstralDiceReserve() {
        return astralDiceReserve;
    }

    /* TODO */
    public void setAstralDiceReserve(int astralDiceReserve) {
        this.astralDiceReserve = astralDiceReserve;
    }

    /* TODO */
    public int getDekasDiceReserve() {
        return dekasDiceReserve;
    }

    /* TODO */
    public void setDekasDiceReserve(int dekasDiceReserve) {
        this.dekasDiceReserve = dekasDiceReserve;
    }

    
    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public PriorityClassEnum getPrioRace() {
        return prioRace;
    }

    public void setPrioRace(PriorityClassEnum prioRace) {
        this.prioRace = prioRace;
    }

    public PriorityClassEnum getPrioMagic() {
        return prioMagic;
    }

    public void setPrioMagic(PriorityClassEnum prioMagic) {
        this.prioMagic = prioMagic;
    }

    public PriorityClassEnum getPrioAttributes() {
        return prioAttributes;
    }

    public void setPrioAttributes(PriorityClassEnum prioAttributes) {
        this.prioAttributes = prioAttributes;
    }

    public PriorityClassEnum getPrioSkills() {
        return prioSkills;
    }

    public void setPrioSkills(PriorityClassEnum prioSkills) {
        this.prioSkills = prioSkills;
    }

    public PriorityClassEnum getPrioResources() {
        return prioResources;
    }

    public void setPrioResources(PriorityClassEnum prioResources) {
        this.prioResources = prioResources;
    }

    /* Will be deprecated */
    public int getAvailableSkillPoints() {
        return availableActiveSkillPoints;
    }

    /* Will be deprecated */
    public void setAvailableSkillPoints(int availableSkillPoints) {
        this.availableActiveSkillPoints = availableSkillPoints;
    }

    public List<Skill> getListOfSkills() {
        return listOfSkills;
    }

    public void setListOfSkills(List<Skill> listOfSkills) {
        this.listOfSkills = listOfSkills;
    }

    public List<Knowledge> getListOfKnowledges() {
        return listOfKnowledges;
    }

    public void setListOfKnowledges(List<Knowledge> listOfKnowledges) {
        this.listOfKnowledges = listOfKnowledges;
    }

    public List<LanguageSkill> getListOfLanguageSkills() {
        return listOfLanguageSkills;
    }

    public void setListOfLanguageSkills(List<LanguageSkill> listOfLanguageSkills) {
        this.listOfLanguageSkills = listOfLanguageSkills;
    }

    public List<CyberWare> getCyberImplants() {
        return cyberImplants;
    }

    public void setCyberImplants(List<CyberWare> cyberImplants) {
        this.cyberImplants = cyberImplants;
    }

    public List<AbstractItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<AbstractItem> inventory) {
        this.inventory = inventory;
    }

    public SpellcasterTypeEnum getSpellcasterType() {
        return spellcasterType;
    }

    public void setSpellcasterType(SpellcasterTypeEnum spellcasterType) {
        this.spellcasterType = spellcasterType;
    }
    public abstract List<AbstractSpell> getSpellList();
    
    public abstract void setSpellList(List<AbstractSpell> spellList);

    public int getAvailableActiveSkillPoints() {
        return availableActiveSkillPoints;
    }

    public void setAvailableActiveSkillPoints(int availableActiveSkillPoints) {
        this.availableActiveSkillPoints = availableActiveSkillPoints;
    }

    public int getAvailablePassiveSkillPoints() {
        return availablePassiveSkillPoints;
    }

    public void setAvailablePassiveSkillPoints(int availablePassiveSkillPoints) {
        this.availablePassiveSkillPoints = availablePassiveSkillPoints;
    }

    public int getAvailableLanguageSkillPoints() {
        return availableLanguageSkillPoints;
    }

    public void setAvailableLanguageSkillPoints(int availableLanguageSkillPoints) {
        this.availableLanguageSkillPoints = availableLanguageSkillPoints;
    }
    
    
    
}
