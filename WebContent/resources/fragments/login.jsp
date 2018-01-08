<div>
    

        <form method="post" action="<c:url value='/logIn' />">
            <input type="text" name="firstname" placeholder="Prenom" /> <input
                type="password" name="password" placeholder="password" /><br>
            <input type="submit" value="Connection" />

        </form>
        <br> <br>
        <!-- si le parametres de connection sont faux -->
        <c:if test="${!empty usererror }">${usererror }</c:if>
    </div>

    <div class="col-lg-3 acces">
        <h2>Nouveau menbres</h2>
        <a href="<c:url value='/signIn'/>">Inscription</a>

    </div>
</div>