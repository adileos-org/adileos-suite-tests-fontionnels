package fr.app.web.steps;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import fr.app.utils.Constantes;
import fr.app.utils.video.LanceCmdLongue;
import fr.app.utils.video.VideoUtils;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "html:D:/cucumber-html" }, features = "src/test/resources/fr/app/web/steps")

public class AppTest {
    private static Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * BeforeClass est appelé avant lancer le test On lit le fichier de constantes et on démarre Videolan si on veut des
     * vidéos
     *
     * @throws ParserConfigurationException
     */
    @BeforeClass
    public static void setUpClass() throws ParserConfigurationException {

        System.out.println("Avant Constantes.initialiseEnv");
        Constantes.initialiseEnv();

        System.out.println("Après Constantes.initialiseEnv");
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);

        LOG.info("Debut setUpClass dans log4j");
        System.out.println("Master setUpClass");

        if (Constantes.startRecordVideo) {
            System.out.println("Lance VLC");

            LanceCmdLongue cmdLongue = new LanceCmdLongue();
            cmdLongue.init(Constantes.launchVideoShell, Constantes.pathVlcExe, Constantes.fileVideoOut);

            // On créer notre thread avec notre tache à executer
            Thread t = new Thread(cmdLongue);
            // On lance le thread
            t.start();
        }

    }

    /**
     * AfterClass est appelé à la fin du test On arrete Videolan s'il avait démarré
     *
     * @throws IOException
     */
    @AfterClass
    public static void tearDownClass() throws IOException {
        System.out.println("Master tearDown");
        if (Constantes.startRecordVideo) {
            System.out.println("Arret de VLC");
            VideoUtils.quit();
        }
    }

}
