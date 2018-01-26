/*
 * The MIT License
 *
 * Copyright 2015 Jaafar EL Bakkali.
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

package ersn.openmc;

import java.awt.Color;
import jsyntaxpane.DefaultSyntaxKit;
import jsyntaxpane.util.Configuration;

/**
 *
 * @author Jaafar EL Bakkali
 */
public class ERSNOpenMC_Scorers extends javax.swing.JFrame {
final static String DarkGreen="0x006400";
final static String DarkBlue ="0x00008B";
final static String Crimson="0xDC143C";
final static String SlateGray="0x708090";
final static String Salmon="0xFA8072";
ERSNOpenMC_Singleton tmp = ERSNOpenMC_Singleton.getInstance( );
String 
            str_flux="", 
            str_total="",
            str_scatter="",
            str_absorption="", 
            str_fission="",
            str_nu_fission="", 
            str_kappa_fission="", 
            str_scatter_n="", 
            str_scatter_pn="",
            str_scatter_yn="", 
            str_nu_scatter="",
            str_nu_scatter_yn="",
            str_nu_scatter_pn="",
            str_nu_scatter_n="",
            str_events="",
            str_current="",
            str_total_yn="",
            str_flux_yn="" ;

            

    public ERSNOpenMC_Scorers() {
        initComponents();
        getContentPane().setBackground(new Color(0, 0, 128));

        DefaultSyntaxKit.initKit();     

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flux = new javax.swing.JCheckBox();
        btn_scorers = new javax.swing.JButton();
        total = new javax.swing.JCheckBox();
        scatter = new javax.swing.JCheckBox();
        absorption = new javax.swing.JCheckBox();
        fission = new javax.swing.JCheckBox();
        nu_fission = new javax.swing.JCheckBox();
        kappa_fission = new javax.swing.JCheckBox();
        nu_scatter_yn = new javax.swing.JCheckBox();
        nu_scatter_PN = new javax.swing.JCheckBox();
        events = new javax.swing.JCheckBox();
        current = new javax.swing.JCheckBox();
        total_yn = new javax.swing.JCheckBox();
        flux_yn = new javax.swing.JCheckBox();
        scatter_yn = new javax.swing.JCheckBox();
        scatter_pn = new javax.swing.JCheckBox();
        scatter_n = new javax.swing.JCheckBox();
        nu_scatter = new javax.swing.JCheckBox();
        nu_scatter_n = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        Target = new javax.swing.JEditorPane();
        btnclose = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setTitle("ERSN-OpenMC_scorers");
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        flux.setBackground(java.awt.SystemColor.activeCaption);
        flux.setForeground(java.awt.Color.orange);
        flux.setText("flux");
        flux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fluxActionPerformed(evt);
            }
        });

        btn_scorers.setBackground(java.awt.SystemColor.activeCaption);
        btn_scorers.setForeground(java.awt.SystemColor.info);
        btn_scorers.setText("add  a list of scorers");
        btn_scorers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_scorers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_scorersActionPerformed(evt);
            }
        });

        total.setBackground(java.awt.SystemColor.activeCaption);
        total.setForeground(java.awt.Color.orange);
        total.setText("total");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        scatter.setBackground(java.awt.SystemColor.activeCaption);
        scatter.setForeground(java.awt.Color.orange);
        scatter.setText("scatter");
        scatter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scatterActionPerformed(evt);
            }
        });

        absorption.setBackground(java.awt.SystemColor.activeCaption);
        absorption.setForeground(java.awt.Color.orange);
        absorption.setText("absorption");
        absorption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absorptionActionPerformed(evt);
            }
        });

        fission.setBackground(java.awt.SystemColor.activeCaption);
        fission.setForeground(java.awt.Color.orange);
        fission.setText("fission");
        fission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fissionActionPerformed(evt);
            }
        });

        nu_fission.setBackground(java.awt.SystemColor.activeCaption);
        nu_fission.setForeground(java.awt.Color.orange);
        nu_fission.setText("nu-fission");
        nu_fission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nu_fissionActionPerformed(evt);
            }
        });

        kappa_fission.setBackground(java.awt.SystemColor.activeCaption);
        kappa_fission.setForeground(java.awt.Color.orange);
        kappa_fission.setText("kappa-fission");
        kappa_fission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kappa_fissionActionPerformed(evt);
            }
        });

        nu_scatter_yn.setBackground(java.awt.SystemColor.activeCaption);
        nu_scatter_yn.setForeground(java.awt.Color.orange);
        nu_scatter_yn.setText("nu-scatter-YN");
        nu_scatter_yn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nu_scatter_ynActionPerformed(evt);
            }
        });

        nu_scatter_PN.setBackground(java.awt.SystemColor.activeCaption);
        nu_scatter_PN.setForeground(java.awt.Color.orange);
        nu_scatter_PN.setText("nu-scatter-PN");
        nu_scatter_PN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nu_scatter_PNActionPerformed(evt);
            }
        });

        events.setBackground(java.awt.SystemColor.activeCaption);
        events.setForeground(java.awt.Color.orange);
        events.setText("events");
        events.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventsActionPerformed(evt);
            }
        });

        current.setBackground(java.awt.SystemColor.activeCaption);
        current.setForeground(java.awt.Color.orange);
        current.setText("current");
        current.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentActionPerformed(evt);
            }
        });

        total_yn.setBackground(java.awt.SystemColor.activeCaption);
        total_yn.setForeground(java.awt.Color.orange);
        total_yn.setText("total-YN");
        total_yn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_ynActionPerformed(evt);
            }
        });

        flux_yn.setBackground(java.awt.SystemColor.activeCaption);
        flux_yn.setForeground(java.awt.Color.orange);
        flux_yn.setText("flux-YN");
        flux_yn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flux_ynActionPerformed(evt);
            }
        });

        scatter_yn.setBackground(java.awt.SystemColor.activeCaption);
        scatter_yn.setForeground(java.awt.Color.orange);
        scatter_yn.setText("scatter-YN");
        scatter_yn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scatter_ynActionPerformed(evt);
            }
        });

        scatter_pn.setBackground(java.awt.SystemColor.activeCaption);
        scatter_pn.setForeground(java.awt.Color.orange);
        scatter_pn.setText("scatter-PN");
        scatter_pn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scatter_pnActionPerformed(evt);
            }
        });

        scatter_n.setBackground(java.awt.SystemColor.activeCaption);
        scatter_n.setForeground(java.awt.Color.orange);
        scatter_n.setText("scatter-N");
        scatter_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scatter_nActionPerformed(evt);
            }
        });

        nu_scatter.setBackground(java.awt.SystemColor.activeCaption);
        nu_scatter.setForeground(java.awt.Color.orange);
        nu_scatter.setText("nu-scatter");
        nu_scatter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nu_scatterActionPerformed(evt);
            }
        });

        nu_scatter_n.setBackground(java.awt.SystemColor.activeCaption);
        nu_scatter_n.setForeground(java.awt.Color.orange);
        nu_scatter_n.setText("nu-scatter-N");
        nu_scatter_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nu_scatter_nActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(Target);

        btnclose.setBackground(java.awt.SystemColor.activeCaption);
        btnclose.setForeground(java.awt.SystemColor.info);
        btnclose.setText("close");
        btnclose.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setForeground(java.awt.Color.orange);
        jLabel1.setText("Copy and  paste the created lines into tallies.xml.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nu_scatter_PN)
                    .addComponent(nu_scatter_yn)
                    .addComponent(kappa_fission)
                    .addComponent(fission)
                    .addComponent(absorption)
                    .addComponent(scatter)
                    .addComponent(total)
                    .addComponent(flux)
                    .addComponent(nu_fission))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nu_scatter_n)
                    .addComponent(current)
                    .addComponent(total_yn)
                    .addComponent(scatter_yn)
                    .addComponent(scatter_pn)
                    .addComponent(flux_yn)
                    .addComponent(scatter_n)
                    .addComponent(nu_scatter)
                    .addComponent(events))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_scorers, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnclose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_scorers)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(flux)
                        .addGap(0, 0, 0)
                        .addComponent(total)
                        .addGap(0, 0, 0)
                        .addComponent(scatter)
                        .addGap(0, 0, 0)
                        .addComponent(absorption)
                        .addGap(0, 0, 0)
                        .addComponent(fission)
                        .addGap(0, 0, 0)
                        .addComponent(nu_fission)
                        .addGap(0, 0, 0)
                        .addComponent(kappa_fission)
                        .addGap(0, 0, 0)
                        .addComponent(nu_scatter_yn)
                        .addGap(0, 0, 0)
                        .addComponent(nu_scatter_PN))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nu_scatter_n)
                        .addGap(0, 0, 0)
                        .addComponent(nu_scatter)
                        .addGap(0, 0, 0)
                        .addComponent(scatter_n)
                        .addGap(0, 0, 0)
                        .addComponent(scatter_pn)
                        .addGap(0, 0, 0)
                        .addComponent(scatter_yn)
                        .addGap(0, 0, 0)
                        .addComponent(flux_yn)
                        .addGap(0, 0, 0)
                        .addComponent(total_yn)
                        .addGap(0, 0, 0)
                        .addComponent(current)
                        .addGap(0, 0, 0)
                        .addComponent(events)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnclose)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void btn_scorersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_scorersActionPerformed
        // TODO add your handling code here:
            Target.setText("<scores > " +
            str_flux+
            str_total+
            str_scatter+
            str_absorption+
            str_fission+
            str_nu_fission+
            str_kappa_fission+ 
            str_scatter_n+ 
            str_scatter_pn+
            str_scatter_yn+
            str_nu_scatter+
            str_nu_scatter_yn+
            str_nu_scatter_pn+
            str_nu_scatter_n+
            str_events+
            str_current+
            str_total_yn+
            str_flux_yn
            +"</scores>");
    }//GEN-LAST:event_btn_scorersActionPerformed
