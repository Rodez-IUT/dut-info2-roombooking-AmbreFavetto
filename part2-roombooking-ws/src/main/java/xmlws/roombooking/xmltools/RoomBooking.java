package xmlws.roombooking.xmltools;

import java.util.Date;

public class RoomBooking {

    private Long id;
    private String roomLabel;
    private String username;
    private Date startDate;
    private Date endDate;

    public RoomBooking() {
    }

    public RoomBooking(String roomLabel, String username, Date startDate, Date endDate) {
        this.roomLabel = roomLabel;
        this.username = username;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
