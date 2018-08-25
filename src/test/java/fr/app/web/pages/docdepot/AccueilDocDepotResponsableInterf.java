package fr.app.web.pages.docdepot;

public interface AccueilDocDepotResponsableInterf {

    void verifPage(String profil) throws InterruptedException;

    void verifPresenceRespTablActSociaux(String profil) throws InterruptedException;

    void verifPresenceActSociaux(String profil);
}
