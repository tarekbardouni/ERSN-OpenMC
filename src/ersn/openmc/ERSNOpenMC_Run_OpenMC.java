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

import static ersn.openmc.ERSNOpenMC_Main.getJarContainingFolder;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author elbakkali
 */
public class ERSNOpenMC_Run_OpenMC extends javax.swing.JFrame {
String p_file=" ", project_full_path=" ",OPENMC_DIR="",CROSS_SECTIONS_DIR="", str_user_gmail_account=" ",
BASH_DIR="",Flag_debug_mode=" ", Flag_plotting_mode=" ", Flag_restart=" ", Flag_npg=" ",
Flag_Number_of_OpenMC_Threads=" ",Flag_write_tracks_for_all_particles=" ", 
Options_1=" empty ", Options_2=" empty ", Options_3=" empty ", Options_4=" empty ", 
Options_5=" empty ", Options_6=" empty ", Options_7=" empty ", Options_8=" empty ", Options_9=" empty ";

    /**
     * Creates new form OpenMC_Options
     */
    public ERSNOpenMC_Run_OpenMC() {
        initComponents();
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
        java.awt.GridBagConstraints gridBagConstraints;

        select_cmfd2 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        npg_lbl = new javax.swing.JCheckBox();
        geometry_debugging_mode_option = new javax.swing.JCheckBox();
        plotting_mode_option = new javax.swing.JCheckBox();
        restrart_a_previous_run_option = new javax.swing.JCheckBox();
        write_tracks_for_all_particles_option = new javax.swing.JCheckBox();
        Number_of_OpenMC_Threads_option = new javax.swing.JCheckBox();
        btn_cancel = new javax.swing.JButton();
        number_of_particles_per_generation_box = new javax.swing.JTextField();
        restart_a_previous_run_box = new javax.swing.JTextField();
        Number_of_OpenMC_Threads = new javax.swing.JTextField();
        select_file = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        notification = new javax.swing.JCheckBox();
        user_gmail_account = new javax.swing.JTextField();
        btn_help = new javax.swing.JButton();
        btn_sim = new javax.swing.JButton();

        select_cmfd2.setText(" geometry debugging mode");
        select_cmfd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_cmfd2ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        setTitle("ERSN-OpenMC_Run_OpenMC");
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        npg_lbl.setBackground(java.awt.SystemColor.activeCaption);
        npg_lbl.setForeground(java.awt.Color.orange);
        npg_lbl.setText("number of particles per generation (nppg)");
        npg_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npg_lblActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 0, 0);
        getContentPane().add(npg_lbl, gridBagConstraints);

        geometry_debugging_mode_option.setBackground(java.awt.SystemColor.activeCaption);
        geometry_debugging_mode_option.setForeground(java.awt.Color.orange);
        geometry_debugging_mode_option.setText("geometry debugging mode");
        geometry_debugging_mode_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geometry_debugging_mode_optionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        getContentPane().add(geometry_debugging_mode_option, gridBagConstraints);

        plotting_mode_option.setBackground(java.awt.SystemColor.activeCaption);
        plotting_mode_option.setForeground(java.awt.Color.orange);
        plotting_mode_option.setText("plotting mode");
        plotting_mode_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotting_mode_optionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        getContentPane().add(plotting_mode_option, gridBagConstraints);