String textformt(String t){
String s=t;
t= " "+s+" ";
return t;
}
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

Configuration config = DefaultSyntaxKit.getConfig(DefaultSyntaxKit.class);
config.put("Style.KEYWORD2",Crimson+",0");
config.put("Style.KEYWORD",DarkGreen+",3");
config.put("Style.STRING",DarkBlue+", 3");
config.put("Style.STRING2",DarkBlue+",0");
config.put("Style.IDENTIFIER",Crimson+", 0");
config.put("Style.TYPE2",SlateGray+", 3");
config.put("Style.COMMENT2",Salmon+", 3");
config.put("Style.COMMENT",Salmon+", 3");
config.put("LineNumbers.Foreground","	0x009933, 3");
Target.setContentType("text/xhtml");

   
    }//GEN-LAST:event_formWindowOpened

    private void fluxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fluxActionPerformed
        // TODO add your handling code here:
        str_flux=textformt("flux");
    }//GEN-LAST:event_fluxActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        
         str_total=textformt("total");
    }//GEN-LAST:event_totalActionPerformed

    private void scatterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scatterActionPerformed
        str_scatter= textformt("scatter");
    }//GEN-LAST:event_scatterActionPerformed

    private void absorptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absorptionActionPerformed
        str_absorption= textformt("absorption");
    }//GEN-LAST:event_absorptionActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
