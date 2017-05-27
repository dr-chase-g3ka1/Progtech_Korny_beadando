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
public class ItemAvailability {
    public enum TypeOfTime {
        ÓRA,
        NAP,
        HÓNAP
    }
    
    public int difficulty;     // how hard it is to get the stuff
    public int minTimeToGetIt; // How many hours does it take to get it
    TypeOfTime typeOfTime;
}
