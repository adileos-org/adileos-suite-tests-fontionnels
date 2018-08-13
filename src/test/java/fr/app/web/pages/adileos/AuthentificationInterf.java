package fr.app.web.pages.adileos;

public interface AuthentificationInterf {

    void verifPageDocDepot() throws InterruptedException;

    void verifPageFissa();

    void verifPageRappelRdvSms();

    void verifPageSuiviBeneficiaire();

    void saisirUid(String uid);

    void saisirPassword(String password);

    void cliquerSeConnecter();

    void verifyErrorMessage(String message) throws InterruptedException;

    void go(String url);

    void goLienFissa();

    void goLienRappelRdvSms();

    void goLienSuiviBenef();

    void supprimerAttrRequiredChampsIdentifiant();

    void supprimerAttrRequiredChampsMdp();

    void verifMsgDeconnexion(String msg);

    void goLienAdileos(String titre);
}
