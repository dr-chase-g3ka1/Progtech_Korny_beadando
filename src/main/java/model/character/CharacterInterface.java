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
 * The Shadowrun character's abstract specification.
 * All character instances inherit this interface.
 * @author Daradics Levente
 */
public interface CharacterInterface {

    /**
     * Returns the traidition of the magician (Hermetic or Saman), or null if not a magician.
     * @return {@code TraditionTypeEnum} and it's "hermetic" or "saman" type or null if the character is not a magic user.
     * @see model.character.spellcaster.TraditionTypeEnum
     */
    public TraditionTypeEnum getSpellcasterTradition();

    /**
     * Sets the tradition type of spellcaster.
     * @param traditionTypeEnum the enum contains tradition type (hermetic or saman), or null
     * @see model.character.spellcaster.TraditionTypeEnum
     */
    public void setSpellcasterTradition(TraditionTypeEnum traditionTypeEnum);
    
    /**
     * Returns magical capabilities of the character.
     * It is one of the first things one must set when generating a character,
     * so if it is not set, then the character generation is just started, or there might be 
     * an error. Should not return null.
     * @return {@code SpellcasterTypeEnum} (Wizard, Adept, Specialized Wizard, or non spellcaster)
     * @see model.character.SpellcasterTypeEnum
     */
    public SpellcasterTypeEnum getSpellcasterType();

    /**
     * Sets magical capabilities of the character if there is any.
     * @param spellcasterTypeEnum {@code SpellcasterTypeEnum} (Wizard, Adept, Specialized Wizard, or non spellcaster)
     * @see model.character.SpellcasterTypeEnum
     */
    public void setSpellcasterType(SpellcasterTypeEnum spellcasterTypeEnum);
    
    /**
     * Returns the name of the character.
     * @return the name of the character as {@code String}
     */
    public String getName();

    /**
     * Sets the name of the character from a string.
     * @param name a {@code String} containing the name you want for the character
     */
    public void setName(String name);

    /**
     * Returns the age of the character measured in years.
     * @return  the age of the character measured in years
     */
    public int getAge();

    /**
     * Sets the age of the character measured in years.
     * @param age the age of the character measured in years
     */
    public void setAge(int age);

    /**
     * Returns a {@code GenderEnum} containing the gender of the character.
     * Sadly there are only two genders in this model. No political correctness here.
     * @return {@code GenderEnum} containing the gender of the character
     * @see model.character.GenderEnum
     */
    public GenderEnum getGender();

    /**
     * Sets the gender of the character as a {@code GenderEnum}.
     * @param gender {@code GenderEnum} gender of the character
     * @see model.character.GenderEnum
     */
    public void setGender(GenderEnum gender);

    /**
     * Returns the race of the character, see {@code RaceEnum}.
     * Race can be Human, Dwarf, Elf, Orc, Troll.
     * @see model.character.RaceEnum
     * @return returns the enum containing the race: {@code RaceEnum}
     */
    public RaceEnum getRace();

    /**
     * Sets the race of the character, see {@code RaceEnum}.
     * Race can be Human, Dwarf, Elf, Orc, Troll.
     * @see model.character.RaceEnum
     * @param race the enum containing the race: {@code RaceEnum}
     */
    public void setRace(RaceEnum race);

    /**
     * Returns a {@code Modifier} class containing the character's race's modifiers.
     * Every race has different strengths and weaknesses. The {@code Modifier} class 
     * describes theese weaknesses and strengths as {@code int}s added to the base
     * attributes of the character.
     * @return a {@code Modifier} class containing the character's race's modifiers
     * @see model.character.Modifier
     * @see model.character.ModifierValues
     * @see model.character.constants.RacialModifiers
     */
    public Modifier getRacialModifier();

    /**
     * Sets the {@code Modifier} class containing the character's race's modifiers.
     * Every race has different strengths and weaknesses. The {@code Modifier} class 
     * describes theese weaknesses and strengths as {@code int}s added to the base
     * attributes of the character. These values can be negative and positive.
     * @see model.character.Modifier
     * @see model.character.ModifierValues
     * @see model.character.constants.RacialModifiers
     * @param racialModifier
     */
    public void setRacialModifier(Modifier racialModifier);

    /**
     * Returns the endurance of the character.
     * Endurance is between 0 and 10.
     * Endurance is used during fights. Represented as {@code int}
     * The character has endurance, health, and damage-overflow.
     * If the character is hit by an enemy, he/she can loose endurance only,
     * or both endurance and health. If endurance goes below one, the character faints.
     * @return the endurance of the character as {@code int}
     */
    public int getEndurance();

