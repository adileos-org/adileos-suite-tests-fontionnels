package fr.app.web.pages.docdepot;

public interface AccueilDocDepotBeneficiaireInterf {

    void selectDomiciliationPost(String domPost) throws InterruptedException;

    void verifAbsenceChampSaisieAdresse() throws InterruptedException;

    void verifLabelAdresse(String adresse) throws InterruptedException;

    void verifChampSaisieAdresseVide() throws InterruptedException;

    void verifChampSaisieAdresseRens(String adresse) throws InterruptedException;

    void saisirAdresseDomPost(String adresse) throws InterruptedException;

}
