package fr.app.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilitaires {

    public static boolean containsTrimIgnoreCase(String toTrim, String toCompare) {
        String inter = StringUtils.trimToEmpty(toTrim);
        return StringUtils.containsIgnoreCase(inter, toCompare);
    }

    /**
     * Cette methode retourne faux si la chaine passee en parametre est vide, vrai sinon.
     *
     * @param string
     *            la chaine que l'on veut tester
     * @return true si elle n'est pas null ni vide ni remplis de blancs, false sinon
     */
    public static boolean estNonVide(String string) {
        if (string != null && !(string.trim()).equals("")) {
            return true;
        } else
            return false;
    }

    /**
     * Cette methode retourne faux si la chaine passee en parametre est vide, vrai sinon.
     *
     * @param string
     *            La chaine que l'on veut tester
     * @return true si la chaine est null, vide ou bien remplis de blancs, false sinon
     */
    public static boolean estVide(String string) {
        if (string == null) {
            return true;
        }
        if ((string.trim()).equals("")) {
            return true;
        }
        return false;
    }

    public static String getConfigurationProperty(
            String envKey, String sysKey, String defValue) {
        String retValue = defValue;
        String envValue = System.getenv(envKey);
        String sysValue = System.getProperty(sysKey);
        // system property prevails over environment variable
        if (sysValue != null) {
            retValue = sysValue;
        } else if (envValue != null) {
            retValue = envValue;
        }
        return retValue;
    }

    public static String mois2ChiffresEnLettre(String sMois) {
        String retour;
        if (sMois.length() == 1) {
            sMois += "0" + sMois;
        }

        switch (sMois) {
        case "01":
            retour = "janvier";
            break;
        case "02":
            retour = "février";
            break;
        case "03":
            retour = "mars";
            break;
        case "04":
            retour = "avril";
            break;
        case "05":
            retour = "mai";
            break;
        case "06":
            retour = "juin";
            break;
        case "07":
            retour = "juillet";
            break;
        case "08":
            retour = "août";
            break;
        case "09":
            retour = "septembre";
            break;
        case "10":
            retour = "octobre";
            break;
        case "11":
            retour = "novembre";
            break;
        case "12":
            retour = "décembre";
            break;
        default:
            retour = "Janvier";
        }
        return retour;
    }

    public static String getBackgroundColorElement(WebElement w) {
        return w.getCssValue("background-color");
    }

    public static boolean checkFormatAmount(String amount, boolean checkEuros, boolean checkSepThousands) {
        if (amount.contains("- ")) {
            amount = amount.substring(2);
        } else if (amount.contains("-")) {
            amount = amount.substring(1);
        }
        if (checkSepThousands && amount.indexOf(",") > 3) {
            return amount.matches(getStringRegexFormattedAmountThousand());
        } else if (checkEuros) {
            return amount.matches(getStringRegexFormattedAmountFollowEuros());
        } else {
            return amount.matches(getStringRegexFormattedAmount());
        }
    }

    public static String getStringRegexFormattedAmount() {
        return "^[0-9]+,[0-9]{2}$";
    }

    public static String getStringRegexFormattedAmountFollowEuros() {
        return "^[0-9]+,[0-9]{2} €$";
    }

    public static String getStringRegexFormattedAmountThousand() {
        return "^[0-9]+ [0-9]{3},[0-9]{2}$";
    }

    public static String getStringRegexDate() {
        return "^[0-9]{2}/[0-9]{4}$";
    }

    public static void cliqueExt(WebDriver webDriver) {
        webDriver.findElement(By.cssSelector("body")).click();
    }
}