    /**
     * Sets the endurance of the character.
     * Endurance is between 0 and 10.
     * Endurance is used during fights. Represented as {@code int}.
     * The character has endurance, health, and damage-overflow.
     * If the character is hit by an enemy, he/she can loose endurance only,
     * or both endurance and health. If endurance goes below one, the character faints.
     * @param endurance
     */
    public void setEndurance(int endurance);

    /**
     * Gets the health of the character.
     * Health is between 0 and 10.
     * Health is used during fights. Represented as {@code int}.
     * The character has endurance, health, and damage-overflow.
     * If the character is hit by an enemy, he/she can loose endurance only,
     * or both endurance and health. If health goes below one, the character faints
     * and every damage taken adds to the damage overflow.
     * @return the health of the character between 0 and 10.
     */
    public int getHealth();

    /**
     * Sets the health of the character.
     * Health is between 0 and 10.
     * Health is used during fights. Represented as {@code int}.
     * The character has endurance, health, and damage-overflow.
     * If the character is hit by an enemy, he/she can loose endurance only,
     * or both endurance and health. If health goes below one, the character faints
     * and every damage taken adds to the damage overflow.
     * @param health health of the character between 0 and 10.
     */
    public void setHealth(int health);

    /**
     * Gets the damage overflow of the character.
     * Damage overflow is used during fights. Represented as {@code int}.
     * The character has endurance, health, and damage-overflow.
     * If the character is hit by an enemy, he/she can loose endurance only,
     * or both endurance and health. If health goes below one, the character faints
     * and every damage taken adds to the damage overflow.
     * @return the damage overflow of the character
     */
    public int getPhysicalDamageOverflow();

    /**
     * Sets the damage overflow of the character.
     * Damage overflow is used during fights. Represented as {@code int}.
     * The character has endurance, health, and damage-overflow.
     * If the character is hit by an enemy, he/she can loose endurance only,
     * or both endurance and health. If health goes below one, the character faints
     * and every damage taken adds to the damage overflow.
     * @param physicalDamageOverflow the damage overflow of the character
     */
    public void setPhysicalDamageOverflow(int physicalDamageOverflow);

    /**
     * Returns the unmodified body attribute of the character.
     * @return the unmodified body attribute of the character
     */
    public int getBaseBody();

    /**
     * Sets the unmodified body attribute of the character.
     * @param baseBody the unmodified body attribute of the character
     */
    public void setBaseBody(int baseBody);

    /**
     * Returns the unmodified agility attribute of the character.
     * @return the unmodified agility attribute of the character
     */
    public int getBaseAgility();

    /**
     * Sets the unmodified agility of the character.
     * @param baseAgility the unmodified body agility of the character
     */
    public void setBaseAgility(int baseAgility);

    /**
     * Returns the unmodified strength attribute of the character.
     * @return the unmodified strength attribute of the character
     */
    public int getBaseStrength();

    /**
     * Sets the unmodified strength attribute of the character.
     * @param baseStrength unmodified strength attribute of the character
     */
    public void setBaseStrength(int baseStrength);

    /**
     * Returns the unmodified charisma attribute of the character.
     * @return unmodified charisma attribute of the character
     */
    public int getBaseCharisma();

    /**
     * Sets the unmodified charisma attribute of the character.
     * @param baseCharisma the unmodified charisma attribute of the character
     */
    public void setBaseCharisma(int baseCharisma);

    /**
     * Gets the unmodified intelligence attribute of the character.
     * @return the unmodified intelligence attribute of the character
     */
    public int getBaseIntelligence();

    /**
     * Sets the unmodified intelligence attribute of the character.
     * @param baseIntelligence the unmodified intelligence attribute of the character
     */
    public void setBaseIntelligence(int baseIntelligence);

    /**
     * Gets the unmodified willpower attribute of the character.
     * @return the unmodified willpower attribute of the character
     */
    public int getBaseWillpower();

    /**
     * Sets the unmodified willpower attribute of the character.
     * @param baseWillpower the unmodified willpower attribute of the character
     */
    public void setBaseWillpower(int baseWillpower);

    /**
     * @deprecated 
     * @return
     */
    public int getAvailableAttributePoints();

    /**
     * @deprecated
     * @param availableAttributePoints
     */
    public void setAvailableAttributePoints(int availableAttributePoints);

    /**
     * Returns the modified body attribute of the character.
     * Modified attributes depend on cyberware inplants, active magic and racial modifiers.
     * @return
     */
    public int getModifiedBody();

    /**
     * Returns the modified agility attribute of the character.
     * Modified attributes depend on cyberware inplants, active magic racial modifiers
     * and the base attribute.
     * @see model.character.Modifier
     * @return modified agility attribute of the character
     */
    public int getModifiedAgility();

