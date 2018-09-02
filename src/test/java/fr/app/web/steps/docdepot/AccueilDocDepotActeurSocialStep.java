package fr.app.web.steps.docdepot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import fr.app.web.pages.docdepot.AccueilDocDepotActeurSocialInterf;
import fr.app.web.pages.docdepot.AccueilDocDepotActeurSocialSel;
import fr.app.web.steps.StepGlobalUtils;

public class AccueilDocDepotActeurSocialStep {

    private static Logger logger = Logger.getLogger(AccueilDocDepotActeurSocialStep.class.getName());

    private AccueilDocDepotActeurSocialInterf accueil;

    public AccueilDocDepotActeurSocialStep() {

    }

    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
        logger.debug("Debut " + this.getClass().getName() + " prepare @Before");
        WebDriver webDriver = StepGlobalUtils.getWebDriver();
        accueil = new AccueilDocDepotActeurSocialSel(webDriver);
        logger.debug("Fin    " + this.getClass().getName() + "  prepare @Before");
    }

    @Then("^ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom '(.*)' et de prénom '(.*)'$")
    public void verifPresenceBeneficiaire(String nom, String prenom) throws InterruptedException {
        accueil.verifierPresenceBeneficiaire(nom, prenom);
    }
}
