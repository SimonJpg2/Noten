package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Controller.MailController;
import de.simonjpg.noten.Backend.Images.ImageHandler;
import de.simonjpg.noten.Backend.Repository.User;
import de.simonjpg.noten.Backend.Security.BadCharacters;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.JLayeredPane.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

/**
 * Class VerificationFrame.
 *
 * <p>
 *     JFrame to verify the token.
 *     Created with NetBeans IDE 15.
 * </p>
 * @version 1.0
 * @since 28.1.2023
 * @author SimonJpg
 * @see JFrame
 */
public class VerificationFrame extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private final FrontendController frontendController;
    private String token = "";

    public VerificationFrame(FrontendController frontendController) {
        this.frontendController = frontendController;
        initComponents();
    }

    /**
     * Method initComponents.
     *
     * <p>
     *     Initializes swing and awt components.
     * </p>
     */

    private void initComponents() {
        JLayeredPane jLayeredPane1 = new JLayeredPane();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        JLabel jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(new ImageHandler().getImageFromResource("FrameImageIcon.png"));

        jPanel1.setBackground(new Color(41, 129, 186));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGap(0, 100, MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGap(0, 0, MAX_VALUE)
        );

        jLabel1.setFont(new Font("Arial Black", BOLD, 18)); // NOI18N
        jLabel1.setText("Verifizierung");

        jLabel2.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel2.setText("E-Mail");

        jTextField1.setFont(new Font("Arial", PLAIN, 14)); // NOI18N

        jLabel3.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel3.setText("Verifizierungstoken");

        jTextField2.setFont(new Font("Arial", PLAIN, 14)); // NOI18N

        jButton1.setFont(new Font("Arial Black", PLAIN, 12)); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(this::sendMail);

        jButton2.setFont(new Font("Arial Black", PLAIN, 12)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(this::verify);

        jLayeredPane1.setLayer(jPanel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(jLabel1, PREFERRED_SIZE, 150, PREFERRED_SIZE))
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING, false)
                                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                .addComponent(jButton1, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED, 80, MAX_VALUE)
                                                                .addComponent(jButton2, PREFERRED_SIZE, 100, PREFERRED_SIZE))
                                                        .addComponent(jLabel2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jLabel3, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                        .addComponent(jTextField2))))
                                .addGap(0, 51, MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addPreferredGap(UNRELATED)
                                .addComponent(jTextField1, PREFERRED_SIZE, 36, PREFERRED_SIZE)
                                .addPreferredGap(UNRELATED)
                                .addComponent(jLabel3, PREFERRED_SIZE, 24, PREFERRED_SIZE)
                                .addPreferredGap(UNRELATED)
                                .addComponent(jTextField2, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addPreferredGap(UNRELATED)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(BASELINE)
                                        .addComponent(jButton1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jButton2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE))
                                .addGap(12, 12, 12))
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
        setTitle("Verifizierung");
    }

    /**
     * Method sendMail.
     *
     * <p>
     *     Sends verification token to the client.
     * </p>
     * @param e ActionEvent triggered by the JButton.
     * @see de.simonjpg.noten.Backend.Controller.MailController
     */
    private void sendMail(ActionEvent e) {
        if (e.getSource() != jButton1) {
            return;
        }

        if (jTextField1.getText().isEmpty()) {
            jTextField1.setText("E-Mail angeben");
            return;
        }

        for (String s : BadCharacters.FORBIDDEN) {
            if (jTextField1.getText().contains(s)) {
                return;
            }
        }

        List<User> users = frontendController.getLoginControllerImplementation().select();

        for (User user : users) {
            if (user.getEmail().equals(jTextField1.getText())) {
                MailController mailController = new MailController();
                mailController.sendMail(jTextField1.getText());
                token = mailController.getCode();
                jTextField1.setText("Prüfe dein Postfach und gib den Token ein.");
                return;
            }
        }
        jTextField1.setText("Diese Email hat keinen Benutzer.");
    }

    /**
     * Method verify.
     *
     * <p>
     *     Checks if token by the client matches with the current token generated by the MailController.
     * </p>
     * @param e ActionEvent triggered by the JButton.
     */
    private void verify(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }

        if (jTextField2.getText().isEmpty()) {
            jTextField2.setText("Token angeben");
            return;
        }

        for (String s : BadCharacters.FORBIDDEN) {
            if (jTextField2.getText().contains(s)) {
                return;
            }
        }

        if (jTextField2.getText().equals(token)) {
            token = "";
            new ResetFrame(frontendController).setVisible(true);
            dispose();
        }
    }
}