    /**
     *  Returns the modified strength attribute of the character.
     * Modified attributes depend on cyberware inplants, active magic racial modifiers
     * and the base attribute.
     * @see model.character.Modifier
     * @return modified strength attribute of the character
     */
    public int getModifiedStrength();

    /**
     * Returns the modified body charisma of the character.
     * Modified attributes depend on cyberware inplants, active magic racial modifiers
     * and the base attribute.
     * @see model.character.Modifier
     * @return the modified body charisma of the character
     */
    public int getModifiedCharisma();

    /**
     * Returns the modified body intelligence of the character.
     * Modified attributes depend on cyberware inplants, active magic racial modifiers
     * and the base attribute.
     * @see model.character.Modifier
     * @return the modified body intelligence of the character
     */
    public int getModifiedIntelligence();

    /**
     * Returns the modified body willpower of the character.
     * Modified attributes depend on cyberware inplants, active magic racial modifiers
     * and the base attribute.
     * @see model.character.Modifier
     * @return the modified body willpower of the character
     */
    public int getModifiedWillpower();

    /**
     * Returns the essence of the character.
     * Max essence is 6.
     * Essence is calculated based on the implants of the character.
     * Serious injuries can also decrease the essence of the character but
     * as of @version 0.4.0-preview it is not implemented.
     * @return the essence of the character
     * @see model.character.AbstractCharacter#cyberImplants
     * @see model.item.implant.CyberWare
     */
    public double getEssence();

    /**
     * @deprecated because essence is calculated based on cyber implants
     * @param essence
     */
    public void setEssence(double essence);

    /**
     * Returns the magic points of the character.
     * Returns 0 (zero as int) if the character is not a spellcaster.
     * Magic is calculated based on the essence by rounding the essence down.
     * For example:
     * If essence is 4,5 or 4,9 or 4,1 magic will be 4.
     * @return
     */
    public int getMagic();

    /**
     * @deprecated because magic is calculated based on essence
     * @param magic
     */
    public void setMagic(int magic);

    /**
     * Returns the reaction of the character.
     * Used during fights and dice rolls.
     * Equals round_down((agility + intelligence) /2)
     * @return the reaction of the character
     */
    public int getReaction();

    /**
     * @deprecated because reaction is calculated based on attributes
     * @param reaction
     */
    public void setReaction(int reaction);

    /**
     * Needs research.
     * @return
     */
    public int getModifiedNumOfInitiativeDice();

    /**
     * Needs research.
     * @param modifiedNumOfInitiativeDice
     */
    public void setModifiedNumOfInitiativeDice(int modifiedNumOfInitiativeDice);

    /**
     * Needs research.
     * @return
     */
    public int getCharmaReserve();

    /**
     * Needs research.
     * @param charmaReserve
     */
    public void setCharmaReserve(int charmaReserve);

    /**
     * Returns good charma points.
     * Good charma is used as a currency to increase attribute points,
     * buy new magic abilities, or "Level Up" the character.
     * @return good charma points
     */
    public int getGoodCharma();

    /**
     * Sets good charma points.
     * Good charma is used as a currency to increase attribute points,
     * buy new magic abilities, or "Level Up" the character.
     * @param goodCharma new good charma points
     */
    public void setGoodCharma(int goodCharma);

    /**
     * Needs research.
     * Calculated based on the modified attributes.
     * Equals round_down((agility + intelligence + willpower) /2)
     * @return
     */
    public int getCombatDiceReserve();

    /**
     * Needs research.
     * @param combatDiceReserve
     */
    public void setCombatDiceReserve(int combatDiceReserve);

    /**
     * Needs research.
     * @return
     */
    public int getMagicDiceReserve();

    /**
     * Needs research.
     * @param magicDiceReserve
     */
    public void setMagicDiceReserve(int magicDiceReserve);

    /**
     * Needs research.
     * @return
     */
    public int getAstralDiceReserve();

    /**
     * Needs research.
     * @param astralDiceReserve
     */
    public void setAstralDiceReserve(int astralDiceReserve);

    /**
     * Needs research.
     * @return
     */
    public int getDekasDiceReserve();

    /**
     * Needs research.
     * @param dekasDiceReserve
     */
    public void setDekasDiceReserve(int dekasDiceReserve);

    /**
     * Returns the actual amount of money of the character.
     * @return the money the character has
     */
    public long getMoney();

    /**
     * Sets the amont of money the character has.
     * @param money money the character will have
     */
    public void setMoney(long money);

    /**
     * Returns a {@code PriorityClassEnum} representing the priority of the race 
     * during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @return {@code PriorityClassEnum} representing the priority of the race
     * @see model.character.PriorityClassEnum
     */
    public PriorityClassEnum getPrioRace();

