package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Repository.User;
import de.simonjpg.noten.Backend.Security.BadCharacters;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.JLayeredPane.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;
import static javax.swing.WindowConstants.*;

/**
 * Class ResetFrame.
 *
 * <p>
 *     JFrame to reset password.
 *     Created with NetBeans IDE 15.
 * </p>
 * @version 1.0
 * @since 28.1.2023
 * @author SimonJpg
 * @see JFrame
 */
public class ResetFrame extends JFrame {
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private final FrontendController frontendController;

    public ResetFrame(FrontendController frontendController) {
        this.frontendController = frontendController;
        initComponents();
    }

    private void initComponents() {

        jLayeredPane1 = new JLayeredPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jPasswordField1 = new JPasswordField();
        jPasswordField2 = new JPasswordField();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

        jLabel1.setFont(new Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Wiederherstellung");

        jLabel2.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Passwort");

        jLabel3.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Passwort wiederholen");

        jButton1.setFont(new Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setText("Change");
        jButton1.addActionListener(this::changePassword);

        jLabel4.setFont(new Font("Arial", 1, 12)); // NOI18N

        jLayeredPane1.setLayer(jPanel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING, false)
                                                .addComponent(jLabel2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(jLabel3, DEFAULT_SIZE, 280, MAX_VALUE)
                                                .addComponent(jButton1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(jLabel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(jPasswordField1)
                                                .addComponent(jPasswordField2))
                                        .addComponent(jLabel4, PREFERRED_SIZE, 80, PREFERRED_SIZE))
                                .addGap(0, 51, MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jLabel4, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jLabel2, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jPasswordField1, PREFERRED_SIZE, 36, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, PREFERRED_SIZE, 24, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jPasswordField2, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
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
        setTitle("Passwort zurücksetzen");
    }

    /**
     * Method changePassword.
     *
     * <p>
     *     Method to change password of the account from the client.
     * </p>
     * @param e ActionEvent triggered by JButton.
     *
     */
    private void changePassword(ActionEvent e) {
        if (e.getSource() != jButton1) {
            return;
        }
        String password1 = new String(jPasswordField1.getPassword());
        String password2 = new String(jPasswordField2.getPassword());

        for (String s : BadCharacters.FORBIDDEN) {
            if (password1.contains(s) || password2.contains(s)) {
                jLabel4.setText("Fail");
                return;
            }
        }

        // check if password is given by the client
        if (password1.isEmpty()) {
            jLabel4.setText("Fail");
            return;
        }

        if (!password1.equals(password2)) {
            jLabel4.setText("Fail");
            return;
        }
        List<User> users = frontendController.getLoginControllerImplementation().select();
        User userToUpdate = users.get(0);

        frontendController.getLoginControllerImplementation().updateById(userToUpdate.getId(),
                new User(
                        userToUpdate.getUsername(),
                        userToUpdate.getEmail(),
                        new String(jPasswordField1.getPassword())
                ));
        jLabel4.setText("Success");
    }
}
