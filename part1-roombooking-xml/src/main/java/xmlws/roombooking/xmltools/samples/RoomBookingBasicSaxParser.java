package xmlws.roombooking.xmltools.samples;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * Class for objects responsible of RoomBooking xml files parsing
 * SAX version
 */
public class RoomBookingBasicSaxParser  {

    /**
     * Parse an xml file provided as an input stream
     *
     * @param inputStream the input stream corresponding to the xml file
     */
    public void parse(InputStream inputStream) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(inputStream, new RoomBookingBasicHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class RoomBookingBasicHandler extends DefaultHandler {

        public void startElement(String namespaceURI,
                                 String localName,
                                 String qName,
                                 Attributes atts)
                throws SAXException {
            System.out.println("In element: "+localName);
        }

        public void characters(char ch[], int start, int length)
                throws SAXException {
            System.out.println(new String(ch, start, length));
        }
    }

}