    /**
     * Sets the {@code PriorityClassEnum} representing the priority of the race 
     * during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @see model.character.PriorityClassEnum
     * @param prioRace {@code PriorityClassEnum} representing the priority of the race
     */
    public void setPrioRace(PriorityClassEnum prioRace);

    /**
     * Returns a {@code PriorityClassEnum} representing the priority of magic 
     * usage level of the character during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @return {@code PriorityClassEnum} representing the priority of magic
     * @see model.character.PriorityClassEnum
     */
    public PriorityClassEnum getPrioMagic();

    /**
     * Sets the {@code PriorityClassEnum} representing the priority of magic 
     * usage level of the character during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @see model.character.PriorityClassEnum
     * @param prioMagic {@code PriorityClassEnum} representing the priority of magic
     */
    public void setPrioMagic(PriorityClassEnum prioMagic);

    /**
     * Returns a {@code PriorityClassEnum} representing the priority of the attributes 
     * during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @return {@code PriorityClassEnum} representing the priority of the attributes
     * @see model.character.PriorityClassEnum
     */
    public PriorityClassEnum getPrioAttributes();

    /**
     * Sets the {@code PriorityClassEnum} representing the priority of attributes 
     * of the character during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @see model.character.PriorityClassEnum
     * @param prioAttributes {@code PriorityClassEnum} representing the priority of attributes
     */
    public void setPrioAttributes(PriorityClassEnum prioAttributes);

    /**
     * Returns a {@code PriorityClassEnum} representing the priority of the skills 
     * during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @return {@code PriorityClassEnum} representing the priority of the skills
     * @see model.character.PriorityClassEnum
     */
    public PriorityClassEnum getPrioSkills();

    /**
     * Sets the {@code PriorityClassEnum} representing the priority of skills 
     * of the character during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @see model.character.PriorityClassEnum
     * @param prioSkills {@code PriorityClassEnum} representing the priority of skills 
     */
    public void setPrioSkills(PriorityClassEnum prioSkills);

    /**
     * Returns a {@code PriorityClassEnum} representing the priority of the money 
     * during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @return {@code PriorityClassEnum} representing the priority of the money
     * @see model.character.PriorityClassEnum
     */
    public PriorityClassEnum getPrioResources();

    /**
     * Sets the {@code PriorityClassEnum} representing the priority of money 
     * usage level of the character during character generation.
     * First step of character generation is assign priorities to
     * magic, race, attributes, skills and resources.
     * @param prioResources {@code PriorityClassEnum} representing the priority of the money
     */
    public void setPrioResources(PriorityClassEnum prioResources);

    /**
     * @deprecated
     * @return
     */
    public int getAvailableSkillPoints();

    /**
     * @deprecated
     * @param availableSkillPoints
     */
    public void setAvailableSkillPoints(int availableSkillPoints);

    /**
     * Returns a list containing active skills.
     * @return list containing active skills
     */
    public List<Skill> getListOfSkills();

    /**
     * Sets a list containing active skills.
     * @param listOfSkills list containing active skills
     */
    public void setListOfSkills(List<Skill> listOfSkills);

    /**
     * Returns a list containing passive skills.
     * @return a list containing passive skills
     */
    public List<Knowledge> getListOfKnowledges();

    /**
     * Sets a list containing passive skills.
     * @param listOfKnowledges list containing passive skills
     */
    public void setListOfKnowledges(List<Knowledge> listOfKnowledges);

    /**
     * Returns a list containing language skills.
     * @return a list containing language skills
     */
    public List<LanguageSkill> getListOfLanguageSkills();

    /**
     * Sets a list containing language skills.
     * @param listOfLanguageSkills a list containing language skills
     */
    public void setListOfLanguageSkills(List<LanguageSkill> listOfLanguageSkills);

    /**
     * Returns a list containing all the implants the character has.
     * @return list containing all the implants the character has
     */
    public List<CyberWare> getCyberImplants();

    /**
     * Sets a list containing all the implants the character has.
     * @param cyberImplants  a list containing {@code CyberWare} implants.
     */
    public void setCyberImplants(List<CyberWare> cyberImplants);

    /**
     * Returns a list containing every item tha character currently has.
     * @return a list containing items of any type (weapon, equipment, etc...)
     */
    public List<AbstractItem> getInventory();

    /**
     * Sets a list containing items of any type (weapon, equipment, etc...).
     * @param inventory list containing items of any type (weapon, equipment, etc...)
     */
    public void setInventory(List<AbstractItem> inventory);
    
    /**
     * Returns a list containing spells.
     * @return a list containing spells
     */
    public List<AbstractSpell> getSpellList();
    
    /**
     * Sets a list containg spells.
     * @param spellList a list containing spells
     */
    public void setSpellList(List<AbstractSpell> spellList);

}
