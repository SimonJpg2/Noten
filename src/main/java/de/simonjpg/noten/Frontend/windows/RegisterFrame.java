package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Repository.User;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.JLayeredPane.*;

/**
 * Class RegisterFrame.
 *
 * <p>
 *     JFrame to create new account.
 *     Created with NetBeans IDE 15.
 * </p>
 * @since 28.1.2023
 * @version 1.0
 * @author SimonJpg
 * @see JFrame
 */
public class RegisterFrame extends JFrame {
    private final JButton jButton1;
    private final JButton jButton2;
    private final JLabel jLabel1;
    private final JLabel jLabel10;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel5;
    private final JLabel jLabel6;
    private final JLabel jLabel7;
    private final JLabel jLabel8;
    private final JLabel jLabel9;
    private final JLayeredPane jLayeredPane1;
    private final JPanel jPanel1;
    private final JPasswordField jPasswordField2;
    private final JPasswordField jPasswordField3;
    private final JTextField jTextField1;
    private final JTextField username;
    private final FrontendController frontendController;
    private LoginFrame loginFrame;

    public RegisterFrame(FrontendController frontendController) {
        this.frontendController = frontendController;
        jLayeredPane1 = new JLayeredPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jLabel4 = new JLabel();
        username = new JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jPasswordField2 = new JPasswordField();
        jButton2 = new JButton();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jPasswordField3 = new JPasswordField();
        jTextField1 = new JTextField();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new Color(41, 129, 186));

        jPanel1.setBackground(new Color(41, 129, 186));

