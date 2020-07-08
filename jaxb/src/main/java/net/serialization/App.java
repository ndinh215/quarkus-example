package net.serialization;

import net.serialization.data.*;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Main program
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance("net.serialization.data");
        ObjectFactory factory = new ObjectFactory();

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        InputStream xml = App.class.getClassLoader().getResourceAsStream("schema/books.xml");
        JAXBElement<? extends CatalogData> books = unmarshaller.unmarshal(new StreamSource(xml), factory.createCatalogData().getClass());

        if (xml != null) {
            xml.close();
        }

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(books, System.out);
    }
}
