package fr.app.web.steps.ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.runner.JUnitCore;

import fr.app.utils.Constantes;

public class TestLauncherIHM extends JFrame {
    private JTextField textFieldUrlTarget;

    public TestLauncherIHM() {
        setTitle("Tests de Non Régression");
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblUrlCible = new JLabel("URL cible");
        panel_1.add(lblUrlCible);
        lblUrlCible.setFont(new Font("Arial", Font.PLAIN, 16));

        textFieldUrlTarget = new JTextField();
        textFieldUrlTarget.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_1.add(textFieldUrlTarget);
        textFieldUrlTarget.setColumns(20);

        JPanel panel_2 = new JPanel();
        getContentPane().add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnLancerLesTests = new JButton("Lancer les tests");
        btnLancerLesTests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldUrlTarget.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Le champ \"URL cible\" doit être renseigné\npar l'url de l'application ciblée par les tests",
                            "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                TestLauncherIHM.this.setVisible(false);
                TestProperties.createTestProperties(textFieldUrlTarget.getText(), Constantes.DEFAULT_PATH_BROWSER);
                JUnitCore.main("fr.app.web.steps.AppTest");
            }
        });
        btnLancerLesTests.setFont(new Font("Arial", Font.PLAIN, 30));
        panel_2.add(btnLancerLesTests);
    }

    public static void main(String[] args) {
        TestLauncherIHM ihm = new TestLauncherIHM();
        ihm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ihm.pack();
        ihm.setResizable(false);
        ihm.setVisible(true);
    }
}
