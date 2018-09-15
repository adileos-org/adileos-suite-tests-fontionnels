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
    public void verifPageAccueilDocDepotArrivee(String msgTypeActeur) throws InterruptedException {
        accueil.verifPage(msgTypeActeur);
    }

    @Then("^ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message '(.*)'$")
    public void verifPageAccueilDocDepot(String msgTypeActeur) throws InterruptedException {
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

    @When("^ACCDOCDEP_TEL Change '(.*)' par '(.*)'$")
    public void changeCoordonneeTel(String label, String nouvTel) throws InterruptedException {
        accueil.changeCoordonnee(nouvTel, " " + label + " :", "telephone");
    }

    @Then("^ACCDOCDEP_TEL Vérifie la valeur de '(.*)' qui doit contenir '(.*)'$")
    public void verifCoordonneeTel(String label, String tel) throws InterruptedException {
        accueil.verifSaisie(tel, " " + label + " :", "telephone");
    }

    @When("^ACCDOCDEP_MAIL Change '(.*)' par '(.*)'$")
    public void changeCoordonneeMail(String label, String nouvMail) throws InterruptedException {
        accueil.changeCoordonnee(nouvMail, " " + label + " : ", "telephone2");
    }

    @Then("^ACCDOCDEP_MAIL Vérifie la valeur de '(.*)' qui doit contenir '(.*)'$")
    public void verifCoordonneeMail(String label, String mail) throws InterruptedException {
        accueil.verifSaisie(mail, " " + label + " : ", "telephone2");
    }

    @When("^ACCDOCDEP_MAIL_BENEF Change '(.*)' par '(.*)'$")
    public void changeCoordonneeMailBenef(String label, String nouvMail) throws InterruptedException {
        accueil.changeCoordonnee(nouvMail, " " + label + " :", "telephone2");
    }

    @Then("^ACCDOCDEP_MAIL_BENEF Vérifie la valeur de '(.*)' qui doit contenir '(.*)'$")
    public void verifCoordonneeMailBenef(String label, String mail) throws InterruptedException {
        accueil.verifSaisie(mail, " " + label + " :", "telephone2");
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
    public void changeCoordonneeTelStructForm(String nouvTel) throws InterruptedException {
        accueil.changeCoordonnee(nouvTel, " - Téléphone: ", "telephone");
    }

    @Then("^ACCDOCDEP Vérifie la valeur de 'Téléphone' qui doit contenir '(.*)'$")
    public void verifCoordonneeTelStructForm(String tel) throws InterruptedException {
        accueil.verifSaisie(tel, " - Téléphone: ", "telephone");
    }

    @When("^ACCDOCDEP Change 'Mail' par '(.*)'$")
    public void changeCoordonneeMailStructForm(String nouvMail) throws InterruptedException {
        accueil.changeCoordonnee(nouvMail, " - Mail: ", "mail");
    }

    @Then("^ACCDOCDEP Vérifie la valeur de 'Mail' qui doit contenir '(.*)'$")
    public void verifCoordonneeMailStructForm(String mail) throws InterruptedException {
        accueil.verifSaisie(mail, " - Mail: ", "mail");
    }

    @Then("^ACCDOCDEP Vérifie la présence du message d'erreur '(.*)'$")
    public void verifMsgErreur(String msgErr) throws InterruptedException {
        accueil.verifMsgErreur(msgErr);
    }

    @Then("^ACCDOCDEP Vérifie la présence du message de succès '(.*)'$")
    public void verifMsgSucces(String msg) throws InterruptedException {
        accueil.verifMsgSucces(msg);
    }

    @When("^ACCDOCDEP Saisir le filtre de recherche '(.*)'$")
    public void saisirFiltreRecherche(String filtre) throws InterruptedException {
        accueil.saisirFiltreRecherche(filtre);
    }

    @Then("^ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '(.*)'$")
    public void verifNbLignesFiltrees(int nbLignes) throws InterruptedException {
        accueil.verifNbLignesFiltrees(nbLignes);
    }

    @When("^ACCDOCDEP Cliquer sur le bouton '(.*)' pour la suppression du filtre$")
    public void cliquerBoutonSupprimerFiltre(String infoBulle) throws InterruptedException {
        accueil.cliquerBoutonSupprimerFiltre(infoBulle);
    }
}
