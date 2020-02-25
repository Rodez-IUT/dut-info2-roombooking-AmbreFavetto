package xmlws.roombooking.xmltools;

import java.util.Date;

public class RoomBooking {

    private String roomLabel;
    private String username;
    private Date startDate;
    private Date endDate;

    public void setRoomLabel(String roomLabel) {
        this.roomLabel = roomLabel;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoomLabel() {
        return roomLabel;
    }

    public String getUsername() {
        return username;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
