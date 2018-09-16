package fr.app.web.pages.docdepot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import fr.app.utils.SeleniumUtils;

public class AccueilDocDepotBeneficiaireSel implements AccueilDocDepotBeneficiaireInterf {

    private WebDriver webDriver;

    public AccueilDocDepotBeneficiaireSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void selectDomiciliationPost(String domPost) throws InterruptedException {
        new Select(SeleniumUtils.findElement(webDriver, By.id("organisme")))
                .selectByVisibleText(domPost);
    }

    @Override
    public void verifLabelAdresse(String adresse) throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath("//tr/td[text()=\"Adresse :\"]/parent::tr/td[2][contains(text(), \"" + adresse + "\")]"));
    }

    @Override
    public void verifChampSaisieAdresseVide() throws InterruptedException {
        Assert.assertTrue(SeleniumUtils.findElement(webDriver,
                By.id("ReversBE")).getAttribute("value").isEmpty());
    }

    @Override
    public void verifAbsenceChampSaisieAdresse() throws InterruptedException {
        Assert.assertTrue(
                webDriver.findElements(By.id("ReversBE")).isEmpty());
    }

    @Override
    public void verifChampSaisieAdresseRens(String adresse) throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath("//tr/td[text()=\"Adresse :\"]/parent::tr/td[2]/input[@id=\"ReversBE\"][@value=\"" + adresse
                        + "\"]"));
    }

    @Override
    public void saisirAdresseDomPost(String adresse) throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath("//tr/td[text()=\"Adresse :\"]/parent::tr/td[2]/input[@id=\"ReversBE\"]"))
                .sendKeys(adresse, Keys.ENTER);
    }

    @Override
    public void cliquerBoutonReferentsConfiance() throws InterruptedException {
        String lien = SeleniumUtils
                .findElement(webDriver, By.xpath("//a[contains(text(), \"+ Référents de confiance\")]"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }

    @Override
    public void selectStructSociale(String structSociale) throws InterruptedException {
        new Select(SeleniumUtils.findElement(webDriver, By.id("organisme")))
                .selectByVisibleText(structSociale);
    }

    @Override
    public void selectActeurSocial(String actSocial) throws InterruptedException {
        new Select(SeleniumUtils.findElement(webDriver, By.xpath("//select[@name=\"nom\"]")))
                .selectByVisibleText(actSocial);
    }

    private static By getXPathChampSaisieRefConfiance(String attrName) {
        return By.xpath("//input[@name=\"" + attrName + "\"]");
    }

    @Override
    public void saisirNomRefConfiance(String nom, String attrName) throws InterruptedException {
        SeleniumUtils.findElement(webDriver, getXPathChampSaisieRefConfiance(attrName)).sendKeys(nom);
    }

    @Override
    public void saisirPrenomRefConfiance(String prenom, String attrName) throws InterruptedException {
        SeleniumUtils.findElement(webDriver, getXPathChampSaisieRefConfiance(attrName)).sendKeys(prenom);
    }

    @Override
    public void cliquerBoutonAjouterRefConfiance() throws InterruptedException {
        SeleniumUtils.findElement(webDriver, By.id("nouveau_referent")).click();
    }

    private static String getStrXPathNouvRefConfiance(String structSociale, String nom, String prenom) {
        return "//tr/td[1][contains(text(), \"" + structSociale + "\")]/parent::tr/td[2][contains(text(), \""
                + nom + "\")]/parent::tr/td[3][contains(text(), \"" + prenom + "\")]";
    }

    @Override
    public void cliquerBoutonSupprimerRefConfiance(String structSociale, String nom, String prenom)
            throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath(getStrXPathNouvRefConfiance(structSociale, nom, prenom) + "/parent::tr/td[7]/form"))
                .submit();
    }

    @Override
    public void cliquerBoutonConfirmation() throws InterruptedException {
        SeleniumUtils.findElement(webDriver, By.xpath("//tr/td[7]/form")).submit();
    }

    @Override
    public void verifPresenceNouvRefConfiance(String structSociale, String nom, String prenom, String adresse)
            throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath(getStrXPathNouvRefConfiance(structSociale, nom, prenom)
                        + "/parent::tr/td[6][contains(text(), \"" + adresse + "\")]"));
    }

    @Override
    public void verifPresenceNouvRefConfiance(String structSociale, String nom, String prenom)
            throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath(getStrXPathNouvRefConfiance(structSociale, nom, prenom)));
    }

    @Override
    public void verifAbsenceRefConfiance(String structSociale, String nom, String prenom, String adresse) {
        Assert.assertTrue(webDriver.findElements(By.xpath(getStrXPathNouvRefConfiance(structSociale, nom, prenom)
                + "/parent::tr/td[6][contains(text(), \"" + adresse + "\")]")).isEmpty());
    }

    @Override
    public void verifAbsenceRefConfiance(String structSociale, String nom, String prenom) {
        Assert.assertTrue(
                webDriver.findElements(By.xpath(getStrXPathNouvRefConfiance(structSociale, nom, prenom))).isEmpty());
    }
}