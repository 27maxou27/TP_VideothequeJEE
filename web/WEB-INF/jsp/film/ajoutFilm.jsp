<%@ page import="classe.MediaSupport" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<MediaSupport> supports;
%>

<!-- Header -->
<%@ include file="/WEB-INF/fragment/head.html" %>

<!-- Content -->
<h1>Ajouter un film</h1>

<form method="post">

    <div class="form-group">
        <label for="txt_nom">Nom</label>
        <input type="text" class="form-control" id="txt_nom" placeholder="Saisir le nom du film">
    </div>

    <div class="form-group">
        <label for="txt_acteur">Acteur principal</label>
        <input type="text" class="form-control" id="txt_acteur" placeholder="Saisir l'acteur principal">
    </div>

    <div class="form-group">
        <label for="txt_annee">Année de sortie</label>
        <input type="number" class="form-control" id="txt_annee" placeholder="Saisir l'année de sortie">
    </div>

    <div class="form-group">
        <label for="txt_realisateur">Réalisateur</label>
        <input type="text" class="form-control" id="txt_realisateur" placeholder="Saisir le réalisateur">
    </div>

    <div class="form-group">
            <label for="ddl_support">State</label>
            <select id="ddl_support" class="form-control">
                <option selected>-- Choisir support --</option>
            </select>
    </div>

    <button type="submit" class="btn btn-primary">Enregistrer</button>
</form>

<!-- Footer -->
<%@ include file="/WEB-INF/fragment/footer.html" %>

</body>
</html>
