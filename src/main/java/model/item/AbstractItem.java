/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item;

/**
 *
 * @author Dr.Chase
 */
public class AbstractItem {
    protected String name;
    protected String description;
    
    protected class LegalityCode  {
        protected short numberCode; //the smaller the number is the more restriction the item has
        protected LegalityLetterCodeEnum letterCode;
    }
    
    
    protected int                 hideability;
    protected double              weightInKilogramms;      // in kilograms
    protected ItemAvailability    availability; 
    protected long                priceInNuYen;   // NuYen is the currency in this world
    protected double              streetIndex;   // multiplier of the price if you intend to buy it in the street, then you must multiply price with this
    public final static double    dwarfMultuplierForPrice = 1.1;
    public final static double    trollMultuplierForPrice = 1.25;
    protected ItemTypeInRaceEnum      itemTypeInRace;
    
}
