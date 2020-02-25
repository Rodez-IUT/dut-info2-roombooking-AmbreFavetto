package xmlws.roombooking.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmlws.roombooking.xmltools.RoomBooking;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomBookingServiceTests {

    @Autowired
    private RoomBookingService roomBookingService;


    @Test
    public void testSaveBooking() {
        // given a RoomBooking instance not saved, aka with no id
        RoomBooking roomBooking = new RoomBooking("A302","JohnDoe",new Date(), new Date());
        assertThat(roomBooking.getId(),nullValue());

        // When saving the room booking
        roomBookingService.saveRoomBooking(roomBooking);

        // then the room booking has now an id
        assertThat(roomBooking.getId(), is(not(nullValue())));

        // and when I trigger the search of a roomBooking with this id
        RoomBooking fetchedRoomBooking = roomBookingService.findRoomBookingForId(roomBooking.getId());

        // then I obtain a new instance corresponding with the same raw in database
        assertThat(fetchedRoomBooking, is(not(roomBooking)));
        assertThat(fetchedRoomBooking.getId(), is(roomBooking.getId()));
        assertThat(fetchedRoomBooking.getRoomLabel(), is(roomBooking.getRoomLabel()));

    }

    @Test
    public void testFindAllRoomBooking() {
        // given 3 room bookings with 2 concerning room A302 saved in the database
        roomBookingService.saveRoomBooking(new RoomBooking("A302","JohnDoe",new Date(), new Date()));
        roomBookingService.saveRoomBooking(new RoomBooking("A303","JohnDoe",new Date(), new Date()));
        roomBookingService.saveRoomBooking(new RoomBooking("A302","BobDoe",new Date(), new Date()));

        // when I trigger the search of all room bookings for room A302
        List<RoomBooking> roomBookings = roomBookingService.findAllRoomBookingsForRoom("A302");

        // then I obtain a list of 2 room bookings
        assertThat(roomBookings.size(), is(2));

        // and the list is ordered by username
        assertThat(roomBookings.get(0).getUsername(), is("BobDoe"));
        assertThat(roomBookings.get(1).getUsername(), is("JohnDoe"));

    }
}
