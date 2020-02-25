package xmlws.roombooking.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import xmlws.roombooking.xmltools.RoomBooking;
import xmlws.roombooking.xmltools.RoomBookingParser;

import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;


@Endpoint
public class RoomBookingEndpoint {

    private RoomBookingService roomBookingService;
    private RoomBookingParser roomBookingParser;
    final private String  NAMESPACE_URI = "http://xmlws.roombooking/rb/schema";

    @Autowired
    public RoomBookingEndpoint(RoomBookingService roomBookingService, RoomBookingParser roomBookingParser) {
        this.roomBookingService = roomBookingService;
        this.roomBookingParser = roomBookingParser;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "roomBookingRequest")
    public void saveRoomBooking(@RequestPayload StreamSource roombookingStreamSource) {
        InputStream roombookingIS = roombookingStreamSource.getInputStream();
        RoomBooking roomBooking = roomBookingParser.parse(roombookingIS);
        roomBookingService.saveRoomBooking(roomBooking);
    }

}
