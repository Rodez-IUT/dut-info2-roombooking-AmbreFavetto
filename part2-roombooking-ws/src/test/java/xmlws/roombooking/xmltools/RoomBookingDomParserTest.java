package xmlws.roombooking.xmltools;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RoomBookingDomParserTest {

    private RoomBookingParser roomBookingParser ;

    @Before
    public void before() {
        roomBookingParser = new RoomBookingDomParser();
    }

    @Test
    public void testParseInputStreamWithFile1() throws IOException, ParseException {
        // given : an xml file corresponding to a room
        InputStream inputStream = this.getClass().getResourceAsStream("/roombooking-sample-1.xml");

        // when : we parse the xml file with a room booking parser instance
        RoomBooking roomBooking = roomBookingParser.parse(inputStream);

        // then : we get a room booking object initialize with values coming from the xml file
        assertThat(roomBooking.getRoomLabel(), is("A203"));
        assertThat(roomBooking.getUsername(), is("JohnDoe"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        assertThat(sdf.format(roomBooking.getStartDate()), is("2019-02-27T09:00:00"));
        assertThat(sdf.format(roomBooking.getEndDate()), is("2019-02-27T10:00:00"));
    }

    @Test
    public void testParseInputStreamWithFile2() throws IOException, ParseException {
        // given : an xml file corresponding to a room
        InputStream inputStream = this.getClass().getResourceAsStream("/roombooking-sample-2.xml");

        // when : we parse the xml file with a room booking parser instance
        RoomBooking roomBooking = roomBookingParser.parse(inputStream);

        // then : we get a room booking object initialize with values coming from the xml file
        assertThat(roomBooking.getRoomLabel(), is("B603"));
        assertThat(roomBooking.getUsername(), is("KateHudson"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        assertThat(sdf.format(roomBooking.getStartDate()), is("2019-02-01T08:00:00"));
        assertThat(sdf.format(roomBooking.getEndDate()), is("2019-02-01T10:00:00"));
    }

}