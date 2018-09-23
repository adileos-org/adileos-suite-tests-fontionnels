package fr.app.web.pages.docdepot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import fr.app.utils.SeleniumUtils;

public class AccueilDocDepotActeurSocialSel implements AccueilDocDepotActeurSocialInterf {

    private WebDriver webDriver;

    public AccueilDocDepotActeurSocialSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void verifierPresenceBeneficiaire(String nom, String prenom) throws InterruptedException {
        SeleniumUtils.findElement(webDriver, By.xpath(
                getStrXpathBeneficiaire(nom, prenom)));
    }

    private static String getStrXpathBeneficiaire(String nom, String prenom) {
        return "//tr/td[2][contains(text(), \"" + nom + "\")]/parent::tr/td[3][contains(text(), \"" + prenom
                + "\")]";
    }

    @Override
    public void cliquerBoutonVoirDetailBenef(String nom, String prenom) throws InterruptedException {
        SeleniumUtils.findElement(webDriver, By.xpath(getStrXpathBeneficiaire(nom, prenom) + "/parent::tr/td[1]/form"))
                .submit();
    }

    @Override
    public void verifierPresenceBoutonSupprDocument(String nomFichier) throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath(AccueilDocDepotBeneficiaireSel.getStrXPathDocDepose(nomFichier, true)
                        + "/input[@title=\"Supprimer\"]"));
    }

    @Override
    public void verifierAbsenceBoutonSupprDocument(String nomFichier) throws InterruptedException {
        Assert.assertTrue(
                webDriver.findElements(By.xpath(AccueilDocDepotBeneficiaireSel.getStrXPathDocDepose(nomFichier, true)
                        + "/input[@title=\"Supprimer\"]")).isEmpty());
    }
}