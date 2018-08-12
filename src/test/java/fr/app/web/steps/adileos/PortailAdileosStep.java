package fr.app.web.steps.adileos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.app.web.pages.adileos.PortailAdileosInterf;
import fr.app.web.pages.adileos.PortailAdileosSel;
import fr.app.web.steps.StepGlobalUtils;

public class PortailAdileosStep {

    private static Logger logger = Logger.getLogger(PortailAdileosStep.class.getName());

    private PortailAdileosInterf adileos;

    public PortailAdileosStep() {

    }

    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
        logger.debug("Debut " + this.getClass().getName() + " prepare @Before");
        WebDriver webDriver = StepGlobalUtils.getWebDriver();
        adileos = new PortailAdileosSel(webDriver);
        logger.debug("Fin    " + this.getClass().getName() + "  prepare @Before");
    }

    @Then("^PORT_ADILEOS Le portail ADILEOS s'affiche dans l'onglet '(.*)'$")
    public void verifPage(String ongletSel) {
        adileos.verifPage(ongletSel);
    }

    @When("^PORT_ADILEOS Revenir à la page précédente$")
    public void goBack() {
        adileos.goBack();
    }

}
