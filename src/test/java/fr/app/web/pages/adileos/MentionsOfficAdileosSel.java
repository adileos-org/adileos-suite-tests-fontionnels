package fr.app.web.pages.adileos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import fr.app.utils.SeleniumUtils;

public class MentionsOfficAdileosSel implements MentionsOfficAdileosInterf {
    private WebDriver webDriver;

    public MentionsOfficAdileosSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifPageTitre(String titre) {
        webDriver.findElement(By.xpath("//h2[contains(text(), \"" + titre + "\")]"));
    }

    public void goLienDocDepot() {
        String lien = webDriver.findElement(By.xpath("//img[@src=\"images/logo.png\"]/parent::a")).getAttribute("href");
        webDriver.navigate().to(lien);
    }

    public void goBack() {
        SeleniumUtils.goBack(webDriver);
    }
}