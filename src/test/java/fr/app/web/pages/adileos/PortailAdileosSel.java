package fr.app.web.pages.adileos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import fr.app.utils.SeleniumUtils;

public class PortailAdileosSel implements PortailAdileosInterf {
    private WebDriver webDriver;

    public PortailAdileosSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifPage(String ongletSel) {
        webDriver.findElement(
                By.xpath("//a[@data-link-title=\"" + ongletSel + "\"][contains(text(), \"" + ongletSel + "\")]"));
    }

    public void goBack() {
        SeleniumUtils.goBack(webDriver);
    }
}