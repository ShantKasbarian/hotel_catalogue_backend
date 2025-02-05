package com.hotel.web_layer;

import com.hotel.Dao.UserBookedRoomDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/my/rooms")
public class UserBookedRooms extends HttpServlet {
    private UserBookedRoomDao userBookedRoomDao = new UserBookedRoomDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        try {
            response.setContentType("application/json");
            response.getWriter().write(userBookedRoomDao.getUserBookedRooms(userId).toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
