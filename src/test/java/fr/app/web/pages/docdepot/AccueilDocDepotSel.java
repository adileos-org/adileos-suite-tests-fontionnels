package fr.app.web.pages.docdepot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void deconnexion() {
        String lien = webDriver.findElement(By.xpath("//ul/li/a[contains(text(), \"Déconnexion\")]"))
                .getAttribute("href");
        webDriver.navigate().to(lien);
    }
}