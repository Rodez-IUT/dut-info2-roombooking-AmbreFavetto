package xmlws.roombooking.xmltools;

import java.io.InputStream;

/**
 * Interface for objects responsible of RoomBooking xml files parsing
 */
public interface RoomBookingParser {

    /**
     * Parse an xml file provided as an input stream
     *
     * @param inputStream the input stream corresponding to the xml file
     * @return the corresponding RoomBooking object
     */
    public RoomBooking parse(InputStream inputStream);
}
