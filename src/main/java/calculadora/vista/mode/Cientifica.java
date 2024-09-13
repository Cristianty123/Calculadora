package calculadora.vista.mode;

import calculadora.controlador.CalculadoraControlador;
import calculadora.vista.component.MyList;
import java.awt.Color;
import javax.swing.DefaultListModel;

public class Cientifica extends javax.swing.JPanel {
    
    private final CalculadoraControlador controlador;
    private final DefaultListModel<String> historialModel;
    private final MyList<String> list;
    private boolean igual = true;
    private boolean operacionBolean = false;
    private boolean operador = false;
    private boolean parentesis = false;
    private int contadorParentesis = 0;
    private String numeroAnterior = "0";

    public Cientifica(CalculadoraControlador controlador) {
        this.controlador = controlador;
        list = new MyList<>();
        historialModel = new DefaultListModel();
        list.setModel(historialModel);
        initComponents();
        init();
        
    }
    private void init(){
        jScrollPane1.setViewportView(list);
        jScrollPane1.setVisible(false);
        jLabelBorrarTodo.setVisible(false);
    }
    private String eliminarCerosDespuesComa(String texto) {
        int indexComa = texto.indexOf(",");
        if (indexComa != -1) {
           // Verificar si solo hay ceros o no hay nada después de la coma
            boolean soloCerosDespuesComa = true;
            for (int i = indexComa + 1; i < texto.length(); i++) {
                if (texto.charAt(i) != '0') {
                     soloCerosDespuesComa = false;
                    break;
                }
            }
        // Si solo hay ceros o no hay nada después de la coma, eliminarlos
            if (soloCerosDespuesComa) {
                return texto.substring(0, indexComa);
            }
        }
        return texto;
    }
    private int encontrarPosicionInsercion(String textoVistaOperaciones) {
    for (int i = textoVistaOperaciones.length() - 1; i >= 0; i--) {
        char c = textoVistaOperaciones.charAt(i);
        if (c == ' ' || (c == '(' && (i == 0 || textoVistaOperaciones.charAt(i - 1) == ' '))) {
            return i + 1;
        }
    }
    return 0; // Si no se encuentra espacio o paréntesis, insertar al principio
    }
    private void manejarOperacion(String operacion) {
       String textoOperaciones = operaciones.getText();
       String textoVistaOperaciones = vistaOperaciones.getText();

       if (!igual && !operacionBolean) {
           // Eliminar los ceros después de la coma si existen
           try {
               textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
               String textoMostrar = String.valueOf(controlador.calcularOperacion(operacion + "(" + textoOperaciones + ")"));
               textoMostrar = textoMostrar.replace(".", ",");
               operaciones.setText(textoMostrar);
               vistaOperaciones.setText(textoVistaOperaciones + operacion + "(" + textoOperaciones + ")");
            } catch (ArithmeticException e) {
                operaciones.setText(e.getMessage());
                igual = true;
            }
        operacionBolean = true;
        operador = false;
        } else if (operacionBolean && !igual) {
            int posicionInsercion = encontrarPosicionInsercion(textoVistaOperaciones);
            String nuevoTextoVistaOperaciones = textoVistaOperaciones.substring(0, posicionInsercion) + operacion + "(" + textoVistaOperaciones.substring(posicionInsercion) + ")";
            vistaOperaciones.setText(nuevoTextoVistaOperaciones);
        }
    }
    private void botonNumeroActionPerformed(java.awt.event.ActionEvent evt, String numero) {
    String textoOperaciones = operaciones.getText();
    if (textoOperaciones.length() != 40) {
        if (textoOperaciones.equals("0")) {
            operaciones.setText(numero);
            igual = false;
            operador = false;
        } else if (igual == true) {
            operaciones.setText(numero);
            vistaOperaciones.setText("");
            igual = false;
            operacionBolean = false;
            
        } else if (operador == true) {
            operaciones.setText(numero);
            operador = false;
        } else {
            operaciones.setText(textoOperaciones + numero);
        }
        parentesis = false;
    } 
}
    private void igualarActionPerformed(java.awt.event.ActionEvent evt){
        String textoVistaOperaciones = vistaOperaciones.getText();
        String textoOperaciones = operaciones.getText();
        
        if(igual == false){
        String operacion = "";
        if(operacionBolean == true){
          operacion = textoVistaOperaciones;  
        }else{
          if(textoVistaOperaciones.endsWith(")")){
              operacion = textoVistaOperaciones;
          }else{
              operacion = textoVistaOperaciones + textoOperaciones;
          }
        }
        try {
           while(contadorParentesis != 0){
               operacion = operacion + ")";
               contadorParentesis--;
           }
           String resultado = String.valueOf(controlador.calcularOperacion(operacion));
           resultado = resultado.replace(".",",");
           System.out.println("pase2");
        
           operaciones.setText(resultado);
           System.out.println("pase3");
           vistaOperaciones.setText(operacion + " = " + resultado);
           System.out.println("pase4");
           list.addItem(operacion + " = " + resultado);
           numeroAnterior = resultado;
        } catch (ArithmeticException e) {
            operaciones.setText(e.getMessage());
        }
    
        igual = true;
        operador = false;
        contadorParentesis = 0;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBorrarTodo = new javax.swing.JLabel();
        operaciones = new javax.swing.JTextField();
        jScrollPane1 = new calculadora.vista.component.ScrollPaneWin11();
        historial = new calculadora.vista.component.MyList<>();
        boton0 = new javax.swing.JButton();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        botonAns = new javax.swing.JButton();
        botonComa = new javax.swing.JButton();
        botonIgual = new javax.swing.JButton();
        botonSumar = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        boton7 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();
        boton9 = new javax.swing.JButton();
        botonMultiplicar = new javax.swing.JButton();
        botonDividir = new javax.swing.JButton();
        botonRestar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonEliminarTodo = new javax.swing.JButton();
        botonAbrirParentesis = new javax.swing.JButton();
        botonCerrarParentesis = new javax.swing.JButton();
        botonCambiarNegativoPositivo = new javax.swing.JButton();
        botonEuler = new javax.swing.JButton();
        botonPi = new javax.swing.JButton();
        botonHistorial = new javax.swing.JLabel();
        vistaOperaciones = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBorrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_red.png"))); // NOI18N
        jLabelBorrarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBorrarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBorrarTodoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBorrarTodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBorrarTodoMouseExited(evt);
            }
        });
        add(jLabelBorrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, -1));
        jLabelBorrarTodo.getAccessibleContext().setAccessibleName("");

        operaciones.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        operaciones.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        operaciones.setText("0");
        operaciones.setBorder(null);
        operaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        operaciones.setFocusable(false);
        operaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacionesActionPerformed(evt);
            }
        });
        add(operaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 42, 275, 52));

        historial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(historial);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 320, 310));

        boton0.setBackground(new java.awt.Color(204, 204, 204));
        boton0.setText("0");
        boton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton0ActionPerformed(evt);
            }
        });
        add(boton0, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 357, 60, 40));

        boton1.setBackground(new java.awt.Color(204, 204, 204));
        boton1.setText("1");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 311, 60, 40));

        boton2.setBackground(new java.awt.Color(204, 204, 204));
        boton2.setText("2");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 311, 60, 40));

        boton3.setBackground(new java.awt.Color(204, 204, 204));
        boton3.setText("3");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        add(boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 311, 60, 40));

        botonAns.setBackground(new java.awt.Color(204, 204, 204));
        botonAns.setText("Ans");
        botonAns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnsActionPerformed(evt);
            }
        });
        add(botonAns, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 357, 60, 40));

        botonComa.setBackground(new java.awt.Color(204, 204, 204));
        botonComa.setText(",");
        botonComa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComaActionPerformed(evt);
            }
        });
        add(botonComa, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 357, 60, 40));

        botonIgual.setBackground(new java.awt.Color(131, 169, 192));
        botonIgual.setText("=");
        botonIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIgualActionPerformed(evt);
            }
        });
        add(botonIgual, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 357, 60, 40));

        botonSumar.setBackground(new java.awt.Color(204, 204, 204));
        botonSumar.setText("+");
        botonSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSumarActionPerformed(evt);
            }
        });
        add(botonSumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 311, 60, 40));

        boton4.setBackground(new java.awt.Color(204, 204, 204));
        boton4.setText("4");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });
        add(boton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 265, 60, 40));

        boton5.setBackground(new java.awt.Color(204, 204, 204));
        boton5.setText("5");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });
        add(boton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 265, 60, 40));

        boton6.setBackground(new java.awt.Color(204, 204, 204));
        boton6.setText("6");
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });
        add(boton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 265, 60, 40));

        boton7.setBackground(new java.awt.Color(204, 204, 204));
        boton7.setText("7");
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });
        add(boton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 219, 60, 40));

        boton8.setBackground(new java.awt.Color(204, 204, 204));
        boton8.setText("8");
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });
        add(boton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 219, 60, 40));

        boton9.setBackground(new java.awt.Color(204, 204, 204));
        boton9.setText("9");
        boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton9ActionPerformed(evt);
            }
        });
        add(boton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 219, 60, 40));

        botonMultiplicar.setBackground(new java.awt.Color(204, 204, 204));
        botonMultiplicar.setText("x");
        botonMultiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMultiplicarActionPerformed(evt);
            }
        });
        add(botonMultiplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 219, 60, 40));

        botonDividir.setBackground(new java.awt.Color(204, 204, 204));
        botonDividir.setText("÷");
        botonDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDividirActionPerformed(evt);
            }
        });
        add(botonDividir, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 265, 60, 40));

        botonRestar.setBackground(new java.awt.Color(204, 204, 204));
        botonRestar.setText("-");
        botonRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestarActionPerformed(evt);
            }
        });
        add(botonRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 173, 60, 40));

        botonEliminar.setBackground(new java.awt.Color(255, 105, 98));
        botonEliminar.setText("DEL");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 127, 60, 40));

        botonEliminarTodo.setBackground(new java.awt.Color(255, 105, 98));
        botonEliminarTodo.setText("AC");
        botonEliminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarTodoActionPerformed(evt);
            }
        });
        add(botonEliminarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 127, 60, 40));

        botonAbrirParentesis.setBackground(new java.awt.Color(204, 204, 204));
        botonAbrirParentesis.setText("(");
        botonAbrirParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirParentesisActionPerformed(evt);
            }
        });
        add(botonAbrirParentesis, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 173, 60, 40));

        botonCerrarParentesis.setBackground(new java.awt.Color(204, 204, 204));
        botonCerrarParentesis.setText(")");
        botonCerrarParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarParentesisActionPerformed(evt);
            }
        });
        add(botonCerrarParentesis, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 173, 60, 40));

        botonCambiarNegativoPositivo.setBackground(new java.awt.Color(204, 204, 204));
        botonCambiarNegativoPositivo.setText("+/-");
        botonCambiarNegativoPositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarNegativoPositivoActionPerformed(evt);
            }
        });
        add(botonCambiarNegativoPositivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 173, 60, 40));

        botonEuler.setBackground(new java.awt.Color(204, 204, 204));
        botonEuler.setText("e");
        botonEuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEulerActionPerformed(evt);
            }
        });
        add(botonEuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 127, 60, 40));

        botonPi.setBackground(new java.awt.Color(204, 204, 204));
        botonPi.setText("π");
        botonPi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPiActionPerformed(evt);
            }
        });
        add(botonPi, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 127, 60, 40));

        botonHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/historial_2.png"))); // NOI18N
        botonHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonHistorialMouseClicked(evt);
            }
        });
        add(botonHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 16, 16));

        vistaOperaciones.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        vistaOperaciones.setForeground(new java.awt.Color(153, 153, 153));
        vistaOperaciones.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        vistaOperaciones.setBorder(null);
        vistaOperaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vistaOperaciones.setFocusable(false);
        vistaOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaOperacionesActionPerformed(evt);
            }
        });
        add(vistaOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 26, 275, 24));
    }// </editor-fold>//GEN-END:initComponents

    private void operacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_operacionesActionPerformed

    private void boton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton0ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if (igual == true){
                operaciones.setText("0");
                vistaOperaciones.setText("");
                igual = false;
                operacionBolean = false;
                
            }else if(operador == true){
                operaciones.setText("0");
                operador = false;
            }else if (!testoOperaciones.equals("0")) {
                operaciones.setText(testoOperaciones + "0");
                
            }
        }
        System.out.println("cero");
        System.out.println(operador);
    }//GEN-LAST:event_boton0ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        botonNumeroActionPerformed(evt, "1");
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        botonNumeroActionPerformed(evt, "2");
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        botonNumeroActionPerformed(evt, "3");
    }//GEN-LAST:event_boton3ActionPerformed

    private void botonAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnsActionPerformed
        operaciones.setText("0");
        botonNumeroActionPerformed(evt, numeroAnterior);
    }//GEN-LAST:event_botonAnsActionPerformed

    private void botonComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComaActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(igual == true){
                operaciones.setText("0" + ",");
                vistaOperaciones.setText("");
                igual = false;
            }else if(!testoOperaciones.contains(",")){
               operaciones.setText(testoOperaciones + ",");
            }
        }  
    }//GEN-LAST:event_botonComaActionPerformed

    private void botonIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIgualActionPerformed
        igualarActionPerformed(evt);
    }//GEN-LAST:event_botonIgualActionPerformed

    private void botonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumarActionPerformed
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(igual == true){
            vistaOperaciones.setText(numeroAnterior + " + ");
            operaciones.setText("0");
            operacionBolean = false;
        }
        if(!textoOperaciones.equals("0") && igual == false && operador == false){
           // Eliminar los ceros después de la coma si existen
           if(operacionBolean == true){
               vistaOperaciones.setText(textoVistaOperaciones  + " + ");
               operacionBolean = false;
           }else if(textoVistaOperaciones.endsWith(")")){
               vistaOperaciones.setText(textoVistaOperaciones  + " + ");
           }else{
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " + ");
           }
           operador = true;
        }else if(textoOperaciones.equals("0") && operador == false && !textoVistaOperaciones.isEmpty()){
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " + ");
           operador = true;
        }else if(operador == true && textoVistaOperaciones.endsWith(" - ")){
            String nuevoTextoVistaOperaciones = textoVistaOperaciones.substring(0, textoVistaOperaciones.length() - 2) + "+ ";
            vistaOperaciones.setText(nuevoTextoVistaOperaciones);
        }
    }//GEN-LAST:event_botonSumarActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        botonNumeroActionPerformed(evt, "4");
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        botonNumeroActionPerformed(evt, "5");
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        botonNumeroActionPerformed(evt, "6");
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        botonNumeroActionPerformed(evt, "7");
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        botonNumeroActionPerformed(evt, "8");
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
        botonNumeroActionPerformed(evt, "9");
    }//GEN-LAST:event_boton9ActionPerformed

    private void botonMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMultiplicarActionPerformed
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(igual == true){
            vistaOperaciones.setText(numeroAnterior + " x ");
            operaciones.setText("0");
            operacionBolean = false;
        }
        
        if(!textoOperaciones.equals("0")&& igual == false && operador == false){
            if(operacionBolean == true){
               vistaOperaciones.setText(textoVistaOperaciones  + " x ");
               operacionBolean = false;
           }else if(textoVistaOperaciones.endsWith(")")){
               vistaOperaciones.setText(textoVistaOperaciones  + " x ");
           }else{
           // Eliminar los ceros después de la coma si existen
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " x ");
           }
           operador = true;
        }else if(textoOperaciones.equals("0") && operador == false && !textoVistaOperaciones.isEmpty()){
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " x ");
           operador = true;
        }
    }//GEN-LAST:event_botonMultiplicarActionPerformed

    private void botonDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDividirActionPerformed
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(igual == true){
            vistaOperaciones.setText(numeroAnterior + " ÷ ");
            operaciones.setText("0");
            operacionBolean = false;
        }
        if(!textoOperaciones.equals("0")&& igual == false && operador == false){
            if(operacionBolean == true){
               vistaOperaciones.setText(textoVistaOperaciones  + " ÷ ");
               operacionBolean = false;
           }else if(textoVistaOperaciones.endsWith(")")){
               vistaOperaciones.setText(textoVistaOperaciones  + " ÷ ");
           }else{
           // Eliminar los ceros después de la coma si existen
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " ÷ ");
            }
           operador = true;
        }else if(textoOperaciones.equals("0") && operador == false && !textoVistaOperaciones.isEmpty()){
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " ÷ ");
           operador = true;
        }
    }//GEN-LAST:event_botonDividirActionPerformed

    private void botonRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestarActionPerformed
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(igual == true){
            vistaOperaciones.setText(numeroAnterior + " - ");
            operaciones.setText("0");
            operacionBolean = false;
        }
        
        if(!textoOperaciones.equals("0")&& igual == false && operador == false){
            
            if(operacionBolean == true){
               vistaOperaciones.setText(textoVistaOperaciones  + " - ");
               operacionBolean = false;
           }else if(textoVistaOperaciones.endsWith(")")){
               vistaOperaciones.setText(textoVistaOperaciones  + " - ");
           }else{
           // Eliminar los ceros después de la coma si existen
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " - ");
           }
           operador = true;
        }else if(textoOperaciones.equals("0") && operador == false && !textoVistaOperaciones.isEmpty()){
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " - ");
           operador = true;
        }else if(operador == true && textoVistaOperaciones.endsWith(" + ")){
            String nuevoTextoVistaOperaciones = textoVistaOperaciones.substring(0, textoVistaOperaciones.length() - 2) + "- ";
            vistaOperaciones.setText(nuevoTextoVistaOperaciones);
        }   
    }//GEN-LAST:event_botonRestarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        String textoOperaciones = operaciones.getText();
        
        if(igual == true){
             operaciones.setText("0");
             vistaOperaciones.setText("");
        }
        if(textoOperaciones.length()== 1){
            operaciones.setText("0");
        }else if(textoOperaciones.length() != 1 && !operacionBolean){
            operaciones.setText(textoOperaciones.substring(0,textoOperaciones.length()-1));
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonEliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarTodoActionPerformed
        if(operaciones.getText().equals("0")){
            vistaOperaciones.setText("");
            igual = true;
            operacionBolean = false;
            operador = false;
            contadorParentesis = 0;
        }else if (igual == true){
            vistaOperaciones.setText("");
        }
        if(operacionBolean){
            igualarActionPerformed(evt);
        }else{
        operaciones.setText("0");
        }
    }//GEN-LAST:event_botonEliminarTodoActionPerformed

    private void botonAbrirParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirParentesisActionPerformed
        String textoVistaOperaciones = vistaOperaciones.getText();
