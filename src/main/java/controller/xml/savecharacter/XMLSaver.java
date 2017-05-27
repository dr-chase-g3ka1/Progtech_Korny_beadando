/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.xml.savecharacter;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.character.AbstractCharacter;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Dr.Chase
 */
public class XMLSaver {
    private static final String XML_SAVE_PATH = "./sample-save-character.xml";
    static AbstractCharacter character;

    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }

    public XMLSaver(AbstractCharacter character) {
        this.character = character;
    }
    
    public static void printOutCharacterXML(AbstractCharacter character)   {
        try {
            JAXBContext context = JAXBContext.newInstance(AbstractCharacter.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(character, System.out);
            
        } catch (PropertyException ex) {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex)  {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void saveCharacterToFileXML(AbstractCharacter character)   {
        try {
            JAXBContext context = JAXBContext.newInstance(AbstractCharacter.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(character, new File(XML_SAVE_PATH));
            
        } catch (PropertyException ex) {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex)  {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveCharacterToFileXML(AbstractCharacter character, String pathToNewFile)   {
        try {
            JAXBContext context = JAXBContext.newInstance(character.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(character, new File(pathToNewFile));
            
        } catch (PropertyException ex) {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex)  {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveCharacterToFileXML(AbstractCharacter character, File file)   {
        try {
            JAXBContext context = JAXBContext.newInstance(character.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(character, file);
            
        } catch (PropertyException ex) {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex)  {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
