package view.diversos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class panel_img extends javax.swing.JPanel {


    public panel_img() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension d = tk.getScreenSize();  
        this.setSize(d.width,d.height);
    }

    @Override
    public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon imagemFundo = new ImageIcon(new ImageIcon(getClass().getResource("/img/fundo.jpg")).getImage());        
        //ImageIcon imagemFundo = new ImageIcon(new ImageIcon(getClass().getResource("/Icones/fundo_novo2.jpg")).getImage());
        g.drawImage(imagemFundo.getImage(),0,0,tam.width,tam.height,null);
        setOpaque(false);
        super.paintComponents(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
