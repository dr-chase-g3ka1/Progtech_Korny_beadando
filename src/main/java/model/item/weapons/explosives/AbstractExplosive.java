/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item.weapons.explosives;

/**
 *
 * @author Dr.Chase
 */
public class AbstractExplosive extends model.item.AbstractItem{
    // the damage of the weapon
    protected int weaponEnergy;     // weapon energy
    model.item.weapons.WeaponLethalityClassEnum lethality;
    
    model.item.weapons.DamageTypeEnum damageType;
    
    protected double explosionPowerReductionByMetres;   // a negative number, the power loss of the explosive by metres
}
