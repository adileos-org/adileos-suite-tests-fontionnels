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
}