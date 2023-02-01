package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Repository.Fach;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

/**
 * Class SecondFrame.
 *
 * <p>
 *     JFrame to delete existing subject.
 *     Created with NetBeans IDE 15.
 * </p>
 * @author SimonJpg
 * @version 2.0
 * @since 30.12.2022
 * @see javax.swing.JFrame
 */

public class SecondFrame extends JFrame {
    private JButton jButton2;
    private JTextField jTextField1;
    private JComboBox<String> jComboBox1;
    private final FrontendController frontendController;
    private final JTable jTable;
    private final DataFrame dataFrame;

    public SecondFrame(FrontendController frontendController, DataFrame dataFrame, JTable jTable) {
        this.frontendController = frontendController;
        this.dataFrame = dataFrame;
        this.jTable = jTable;
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

    /**
     * Method deleteOnClicked.
     *
     * <p>
     *     Deletes existing Fach entry in the database.
     * </p>
     * @param e ActionEvent triggered by JButton.
     */
    private void deleteOnClicked(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }
        // the data to work with
        String name = jTextField1.getText();

        List<Fach> fachListQ1 = frontendController.getBackendController().select("q1");
        List<Fach> fachListQ2 = frontendController.getBackendController().select("q2");
        List<Fach> fachListQ3 = frontendController.getBackendController().select("q3");
        List<Fach> fachListQ4 = frontendController.getBackendController().select("q4");

        dataFrame.sort(fachListQ1, 0, fachListQ1.size() - 1);
        dataFrame.sort(fachListQ2, 0, fachListQ2.size() - 1);
        dataFrame.sort(fachListQ3, 0, fachListQ3.size() - 1);
        dataFrame.sort(fachListQ4, 0, fachListQ4.size() - 1);

        // delete all data with the given name from the database.
        for (Fach fach : fachListQ1) {
            if (fach.getName().equalsIgnoreCase(name)) {
                frontendController.getBackendController().deleteById(fach.getId(), "q1");
            }
        }

        for (Fach fach : fachListQ2) {
            if (fach.getName().equalsIgnoreCase(name)) {
                frontendController.getBackendController().deleteById(fach.getId(), "q2");
            }
        }

        for (Fach fach : fachListQ3) {
            if (fach.getName().equalsIgnoreCase(name)) {
                frontendController.getBackendController().deleteById(fach.getId(), "q3");
            }
        }

        for (Fach fach : fachListQ4) {
            if (fach.getName().equalsIgnoreCase(name)) {
                frontendController.getBackendController().deleteById(fach.getId(), "q4");
            }
        }
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();

        // remove table data
        if (defaultTableModel.getRowCount() > 0) {
            for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
                defaultTableModel.removeRow(i);
            }
        }

        // add data
        dataFrame.appendSubject();

        // add schnitt
        defaultTableModel.addRow(new Object[] {
                "Schnitt",
                dataFrame.calcSchnitt("q1"),
                dataFrame.calcSchnitt("q2"),
                dataFrame.calcSchnitt("q3"),
                dataFrame.calcSchnitt("q4")
        });

        // update JTable
        AbstractTableModel abstractTableModel = (AbstractTableModel) jTable.getModel();
        abstractTableModel.fireTableDataChanged();
    }
}
