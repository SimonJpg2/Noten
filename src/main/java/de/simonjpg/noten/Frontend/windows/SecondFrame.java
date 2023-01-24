package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Fach;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;
import static javax.swing.WindowConstants.*;

/**
 * Class SecondFrame.
 *
 * <p>
 *     JFrame to delete existing subject.
 *     Created with NetBeans IDE 15.
 * </p>
 * @author SimonJpg
 * @version 1.0
 * @since 30.12.2022
 * @see javax.swing.JFrame
 */

public class SecondFrame extends JFrame {

    private JButton jButton2;
    private JTextField jTextField1;
    private JComboBox<String> jComboBox1;
    private final FrontendController frontendController;

    public SecondFrame(FrontendController frontendController) {
        this.frontendController = frontendController;
        initComponents();
    }

    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        JButton jButton1 = new JButton();
        jButton2 = new JButton();
        jComboBox1 = new JComboBox<>();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(new Color(43, 43, 43));
        setResizable(false);

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

        jLabel1.setFont(new Font("Arial", BOLD, 18)); // NOI18N
        jLabel1.setText("Fach");

        jTextField1.setFont(new Font("Arial", BOLD, 14)); // NOI18N
        jTextField1.setText("Fach eingeben");

        jButton1.setFont(new Font("Arial", BOLD, 14)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(e -> dispose());

        jButton2.setFont(new Font("Arial", BOLD, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(this::deleteOnClicked);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"q1", "q2", "q3", "q4"}));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(133, 133, 133)
                                                                .addComponent(jTextField1, PREFERRED_SIZE, 150, PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(44, 44, 44)
                                                                .addComponent(jButton2, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                                                .addGap(128, 128, 128)
                                                                .addComponent(jButton1, PREFERRED_SIZE, 90, PREFERRED_SIZE)))
                                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(179, 179, 179)
                                                .addComponent(jLabel1, PREFERRED_SIZE, 70, PREFERRED_SIZE)
                                                .addPreferredGap(RELATED, 192, MAX_VALUE)
                                                .addComponent(jComboBox1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel1, PREFERRED_SIZE, 40, PREFERRED_SIZE)
                                        .addComponent(jComboBox1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(84, 84, 84)
                                .addComponent(jTextField1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(RELATED, 113, MAX_VALUE)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jButton2, PREFERRED_SIZE, 40, PREFERRED_SIZE)
                                        .addComponent(jButton1, PREFERRED_SIZE, 40, PREFERRED_SIZE))
                                .addGap(16, 16, 16))
        );

        pack();
    }

    private void deleteOnClicked(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }

        String name = jTextField1.getText();
        String table = (String) jComboBox1.getSelectedItem();

        List<Fach> fachList = frontendController.getBackendController().select(table);

        for (Fach fach : fachList) {
            if (fach.getName().equalsIgnoreCase(name)) {
                frontendController.getBackendController().deleteById(fach.getId(), table);
            }
        }
    }
}
