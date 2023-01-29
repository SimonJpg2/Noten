package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Repository.Fach;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

/**
 * Class FirstFrame.
 *
 * <p>
 *     JFrame to add new subject.
 *     Created with NetBeans IDE 15.
 * </p>
 * @author SimonJpg
 * @version 1.0
 * @since 30.12.2022
 * @see javax.swing.JFrame
 */

public class FirstFrame extends javax.swing.JFrame {
    private final FrontendController frontendController;
    private JButton jButton2;
    private JSpinner jSpinner1;
    private JTextField jTextField1;
    private JComboBox<String> jComboBox1;

    public FirstFrame(FrontendController frontendController) {
        this.frontendController = frontendController;
        initComponents();
    }

    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jSpinner1 = new JSpinner();
        JButton jButton1 = new JButton();
        jButton2 = new JButton();
        jComboBox1 = new JComboBox<>();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(43, 43, 43));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(41, 129, 186));

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

        jLabel1.setFont(new java.awt.Font("Arial", BOLD, 18)); // NOI18N
        jLabel1.setText("Fach");

        jLabel2.setFont(new java.awt.Font("Arial", BOLD, 18)); // NOI18N
        jLabel2.setText("Note");

        jTextField1.setFont(new java.awt.Font("Arial", BOLD, 14)); // NOI18N
        jTextField1.setText("Fach eingeben");

        jSpinner1.setFont(new java.awt.Font("Arial", PLAIN, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", BOLD, 14)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(e -> dispose());

        jButton2.setFont(new java.awt.Font("Arial", BOLD, 14)); // NOI18N
        jButton2.setText("Apply");
        jButton2.addActionListener(this::addEntry);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"q1", "q2", "q3", "q4"}));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(jButton2, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                                .addGap(128, 128, 128)
                                                .addComponent(jButton1, PREFERRED_SIZE, 90, PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jLabel1, PREFERRED_SIZE, 70, PREFERRED_SIZE)
                                                                .addGap(149, 149, 149))
                                                        .addGroup(LEADING, layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField1, PREFERRED_SIZE, 150, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)))
                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                        .addComponent(jLabel2, PREFERRED_SIZE, 70, PREFERRED_SIZE)
                                                        .addComponent(jSpinner1, PREFERRED_SIZE, 89, PREFERRED_SIZE))))
                                .addPreferredGap(RELATED, DEFAULT_SIZE, MAX_VALUE)
                                .addComponent(jComboBox1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel1, PREFERRED_SIZE, 40, PREFERRED_SIZE)
                                        .addComponent(jComboBox1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jLabel2, PREFERRED_SIZE, 40, PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jSpinner1, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                        .addComponent(jTextField1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addPreferredGap(RELATED, 117, MAX_VALUE)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jButton2, PREFERRED_SIZE, 40, PREFERRED_SIZE)
                                        .addComponent(jButton1, PREFERRED_SIZE, 40, PREFERRED_SIZE))
                                .addGap(16, 16, 16))
        );

        pack();
    }

    /**
     * Method addEntry.
     *
     * <p>
     *     This method adds a new Fach entry to the database.
     * </p>
     *
     * @param e the event triggered by the JButton.
     */
    private void addEntry(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }

        String name = jTextField1.getText();
        String table = (String) jComboBox1.getSelectedItem();
        int note = (Integer) jSpinner1.getValue();

        List<Fach> fachList = frontendController.getBackendController().select(table);
        boolean found = false;

        for (Fach fach : fachList) {
            if (fach.getName().equalsIgnoreCase(name)) {
                frontendController.getBackendController().updateById(fach.getId(), new Fach(name, note), table);
                found = true;
            }
        }

        if (!found) {
            frontendController.getBackendController().create(new Fach(name, note), table);
        }
    }
}