        restrart_a_previous_run_option.setBackground(java.awt.SystemColor.activeCaption);
        restrart_a_previous_run_option.setForeground(java.awt.Color.orange);
        restrart_a_previous_run_option.setText("restart a previous run (nppg must be the same)");
        restrart_a_previous_run_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restrart_a_previous_run_optionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 0, 0);
        getContentPane().add(restrart_a_previous_run_option, gridBagConstraints);

        write_tracks_for_all_particles_option.setBackground(java.awt.SystemColor.activeCaption);
        write_tracks_for_all_particles_option.setForeground(java.awt.Color.orange);
        write_tracks_for_all_particles_option.setText("dump tracks for all particles ");
        write_tracks_for_all_particles_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                write_tracks_for_all_particles_optionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        getContentPane().add(write_tracks_for_all_particles_option, gridBagConstraints);

        Number_of_OpenMC_Threads_option.setBackground(java.awt.SystemColor.activeCaption);
        Number_of_OpenMC_Threads_option.setForeground(java.awt.Color.orange);
        Number_of_OpenMC_Threads_option.setText("number of OpenMP threads");
        Number_of_OpenMC_Threads_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Number_of_OpenMC_Threads_optionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 0, 0);
        getContentPane().add(Number_of_OpenMC_Threads_option, gridBagConstraints);

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        getContentPane().add(btn_cancel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        getContentPane().add(number_of_particles_per_generation_box, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 6, 4, 0);
        getContentPane().add(restart_a_previous_run_box, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        getContentPane().add(Number_of_OpenMC_Threads, gridBagConstraints);

        select_file.setBackground(new java.awt.Color(217, 217, 217));
        select_file.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        select_file.setText("...");
        select_file.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        select_file.setMaximumSize(new java.awt.Dimension(20, 16));
        select_file.setPreferredSize(new java.awt.Dimension(10, 18));
        select_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_fileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 43;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(select_file, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 740;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        getContentPane().add(jSeparator1, gridBagConstraints);

        notification.setBackground(java.awt.SystemColor.activeCaption);
        notification.setForeground(java.awt.Color.orange);
        notification.setText("notify me by Email,  once the simulation ends");
        notification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        getContentPane().add(notification, gridBagConstraints);

        user_gmail_account.setToolTipText("user@gmail.com");
        user_gmail_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_gmail_accountActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 0);
        getContentPane().add(user_gmail_account, gridBagConstraints);

        btn_help.setText("?");
        btn_help.setMinimumSize(new java.awt.Dimension(17, 20));
        btn_help.setPreferredSize(new java.awt.Dimension(17, 20));
        btn_help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_helpActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        getContentPane().add(btn_help, gridBagConstraints);

        btn_sim.setText("Start simulation");
        btn_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 92, 5, 2);
        getContentPane().add(btn_sim, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void get_openmcdir(){
try {
File fileDir = new File(getJarContainingFolder(ERSNOpenMC_Main.class)+"/config/openmc.dir");
OPENMC_DIR=("");
    try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8")))
    {
        String str;
        while ((str = in.readLine()) != null) { OPENMC_DIR=OPENMC_DIR+str; }
    }
    } 
    catch (UnsupportedEncodingException e)  { System.out.println(e.getMessage()); } 
    catch (IOException e) { System.out.println(e.getMessage()); }
    catch (Exception e) { System.out.println(e.getMessage()); }
OPENMC_DIR=OPENMC_DIR+"";
}

public void get_cross_sections_dir(){
try {
File fileDir = new File(getJarContainingFolder(ERSNOpenMC_Main.class)+"/config/cross_sections.dir");
CROSS_SECTIONS_DIR=("");
    try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
        String str;
        while ((str = in.readLine()) != null) { CROSS_SECTIONS_DIR=CROSS_SECTIONS_DIR+str; }
        System.out.print(CROSS_SECTIONS_DIR);
    }
    } 
    catch (UnsupportedEncodingException e)  { System.out.println(e.getMessage());} 
    catch (IOException e) { System.out.println(e.getMessage()); }
    catch (Exception e)   { System.out.println(e.getMessage()); }
    CROSS_SECTIONS_DIR=CROSS_SECTIONS_DIR+"";
    System.out.println(" the cross section is :"+CROSS_SECTIONS_DIR);
}

    private void select_cmfd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_cmfd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_select_cmfd2ActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        this.show(false);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ERSNOpenMC_Singleton tmp = ERSNOpenMC_Singleton.getInstance();
        project_full_path=tmp.getPath();

    }//GEN-LAST:event_formWindowActivated

    private void select_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_fileActionPerformed
