package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListFilmServlet")
public class ListFilmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Open a connection
            Connection conn  = DriverManager.getConnection(DB_URL, USER, PASS);
            //SQL query
            Statement stmt = conn.createStatement();
            String ListFilm,SearchFilm,AddFilm,DropFilm,ListMembre,SearchMembre,AddMembre,DropMembre;
            ListFilm = "SELECT nom FROM film" ;
            String film = request.getParameter();

            ResultSet rs = stmt.executeQuery(ListFilm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
