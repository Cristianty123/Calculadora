package calculadora.vista.mode;

import calculadora.controlador.CalculadoraControlador;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica.Modo;
import javax.swing.DefaultListModel;

public class Cientifica extends javax.swing.JPanel {
    
    private CalculadoraControlador controlador;
    private DefaultListModel<String> historialModel = new DefaultListModel();
    private boolean igual = false;

    public Cientifica(CalculadoraControlador controlador) {
        this.controlador = controlador;
        initComponents();
        historial.setModel(historialModel);
        historialModel.addElement("No hay historial todavía");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        operaciones = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        historial = new javax.swing.JList<>();
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
        botonLogaritmo = new javax.swing.JButton();
        botonLogaritmoNatural = new javax.swing.JButton();
        botonElevarCuadrado = new javax.swing.JButton();
        botonElevarCualquierNumero = new javax.swing.JButton();
        botonEliminarTodo = new javax.swing.JButton();
        botonAbrirParentesis = new javax.swing.JButton();
        botonCerrarParentesis = new javax.swing.JButton();
        botonCambiarNegativoPositivo = new javax.swing.JButton();
        botonRaizCuadrada = new javax.swing.JButton();
        botonCualquierRaiz = new javax.swing.JButton();
        botonEuler = new javax.swing.JButton();
        botonPi = new javax.swing.JButton();
        botonSeno = new javax.swing.JButton();
        botonCoseno = new javax.swing.JButton();
        botonTangente = new javax.swing.JButton();
        botonArcSeno = new javax.swing.JButton();
        botonArcCos = new javax.swing.JButton();
        botonArcTan = new javax.swing.JButton();
        botonCotangente = new javax.swing.JButton();
        botonSecante = new javax.swing.JButton();
        botonCosecante = new javax.swing.JButton();
        botonMod = new javax.swing.JButton();
        botonModoDegORad = new javax.swing.JButton();
        botonVariableX = new javax.swing.JButton();
        botonVariableY = new javax.swing.JButton();
        botonVariableZ = new javax.swing.JButton();
        botonPorcentaje = new javax.swing.JButton();
        jLabelHistorial = new javax.swing.JLabel();
        vistaOperaciones = new javax.swing.JTextField();

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

        historial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(historial);

        boton0.setText("0");
        boton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton0ActionPerformed(evt);
            }
        });

        boton1.setText("1");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setText("2");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.setText("3");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        botonAns.setText("Ans");
        botonAns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnsActionPerformed(evt);
            }
        });

        botonComa.setText(",");
        botonComa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComaActionPerformed(evt);
            }
        });

        botonIgual.setText("=");
        botonIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIgualActionPerformed(evt);
            }
        });

        botonSumar.setText("+");
        botonSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSumarActionPerformed(evt);
            }
        });

        boton4.setText("4");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        boton5.setText("5");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });

        boton6.setText("6");
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });

        boton7.setText("7");
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });

        boton8.setText("8");
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });

        boton9.setText("9");
        boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton9ActionPerformed(evt);
            }
        });

        botonMultiplicar.setText("x");
        botonMultiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMultiplicarActionPerformed(evt);
            }
        });

        botonDividir.setText("÷");
        botonDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDividirActionPerformed(evt);
            }
        });

        botonRestar.setText("-");
        botonRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(255, 51, 0));
        botonEliminar.setText("DEL");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonLogaritmo.setText("Log");
        botonLogaritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLogaritmoActionPerformed(evt);
            }
        });

        botonLogaritmoNatural.setText("Ln");
        botonLogaritmoNatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLogaritmoNaturalActionPerformed(evt);
            }
        });

        botonElevarCuadrado.setText("x^2");
        botonElevarCuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonElevarCuadradoActionPerformed(evt);
            }
        });

        botonElevarCualquierNumero.setText("x^y");
        botonElevarCualquierNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonElevarCualquierNumeroActionPerformed(evt);
            }
        });

        botonEliminarTodo.setBackground(new java.awt.Color(255, 51, 0));
        botonEliminarTodo.setText("AC");
        botonEliminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarTodoActionPerformed(evt);
            }
        });

        botonAbrirParentesis.setText("(");
        botonAbrirParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirParentesisActionPerformed(evt);
            }
        });

        botonCerrarParentesis.setText(")");
        botonCerrarParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarParentesisActionPerformed(evt);
            }
        });

        botonCambiarNegativoPositivo.setText("+/-");
        botonCambiarNegativoPositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarNegativoPositivoActionPerformed(evt);
            }
        });

        botonRaizCuadrada.setText("√x");
        botonRaizCuadrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRaizCuadradaActionPerformed(evt);
            }
        });

        botonCualquierRaiz.setText("y√x");
        botonCualquierRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCualquierRaizActionPerformed(evt);
            }
        });

        botonEuler.setText("e");
        botonEuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEulerActionPerformed(evt);
            }
        });

        botonPi.setText("π");
        botonPi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPiActionPerformed(evt);
            }
        });

        botonSeno.setText("Sen(θ)");
        botonSeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSenoActionPerformed(evt);
            }
        });

        botonCoseno.setText("Cos(θ)");
        botonCoseno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCosenoActionPerformed(evt);
            }
        });

        botonTangente.setText("Tan(θ)");
        botonTangente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTangenteActionPerformed(evt);
            }
        });

        botonArcSeno.setText("ArcSen(x)");
        botonArcSeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonArcSenoActionPerformed(evt);
            }
        });

        botonArcCos.setText("ArcCos(x)");
        botonArcCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonArcCosActionPerformed(evt);
            }
        });

        botonArcTan.setText("ArcTan(x)");
        botonArcTan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonArcTanActionPerformed(evt);
            }
        });

        botonCotangente.setText("CoTan(θ)");
        botonCotangente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCotangenteActionPerformed(evt);
            }
        });

        botonSecante.setText("Sec(θ)");
        botonSecante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSecanteActionPerformed(evt);
            }
        });

        botonCosecante.setText("CoSec(θ)");
        botonCosecante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCosecanteActionPerformed(evt);
            }
        });

        botonMod.setText("Mod");
        botonMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModActionPerformed(evt);
            }
        });

        botonModoDegORad.setText("Deg");
        botonModoDegORad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModoDegORadActionPerformed(evt);
            }
        });

        botonVariableX.setText("X");
        botonVariableX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVariableXActionPerformed(evt);
            }
        });

        botonVariableY.setText("Y");
        botonVariableY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVariableYActionPerformed(evt);
            }
        });

        botonVariableZ.setText("Z");
        botonVariableZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVariableZActionPerformed(evt);
            }
        });

        botonPorcentaje.setText("%");
        botonPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPorcentajeActionPerformed(evt);
            }
        });

        jLabelHistorial.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelHistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHistorial.setText("Historial");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vistaOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonVariableX, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonVariableY, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonVariableZ, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonModoDegORad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonArcSeno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonArcCos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonArcTan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonMod, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonCosecante, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonSeno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonCoseno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonTangente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonCotangente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonSecante, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonCualquierRaiz, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonEuler, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonPi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonEliminarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonRaizCuadrada, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonAbrirParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonCerrarParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonCambiarNegativoPositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonRestar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonElevarCualquierNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonMultiplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonElevarCuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonDividir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonLogaritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonSumar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonLogaritmoNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonComa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(boton0, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonAns, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botonIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vistaOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonVariableX, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVariableY, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVariableZ, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModoDegORad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonArcSeno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonArcCos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonArcTan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMod, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCosecante, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSeno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCoseno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonTangente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCotangente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSecante, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCualquierRaiz, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEuler, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRaizCuadrada, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAbrirParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCerrarParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCambiarNegativoPositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRestar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonElevarCualquierNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMultiplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonElevarCuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDividir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonLogaritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSumar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonLogaritmoNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonComa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton0, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAns, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabelHistorial)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
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
            }
            else if (!testoOperaciones.equals("0")) {
                operaciones.setText(testoOperaciones + "0");
            }
        }
    }//GEN-LAST:event_boton0ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("1");
                
            }else if(igual == true){
                operaciones.setText("1");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "1");
            }
        }
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("2");
                
            }else if(igual == true){
                operaciones.setText("2");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "2");
            }
        }
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("3");
                
            }else if(igual == true){
                operaciones.setText("3");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "3");
            }
        }
    }//GEN-LAST:event_boton3ActionPerformed

    private void botonAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnsActionPerformed
        // TODO add your handling code here:
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
        String textoVistaOperaciones = vistaOperaciones.getText();
        String textoOperaciones = operaciones.getText();
        
        String operacion = textoVistaOperaciones + textoOperaciones;
        String resultado = String.valueOf(controlador.calcularOperacion(operacion));
        
        operaciones.setText(resultado);
        vistaOperaciones.setText(operacion + " = " + resultado);
        
        if (historialModel.getSize() == 1 && historialModel.getElementAt(0).equals("No hay historial todavía")) {
            historialModel.removeAllElements();
        }
        historialModel.addElement(operacion + " = " + resultado);
        
        igual = true;
    }//GEN-LAST:event_botonIgualActionPerformed

    private void botonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumarActionPerformed
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(!textoOperaciones.equals("0") && igual == false){
           // Eliminar los ceros después de la coma si existen
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " + ");
        
           operaciones.setText("0");
        }
    }//GEN-LAST:event_botonSumarActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("4");
                
            }else if(igual == true){
                operaciones.setText("4");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "4");
            }
        }
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("5");
                
            }else if(igual == true){
                operaciones.setText("5");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "5");
            }
        }
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("6");
                
            }else if(igual == true){
                operaciones.setText("6");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "6");
            }
        }
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("7");
                
            }else if(igual == true){
                operaciones.setText("7");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "7");
            }
        }
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("8");
                
            }else if(igual == true){
                operaciones.setText("8");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "8");
            }
        }
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
        String testoOperaciones = operaciones.getText();
        if(testoOperaciones.length() != 40){
            if(testoOperaciones.equals("0")){
                operaciones.setText("9");
                
            }else if(igual == true){
                operaciones.setText("9");
                vistaOperaciones.setText("");
                igual = false;
            }else{
                operaciones.setText(testoOperaciones + "9");
            }
        }
    }//GEN-LAST:event_boton9ActionPerformed

    private void botonMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMultiplicarActionPerformed
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(!textoOperaciones.equals("0")){
           // Eliminar los ceros después de la coma si existen
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " x ");
        
           operaciones.setText("0");
        }
    }//GEN-LAST:event_botonMultiplicarActionPerformed

    private void botonDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDividirActionPerformed
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(!textoOperaciones.equals("0")&& igual == false){
           // Eliminar los ceros después de la coma si existen
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " ÷ ");
        
           operaciones.setText("0");
        }
    }//GEN-LAST:event_botonDividirActionPerformed

    private void botonRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestarActionPerformed
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(!textoOperaciones.equals("0")&& igual == false){
           // Eliminar los ceros después de la coma si existen
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " - ");
        
           operaciones.setText("0");
        }
    }//GEN-LAST:event_botonRestarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        String textoOperaciones = operaciones.getText();
        
        if(textoOperaciones.length()== 1){
            operaciones.setText("0");
        }else{
            operaciones.setText(textoOperaciones.substring(0,textoOperaciones.length()-1));
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonLogaritmoNaturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLogaritmoNaturalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLogaritmoNaturalActionPerformed

    private void botonLogaritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLogaritmoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLogaritmoActionPerformed

    private void botonElevarCuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonElevarCuadradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonElevarCuadradoActionPerformed

    private void botonElevarCualquierNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonElevarCualquierNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonElevarCualquierNumeroActionPerformed

    private void botonEliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarTodoActionPerformed
        if(operaciones.getText().equals("0")){
            vistaOperaciones.setText("");
        }
        operaciones.setText("0");
    }//GEN-LAST:event_botonEliminarTodoActionPerformed

    private void botonAbrirParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirParentesisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAbrirParentesisActionPerformed

    private void botonCerrarParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarParentesisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCerrarParentesisActionPerformed

    private void botonCambiarNegativoPositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarNegativoPositivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCambiarNegativoPositivoActionPerformed

    private void botonRaizCuadradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRaizCuadradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRaizCuadradaActionPerformed

    private void botonCualquierRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCualquierRaizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCualquierRaizActionPerformed

    private void botonEulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEulerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEulerActionPerformed

    private void botonPiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonPiActionPerformed

    private void botonSenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSenoActionPerformed

    private void botonCosenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCosenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCosenoActionPerformed

    private void botonTangenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTangenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTangenteActionPerformed

    private void botonArcSenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonArcSenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonArcSenoActionPerformed

    private void botonArcCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonArcCosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonArcCosActionPerformed

    private void botonArcTanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonArcTanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonArcTanActionPerformed

    private void botonCotangenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCotangenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCotangenteActionPerformed

    private void botonSecanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSecanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSecanteActionPerformed

    private void botonCosecanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCosecanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCosecanteActionPerformed

    private void botonModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonModActionPerformed

    private void botonModoDegORadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModoDegORadActionPerformed
        String textoBoton = botonModoDegORad.getText();
    
    // Verificar el texto actual y cambiar el modo y el texto del botón en consecuencia
    if (textoBoton.equals("Deg")) {
        controlador.cambiarModoFuncionTrigonometrica(Modo.RADIANES);
        botonModoDegORad.setText("Rad");
    } else if (textoBoton.equals("Rad")) {
        controlador.cambiarModoFuncionTrigonometrica(Modo.DEG);
        botonModoDegORad.setText("Deg");
    }
    }//GEN-LAST:event_botonModoDegORadActionPerformed

    private void botonVariableXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVariableXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVariableXActionPerformed

    private void botonVariableYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVariableYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVariableYActionPerformed

    private void botonVariableZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVariableZActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVariableZActionPerformed

    private void botonPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPorcentajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonPorcentajeActionPerformed

    private void vistaOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaOperacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vistaOperacionesActionPerformed


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
    private javax.swing.JButton botonArcCos;
    private javax.swing.JButton botonArcSeno;
    private javax.swing.JButton botonArcTan;
    private javax.swing.JButton botonCambiarNegativoPositivo;
    private javax.swing.JButton botonCerrarParentesis;
    private javax.swing.JButton botonComa;
    private javax.swing.JButton botonCosecante;
    private javax.swing.JButton botonCoseno;
    private javax.swing.JButton botonCotangente;
    private javax.swing.JButton botonCualquierRaiz;
    private javax.swing.JButton botonDividir;
    private javax.swing.JButton botonElevarCuadrado;
    private javax.swing.JButton botonElevarCualquierNumero;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEliminarTodo;
    private javax.swing.JButton botonEuler;
    private javax.swing.JButton botonIgual;
    private javax.swing.JButton botonLogaritmo;
    private javax.swing.JButton botonLogaritmoNatural;
    private javax.swing.JButton botonMod;
    private javax.swing.JButton botonModoDegORad;
    private javax.swing.JButton botonMultiplicar;
    private javax.swing.JButton botonPi;
    private javax.swing.JButton botonPorcentaje;
    private javax.swing.JButton botonRaizCuadrada;
    private javax.swing.JButton botonRestar;
    private javax.swing.JButton botonSecante;
    private javax.swing.JButton botonSeno;
    private javax.swing.JButton botonSumar;
    private javax.swing.JButton botonTangente;
    private javax.swing.JButton botonVariableX;
    private javax.swing.JButton botonVariableY;
    private javax.swing.JButton botonVariableZ;
    private javax.swing.JList<String> historial;
    private javax.swing.JLabel jLabelHistorial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField operaciones;
    private javax.swing.JTextField vistaOperaciones;
    // End of variables declaration//GEN-END:variables
}