        jLabel1.setFont(new Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Login Notenübersicht");

        jLabel2.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Du hast bereits einen Account?");
        jLabel2.setToolTipText("Du benötigst einen Account, um das Programm zu verwenden");

        jLabel3.setFont(new Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Jetzt anmelden");

        jButton1.setBackground(new Color(41, 129, 186));
        jButton1.setFont(new Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.setToolTipText("Wechsel zum Login");
        jButton1.addActionListener(this::login);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel1)
                                .addContainerGap(82, MAX_VALUE))
                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE)
                                .addComponent(jLabel3, PREFERRED_SIZE, 90, PREFERRED_SIZE)
                                .addGap(137, 137, 137))
                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, PREFERRED_SIZE, 223, PREFERRED_SIZE)
                                                .addGap(57, 57, 57))
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1, PREFERRED_SIZE, 223, PREFERRED_SIZE)
                                                .addGap(68, 68, 68))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1, PREFERRED_SIZE, 50, PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton1, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addContainerGap(179, MAX_VALUE))
        );

        jLabel4.setFont(new Font("Arial Black", 1, 24)); // NOI18N
        jLabel4.setText("Registrieren");

        username.setFont(new Font("Arial", 0, 14)); // NOI18N
        username.setToolTipText("Benutzername für deinen Account");

        jLabel5.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Benutzername");

        jLabel6.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Email adresse");

        jLabel7.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Passwort");

        jPasswordField2.setToolTipText("Wähle ein starkes Passwort");

        jButton2.setFont(new Font("Arial Black", 1, 18)); // NOI18N
        jButton2.setText("Sign up");
        jButton2.setToolTipText("Zum Bestätigen drücken");
        jButton2.addActionListener(this::signUp);

        jLabel8.setFont(new Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("schwach");

        jLabel9.setFont(new Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("schwach");

        jLabel10.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Passwort wiederholen");

        jPasswordField3.setToolTipText("Wähle ein starkes Passwort");

        jTextField1.setFont(new Font("Arial", 0, 14)); // NOI18N

        jLayeredPane1.setLayer(jPanel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, DEFAULT_LAYER);
        jLayeredPane1.setLayer(username, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel9, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField3, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField1, DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED, 172, MAX_VALUE)
                                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                                        .addGroup(TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4, PREFERRED_SIZE, 250, PREFERRED_SIZE)
                                                                .addGap(205, 205, 205))
                                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                                                        .addGroup(jLayeredPane1Layout.createParallelGroup(TRAILING, false)
                                                                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                                        .addGroup(jLayeredPane1Layout.createParallelGroup(TRAILING, false)
                                                                                                .addComponent(jLabel10, LEADING, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                                                                .addComponent(jPasswordField3, LEADING)
                                                                                                .addComponent(jPasswordField2, LEADING, PREFERRED_SIZE, 300, PREFERRED_SIZE))
                                                                                        .addPreferredGap(ComponentPlacement.RELATED, DEFAULT_SIZE, MAX_VALUE)
                                                                                        .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                                                                                .addComponent(jLabel8, TRAILING, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                                                .addComponent(jLabel9, TRAILING, PREFERRED_SIZE, 60, PREFERRED_SIZE)))
                                                                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                                        .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                                                                                .addComponent(jLabel5, PREFERRED_SIZE, 155, PREFERRED_SIZE)
                                                                                                .addComponent(jLabel7, PREFERRED_SIZE, 300, PREFERRED_SIZE))
                                                                                        .addGap(89, 89, 89)))
                                                                        .addGroup(jLayeredPane1Layout.createParallelGroup(TRAILING, false)
                                                                                .addComponent(jTextField1, LEADING)
                                                                                .addComponent(jLabel6, LEADING, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                                                .addComponent(username, LEADING, DEFAULT_SIZE, 300, MAX_VALUE)))
                                                                .addContainerGap(138, MAX_VALUE))))
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(210, 210, 210)
                                                .addComponent(jButton2, PREFERRED_SIZE, 223, PREFERRED_SIZE)
                                                .addGap(0, 0, MAX_VALUE))))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4, PREFERRED_SIZE, 50, PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel5, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(username, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jLabel6, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jTextField1)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(BASELINE)
                                        .addComponent(jPasswordField2, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jLabel10, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(BASELINE)
                                        .addComponent(jPasswordField3, PREFERRED_SIZE, 36, PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                        .addComponent(jPanel1, TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
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
        setTitle("Registrierung Notenübersicht");
    }

    /**
     * Method signUp.
     *
     * <p>
     *     Used by JButton, handles sign up process.
     * </p>
     * @param e ActionEvent of JButton.
     */

    private void signUp(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }

        // check if username is given by the client
        if (username.getText().isEmpty()) {
            username.setText("Benutzername angeben.");
            return;
        }

        // check if username is already used
        List<User> users = frontendController.getLoginControllerImplementation().select();
        for (User user : users) {
            if (user.getUsername().equals(username.getText())) {
                username.setText("Der Benutzer ist bereits vergeben.");
                return;
            }
        }

        // check if password is given by the client
        if (Arrays.equals(jPasswordField2.getPassword(), new char[]{}) || Arrays.equals(jPasswordField3.getPassword(), new char[]{})) {
            username.setText("Bitte Passwort eingeben.");
            return;
        }

        // check if password matches in both fields
        if (!Arrays.equals(jPasswordField2.getPassword(), jPasswordField3.getPassword())) {
            username.setText("Passwörter sind nicht gleich.");
            jPasswordField2.setText("");
            jPasswordField3.setText("");
            return;
        }

        boolean success = frontendController.getLoginControllerImplementation().create(new User(
                username.getText(),
                jTextField1.getText(),
                new String(jPasswordField2.getPassword())
        ));
        jPasswordField2.setText("");
        jPasswordField3.setText("");

        if (success) {
            setVisible(false);
            new DataFrame(frontendController).setVisible(true);
        }
    }

    /**
     * Method login.
     *
     * <p>
     *     Changes current window with LoginFrame.
     * </p>
     * @param e ActionEvent of JButton.
     */

    private void login(ActionEvent e) {
        if (e.getSource() != jButton1) {
            return;
        }
        setVisible(false);
        loginFrame.setVisible(true);
    }
    public void setLoginFrame(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }
}
