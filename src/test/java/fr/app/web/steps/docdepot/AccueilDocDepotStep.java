package fr.app.web.steps.docdepot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.app.web.pages.docdepot.AccueilDocDepotInterf;
import fr.app.web.pages.docdepot.AccueilDocDepotSel;
import fr.app.web.steps.StepGlobalUtils;

public class AccueilDocDepotStep {

    private static Logger logger = Logger.getLogger(AccueilDocDepotStep.class.getName());

    private AccueilDocDepotInterf accueil;

    public AccueilDocDepotStep() {

    }

    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
        logger.debug("Debut " + this.getClass().getName() + " prepare @Before");
        WebDriver webDriver = StepGlobalUtils.getWebDriver();
        accueil = new AccueilDocDepotSel(webDriver);
        logger.debug("Fin    " + this.getClass().getName() + "  prepare @Before");
    }

    @Given("^ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message '(.*)'$")
    public void verifPageAccueilDocDepotArrivee(String msgTypeActeur) {
        accueil.verifPage(msgTypeActeur);
    }

    @Then("^ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message '(.*)'$")
    public void verifPageAccueilDocDepot(String msgTypeActeur) {
        accueil.verifPage(msgTypeActeur);
    }

    @When("^ACCDOCDEP Cliquer sur le bouton 'Déconnexion'$")
    public void deconnexion() {
        accueil.deconnexion();
    }

    @When("^ACCDOCDEP Cliquer sur le bouton 'Modification mot de passe'$")
    public void accederPageModifMdp() {
        accueil.goLienModifMdp();
    }

    @When("^ACCDOCDEP Change 'Tel pro' par '(.*)'$")
    public void changeCoordonneeTelPro(String nouvTel) throws InterruptedException {
        accueil.changeCoordonnee(nouvTel, " Tel pro :", "telephone");
    }

    @Then("^ACCDOCDEP Vérifie la valeur de 'Tel pro' qui doit contenir '(.*)'$")
    public void verifCoordonneeTelPro(String tel) throws InterruptedException {
        accueil.verifSaisie(tel, " Tel pro :", "telephone");
    }

    @When("^ACCDOCDEP Change 'Mail pro' par '(.*)'$")
    public void changeCoordonneeMailPro(String nouvMail) throws InterruptedException {
        accueil.changeCoordonnee(nouvMail, " Mail pro : ", "telephone2");
    }

    @Then("^ACCDOCDEP Vérifie la valeur de 'Mail pro' qui doit contenir '(.*)'$")
    public void verifCoordonneeMailPro(String mail) throws InterruptedException {
        accueil.verifSaisie(mail, " Mail pro : ", "telephone2");
    }

    @When("^ACCDOCDEP Change 'Adresse' par '(.*)'$")
    public void changeCoordonneeAdresse(String nouvAdr) throws InterruptedException {
        accueil.changeCoordonnee(nouvAdr, " Adresse: ", "adresse");
    }

    @Then("^ACCDOCDEP Vérifie la valeur de 'Adresse' qui doit contenir '(.*)'$")
    public void verifCoordonneeAdresse(String adr) throws InterruptedException {
        accueil.verifSaisie(adr, " Adresse: ", "adresse");
    }

    @When("^ACCDOCDEP Change 'Téléphone' par '(.*)'$")
    public void changeCoordonneeTel(String nouvTel) throws InterruptedException {
        accueil.changeCoordonnee(nouvTel, " - Téléphone: ", "telephone");
    }

    @Then("^ACCDOCDEP Vérifie la valeur de 'Téléphone' qui doit contenir '(.*)'$")
    public void verifCoordonneeTel(String tel) throws InterruptedException {
        accueil.verifSaisie(tel, " - Téléphone: ", "telephone");
    }

    @When("^ACCDOCDEP Change 'Mail' par '(.*)'$")
    public void changeCoordonneeMail(String nouvMail) throws InterruptedException {
        accueil.changeCoordonnee(nouvMail, " - Mail: ", "mail");
    }

    @Then("^ACCDOCDEP Vérifie la valeur de 'Mail' qui doit contenir '(.*)'$")
    public void verifCoordonneeMail(String mail) throws InterruptedException {
        accueil.verifSaisie(mail, " - Mail: ", "mail");
    }

    @Then("^ACCDOCDEP Vérifie la présence du message d'erreur '(.*)'$")
    public void verifMsgErreur(String msgErr) throws InterruptedException {
        accueil.verifMsgErreur(msgErr);
    }
}
