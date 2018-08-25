package fr.app.web.pages.docdepot;

public interface AccueilDocDepotInterf {

    void verifPage(String msgTypeActeur);

    void goLienModifMdp();

    void deconnexion();

    void changeCoordonnee(String nouvVal, String libelle, String inputName) throws InterruptedException;

    void verifSaisie(String saisie, String libelle, String inputName) throws InterruptedException;

    void verifMsgErreur(String msgErr) throws InterruptedException;
}
