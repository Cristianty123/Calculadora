package calculadora.vista.mode;

import calculadora.controlador.CalculadoraControlador;
import calculadora.vista.component.MyList;
import calculadora.vista.component.ScrollPaneWin11;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

public class Cientifica extends javax.swing.JPanel {
    
    private final CalculadoraControlador controlador;
    private final DefaultListModel<String> historialModel;
    private final MyList<String> list;
    private boolean igual;
    private boolean operacionBolean;
    private boolean operador;
    private boolean parentesis;
    private int contadorParentesis;
    private String numeroAnterior ;
    private JLabel jLabelBorrarTodo;
    private ScrollPaneWin11 historialScrollPane;
    private boolean isExpanded ;
    private Timer timer;
    private int startY;
    private int endY;
    private KeyListener keyListener;
    private final MatteBorder borderOperaciones, borderVistaOperaciones;
    
    public Cientifica(CalculadoraControlador controlador) {
        this.controlador = controlador;
        contadorParentesis = 0;
        numeroAnterior = "0";
        isExpanded = false;
        historialScrollPane = new ScrollPaneWin11();
        borderOperaciones = new MatteBorder(0, 1, 1, 1, new Color(51,51,51));
        borderVistaOperaciones = new MatteBorder(1, 1, 0, 1, new Color(51,51,51));
        igual = true;
        operacionBolean = false;
        operador = false;
        parentesis = false;
        list = new MyList<>();
        historialModel = new DefaultListModel();
        list.setModel(historialModel);
        initComponents();
        initKeyListener();
        init();
        
    }
    public JLabel getjLabelBorrarTodo(){
        return jLabelBorrarTodo;
    }
    private void initKeyListener(){
        keyListener = new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                ifKeyPressedNumbers(keyChar, e);
                ifOperador(keyChar);
                if(keyChar == '('){
                    botonAbrirParentesisActionPerformed();
                }else if (keyChar == ')'){
                    botonCerrarParentesisActionPerformed();
                }else if(keyChar == ','){
                    botonComaActionPerformed();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                
                if(keyCode == KeyEvent.VK_BACK_SPACE){
                    botonEliminarActionPerformed();
                }
                else if(keyCode == KeyEvent.VK_ENTER){
                    igualarActionPerformed();
                }else if (keyCode == KeyEvent.VK_DELETE){
                    botonEliminarTodoActionPerformed();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        }; 
    }
    private void init(){
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(keyListener);
        list.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jLabelBorrarTodo = new JLabel();
        historialScrollPane = new ScrollPaneWin11();
    
        jLabelBorrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_red.png"))); // NOI18N
        jLabelBorrarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    
        jLabelBorrarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBorrarTodoMouseClicked(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBorrarTodoMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBorrarTodoMouseExited(evt);
            }
        });

        jLayeredPane1.add(jLabelBorrarTodo, JLayeredPane.PALETTE_LAYER);
        jLabelBorrarTodo.setBounds(280, 270, 30, 30);
        jLabelBorrarTodo.getAccessibleContext().setAccessibleName("");
        
