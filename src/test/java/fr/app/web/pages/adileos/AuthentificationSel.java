package fr.app.web.pages.adileos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import fr.app.utils.SeleniumUtils;

public class AuthentificationSel implements AuthentificationInterf {
    private WebDriver webDriver;

    public AuthentificationSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifPageDocDepot() {
        // Vérifier présence logo page d'accueil
        SeleniumUtils.findElement(webDriver, By
                .xpath("//div[@id=\"logo\"]/center/a/img[@src=\"images/logo.png\"][@width=\"200\"][@height=\"150\"]"));
        // Vérifier la présence de titre de la page d'accueil
        SeleniumUtils.findElement(webDriver, By.xpath("//h3[contains(text(),\"La Consigne Numérique Solidaire\")]"));
        SeleniumUtils.findElement(webDriver,
                By.xpath("//p/i/b/font[contains(text(), \"'' Mon essentiel à l'abri en toute confiance '' .\")]"));
    }

    public void verifPageFissa() {
        // Vérifier présence logo page d'accueil
        webDriver.findElement(By
                .xpath("//div[@id=\"logo\"]/center/a/img[@src=\"images/fissa.jpg\"][@width=\"200\"][@height=\"150\"]"));
        // Vérifier la présence de titre de la page d'accueil
        webDriver.findElement(
                By.xpath("//h3[contains(text(),\"Simplifiez le suivi des activités et des bénéficiaires\")]"));
    }

    public void verifPageRappelRdvSms() {
        // Vérifier présence logo page d'accueil
        webDriver.findElement(By
                .xpath("//div[@id=\"logo\"]/center/a/img[@src=\"images/rdv.jpg\"][@width=\"200\"][@height=\"150\"]"));
        // Vérifier la présence de titre de la page d'accueil
        webDriver.findElement(By.xpath("//h3[contains(text(),\"Rappel de rendez-vous par SMS\")]"));
    }

    public void verifPageSuiviBeneficiaire() {
        // Vérifier présence logo page d'accueil
        webDriver.findElement(By
                .xpath("//div[@id=\"logo\"]/center/a/img[@src=\"images/suivi.jpg\"][@width=\"200\"][@height=\"150\"]"));
        // Vérifier la présence de titre de la page d'accueil
        webDriver.findElement(By.xpath("//h3[contains(text(),\"Enrichissez le suivi des bénéficiaires \")]"));
    }

    public void saisirUid(String uid) {
        webDriver.findElement(By.name("id")).clear();
        webDriver.findElement(By.name("id")).sendKeys(uid);
    }

    public void saisirPassword(String password) {
        webDriver.findElement(By.name("pass")).clear();
        webDriver.findElement(By.name("pass")).sendKeys(password);
    }

    public void cliquerSeConnecter() {
        webDriver.findElement(By.xpath("//input[@value='Se connecter']")).click();
    }

    public void verifyErrorMessage(String message) throws InterruptedException {
        String sXpath = "//div[@id=\"msg_erreur\"]/center/font[contains(text(), \"" + message + "\")]";
        webDriver.findElement(By.xpath(sXpath));
    }

    @Override
    public void go(String url) {
        SeleniumUtils.go(webDriver, url);
    }

    public void goLienFissa() {
        String lien = webDriver.findElement(By.xpath("//img[@src=\"images/fissa.jpg\"]/parent::a"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }

    public void goLienRappelRdvSms() {
        String lien = webDriver.findElement(By.xpath("//img[@src=\"images/rdv.jpg\"]/parent::a")).getAttribute("href");
        webDriver.navigate().to(lien);
    }

    public void goLienSuiviBenef() {
        String lien = webDriver.findElement(By.xpath("//img[@src=\"images/suivi.jpg\"]/parent::a"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }

    public void supprimerAttrRequiredChampsIdentifiant() {
        ((JavascriptExecutor) webDriver)
                .executeScript("document.querySelector('input[required][type=text]').removeAttribute('required')");
    }

    public void supprimerAttrRequiredChampsMdp() {
        ((JavascriptExecutor) webDriver)
                .executeScript("document.querySelector('input[required][type=password]').removeAttribute('required')");
    }

    public void verifMsgDeconnexion(String msg) {
        webDriver.findElement(By.xpath("//div[@id=\"msg_dx\"][contains(text(), \"" + msg + "\")]"));
    }

    public void goLienAdileos(String titre) {
        String lien = webDriver.findElement(By.xpath("//a[contains(text(), \"" + titre + "\")]"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }
}