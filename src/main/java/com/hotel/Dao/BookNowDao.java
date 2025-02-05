package com.hotel.Dao;

import com.hotel.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookNowDao {
    public void book(int userId, int roomId) throws SQLException, ClassNotFoundException {
        String roomSql = "select * from public.\"Rooms\" where id = ?";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        PreparedStatement roomStatement = connection.prepareStatement(roomSql);
        roomStatement.setInt(1, roomId);

        ResultSet resultSet = roomStatement.executeQuery();
        if (!resultSet.next()) {
            throw new RuntimeException("room not found");
        }

        String userSql = "select * from public.\"customers\" where id = ?";

        PreparedStatement userStatement = connection.prepareStatement(userSql);
        userStatement.setInt(1, userId);

        ResultSet rs = userStatement.executeQuery();

        if (!rs.next()) {
            throw new RuntimeException("user not found");
        }

        String bookRomSql = "select * from public.\"User_Room\" where room_id = ?";

        PreparedStatement bookRomStatement = connection.prepareStatement(bookRomSql);
        bookRomStatement.setInt(1, roomId);

        ResultSet userRoomRs = bookRomStatement.executeQuery();

        if (userRoomRs.next()) {
            throw new RuntimeException("room has already been booked, try another one");
        }

        String insert = "insert into public.\"User_Room\" (room_id, user_id) values(?, ?)";

        PreparedStatement insertStatement = connection.prepareStatement(insert);
        insertStatement.setInt(1, roomId);
        insertStatement.setInt(2, userId);
        insertStatement.executeUpdate();
    }
}