this.show(false);this.show(false);    }//GEN-LAST:event_btncloseActionPerformed

    private void fissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fissionActionPerformed
      str_fission= textformt("fission");
    }//GEN-LAST:event_fissionActionPerformed

    private void nu_fissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nu_fissionActionPerformed
        str_nu_fission= textformt("nu-fission");
    }//GEN-LAST:event_nu_fissionActionPerformed

    private void kappa_fissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kappa_fissionActionPerformed
        str_kappa_fission= textformt("kappa-fission");
    }//GEN-LAST:event_kappa_fissionActionPerformed

    private void nu_scatter_ynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nu_scatter_ynActionPerformed
         str_nu_scatter_yn= textformt("nu-scatter-YN");

    }//GEN-LAST:event_nu_scatter_ynActionPerformed

    private void nu_scatter_PNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nu_scatter_PNActionPerformed
        str_nu_scatter_pn= textformt("nu-scatter-PN");

    }//GEN-LAST:event_nu_scatter_PNActionPerformed

    private void eventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventsActionPerformed
        str_events=textformt("events");

    }//GEN-LAST:event_eventsActionPerformed

    private void currentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentActionPerformed
       str_current=textformt("current");

    }//GEN-LAST:event_currentActionPerformed

    private void total_ynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_ynActionPerformed
            str_total_yn=textformt("total-YN");
    }//GEN-LAST:event_total_ynActionPerformed

    private void flux_ynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flux_ynActionPerformed
            str_flux_yn=textformt("flux-YN");

    }//GEN-LAST:event_flux_ynActionPerformed

    private void scatter_ynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scatter_ynActionPerformed
           str_scatter_yn= textformt("scatter-YN");

    }//GEN-LAST:event_scatter_ynActionPerformed

    private void scatter_pnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scatter_pnActionPerformed
           str_scatter_pn= textformt("scatter-PN");

    }//GEN-LAST:event_scatter_pnActionPerformed

    private void scatter_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scatter_nActionPerformed
            str_scatter_n= textformt("scatter-N");

    }//GEN-LAST:event_scatter_nActionPerformed

    private void nu_scatterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nu_scatterActionPerformed
           str_nu_scatter= textformt("nu-scatter");

    }//GEN-LAST:event_nu_scatterActionPerformed

    private void nu_scatter_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nu_scatter_nActionPerformed
           str_nu_scatter_n= textformt("nu-scatter-N");

    }//GEN-LAST:event_nu_scatter_nActionPerformed

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
            java.util.logging.Logger.getLogger(ERSNOpenMC_Scorers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ERSNOpenMC_Scorers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane Target;
    private javax.swing.JCheckBox absorption;
    private javax.swing.JButton btn_scorers;
    private javax.swing.JButton btnclose;
    private javax.swing.JCheckBox current;
    private javax.swing.JCheckBox events;
    private javax.swing.JCheckBox fission;
    private javax.swing.JCheckBox flux;
    private javax.swing.JCheckBox flux_yn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox kappa_fission;
    private javax.swing.JCheckBox nu_fission;
    private javax.swing.JCheckBox nu_scatter;
    private javax.swing.JCheckBox nu_scatter_PN;
    private javax.swing.JCheckBox nu_scatter_n;
    private javax.swing.JCheckBox nu_scatter_yn;
    private javax.swing.JCheckBox scatter;
    private javax.swing.JCheckBox scatter_n;
    private javax.swing.JCheckBox scatter_pn;
    private javax.swing.JCheckBox scatter_yn;
    private javax.swing.JCheckBox total;
    private javax.swing.JCheckBox total_yn;
    // End of variables declaration//GEN-END:variables
}
