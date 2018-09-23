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

    @When("^ACCDOCDEPBENEF_SECTION Cliquer sur le bouton '(.*)'$")
    public void cliquerBoutonReferentsConfiance(String section) throws InterruptedException {
        accueil.cliquerBoutonSection(section);
    }

    @When("^ACCDOCDEPBENEF Sélectionner la structure sociale '(.*)'$")
    public void selectStructSociale(String structSociale) throws InterruptedException {
        accueil.selectStructSociale(structSociale);
    }

    @When("^ACCDOCDEPBENEF Sélectionner l'acteur social '(.*)'$")
    public void selectActeurSocial(String actSocial) throws InterruptedException {
        accueil.selectActeurSocial(actSocial);
    }

    @When("^ACCDOCDEPBENEF Saisir le nom '(.*)' du référent de confiance$")
    public void saisirNomRefConfiance(String nom) throws InterruptedException {
        accueil.saisirNomRefConfiance(nom, "nom");
    }

    @When("^ACCDOCDEPBENEF Saisir le prénom '(.*)' du référent de confiance$")
    public void saisirPrenomRefConfiance(String prenom) throws InterruptedException {
        accueil.saisirPrenomRefConfiance(prenom, "prenom");
    }

    @When("^ACCDOCDEPBENEF Cliquer sur le bouton 'Ajouter' pour le référent de confiance$")
    public void cliquerBoutonAjouterRefConfiance() throws InterruptedException {
        accueil.cliquerBoutonAjouterRefConfiance();
    }

    @When("^ACCDOCDEPBENEF Cliquer sur le bouton 'Supprimer' pour le référent de confiance de structure sociale '(.*)', de nom '(.*)' et de prénom '(.*)'$")
    public void cliquerBoutonSupprimerRefConfiance(String structSociale, String nom, String prenom)
            throws InterruptedException {
        accueil.cliquerBoutonSupprimerRefConfiance(structSociale, nom, prenom);
    }

    @When("^ACCDOCDEPBENEF Cliquer le bouton de confirmation$")
    public void cliquerBoutonConfirmation() throws InterruptedException {
        accueil.cliquerBoutonConfirmation();
    }

    @Then("^ACCDOCDEPBENEF_PRES Vérifie la présence du référent de confiance de structure sociale '(.*)', de nom '(.*)', de prénom '(.*)' et d'adresse '(.*)'$")
    public void verifPresenceNouvRefConfiance(String structSociale, String nom, String prenom, String adresse)
            throws InterruptedException {
        accueil.verifPresenceNouvRefConfiance(structSociale, nom, prenom, adresse);
    }

    @Then("^ACCDOCDEPBENEF_PRES02 Vérifie la présence du référent de confiance de structure sociale '(.*)', de nom '(.*)' et de prénom '(.*)'$")
    public void verifPresenceNouvRefConfiance(String structSociale, String nom, String prenom)
            throws InterruptedException {
        accueil.verifPresenceNouvRefConfiance(structSociale, nom, prenom);
    }

    @Then("^ACCDOCDEPBENEF_ABS Vérifie l'absence du référent de confiance de structure sociale '(.*)', de nom '(.*)', de prénom '(.*)' et d'adresse '(.*)'$")
    public void verifAbsenceRefConfiance(String structSociale, String nom, String prenom, String adresse) {
        accueil.verifAbsenceRefConfiance(structSociale, nom, prenom, adresse);
    }

    @Then("^ACCDOCDEPBENEF_ABS02 Vérifie l'absence du référent de confiance de structure sociale '(.*)', de nom '(.*)' et de prénom '(.*)'$")
    public void verifAbsenceRefConfiance(String structSociale, String nom, String prenom) {
        accueil.verifAbsenceRefConfiance(structSociale, nom, prenom);
    }

    @When("^ACCDOCDEPBENEF_AJT_DOC Cliquer sur le bouton 'Ajouter un doc'$")
    public void cliquerBoutonAjouterDoc() throws InterruptedException {
        accueil.cliquerBoutonAjouterDoc();
    }

    @When("^ACCDOCDEPBENEF Ajouter le document '(.*)'$")
    public void ajouterDocBeneficiaire(String cheminFichier) throws InterruptedException {
        accueil.ajouterDocBeneficiaire(cheminFichier);
    }

    @When("^ACCDOCDEPBENEF Naviguer avec le lien '(.*)'$")
    public void naviguerVersLienRetour(String msg) throws InterruptedException {
        accueil.naviguerVersLienRetour(msg);
    }

    @When("^ACCDOCDEPBENEF Cliquer sur la catégorie de documents '(.*)'$")
    public void cliquerCategorieDocument(String categorie) throws InterruptedException {
        accueil.cliquerCategorieDocument(categorie);
    }

    @Then("^ACCDOCDEPBENEF_PREF_ESP Vérifier la présence du document ajouté '(.*)'$")
    public void verifPresenceDocAjouteAvPrefixeEsp(String nomFichier) throws InterruptedException {
        accueil.verifPresenceDocAjoute(nomFichier, true);
    }

    @Then("^ACCDOCDEPBENEF_PREF_ESP Vérifier l'absence du document '(.*)'$")
    public void verifAbsenceDocAvPrefixeEsp(String nomFichier) throws InterruptedException {
        accueil.verifAbsenceDoc(nomFichier, true);
    }

    @When("^ACCDOCDEPBENEF_PREF_ESP Supprimer le document '(.*)'$")
    public void cliquerBoutonSupprimerDocAvPrefixeEsp(String nomFichier) throws InterruptedException {
        accueil.cliquerBoutonSupprimerDoc(nomFichier, true);
    }

    @Then("^ACCDOCDEPBENEF_ESP Vérifier la présence du document ajouté '(.*)'$")
    public void verifPresenceDocAjoute(String nomFichier) throws InterruptedException {
        accueil.verifPresenceDocAjoute(nomFichier, false);
    }

    @Then("^ACCDOCDEPBENEF_ESP Vérifier l'absence du document '(.*)'$")
    public void verifAbsenceDoc(String nomFichier) throws InterruptedException {
        accueil.verifAbsenceDoc(nomFichier, false);
    }

    @When("^ACCDOCDEPBENEF_ESP Supprimer le document '(.*)'$")
    public void cliquerBoutonSupprimerDoc(String nomFichier) throws InterruptedException {
        accueil.cliquerBoutonSupprimerDoc(nomFichier, false);
    }

    @When("^ACCDOCDEPBENEF_ESP Changer le document '(.*)' d'espace$")
    public void cliquerBoutonChangerEspaceDoc(String nomFichier) throws InterruptedException {
        accueil.cliquerBoutonChangerEspaceDoc(nomFichier, false);
    }

    @When("^ACCDOCDEPBENEF Cliquer sur le bouton de confirmation pour la suppression du document$")
    public void cliquerBoutonConfirmationSupprDoc() throws InterruptedException {
        accueil.cliquerBoutonConfirmationSupprDoc();
    }

    @When("^ACCDOCDEPBENEF Saisir la note '(.*)'$")
    public void saisirNote(String note) throws InterruptedException {
        accueil.saisirNote(note);
    }

    @When("^ACCDOCDEPBENEF_AJT_NOTE Cliquer sur le bouton 'Ajouter'$")
    public void cliquerBoutonAjouterNote() throws InterruptedException {
        accueil.cliquerBoutonAjouterNote();
    }

    @When("^ACCDOCDEPBENEF Supprimer la note '(.*)'$")
    public void cliquerBoutonSupprimerNote(String note) throws InterruptedException {
        accueil.cliquerBoutonSupprimerNote(note);
    }

    @Then("^ACCDOCDEPBENEF Vérifier la présence de la note '(.*)'$")
    public void verifPresenceNote(String note) throws InterruptedException {
        accueil.verifPresenceNote(note);
    }

    @Then("^ACCDOCDEPBENEF Vérifier l'absence de la note '(.*)'$")
    public void verifAbsenceNote(String note) throws InterruptedException {
        accueil.verifAbsenceNote(note);
    }
}
