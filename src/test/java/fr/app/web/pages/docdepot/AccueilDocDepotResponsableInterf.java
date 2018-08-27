package fr.app.web.pages.docdepot;

public interface AccueilDocDepotResponsableInterf {

    void verifPage(String profil) throws InterruptedException;

    void verifPresenceRespTablActSociaux(String profil) throws InterruptedException;

    void verifPresenceActSociaux(String profil);

    void cliquerBoutonSection(String libelleBouton) throws InterruptedException;

    void saisirInfoActeurSocial(String inputName, String valeur) throws InterruptedException;

    void cliquerBoutonAjouterActeurSocial() throws InterruptedException;

    void cliquerBoutonModifierActeurSocial(String nom, String prenom) throws InterruptedException;

    void cliquerBoutonSupprimerActeurSocial(String nom, String prenom) throws InterruptedException;

    void cliquerBoutonConfirmerModificationActeurSocial() throws InterruptedException;

    void cliquerBoutonConfirmerSuppressionActeurSocial() throws InterruptedException;

    void verifInfoActeurSocial(String nom, String prenom, String tel, String mail) throws InterruptedException;

    void verifAbsenceActeurSocial(String nom, String prenom, String tel, String mail) throws InterruptedException;
}
