package xmlws.roombooking.xmltools.samples;

import org.junit.Test;

import java.io.InputStream;

public class RoomBookingBasicSaxParserTest {

    @Test
    public void testParse() {
        // given : an xml file corresponding to a room
        InputStream inputStream = this.getClass().getResourceAsStream("/roombooking-sample-1.xml");
        // and a basic sax parser
        RoomBookingBasicSaxParser roomBookingBasicSaxParser = new RoomBookingBasicSaxParser();
        // when : we parse the xml file with a room booking parser instance
        roomBookingBasicSaxParser.parse(inputStream);
        // then : it's fine :-)
    }
}
