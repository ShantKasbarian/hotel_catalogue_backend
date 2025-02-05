package com.hotel.Dao;

import com.hotel.config.DatabaseConnection;
import com.hotel.entities.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {
    public List<Room> getRooms() throws SQLException, ClassNotFoundException {
        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT id, price, floor, capacity FROM public.\"Rooms\" ";

        PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            float price = resultSet.getFloat(2);
            int floor = resultSet.getInt(3);
            int capacity = resultSet.getInt(4);

            rooms.add(new Room(id, price, floor, capacity));
        }

        return rooms;
    }
}
