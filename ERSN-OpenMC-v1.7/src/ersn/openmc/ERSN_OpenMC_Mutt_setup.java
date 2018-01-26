package ersn.openmc;

import java.awt.Color;
import jsyntaxpane.DefaultSyntaxKit;

/*
 * The MIT License
 *
 * Copyright 2015 bakkali.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author bakkali
 */
public class ERSN_OpenMC_Mutt_setup extends javax.swing.JFrame {

    /**
     * Creates new form ERSN_OpenMC_mutt_setup
     */
    public ERSN_OpenMC_Mutt_setup() {
        initComponents();
        DefaultSyntaxKit.initKit();  
getContentPane().setBackground(new Color(0, 0, 128));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        muttrc_txt = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configure mutt");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jLabel1.setText("1. create ~/.muttrc and put inside the file this contents");

        jLabel2.setBackground(java.awt.SystemColor.activeCaption);
        jLabel2.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jLabel2.setText("2. change your user and your password.");

        jLabel3.setBackground(java.awt.SystemColor.activeCaption);
        jLabel3.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jLabel3.setText("3.  open terminal and type this command:");

        jLabel4.setBackground(java.awt.SystemColor.activeCaption);
        jLabel4.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jLabel4.setText("        mkdir -p ~/.mutt/cache");

        jButton1.setText("close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        muttrc_txt.setText("set from = \"user@gmail.com\"\nset realname = \"Guillermo Garron\"\nset imap_user = \"user@gmail.com\"\nset imap_pass = \"password\"\nset folder = \"imaps://imap.gmail.com:993\"\nset spoolfile = \"+INBOX\"\nset postponed =\"+[Gmail]/Drafts\"\nset header_cache =~/.mutt/cache/headers\nset message_cachedir =~/.mutt/cache/bodies\nset certificate_file =~/.mutt/certificates\nset smtp_url = \"smtp://user@smtp.gmail.com:587/\"\nset smtp_pass = \"password\"\nset move = no \nset imap_keepalive = 900");
        jScrollPane2.setViewportView(muttrc_txt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void text_heighlighter() {

muttrc_txt.setContentType("text/xhtml");
 

          }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                this.show(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        text_heighlighter();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        text_heighlighter();
        muttrc_txt.setText("set from = \"user@gmail.com\"\n" +
"set realname = \"Guillermo Garron\"\n" +
"set imap_user = \"user@gmail.com\"\n" +
"set imap_pass = \"password\"\n" +
"set folder = \"imaps://imap.gmail.com:993\"\n" +
"set spoolfile = \"+INBOX\"\n" +
"set postponed =\"+[Gmail]/Drafts\"\n" +
"set header_cache =~/.mutt/cache/headers\n" +
"set message_cachedir =~/.mutt/cache/bodies\n" +
"set certificate_file =~/.mutt/certificates\n" +
"set smtp_url = \"smtp://user@smtp.gmail.com:587/\"\n" +
"set smtp_pass = \"password\"\n" +
"set move = no \n" +
"set imap_keepalive = 900");
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ERSN_OpenMC_Mutt_setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ERSN_OpenMC_Mutt_setup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JEditorPane muttrc_txt;
    // End of variables declaration//GEN-END:variables
}
