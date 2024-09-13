
package testAnimation;

public class CientificaTest extends javax.swing.JPanel {
    
    public CientificaTest() {
        initComponents();
        buttonAnimation.setLocation(180, 14);
        revalidate();
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Jlist = new javax.swing.JList<>();
        buttonAnimation = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Jlist);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 182, 452, 237));

        buttonAnimation.setText("jButton1");
        buttonAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnimationActionPerformed(evt);
            }
        });
        add(buttonAnimation, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 14, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnimationActionPerformed
        if(jScrollPane1.isVisible()){
            jScrollPane1.setVisible(false);
        }else{
            jScrollPane1.setVisible(true);
        }
    }//GEN-LAST:event_buttonAnimationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Jlist;
    private javax.swing.JButton buttonAnimation;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
