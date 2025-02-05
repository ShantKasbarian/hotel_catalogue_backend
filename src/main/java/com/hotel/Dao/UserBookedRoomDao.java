package com.hotel.Dao;

import com.hotel.config.DatabaseConnection;
import com.hotel.entities.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBookedRoomDao {
    public List<Room> getUserBookedRooms(int userId) throws SQLException, ClassNotFoundException {
        List<Room> rooms = new ArrayList<>();
        List<Integer> roomIds = new ArrayList<>();

        String sql = "select * from public.\"User_Room\" where user_id=?";

        PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            roomIds.add(resultSet.getInt(1));
        }

        if (roomIds.isEmpty()) {
            throw new RuntimeException("No rooms found for user id " + userId);
        }

        String roomsSql = "select * from public.\"Rooms\" where id=?";

        for (Integer roomId : roomIds) {
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(roomsSql);
            preparedStatement.setInt(1, roomId);
            ResultSet resultSet1 = preparedStatement.executeQuery();

            while (resultSet1.next()) {
                int id = resultSet1.getInt(1);
                float price = resultSet1.getFloat(2);
                int floor = resultSet1.getInt(3);
                int capacity = resultSet1.getInt(4);

                rooms.add(new Room(id, price, floor, capacity));
            }
        }

        return rooms;

    }
}
