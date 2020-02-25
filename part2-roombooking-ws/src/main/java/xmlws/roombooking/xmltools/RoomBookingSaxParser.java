package xmlws.roombooking.xmltools;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class for objects responsible of RoomBooking xml files parsing
 * SAX version
 */
public class RoomBookingSaxParser implements RoomBookingParser {

    /**
     * Parse an xml file provided as an input stream
     *
     * @param inputStream the input stream corresponding to the xml file
     * @return the corresponding RoomBooking object
     */
    public RoomBooking parse(InputStream inputStream) {
        RoomBooking roomBooking = new RoomBooking();
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(inputStream, new RoomBookingHandler(roomBooking));
        } catch (Exception e) {
            e.printStackTrace();
            roomBooking = null;
        }
        return roomBooking;
    }

    private class RoomBookingHandler extends DefaultHandler {
        private RoomBooking roomBooking;
        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        private CurrentElement currentElement;

        public RoomBookingHandler(RoomBooking roomBooking) {
            this.roomBooking = roomBooking;
        }

        public void startElement(String namespaceURI,
                                 String localName,
                                 String qName,
                                 Attributes atts)
                throws SAXException {
            switch (localName) {
                case "label":
                    currentElement = CurrentElement.LABEL;
                    break;
                case "username":
                    currentElement = CurrentElement.USERNAME;
                    break;
                case "startDate":
                    currentElement = CurrentElement.START_DATE;
                    break;
                case "endDate":
                    currentElement = CurrentElement.END_DATE;
                    break;
                default:
                    currentElement = CurrentElement.OTHER;
            }
        }

        public void characters(char ch[], int start, int length)
                throws SAXException {
            switch (currentElement) {
                case LABEL:
                    String label = new String(ch, start, length);
                    roomBooking.setRoomLabel(label);
                    currentElement = CurrentElement.OTHER;
                    break;
                case USERNAME:
                    String username = new String(ch, start, length);
                    roomBooking.setUsername(username);
                    currentElement = CurrentElement.OTHER;
                    break;
                case START_DATE:
                    try {
                        String dateAsString = new String(ch, start, length);
                        roomBooking.setStartDate(sdf.parse(dateAsString));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    currentElement = CurrentElement.OTHER;
                    break;
                case END_DATE:
                    try {
                        String dateAsString = new String(ch, start, length);
                        roomBooking.setEndDate(sdf.parse(dateAsString));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    currentElement = CurrentElement.OTHER;
            }
        }
    }

    private enum CurrentElement {
        LABEL,
        USERNAME,
        START_DATE,
        END_DATE,
        OTHER;
    }
}
