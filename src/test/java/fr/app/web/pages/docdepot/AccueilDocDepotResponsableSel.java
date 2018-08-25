package fr.app.web.pages.docdepot;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    @Override
    public void verifPresenceRespTablActSociaux(String profil) throws InterruptedException {
        Assert.assertTrue(SeleniumUtils.findElement(webDriver,
                By.xpath("//tr/td[6][contains(text(), \"" + profil + "\")]/parent::tr/td[1]")).getText()
                .matches(REGEX_ID_RESP_ACT_SOC));
    }

    @Override
    public void verifPresenceActSociaux(String profil) {
        List<WebElement> ws = webDriver
                .findElements(By.xpath("//tr/td[6][contains(text(), \"" + profil + "\")]/parent::tr/td[1]"));
        for (WebElement w : ws) {
            Assert.assertTrue(w.getText().matches(REGEX_ID_RESP_ACT_SOC));
        }
    }

}