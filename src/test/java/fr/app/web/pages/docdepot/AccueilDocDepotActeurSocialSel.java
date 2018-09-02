package fr.app.web.pages.docdepot;

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
                "//tr/td[2][contains(text(), \"" + nom + "\")]/parent::tr/td[3][contains(text(), \"" + prenom
                        + "\")]"));
    }
}