package fr.app.web.pages.docdepot;

public interface AccueilDocDepotBeneficiaireInterf {

    void selectDomiciliationPost(String domPost) throws InterruptedException;

    void verifAbsenceChampSaisieAdresse() throws InterruptedException;

    void verifLabelAdresse(String adresse) throws InterruptedException;

    void verifChampSaisieAdresseVide() throws InterruptedException;

    void verifChampSaisieAdresseRens(String adresse) throws InterruptedException;

    void saisirAdresseDomPost(String adresse) throws InterruptedException;

    void cliquerBoutonReferentsConfiance() throws InterruptedException;

    void selectStructSociale(String structSociale) throws InterruptedException;

    void selectActeurSocial(String actSocial) throws InterruptedException;

    void saisirNomRefConfiance(String nom, String attrName) throws InterruptedException;

    void saisirPrenomRefConfiance(String prenom, String attrName) throws InterruptedException;

    void cliquerBoutonAjouterRefConfiance() throws InterruptedException;

    void cliquerBoutonSupprimerRefConfiance(String structSociale, String nom, String prenom)
            throws InterruptedException;

    void cliquerBoutonConfirmation() throws InterruptedException;

    void verifPresenceNouvRefConfiance(String structSociale, String nom, String prenom, String adresse)
            throws InterruptedException;

    void verifPresenceNouvRefConfiance(String structSociale, String nom, String prenom) throws InterruptedException;

    void verifAbsenceRefConfiance(String structSociale, String nom, String prenom, String adresse);

    void verifAbsenceRefConfiance(String structSociale, String nom, String prenom);
}