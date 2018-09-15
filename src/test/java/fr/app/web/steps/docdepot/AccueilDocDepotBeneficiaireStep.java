package fr.app.web.steps.docdepot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.app.web.pages.docdepot.AccueilDocDepotBeneficiaireInterf;
import fr.app.web.pages.docdepot.AccueilDocDepotBeneficiaireSel;
import fr.app.web.steps.StepGlobalUtils;

public class AccueilDocDepotBeneficiaireStep {

    private static Logger logger = Logger.getLogger(AccueilDocDepotBeneficiaireStep.class.getName());

    private AccueilDocDepotBeneficiaireInterf accueil;

    public AccueilDocDepotBeneficiaireStep() {

    }

    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
        logger.debug("Debut " + this.getClass().getName() + " prepare @Before");
        WebDriver webDriver = StepGlobalUtils.getWebDriver();
        accueil = new AccueilDocDepotBeneficiaireSel(webDriver);
        logger.debug("Fin    " + this.getClass().getName() + "  prepare @Before");
    }

    @When("^ACCDOCDEPBENEF Sélectionner la domiciliation postale '(.*)'$")
    public void selectDomiciliationPost(String domPost) throws InterruptedException {
        accueil.selectDomiciliationPost(domPost);
    }

    @Then("^ACCDOCDEPBENEF Vérifie si l'adresse non éditable est '(.*)'$")
    public void verifLabelAdresse(String adresse) throws InterruptedException {
        accueil.verifLabelAdresse(adresse);
    }

    @Then("^ACCDOCDEPBENEF Vérifie si aucune adresse n'est renseignée$")
    public void verifChampSaisieAdresseVide() throws InterruptedException {
        accueil.verifChampSaisieAdresseVide();
    }

    @Then("^ACCDOCDEPBENEF Vérifie l'absence du champ de saisie pour l'adresse$")
    public void verifAbsenceChampSaisieAdresse() throws InterruptedException {
        accueil.verifAbsenceChampSaisieAdresse();
    }

    @Then("^ACCDOCDEPBENEF Vérifie si le champ de saisie est renseignée avec l'adresse '(.*)'$")
    public void verifChampSaisieAdresseRens(String adresse) throws InterruptedException {
        accueil.verifChampSaisieAdresseRens(adresse);
    }

    @When("^ACCDOCDEPBENEF Saisir l'adresse '(.*)' pour la domiciliation postale$")
    public void saisirAdresseDomPost(String adresse) throws InterruptedException {
        accueil.saisirAdresseDomPost(adresse);
    }
}
