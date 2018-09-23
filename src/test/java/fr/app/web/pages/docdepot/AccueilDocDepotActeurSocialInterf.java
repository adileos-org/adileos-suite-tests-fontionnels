package fr.app.web.pages.docdepot;

public interface AccueilDocDepotActeurSocialInterf {
    void verifierPresenceBeneficiaire(String nom, String prenom) throws InterruptedException;

    void cliquerBoutonVoirDetailBenef(String nom, String prenom) throws InterruptedException;

    void verifierPresenceBoutonSupprDocument(String nomFichier) throws InterruptedException;

    void verifierAbsenceBoutonSupprDocument(String nomFichier) throws InterruptedException;
}
