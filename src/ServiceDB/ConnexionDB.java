package ServiceDB;

import org.ini4j.Wini;

import org.ini4j.Wini;

import javax.servlet.RequestDispatcher;
import java.io.File;
import java.io.IOException;
import java.sql.*;


public class ConnexionDB {
    String path = "/WEB-INF/jsp/content.jsp";


    protected Connection doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
        Connection conn = null;

        Wini ini = new Wini(new File("E:\\EPSI B3\\Java\\Videothèque\\web\\WEB-INF\\conf.ini"));
        String DB_URL = ini.get("ConnexionDB", "url");
        String USER = ini.get("ConnexionDB", "user");
        String PASS = "";


        try {
           conn  = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn ;
    }
}
