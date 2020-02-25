package xmlws.roombooking.xmltools.samples;

import org.junit.Test;
import java.io.InputStream;

public class RoomBookingBasicDomParserTest {

    @Test
    public void testParse() {
        // given : an xml file corresponding to a room
        InputStream inputStream = this.getClass().getResourceAsStream("/roombooking-sample-1.xml");
        // and : a basic dom parser
        RoomBookingBasicDomParser roomBookingBasicDomParser = new RoomBookingBasicDomParser();
        // when : we parse the xml file with a room booking parser instance
        roomBookingBasicDomParser.parse(inputStream);
        // then: it's fine :-)

    }
}
