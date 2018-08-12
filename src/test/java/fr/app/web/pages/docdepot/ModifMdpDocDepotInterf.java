package fr.app.web.pages.docdepot;

public interface ModifMdpDocDepotInterf {

    void verifPage();

    void saisirAncienMdp(String mdp);

    void saisirNouvMdp(String mdp);

    void saisirConfirmMdp(String mdp);

    void cliquerBoutonModifier();

    void verifMsgErreur(String msgErr);

    void goLienRetourPageAccueil();

    void verifMsgSucces(String msgSucces);
}
