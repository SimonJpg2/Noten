package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Images.ImageHandler;
import de.simonjpg.noten.Backend.Repository.Fach;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
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
 * @version 2.0
 * @since 30.12.2022
 * @see JFrame
 */

public class FirstFrame extends JFrame {
    private final FrontendController frontendController;
    private final JTable jTable1;
    private final DataFrame dataFrame;
    private JButton jButton2;
    private JSpinner jSpinner1;
    private JTextField jTextField1;
    private JComboBox<String> jComboBox1;

    public FirstFrame(FrontendController frontendController, DataFrame dataFrame, JTable jTable1) {
        this.frontendController = frontendController;
        this.dataFrame = dataFrame;
        this.jTable1 = jTable1;
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

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jSpinner1 = new JSpinner();
        JButton jButton1 = new JButton();
        jButton2 = new JButton();
        jComboBox1 = new JComboBox<>();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(new ImageHandler().getImageFromResource("FrameImageIcon.png"));
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
        setLocationRelativeTo(null);
        setTitle("Fach hinzufügen");
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
        // get data to work with
        String name = jTextField1.getText();
        String table = (String) jComboBox1.getSelectedItem();
        int note = (Integer) jSpinner1.getValue();

        // the column to update existing data
        int column = table.equalsIgnoreCase("q1") ? 1 : table.equalsIgnoreCase("q2") ? 2 : table.equalsIgnoreCase("q3") ? 3 : 4;

        // data from database
        List<Fach> fachList = frontendController.getBackendController().select(table);

        // true if subject already exists in database.
        boolean found = false;

        // update database.
        for (Fach fach : fachList) {
            if (fach.getName().equalsIgnoreCase(name)) {
                frontendController.getBackendController().updateById(fach.getId(), new Fach(name, note), table);
                found = true;
            }
        }

        List<Fach> fachListQ1 = frontendController.getBackendController().select("q1");
        List<Fach> fachListQ2 = frontendController.getBackendController().select("q2");
        List<Fach> fachListQ3 = frontendController.getBackendController().select("q3");
        List<Fach> fachListQ4 = frontendController.getBackendController().select("q4");

        dataFrame.sort(fachListQ1, 0, fachListQ1.size() - 1);
        dataFrame.sort(fachListQ2, 0, fachListQ2.size() - 1);
        dataFrame.sort(fachListQ3, 0, fachListQ3.size() - 1);
        dataFrame.sort(fachListQ4, 0, fachListQ4.size() - 1);

        if (found) {
            // update column Q1
            for (int i = 0; i < fachListQ1.size(); i++) {
                if (fachListQ1.get(i).getName().equalsIgnoreCase(name)) {
                    DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

                    // remove schnitt
                    defaultTableModel.removeRow(defaultTableModel.getRowCount() - 1);

                    // add fach
                    defaultTableModel.setValueAt(note, i, column);

                    // add schnitt
                    defaultTableModel.addRow(new Object[]{
                            "Schnitt",
                            dataFrame.calcSchnitt("q1"),
                            dataFrame.calcSchnitt("q2"),
                            dataFrame.calcSchnitt("q3"),
                            dataFrame.calcSchnitt("q4")
                    });
                }
            }
            // update column Q2
            for (int i = 0; i < fachListQ2.size(); i++) {
                if (fachListQ2.get(i).getName().equalsIgnoreCase(name)) {
                    DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

                    // remove schnitt
                    defaultTableModel.removeRow(defaultTableModel.getRowCount() - 1);

                    // add fach
                    defaultTableModel.setValueAt(note, i, column);

                    // add schnitt
                    defaultTableModel.addRow(new Object[]{
                            "Schnitt",
                            dataFrame.calcSchnitt("q1"),
                            dataFrame.calcSchnitt("q2"),
                            dataFrame.calcSchnitt("q3"),
                            dataFrame.calcSchnitt("q4")
                    });
                }
            }
            // update column Q3
            for (int i = 0; i < fachListQ3.size(); i++) {
                if (fachListQ3.get(i).getName().equalsIgnoreCase(name)) {
                    DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

                    // remove schnitt
                    defaultTableModel.removeRow(defaultTableModel.getRowCount() - 1);

                    // add fach
                    defaultTableModel.setValueAt(note, i, column);

                    // add schnitt
                    defaultTableModel.addRow(new Object[]{
                            "Schnitt",
                            dataFrame.calcSchnitt("q1"),
                            dataFrame.calcSchnitt("q2"),
                            dataFrame.calcSchnitt("q3"),
                            dataFrame.calcSchnitt("q4")
                    });
                }
            }
            // update column Q4
            for (int i = 0; i < fachListQ4.size(); i++) {
                if (fachListQ4.get(i).getName().equalsIgnoreCase(name)) {
                    DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

                    // remove schnitt
                    defaultTableModel.removeRow(defaultTableModel.getRowCount() - 1);

                    // add fach
                    defaultTableModel.setValueAt(note, i, column);

                    // add schnitt
                    defaultTableModel.addRow(new Object[]{
                            "Schnitt",
                            dataFrame.calcSchnitt("q1"),
                            dataFrame.calcSchnitt("q2"),
                            dataFrame.calcSchnitt("q3"),
                            dataFrame.calcSchnitt("q4")
                    });
                }
            }
        }

        // if subject doesn't exist in the database.
        if (!found) {
            frontendController.getBackendController().create(new Fach(name, note), table);

            // fill DB to avoid IndexOutOfBoundsException.
            if (column == 1) {
                frontendController.getBackendController().create(new Fach(name, -1), "q2");
                frontendController.getBackendController().create(new Fach(name, -1), "q3");
                frontendController.getBackendController().create(new Fach(name, -1), "q4");
            } else if (column == 2) {
                frontendController.getBackendController().create(new Fach(name, -1), "q1");
                frontendController.getBackendController().create(new Fach(name, -1), "q3");
                frontendController.getBackendController().create(new Fach(name, -1), "q4");
            } else if (column == 3) {
                frontendController.getBackendController().create(new Fach(name, -1), "q1");
                frontendController.getBackendController().create(new Fach(name, -1), "q2");
                frontendController.getBackendController().create(new Fach(name, -1), "q4");
            } else {
                frontendController.getBackendController().create(new Fach(name, -1), "q1");
                frontendController.getBackendController().create(new Fach(name, -1), "q2");
                frontendController.getBackendController().create(new Fach(name, -1), "q3");
            }
            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

            // remove table data
            if (defaultTableModel.getRowCount() > 0) {
                for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
                    defaultTableModel.removeRow(i);
                }
            }

            // fill JTable with data
            dataFrame.appendSubject();

            // add schnitt
            defaultTableModel.addRow(new Object[] {
                    "Schnitt",
                    dataFrame.calcSchnitt("q1"),
                    dataFrame.calcSchnitt("q2"),
                    dataFrame.calcSchnitt("q3"),
                    dataFrame.calcSchnitt("q4")
            });
        }
        // update JTable
        AbstractTableModel abstractTableModel = (AbstractTableModel) jTable1.getModel();
        abstractTableModel.fireTableDataChanged();
    }
}
