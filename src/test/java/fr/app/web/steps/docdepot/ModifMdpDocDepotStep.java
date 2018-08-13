package fr.app.web.steps.docdepot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.app.web.pages.docdepot.ModifMdpDocDepotInterf;
import fr.app.web.pages.docdepot.ModifMdpDocDepotSel;
import fr.app.web.steps.StepGlobalUtils;

public class ModifMdpDocDepotStep {

    private static Logger logger = Logger.getLogger(ModifMdpDocDepotStep.class.getName());

    private ModifMdpDocDepotInterf modifMdp;

    public ModifMdpDocDepotStep() {

    }

    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
        logger.debug("Debut " + this.getClass().getName() + " prepare @Before");
        WebDriver webDriver = StepGlobalUtils.getWebDriver();
        modifMdp = new ModifMdpDocDepotSel(webDriver);
        logger.debug("Fin    " + this.getClass().getName() + "  prepare @Before");
    }

    @Given("^MODIF_MDP_DOC_DEP Sur la page de modification du mot de passe 'DOC-DEPOT'$")
    public void verifPageModifMdpDocDepotArrivee() {
        modifMdp.verifPage();
    }

    @Then("^MODIF_MDP_DOC_DEP La page de modification du mot de passe 'DOC-DEPOT' s'affiche$")
    public void verifPageModifMdpDocDepot() {
        modifMdp.verifPage();
    }

    @When("^MODIF_MDP_DOC_DEP Saisir '(.*)' dans le champs 'Ancien'$")
    public void saisirAncienMdp(String mdp) {
        modifMdp.saisirAncienMdp(mdp);
    }

    @When("^MODIF_MDP_DOC_DEP Saisir '(.*)' dans le champs 'Nouveau'$")
    public void saisirNouvMdp(String mdp) {
        modifMdp.saisirNouvMdp(mdp);
    }

    @When("^MODIF_MDP_DOC_DEP Saisir '(.*)' dans le champs 'Confirmation'$")
    public void saisirConfirmMdp(String mdp) {
        modifMdp.saisirConfirmMdp(mdp);
    }

    @When("^MODIF_MDP_DOC_DEP Cliquer le bouton 'Modifier'$")
    public void cliquerBoutonModifier() {
        modifMdp.cliquerBoutonModifier();
    }

    @Then("MODIF_MDP_DOC_DEP Le message d'erreur '(.*)' s'affiche")
    public void verifPresenceMsgErreur(String msgErr) throws InterruptedException {
        modifMdp.verifMsgErreur(msgErr);
    }

    @When("MODIF_MDP_DOC_DEP Revenir à la page d'accueil")
    public void goLienRetourPageAccueil() {
        modifMdp.goLienRetourPageAccueil();
    }

    @Then("MODIF_MDP_DOC_DEP Le message '(.*)' s'affiche")
    public void verifMsgSucces(String msgSucces) throws InterruptedException {
        modifMdp.verifMsgSucces(msgSucces);
    }
}
