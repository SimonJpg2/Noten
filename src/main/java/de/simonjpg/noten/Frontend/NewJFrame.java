package de.simonjpg.noten.Frontend;


import de.simonjpg.noten.Backend.Fach;
import de.simonjpg.noten.Frontend.windows.FirstFrame;
import de.simonjpg.noten.Frontend.windows.SecondFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

/**
 * Class NewJFrame.
 *
 * <p>
 *     Main JFrame to display subjects and marks to the user.
 *     Created with NetBeans IDE 15.
 * </p>
 * @see javax.swing.JFrame
 */

public class NewJFrame extends JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private final JPanel jPanel1 = new JPanel();
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private final FrontendController frontendController;

    /**
     * Constructor NewJFrame.
     *
     * <p>
     *     Displays data from DB to JTextAreas.
     *     Initializes components for JFrame.
     * </p>
     * @param frontendController a {@link de.simonjpg.noten.Frontend.FrontendController} instance.
     */

    public NewJFrame(FrontendController frontendController) {
        this.frontendController = frontendController;
        initComponents();
        jTextArea1.append("\t\n\tFächer\n");
        jTextArea2.append("\t\n\tQ1\tQ2\tQ3\tQ4\n");
        appendSubject();
        jTextArea1.append("\t\n\n\tSchnitt\n");
        jTextArea2.append("\t\n\n\t"+ calcSchnitt("q1") + "\t"
                                    + calcSchnitt("q2") + "\t"
                                    + calcSchnitt("q3") + "\t"
                                    + calcSchnitt("q4") + "\n");
    }

    /**
     * Method initComponents.
     *
     * <p>
     *     Initializes components needed for the JFrame.
     * </p>
     */
    private void initComponents() {
        // instantiate components.
        jButton1 = new JButton();
        jButton2 = new JButton();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JPanel jPanel3 = new JPanel();
        JScrollPane jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        JScrollPane jScrollPane3 = new JScrollPane();
        jTextArea2 = new JTextArea();

        // set frame properties.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(238, 238, 238));
        setResizable(false);

        // set component properties.
        jPanel1.setBackground(new Color(41, 129, 186));


        jButton1.setBackground(new Color(0, 255, 0));
        jButton1.addActionListener(this::actionEventFirstButton);

        jButton2.setBackground(new Color(255, 0, 0));
        jButton2.addActionListener(this::actionEventSecondButton);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                        .addComponent(jButton1, PREFERRED_SIZE, 62, PREFERRED_SIZE)
                                        .addComponent(jButton2, PREFERRED_SIZE, 62, PREFERRED_SIZE))
                                .addContainerGap(39, MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jButton2, PREFERRED_SIZE, 58, PREFERRED_SIZE)
                                .addPreferredGap(RELATED, 320, MAX_VALUE)
                                .addComponent(jButton1, PREFERRED_SIZE, 58, PREFERRED_SIZE)
                                .addGap(37, 37, 37))
        );

        jPanel2.setBackground(new Color(41,129,186));

        jLabel1.setFont(new java.awt.Font("Arial Black", BOLD, 18)); // NOI18N
        jLabel1.setText("Notenübersicht");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE)
                                .addComponent(jLabel1, PREFERRED_SIZE, 180, PREFERRED_SIZE)
                                .addGap(425, 425, 425))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, DEFAULT_SIZE, 35, MAX_VALUE)
                                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new Color(238, 238, 238));

        jTextArea1.setBackground(new Color(238, 238, 238));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", PLAIN, 14)); // NOI18N
        jTextArea1.setForeground(new Color(0, 0, 0));
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jScrollPane2.setViewportView(jTextArea1);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, PREFERRED_SIZE, 462, PREFERRED_SIZE)
                                .addGap(0, 0, MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(LEADING)
                        .addComponent(jScrollPane2, TRAILING, DEFAULT_SIZE, 484, MAX_VALUE)
        );

        jTextArea2.setBackground(new Color(238, 238, 238));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", PLAIN, 14)); // NOI18N
        jTextArea2.setForeground(new Color(0, 0, 0));
        jTextArea2.setRows(5);
        jTextArea2.setEditable(false);
        jScrollPane3.setViewportView(jTextArea2);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(jPanel2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel3, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addPreferredGap(RELATED)
                                                .addComponent(jScrollPane3, PREFERRED_SIZE, 503, PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(TRAILING)
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(UNRELATED)
                                .addGroup(layout.createParallelGroup(LEADING, false)
                                        .addComponent(jPanel3, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jScrollPane3))
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE))
        );

        pack();
    }

    /**
     * Method appendSubject.
     *
     * <p>
     *     gets data from DB and appends it to the JTextArea.
     * </p>
     */

    private void appendSubject() {
        List<Fach> fachListQ1 = frontendController.getBackendController().select("q1");
        List<Fach> fachListQ2 = frontendController.getBackendController().select("q2");
        List<Fach> fachListQ3 = frontendController.getBackendController().select("q3");
        List<Fach> fachListQ4 = frontendController.getBackendController().select("q4");

        for (int i = 0; i < fachListQ1.size(); i++) {
            jTextArea1.append("\t\n\t" + fachListQ1.get(i).getName() + "\n");
            jTextArea2.append("\t\n\t" + fachListQ1.get(i).getNote());
            jTextArea2.append("\t" + fachListQ2.get(i).getNote());
            jTextArea2.append("\t" + fachListQ3.get(i).getNote());
            jTextArea2.append("\t" + fachListQ4.get(i).getNote() + "\n");
        }
    }

    /**
     * Method calcSchnitt.
     *
     * <p>
     *     calculates schnitt of every QPhase.
     * </p>
     * @param halbjahr the table for the QPhase.
     * @return a {@link java.lang.String}.
     */

    private String calcSchnitt(String halbjahr) {

        if (!halbjahr.equals("q1") && !halbjahr.equals("q2") && !halbjahr.equals("q3") && !halbjahr.equals("q4")) {
            System.err.println("Given table of Database is incorrect. Please check the param of the method calcSchnitt.");
            return "something went wrong.";
        }

        List<Fach> fachList = frontendController.getBackendController().select(halbjahr);
        int sum = 0;
        // Auftreten Division durch 0, falls keine Werte vorhanden.
        try {
            for (Fach fach : fachList) {

                // Leistungskurse
          /*  if (fach.getName().equalsIgnoreCase("Chemie") || fach.getName().equalsIgnoreCase("Programmieren")) {
                sum += fach.getNote() * 2;
            } */
                sum += fach.getNote();
            }
            return Integer.toString(sum / fachList.size());
        } catch (ArithmeticException e) {
            return Integer.toString(0);
        }
    }

    // second button on first JFrame
    private void actionEventFirstButton(ActionEvent e) {
        if (e.getSource() == jButton1) {
            new FirstFrame(frontendController).setVisible(true);
        }
    }

    // first button on first JFrame
    private void actionEventSecondButton(ActionEvent e) {
        if (e.getSource() == jButton2) {
            new SecondFrame(frontendController).setVisible(true);
        }

    }
}