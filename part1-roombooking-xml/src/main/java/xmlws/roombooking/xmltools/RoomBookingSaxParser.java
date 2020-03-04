package xmlws.roombooking.xmltools;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RoomBookingSaxParser implements RoomBookingParser {

    @Override
    public RoomBooking parse(InputStream inputStream) {
        RoomBooking rb = new RoomBooking();
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(inputStream, new RoomBookingHandler(rb));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rb;
    }

    private class RoomBookingHandler extends DefaultHandler {
        private RoomBooking rb;

        public RoomBookingHandler(RoomBooking rb) {
            this.rb = rb;
        }
        public String balise = "";

        public void startElement(String namespaceURI,
                                 String localName,
                                 String qName,
                                 Attributes atts)
                throws SAXException {
            balise = localName;
            // System.out.println("In element: "+localName);
        }

        public void characters(char ch[], int start, int length)
                throws SAXException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            // System.out.println(new String(ch, start, length));

            String test = new String(ch, start, length);
            if (!test.startsWith("\n")) {

                switch (balise) {
                    case "label":
                        rb.setRoomLabel(new String(ch, start, length));
                        break;
                    case "username":
                        rb.setUsername(new String(ch, start, length));
                        break;
                    case "startDate":
                        try {
                            rb.setStartDate(sdf.parse(new String(ch, start, length)));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "endDate":
                        try {
                            rb.setEndDate(sdf.parse(new String(ch, start, length)));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        // stub
                        break;
                }
            }
        }
    }
}
