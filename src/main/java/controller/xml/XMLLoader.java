/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.xml;

/**
 *
 * @author Dr.Chase
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import model.character.AbstractCharacter;

public class XMLLoader {
    
    public static AbstractCharacter loadXMLFromFile(File file)    {
        AbstractCharacter loadedCharacter = null;
        try {
            JAXBContext context = JAXBContext.newInstance(AbstractCharacter.class);
            Unmarshaller um = context.createUnmarshaller();
            loadedCharacter = 
                    (AbstractCharacter) um.unmarshal(new FileReader(file));
        } catch (PropertyException ex) {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException | FileNotFoundException ex)  {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            return loadedCharacter;
        }
        
    }
    
    public static AbstractCharacter loadXMLFromFileAndPrint(File file)    {
        AbstractCharacter loadedCharacter = null;
        try {
            JAXBContext context = JAXBContext.newInstance(AbstractCharacter.class);
            Unmarshaller um = context.createUnmarshaller();
            loadedCharacter = 
                    (AbstractCharacter) um.unmarshal(new FileReader(file));
            
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(loadedCharacter, System.out);
        } catch (PropertyException ex) {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException | FileNotFoundException ex)  {
            Logger.getLogger(XMLSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            return loadedCharacter;
        }
        
    }    
}
