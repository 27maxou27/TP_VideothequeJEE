<%@ page import="classe.MediaSupport" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<MediaSupport> supports;
%>

<!-- Header -->
<%@ include file="/WEB-INF/fragment/head.html" %>

<!-- Content -->
<h1>Ajouter un film</h1>

<form method="post" action="/AjoutFilmServlet">

    <div class="form-group">
        <label for="nom">Nom</label>
        <input type="text" class="form-control" id="nom" placeholder="Saisir le nom du film">
    </div>

    <div class="form-group">
        <label for="acteur">Acteur principal</label>
        <input type="text" class="form-control" id="acteur" placeholder="Saisir l'acteur principal">
    </div>

    <div class="form-group">
        <label for="annee">Année de sortie</label>
        <input type="number" class="form-control" id="annee" placeholder="Saisir l'année de sortie">
    </div>

    <div class="form-group">
        <label for="realisateur">Réalisateur</label>
        <input type="text" class="form-control" id="realisateur" placeholder="Saisir le réalisateur">
    </div>

    <div class="form-group">
            <label for="support">Support</label>
<%
    supports = (List<MediaSupport>)request.getAttribute("supports");
    if (supports != null) {
%>
        <select id="support" class="form-control">
            <option value="">-- Choisir --</option>
        <% for (MediaSupport support : supports) { %>
            <option value="<%= support.Id %>"><%= support.Nom %></option>
        <% } %>
        </select>
        <% } else { %>
        <select id="ddl_support" class="form-control">
            <option value="">Erreur</option>
        </select>
        <% } %>
    </div>

    <button type="submit" class="btn btn-primary">Enregistrer</button>
</form>

<!-- Footer -->
<%@ include file="/WEB-INF/fragment/footer.html" %>

</body>
</html>
