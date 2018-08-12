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
}
