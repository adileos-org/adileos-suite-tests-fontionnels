package fr.app.utils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import fr.app.web.steps.ihm.TestProperties;

public class SeleniumUtils {
    private static final Logger LOG = Logger.getLogger(SeleniumUtils.class.getName());

    public static final int PAS_ATTENTE = 1;
    public static final int ATTENTE_1_SEC = 1000;
    public static final int ATTENTE_2_SEC = 2000;
    public static final int ATTENTE_5_SEC = 5000;
    public static final int ATTENTE_10_SEC = 10000;
    public static final int ATTENTE_20_SEC = 20000;

    public static String getTitle1(WebDriver webDriver, int attente) {
        String titrePage = webDriver.getTitle();
        if (Utilitaires.estVide(titrePage) && attente != PAS_ATTENTE) {
            try {
                Thread.sleep(attente);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String title = webDriver.getTitle();
        // LOG.info("title =<" + title +">");
        return title;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static String getTitle(final WebDriver webDriver, int attente) {

        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
                .pollingEvery(1, java.util.concurrent.TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        wait.until(new ExpectedCondition() {
            public Boolean apply(Object webDriver) {
                String titleTmp = ((WebDriver) webDriver).getTitle();
                return new Boolean(Utilitaires.estNonVide(titleTmp));
            }
        });

        /*
         * (new WebDriverWait(webDriver, attente)).until( new ExpectedCondition() { public Boolean apply(Object
         * webDriver) { String titleTmp = ((WebDriver)webDriver).getTitle(); return new
         * Boolean(Utilitaires.estNonVide(titleTmp)); } } );
         */
        String title = webDriver.getTitle();
        // if (LOG.isDebugEnabled()) {
        // LOG.debug("title = " + title);
        // }
        return title;

    }

    public static String waitAndGetTitle(final WebDriver webDriver, final int attente, final String stringToWait) {

        final long debut = System.currentTimeMillis();
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(attente, java.util.concurrent.TimeUnit.SECONDS)
                .pollingEvery(500, java.util.concurrent.TimeUnit.MILLISECONDS); // .ignoring(NoSuchElementException.class);

        wait.until(new ExpectedCondition() {
            public Boolean apply(Object webDriver) {
                String titleTmp = ((WebDriver) webDriver).getTitle();
                long fin = System.currentTimeMillis();
                // LOG.info("fin - debut =" + (fin - debut));
                if ((fin - debut) >= (attente)) {
                    // LOG.info("Return Boolean.TRUE");
                    return Boolean.TRUE;
                }
                return new Boolean(Utilitaires.containsTrimIgnoreCase(titleTmp, stringToWait));
            }
        });

        String title = webDriver.getTitle();
        // LOG.info("title = " + title);
        return title;

    }

    public static String waitAndGetTextWebElementVisibleByXpath(final WebDriver webDriver, final int attente,
            final String stringToWait, final String sXpath) {

        final long debut = System.currentTimeMillis();
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(attente, java.util.concurrent.TimeUnit.SECONDS)
                .pollingEvery(500, java.util.concurrent.TimeUnit.MILLISECONDS); // .ignoring(NoSuchElementException.class);

        wait.until(new ExpectedCondition() {
            public Boolean apply(Object webDriver) {
                WebDriver wd = (WebDriver) webDriver;
                WebElement we = wd.findElement(By.xpath(sXpath));
                // recherche d'un element visible uniquement
                if (!we.isDisplayed()) {
                    return Boolean.FALSE;
                }
                String texteTmp = we.getText();
                long fin = System.currentTimeMillis();
                // LOG.info("fin - debut =" + (fin - debut));
                if ((fin - debut) >= (attente)) {
                    // LOG.info("Return Boolean.TRUE");
                    return Boolean.TRUE;
                }
                return new Boolean(Utilitaires.containsTrimIgnoreCase(texteTmp, stringToWait));
            }
        });

        String texte = webDriver.findElement(By.xpath(sXpath)).getText();
        // if (LOG.isDebugEnabled()) {
        // LOG.debug("texte = " + texte);
        // }
        LOG.info("texte = " + texte);
        return texte;

    }

    public static WebElement waitWebElementVisibleByXpath(final WebDriver webDriver, final int attente,
            final String sXpath) {

        WebElement returnElt = (new WebDriverWait(webDriver, attente)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                WebElement elt = d.findElement(By.xpath(sXpath));
                if (elt.isDisplayed()) {
                    return elt;
                } else {
                    return null;
                }
            }
        });

        return returnElt;
    }

    public static void go(WebDriver webDriver, String url) {
        if (url.startsWith("http") || url.startsWith("HTTP")) {
            LOG.info("url indiquee dans le step (commence par http)");
            webDriver.get(url);
        } else if (TestProperties.isInitialized()) {
            webDriver.get(TestProperties.getInstance().getUrl());
        } else if (url.startsWith("env:") || url.startsWith("ENV:")) {
            LOG.info("recherche de l'url par variable d'environnement (ENV:PARAM)");
            // like env:HOME_SITE or ENV:ACCUEIL_HOME
            String sParam = url.substring(4);

            LOG.info("sParam = " + sParam);
            String urlEnv = Utilitaires.getConfigurationProperty(sParam, sParam, "localhost");

            org.junit.Assert.assertNotNull(urlEnv);
            LOG.info("urlEnv = " + urlEnv);
            webDriver.get(urlEnv);
        } else {
            org.junit.Assert.fail(
                    "l'url n'est pas de type http ou ENV:URL_HOME avec la variable apres le env: declare en variable d'environnement avec mv -DURL_HOME=http://site_integ/page ");
        }
    }

    public static void goBack(WebDriver webDriver) {
        webDriver.navigate().back();
    }

    public static WebElement findElementWithTimeout(WebDriver webDriver, final By locator, int timeout,
            int checkTime) {
        WebElement w = SeleniumUtils.getElementByGraduallyWait(webDriver, locator, timeout, checkTime);
        if (w == null) {
            throw new NoSuchElementException("Not found : " + locator.toString());
        }
        return w;
    }

    public static WebElement findElement(WebDriver webDriver, final By locator) throws InterruptedException {
        if (webDriver.findElements(locator).size() == 0) {
            Thread.sleep(5000);
        }
        return findElementWithTimeout(webDriver, locator, 20, 5);
    }

    public static WebElement getElementByGraduallyWait(WebDriver webDriver, final By locator, int timeout,
            int checkTime) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver).withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(checkTime,
                        TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }
}