String textoOperaciones = operaciones.getText();


if (igual) {
    vistaOperaciones.setText(textoVistaOperaciones + "(");
    contadorParentesis++;
    System.out.println("1");
}else if(igual && textoVistaOperaciones.contains("=")){
    vistaOperaciones.setText("(");
}else {
    if (textoVistaOperaciones.isEmpty()) {
        vistaOperaciones.setText(textoOperaciones + " x (");
        contadorParentesis++;
        parentesis = true;
        operador = true;
        System.out.println("2");
    } else {
        char ultimoCaracter = textoVistaOperaciones.charAt(textoVistaOperaciones.length() - 1);
        System.out.println(ultimoCaracter);
        if (ultimoCaracter == '(' && parentesis) {
            vistaOperaciones.setText(textoVistaOperaciones + "(");
            contadorParentesis++;
            System.out.println("3");
        } else if (operador && ultimoCaracter != '(' && ultimoCaracter != ')') {
            vistaOperaciones.setText(textoVistaOperaciones + "(");
            parentesis = true;
            contadorParentesis++;
            System.out.println("4");
        } else if (ultimoCaracter == ')'){
            vistaOperaciones.setText(textoVistaOperaciones + " x (");
            contadorParentesis++;
            parentesis = true;
            operador = true;
            System.out.println("5");
        }else {
            vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " x (");
            operador = true;
            parentesis = true;
            contadorParentesis++;
            System.out.println("6");
        }
    }
}

    }//GEN-LAST:event_botonAbrirParentesisActionPerformed

    private void botonCerrarParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarParentesisActionPerformed
        if(contadorParentesis != 0){
            String textoVistaOperaciones = vistaOperaciones.getText();
            if(textoVistaOperaciones.endsWith("(") || operador || textoVistaOperaciones.endsWith(" ")){
               vistaOperaciones.setText(textoVistaOperaciones + operaciones.getText() + ")");
               operador = false;
            }else{
               vistaOperaciones.setText(textoVistaOperaciones + ")");
            }
            contadorParentesis--;
        }
    }//GEN-LAST:event_botonCerrarParentesisActionPerformed

    private void botonCambiarNegativoPositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarNegativoPositivoActionPerformed
        String textoOperaciones = operaciones.getText();
        textoOperaciones = textoOperaciones.replace(",", ".");
        
        if(!textoOperaciones.equals("0") && igual == false){
            double numero = Double.parseDouble(textoOperaciones);
            numero = -numero;
            textoOperaciones = String.valueOf(numero);
            textoOperaciones = textoOperaciones.replace(".", ",");
            textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
            operaciones.setText(textoOperaciones);
        }
    }//GEN-LAST:event_botonCambiarNegativoPositivoActionPerformed
        
    private void botonEulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEulerActionPerformed
        String textoVistaOperaciones = vistaOperaciones.getText();

       if (!igual && !operacionBolean ) {
           // Eliminar los ceros después de la coma si existen
           String textoMostrar = String.valueOf(Math.E);
           textoMostrar = textoMostrar.replace(".", ",");
           operaciones.setText(textoMostrar);
           vistaOperaciones.setText(textoVistaOperaciones + "e");
           operacionBolean = true;
           operador = false;
        }else if(!igual && textoVistaOperaciones.endsWith("π")){
            String textoMostrar = String.valueOf(Math.E);
            textoMostrar = textoMostrar.replace(".", ",");
            operaciones.setText(textoMostrar);
            String nuevoTextoVistaOperaciones = textoVistaOperaciones.substring(0,textoVistaOperaciones.length() - 1) + "e";
            vistaOperaciones.setText(nuevoTextoVistaOperaciones);
            operacionBolean = true;
            operador = false;
         }else if(igual == true){
            String textoMostrar = String.valueOf(Math.E);
            textoMostrar = textoMostrar.replace(".", ",");
            operaciones.setText(textoMostrar);
            vistaOperaciones.setText("e");
            igual = false;
            operacionBolean = true;
        }      
    }//GEN-LAST:event_botonEulerActionPerformed

    private void botonPiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPiActionPerformed
        String textoVistaOperaciones = vistaOperaciones.getText();

       if (!igual && !operacionBolean) {
           // Eliminar los ceros después de la coma si existen
           String textoMostrar = String.valueOf(Math.PI);
           textoMostrar = textoMostrar.replace(".", ",");
           operaciones.setText(textoMostrar);
           vistaOperaciones.setText(textoVistaOperaciones + "π");
           operacionBolean = true;
           operador = false;
        }else if(!igual && textoVistaOperaciones.endsWith("e")){
            String textoMostrar = String.valueOf(Math.PI);
            textoMostrar = textoMostrar.replace(".", ",");
            operaciones.setText(textoMostrar);
            String nuevoTextoVistaOperaciones = textoVistaOperaciones.substring(0,textoVistaOperaciones.length() - 1) + "π";
            vistaOperaciones.setText(nuevoTextoVistaOperaciones);
            operacionBolean = true;
            operador = false;
         }else if(igual == true){
            String textoMostrar = String.valueOf(Math.PI);
            textoMostrar = textoMostrar.replace(".", ",");
            operaciones.setText(textoMostrar);
            vistaOperaciones.setText("π");
            igual = false;
            operacionBolean = true;
        } 
    }//GEN-LAST:event_botonPiActionPerformed

    private void vistaOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaOperacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vistaOperacionesActionPerformed

    private void botonHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonHistorialMouseClicked
        if(jScrollPane1.isVisible()){
            jScrollPane1.setVisible(false);
            vistaOperaciones.setBackground(new Color(255,255,255));
            operaciones.setBackground(new Color(255,255,255));
            operaciones.setForeground(new Color(0,0,0));
            jLabelBorrarTodo.setVisible(false);
            this.setBackground(new Color(102, 102, 102));
        }else{
            vistaOperaciones.setBackground(new Color(235,235,235));
            operaciones.setBackground(new Color(235,235,235));
            operaciones.setForeground(new Color(51,51,51));
            this.setBackground(new Color(120, 120, 120));
            jScrollPane1.setVisible(true);
            System.out.println("cantidad de datos " + list.cantidadDatos());
            if(!jLabelBorrarTodo.isVisible() && list.cantidadDatos() > 0){
                jLabelBorrarTodo.setVisible(true);
            }
        }
    }//GEN-LAST:event_botonHistorialMouseClicked

    private void jLabelBorrarTodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBorrarTodoMouseEntered
        jLabelBorrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_disable.png")));
    }//GEN-LAST:event_jLabelBorrarTodoMouseEntered

    private void jLabelBorrarTodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBorrarTodoMouseExited
        jLabelBorrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_red.png")));    
    }//GEN-LAST:event_jLabelBorrarTodoMouseExited

    private void jLabelBorrarTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBorrarTodoMouseClicked
        list.clear();
        jLabelBorrarTodo.setVisible(false);
    }//GEN-LAST:event_jLabelBorrarTodoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton0;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JButton boton9;
    private javax.swing.JButton botonAbrirParentesis;
    private javax.swing.JButton botonAns;
    private javax.swing.JButton botonCambiarNegativoPositivo;
    private javax.swing.JButton botonCerrarParentesis;
    private javax.swing.JButton botonComa;
    private javax.swing.JButton botonDividir;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEliminarTodo;
    private javax.swing.JButton botonEuler;
    private javax.swing.JLabel botonHistorial;
    private javax.swing.JButton botonIgual;
    private javax.swing.JButton botonMultiplicar;
    private javax.swing.JButton botonPi;
    private javax.swing.JButton botonRestar;
    private javax.swing.JButton botonSumar;
    private javax.swing.JList<String> historial;
    private javax.swing.JLabel jLabelBorrarTodo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField operaciones;
    private javax.swing.JTextField vistaOperaciones;
    // End of variables declaration//GEN-END:variables
}
