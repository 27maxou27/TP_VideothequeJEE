<%@ page import="classe.Movie" %>
<%@ page import="java.util.List" %>
<%!
    List<Movie> films;
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Header -->
<%@ include file="/WEB-INF/fragment/head.html" %>

<%
    films = (List<Movie>)request.getAttribute("liste");
%>

<!-- Content -->
<h1>Liste des films</h1>

<!-- Footer -->
<%@ include file="/WEB-INF/fragment/footer.html" %>

</body>
</html>