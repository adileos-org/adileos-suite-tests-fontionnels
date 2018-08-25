package fr.app.web.steps.docdepot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import fr.app.web.pages.docdepot.AccueilDocDepotResponsableInterf;
import fr.app.web.pages.docdepot.AccueilDocDepotResponsableSel;
import fr.app.web.steps.StepGlobalUtils;

public class AccueilDocDepotResponsableStep {

    private static Logger logger = Logger.getLogger(AccueilDocDepotResponsableStep.class.getName());

    private AccueilDocDepotResponsableInterf accueil;

    public AccueilDocDepotResponsableStep() {

    }

    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
        logger.debug("Debut " + this.getClass().getName() + " prepare @Before");
        WebDriver webDriver = StepGlobalUtils.getWebDriver();
        accueil = new AccueilDocDepotResponsableSel(webDriver);
        logger.debug("Fin    " + this.getClass().getName() + "  prepare @Before");
    }

    @Given("^ACCDOCDEPRESP Sur la page d'accueil 'DOC-DEPOT' avec le profil '(.*)'$")
    public void verifPageAccueilDocDepotResponsableArrivee(String profil) throws InterruptedException {
        accueil.verifPage(profil);
    }

    @Then("^ACCDOCDEPRESP La page d'accueil 'DOC-DEPOT' s'affiche avec le profil '(.*)'$")
    public void verifPageAccueilDocDepotResponsable(String profil) throws InterruptedException {
        accueil.verifPage(profil);
    }

    @Then("^ACCDOCDEPRESP Le profil '(.*)' et son identifiant de connexion est présent dans le tableau des acteurs sociaux$")
    public void verifPresenceRespTablActSociaux(String profil) throws InterruptedException {
        accueil.verifPresenceRespTablActSociaux(profil);
    }

    @Then("^ACCDOCDEPRESP Les profils '(.*)' et leur identifiant de connexion sont présents dans le tableau des acteurs sociaux$")
    public void verifPresenceActSociaux(String profil) throws InterruptedException {
        accueil.verifPresenceActSociaux(profil);
    }
}
