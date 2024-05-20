package calculadora.vista;

import calculadora.controlador.CalculadoraControlador;
import calculadora.vista.mode.CMPLX;
import calculadora.vista.mode.Cientifica;
import calculadora.vista.mode.Convercion;
import calculadora.vista.mode.Corte;
import calculadora.vista.mode.Matrix;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class CalculadoraVista extends javax.swing.JFrame {

    private JPanel selectedPanel = null;
    private Cientifica cientifica;
     private CalculadoraControlador controlador;
    
    public CalculadoraVista() {
        initComponents();
    }
    
    public void iniciar() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }
   
    public void setControlador(CalculadoraControlador controlador) {
        this.controlador = controlador;
        this.cientifica = new Cientifica(controlador);
        setForm(cientifica);
        setSelectedPanel(jPanelCientifica);
    }
    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    private void setSelectedPanel(JPanel panel) {
    if (selectedPanel != null) {
        selectedPanel.setBackground(new java.awt.Color(255, 255, 255));
    }
    selectedPanel = panel;
    selectedPanel.setBackground(new java.awt.Color(242, 242, 242));
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelCalculadora = new javax.swing.JLabel();
        jLabelModo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelCientifica = new javax.swing.JPanel();
        jLabelModo1 = new javax.swing.JLabel();
        jPanelConvercion = new javax.swing.JPanel();
        jLabelConvercion = new javax.swing.JLabel();
        jPanelMatrix = new javax.swing.JPanel();
        jLabelMatrix = new javax.swing.JLabel();
        jPanelCMPLX = new javax.swing.JPanel();
        jLabelCMPLX = new javax.swing.JLabel();
        jPanelCorte = new javax.swing.JPanel();
        jLabelCorte = new javax.swing.JLabel();
        jPanelSalir = new javax.swing.JPanel();
        jLabelSalir = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabelCalculadora.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelCalculadora.setText("Calculadora");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelCalculadora)
                .addGap(15, 15, 15))
        );

        jLabelModo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelModo.setText("Mode");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jPanelCientifica.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCientifica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelCientifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCientificaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCientificaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelCientificaMouseExited(evt);
            }
        });

        jLabelModo1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabelModo1.setText("Cientifica");

        javax.swing.GroupLayout jPanelCientificaLayout = new javax.swing.GroupLayout(jPanelCientifica);
        jPanelCientifica.setLayout(jPanelCientificaLayout);
        jPanelCientificaLayout.setHorizontalGroup(
            jPanelCientificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelCientificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelModo1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
        );
        jPanelCientificaLayout.setVerticalGroup(
            jPanelCientificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
            .addGroup(jPanelCientificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCientificaLayout.createSequentialGroup()
                    .addComponent(jLabelModo1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelConvercion.setBackground(new java.awt.Color(255, 255, 255));
        jPanelConvercion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelConvercion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelConvercionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelConvercionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelConvercionMouseExited(evt);
            }
        });

        jLabelConvercion.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabelConvercion.setText("Convercion");

        javax.swing.GroupLayout jPanelConvercionLayout = new javax.swing.GroupLayout(jPanelConvercion);
        jPanelConvercion.setLayout(jPanelConvercionLayout);
        jPanelConvercionLayout.setHorizontalGroup(
            jPanelConvercionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelConvercionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelConvercion, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
        );
        jPanelConvercionLayout.setVerticalGroup(
            jPanelConvercionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
            .addGroup(jPanelConvercionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelConvercionLayout.createSequentialGroup()
                    .addComponent(jLabelConvercion)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelMatrix.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMatrix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMatrix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMatrixMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMatrixMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMatrixMouseExited(evt);
            }
        });

        jLabelMatrix.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabelMatrix.setText("Matrix");

        javax.swing.GroupLayout jPanelMatrixLayout = new javax.swing.GroupLayout(jPanelMatrix);
        jPanelMatrix.setLayout(jPanelMatrixLayout);
        jPanelMatrixLayout.setHorizontalGroup(
            jPanelMatrixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelMatrixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelMatrix, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
        );
        jPanelMatrixLayout.setVerticalGroup(
            jPanelMatrixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
            .addGroup(jPanelMatrixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelMatrixLayout.createSequentialGroup()
                    .addComponent(jLabelMatrix)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelCMPLX.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCMPLX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelCMPLX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCMPLXMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCMPLXMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelCMPLXMouseExited(evt);
            }
        });

        jLabelCMPLX.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabelCMPLX.setText("CMPLX");

        javax.swing.GroupLayout jPanelCMPLXLayout = new javax.swing.GroupLayout(jPanelCMPLX);
        jPanelCMPLX.setLayout(jPanelCMPLXLayout);
        jPanelCMPLXLayout.setHorizontalGroup(
            jPanelCMPLXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelCMPLXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelCMPLX, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
        );
        jPanelCMPLXLayout.setVerticalGroup(
            jPanelCMPLXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
            .addGroup(jPanelCMPLXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCMPLXLayout.createSequentialGroup()
                    .addComponent(jLabelCMPLX)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelCorte.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCorte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelCorte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCorteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCorteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelCorteMouseExited(evt);
            }
        });

        jLabelCorte.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabelCorte.setText("Corte");

        javax.swing.GroupLayout jPanelCorteLayout = new javax.swing.GroupLayout(jPanelCorte);
        jPanelCorte.setLayout(jPanelCorteLayout);
        jPanelCorteLayout.setHorizontalGroup(
            jPanelCorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCorte, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        );
        jPanelCorteLayout.setVerticalGroup(
            jPanelCorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCorteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelCorte))
        );

        jPanelSalir.setBackground(new java.awt.Color(255, 105, 98));
        jPanelSalir.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelSalirMouseExited(evt);
            }
        });

        jLabelSalir.setBackground(new java.awt.Color(0, 0, 0));
        jLabelSalir.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabelSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSalir.setText("Salir");

        javax.swing.GroupLayout jPanelSalirLayout = new javax.swing.GroupLayout(jPanelSalir);
        jPanelSalir.setLayout(jPanelSalirLayout);
        jPanelSalirLayout.setHorizontalGroup(
            jPanelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSalirLayout.setVerticalGroup(
            jPanelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelSalir))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelModo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanelCorte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelCMPLX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelMatrix, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelCientifica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelConvercion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelModo)
                .addGap(18, 18, 18)
                .addComponent(jPanelCientifica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelConvercion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelMatrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCMPLX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelCientificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCientificaMouseClicked
        setForm(cientifica);
        setSelectedPanel(jPanelCientifica); 
    }//GEN-LAST:event_jPanelCientificaMouseClicked

    private void jPanelCientificaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCientificaMouseEntered
        if (selectedPanel != jPanelCientifica) {
             jPanelCientifica.setBackground(new java.awt.Color(242, 242, 242));
        }
    }//GEN-LAST:event_jPanelCientificaMouseEntered

    private void jPanelCientificaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCientificaMouseExited
        if (selectedPanel != jPanelCientifica) {
             jPanelCientifica.setBackground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_jPanelCientificaMouseExited

    private void jPanelConvercionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelConvercionMouseClicked
        Convercion convercion = new Convercion();
        setForm(convercion);
        setSelectedPanel(jPanelConvercion);
        
    }//GEN-LAST:event_jPanelConvercionMouseClicked

    private void jPanelConvercionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelConvercionMouseEntered
        if (selectedPanel != jPanelConvercion) {
             jPanelConvercion.setBackground(new java.awt.Color(242, 242, 242));
        }
    }//GEN-LAST:event_jPanelConvercionMouseEntered

    private void jPanelConvercionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelConvercionMouseExited
        if (selectedPanel != jPanelConvercion) {
             jPanelConvercion.setBackground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_jPanelConvercionMouseExited

    private void jPanelMatrixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrixMouseClicked
        Matrix matrix = new Matrix();
        setForm(matrix);
        setSelectedPanel(jPanelMatrix);
    }//GEN-LAST:event_jPanelMatrixMouseClicked

    private void jPanelMatrixMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrixMouseEntered
        if (selectedPanel != jPanelMatrix) {
             jPanelMatrix.setBackground(new java.awt.Color(242, 242, 242));
        }
    }//GEN-LAST:event_jPanelMatrixMouseEntered

    private void jPanelMatrixMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrixMouseExited
        if (selectedPanel != jPanelMatrix) {
             jPanelMatrix.setBackground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_jPanelMatrixMouseExited

    private void jPanelCMPLXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCMPLXMouseClicked
        CMPLX cmplx = new CMPLX();
        setForm(cmplx);
        setSelectedPanel(jPanelCMPLX);
    }//GEN-LAST:event_jPanelCMPLXMouseClicked

    private void jPanelCMPLXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCMPLXMouseEntered
        if (selectedPanel != jPanelCMPLX) {
             jPanelCMPLX.setBackground(new java.awt.Color(242, 242, 242));
        }
    }//GEN-LAST:event_jPanelCMPLXMouseEntered

    private void jPanelCMPLXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCMPLXMouseExited
        if (selectedPanel != jPanelCMPLX) {
             jPanelCMPLX.setBackground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_jPanelCMPLXMouseExited

    private void jPanelCorteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCorteMouseClicked
        Corte corte = new Corte();
        setForm(corte);
        setSelectedPanel(jPanelCorte);
    }//GEN-LAST:event_jPanelCorteMouseClicked

    private void jPanelCorteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCorteMouseEntered
        if (selectedPanel != jPanelCorte) {
             jPanelCorte.setBackground(new java.awt.Color(242, 242, 242));
        }
    }//GEN-LAST:event_jPanelCorteMouseEntered

    private void jPanelCorteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCorteMouseExited
         if (selectedPanel != jPanelCorte) {
             jPanelCorte.setBackground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_jPanelCorteMouseExited

    private void jPanelSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanelSalirMouseClicked

    private void jPanelSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSalirMouseEntered
        jPanelSalir.setBackground(new java.awt.Color(255,51,0));
    }//GEN-LAST:event_jPanelSalirMouseEntered

    private void jPanelSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSalirMouseExited
        jPanelSalir.setBackground(new java.awt.Color(255,105,98));
    }//GEN-LAST:event_jPanelSalirMouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCMPLX;
    private javax.swing.JLabel jLabelCalculadora;
    private javax.swing.JLabel jLabelConvercion;
    private javax.swing.JLabel jLabelCorte;
    private javax.swing.JLabel jLabelMatrix;
    private javax.swing.JLabel jLabelModo;
    private javax.swing.JLabel jLabelModo1;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelCMPLX;
    private javax.swing.JPanel jPanelCientifica;
    private javax.swing.JPanel jPanelConvercion;
    private javax.swing.JPanel jPanelCorte;
    private javax.swing.JPanel jPanelMatrix;
    private javax.swing.JPanel jPanelSalir;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
