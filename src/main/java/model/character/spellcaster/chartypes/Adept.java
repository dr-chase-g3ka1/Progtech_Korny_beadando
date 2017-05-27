/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character.spellcaster.chartypes;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import model.character.AbstractCharacter;
import model.character.spellcaster.TraditionTypeEnum;
import model.character.spellcaster.spell.AbstractSpell;

/**
 *
 * @author Dr.Chase
 */
@XmlRootElement(name = "character")
public class Adept extends AbstractCharacter {

    @Override
    public List<AbstractSpell> getSpellList() {
        return null;
    }

    @Override
    public void setSpellList(List<AbstractSpell> spellList) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TraditionTypeEnum getSpellcasterTradition() {
        return null;
    }

    @Override
    public void setSpellcasterTradition(TraditionTypeEnum traditionTypeEnum) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
