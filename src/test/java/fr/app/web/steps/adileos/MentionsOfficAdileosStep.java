package fr.app.web.steps.adileos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.app.web.pages.adileos.MentionsOfficAdileosInterf;
import fr.app.web.pages.adileos.MentionsOfficAdileosSel;
import fr.app.web.steps.StepGlobalUtils;

public class MentionsOfficAdileosStep {

    private static Logger logger = Logger.getLogger(MentionsOfficAdileosStep.class.getName());

    private MentionsOfficAdileosInterf mentionsOffic;

    public MentionsOfficAdileosStep() {

    }

    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
        logger.debug("Debut " + this.getClass().getName() + " prepare @Before");
        WebDriver webDriver = StepGlobalUtils.getWebDriver();
        mentionsOffic = new MentionsOfficAdileosSel(webDriver);
        logger.debug("Fin    " + this.getClass().getName() + "  prepare @Before");
    }

    @Then("^MENT_OFF La page de titre '(.*)' s'affiche$")
    public void verifPageTitre(String titre) {
        mentionsOffic.verifPageTitre(titre);
    }

    @When("^MENT_OFF Accéder au lien 'DOC-DEPOT'$")
    public void goLienDocDepot() {
        mentionsOffic.goLienDocDepot();
    }

    @When("^MENT_OFF Revenir à la page précédente$")
    public void goBack() {
        mentionsOffic.goBack();
    }

}
