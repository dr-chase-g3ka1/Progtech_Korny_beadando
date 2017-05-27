/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item.weapons.gunpowder;

/**
 *
 * @author Dr.Chase
 */
public class Pistol extends AbstractGunpowderWeapon {
    private boolean isRevolver;
    // Revolvers can't have suppressor or silencer modifications
    // Self defense pistols can't have any modifications
    PistolSubTypeEnum pistolSubType;
    
    GunpowderWeaponModSocket barrelMod;
    GunpowderWeaponModSocket sightMod;
}