        jLayeredPane1.add(historialScrollPane,JLayeredPane.DEFAULT_LAYER);
        //inicio historialScrollPane.setBounds(0, 0, 320, 314);
        historialScrollPane.setBounds(0, 314, 320, 314);
        historialScrollPane.setViewportView(list);
        historialScrollPane.setVisible(true);
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
    private void ifKeyPressedNumbers(char keyCode, KeyEvent e){
        boolean shiftPressed = e.isShiftDown();
        if(!shiftPressed){
            switch (keyCode) {
                case '0' -> boton0ActionPerformed();
                case '1' -> botonNumeroActionPerformed("1");
                case '2' -> botonNumeroActionPerformed("2");
                case '3' -> botonNumeroActionPerformed("3");
                case '4' -> botonNumeroActionPerformed("4");
                case '5' -> botonNumeroActionPerformed("5");
                case '6' -> botonNumeroActionPerformed("6");
                case '7' -> botonNumeroActionPerformed("7");
                case '8' -> botonNumeroActionPerformed("8");
                case '9' -> botonNumeroActionPerformed("9");
                default -> {
                }
            }
        }
    }
    private void ifOperador(char keyChar){
        switch (keyChar) {
            case '+' -> botonSumarActionPerformed();
            case '-' -> botonRestarActionPerformed();
            case '*' -> botonMultiplicarActionPerformed();
            case '/' -> botonDividirActionPerformed();
            default -> {
            }
        }
    }
    private void botonAbrirParentesisActionPerformed(){
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
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void botonCerrarParentesisActionPerformed(){
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
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void botonRestarActionPerformed(){
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
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void botonMultiplicarActionPerformed(){
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
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void botonDividirActionPerformed(){
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(igual == true){
            vistaOperaciones.setText(numeroAnterior + " / ");
            operaciones.setText("0");
            operacionBolean = false;
        }
        if(!textoOperaciones.equals("0")&& igual == false && operador == false){
            if(operacionBolean == true){
               vistaOperaciones.setText(textoVistaOperaciones  + " / ");
               operacionBolean = false;
           }else if(textoVistaOperaciones.endsWith(")")){
               vistaOperaciones.setText(textoVistaOperaciones  + " / ");
           }else{
           // Eliminar los ceros después de la coma si existen
           textoOperaciones = eliminarCerosDespuesComa(textoOperaciones);
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " / ");
            }
           operador = true;
        }else if(textoOperaciones.equals("0") && operador == false && !textoVistaOperaciones.isEmpty()){
           vistaOperaciones.setText(textoVistaOperaciones + textoOperaciones + " / ");
           operador = true;
        }
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void botonComaActionPerformed(){
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
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void boton0ActionPerformed(){
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        char ultimoCaracter = ' ';
        if(!textoVistaOperaciones.isEmpty()){
            ultimoCaracter = textoVistaOperaciones.charAt(textoVistaOperaciones.length() - 1); 
        }
        if(textoOperaciones.length() != 40){
            if (igual == true){
                operaciones.setText("0");
                vistaOperaciones.setText("");
                igual = false;
                operacionBolean = false;
                
            }else if(operador == true){
                operaciones.setText("0");
                operador = false;
            }else if (operador != true && ultimoCaracter == ')'){
                operaciones.setText("0");
                vistaOperaciones.setText(textoVistaOperaciones + " x ");
                operador = false;
            }else if (!textoOperaciones.equals("0")) {
                operaciones.setText(textoOperaciones + "0");
                
            }
        }
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void botonNumeroActionPerformed(String numero) {
    String textoOperaciones = operaciones.getText();
    String textoVistaOperaciones = vistaOperaciones.getText();
    char ultimoCaracter = ' ';
    if(!textoVistaOperaciones.isEmpty()){
        ultimoCaracter = textoVistaOperaciones.charAt(textoVistaOperaciones.length() - 1); 
    }
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
        }else if (operador != true && ultimoCaracter == ')'){
                operaciones.setText(numero);
                vistaOperaciones.setText(textoVistaOperaciones + " x ");
                operador = false; 
        }else {
            operaciones.setText(textoOperaciones + numero);
        }
        parentesis = false;
    }
    this.setFocusable(true);
    this.requestFocusInWindow();
}
    private void igualarActionPerformed(){
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
           
           operaciones.setText(resultado);
           vistaOperaciones.setText(operacion + " = " + resultado);
           list.addItem(operacion + " = " + resultado);
           numeroAnterior = resultado;
        } catch (ArithmeticException e) {
            operaciones.setText(e.getMessage());
        }
    
        igual = true;
        operador = false;
        contadorParentesis = 0;
        }
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        operaciones = new javax.swing.JTextField();
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
        add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 320, 310));

        operaciones.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        operaciones.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        operaciones.setText("0");
        operaciones.setBorder(borderOperaciones);
        operaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        operaciones.setFocusable(false);
        operaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacionesActionPerformed(evt);
            }
        });
        add(operaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 42, 275, 52));

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
        botonDividir.setText("/");
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
        botonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonEliminar.setText("DEL");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 127, 60, 40));

        botonEliminarTodo.setBackground(new java.awt.Color(255, 105, 98));
        botonEliminarTodo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        vistaOperaciones.setBorder(borderVistaOperaciones);
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
        boton0ActionPerformed();   
    }//GEN-LAST:event_boton0ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        botonNumeroActionPerformed("1");
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        botonNumeroActionPerformed("2");
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        botonNumeroActionPerformed( "3");
    }//GEN-LAST:event_boton3ActionPerformed

    private void botonAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnsActionPerformed
        operaciones.setText("0");
        botonNumeroActionPerformed(numeroAnterior);
    }//GEN-LAST:event_botonAnsActionPerformed

    private void botonComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComaActionPerformed
        botonComaActionPerformed();  
    }//GEN-LAST:event_botonComaActionPerformed

    private void botonIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIgualActionPerformed
        igualarActionPerformed();
    }//GEN-LAST:event_botonIgualActionPerformed

    private void botonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumarActionPerformed
        botonSumarActionPerformed();
    }//GEN-LAST:event_botonSumarActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        botonNumeroActionPerformed("4");
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        botonNumeroActionPerformed("5");
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        botonNumeroActionPerformed("6");
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        botonNumeroActionPerformed("7");
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        botonNumeroActionPerformed("8");
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
        botonNumeroActionPerformed("9");
    }//GEN-LAST:event_boton9ActionPerformed

    private void botonMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMultiplicarActionPerformed
        botonMultiplicarActionPerformed();
    }//GEN-LAST:event_botonMultiplicarActionPerformed

    private void botonDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDividirActionPerformed
        botonDividirActionPerformed();
    }//GEN-LAST:event_botonDividirActionPerformed

    private void botonRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestarActionPerformed
        botonRestarActionPerformed();
    }//GEN-LAST:event_botonRestarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        botonEliminarActionPerformed();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonEliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarTodoActionPerformed
        botonEliminarTodoActionPerformed();
    }//GEN-LAST:event_botonEliminarTodoActionPerformed

    private void botonAbrirParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirParentesisActionPerformed
        botonAbrirParentesisActionPerformed();
    }//GEN-LAST:event_botonAbrirParentesisActionPerformed

    private void botonCerrarParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarParentesisActionPerformed
        botonCerrarParentesisActionPerformed();
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
        if(isExpanded){
            this.addKeyListener(keyListener);
            toggleButtons(true);
            startY = 0;
            endY = 314;
            animateScrollPane();
            vistaOperaciones.setBackground(new Color(255,255,255));
            operaciones.setBackground(new Color(255,255,255));
            operaciones.setForeground(new Color(0,0,0));
            jLabelBorrarTodo.setVisible(false);
            this.setBackground(new Color(102, 102, 102));
            MatteBorder border = new MatteBorder(0, 1, 1, 1, new Color(51,51,51));
            operaciones.setBorder(border);
            vistaOperaciones.setBorder(border);
        }else{
            this.removeKeyListener(keyListener);
            toggleButtons(false);
            startY = 314;
            endY = 0;
            animateScrollPane();
            vistaOperaciones.setBackground(new Color(235,235,235));
            operaciones.setBackground(new Color(235,235,235));
            operaciones.setForeground(new Color(51,51,51));
            this.setBackground(new Color(120, 120, 120));
            historialScrollPane.setVisible(true);
            if(!jLabelBorrarTodo.isVisible() && list.cantidadDatos() > 0){
                jLabelBorrarTodo.setVisible(true);
            }
            MatteBorder border = new MatteBorder(0, 1, 1, 1, new Color(85,85,85));
            operaciones.setBorder(border);
            vistaOperaciones.setBorder(border);
        }
        isExpanded = !isExpanded;
    }//GEN-LAST:event_botonHistorialMouseClicked
    private void jLabelBorrarTodoMouseExited(java.awt.event.MouseEvent evt) {                                             
        jLabelBorrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_red.png")));
    }
    private void toggleButtons(boolean enable) {
        boton0.setEnabled(enable);
        boton1.setEnabled(enable);
        boton2.setEnabled(enable);
        boton3.setEnabled(enable);
        boton4.setEnabled(enable);
        boton5.setEnabled(enable);
        boton6.setEnabled(enable);
        boton7.setEnabled(enable);
        boton8.setEnabled(enable);
        boton9.setEnabled(enable);
        botonAbrirParentesis.setEnabled(enable);
        botonAns.setEnabled(enable);
        botonCambiarNegativoPositivo.setEnabled(enable);
        botonCerrarParentesis.setEnabled(enable);
        botonComa.setEnabled(enable);
        botonDividir.setEnabled(enable);
        botonEliminar.setEnabled(enable);
        botonEliminarTodo.setEnabled(enable);
        botonEuler.setEnabled(enable);
        botonIgual.setEnabled(enable);
        botonMultiplicar.setEnabled(enable);
        botonPi.setEnabled(enable);
        botonRestar.setEnabled(enable);
        botonSumar.setEnabled(enable);
    }

    private void jLabelBorrarTodoMouseEntered(java.awt.event.MouseEvent evt) {                                              
        jLabelBorrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_disable.png")));
    }                                             

    private void jLabelBorrarTodoMouseClicked(java.awt.event.MouseEvent evt) {                                              
        list.clear();
        jLabelBorrarTodo.setVisible(false);
    }
    private void botonEliminarActionPerformed() {
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
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void botonEliminarTodoActionPerformed(){
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
            igualarActionPerformed();
        }else{
        operaciones.setText("0");
        }
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void botonSumarActionPerformed(){
        String textoOperaciones = operaciones.getText();
        String textoVistaOperaciones = vistaOperaciones.getText();
        
        if(igual == true){
            vistaOperaciones.setText(numeroAnterior + " + ");
            operaciones.setText("0");
            operacionBolean = false;
        }
        if(!textoOperaciones.equals("0") && igual == false && operador == false){
           
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
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private void animateScrollPane() {
        
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        
        
        timer = new Timer(10, new ActionListener() {
            int currentY = startY;
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int deltaY = (endY - startY) / 10; 
                
                if ((deltaY > 0 && currentY < endY) || (deltaY < 0 && currentY > endY)) {
                    currentY += deltaY;
                    historialScrollPane.setBounds(0, currentY, 320, 314);
                } else {
                    
                    historialScrollPane.setBounds(0, endY, 320, 314);
                    timer.stop(); 
                }
            }
        });
        timer.start(); 
    }

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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField operaciones;
    private javax.swing.JTextField vistaOperaciones;
    // End of variables declaration//GEN-END:variables
}
