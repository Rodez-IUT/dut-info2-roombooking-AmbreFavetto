package xmlws.roombooking.ws;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import xmlws.roombooking.xmltools.RoomBooking;

import java.util.List;

@Mapper @Service
public interface RoomBookingService {

    @Insert("insert into room_booking (id,room_label, username, start_date, end_date) values (#{id},#{roomLabel},#{username},#{startDate},#{endDate})")
    @SelectKey(statement="SELECT nextVal('rb_sequence')", keyProperty="id", before=true, resultType=Long.class)
    public void saveRoomBooking(RoomBooking roomBooking);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "roomLabel", column = "room_label"),
            @Result(property = "username", column = "username"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date")
    })
    @Select("select * from room_booking where id = #{id}")
    public RoomBooking findRoomBookingForId(Long id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "roomLabel", column = "room_label"),
            @Result(property = "username", column = "username"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date")
    })
    @Select("select * from room_booking where room_label = #{roomLabel} order by username;")
    public List<RoomBooking> findAllRoomBookingsForRoom(String roomLabel);

}
