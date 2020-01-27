package servlet;

import ServiceDB.ConnexionDB;
import classe.MediaSupport;
import classe.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;

@WebServlet(name = "AjoutFilmServlet", urlPatterns = {"/AjoutFilm"})
public class AjoutFilmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        boolean IsSucceed = true;

        String nom = request.getParameter("nom");
        String annee = request.getParameter("annee");
        String real = request.getParameter("realisateur");
        String acteur = request.getParameter("acteur");
        String id_support = request.getParameter("support");

        Connection conn = ConnexionDB.OpenConnection(request,response);
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) conn.createStatement();
            String GetListSupport;
            GetListSupport = "INSERT INTO film VALUES ?,?,?,?,?";
            stmt.setString(1,nom);
            stmt.setString(2,acteur);
            stmt.setString(3,real);
            stmt.setInt(4,Integer.parseInt(id_support));
            stmt.setInt(5,Integer.parseInt(annee));

            ResultSet rs = stmt.executeQuery(GetListSupport);
            List<MediaSupport> ListeSupport = ListeSupport(rs);
            request.setAttribute("ListeSupport",ListeSupport);
        } catch (SQLException e) {
            IsSucceed = false;
            e.printStackTrace();
        }

        request.setAttribute("succes",IsSucceed);
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        Connection conn = ConnexionDB.OpenConnection(request,response);
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String GetListSupport;
            GetListSupport = "SELECT * FROM support ";
            ResultSet rs = stmt.executeQuery(GetListSupport);
            List<MediaSupport> ListeSupport = ListeSupport(rs);
            request.setAttribute("ListeSupport",ListeSupport);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path = "/WEB-INF/jsp/film/ajoutFilm.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);

    }

    public List<MediaSupport> ListeSupport (ResultSet rs){
        int size =0;
        List<MediaSupport> LstSp = null;

        try {
            while (rs.next()){
                MediaSupport sp = new MediaSupport(
                        rs.getInt("support_id"),
                        rs.getString("type_support")
                );

                LstSp.add(sp);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return LstSp;
    }
}
