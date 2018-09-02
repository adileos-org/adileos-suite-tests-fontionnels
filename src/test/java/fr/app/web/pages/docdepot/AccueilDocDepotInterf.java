package fr.app.web.pages.docdepot;

public interface AccueilDocDepotInterf {

    void verifPage(String msgTypeActeur) throws InterruptedException;

    void goLienModifMdp();

    void deconnexion();

    void changeCoordonnee(String nouvVal, String libelle, String inputName) throws InterruptedException;

    void verifSaisie(String saisie, String libelle, String inputName) throws InterruptedException;

    void verifMsgErreur(String msgErr) throws InterruptedException;

    void verifMsgSucces(String msg) throws InterruptedException;

    void saisirFiltreRecherche(String filtre) throws InterruptedException;

    void verifNbLignesFiltrees(int nbLignes) throws InterruptedException;

    void cliquerBoutonSupprimerFiltre(String infoBulle) throws InterruptedException;
}