JFileChooser fc = new JFileChooser(); 
FileNameExtensionFilter ppmfilter = new FileNameExtensionFilter("state_point binary files ", "binary", "h5");
fc.setFileFilter(ppmfilter);
fc.setDialogTitle("Open a state point or a particle restart file");
java.io.File dir = new File(project_full_path);
fc.setCurrentDirectory(dir);
fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
int returnVal = fc.showOpenDialog(this);
if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
java.io.File file = fc.getSelectedFile( );
//
p_file= file.toString( );
restart_a_previous_run_box.setText(p_file);
}        
    }//GEN-LAST:event_select_fileActionPerformed

    private void notificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationActionPerformed
        
         if (notification.isSelected() == true) {             
            str_user_gmail_account= user_gmail_account.getText();
        }
        if (notification.isSelected() == false) {          
            user_gmail_account.setText("");
            str_user_gmail_account=" "+ user_gmail_account.getText()+ " ";           
        }                        
    }//GEN-LAST:event_notificationActionPerformed

    private void user_gmail_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_gmail_accountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_gmail_accountActionPerformed

    private void btn_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_helpActionPerformed
        ERSN_OpenMC_Mutt_setup dialgo  =new     ERSN_OpenMC_Mutt_setup();
        dialgo.show();   dialgo.show();  
    }//GEN-LAST:event_btn_helpActionPerformed

    private void btn_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simActionPerformed
        // TODO add your handling code here:
        str_user_gmail_account=" "+user_gmail_account.getText()+" ";
        get_openmcdir();
        get_cross_sections_dir();
        if (geometry_debugging_mode_option.isSelected()==true) 
            { Flag_debug_mode=" -g ";
              Options_1=Flag_debug_mode;
            } 

        if (plotting_mode_option.isSelected()==true)
            { Flag_plotting_mode=" -p ";
              Options_2=Flag_plotting_mode;
            } 

        if (npg_lbl.isSelected()==true) 
            { Flag_npg=" -n ";
              Options_3=Flag_npg;
              Options_4=number_of_particles_per_generation_box.getText()+" ";
            } 

        if (Number_of_OpenMC_Threads_option.isSelected()==true) 
            { Flag_Number_of_OpenMC_Threads=" -s ";
              Options_5=Flag_Number_of_OpenMC_Threads;
              Options_6=Number_of_OpenMC_Threads.getText()+" ";
            } 

        if (write_tracks_for_all_particles_option.isSelected()==true) 
            { Flag_write_tracks_for_all_particles=" -t ";
              Options_7=Flag_write_tracks_for_all_particles;
            }
        
        if (restrart_a_previous_run_option.isSelected()==true) 
            { Options_8=" -r ";
              Options_9=restart_a_previous_run_box.getText()+" ";
            } 
        
    try{                   
        BASH_DIR= getJarContainingFolder(ERSNOpenMC_Main.class)+"/scripts/start_openmc.sh";  
    } catch (Exception ex) {  
        System.out.print(ex);  
    }
    
    try {            
        System.out.print("OPENMC DIR :"+OPENMC_DIR);  
        Process START_OPENMC_PROCESS =Runtime.getRuntime().exec( 
                "xterm -j  -sb -title ERSN-OpenMC_Console -sl 2000  -e "+
            BASH_DIR+" " +
            CROSS_SECTIONS_DIR+" " + // full path to the cross sections xml
            OPENMC_DIR+" "+          // openmc parent dir
            project_full_path+" "+   // project full path
            Options_1+               // geometry debuging
            Options_2+               // geometry ploting
            Options_3+               // number of particles per generation flag
            Options_4+               // number of particles per generation
            Options_5+               // threads flag
            Options_6+               // threads number
            Options_7+               // all particles track
            Options_8+               // retart flag
            Options_9+               // state_point file for retart
            str_user_gmail_account);
        
        START_OPENMC_PROCESS.waitFor();
        
        JOptionPane.showMessageDialog(this, "The simulation has been finished ! ");

        } catch (IOException | InterruptedException ex) {  
            System.out.print(ex);  
        }
       
    }//GEN-LAST:event_btn_simActionPerformed

    private void geometry_debugging_mode_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geometry_debugging_mode_optionActionPerformed
    if (geometry_debugging_mode_option.isSelected()==false) 
{ 
        //Flag_debug_mode=" ";
        Options_1=" empty ";
}
    }//GEN-LAST:event_geometry_debugging_mode_optionActionPerformed

    private void plotting_mode_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotting_mode_optionActionPerformed
    if (plotting_mode_option.isSelected()==false)
{
        //Flag_plotting_mode=" ";
        Options_2=" empty ";
}
    }//GEN-LAST:event_plotting_mode_optionActionPerformed

    private void npg_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npg_lblActionPerformed
    if (npg_lbl.isSelected()==false) 
{ 
        // Flag_npg=" ";
        Options_3=" empty ";
        Options_4=" empty ";
        number_of_particles_per_generation_box.setText("");
  } 
    }//GEN-LAST:event_npg_lblActionPerformed

    private void Number_of_OpenMC_Threads_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Number_of_OpenMC_Threads_optionActionPerformed
    if (Number_of_OpenMC_Threads_option.isSelected()==false) 
{
        //Flag_Number_of_OpenMC_Threads=" ";
        Options_5=" empty ";
        Options_6=" empty ";
        Number_of_OpenMC_Threads.setText("");
}
    }//GEN-LAST:event_Number_of_OpenMC_Threads_optionActionPerformed

        private void write_tracks_for_all_particles_optionActionPerformed(java.awt.event.ActionEvent evt) {                                                                      
    if (write_tracks_for_all_particles_option.isSelected()==false) 
{
        Options_7=" empty ";
}    
    }                                                                     

    private void restrart_a_previous_run_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restrart_a_previous_run_optionActionPerformed
    if (restrart_a_previous_run_option.isSelected()==false) 
{  
        Options_8=" empty ";
        Options_9=" empty ";
        restart_a_previous_run_box.setText("");
}
    }//GEN-LAST:event_restrart_a_previous_run_optionActionPerformed
/**
    private void write_tracks_for_all_particles_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_write_tracks_for_all_particles_optionActionPerformed
    if (write_tracks_for_all_particles_option.isSelected()==false) 
{
        Options_7=" empty ";
}    
    }//GEN-LAST:event_write_tracks_for_all_particles_optionActionPerformed
*/
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
            java.util.logging.Logger.getLogger(ERSNOpenMC_Run_OpenMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    //</editor-fold>
    
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ERSNOpenMC_Run_OpenMC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Number_of_OpenMC_Threads;
    private javax.swing.JCheckBox Number_of_OpenMC_Threads_option;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_help;
    private javax.swing.JButton btn_sim;
    private javax.swing.JCheckBox geometry_debugging_mode_option;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox notification;
    private javax.swing.JCheckBox npg_lbl;
    private javax.swing.JTextField number_of_particles_per_generation_box;
    private javax.swing.JCheckBox plotting_mode_option;
    private javax.swing.JTextField restart_a_previous_run_box;
    private javax.swing.JCheckBox restrart_a_previous_run_option;
    private javax.swing.JCheckBox select_cmfd2;
    private javax.swing.JButton select_file;
    private javax.swing.JTextField user_gmail_account;
    private javax.swing.JCheckBox write_tracks_for_all_particles_option;
    // End of variables declaration//GEN-END:variables
}
