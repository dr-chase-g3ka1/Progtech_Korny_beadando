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
public class Rifle extends AbstractGunpowderWeapon{
    // rifles can't have noise suppressor or silencer
    RifleSubTypeEnum typeOfRifle;
    
    GunpowderWeaponModSocket barrelMod;
    GunpowderWeaponModSocket sightMod;
    GunpowderWeaponModSocket receiverMod;
}
