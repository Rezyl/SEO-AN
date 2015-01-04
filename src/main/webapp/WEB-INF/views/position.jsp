<h1>Zjištění pozice</h1>

<form class="pure-form" action="/pozice_zpracuj" method="get">
    <fieldset>
        <legend>A compact inline form</legend>

        <input type="text" name="url" placeholder="url" value="http://www.auto.cz/" />
        <input type="text" name="key" placeholder="klíčové slovo" value="auto" />
        <input type="text" name="numberOfPage" value="1" />
        <select name="search_engines">
            <option value="all">Všechny</option>
            <option value="seznam_cz" selected="selected">Seznam.cz</option>
            <option value="google_com">Google.com</option>
        </select>

        <button type="submit" class="pure-button pure-button-primary">Odeslat</button>
    </fieldset>
</form>