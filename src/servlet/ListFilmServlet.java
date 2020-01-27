package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ServiceDB.ConnexionDB;
import classe.Movie;

@WebServlet(name = "ListFilmServlet")
public class ListFilmServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        Connection conn = ConnexionDB.OpenConnection(request,response);
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String GetListFilm;
            GetListFilm = "SELECT nom,acteur_principal,realisateur,type_support,annee_sortie FROM film,support where film.support_id = support.support_id";
            ResultSet rs = stmt.executeQuery(GetListFilm);
            request.setAttribute("liste",rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> ListFilm (ResultSet rs){
        int size =0;
        List<Movie> LstMv = null;

        try {
            while (rs.next()){
                Movie mv = new Movie(rs.getString("nom"),
                        rs.getString("acteur_principal"),
                        rs.getString("realisateur"),
                        rs.getInt("annee_sortie"),
                        rs.getString("type_support"));

                LstMv.add(mv);
            }
        }catch (SQLException e) {
                e.printStackTrace();
            }
        return LstMv;
       }
    }
}
