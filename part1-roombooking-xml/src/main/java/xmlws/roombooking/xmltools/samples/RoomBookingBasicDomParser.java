package xmlws.roombooking.xmltools.samples;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 *  Class for objects responsible of RoomBooking xml files parsing
 *  DOM version
 */
public class RoomBookingBasicDomParser {

    /**
     * Parse an xml file provided as an input stream
     * @param inputStream the input stream corresponding to the xml file
     */
    public void parse(InputStream inputStream) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(inputStream);
            System.out.println(doc.getElementsByTagName("label").item(0).getTextContent());
            System.out.println(doc.getElementsByTagName("username").item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
