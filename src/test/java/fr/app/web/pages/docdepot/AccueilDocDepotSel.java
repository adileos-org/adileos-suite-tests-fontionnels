package fr.app.web.pages.docdepot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fr.app.utils.SeleniumUtils;

public class AccueilDocDepotSel implements AccueilDocDepotInterf {

    private WebDriver webDriver;

    public AccueilDocDepotSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifPage(String msgTypeActeur) {
        webDriver.findElement(By.xpath("//table/tbody/tr/td/b[contains(text(), \"" + msgTypeActeur + "\")]"));
    }

    public void goLienModifMdp() {
        String lien = webDriver
                .findElement(By
                        .xpath("//ul/li/a[contains(text(), \"Déconnexion\")]/parent::li/ul/li/a[contains(text(), \"Modification mot de passe\")]"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }

    public void changeCoordonnee(String nouvVal, String libelle, String inputName) throws InterruptedException {
        WebElement w = SeleniumUtils
                .findElement(webDriver,
                        By.xpath("//td[text()=\"" + libelle + "\"]/input[@name=\"" + inputName + "\"]"));
        w.sendKeys(Keys.chord(Keys.CONTROL, "a"), nouvVal, Keys.ENTER);
    }

    public void verifSaisie(String saisie, String libelle, String inputName) throws InterruptedException {
        Assert.assertTrue(SeleniumUtils
                .findElement(webDriver, By.xpath("//td[text()=\"" + libelle + "\"]/input[@name=\"" + inputName + "\"]"))
                .getAttribute("value")
                .equals(saisie));
    }

    public void verifMsgErreur(String msgErr) throws InterruptedException {
        SeleniumUtils
                .findElement(webDriver,
                        By.xpath("//div[@id=\"msg_erreur\"]/center/font[contains(text(), \"" + msgErr + "\")]"));
    }

    public void verifMsgSucces(String msg) throws InterruptedException {
        SeleniumUtils.findElement(webDriver,
                By.xpath("//div[@id=\"msg_ok\"]/center[contains(text(), \"" + msg + "\")]"));
    }

    public void deconnexion() {
        String lien = webDriver.findElement(By.xpath("//ul/li/a[contains(text(), \"Déconnexion\")]"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }
}