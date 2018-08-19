package fr.app.web.steps.ihm;

import java.util.Objects;

public class TestProperties {
    private final String url;
    private final String pathBrowser;

    private static TestProperties instance;

    private TestProperties(String url, String pathBrowser) {
        this.url = url;
        this.pathBrowser = pathBrowser;
    }

    public static TestProperties createTestProperties(String url, String pathBrowser) {
        Objects.requireNonNull(url);
        Objects.requireNonNull(pathBrowser);
        instance = new TestProperties(url, pathBrowser);
        return instance;
    }

    public static TestProperties getInstance() {
        return instance;
    }

    public static boolean isInitialized() {
        return (instance != null);
    }

    public String getUrl() {
        return url;
    }

    public String getPathBrowser() {
        return pathBrowser;
    }
}
