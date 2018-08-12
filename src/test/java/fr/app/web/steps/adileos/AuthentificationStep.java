package fr.app.web.steps.adileos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.app.web.pages.adileos.AuthentificationInterf;
import fr.app.web.pages.adileos.AuthentificationSel;
import fr.app.web.steps.StepGlobalUtils;

public class AuthentificationStep {

    private static Logger logger = Logger.getLogger(AuthentificationStep.class.getName());

    private AuthentificationInterf authentification;

    public AuthentificationStep() {

    }

    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
        logger.debug("Debut AuthentificationStep prepare @Before");
        WebDriver webDriver = StepGlobalUtils.getWebDriver();
        authentification = new AuthentificationSel(webDriver);
        logger.debug("Fin   AuthentificationStep prepare @Before");
    }

    // ************ FORMULAIRE DE D'AUTHENTIFICATION ******************
    @Given("^Sur la page 'Authentification' URL '(.*)'")
    public void goAuthentification(String url) throws InterruptedException {
        authentification.go(url);
    }

    @Given("^AUTH01 Sur la page 'Authentification DOC-DEPOT'$")
    public void verifPageAuthentifDocDepotArrivee() throws InterruptedException {
        authentification.verifPageDocDepot();
    }

    @Given("^AUTH01 Sur la page 'Authentification FISSA'$")
    public void verifPageAuthentifFissaArrivee() throws InterruptedException {
        authentification.verifPageFissa();
    }

    @Given("^AUTH01 Sur la page 'Authentification RAPPEL-RDV-SMS'$")
    public void verifPageAuthentifRappelRdvArrivee() throws InterruptedException {
        authentification.verifPageRappelRdvSms();
    }

    @Given("^AUTH01 Sur la page 'Authentification SUIVI-BENEFICIAIRE'$")
    public void verifPageAuthentifSuiviBenefArrivee() throws InterruptedException {
        authentification.verifPageSuiviBeneficiaire();
    }

    @When("AUTH01 Dans le champ 'Identifiant' saisir '(.*)'$")
    public void authentificationSaisirUid(String loginP) {
        authentification.saisirUid(loginP);
    }

    @When("AUTH01 Dans le champ 'Mot de passe' saisir '(.*)'")
    public void authentificationSaisirPassword(String password) {
        authentification.saisirPassword(password);
    }

    @When("AUTH01 Cliquer sur le bouton 'SE CONNECTER'")
    public void formulaireLogin() {
        authentification.cliquerSeConnecter();
    }

    @Then("AUTH01 Le message '(.*)' s'affiche")
    public void verifMessageErreur(String message) throws InterruptedException {
        authentification.verifyErrorMessage(message);
    }

    @Then("^AUTH01 La page 'Authentification DOC-DEPOT' s'affiche$")
    public void verifPageAuthentifDocDepot() throws InterruptedException {
        authentification.verifPageDocDepot();
    }

    @Then("^AUTH01 La page 'Authentification RAPPEL-RDV-SMS' s'affiche$")
    public void verifPageAuthentifRappelRdv() throws InterruptedException {
        authentification.verifPageRappelRdvSms();
    }

    @Then("^AUTH01 La page 'Authentification FISSA' s'affiche$")
    public void verifPageAuthentifFissa() throws InterruptedException {
        authentification.verifPageFissa();
    }

    @Then("^AUTH01 La page 'Authentification SUIVI-BENEFICIAIRE' s'affiche$")
    public void verifPageAuthentifSuiviBenef() throws InterruptedException {
        authentification.verifPageSuiviBeneficiaire();
    }

    @When("^AUTH01 Supprimer le contrôle front-end sur le champs 'Identifiant'$")
    public void supprimerAttrRequiredChampsIdentifiant() {
        authentification.supprimerAttrRequiredChampsIdentifiant();
    }

    @When("^AUTH01 Supprimer le contrôle front-end sur le champs 'Mot de passe'$")
    public void supprimerAttrRequiredChampsMdp() {
        authentification.supprimerAttrRequiredChampsMdp();
    }

    @When("^AUTH01 Accéder à FISSA$")
    public void accederPageLienFissa() {
        authentification.goLienFissa();
    }

    @When("^AUTH01 Accéder au Rappel de rendez-vous par SMS$")
    public void accederPageLienRappelRdv() {
        authentification.goLienRappelRdvSms();
    }

    @When("^AUTH01 Accéder au Suivi des bénéficiaires$")
    public void accederPageLienSuiviBenef() {
        authentification.goLienSuiviBenef();
    }

    @Then("^AUTH01 Le message de déconnexion '(.*)' s'affiche$")
    public void verifMsgDeconnexion(String msg) {
        authentification.verifMsgDeconnexion(msg);
    }

    @When("^AUTH01 Accéder au lien '(.*)'$")
    public void goLienAdileos(String titre) {
        authentification.goLienAdileos(titre);
    }
}
