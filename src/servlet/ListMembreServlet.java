package servlet;

import ServiceDB.ConnexionDB;
import classe.Movie;
import classe.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;

@WebServlet(name = "ListMembreServlet")
public class ListMembreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        Connection conn = ConnexionDB.OpenConnection(request,response);
        PreparedStatement stmt = null;
        try {
            stmt =(PreparedStatement) conn.createStatement();
            String GetListMembre;
            GetListMembre = "SELECT nom,prenom,mail,count(location_id) as FilmLoue FROM film,locationfilm where client_id = locationfilm.location_id";
            if (nom != null && nom != ""){
                GetListMembre = GetListMembre + "and nom = ?";
                stmt.setString(1,nom);
            }
            if (prenom != null && prenom != ""){
                GetListMembre = GetListMembre + "and prenom = ?";
                stmt.setString(1,prenom);

            }
            if (mail != null && mail != ""){
                GetListMembre = GetListMembre + "and mail = ?";
                stmt.setString(1,mail);

            }
            ResultSet rs = stmt.executeQuery(GetListMembre);
            List<User> ListeClient = ListClient(rs);
            request.setAttribute("listeClient",ListeClient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String path = "/WEB-INF/jsp/membre/listerMembres.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    public List<User> ListClient (ResultSet rs){
        int size =0;
        List<User> LstUs = null;

        try {
            while (rs.next()){
                User mv = new User(rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("mail"),
                        rs.getInt("FilmLoue"));

                LstUs.add(mv);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return LstUs;
    }
}
