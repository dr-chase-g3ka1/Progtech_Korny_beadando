/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item.weapons.gunpowder;

import java.util.EnumSet;
import model.item.weapons.DamageTypeEnum;

/**
 *
 * @author Dr.Chase
 */
public abstract class AbstractGunpowderWeapon extends model.item.AbstractItem{
    
    protected int maxMagazineSize;
    protected int actaulAmmoInMagazine;
    protected int numberOfMagazinesForThisGun;
    GunpowderMagazineType magazineType;
    EnumSet<AmmoType> allowedAmmoTypes;
    AmmoType actualAmmoType;
    FireModeEnum fireMode;
    protected int recoilReduction;
    
    // these 2 will  give you the actual damage of the weapon
    protected int weaponEnergy;
    model.item.weapons.WeaponLethalityClassEnum lethality;
    
    DamageTypeEnum lethalOrStun;
    
}
