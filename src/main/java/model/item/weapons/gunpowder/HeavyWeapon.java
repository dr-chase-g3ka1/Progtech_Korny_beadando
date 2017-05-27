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
public class HeavyWeapon extends AbstractGunpowderWeapon {
    // rocket launchers can't have standard gunpowder weapon modification
    // generally can't have sound suppressors and silencers
    private boolean isRocketLauncer;
    HeavyWeaponSubTypeEnum heavySubType;
    GunpowderWeaponModSocket barrelMod;
    GunpowderWeaponModSocket sightMod;
    GunpowderWeaponModSocket receiverMod;
}
