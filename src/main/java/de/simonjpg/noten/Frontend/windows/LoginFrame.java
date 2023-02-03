package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Security.SHA256;
import de.simonjpg.noten.Backend.Repository.User;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.JLayeredPane.*;

/**
 * Class LoginFrame
 *
 * <p>
 *     JFrame to login.
 *     Created with NetBeans IDE 15.
 * </p>
 * @version 1.0
 * @since 28.1.2023
 * @author SimonJpg
 * @see JFrame
 */
public class LoginFrame extends JFrame {
    private final JButton jButton1;
    private final JButton jButton2;
    private final JButton jButton3;
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel5;
    private final JLabel jLabel6;
    private final JLabel jLabel7;
    private final JLayeredPane jLayeredPane1;
    private final JPanel jPanel1;
    private final JPasswordField jPasswordField1;
    private final JTextField username;
    private final FrontendController frontendController;
    private final RegisterFrame registerFrame;


    public LoginFrame(FrontendController frontendController, RegisterFrame registerFrame) {
        this.frontendController = frontendController;
        this.registerFrame = registerFrame;
        jLayeredPane1 = new JLayeredPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jLabel7 = new JLabel();
        jButton3 = new JButton();
        jLabel4 = new JLabel();
        username = new JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton2 = new JButton();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new Color(41, 129, 186));

        jPanel1.setBackground(new Color(41, 129, 186));

        jLabel1.setFont(new Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Sign in Notenübersicht");

        jLabel2.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Du hast noch keinen Account?");
        jLabel2.setToolTipText("Du brauchst einen Account, um das Programm zu benutzen");

        jLabel3.setFont(new Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Jetzt registrieren");

        jButton1.setBackground(new Color(41, 129, 186));
        jButton1.setFont(new Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setText("Sign up");
        jButton1.setToolTipText("Wechsel zum Registrieren");
        jButton1.addActionListener(this::signUp);

        jLabel7.setFont(new Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Du hast deinen Benutzernamen oder dein Passwort vergessen?");

        jButton3.setBackground(new Color(41, 129, 186));
        jButton3.setFont(new Font("Arial", 0, 12)); // NOI18N
        jButton3.setText("Send Email");
        jButton3.addActionListener(this::sendVerificationMail);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addGroup(jPanel1Layout.createParallelGroup(TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jButton1, PREFERRED_SIZE, 223, PREFERRED_SIZE))
                                                .addGap(0, 0, MAX_VALUE))
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(23, MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                                        .addComponent(jLabel7, PREFERRED_SIZE, 365, PREFERRED_SIZE)
                                                        .addComponent(jButton3, PREFERRED_SIZE, 350, PREFERRED_SIZE))))
                                .addContainerGap())
                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, PREFERRED_SIZE, 90, PREFERRED_SIZE)
                                                .addGap(149, 149, 149))
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, PREFERRED_SIZE, 223, PREFERRED_SIZE)
                                                .addGap(69, 69, 69))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1, PREFERRED_SIZE, 50, PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel7, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addContainerGap(62, MAX_VALUE))
        );

        jLabel4.setFont(new Font("Arial Black", 1, 24)); // NOI18N
        jLabel4.setText("Anmelden");

        username.setFont(new Font("Arial", 0, 14)); // NOI18N
        username.setToolTipText("Dein Benutzername");

        jLabel5.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Benutzername");

        jLabel6.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Passwort");

        jPasswordField1.setToolTipText("Dein Passwort");

        jButton2.setFont(new Font("Arial Black", 1, 18)); // NOI18N
        jButton2.setText("Login");
        jButton2.setToolTipText("Zum Bestätigen drücken");
        jButton2.addActionListener(this::login);

        jLayeredPane1.setLayer(jPanel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, DEFAULT_LAYER);
        jLayeredPane1.setLayer(username, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addComponent(jLabel5, PREFERRED_SIZE, 155, PREFERRED_SIZE)
                                        .addComponent(jPasswordField1, PREFERRED_SIZE, 300, PREFERRED_SIZE)
                                        .addComponent(jLabel6, PREFERRED_SIZE, 90, PREFERRED_SIZE)
                                        .addGroup(TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                                .addComponent(username, PREFERRED_SIZE, 300, PREFERRED_SIZE)
                                                .addGap(196, 196, 196))))
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(228, 228, 228)
                                                .addComponent(jButton2, PREFERRED_SIZE, 223, PREFERRED_SIZE))
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(264, 264, 264)
                                                .addComponent(jLabel4, PREFERRED_SIZE, 150, PREFERRED_SIZE)))
                                .addContainerGap(235, MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4, PREFERRED_SIZE, 50, PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel5, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(username, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE))
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(jLayeredPane1)
        );

        pack();
        setLocationRelativeTo(null);
        setTitle("Login Notenübersicht");
    }

    /**
     * Method signUp.
     *
     * <p>
     *     Used by JButton, changes current frame to RegisterFrame.
     * </p>
     * @param e ActionEvent of JButton.
     */

    private void signUp(ActionEvent e) {
        if (e.getSource() != jButton1) {
            return;
        }
        setVisible(false);
        registerFrame.setVisible(true);
    }

    /**
     * Method login.
     *
     * <p>
     *     Used by JButton, handles login process.
     * </p>
     * @param e ActionEvent of JButton.
     */

    private void login(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }
        List<User> users = frontendController.getLoginControllerImplementation().select();
        for (User user : users) {
            if (user.getUsername().equals(username.getText())) {
                if (user.getPassword().equals(new SHA256().hash(new String(jPasswordField1.getPassword())))) {
                    setVisible(false);
                    new DataFrame(frontendController).setVisible(true);
                    return;
                }
            }
        }
        username.setText("Login fehlgeschlagen.");
    }

    /**
     * Method sendVerificationMail.
     *
     * <p>
     *     This method opens the JFrame VerificationFrame.
     * </p>
     *
     * @param e ActionEvent triggered by the JButton.
     */
    private void sendVerificationMail(ActionEvent e) {
        if (e.getSource() != jButton3) {
            return;
        }

        new VerificationFrame(frontendController).setVisible(true);
    }
}
