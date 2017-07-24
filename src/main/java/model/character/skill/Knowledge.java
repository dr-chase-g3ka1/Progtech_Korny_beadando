/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character.skill;

import model.character.KnowledgeTypesEnum;

/**
 *
 * @author Dr.Chase
 */
public class Knowledge {
    private String name; 
    KnowledgeTypesEnum type;   
    private int level;
    
    private boolean isSpecialized;
    private String specialization;
    
    private String description;
}
