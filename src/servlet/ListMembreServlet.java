package servlet;

import ServiceDB.ConnexionDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ListMembreServlet")
public class ListMembreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        Connection conn = ConnexionDB.OpenConnection(request,response);
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String GetListMembre;
            GetListMembre = "SELECT nom,prenom,mail FROM client";
            ResultSet rs = stmt.executeQuery(GetListMembre);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
