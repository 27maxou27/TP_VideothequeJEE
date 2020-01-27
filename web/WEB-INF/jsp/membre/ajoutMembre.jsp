<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Header -->
<%@ include file="/WEB-INF/fragment/head.html" %>

<!-- Content -->
<h1>Ajouter un membre</h1>

<form>

    <div class="form-group">
        <label for="txt_nom">Nom</label>
        <input type="text" class="form-control" id="txt_nom" placeholder="Votre nom">
    </div>

    <div class="form-group">
        <label for="txt_prenom">Prénom</label>
        <input type="text" class="form-control" id="txt_prenom" placeholder="Votre prénom">
    </div>

    <div class="form-group">
        <label for="txt_email">Email</label>
        <input type="email" class="form-control" id="txt_email" placeholder="Votre email">
    </div>

    <button type="submit" class="btn btn-primary">Enregistrer</button>
</form>

<!-- Footer -->
<%@ include file="/WEB-INF/fragment/footer.html" %>

</body>
</html>