package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Repository.Fach;
import de.simonjpg.noten.Frontend.FrontendController;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Random;

import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;
import static javax.swing.WindowConstants.*;

/**
 * Class DataFrame
 *
 * <p>
 *     JFrame to display data
 *     Created with NetBeans IDE 15.
 * </p>
 * @version 1.0
 * @since 1.2.2023
 * @author SimonJpg
 * @see javax.swing.JFrame
 */

public class DataFrame extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private DefaultTableModel tableModel;
    private final FrontendController frontendController;

    public DataFrame(FrontendController frontendController) {
        this.frontendController = frontendController;
        initComponents();
        appendSubject();
        tableModel.addRow(new Object[] {"Schnitt", calcSchnitt("q1"), calcSchnitt("q2"), calcSchnitt("q3"), calcSchnitt("q4")});
    }

    private void initComponents() {
        jLayeredPane1 = new JLayeredPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        jButton3 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(41, 129, 186));

        jLabel1.setFont(new Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Notenübersicht");
        jLabel1.setToolTipText("Verwaltung der Zeugnisnoten verschiedener Halbjahreszeugnisse.");

        jButton1.setBackground(new Color(41, 129, 186));
        jButton1.setFont(new Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(this::actionEventFirstButton);

        jLabel3.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Fach hinzufügen/bearbeiten");

        jLabel4.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Fach löschen");

        jButton2.setBackground(new Color(41, 129, 186));
        jButton2.setFont(new Font("Arial Black", 0, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(this::actionEventSecondButton);

        jLabel2.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Anwendung schließen");

        jButton3.setBackground(new Color(41, 129, 186));
        jButton3.setFont(new Font("Arial Black", 1, 14)); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(this::close);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(45, MAX_VALUE)
                                                .addComponent(jLabel1, PREFERRED_SIZE, 200, PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanel1Layout.createParallelGroup(LEADING, false)
                                                        .addComponent(jButton1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                        .addComponent(jLabel3, DEFAULT_SIZE, 200, MAX_VALUE)
                                                        .addComponent(jLabel4, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                        .addComponent(jButton2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                        .addComponent(jLabel2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                        .addComponent(jButton3, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE))
                                                .addGap(0, 0, MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel3, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addPreferredGap(UNRELATED)
                                .addComponent(jButton2, PREFERRED_SIZE, 31, PREFERRED_SIZE)
                                .addPreferredGap(RELATED, DEFAULT_SIZE, MAX_VALUE)
                                .addComponent(jLabel2, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addPreferredGap(UNRELATED)
                                .addComponent(jButton3)
                                .addGap(26, 26, 26))
        );

        jTable1.setFont(new Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Fächer", "Q1", "Q2", "Q3", "Q4"
                }
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLayeredPane1.setLayer(jPanel1, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, JLayeredPane.DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, DEFAULT_SIZE, 744, MAX_VALUE)
                                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, DEFAULT_SIZE, 438, MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(jLayeredPane1, TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
        setTitle("Notenübersicht");
    }

    public String calcSchnitt(String halbjahr) {
        if (!halbjahr.equals("q1") && !halbjahr.equals("q2") && !halbjahr.equals("q3") && !halbjahr.equals("q4")) {
            System.err.println("Given table of Database is incorrect. Please check the param of the method calcSchnitt.");
            return "something went wrong.";
        }

        List<Fach> fachList = frontendController.getBackendController().select(halbjahr);
        int sum = 0;
        // Auftreten Division durch 0, falls keine Werte vorhanden.
        try {
            for (Fach fach : fachList) {
                sum += fach.getNote();
            }
            return Integer.toString(sum / fachList.size());
        } catch (ArithmeticException e) {
            return Integer.toString(0);
        }
    }

    /**
     * Method sort
     *
     * <p>
     *     implements quicksort algorithm
     * </p>
     *
     * @param listToSort the list to be sorted
     * @param lowIndex start index
     * @param highIndex end index
     */

    public  void sort(List<Fach> listToSort, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        String pivot = listToSort.get(pivotIndex).getName();
        swap(listToSort, pivotIndex, highIndex);

        int leftPointer = partition(listToSort, lowIndex, highIndex, pivot);
        sort(listToSort, lowIndex, leftPointer - 1);
        sort(listToSort, leftPointer + 1, highIndex);
    }

    /**
     * Method partition.
     *
     * <p>
     *     implementation of quicksort.
     * </p>
     *
     * @param listToSort {@link java.util.List}
     * @param lowIndex {@link java.lang.Integer}
     * @param highIndex {@link java.lang.Integer}
     * @param pivot {@link java.lang.Integer}
     * @return {@link java.lang.Integer}
     */

    private int partition(List<Fach> listToSort, int lowIndex, int highIndex, String pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            while (listToSort.get(leftPointer).getName().compareTo(pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (listToSort.get(rightPointer).getName().compareTo(pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(listToSort, leftPointer, rightPointer);
        }

        if (listToSort.get(leftPointer).getName().compareTo(listToSort.get(highIndex).getName()) > 0) {
            swap(listToSort, leftPointer, highIndex);
        }

        else {
            leftPointer = highIndex;
        }
        return leftPointer;
    }

    /**
     * Method swap.
     *
     * <p>
     *     Swaps to subject references of a List.
     * </p>
     *
     * @param listToSort {@link java.util.List} list to be sorted.
     * @param index1 index of first reference
     * @param index2 index of second reference
     */
    private void swap(List<Fach> listToSort, int index1, int index2) {
        Fach k = listToSort.get(index1);
        listToSort.set(index1, listToSort.get(index2));
        listToSort.set(index2, k);
    }

    /**
     * Method appendSubject.
     *
     * <p>
     *     adds data to the JTable.
     * </p>
     */
    public void appendSubject() {
        List<Fach> fachListQ1 = frontendController.getBackendController().select("q1");
        List<Fach> fachListQ2 = frontendController.getBackendController().select("q2");
        List<Fach> fachListQ3 = frontendController.getBackendController().select("q3");
        List<Fach> fachListQ4 = frontendController.getBackendController().select("q4");

        sort(fachListQ1, 0, fachListQ1.size() - 1);
        sort(fachListQ2, 0, fachListQ2.size() - 1);
        sort(fachListQ3, 0, fachListQ3.size() - 1);
        sort(fachListQ4, 0, fachListQ4.size() - 1);

        tableModel = (DefaultTableModel) jTable1.getModel();

        // add rows with data of the database
        for (int i = 0; i < fachListQ1.size(); i++) {
            tableModel.addRow(new Object[]{
                    fachListQ1.get(i).getName(),
                    fachListQ1.get(i).getNote(),
                    fachListQ2.get(i).getNote(),
                    fachListQ3.get(i).getNote(),
                    fachListQ4.get(i).getNote()
            });
        }
    }
    /**
     * Method actionEventFirstButton.
     *
     * <p>
     *     Creates JFrame to add/change data
     * </p>
     * @param e ActionEvent triggered by the JButton.
     */

    private void actionEventFirstButton(ActionEvent e) {
        if (e.getSource() == jButton1) {
            new FirstFrame(frontendController, this, jTable1).setVisible(true);
        }
    }

    /**
     * Method actionEventSecondButton.
     *
     * <p>
     *     Creates JFrame to delete data
     * </p>
     * @param e ActionEvent triggered by the JButton.
     */

    private void actionEventSecondButton(ActionEvent e) {
        if (e.getSource() == jButton2) {
            new SecondFrame(frontendController, this, jTable1).setVisible(true);
        }
    }

    /**
     * Method close.
     *
     * <p>
     *     Exit program with exitcode 0.
     * </p>
     * @param e ActionEvent triggered by the JButton.
     */

    private void close(ActionEvent e) {
        if (e.getSource() != jButton3) {
            return;
        }
        System.exit(0);
    }
}
