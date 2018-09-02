package fr.app.web.pages.docdepot;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import fr.app.utils.SeleniumUtils;

public class AccueilDocDepotResponsableSel implements AccueilDocDepotResponsableInterf {

    private WebDriver webDriver;

    private static final String REGEX_ID_RESP_ACT_SOC = "^[A-Z]{1,} \\(Identifiant='[A-Za-z0-9_]*'\\)$";

    public AccueilDocDepotResponsableSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void verifPage(String profil) throws InterruptedException {
        Assert.assertTrue(SeleniumUtils.findElement(webDriver, By.xpath("//select[@name=\"profil\"]/option[@selected]"))
                .getText().equals(profil));
    }

    private static By getXPathIdentifiantActeurSocial(String profil) {
        return By.xpath("//tr/td[6][contains(text(), \"" + profil + "\")]/parent::tr/td[1]");
    }

    private static By getXPathInfoActeurSocial(String nom, String prenom, String tel, String mail) {
        return By.xpath("//tr/td[1][text()=\" " + nom
                + " (compte non finalisé: \"]/parent::tr/td[2][contains(text(), \"" + prenom
                + "\")]/parent::tr/td[3]/form[contains(text(), \"" + tel
                + "\")]/parent::td/parent::tr/td[4]/form[contains(text(), \"" + mail + "\")]");
    }

    @Override
    public void verifPresenceRespTablActSociaux(String profil) throws InterruptedException {
        Assert.assertTrue(SeleniumUtils.findElement(webDriver,
                getXPathIdentifiantActeurSocial(profil)).getText()
                .matches(REGEX_ID_RESP_ACT_SOC));
    }

    @Override
    public void verifPresenceActSociaux(String profil) {
        List<WebElement> ws = webDriver
                .findElements(getXPathIdentifiantActeurSocial(profil));
        for (WebElement w : ws) {
            Assert.assertTrue(w.getText().matches(REGEX_ID_RESP_ACT_SOC));
        }
    }

    @Override
    public void cliquerBoutonSection(String libelleBouton) throws InterruptedException {
        String lien = SeleniumUtils.findElement(webDriver, By.xpath("//a[contains(text(), \"" + libelleBouton + "\")]"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }

    @Override
    public void saisirInfoActeurSocial(String inputName, String valeur) throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath("//input[@name=\"" + inputName + "\"]"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), valeur);
    }

    @Override
    public void cliquerBoutonAjouterActeurSocial() throws InterruptedException {
        SeleniumUtils.findElement(webDriver, By.id("nouveau_user")).click();
    }

    @Override
    public void cliquerBoutonModifierActeurSocial(String nom, String prenom) throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath("//tr/td[1][text()=\" " + nom
                        + " (compte non finalisé: \"]/parent::tr/td[2][contains(text(), \"" + prenom
                        + "\")]/parent::tr/td[8]/form"))
                .submit();
    }

    @Override
    public void cliquerBoutonSupprimerActeurSocial(String nom, String prenom) throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath("//tr/td[1][text()=\" " + nom
                        + " (compte non finalisé: \"]/parent::tr/td[2][contains(text(), \"" + prenom
                        + "\")]/parent::tr/td[7]/form"))
                .submit();
    }

    @Override
    public void cliquerBoutonConfirmerModificationActeurSocial() throws InterruptedException {
        SeleniumUtils.findElement(webDriver, By.id("modif_user")).click();
    }

    @Override
    public void cliquerBoutonConfirmerSuppressionActeurSocial() throws InterruptedException {
        SeleniumUtils.findElement(webDriver, By.xpath("//tr/td[7]/form")).submit();
    }

    @Override
    public void verifInfoActeurSocial(String nom, String prenom, String tel, String mail) throws InterruptedException {
        SeleniumUtils.findElement(webDriver, getXPathInfoActeurSocial(nom, prenom, tel, mail));
    }

    @Override
    public void verifAbsenceActeurSocial(String nom, String prenom, String tel, String mail)
            throws InterruptedException {
        Assert.assertTrue(webDriver.findElements(getXPathInfoActeurSocial(nom, prenom, tel, mail)).size() == 0);
    }

    @Override
    public void selectionnerProfil(String profil) throws InterruptedException {
        new Select(SeleniumUtils.findElement(webDriver, By.xpath("//select[@name=\"profil\"]")))
                .selectByVisibleText(profil);
    }

    @Override
    public void verifierPresenceActeurSocial(String nom, String identifiant, String prenom)
            throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath("//tr/td[1][text()=\" " + nom + "  (Identifiant='" + identifiant
                        + "')   \"]/parent::tr/td[2][contains(text(), \"" + prenom + "\")]"));
    }

}