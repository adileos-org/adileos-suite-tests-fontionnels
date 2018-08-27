package fr.app.web.steps.docdepot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @When("^ACCDOCDEPRESP_SECT Cliquer sur le bouton '(.*)'$")
    public void cliquerBoutonSection(String libelleBouton) throws InterruptedException {
        accueil.cliquerBoutonSection(libelleBouton);
    }

    @When("^ACCDOCDEPRESP Renseigner le nom '(.*)'$")
    public void saisirChampActeurSocialNom(String nom) throws InterruptedException {
        accueil.saisirInfoActeurSocial("nom", nom);
    }

    @When("^ACCDOCDEPRESP Renseigner le prénom '(.*)'$")
    public void saisirChampActeurSocialPrenom(String prenom) throws InterruptedException {
        accueil.saisirInfoActeurSocial("prenom", prenom);
    }

    @When("^ACCDOCDEPRESP Renseigner le téléphone '(.*)'$")
    public void saisirChampActeurSocialTel(String tel) throws InterruptedException {
        accueil.saisirInfoActeurSocial("telephone", tel);
    }

    @When("^ACCDOCDEPRESP Renseigner le mail '(.*)'$")
    public void saisirChampActeurSocialMail(String mail) throws InterruptedException {
        accueil.saisirInfoActeurSocial("mail", mail);
    }

    @When("^ACCDOCDEPRESP_AJT Cliquer sur le bouton 'Ajouter'$")
    public void cliquerBoutonAjouterActeurSocial() throws InterruptedException {
        accueil.cliquerBoutonAjouterActeurSocial();
    }

    @When("^ACCDOCDEPRESP Cliquer sur l'icône 'Modifier' de l'acteur social de nom '(.*)' et de prénom '(.*)'$")
    public void cliquerBoutonModifierActeurSocial(String nom, String prenom) throws InterruptedException {
        accueil.cliquerBoutonModifierActeurSocial(nom, prenom);
    }

    @When("^ACCDOCDEPRESP Cliquer sur l'icône 'Supprimer' de l'acteur social de nom '(.*)' et de prénom '(.*)'$")
    public void cliquerBoutonSupprimerActeurSocial(String nom, String prenom) throws InterruptedException {
        accueil.cliquerBoutonSupprimerActeurSocial(nom, prenom);
    }

    @When("^ACCDOCDEPRESP_MOD Cliquer sur le bouton 'Modifier'$")
    public void cliquerBoutonModifierActeurSocial() throws InterruptedException {
        accueil.cliquerBoutonConfirmerModificationActeurSocial();
    }

    @When("^ACCDOCDEPRESP Confirmer la suppression de l'acteur social$")
    public void cliquerBoutonSupprimerActeurSocial() throws InterruptedException {
        accueil.cliquerBoutonConfirmerSuppressionActeurSocial();
    }

    @Then("^ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom '(.*)', de prénom '(.*)', de téléphone '(.*)' et de mail '(.*)'$")
    public void verifInfoActeurSocial(String nom, String prenom, String tel, String mail) throws InterruptedException {
        accueil.verifInfoActeurSocial(nom, prenom, tel, mail);
    }

    @Then("^ACCDOCDEPRESP Vérifie l'absence de l'acteur social de nom '(.*)', de prénom '(.*)', de téléphone '(.*)' et de mail '(.*)'$")
    public void verifAbsenceActeurSocial(String nom, String prenom, String tel, String mail)
            throws InterruptedException {
        accueil.verifAbsenceActeurSocial(nom, prenom, tel, mail);
    }
}
