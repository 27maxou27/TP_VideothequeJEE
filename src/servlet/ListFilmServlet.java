package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

import ServiceDB.ConnexionDB;
import classe.Movie;

@WebServlet(name = "ListFilmServlet")
public class ListFilmServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String annee = request.getParameter("annee");
        String real = request.getParameter("realisateur");
        String acteur = request.getParameter("acteur");
        String support = request.getParameter("support");

        Connection conn = ConnexionDB.OpenConnection(request,response);
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) conn.createStatement();
            String GetListFilm;
            GetListFilm = "SELECT nom,acteur_principal,realisateur,type_support,annee_sortie FROM film,support where film.support_id = support.support_id";
            if (nom != null && nom != ""){
                GetListFilm = GetListFilm + "and nom = ?";
                stmt.setString(1,nom);
            }
            if (annee != null && annee != ""){
                GetListFilm = GetListFilm + "and annee_sortie = ?";
                stmt.setInt(1,Integer.valueOf(annee));

                    }
            if (real != null && real != ""){
                GetListFilm = GetListFilm + "and realisateur = ?";
                stmt.setString(1,real);

                        }
            if (acteur != null && acteur != ""){
                GetListFilm = GetListFilm + "and acteur_principal = ?";
                stmt.setString(1,acteur);

                            }
            if (support != null && support != "" ){
                GetListFilm = GetListFilm + "and type_support = ?";
                stmt.setString(1,support);


            }
            ResultSet rs = stmt.executeQuery(GetListFilm);
            List<Movie> ListeFilm = ListFilm(rs);
            request.setAttribute("listeFilm",ListeFilm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path = "/WEB-INF/jsp/film/listerFilms.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);

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
