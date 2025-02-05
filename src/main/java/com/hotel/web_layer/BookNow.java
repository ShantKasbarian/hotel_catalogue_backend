package com.hotel.web_layer;

import com.hotel.Dao.BookNowDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/book")
public class BookNow extends HttpServlet {
    private BookNowDao bookNowDao = new BookNowDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        try {
            bookNowDao.book(userId, roomId);
            resp.setContentType("application/json");
            resp.getWriter().write("room has been booked");
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
        catch (SQLException | ClassNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        catch (RuntimeException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
