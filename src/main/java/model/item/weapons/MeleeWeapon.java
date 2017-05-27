/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item.weapons;

import model.item.weapons.WeaponLethalityClassEnum;
import model.character.SkillAttrEnum;
import model.item.AbstractItem;

/**
 *
 * @author Dr.Chase
 */
public class MeleeWeapon extends AbstractItem{
    private int reach;      // how long the weapon can hit
    //
    SkillAttrEnum skillAttrEnum;
    private int addedNumber;        // weapon energy
    WeaponLethalityClassEnum lethality;
    
    DamageTypeEnum lethalOrStun;
}
