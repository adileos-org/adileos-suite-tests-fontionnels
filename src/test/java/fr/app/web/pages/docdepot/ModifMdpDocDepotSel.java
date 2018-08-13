package fr.app.web.pages.docdepot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import fr.app.utils.SeleniumUtils;

public class ModifMdpDocDepotSel implements ModifMdpDocDepotInterf {

    private WebDriver webDriver;

    public ModifMdpDocDepotSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifPage() {
        webDriver.findElement(
                By.xpath("//table/tbody/tr/td/center/div/p[contains(text(), \"Modification de votre mot de passe\")]"));
    }

    public void saisirAncienMdp(String mdp) {
        webDriver.findElement(By.id("pwd1")).sendKeys(mdp);
    }

    public void saisirNouvMdp(String mdp) {
        webDriver.findElement(By.id("pwd2")).sendKeys(mdp);
    }

    public void saisirConfirmMdp(String mdp) {
        webDriver.findElement(By.id("pwd")).sendKeys(mdp);
    }

    public void cliquerBoutonModifier() {
        webDriver.findElement(By.id("changer_mdp")).sendKeys(Keys.ENTER);
    }

    public void verifMsgErreur(String msgErr) throws InterruptedException {
        By by = By.xpath("//div[@id=\"msg_erreur\"]/center/font[contains(text(), \"" + msgErr + "\")]");
        SeleniumUtils.findElement(webDriver, by);
    }

    public void goLienRetourPageAccueil() {
        String lien = webDriver
                .findElement(By.xpath("//a[@id=\"accueil\"][contains(text(), \"Retour à la page d'accueil.\")]"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }

    public void verifMsgSucces(String msgSucces) throws InterruptedException {
        By by = By.xpath("//div[@id=\"msg_ok\"]/center[contains(text(), \"" + msgSucces + "\")]");
        SeleniumUtils.findElement(webDriver, by);
    }
}