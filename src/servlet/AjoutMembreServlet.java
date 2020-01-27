package servlet;

import ServiceDB.ConnexionDB;
import classe.MediaSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;

@WebServlet(name = "AjoutMembreServlet")
public class AjoutMembreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        boolean IsSucceed = true;

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");


        Connection conn = ConnexionDB.OpenConnection(request,response);
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) conn.createStatement();
            String GetListSupport;
            GetListSupport = "INSERT INTO client VALUES ?,?,?";
            stmt.setString(1,nom);
            stmt.setString(2,prenom);
            stmt.setString(3,mail);

            ResultSet rs = stmt.executeQuery(GetListSupport);

        } catch (SQLException e) {
            IsSucceed = false;
            e.printStackTrace();


        }
        request.setAttribute("succes",IsSucceed);
        doGet(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        String path = "/WEB-INF/jsp/membre/ajoutMembre.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }
}
