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
 * furnished to do so, subject to the iltersollowing conditions:
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
import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.CodeSource;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.filechooser.FileNameExtensionFilter;
import jsyntaxpane.DefaultSyntaxKit;
import jsyntaxpane.util.Configuration;
import java.io.FilenameFilter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Jaafar EL Bakkali
 * @email bahmedj@gmail.com

 */

public class ERSNOpenMC_Main extends javax.swing.JFrame {
static int id=0;

final static String DarkGreen     =   "0x14C562",
                    DarkBlue      =   "0x00008B",
                    Crimson       =   "0xFF0000",
                    SlateGray     =   "0x800000",
                    Salmon        =   "0xB252C5";
String   file_name=null,
         statepoint_file=null,
         openmcdir="",
         project_full_path="",
         openmc_options=" ",
         open_action="no",
         scripts_dir="", 
         track_file="";

// CREATION OF AN INSTANCE OF A CLASS THAT RECORED SOME VARIABLES.
ERSNOpenMC_Singleton tmp = ERSNOpenMC_Singleton.getInstance();

// DEFINITION OF COLORS ASSIGNED TO THE BUTTON AT SELECTED AND UNSELECTED STATES.
Color BUTTON_BACKGROUD_COLOR__SELECTED_STATE= new Color(255,0,54), BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE= new Color(0,0,154);
    private JTextArea guide_filter;


 
public ERSNOpenMC_Main() {
    initComponents();  
//    myInitComponents();
    getContentPane().setBackground(new Color(0, 0, 128));
    //setIconImage( new ImageIcon(getClass().getClassLoader().getResource("PATH/TO/YourImage.png")));
    DefaultSyntaxKit.initKit();  
}
/*
public void myInitComponents() {
 //       java.awt.GridBagConstraints gridBagConstraints;
        btn_cancel = new javax.swing.JButton();
        btn_cancel.setBackground(new java.awt.Color(228, 223, 223));
        btn_cancel.setForeground(java.awt.Color.darkGray);
        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
//        getContentPane().add(btn_cancel, gridBagConstraints);

}

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.show(false);
    }                                          
*/
// getJarContainingFolder class
public static String getJarContainingFolder(Class aclass) throws Exception {
CodeSource codeSource = aclass.getProtectionDomain().getCodeSource();
File jarFile;
if (codeSource.getLocation() != null) {
jarFile = new File(codeSource.getLocation().toURI());
} else {
String path = aclass.getResource(aclass.getSimpleName() + ".class").getPath();
String jarFilePath = path.substring(path.indexOf(":") + 1, path.indexOf("!"));
jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
jarFile = new File(jarFilePath);
}
return jarFile.getParentFile().getAbsolutePath();
}

// save_xml_file class
public void save_xml_file(String xml_file,String path,javax.swing.JEditorPane target){
try {
                    FileWriter lu = new FileWriter(path+"/"+xml_file);// Créer un objet java.io.FileWriter avec comme argument le mon du fichier dans lequel enregsitrer
    try (BufferedWriter fluxS = new BufferedWriter(lu) // Mettre le flux en tampon (en cache)
    ) {
        fluxS.write(target.getText()); //Balancer dans le flux le contenu de la zone de texte
        fluxS.close(); // Fermer le flux (c’est toujours mieux de le fermer explicitement)
    } //Balancer dans le flux le contenu de la zone de texte
     } catch (IOException er) {;}
}

// open_xml_file class
public void open_xml_file(String xml_file, javax.swing.JEditorPane target,String path){
try {
File fileDir = new File(path+"/"+xml_file);
target.setText("");
BufferedReader in = new BufferedReader(
new InputStreamReader( new FileInputStream(fileDir), "UTF8"));
String str;
while ((str = in.readLine()) != null) {
target.setText(target.getText().toString()+str+"\n");
    }
in.close();
    } 
    catch (UnsupportedEncodingException e) 
    {
 System.out.println(e.getMessage());
    } 
    catch (IOException e) 
    {
 System.out.println(e.getMessage());
    }
    catch (Exception e)
    {
 System.out.println(e.getMessage());
    }
lbl.setText(path);
}

// open_xml_file class
public void save_all_xml_files(){
if (project_full_path.isEmpty()==false) 
{ save_xml_file("settings.xml",project_full_path,settingsTxt);
  save_xml_file("materials.xml",project_full_path,materialsTxt);
  save_xml_file("geometry.xml",project_full_path,geometryTxt);
}

if (talliesTxt.getText().toString().isEmpty()==false) {save_xml_file("tallies.xml",project_full_path,talliesTxt);}
if (plottingTxt.getText().isEmpty()==false) {save_xml_file("plots.xml",project_full_path,plottingTxt);}
if (cmfdTxt.getText().isEmpty()==false) {save_xml_file("cmfd.xml",project_full_path,cmfdTxt);}
}

// open_all_xml_files class
public void open_all_xml_files(){
if (!"".equals(project_full_path)) open_xml_file("settings.xml",settingsTxt,project_full_path);
if (!"".equals(project_full_path)) open_xml_file("geometry.xml",geometryTxt,project_full_path);
if (!"".equals(project_full_path)) open_xml_file("materials.xml",materialsTxt,project_full_path);
if (!"".equals(project_full_path)) open_xml_file("cmfd.xml",cmfdTxt,project_full_path);
if (!"".equals(project_full_path)) open_xml_file("tallies.xml",talliesTxt,project_full_path);
if (!"".equals(project_full_path)) open_xml_file("plots.xml",plottingTxt,project_full_path);
}

// text_heighlighter class
public void text_heighlighter() {
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
cmfdTxt.setContentType("text/xhtml");
geometryTxt.setContentType("text/xhtml");
talliesTxt.setContentType("text/xhtml");
materialsTxt.setContentType("text/xhtml");
settingsTxt.setContentType("text/xhtml");
plottingTxt.setContentType("text/xhtml");   

          }

// openPdfFile class

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jFrame1 = new javax.swing.JFrame();
        jScrollBar1 = new javax.swing.JScrollBar();
        container = new javax.swing.JTabbedPane();
        geometry_pnl = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        btn_lattice = new javax.swing.JButton();
        btn_surface = new javax.swing.JButton();
        btn_hex_lattice = new javax.swing.JButton();
        btn_comment_geometry = new javax.swing.JButton();
        btn_cell = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        geometryTxt = new javax.swing.JEditorPane();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane17 = new javax.swing.JScrollPane();
        guide_geometry = new javax.swing.JTextArea();
        materials_pnl = new javax.swing.JPanel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        btn_material = new javax.swing.JButton();
        btn_defaults_xs = new javax.swing.JButton();
        btn_comment_materials = new javax.swing.JButton();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        materialsTxt = new javax.swing.JEditorPane();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jScrollPane19 = new javax.swing.JScrollPane();
        guide_materials = new javax.swing.JTextArea();
        settings_pnl = new javax.swing.JPanel();
        jInternalFrame9 = new javax.swing.JInternalFrame();
        btn_trace = new javax.swing.JButton();
        btn_cross_sections = new javax.swing.JButton();
        btn_ptables = new javax.swing.JButton();
        btn_log_grid_bins = new javax.swing.JButton();
        btn_threads = new javax.swing.JButton();
        btn_output_path = new javax.swing.JButton();
        btn_confidence_intervals = new javax.swing.JButton();
        btn_comment_settings = new javax.swing.JButton();
        btn_run_cmfd = new javax.swing.JButton();
        btn_output = new javax.swing.JButton();
        btn_track = new javax.swing.JButton();
        btn_entropy = new javax.swing.JButton();
        btn_source_point = new javax.swing.JButton();
        btn_verbosity = new javax.swing.JButton();
        btn_uniform_fs = new javax.swing.JButton();
        btn_state_point = new javax.swing.JButton();
        btn_seed = new javax.swing.JButton();
        btn_source = new javax.swing.JButton();
        btn_trigger = new javax.swing.JButton();
        btn_energy_grid = new javax.swing.JButton();
        btn_cutoff = new javax.swing.JButton();
        btn_resonance_scattering = new javax.swing.JButton();
        btn_fixed_source = new javax.swing.JButton();
        btn_no_reduce = new javax.swing.JButton();
        btn_survival_biasing = new javax.swing.JButton();
        btn_eignvalue = new javax.swing.JButton();
        btn_natural_elements = new javax.swing.JButton();
        jInternalFrame10 = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        settingsTxt = new javax.swing.JEditorPane();
        jInternalFrame11 = new javax.swing.JInternalFrame();
        jScrollPane14 = new javax.swing.JScrollPane();
        Guide = new javax.swing.JTextArea();
        tallies_pnl = new javax.swing.JPanel();
        jInternalFrame7 = new javax.swing.JInternalFrame();
        btn_comment_tallies = new javax.swing.JButton();
        btn_mesh = new javax.swing.JButton();
        btn_tally = new javax.swing.JButton();
        btn_assume_separate = new javax.swing.JButton();
        btn_tally2 = new javax.swing.JButton();
        jInternalFrame8 = new javax.swing.JInternalFrame();
        jScrollPane8 = new javax.swing.JScrollPane();
        talliesTxt = new javax.swing.JEditorPane();
        jInternalFrame12 = new javax.swing.JInternalFrame();
        jScrollPane20 = new javax.swing.JScrollPane();
        guide_tallies = new javax.swing.JTextArea();
        cmfd_pnl = new javax.swing.JPanel();
        jInternalFrame13 = new javax.swing.JInternalFrame();
        btn_mesh_cmfd = new javax.swing.JButton();
        btn_gauss_seidel_tolerance = new javax.swing.JButton();
        btn_norm = new javax.swing.JButton();
        btn_power_monitor = new javax.swing.JButton();
        btn_write_matrices = new javax.swing.JButton();
        btn_dhat_set = new javax.swing.JButton();
        btn_tally_reset = new javax.swing.JButton();
        btn_display = new javax.swing.JButton();
        btn_shift = new javax.swing.JButton();
        btn_begin = new javax.swing.JButton();
        btn_downscatter = new javax.swing.JButton();
        run_adjoint = new javax.swing.JButton();
        btn_comment_cmfd = new javax.swing.JButton();
        btn_stol = new javax.swing.JButton();
        btn_ktol = new javax.swing.JButton();
        btn_feedback = new javax.swing.JButton();
        btn_spectral = new javax.swing.JButton();
        jInternalFrame14 = new javax.swing.JInternalFrame();
        jScrollPane9 = new javax.swing.JScrollPane();
        cmfdTxt = new javax.swing.JEditorPane();
        jInternalFrame15 = new javax.swing.JInternalFrame();
        jScrollPane21 = new javax.swing.JScrollPane();
        Guidecmfd = new javax.swing.JTextArea();
        plotting_pnl = new javax.swing.JPanel();
        jInternalFrame16 = new javax.swing.JInternalFrame();
        btn_comment_plotting = new javax.swing.JButton();
        btn_plot_voxel = new javax.swing.JButton();
        btn_plot_slice = new javax.swing.JButton();
        jInternalFrame17 = new javax.swing.JInternalFrame();
        jScrollPane10 = new javax.swing.JScrollPane();
        plottingTxt = new javax.swing.JEditorPane();
        jInternalFrame18 = new javax.swing.JInternalFrame();
        jScrollPane22 = new javax.swing.JScrollPane();
        GuidePlotting = new javax.swing.JTextArea();
        lbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menu_new_openmc_project = new javax.swing.JMenuItem();
        menu_existing_project = new javax.swing.JMenuItem();
        menu_save_project = new javax.swing.JMenuItem();
        menu_exit = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu_get_openmc = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem_run_openmc = new javax.swing.JMenuItem();
        Menu_tools = new javax.swing.JMenu();
        menu_item_show_results = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        _3d_mesh_plot = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuPPM2PNG = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem_binary_track_to_pvtp = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        add_scorers = new javax.swing.JMenuItem();
        menu_item_table_of_nuclides = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem_openmc_xml_validation = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menu_item_about = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ERSN-OpenMC developed by Jaafar EL Bakkali & Tarek EL Bardouni");
        setBackground(new java.awt.Color(0, 51, 204));
        setFont(new java.awt.Font("Ubuntu", 0, 5)); // NOI18N
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        container.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        container.setOpaque(true);

        geometry_pnl.setBackground(java.awt.SystemColor.activeCaption);
        geometry_pnl.setForeground(java.awt.SystemColor.activeCaption);

        jInternalFrame1.setTitle("OpenMC commands");
        jInternalFrame1.setVisible(true);

        btn_lattice.setBackground(new java.awt.Color(0, 0, 154));
        btn_lattice.setForeground(new java.awt.Color(255, 255, 204));
        btn_lattice.setText("rectangular lattice");
        btn_lattice.setToolTipText("");
        btn_lattice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_lattice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_lattice.setFocusPainted(false);
        btn_lattice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_latticeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_latticeMouseEntered(evt);
            }
        });
        btn_lattice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_latticeActionPerformed(evt);
            }
        });

        btn_surface.setBackground(new java.awt.Color(0, 0, 154));
        btn_surface.setForeground(new java.awt.Color(255, 255, 204));
        btn_surface.setText("surface");
        btn_surface.setToolTipText("");
        btn_surface.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_surface.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_surface.setFocusPainted(false);
        btn_surface.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_surfaceMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_surfaceMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_surfaceMouseEntered(evt);
            }
        });
        btn_surface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_surfaceActionPerformed(evt);
            }
        });

        btn_hex_lattice.setBackground(new java.awt.Color(0, 0, 154));
        btn_hex_lattice.setForeground(new java.awt.Color(255, 255, 204));
        btn_hex_lattice.setText("hexagonal lattice");
        btn_hex_lattice.setToolTipText("");
        btn_hex_lattice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_hex_lattice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hex_lattice.setFocusPainted(false);
        btn_hex_lattice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hex_latticeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hex_latticeMouseEntered(evt);
            }
        });
        btn_hex_lattice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hex_latticeActionPerformed(evt);
            }
        });

        btn_comment_geometry.setBackground(new java.awt.Color(0, 0, 154));
        btn_comment_geometry.setForeground(new java.awt.Color(255, 255, 204));
        btn_comment_geometry.setText("comment");
        btn_comment_geometry.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_comment_geometry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_comment_geometry.setFocusPainted(false);
        btn_comment_geometry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_comment_geometryMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_comment_geometryMouseEntered(evt);
            }
        });
        btn_comment_geometry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comment_geometryActionPerformed(evt);
            }
        });

        btn_cell.setBackground(new java.awt.Color(0, 0, 154));
        btn_cell.setForeground(new java.awt.Color(255, 255, 204));
        btn_cell.setText("cell");
        btn_cell.setToolTipText("");
        btn_cell.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cell.setFocusPainted(false);
        btn_cell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cellMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cellMouseEntered(evt);
            }
        });
        btn_cell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cellActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_cell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_surface, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lattice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_comment_geometry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hex_lattice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_surface, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_cell, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_hex_lattice, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_lattice, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_comment_geometry, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame2.setTitle("OpenMC XML Editor");
        jInternalFrame2.setVisible(true);

        geometryTxt.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                geometryTxtAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(geometryTxt);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame3.setTitle("OpenMC commands guidance");
        jInternalFrame3.setToolTipText("");
        jInternalFrame3.setVisible(true);

        guide_geometry.setColumns(20);
        guide_geometry.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        guide_geometry.setLineWrap(true);
        guide_geometry.setRows(5);
        guide_geometry.setWrapStyleWord(true);
        jScrollPane17.setViewportView(guide_geometry);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout geometry_pnlLayout = new javax.swing.GroupLayout(geometry_pnl);
        geometry_pnl.setLayout(geometry_pnlLayout);
        geometry_pnlLayout.setHorizontalGroup(
            geometry_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geometry_pnlLayout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame2))
            .addComponent(jInternalFrame3)
        );
        geometry_pnlLayout.setVerticalGroup(
            geometry_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geometry_pnlLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(geometry_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame3))
        );

        container.addTab("Geometry ", geometry_pnl);

        materials_pnl.setBackground(java.awt.SystemColor.activeCaption);

        jInternalFrame4.setTitle("OpenMC commands");
        jInternalFrame4.setVisible(true);

        btn_material.setBackground(new java.awt.Color(0, 0, 154));
        btn_material.setForeground(new java.awt.Color(255, 255, 204));
        btn_material.setText("material");
        btn_material.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_material.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_material.setFocusPainted(false);
        btn_material.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_materialMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_materialMouseEntered(evt);
            }
        });
        btn_material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_materialActionPerformed(evt);
            }
        });

        btn_defaults_xs.setBackground(new java.awt.Color(0, 0, 154));
        btn_defaults_xs.setForeground(new java.awt.Color(255, 255, 204));
        btn_defaults_xs.setText("default_xs");
        btn_defaults_xs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_defaults_xs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_defaults_xs.setFocusPainted(false);
        btn_defaults_xs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_defaults_xsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_defaults_xsMouseEntered(evt);
            }
        });
        btn_defaults_xs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_defaults_xsActionPerformed(evt);
            }
        });

        btn_comment_materials.setBackground(new java.awt.Color(0, 0, 154));
        btn_comment_materials.setForeground(new java.awt.Color(255, 255, 204));
        btn_comment_materials.setText("comment");
        btn_comment_materials.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_comment_materials.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_comment_materials.setFocusPainted(false);
        btn_comment_materials.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_comment_materialsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_comment_materialsMouseEntered(evt);
            }
        });
        btn_comment_materials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comment_materialsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_material, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_defaults_xs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_comment_materials, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_material, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_defaults_xs, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_comment_materials, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame5.setTitle("OpenMC XML Editor");
        jInternalFrame5.setVisible(true);

        jScrollPane4.setViewportView(materialsTxt);

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame6.setTitle("OpenMC commands guidance");
        jInternalFrame6.setVisible(true);

        guide_materials.setColumns(20);
        guide_materials.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        guide_materials.setLineWrap(true);
        guide_materials.setRows(5);
        guide_materials.setWrapStyleWord(true);
        jScrollPane19.setViewportView(guide_materials);

        javax.swing.GroupLayout jInternalFrame6Layout = new javax.swing.GroupLayout(jInternalFrame6.getContentPane());
        jInternalFrame6.getContentPane().setLayout(jInternalFrame6Layout);
        jInternalFrame6Layout.setHorizontalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame6Layout.setVerticalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout materials_pnlLayout = new javax.swing.GroupLayout(materials_pnl);
        materials_pnl.setLayout(materials_pnlLayout);
        materials_pnlLayout.setHorizontalGroup(
            materials_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materials_pnlLayout.createSequentialGroup()
                .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame5))
            .addComponent(jInternalFrame6)
        );
        materials_pnlLayout.setVerticalGroup(
            materials_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, materials_pnlLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(materials_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame6))
        );

        container.addTab("Materials ", materials_pnl);

        settings_pnl.setBackground(java.awt.SystemColor.activeCaption);
        settings_pnl.setForeground(java.awt.SystemColor.activeCaption);

        jInternalFrame9.setTitle("OpenMC commands");
        jInternalFrame9.setVisible(true);

        btn_trace.setBackground(new java.awt.Color(0, 0, 154));
        btn_trace.setForeground(new java.awt.Color(255, 255, 204));
        btn_trace.setText("trace");
        btn_trace.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_trace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_trace.setFocusPainted(false);
        btn_trace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_traceMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_traceMouseEntered(evt);
            }
        });
        btn_trace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_traceActionPerformed(evt);
            }
        });

        btn_cross_sections.setBackground(new java.awt.Color(0, 0, 154));
        btn_cross_sections.setForeground(new java.awt.Color(255, 255, 204));
        btn_cross_sections.setText("cross_sections");
        btn_cross_sections.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cross_sections.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cross_sections.setFocusPainted(false);
        btn_cross_sections.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cross_sectionsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cross_sectionsMouseEntered(evt);
            }
        });
        btn_cross_sections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cross_sectionsActionPerformed(evt);
            }
        });

        btn_ptables.setBackground(new java.awt.Color(0, 0, 154));
        btn_ptables.setForeground(new java.awt.Color(255, 255, 204));
        btn_ptables.setText("ptables");
        btn_ptables.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ptables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ptables.setFocusPainted(false);
        btn_ptables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ptablesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ptablesMouseEntered(evt);
            }
        });
        btn_ptables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ptablesActionPerformed(evt);
            }
        });

        btn_log_grid_bins.setBackground(new java.awt.Color(0, 0, 154));
        btn_log_grid_bins.setForeground(new java.awt.Color(255, 255, 204));
        btn_log_grid_bins.setText("log_grid_bins");
        btn_log_grid_bins.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_log_grid_bins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_log_grid_bins.setFocusPainted(false);
        btn_log_grid_bins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_log_grid_binsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_log_grid_binsMouseEntered(evt);
            }
        });
        btn_log_grid_bins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_log_grid_binsActionPerformed(evt);
            }
        });

        btn_threads.setBackground(new java.awt.Color(0, 0, 154));
        btn_threads.setForeground(new java.awt.Color(255, 255, 204));
        btn_threads.setText("threads");
        btn_threads.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_threads.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_threads.setFocusPainted(false);
        btn_threads.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_threadsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_threadsMouseEntered(evt);
            }
        });
        btn_threads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_threadsActionPerformed(evt);
            }
        });

        btn_output_path.setBackground(new java.awt.Color(0, 0, 154));
        btn_output_path.setForeground(new java.awt.Color(255, 255, 204));
        btn_output_path.setText("output_path");
        btn_output_path.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_output_path.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_output_path.setFocusPainted(false);
        btn_output_path.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_output_pathMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_output_pathMouseEntered(evt);
            }
        });
        btn_output_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_output_pathActionPerformed(evt);
            }
        });

        btn_confidence_intervals.setBackground(new java.awt.Color(0, 0, 154));
        btn_confidence_intervals.setForeground(new java.awt.Color(255, 255, 204));
        btn_confidence_intervals.setText("confidence_intervals");
        btn_confidence_intervals.setToolTipText("");
        btn_confidence_intervals.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confidence_intervals.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confidence_intervals.setFocusPainted(false);
        btn_confidence_intervals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_confidence_intervalsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_confidence_intervalsMouseEntered(evt);
            }
        });
        btn_confidence_intervals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confidence_intervalsActionPerformed(evt);
            }
        });

        btn_comment_settings.setBackground(new java.awt.Color(0, 0, 154));
        btn_comment_settings.setForeground(new java.awt.Color(255, 255, 204));
        btn_comment_settings.setText("comment");
        btn_comment_settings.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_comment_settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_comment_settings.setFocusPainted(false);
        btn_comment_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_comment_settingsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_comment_settingsMouseEntered(evt);
            }
        });
        btn_comment_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comment_settingsActionPerformed(evt);
            }
        });

        btn_run_cmfd.setBackground(new java.awt.Color(0, 0, 154));
        btn_run_cmfd.setForeground(new java.awt.Color(255, 255, 204));
        btn_run_cmfd.setText("run_cmfd");
        btn_run_cmfd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_run_cmfd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_run_cmfd.setFocusPainted(false);
        btn_run_cmfd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_run_cmfdMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_run_cmfdMouseEntered(evt);
            }
        });
        btn_run_cmfd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_run_cmfdActionPerformed(evt);
            }
        });

        btn_output.setBackground(new java.awt.Color(0, 0, 154));
        btn_output.setForeground(new java.awt.Color(255, 255, 204));
        btn_output.setText("output");
        btn_output.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_output.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_output.setFocusPainted(false);
        btn_output.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_outputMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_outputMouseEntered(evt);
            }
        });
        btn_output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_outputActionPerformed(evt);
            }
        });

        btn_track.setBackground(new java.awt.Color(0, 0, 154));
        btn_track.setForeground(new java.awt.Color(255, 255, 204));
        btn_track.setText("track");
        btn_track.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_track.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_track.setFocusPainted(false);
        btn_track.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_trackMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_trackMouseEntered(evt);
            }
        });
        btn_track.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trackActionPerformed(evt);
            }
        });

        btn_entropy.setBackground(new java.awt.Color(0, 0, 154));
        btn_entropy.setForeground(new java.awt.Color(255, 255, 204));
        btn_entropy.setText("entropy");
        btn_entropy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_entropy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entropy.setFocusPainted(false);
        btn_entropy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_entropyMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_entropyMouseEntered(evt);
            }
        });
        btn_entropy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entropyActionPerformed(evt);
            }
        });

        btn_source_point.setBackground(new java.awt.Color(0, 0, 154));
        btn_source_point.setForeground(new java.awt.Color(255, 255, 204));
        btn_source_point.setText("source_point");
        btn_source_point.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_source_point.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_source_point.setFocusPainted(false);
        btn_source_point.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_source_pointMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_source_pointMouseEntered(evt);
            }
        });
        btn_source_point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_source_pointActionPerformed(evt);
            }
        });

        btn_verbosity.setBackground(new java.awt.Color(0, 0, 154));
        btn_verbosity.setForeground(new java.awt.Color(255, 255, 204));
        btn_verbosity.setText("verbosity");
        btn_verbosity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_verbosity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verbosity.setFocusPainted(false);
        btn_verbosity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_verbosityMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_verbosityMouseEntered(evt);
            }
        });
        btn_verbosity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verbosityActionPerformed(evt);
            }
        });

        btn_uniform_fs.setBackground(new java.awt.Color(0, 0, 154));
        btn_uniform_fs.setForeground(new java.awt.Color(255, 255, 204));
        btn_uniform_fs.setText("uniform_fs");
        btn_uniform_fs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_uniform_fs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_uniform_fs.setFocusPainted(false);
        btn_uniform_fs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_uniform_fsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_uniform_fsMouseEntered(evt);
            }
        });
        btn_uniform_fs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uniform_fsActionPerformed(evt);
            }
        });

        btn_state_point.setBackground(new java.awt.Color(0, 0, 154));
        btn_state_point.setForeground(new java.awt.Color(255, 255, 204));
        btn_state_point.setText("state_point");
        btn_state_point.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_state_point.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_state_point.setFocusPainted(false);
        btn_state_point.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_state_pointMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_state_pointMouseEntered(evt);
            }
        });
        btn_state_point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_state_pointActionPerformed(evt);
            }
        });

        btn_seed.setBackground(new java.awt.Color(0, 0, 154));
        btn_seed.setForeground(new java.awt.Color(255, 255, 204));
        btn_seed.setText("seed");
        btn_seed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_seed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_seed.setFocusPainted(false);
        btn_seed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_seedMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_seedMouseEntered(evt);
            }
        });
        btn_seed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seedActionPerformed(evt);
            }
        });

        btn_source.setBackground(new java.awt.Color(0, 0, 154));
        btn_source.setForeground(new java.awt.Color(255, 255, 204));
        btn_source.setText("source");
        btn_source.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_source.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_source.setFocusPainted(false);
        btn_source.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_sourceMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sourceMouseEntered(evt);
            }
        });
        btn_source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sourceActionPerformed(evt);
            }
        });

        btn_trigger.setBackground(new java.awt.Color(0, 0, 154));
        btn_trigger.setForeground(new java.awt.Color(255, 255, 204));
        btn_trigger.setText("trigger");
        btn_trigger.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_trigger.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_trigger.setFocusPainted(false);
        btn_trigger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_triggerMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_triggerMouseEntered(evt);
            }
        });
        btn_trigger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_triggerActionPerformed(evt);
            }
        });

        btn_energy_grid.setBackground(new java.awt.Color(0, 0, 154));
        btn_energy_grid.setForeground(new java.awt.Color(255, 255, 204));
        btn_energy_grid.setText("energy_grid");
        btn_energy_grid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_energy_grid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_energy_grid.setFocusPainted(false);
        btn_energy_grid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_energy_gridMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_energy_gridMouseEntered(evt);
            }
        });
        btn_energy_grid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_energy_gridActionPerformed(evt);
            }
        });

        btn_cutoff.setBackground(new java.awt.Color(0, 0, 154));
        btn_cutoff.setForeground(new java.awt.Color(255, 255, 204));
        btn_cutoff.setText("cutoff");
        btn_cutoff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cutoff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cutoff.setFocusPainted(false);
        btn_cutoff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cutoffMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cutoffMouseEntered(evt);
            }
        });
        btn_cutoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cutoffActionPerformed(evt);
            }
        });

        btn_resonance_scattering.setBackground(new java.awt.Color(0, 0, 154));
        btn_resonance_scattering.setForeground(new java.awt.Color(255, 255, 204));
        btn_resonance_scattering.setText("resonance_scattering");
        btn_resonance_scattering.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_resonance_scattering.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_resonance_scattering.setFocusPainted(false);
        btn_resonance_scattering.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_resonance_scatteringMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_resonance_scatteringMouseEntered(evt);
            }
        });
        btn_resonance_scattering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resonance_scatteringActionPerformed(evt);
            }
        });

        btn_fixed_source.setBackground(new java.awt.Color(0, 0, 154));
        btn_fixed_source.setForeground(new java.awt.Color(255, 255, 204));
        btn_fixed_source.setText("fixed_source");
        btn_fixed_source.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_fixed_source.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_fixed_source.setFocusPainted(false);
        btn_fixed_source.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_fixed_sourceMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_fixed_sourceMouseEntered(evt);
            }
        });
        btn_fixed_source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fixed_sourceActionPerformed(evt);
            }
        });

        btn_no_reduce.setBackground(new java.awt.Color(0, 0, 154));
        btn_no_reduce.setForeground(new java.awt.Color(255, 255, 204));
        btn_no_reduce.setText("no_reduce");
        btn_no_reduce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_no_reduce.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_no_reduce.setFocusPainted(false);
        btn_no_reduce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_no_reduceMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_no_reduceMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_no_reduceMouseEntered(evt);
            }
        });
        btn_no_reduce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_no_reduceActionPerformed(evt);
            }
        });

        btn_survival_biasing.setBackground(new java.awt.Color(0, 0, 154));
        btn_survival_biasing.setForeground(new java.awt.Color(255, 255, 204));
        btn_survival_biasing.setText("survival_biasing");
        btn_survival_biasing.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_survival_biasing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_survival_biasing.setFocusPainted(false);
        btn_survival_biasing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_survival_biasingMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_survival_biasingMouseEntered(evt);
            }
        });
        btn_survival_biasing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_survival_biasingActionPerformed(evt);
            }
        });

        btn_eignvalue.setBackground(new java.awt.Color(0, 0, 154));
        btn_eignvalue.setForeground(new java.awt.Color(255, 255, 204));
        btn_eignvalue.setText("eigenvalue");
        btn_eignvalue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eignvalue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eignvalue.setFocusPainted(false);
        btn_eignvalue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_eignvalueMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_eignvalueMouseEntered(evt);
            }
        });
        btn_eignvalue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eignvalueActionPerformed(evt);
            }
        });

        btn_natural_elements.setBackground(new java.awt.Color(0, 0, 154));
        btn_natural_elements.setForeground(new java.awt.Color(255, 255, 204));
        btn_natural_elements.setText("natural_elements");
        btn_natural_elements.setToolTipText("");
        btn_natural_elements.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_natural_elements.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_natural_elements.setFocusPainted(false);
        btn_natural_elements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_natural_elementsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_natural_elementsMouseEntered(evt);
            }
        });
        btn_natural_elements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_natural_elementsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame9Layout = new javax.swing.GroupLayout(jInternalFrame9.getContentPane());
        jInternalFrame9.getContentPane().setLayout(jInternalFrame9Layout);
        jInternalFrame9Layout.setHorizontalGroup(
            jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_run_cmfd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_seed, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_source, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_track, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_state_point, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_source_point, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_threads, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_trace, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_survival_biasing, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btn_confidence_intervals, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cross_sections, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cutoff, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_eignvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_entropy, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_fixed_source, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_output, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_no_reduce, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_output_path, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_ptables, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_energy_grid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_natural_elements, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_log_grid_bins, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_resonance_scattering, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_verbosity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_uniform_fs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_trigger, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_comment_settings, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jInternalFrame9Layout.setVerticalGroup(
            jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_confidence_intervals, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_cross_sections, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_cutoff, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_eignvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_energy_grid, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_entropy, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_fixed_source, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_log_grid_bins, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_natural_elements, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_no_reduce, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_output, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_output_path, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_ptables, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_resonance_scattering, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_run_cmfd, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_seed, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_source, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_state_point, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_source_point, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_survival_biasing, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_threads, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_trace, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_track, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_trigger, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_uniform_fs, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_verbosity, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_comment_settings, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame10.setTitle("OpenMC XML Editor");
        jInternalFrame10.setVisible(true);

        jScrollPane5.setViewportView(settingsTxt);

        javax.swing.GroupLayout jInternalFrame10Layout = new javax.swing.GroupLayout(jInternalFrame10.getContentPane());
        jInternalFrame10.getContentPane().setLayout(jInternalFrame10Layout);
        jInternalFrame10Layout.setHorizontalGroup(
            jInternalFrame10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame10Layout.setVerticalGroup(
            jInternalFrame10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame11.setTitle("OpenMC commands guidance");
        jInternalFrame11.setVisible(true);

        Guide.setColumns(20);
        Guide.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        Guide.setLineWrap(true);
        Guide.setRows(5);
        Guide.setWrapStyleWord(true);
        jScrollPane14.setViewportView(Guide);

        javax.swing.GroupLayout jInternalFrame11Layout = new javax.swing.GroupLayout(jInternalFrame11.getContentPane());
        jInternalFrame11.getContentPane().setLayout(jInternalFrame11Layout);
        jInternalFrame11Layout.setHorizontalGroup(
            jInternalFrame11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame11Layout.setVerticalGroup(
            jInternalFrame11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout settings_pnlLayout = new javax.swing.GroupLayout(settings_pnl);
        settings_pnl.setLayout(settings_pnlLayout);
        settings_pnlLayout.setHorizontalGroup(
            settings_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_pnlLayout.createSequentialGroup()
                .addComponent(jInternalFrame9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame10))
            .addComponent(jInternalFrame11)
        );
        settings_pnlLayout.setVerticalGroup(
            settings_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_pnlLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(settings_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame11))
        );

        container.addTab("Settings ", settings_pnl);

        tallies_pnl.setBackground(java.awt.SystemColor.activeCaption);
        tallies_pnl.setPreferredSize(new java.awt.Dimension(1010, 668));

        jInternalFrame7.setTitle("OpenMC commands");
        jInternalFrame7.setVisible(true);

        btn_comment_tallies.setBackground(new java.awt.Color(0, 0, 154));
        btn_comment_tallies.setForeground(new java.awt.Color(255, 255, 204));
        btn_comment_tallies.setText("comment");
        btn_comment_tallies.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_comment_tallies.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_comment_tallies.setFocusPainted(false);
        btn_comment_tallies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_comment_talliesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_comment_talliesMouseEntered(evt);
            }
        });
        btn_comment_tallies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comment_talliesActionPerformed(evt);
            }
        });

        btn_mesh.setBackground(new java.awt.Color(0, 0, 154));
        btn_mesh.setForeground(new java.awt.Color(255, 255, 204));
        btn_mesh.setText("mesh");
        btn_mesh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_mesh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_mesh.setFocusPainted(false);
        btn_mesh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_meshMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_meshMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_meshMouseEntered(evt);
            }
        });
        btn_mesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meshActionPerformed(evt);
            }
        });

        btn_tally.setBackground(new java.awt.Color(0, 0, 154));
        btn_tally.setForeground(new java.awt.Color(255, 255, 204));
        btn_tally.setText("tally");
        btn_tally.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tally.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tally.setFocusPainted(false);
        btn_tally.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tallyMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tallyMouseEntered(evt);
            }
        });
        btn_tally.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tallyActionPerformed(evt);
            }
        });

        btn_assume_separate.setBackground(new java.awt.Color(0, 0, 154));
        btn_assume_separate.setForeground(new java.awt.Color(255, 255, 204));
        btn_assume_separate.setText("assume_separate");
        btn_assume_separate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_assume_separate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_assume_separate.setFocusPainted(false);
        btn_assume_separate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_assume_separateMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_assume_separateMouseEntered(evt);
            }
        });
        btn_assume_separate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_assume_separateActionPerformed(evt);
            }
        });

        btn_tally2.setBackground(new java.awt.Color(0, 0, 154));
        btn_tally2.setForeground(new java.awt.Color(255, 255, 204));
        btn_tally2.setText("filter");
        btn_tally2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tally2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tally2.setFocusPainted(false);
        btn_tally2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tally2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tally2MouseEntered(evt);
            }
        });
        btn_tally2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tally2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame7Layout = new javax.swing.GroupLayout(jInternalFrame7.getContentPane());
        jInternalFrame7.getContentPane().setLayout(jInternalFrame7Layout);
        jInternalFrame7Layout.setHorizontalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_mesh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_assume_separate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tally, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_comment_tallies, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tally2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jInternalFrame7Layout.setVerticalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_tally, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_tally2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_mesh, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_assume_separate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_comment_tallies, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jInternalFrame8.setTitle("OpenMC XML Editor");
        jInternalFrame8.setVisible(true);

        jScrollPane8.setViewportView(talliesTxt);

        javax.swing.GroupLayout jInternalFrame8Layout = new javax.swing.GroupLayout(jInternalFrame8.getContentPane());
        jInternalFrame8.getContentPane().setLayout(jInternalFrame8Layout);
        jInternalFrame8Layout.setHorizontalGroup(
            jInternalFrame8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame8Layout.setVerticalGroup(
            jInternalFrame8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame12.setTitle("OpenMC commands guidance");
        jInternalFrame12.setVisible(true);

        guide_tallies.setColumns(20);
        guide_tallies.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        guide_tallies.setLineWrap(true);
        guide_tallies.setRows(5);
        guide_tallies.setWrapStyleWord(true);
        jScrollPane20.setViewportView(guide_tallies);

        javax.swing.GroupLayout jInternalFrame12Layout = new javax.swing.GroupLayout(jInternalFrame12.getContentPane());
        jInternalFrame12.getContentPane().setLayout(jInternalFrame12Layout);
        jInternalFrame12Layout.setHorizontalGroup(
            jInternalFrame12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame12Layout.setVerticalGroup(
            jInternalFrame12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout tallies_pnlLayout = new javax.swing.GroupLayout(tallies_pnl);
        tallies_pnl.setLayout(tallies_pnlLayout);
        tallies_pnlLayout.setHorizontalGroup(
            tallies_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tallies_pnlLayout.createSequentialGroup()
                .addComponent(jInternalFrame7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame8))
            .addComponent(jInternalFrame12)
        );
        tallies_pnlLayout.setVerticalGroup(
            tallies_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tallies_pnlLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(tallies_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jInternalFrame12))
        );

        container.addTab("Tallies ", tallies_pnl);

        cmfd_pnl.setBackground(java.awt.SystemColor.activeCaption);

        jInternalFrame13.setTitle("OpenMC commands");
        jInternalFrame13.setVisible(true);

        btn_mesh_cmfd.setBackground(new java.awt.Color(0, 0, 154));
        btn_mesh_cmfd.setForeground(new java.awt.Color(255, 255, 204));
        btn_mesh_cmfd.setText("mesh");
        btn_mesh_cmfd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_mesh_cmfd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_mesh_cmfd.setFocusPainted(false);
        btn_mesh_cmfd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mesh_cmfdMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mesh_cmfdMouseEntered(evt);
            }
        });
        btn_mesh_cmfd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mesh_cmfdActionPerformed(evt);
            }
        });

        btn_gauss_seidel_tolerance.setBackground(new java.awt.Color(0, 0, 154));
        btn_gauss_seidel_tolerance.setForeground(new java.awt.Color(255, 255, 204));
        btn_gauss_seidel_tolerance.setText("gauss_seidel_tolerance");
        btn_gauss_seidel_tolerance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_gauss_seidel_tolerance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_gauss_seidel_tolerance.setFocusPainted(false);
        btn_gauss_seidel_tolerance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gauss_seidel_toleranceMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gauss_seidel_toleranceMouseEntered(evt);
            }
        });
        btn_gauss_seidel_tolerance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gauss_seidel_toleranceActionPerformed(evt);
            }
        });

        btn_norm.setBackground(new java.awt.Color(0, 0, 154));
        btn_norm.setForeground(new java.awt.Color(255, 255, 204));
        btn_norm.setText("norm");
        btn_norm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_norm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_norm.setFocusPainted(false);
        btn_norm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_normMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_normMouseEntered(evt);
            }
        });
        btn_norm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_normActionPerformed(evt);
            }
        });

        btn_power_monitor.setBackground(new java.awt.Color(0, 0, 154));
        btn_power_monitor.setForeground(new java.awt.Color(255, 255, 204));
        btn_power_monitor.setText("power_monitor");
        btn_power_monitor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_power_monitor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_power_monitor.setFocusPainted(false);
        btn_power_monitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_power_monitorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_power_monitorMouseEntered(evt);
            }
        });
        btn_power_monitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_power_monitorActionPerformed(evt);
            }
        });

        btn_write_matrices.setBackground(new java.awt.Color(0, 0, 154));
        btn_write_matrices.setForeground(new java.awt.Color(255, 255, 204));
        btn_write_matrices.setText("write_matrices");
        btn_write_matrices.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_write_matrices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_write_matrices.setFocusPainted(false);
        btn_write_matrices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_write_matricesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_write_matricesMouseEntered(evt);
            }
        });
        btn_write_matrices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_write_matricesActionPerformed(evt);
            }
        });

        btn_dhat_set.setBackground(new java.awt.Color(0, 0, 154));
        btn_dhat_set.setForeground(new java.awt.Color(255, 255, 204));
        btn_dhat_set.setText("dhat_set");
        btn_dhat_set.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_dhat_set.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dhat_set.setFocusPainted(false);
        btn_dhat_set.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dhat_setMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dhat_setMouseEntered(evt);
            }
        });
        btn_dhat_set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dhat_setActionPerformed(evt);
            }
        });

        btn_tally_reset.setBackground(new java.awt.Color(0, 0, 154));
        btn_tally_reset.setForeground(new java.awt.Color(255, 255, 204));
        btn_tally_reset.setText("tally_reset");
        btn_tally_reset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tally_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tally_reset.setFocusPainted(false);
        btn_tally_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tally_resetMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tally_resetMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tally_resetMouseEntered(evt);
            }
        });
        btn_tally_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tally_resetActionPerformed(evt);
            }
        });

        btn_display.setBackground(new java.awt.Color(0, 0, 154));
        btn_display.setForeground(new java.awt.Color(255, 255, 204));
        btn_display.setText("display");
        btn_display.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_display.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_display.setFocusPainted(false);
        btn_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_displayMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_displayMouseEntered(evt);
            }
        });
        btn_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_displayActionPerformed(evt);
            }
        });

        btn_shift.setBackground(new java.awt.Color(0, 0, 154));
        btn_shift.setForeground(new java.awt.Color(255, 255, 204));
        btn_shift.setText("shift");
        btn_shift.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_shift.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_shift.setFocusPainted(false);
        btn_shift.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_shiftMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_shiftMouseEntered(evt);
            }
        });
        btn_shift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_shiftActionPerformed(evt);
            }
        });

        btn_begin.setBackground(new java.awt.Color(0, 0, 154));
        btn_begin.setForeground(new java.awt.Color(255, 255, 204));
        btn_begin.setText("begin");
        btn_begin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_begin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_begin.setFocusPainted(false);
        btn_begin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_beginMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_beginMouseEntered(evt);
            }
        });
        btn_begin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_beginActionPerformed(evt);
            }
        });

        btn_downscatter.setBackground(new java.awt.Color(0, 0, 154));
        btn_downscatter.setForeground(new java.awt.Color(255, 255, 204));
        btn_downscatter.setText("downscatter");
        btn_downscatter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_downscatter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_downscatter.setFocusPainted(false);
        btn_downscatter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_downscatterMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_downscatterMouseEntered(evt);
            }
        });
        btn_downscatter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_downscatterActionPerformed(evt);
            }
        });

        run_adjoint.setBackground(new java.awt.Color(0, 0, 154));
        run_adjoint.setForeground(new java.awt.Color(255, 255, 204));
        run_adjoint.setText("run_adjoint");
        run_adjoint.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        run_adjoint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        run_adjoint.setFocusPainted(false);
        run_adjoint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                run_adjointMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                run_adjointMouseEntered(evt);
            }
        });
        run_adjoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                run_adjointActionPerformed(evt);
            }
        });

        btn_comment_cmfd.setBackground(new java.awt.Color(0, 0, 154));
        btn_comment_cmfd.setForeground(new java.awt.Color(255, 255, 204));
        btn_comment_cmfd.setText("comment");
        btn_comment_cmfd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_comment_cmfd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_comment_cmfd.setFocusPainted(false);
        btn_comment_cmfd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_comment_cmfdMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_comment_cmfdMouseEntered(evt);
            }
        });
        btn_comment_cmfd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comment_cmfdActionPerformed(evt);
            }
        });

        btn_stol.setBackground(new java.awt.Color(0, 0, 154));
        btn_stol.setForeground(new java.awt.Color(255, 255, 204));
        btn_stol.setText("stol");
        btn_stol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_stol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_stol.setFocusPainted(false);
        btn_stol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_stolMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_stolMouseEntered(evt);
            }
        });
        btn_stol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stolActionPerformed(evt);
            }
        });

        btn_ktol.setBackground(new java.awt.Color(0, 0, 154));
        btn_ktol.setForeground(new java.awt.Color(255, 255, 204));
        btn_ktol.setText("ktol");
        btn_ktol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ktol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ktol.setFocusPainted(false);
        btn_ktol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ktolMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ktolMouseEntered(evt);
            }
        });
        btn_ktol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ktolActionPerformed(evt);
            }
        });

        btn_feedback.setBackground(new java.awt.Color(0, 0, 154));
        btn_feedback.setForeground(new java.awt.Color(255, 255, 204));
        btn_feedback.setText("feedback");
        btn_feedback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_feedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_feedback.setFocusPainted(false);
        btn_feedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_feedbackMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_feedbackMouseEntered(evt);
            }
        });
        btn_feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_feedbackActionPerformed(evt);
            }
        });

        btn_spectral.setBackground(new java.awt.Color(0, 0, 154));
        btn_spectral.setForeground(new java.awt.Color(255, 255, 204));
        btn_spectral.setText("spectral");
        btn_spectral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_spectral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_spectral.setFocusPainted(false);
        btn_spectral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_spectralMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_spectralMouseEntered(evt);
            }
        });
        btn_spectral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_spectralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame13Layout = new javax.swing.GroupLayout(jInternalFrame13.getContentPane());
        jInternalFrame13.getContentPane().setLayout(jInternalFrame13Layout);
        jInternalFrame13Layout.setHorizontalGroup(
            jInternalFrame13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jInternalFrame13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_dhat_set, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_stol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_begin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_display, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_gauss_seidel_tolerance, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ktol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mesh_cmfd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_norm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(run_adjoint, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_shift, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_spectral, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_downscatter, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_power_monitor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_write_matrices, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tally_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_comment_cmfd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jInternalFrame13Layout.setVerticalGroup(
            jInternalFrame13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_begin, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_dhat_set, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_display, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_downscatter, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_gauss_seidel_tolerance, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_ktol, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_mesh_cmfd, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_norm, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_power_monitor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(run_adjoint, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_shift, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_spectral, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_stol, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_tally_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_write_matrices, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_comment_cmfd, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame14.setTitle("OpenMC XML Editor");
        jInternalFrame14.setVisible(true);

        jScrollPane9.setViewportView(cmfdTxt);

        javax.swing.GroupLayout jInternalFrame14Layout = new javax.swing.GroupLayout(jInternalFrame14.getContentPane());
        jInternalFrame14.getContentPane().setLayout(jInternalFrame14Layout);
        jInternalFrame14Layout.setHorizontalGroup(
            jInternalFrame14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame14Layout.setVerticalGroup(
            jInternalFrame14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame15.setTitle("OpenMC commands guidance");
        jInternalFrame15.setVisible(true);

        Guidecmfd.setColumns(20);
        Guidecmfd.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        Guidecmfd.setLineWrap(true);
        Guidecmfd.setRows(5);
        Guidecmfd.setWrapStyleWord(true);
        jScrollPane21.setViewportView(Guidecmfd);

        javax.swing.GroupLayout jInternalFrame15Layout = new javax.swing.GroupLayout(jInternalFrame15.getContentPane());
        jInternalFrame15.getContentPane().setLayout(jInternalFrame15Layout);
        jInternalFrame15Layout.setHorizontalGroup(
            jInternalFrame15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame15Layout.setVerticalGroup(
            jInternalFrame15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout cmfd_pnlLayout = new javax.swing.GroupLayout(cmfd_pnl);
        cmfd_pnl.setLayout(cmfd_pnlLayout);
        cmfd_pnlLayout.setHorizontalGroup(
            cmfd_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmfd_pnlLayout.createSequentialGroup()
                .addComponent(jInternalFrame13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame14))
            .addComponent(jInternalFrame15)
        );
        cmfd_pnlLayout.setVerticalGroup(
            cmfd_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmfd_pnlLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(cmfd_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame15))
        );

        container.addTab("CMFD ", cmfd_pnl);

        plotting_pnl.setBackground(java.awt.SystemColor.activeCaption);

        jInternalFrame16.setTitle("OpenMC commands");
        jInternalFrame16.setVisible(true);

        btn_comment_plotting.setBackground(new java.awt.Color(0, 0, 154));
        btn_comment_plotting.setForeground(new java.awt.Color(255, 255, 204));
        btn_comment_plotting.setText("comment");
        btn_comment_plotting.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_comment_plotting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_comment_plotting.setFocusPainted(false);
        btn_comment_plotting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_comment_plottingMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_comment_plottingMouseEntered(evt);
            }
        });
        btn_comment_plotting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comment_plottingActionPerformed(evt);
            }
        });

        btn_plot_voxel.setBackground(new java.awt.Color(0, 0, 154));
        btn_plot_voxel.setForeground(new java.awt.Color(255, 255, 204));
        btn_plot_voxel.setText("plot voxel");
        btn_plot_voxel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_plot_voxel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_plot_voxel.setFocusPainted(false);
        btn_plot_voxel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_plot_voxelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_plot_voxelMouseEntered(evt);
            }
        });
        btn_plot_voxel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_plot_voxelActionPerformed(evt);
            }
        });

        btn_plot_slice.setBackground(new java.awt.Color(0, 0, 154));
        btn_plot_slice.setForeground(new java.awt.Color(255, 255, 204));
        btn_plot_slice.setText("plot slice");
        btn_plot_slice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_plot_slice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_plot_slice.setFocusPainted(false);
        btn_plot_slice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_plot_sliceMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_plot_sliceMouseEntered(evt);
            }
        });
        btn_plot_slice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_plot_sliceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame16Layout = new javax.swing.GroupLayout(jInternalFrame16.getContentPane());
        jInternalFrame16.getContentPane().setLayout(jInternalFrame16Layout);
        jInternalFrame16Layout.setHorizontalGroup(
            jInternalFrame16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jInternalFrame16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_plot_voxel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_plot_slice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_comment_plotting, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jInternalFrame16Layout.setVerticalGroup(
            jInternalFrame16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_plot_slice, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_plot_voxel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_comment_plotting, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame17.setTitle("OpenMC XML Editor");
        jInternalFrame17.setVisible(true);

        jScrollPane10.setViewportView(plottingTxt);

        javax.swing.GroupLayout jInternalFrame17Layout = new javax.swing.GroupLayout(jInternalFrame17.getContentPane());
        jInternalFrame17.getContentPane().setLayout(jInternalFrame17Layout);
        jInternalFrame17Layout.setHorizontalGroup(
            jInternalFrame17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame17Layout.setVerticalGroup(
            jInternalFrame17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jInternalFrame18.setTitle("OpenMC commands guidance");
        jInternalFrame18.setVisible(true);

        GuidePlotting.setColumns(20);
        GuidePlotting.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        GuidePlotting.setLineWrap(true);
        GuidePlotting.setRows(5);
        GuidePlotting.setWrapStyleWord(true);
        jScrollPane22.setViewportView(GuidePlotting);

        javax.swing.GroupLayout jInternalFrame18Layout = new javax.swing.GroupLayout(jInternalFrame18.getContentPane());
        jInternalFrame18.getContentPane().setLayout(jInternalFrame18Layout);
        jInternalFrame18Layout.setHorizontalGroup(
            jInternalFrame18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jInternalFrame18Layout.setVerticalGroup(
            jInternalFrame18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout plotting_pnlLayout = new javax.swing.GroupLayout(plotting_pnl);
        plotting_pnl.setLayout(plotting_pnlLayout);
        plotting_pnlLayout.setHorizontalGroup(
            plotting_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plotting_pnlLayout.createSequentialGroup()
                .addComponent(jInternalFrame16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame17))
            .addComponent(jInternalFrame18)
        );
        plotting_pnlLayout.setVerticalGroup(
            plotting_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plotting_pnlLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(plotting_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame18))
        );

        container.addTab("Geometry Plotting ", plotting_pnl);

        lbl.setBackground(java.awt.SystemColor.activeCaption);
        lbl.setForeground(java.awt.Color.orange);
        lbl.setText("Project path");

        jMenuBar1.setBackground(new java.awt.Color(26, 24, 17));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(242, 240, 236));

        jMenu3.setBackground(new java.awt.Color(102, 255, 102));
        jMenu3.setForeground(new java.awt.Color(223, 219, 210));
        jMenu3.setText("File");

        menu_new_openmc_project.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menu_new_openmc_project.setText("New OpenMC project");
        menu_new_openmc_project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_new_openmc_projectActionPerformed(evt);
            }
        });
        jMenu3.add(menu_new_openmc_project);

        menu_existing_project.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menu_existing_project.setText("Open an existing project");
        menu_existing_project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_existing_projectActionPerformed(evt);
            }
        });
        jMenu3.add(menu_existing_project);

        menu_save_project.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menu_save_project.setText("Save project");
        menu_save_project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_save_projectActionPerformed(evt);
            }
        });
        jMenu3.add(menu_save_project);

        menu_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menu_exit.setText("Exit");
        menu_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_exitActionPerformed(evt);
            }
        });
        jMenu3.add(menu_exit);

        jMenuBar1.add(jMenu3);

        jMenu8.setBackground(new java.awt.Color(102, 255, 102));
        jMenu8.setForeground(new java.awt.Color(223, 219, 210));
        jMenu8.setText("Get OpenMC");

        jMenu_get_openmc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenu_get_openmc.setText("Get OpenMC");
        jMenu_get_openmc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_get_openmcActionPerformed(evt);
            }
        });
        jMenu8.add(jMenu_get_openmc);

        jMenuBar1.add(jMenu8);

        jMenu9.setBackground(new java.awt.Color(102, 255, 102));
        jMenu9.setForeground(new java.awt.Color(223, 219, 210));
        jMenu9.setText("Run OpenMC");

        jMenuItem_run_openmc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_run_openmc.setText("Run OpenMC");
        jMenuItem_run_openmc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_run_openmcActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem_run_openmc);

        jMenuBar1.add(jMenu9);

        Menu_tools.setBackground(new java.awt.Color(102, 255, 102));
        Menu_tools.setForeground(new java.awt.Color(241, 235, 221));
        Menu_tools.setText("Tools");
        Menu_tools.setPreferredSize(new java.awt.Dimension(73, 17));

        menu_item_show_results.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menu_item_show_results.setText("Show results");
        menu_item_show_results.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_show_resultsActionPerformed(evt);
            }
        });
        Menu_tools.add(menu_item_show_results);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem9.setText("View HDF5 file");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Menu_tools.add(jMenuItem9);

        jMenu4.setText("Geometry visualization");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setText("PPM file (2D)");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("VTI file (3D)");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        Menu_tools.add(jMenu4);

        jMenu6.setText("Data visualization");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText("Track visualization");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem10.setText("2D mesh plot");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        _3d_mesh_plot.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        _3d_mesh_plot.setText("3D mesh plot");
        _3d_mesh_plot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _3d_mesh_plotActionPerformed(evt);
            }
        });
        jMenu6.add(_3d_mesh_plot);

        Menu_tools.add(jMenu6);

        jMenu7.setText("File conversion");

        jMenuPPM2PNG.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuPPM2PNG.setText("ppm image to png");
        jMenuPPM2PNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPPM2PNGActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuPPM2PNG);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem4.setText("h5 VOXEL  to VTK");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenuItem_binary_track_to_pvtp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem_binary_track_to_pvtp.setText("binary TRACK  to PVTP");
        jMenuItem_binary_track_to_pvtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_binary_track_to_pvtpActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem_binary_track_to_pvtp);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem8.setText("3D MESH to VTM");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem8);

        Menu_tools.add(jMenu7);
        Menu_tools.add(jSeparator2);

        add_scorers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        add_scorers.setText("Add Scorers");
        add_scorers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_scorersActionPerformed(evt);
            }
        });
        Menu_tools.add(add_scorers);

        menu_item_table_of_nuclides.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menu_item_table_of_nuclides.setText("Table of nuclides");
        menu_item_table_of_nuclides.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_table_of_nuclidesActionPerformed(evt);
            }
        });
        Menu_tools.add(menu_item_table_of_nuclides);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("RGB color");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Menu_tools.add(jMenuItem2);

        jMenuItem_openmc_xml_validation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_openmc_xml_validation.setText("OpenMC XML validation");
        jMenuItem_openmc_xml_validation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_openmc_xml_validationActionPerformed(evt);
            }
        });
        Menu_tools.add(jMenuItem_openmc_xml_validation);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Memory Usage");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        Menu_tools.add(jMenuItem11);
        Menu_tools.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Project Tree");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Menu_tools.add(jMenuItem3);

        jMenuBar1.add(Menu_tools);

        jMenu5.setForeground(new java.awt.Color(241, 235, 221));
        jMenu5.setText("    ?");

        menu_item_about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menu_item_about.setText("About ERSN-OpenMC");
        menu_item_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_aboutActionPerformed(evt);
            }
        });
        jMenu5.add(menu_item_about);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl)
                        .addContainerGap())
                    .addComponent(container, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(container)
                .addGap(0, 0, 0)
                .addComponent(lbl))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
void guidance (javax.swing.JTextArea target, String text){

int caretPosition = target.getCaretPosition(); 
target.setText(text);
target.setCaretPosition(Math.min(caretPosition, target.getText().length()));

} 
    private void menu_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_exitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_menu_exitActionPerformed

    private void btn_surfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_surfaceActionPerformed
      geometryTxt.replaceSelection("<surface id=\"\" type=\"\" coeffs=\"\" boundary=\"\"/>\n"); 
    }//GEN-LAST:event_btn_surfaceActionPerformed

    private void btn_materialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_materialActionPerformed
      materialsTxt.replaceSelection("<material id=\"\" >\n  <density value=\"\" units=\"\" />\n  <nuclide name=\"\" xs=\"\" ao=\"\" />\n  <element name=\"\" ao=\"\" />\n  <sab name=\"\" xs=\"\"  />\n</material>\n"); 
    }//GEN-LAST:event_btn_materialActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
text_heighlighter();
get_scripts_dir();
project_full_path=tmp.getPath();  
if (open_action.equals("no") || project_full_path.isEmpty()==false){

//
    open_all_xml_files();
//
    save_all_xml_files();
}
    }//GEN-LAST:event_formWindowActivated
                               

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
text_heighlighter();

String 
         bashdir_files="";
 try    {  
     bashdir_files=  getJarContainingFolder(ERSNOpenMC_Main.class)+"/scripts";  

 } catch (Exception  ex) {System.out.print(ex);}
 /* 
 try    {  
 
Process p_get_hdf5 = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/get_hdf5.sh");
Process p_get_openmc = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/get_openmc.sh");
Process p_get_openmc_with_mpich2 = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/get_openmc-with-mpich2.sh");
Process pb_get_openmc_with_openmpi = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/get_openmc-with-openmpi.sh");
Process pb_get_openmc_with_openmp = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/get_openmc-with-openmp.sh");
Process pb_start_openmc = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/start_openmc.sh");
Process p_get_nndc = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/get_nndc.sh");
Process p_get_hdf5_parallel = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/get_hdf5_parallel.sh");
Process p_track = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/track.sh");
Process p_openmc_xml_validation = Runtime.getRuntime().exec("xterm -iconic -title ERSN-OpenMC_Console -e chmod +x "+bashdir_files+"/openmc-xml-validation.sh");

 } 
 catch (IOException  ex) { System.out.print(ex);  }
 */
          }//GEN-LAST:event_formWindowOpened

    private void btn_cellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cellActionPerformed
      geometryTxt.replaceSelection(
          "<cell id=\"\" >\n"
        + "   <material>  </material>        \n"
        + "   <region>  </region>            \n"
        + "   <universe>  </universe>        \n"
        + "   <fill>  </fill>                \n"
        + "   <rotation>  </rotation>        \n"
        + "   <translation>  </translation>  \n"
        + "</cell>\n"); 
    }//GEN-LAST:event_btn_cellActionPerformed

    private void btn_tallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tallyActionPerformed
//int caretPosition = talliesTxt.getCaretPosition(); 
talliesTxt.replaceSelection(
          "<tally id=\"\" >\n  <name >  </name>\n"
        + "  <filters>  </filters>\n"
        + "  <scores >  </scores>\n"
        + "  <nuclides> </nuclides>\n"
        + "  <trigger>\n"
        + "      <type> </type>\n"
        + "      <threshold> </threshold>\n"  
        + "      <scores> </scrores>\n" 
        + "  </trigger>\n"
        + "</tally>\n"); 
//talliesTxt.setCaretPosition(Math.min(caretPosition, talliesTxt.getText().length()));             
    }//GEN-LAST:event_btn_tallyActionPerformed

    private void menu_save_projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_save_projectActionPerformed
save_xml_file("settings.xml",project_full_path,settingsTxt);
save_xml_file("materials.xml",project_full_path,materialsTxt);
save_xml_file("geometry.xml",project_full_path,geometryTxt);
if (talliesTxt.getText().isEmpty()== false) {save_xml_file("tallies.xml",project_full_path,talliesTxt);}
if (plottingTxt.getText().isEmpty()==false) {save_xml_file("plots.xml",project_full_path,plottingTxt);}
if (cmfdTxt.getText().isEmpty()==false) {save_xml_file("cmfd.xml",project_full_path,cmfdTxt);}
showMessageDialog(this.getParent(), "The project has been successfully saved ! ", "", JOptionPane.INFORMATION_MESSAGE) ;      
System.out.print(project_full_path);
    }//GEN-LAST:event_menu_save_projectActionPerformed

    private void menu_existing_projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_existing_projectActionPerformed
        open_action="yes";
        JFileChooser fc = new JFileChooser(); 
        fc.setDialogTitle("Open an exsisting OpenMC project");
        fc.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
            file_name = file.toString( );
            project_full_path=file_name;
            tmp.setPath(project_full_path);
            open_all_xml_files();
            JOptionPane.showMessageDialog(this, "The project entitled '"+file.getName()+"' has been successfully opened ! ");
        }
    }//GEN-LAST:event_menu_existing_projectActionPerformed

    private void btn_defaults_xsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_defaults_xsActionPerformed
        materialsTxt.replaceSelection("<default_xs>  </default_xs>\n");    
    }//GEN-LAST:event_btn_defaults_xsActionPerformed

    private void btn_latticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_latticeActionPerformed
        geometryTxt.replaceSelection(
             "<lattice id=\" \" dimension=\" \" outer=\" \">\n" 
      
      +"   <lower_left>   </lower_left> \n" 
            +"   <pitch>  </pitch> \n" 
            +"   <universes>  \n\n"
            +"   </universes> \n" 
            +"</lattice>\n"); 
    }//GEN-LAST:event_btn_latticeActionPerformed
    private void btn_meshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meshActionPerformed
        talliesTxt.replaceSelection(
                "<mesh id=\"\">\n" +
                "  <type>   </type> \n" +
                "  <dimension>  </dimension> \n" +
                "  <upper_right>   </upper_right> \n" +
                "  <lower_left>   </lower_left> \n" +
                "  <width>  </width> \n" +
                "</mesh>\n");    
    }//GEN-LAST:event_btn_meshActionPerformed

    private void btn_assume_separateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assume_separateActionPerformed
//talliesTxt.replaceSelection("<assume_separate> false </assume_separate>");    }//GEN-LAST:event_btn_assume_separateActionPerformed
        talliesTxt.replaceSelection("<assume_separate> false </assume_separate>\n");    }
        
    private void btn_plot_sliceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plot_sliceActionPerformed
        plottingTxt.replaceSelection(
                "<plot id=\"\" color_by=\"\"  type=\"slice\" basis=\"\" background=\"\">\n" +
                "  <origin> </origin>\n" +
                "  <pixels>  </pixels>\n" +
                "  <width> </width>\n" +
                "  <col_spec id=\"\" rgb=\"\"><col_spec>\n" +
                "  <mask> </mask>\n" +
                "</plot>\n" 
);                                             
    }//GEN-LAST:event_btn_plot_sliceActionPerformed

    private void btn_plot_voxelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plot_voxelActionPerformed
        plottingTxt.replaceSelection(
                "\n" +
                "<plot id=\"\" color_by=\"\"  type=\"voxel\" background=\"\">\n" +
                "  <origin> </origin>\n" +
                "  <pixels>  </pixels>\n" +
                "  <width> </width>\n" +
                "  <col_spec id=\"\" rgb=\"\"><col_spec>\n" +
                "  <mask> </mask>\n" +
                "</plot>\n"
);            }//GEN-LAST:event_btn_plot_voxelActionPerformed

    private void btn_beginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_beginActionPerformed
        cmfdTxt.replaceSelection("<begin>  </begin>\n");                                            
    }//GEN-LAST:event_btn_beginActionPerformed

    private void btn_displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_displayActionPerformed
        cmfdTxt.replaceSelection("<display> </display>\n");                                            
    }//GEN-LAST:event_btn_displayActionPerformed

    private void btn_feedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_feedbackActionPerformed
        cmfdTxt.replaceSelection("<feedback>  </feedback>\n");                                            
    }//GEN-LAST:event_btn_feedbackActionPerformed

    private void btn_gauss_seidel_toleranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gauss_seidel_toleranceActionPerformed
        cmfdTxt.replaceSelection("<gauss_seidel_tolerance>  </gauss_seidel_tolerance>\n");                                            
    }//GEN-LAST:event_btn_gauss_seidel_toleranceActionPerformed

    private void btn_ktolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ktolActionPerformed
        cmfdTxt.replaceSelection("<ktol>  </ktol>\n");                                            
    }//GEN-LAST:event_btn_ktolActionPerformed

    private void btn_stolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stolActionPerformed
        cmfdTxt.replaceSelection("<stol>  </stol>\n");                                            
    }//GEN-LAST:event_btn_stolActionPerformed

    private void btn_mesh_cmfdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mesh_cmfdActionPerformed
        cmfdTxt.replaceSelection(
                "<mesh>\n" +
                "  <dimension>  </dimension>\n" +
                "  <upper_right>   </upper_right>\n" +
                "  <lower_left>   </lower_left>\n" +
                "  <energy>   </energy>\n" +
                "  <albedo>   </albedo>\n" +
                "  <width>  </width>\n" +       
                "  <map>  </map>\n" +
                "  <universes>\n\n" +
                "  </universes>\n" +
                "</mesh>\n");                                            
    }//GEN-LAST:event_btn_mesh_cmfdActionPerformed

    private void btn_normActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_normActionPerformed
        cmfdTxt.replaceSelection("<norm>  </norm>\n");                                            
    }//GEN-LAST:event_btn_normActionPerformed

    private void btn_downscatterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_downscatterActionPerformed
        cmfdTxt.replaceSelection("<downscatter>  </downscatter>\n");                                            
    }//GEN-LAST:event_btn_downscatterActionPerformed

    private void run_adjointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_run_adjointActionPerformed
        cmfdTxt.replaceSelection("<run_adjoint>  </run_adjoint>\n");                                            
    }//GEN-LAST:event_run_adjointActionPerformed

    private void btn_power_monitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_power_monitorActionPerformed
        cmfdTxt.replaceSelection("<power_monitor>  </power_monitor>\n");                                            
    }//GEN-LAST:event_btn_power_monitorActionPerformed

    private void btn_shiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_shiftActionPerformed
        cmfdTxt.replaceSelection("<shift>  </shift>\n");                                            
    }//GEN-LAST:event_btn_shiftActionPerformed

    private void btn_spectralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_spectralActionPerformed
        cmfdTxt.replaceSelection("<spectral>  </spectral>\n");                                            
    }//GEN-LAST:event_btn_spectralActionPerformed

    private void btn_tally_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tally_resetActionPerformed
        cmfdTxt.replaceSelection("<tally_reset>  </tally_reset>\n");                                            
    }//GEN-LAST:event_btn_tally_resetActionPerformed

    private void menu_new_openmc_projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_new_openmc_projectActionPerformed

        open_action="no";       
        ERSNOpenMC_New_project  dialgo  =new     ERSNOpenMC_New_project();
        dialgo.show();     
        //this.show(false);
    }//GEN-LAST:event_menu_new_openmc_projectActionPerformed

    private void menu_item_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_aboutActionPerformed
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        
            @Override
    public void run() {
        ERSNOpenMC_About myabout  =new     ERSNOpenMC_About();
        myabout.show();
    }   }); 
    }//GEN-LAST:event_menu_item_aboutActionPerformed

    private void btn_comment_materialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comment_materialsActionPerformed
       
        materialsTxt.replaceSelection(" <!--            -->  \n");
        
    }//GEN-LAST:event_btn_comment_materialsActionPerformed

    private void btn_comment_talliesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comment_talliesActionPerformed
        talliesTxt.replaceSelection(" <!--            -->  \n"); 
    }//GEN-LAST:event_btn_comment_talliesActionPerformed

    private void btn_comment_plottingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comment_plottingActionPerformed
        plottingTxt.replaceSelection(" <!--            -->  \n");
   
    }//GEN-LAST:event_btn_comment_plottingActionPerformed

    private void btn_comment_cmfdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comment_cmfdActionPerformed
        cmfdTxt.replaceSelection(" <!--            -->  \n");       
    }//GEN-LAST:event_btn_comment_cmfdActionPerformed

    private void btn_comment_geometryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comment_geometryActionPerformed
        geometryTxt.replaceSelection(" <!--            -->  \n");   
    }//GEN-LAST:event_btn_comment_geometryActionPerformed

    private void menu_item_show_resultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_show_resultsActionPerformed
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ERSNOpenMC_Output().setVisible(true);
            }
        });
    }//GEN-LAST:event_menu_item_show_resultsActionPerformed

    private void btn_dhat_setMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dhat_setMouseEntered
        btn_dhat_set.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
        guidance (Guidecmfd,"The <dhat_reset> element controls whether \\widehat{D} nonlinear CMFD parameters should be reset to zero before solving CMFD eigenproblem. It can be turned on with “true” and off with “false”.\n" +
"\n" +
"Default: false");
  
    }//GEN-LAST:event_btn_dhat_setMouseEntered

    private void btn_beginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_beginMouseEntered
       btn_begin.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
 guidance (Guidecmfd,"The <begin> element controls what batch CMFD calculations should begin.\n" +
"\n" +
"    Default: 1");
    }//GEN-LAST:event_btn_beginMouseEntered

    private void btn_displayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_displayMouseEntered
        btn_display.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"The <display> element sets one additional CMFD output column. Options are:\n" +
"“balance” - prints the RMS [%] of the resdiual from the neutron balance equation on CMFD tallies.\n" +
"“dominance” - prints the estimated dominance ratio from the CMFD iterations. This will only work for power iteration eigensolver.\n" +
"“entropy” - prints the entropy of the CMFD predicted fission source. Can only be used if OpenMC entropy is active as well.\n" +
" “source” - prints the RMS [%] between the OpenMC fission source and CMFD fission source. \nDefault: None");
    }//GEN-LAST:event_btn_displayMouseEntered

    private void btn_feedbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_feedbackMouseEntered
        btn_feedback.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
        guidance (Guidecmfd,"The <feedback> element controls whether or not the CMFD diffusion result is used to adjust the weight of fission source neutrons on the next OpenMC batch. It can be turned on with “true” and off with “false”.Default: false");
    }//GEN-LAST:event_btn_feedbackMouseEntered

    private void btn_gauss_seidel_toleranceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gauss_seidel_toleranceMouseEntered
        btn_gauss_seidel_tolerance.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
        guidance (Guidecmfd,"The <gauss_seidel_tolerance> element specifies two parameters. The first is the absolute inner tolerance for Gauss-Seidel iterations when performing CMFD and the second is the relative inner tolerance for Gauss-Seidel iterations for CMFD calculations.\n" +
        "\n" +
        "Default: 1.e-10 1.e-5");
    }//GEN-LAST:event_btn_gauss_seidel_toleranceMouseEntered

    private void btn_ktolMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ktolMouseEntered
      btn_ktol.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (Guidecmfd,"The <ktol> element specifies the tolerance on the eigenvalue when performing CMFD power iteration.\n" +
"\n" +
"Default: 1.e-8");
    }//GEN-LAST:event_btn_ktolMouseEntered

    private void btn_comment_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comment_settingsActionPerformed

        settingsTxt.replaceSelection("<!--            -->  \n" );
     
    }//GEN-LAST:event_btn_comment_settingsActionPerformed

    private void btn_sourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sourceActionPerformed
        settingsTxt.replaceSelection("<source>\n" +
            "  <file>  </file>\n" +
            "  <space>  \n" +
            "    <type> </type> \n" +
            "    <parameters> </parameters>  \n" +
            "  </space>\n" +
            "  <angle>  \n" +
            "    <type> </type> \n" +
            "    <parameters> </parameters>  \n" +
            "  </angle>\n" +
            "  <energy>  \n" +
            "    <type> </type> \n" +
            "    <parameters> </parameters>  \n" +
            "  </energy>\n" +
            "</source>\n");
    }//GEN-LAST:event_btn_sourceActionPerformed

    private void btn_verbosityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verbosityActionPerformed
        settingsTxt.replaceSelection("<verbosity  value=\"5\"/>\n");
    }//GEN-LAST:event_btn_verbosityActionPerformed

    private void btn_uniform_fsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uniform_fsActionPerformed
        settingsTxt.replaceSelection("<uniform_fs>\n" +
            "  <lower_left>   </lower_left>\n" +
            "  <upper_right>   </upper_right>\n" +
            "  <dimension>   </dimension>\n" +
            "</uniform_fs>\n");
    }//GEN-LAST:event_btn_uniform_fsActionPerformed

    private void btn_trackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trackActionPerformed
        settingsTxt.replaceSelection("<track> " +
            "</track>\n");
    }//GEN-LAST:event_btn_trackActionPerformed

    private void btn_traceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_traceActionPerformed
        settingsTxt.replaceSelection("<trace>  </trace>\n");

    }//GEN-LAST:event_btn_traceActionPerformed

    private void btn_threadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_threadsActionPerformed
        settingsTxt.replaceSelection("<threads>  </threads>\n");
    }//GEN-LAST:event_btn_threadsActionPerformed

    private void btn_survival_biasingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_survival_biasingActionPerformed
        settingsTxt.replaceSelection("<survival_biasing> false </survival_biasing>\n");
    }//GEN-LAST:event_btn_survival_biasingActionPerformed

    private void btn_state_pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_state_pointActionPerformed
        settingsTxt.replaceSelection("<state_point>\n" +
            "  <batches>  </batches>\n" +
            "  <interval>  </interval>\n" +
            "</state_point>\n");
       
    }//GEN-LAST:event_btn_state_pointActionPerformed

    private void btn_seedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seedActionPerformed
        settingsTxt.replaceSelection("<seed> 1 </seed>\n");
    }//GEN-LAST:event_btn_seedActionPerformed

    private void btn_run_cmfdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_run_cmfdActionPerformed
        settingsTxt.replaceSelection("<run_cmfd> false </run_cmfd>\n");
    }//GEN-LAST:event_btn_run_cmfdActionPerformed

    private void btn_ptablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ptablesActionPerformed
        settingsTxt.replaceSelection("<ptables> true </ptables>\n");
    }//GEN-LAST:event_btn_ptablesActionPerformed

    private void btn_output_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_output_pathActionPerformed
        settingsTxt.replaceSelection("<output_path>  </output_path>\n");
    }//GEN-LAST:event_btn_output_pathActionPerformed

    private void btn_outputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_outputActionPerformed
        settingsTxt.replaceSelection("<output>\n" +
            "  <cross_sections> false  </cross_sections>\n" +
            "  <summary> false  </summary> \n" +
            "  <tallies> false </tallies>  \n" +
            "</output>\n");
    }//GEN-LAST:event_btn_outputActionPerformed

    private void btn_no_reduceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_no_reduceActionPerformed
        settingsTxt.replaceSelection("<no_reduce> false </no_reduce>\n");
    }//GEN-LAST:event_btn_no_reduceActionPerformed

    private void btn_fixed_sourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fixed_sourceActionPerformed
        settingsTxt.replaceSelection("<run_mode>fixed_source</run_mode>\n" +
            "  <batches>    </batches>\n" +
            "  <particles>   </particles>\n");
    }//GEN-LAST:event_btn_fixed_sourceActionPerformed

    private void btn_entropyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entropyActionPerformed
        settingsTxt.replaceSelection("<entropy>\n" +
            "  <lower_left>   </lower_left>\n" +
            "  <upper_right>   </upper_right>\n" +
            "  <dimension>   </dimension>\n" +
            "</entropy>\n");
    }//GEN-LAST:event_btn_entropyActionPerformed

    private void btn_energy_gridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_energy_gridActionPerformed
        settingsTxt.replaceSelection("<energy_grid> union </energy_grid>\n");
    }//GEN-LAST:event_btn_energy_gridActionPerformed

    private void btn_eignvalueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eignvalueActionPerformed
        settingsTxt.replaceSelection("<run_mode>eigenvalue</run_mode>   <!-- avoid space around numbers -->\n" +
                "   <batches> </batches>\n" +
                "   <generations_per_batch>" +
                "   </generations_per_batch>\n" +
                "   <inactive> </inactive> \n" +
                "   <particles> </particles> \n");
    }//GEN-LAST:event_btn_eignvalueActionPerformed

    private void btn_cutoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cutoffActionPerformed
        settingsTxt.replaceSelection("<cutoff> \n <weight> 0.25 </weight> \n <weight_avg> 1 </weight_avg> \n</cutoff>\n");
    }//GEN-LAST:event_btn_cutoffActionPerformed

    private void btn_cross_sectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cross_sectionsActionPerformed
        settingsTxt.replaceSelection("<cross_sections>  </cross_sections>\n");
    }//GEN-LAST:event_btn_cross_sectionsActionPerformed

    private void btn_confidence_intervalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confidence_intervalsActionPerformed
        settingsTxt.replaceSelection("<confidence_intervals> false </confidence_intervals> \n");
    }//GEN-LAST:event_btn_confidence_intervalsActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
save_xml_file("settings.xml",project_full_path,settingsTxt);
save_xml_file("materials.xml",project_full_path,materialsTxt);
save_xml_file("geometry.xml",project_full_path,geometryTxt);
if (talliesTxt.getText().isEmpty()==false) {save_xml_file("tallies.xml",project_full_path,talliesTxt);}
if (plottingTxt.getText().isEmpty()==false) {save_xml_file("plots.xml",project_full_path,plottingTxt);}
if (cmfdTxt.getText().isEmpty()==false) {save_xml_file("cmfd.xml",project_full_path,cmfdTxt);}

    }//GEN-LAST:event_formWindowDeactivated

    private void btn_materialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_materialMouseEntered
        btn_material.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (guide_materials,"Each material element can have the following attributes or sub-elements:\n" +
"id: A unique integer that can be used to identify the material.\n" +
"density: An element with attributes/sub-elements called value and units. The value attribute is the numeric value of the density while the units can be “g/cm3”, “kg/m3”, “atom/b-cm”, “atom/cm3”, or “sum”. The “sum” unit indicates that the density should be calculated as the sum of the atom fractions for each nuclide in the material. This should not be used in conjunction with weight percents. Default: None\n" +
"nuclide: An element with attributes/sub-elements called name, xs, and ao or wo. The name attribute is the name of the cross-section for a desired nuclide while the xs attribute is the cross-section identifier. Finally, the ao and wo attributes specify the atom or weight percent of that nuclide within the material, respectively element:	\n" +
"Specifies that a natural element is present in the material. The natural element is split up into individual isotopes based on IUPAC Isotopic Compositions of the Elements 2009. This element has attributes/sub-elements called name, xs, and ao. The name attribute is the atomic symbol of the element while the xs attribute is the cross-section identifier. Finally, the ao attribute specifies the atom percent of the element within the material, respectively. In some cross section libraries, certain naturally occurring isotopes do not have cross sections. The <natural_elements> Element option determines how a natural element is split into isotopes in these cases. Default: None\n sab: Associates an S(a,b) table with the material. This element has attributes/sub-elements called name and xs. The name attribute is the name of the S(a,b) table that should be associated with the material, and xs is the cross-section identifier for the table. Default: None");

    }//GEN-LAST:event_btn_materialMouseEntered

    private void btn_defaults_xsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_defaults_xsMouseEntered
        btn_defaults_xs.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (guide_materials,"In some circumstances, the cross-section identifier may be the same for many or all nuclides in a given problem. In this case, rather than specifying the xs=... attribute on every nuclide, a <default_xs> element can be used to set the default cross-section identifier for any nuclide without an identifier explicitly listed. This element has no attributes and accepts a 3-letter string that indicates the default cross-section identifier, e.g. “70c”. " +
"    Default: None");
    }//GEN-LAST:event_btn_defaults_xsMouseEntered

    private void btn_surfaceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_surfaceMouseEntered

        btn_surface.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (guide_geometry,"Each <surface> element can have the following attributes or sub-elements:\n" +
"id: A unique integer that can be used to identify the surface. Default: None \n" +
"type: The type of the surfaces. This can be “x-plane”, “y-plane”, “z-plane”, “plane”, “x-cylinder”, “y-cylinder”, “z-cylinder”, “sphere”, “x-cone”, “y-cone”, “z-cone”, or “quadric”. Default: None\n" +
"coeffs: The corresponding coefficients for the given type of surface. See below for a list a what coefficients to specify for a given surface. Default: None\n" +
"boundary: The boundary condition for the surface. This can be “transmission”, “vacuum”, or “reflective. Default: “transmission”");             
    }//GEN-LAST:event_btn_surfaceMouseEntered

    private void btn_cellMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cellMouseEntered
        btn_cell.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (guide_geometry,"Each <cell> element can have the following attributes or sub-elements:\n" +
"id: A unique integer that can be used to identify the surface. Default: None\n" +
"universe: The id of the universe that this cell is contained in. Default: 0\n" +
"fill: The id of the universe that fills this cell.\n material: The id of the material that this cell contains. If the cell should contain no material, this can also be set to “void”. Default: None\n" +
"region: A list of the ids for surfaces that bound this cell, e.g. if the cell is on the negative side of surface 3 and the positive side of surface 5, the bounding surfaces would be given as “-3 5”. Note: surfaces have been replaced by region in openmc release 0.7.1.  Default: None\n" +
"rotation: If the cell is filled with a universe, this element specifies the angles in degrees about the x, y, and z axes that the filled universe should be rotated. Should be given as three real numbers. Rotation can be omitted if no rotation is applyed. Default: None\n" +
"translation: If the cell is filled with a universe, this element specifies a vector that is used to translate (shift) the universe. Should be given as three real numbers. Translation can be omitted if no translation is applyed. Default: None");  
    }//GEN-LAST:event_btn_cellMouseEntered

    private void btn_latticeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_latticeMouseEntered
        btn_lattice.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    
guidance (guide_geometry,"The <lattice> can be used to represent repeating structures (e.g. fuel pins in an assembly) or other geometry which naturally fits into a two- or three-dimensional structured mesh. Each cell within the lattice is filled with a specified universe. A <lattice> accepts the following attributes or sub-elements:\n" +
"id: A unique integer that can be used to identify the surface.\n" +
"type: A string indicating the arrangement of lattice cells. Currently, the only accepted option is “rectangular”. Default: rectangular\n" +
"dimension: Two or three integers representing the number of lattice cells in the x- and y- (and z-) directions, respectively. " +
"Default: None \n lower_left: The coordinates of the lower-left corner of the lattice. If the lattice is two-dimensional, only the x- and y-coordinates are specified. Default: None\n" +
"width: The width of the lattice cell in the x- and y- (and z-) directions. Default: None\n" +
"outside: The unique integer identifier of a material that is to be used to fill all space outside of the lattice. This element is optional. Default: The region outside the defined lattice is treated as void.\n" +
"universes: A list of the universe numbers that fill each cell of the lattice. Default: None\n" +
"Here is an example of a properly defined 2d rectangular lattice:\n" +
"   <lattice id=\"10\" dimension=\"3 3\" outer=\"1\">\n" +
"    <lower_left> -1.5 -1.5 </lower_left>\n" +
"    <pitch> 1.0 1.0 </pitch>\n" +
"    <universes>\n" +
"      2 2 2\n" +
"      2 1 2\n" +
"      2 2 2\n" +
"    </universes>\n" +
"   </lattice>"        
        );
    }//GEN-LAST:event_btn_latticeMouseEntered

    private void menu_item_table_of_nuclidesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_table_of_nuclidesActionPerformed
        ERSNOpenMC_Table_of_nuclides  dialgo  =new ERSNOpenMC_Table_of_nuclides();
  dialgo.show();     }//GEN-LAST:event_menu_item_table_of_nuclidesActionPerformed

    private void btn_tallyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tallyMouseEntered
        btn_tally.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (guide_tallies,"The <tally> element accepts the following sub-elements:\n\n" 
+ "name:     This is an optional sub-element specifying the name of this tally to be used for output purposes. This string is limited to 52 characters for formatting purposes.\n" 
+ "filter:   Specify a filter that restricts contributions to the tally to particles within certain regions of phase space.\n The filter element has the following attributes/sub-elements:\n"
+ "        type:   The type of the filter. Accepted options are “cell”, “cellborn”, “material”, “universe”, “energy”, “energyout”, “mesh”, “distribcell”, “mu”, “polar”, “azimutal”, and “delayedgroup”. \n"
+ "        bins:   For each filter type, the corresponding bins entry corresponds to identifiers and/or values of the above type entries.  \n\n"
+ "                example: <filter type=\"energy\" bins=\"0.0 1.0 20.0\" />   \n"
+ "                         <filter type=\"energy\" bins=\"0.0 1.0 20.0\" />   \n"
+ "                         <filter type=\"energyout\" bins=\"0.0 1.0 20.0\" />   \n"
+ "                         <filter type=\"mu\" bins=\"-1.0 -0.6 -0.2 0.2 0.6 1.0\" /> \n"
+ "                      or <filter type=\"mu\" bins=\"5\" />\n" 
+ "                         <filter type=\"polar\" bins=\"0.0 0.6283 1.2566 1.8850 2.5132 3.1416\"/> \n"
+ "                      or <filter type=\"polar\" bins=\"5\" /> \n"
+ "                         <filter type=\"azimuthal\" bins=\"0.0 3.1416 6.2832\" /> \n"
+ "                      or <filter type=\"azimuthal\" bins=\"2\" />\n"
+ "                         <filter type=\"delayedgroup\" bins=\"1 2 3 4 5 6\" /> to tally to all 6 delayed groups in the ENDF/B-VII.1 library  \n"
+ "   \n"
+ "nuclides: If specified, the scores listed will be for particular nuclides, not the summation of reactions from all nuclides. \n"
+ "          The format for nuclides should be [Atomic symbol]-[Mass number], e.g. “U-235”. The reaction rate for all nuclides can \n"
+ "          be obtained with “total”. Use: <nuclides>U-235 Pu-239 total</nuclides>  \n\n "
+ "estimator: The estimator element is used to force the use of either analog or tracklength tally estimation.  \n\n"
+ "scores:   A space-separated list of the desired responses to be accumulated. \n"
+ "          Accepted options are : “flux”, “total”, “scatter”, “absorption”, “fission”, “nu-fission”, “delayed-nu-fission”, “kappa-fission”, “nu-scatter”, \n"
+ "          “scatter-N”, “scatter-PN”, “scatter-YN”, “nu-scatter-N”, “nu-scatter-PN”, “nu-scatter-YN”, “flux-YN”, “total-YN”, \n"
+ "          “current”, “inverse-velocity” and “events”. \n\n "
+ "trigger:  Precision trigger applied to all filter bins and nuclides for this tally. It must specify the trigger’s type, \n"
+ "          threshold and scores to which it will be applied. It has the following attributes/sub-elements:\n" 
+ "        type:      The type of the trigger. Accepted options are “variance”, “std_dev”, and “rel_err”.\n"
+ "        threshold: The precision trigger’s convergence criterion for tallied values.\n" 
+ "        scores:    The score(s) in this tally to which the trigger should be applied.\n\n");
       
    }//GEN-LAST:event_btn_tallyMouseEntered

    private void btn_tally_resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tally_resetMouseEntered
      btn_tally_reset.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (Guidecmfd,"The <tally_reset> element contains a list of batch numbers in which CMFD tallies should be reset.\n" +
"\n" +
"Default: None");

    }//GEN-LAST:event_btn_tally_resetMouseEntered

    private void btn_stolMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stolMouseEntered
     btn_stol.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (Guidecmfd,"The <stol> element specifies the tolerance on the fission source when performing CMFD power iteration.\n" +
"\n" +
"Default: 1.e-8");
    }//GEN-LAST:event_btn_stolMouseEntered

    private void btn_comment_geometryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_geometryMouseEntered
       btn_comment_geometry.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

        guidance (guide_geometry,"Comment");
    }//GEN-LAST:event_btn_comment_geometryMouseEntered

    private void btn_surfaceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_surfaceMouseExited
       btn_surface.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_surfaceMouseExited

    private void btn_surfaceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_surfaceMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_surfaceMousePressed

    private void btn_comment_materialsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_materialsMouseEntered
         btn_comment_materials.setBackground( Color.RED);  

        guidance (guide_materials,"Comment");
    }//GEN-LAST:event_btn_comment_materialsMouseEntered

    private void btn_confidence_intervalsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confidence_intervalsMouseEntered
guidance (Guide,  "The <confidence_intervals> element has no attributes and has an accepted value of “true” or “false”. If set to “true”, uncertainties on tally results will be reported as the half-width of the 95% two-sided confidence interval. If set to “false”, uncertainties on tally results will be reported as the sample standard deviation. Default: false");
btn_confidence_intervals.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);

    }//GEN-LAST:event_btn_confidence_intervalsMouseEntered

    private void btn_cross_sectionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cross_sectionsMouseEntered
            btn_cross_sections.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  

        guidance (Guide, "The <cross_sections> element has no attributes and simply indicates the path to an XML cross section listing file (usually named cross_sections.xml). If this element is absent from the settings.xml file, the CROSS_SECTIONS environment variable will be used to find the path to the XML cross section listing.");
    }//GEN-LAST:event_btn_cross_sectionsMouseEntered

    private void btn_cutoffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cutoffMouseEntered
       
                    btn_cutoff.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  

        guidance (Guide, "The <cutoff> element indicates the weight cutoff used below which particles undergo Russian roulette. Surviving particles are assigned a user-determined weight. Note that weight cutoffs and Russian rouletting are not turned on by default. This element has the following attributes/sub-elements: "
                + "weight: " +
"The weight below which particles undergo Russian roulette. " +
"Default: 0.25\n" +
"weight_avg: " +
"The weight that is assigned to particles that are not killed after Russian roulette. Default: 1.0");
    }//GEN-LAST:event_btn_cutoffMouseEntered

    private void btn_eignvalueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eignvalueMouseEntered
                    btn_eignvalue.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  

        guidance (Guide,"The <eigenvalue> element indicates that a k-eigenvalue calculation should be performed. It has the following attributes/sub-elements:\n" +
"    batches: The total number of batches, where each batch corresponds to multiple fission source iterations. Batching is done to eliminate correlation between realizations of random variables." +
"    Default: None\n" +
"    generations_per_batch: The number of total fission source iterations per batch." +
"    Default: 1\n" +
"    inactive: The number of inactive batches. In general, the starting cycles in a criticality calculation can not be used to contribute to tallies since the fission source distribution and eigenvalue are generally not converged immediately.\n" +
"    Default: None\n" +
"    particles:The number of neutrons to simulate per fission source iteration. Default: None");

    }//GEN-LAST:event_btn_eignvalueMouseEntered

    private void btn_energy_gridMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_energy_gridMouseEntered
                    btn_energy_grid.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  

        guidance (Guide,"The <energy_grid> element determines the treatment of the energy grid during a simulation. Setting this element to “nuclide” will cause OpenMC to use a nuclide’s energy grid when determining what points to interpolate between for determining cross sections (i.e. non-unionized energy grid). To use a unionized energy grid, set this element to “union”. Note that the unionized energy grid treatment is slightly different than that employed in Serpent.\n" +
"\n" +
"    Default: union");

    }//GEN-LAST:event_btn_energy_gridMouseEntered

    private void btn_entropyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entropyMouseEntered

                         btn_entropy.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
   
        guidance (Guide,"TThe <entropy> element describes a mesh that is used for calculating Shannon entropy. This mesh should cover all possible fissionable materials in the problem. It has the following attributes/sub-elements:\n" +
"dimension: The number of mesh cells in the x, y, and z directions, respectively.\n" +

"Default: If this tag is not present, the number of mesh cells is automatically determined by the code.\n" +
"lower_left:The Cartesian coordinates of the lower-left corner of the mesh. Default: None\n" +
"upper_right: The Cartesian coordinates of the upper-right corner of the mesh. Default: None");
    }//GEN-LAST:event_btn_entropyMouseEntered

    private void btn_fixed_sourceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fixed_sourceMouseEntered
                         btn_fixed_source.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  

        guidance (Guide,"The <fixed_source> element indicates that a fixed source calculation should be performed. It has the following attributes/sub-elements:\n" +
"    batches: " +
"    The total number of batches. For fixed source calculations, each batch represents a realization of random variables for tallies. " +
"   Default: None\n" +
"    particles:	The number of particles to simulate per batch. Default: None");
 
    }//GEN-LAST:event_btn_fixed_sourceMouseEntered

    private void btn_no_reduceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_no_reduceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_no_reduceMouseClicked

    private void btn_outputMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_outputMouseEntered
                         btn_output.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  

        guidance (Guide,"The <output> element determines what output files should be written to disk during the run. The sub-elements are described below, where “true” will write out the file and “false” will not.\n" +
"cross_sections : Writes out an ASCII summary file of the cross sections that were read in. Default: false\n" +
"summary : Writes out an ASCII summary file describing all of the user input files that were read in. Default: false\n" +
"tallies : Write out an ASCII file of tally results.  Default: true");
    }//GEN-LAST:event_btn_outputMouseEntered

    private void btn_output_pathMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_output_pathMouseEntered
                         btn_output_path.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  

        guidance (Guide,"The <output_path> element specifies an absolute or relative path where all output files should be written to. The specified path must exist or else OpenMC will abort.\n" +
"    Default: Current working directory");
    }//GEN-LAST:event_btn_output_pathMouseEntered

    private void btn_ptablesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ptablesMouseEntered

                                btn_ptables.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
  
        guidance (Guide,"The <ptables> element determines whether probability tables should be used in the unresolved resonance range if available. This element has no attributes or sub-elements and can be set to either “false” or “true”.\n" +

"    Default: true");
    }//GEN-LAST:event_btn_ptablesMouseEntered

    private void btn_run_cmfdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_run_cmfdMouseEntered
        btn_run_cmfd.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
        guidance (Guide,"The <run_cmfd> element indicates whether or not CMFD acceleration should be turned on or off. This element has no attributes or sub-elements and can be set to either “false” or “true”.\n" +
"    Defualt: false");
    }//GEN-LAST:event_btn_run_cmfdMouseEntered

    private void btn_seedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seedMouseEntered
        btn_seed.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The seed element is used to set the seed used for the linear congruential pseudo-random number generator.\n" +
"    Default: 1");
    }//GEN-LAST:event_btn_seedMouseEntered

    private void btn_no_reduceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_no_reduceMouseEntered
                         btn_no_reduce.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  

        guidance (Guide,"The <no_reduce> element has no attributes and has an accepted value of “true” or “false”. If set to “true”, all user-defined tallies and global tallies will not be reduced across processors in a parallel calculation. This means that the accumulate score in one batch on a single processor is considered as an independent realization for the tally random variable. For a problem with large tally data, this option can significantly improve the parallel efficiency.\n" +
"    Default: false");
    }//GEN-LAST:event_btn_no_reduceMouseEntered

    private void btn_sourceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sourceMouseEntered
        btn_source.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The source element gives information on an external source distribution to be used either as the source for a fixed source calculation or the initial source guess for criticality calculations. ");
 
    }//GEN-LAST:event_btn_sourceMouseEntered

    private void btn_state_pointMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_state_pointMouseEntered
        btn_state_point.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <state_point> element indicates at what batches a state point file should be written. A state point file can be used to restart a run or to get tally results at any batch. The default behavior when using this tag is to write out the source bank in the state_point file. This behavior can be customized by using the <source_point> element.");
    }//GEN-LAST:event_btn_state_pointMouseEntered

    private void btn_plot_sliceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plot_sliceMouseEntered
        btn_plot_slice.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (GuidePlotting,"slice 2D pixel plot along one of the major axes. Produces a PPM image file.");
    }//GEN-LAST:event_btn_plot_sliceMouseEntered

    private void btn_plot_voxelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plot_voxelMouseEntered
        btn_plot_voxel.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (GuidePlotting,"voxel 3D voxel data dump. Produces a binary file containing voxel xyz position and cell or material id.");
    }//GEN-LAST:event_btn_plot_voxelMouseEntered

    private void btn_comment_plottingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_plottingMouseEntered
        btn_comment_plotting.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (GuidePlotting,"Comment\n");
    }//GEN-LAST:event_btn_comment_plottingMouseEntered

    private void btn_comment_cmfdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_cmfdMouseEntered
       btn_comment_cmfd.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"Comment.\n");
    }//GEN-LAST:event_btn_comment_cmfdMouseEntered

    private void btn_spectralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_spectralMouseEntered
       btn_spectral.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"The <spectral> element specifies an optional spectral radius that can be set to accelerate the convergence of Gauss-Seidel iterations during CMFD power iteration solve.\n" +
"\n" +
"Default: 0.0");
    }//GEN-LAST:event_btn_spectralMouseEntered

    private void btn_shiftMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_shiftMouseEntered
       btn_shift.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"The <shift> element specifies an optional Wielandt shift parameter for accelerating power iterations. It is by default very large so the impact of the shift is effectively zero.\n" +
"\n" +
"Default: 1e6");
    }//GEN-LAST:event_btn_shiftMouseEntered

    private void run_adjointMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_run_adjointMouseEntered
       run_adjoint.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"The <run_adjoint> element can be turned on with “true” to have an adjoint calculation be performed on the last batch when CMFD is active.");

    }//GEN-LAST:event_run_adjointMouseEntered

    private void btn_power_monitorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_power_monitorMouseEntered
       btn_power_monitor.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"The <power_monitor> element is used to view the convergence of power iteration. This option can be turned on with “true” and turned off with “false”. Default: false");

    }//GEN-LAST:event_btn_power_monitorMouseEntered

    private void btn_downscatterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_downscatterMouseEntered

        btn_downscatter.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"The <downscatter> element controls whether an effective downscatter cross section should be used when using 2-group CMFD. It can be turned on with “true” and off with “false”.\n" +
"\n" +
"Default: false");
    }//GEN-LAST:event_btn_downscatterMouseEntered

    private void btn_normMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_normMouseEntered
       btn_norm.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"The <norm> element is used to normalize the CMFD fission source distribution to a particular value. For example, if a fission source is calculated for a 17 x 17 lattice of pins, the fission source may be normalized to the number of fission source regions, in this case 289. This is useful when visualizing this distribution as the average peaking factor will be unity. This parameter will not impact the calculation. Default: 1.0");

    }//GEN-LAST:event_btn_normMouseEntered

    private void btn_mesh_cmfdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mesh_cmfdMouseEntered
      btn_mesh_cmfd.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guidecmfd,"The CMFD mesh is a structured Cartesian mesh. This element has the following attributes/sub-elements:\n lower_left:The lower-left corner of the structured mesh. If only two coordinate are given, it is assumed that the mesh is an x-y mesh.\n upper_right: The upper-right corner of the structrued mesh. If only two coordinate are given, it is assumed that the mesh is an x-y mesh.\n dimension:The number of mesh cells in each direction.\nwidth:The width of mesh cells in each direction.\n energy: Energy bins [in MeV], listed in ascending order (e.g. 0.0 0.625e-7 20.0) for CMFD tallies and acceleration. If no energy bins are listed, OpenMC automatically assumes a one energy group calculation over the entire energy range. \nalbedo: Surface ratio of incoming to outgoing partial currents on global boundary conditions. They are listed in the following order: -x +x -y +y -z +z. \nmap: An optional acceleration map can be specified to overlay on the coarse mesh spatial grid. If this option is used a 1 is used for a non-accelerated region and a 2 is used for an accelerated region.");                           
    }//GEN-LAST:event_btn_mesh_cmfdMouseEntered

    private void btn_meshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_meshMouseEntered

      btn_mesh.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (guide_tallies,"If a structured mesh is desired as a filter for a tally, it must be specified in a separate element with the tag name <mesh>. This element has the following attributes/sub-elements: \n type: The type of structured mesh. Valid options include “rectangular” and “hexagonal”. \n dimension:The number of mesh cells in each direction.\n lower_left:The lower-left corner of the structured mesh. If only two coordinates are given, it is assumed that the mesh is an x-y mesh.\n upper_right:The upper-right corner of the structured mesh. If only two coordinates are given, it is assumed that the mesh is an x-y mesh.\n width:The width of mesh cells in each direction.\n One of <upper_right> or <width> must be specified, but not both (even if they are consistent with one another).");
    }//GEN-LAST:event_btn_meshMouseEntered

    private void btn_assume_separateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_assume_separateMouseEntered
       btn_assume_separate.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (guide_tallies,"In cases where the user needs to specify many different tallies each of which are spatially separate, this tag can be used to cut down on some of the tally overhead. The effect of assuming all tallies are spatially separate is that once one tally is scored to, the same event is assumed not to score to any other tallies. This element should be followed by “true” or “false”.");
    }//GEN-LAST:event_btn_assume_separateMouseEntered

    private void btn_comment_talliesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_talliesMouseEntered
       btn_comment_tallies.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (guide_tallies,"Comment");
    }//GEN-LAST:event_btn_comment_talliesMouseEntered

    private void btn_uniform_fsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_uniform_fsMouseEntered
       btn_uniform_fs.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
 guidance (Guide,"The <uniform_fs> element describes a mesh that is used for re-weighting source sites at every generation based on the uniform fission site methodology described in Kelly et al., “MC21 Analysis of the Nuclear Energy Agency Monte Carlo Performance Benchmark Problem,” Proceedings of Physor 2012, Knoxville, TN (2012). ");
    }//GEN-LAST:event_btn_uniform_fsMouseEntered

    private void btn_comment_settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_settingsMouseEntered

        btn_comment_settings.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"Comment");
    }//GEN-LAST:event_btn_comment_settingsMouseEntered

    private void btn_verbosityMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_verbosityMouseEntered
        btn_verbosity.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <verbosity> element tells the code how much information to display to the standard output. A higher verbosity corresponds to more information being displayed.The specified verbosity between 1 and 10. Default: 5");
    }//GEN-LAST:event_btn_verbosityMouseEntered

    private void btn_trackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_trackMouseEntered
        btn_track.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <track> element specifies particles for which OpenMC will output binary files describing particle position at every step of its transport. This element should be followed by triplets of integers. Each triplet describes one particle. The integers in each triplet specify the batch number, generation number, and particle number, respectively.Default: None");
    }//GEN-LAST:event_btn_trackMouseEntered

    private void btn_traceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_traceMouseEntered
        btn_trace.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <trace> element can be used to print out detailed information about a single particle during a simulation. This element should be followed by three integers: the batch number, generation number, and particle number.Default: None");
    }//GEN-LAST:event_btn_traceMouseEntered

    private void btn_threadsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_threadsMouseEntered
        btn_threads.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <threads> element indicates the number of OpenMP threads to be used for a simulation. It has no attributes and accepts a positive integer value.Default: None (Determined by environment variable OMP_NUM_THREADS)");
    }//GEN-LAST:event_btn_threadsMouseEntered

    private void btn_survival_biasingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_survival_biasingMouseEntered
        btn_survival_biasing.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <survival_biasing> element has no attributes and has an accepted value of “true” or “false”. If set to “true”, this option will enable the use of survival biasing, otherwise known as implicit capture or absorption. Default: false");
    }//GEN-LAST:event_btn_survival_biasingMouseEntered

    private void btn_verbosityMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_verbosityMouseExited
        btn_verbosity.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_verbosityMouseExited

    private void btn_tally_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tally_resetMouseClicked
    }//GEN-LAST:event_btn_tally_resetMouseClicked

    private void btn_natural_elementsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_natural_elementsMouseEntered
        btn_natural_elements.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <natural_elements> element indicates to OpenMC what nuclides are available in the cross section library when expanding an <element> into separate isotopes (see <material> Element). The accepted values are:\n"+
"ENDF/B-VII.0	ENDF/B-VII.1	JEFF-3.1.1	JEFF-3.1.2	JEFF-3.2	JENDL-3.2	JENDL-3.3	JENDL-4.0\n" +
"Note that the value is case-insensitive, so “ENDF/B-VII.1” is equivalent to “endf/b-vii.1”.\n" +
"");
    }//GEN-LAST:event_btn_natural_elementsMouseEntered

    private void btn_natural_elementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_natural_elementsActionPerformed
        settingsTxt.replaceSelection("<natural_elements>  " +
            " </natural_elements>\n");
    }//GEN-LAST:event_btn_natural_elementsActionPerformed

    private void btn_source_pointMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_source_pointMouseEntered
        btn_source_point.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <source_point> element indicates at what batches the source bank should be written. The source bank can be either written out within a state point file or separately in a source point file.");
    }//GEN-LAST:event_btn_source_pointMouseEntered

    private void btn_source_pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_source_pointActionPerformed
        settingsTxt.replaceSelection("<source_point>\n" +
            "  <batches>  </batches>\n" +
            "  <interval>  </interval>\n" +
         "  <separate>  </separate>\n" +
         "  <source_write>  </source_write>\n" +
 "  <overwrite_latest>  </overwrite_latest>\n" +

            "</source_point>\n");
    }//GEN-LAST:event_btn_source_pointActionPerformed

    private void add_scorersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_scorersActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ERSNOpenMC_Scorers().setVisible(true);
            }
        });
    }//GEN-LAST:event_add_scorersActionPerformed
public void track_py( String filename, String track_file){
         String bashdir_track=null;
    try { 


    } catch (Exception ex) {
            System.out.print(ex);
        }
    String d="";
    try {
        File fileDir = new File(getJarContainingFolder(ERSNOpenMC_Main.class)+"/config/scripts.dir");
        try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
        String str;
        while ((str = in.readLine()) != null) {
            d=d+str;
        }   }
    } 
    catch (UnsupportedEncodingException e) {
        System.out.println(e.getMessage());
    } 
    catch (IOException e) {
        System.out.println(e.getMessage());
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }

    Process process = null;  
        try {            
            String trackpy_dir=scripts_dir+"/openmc-track-to-vtk"; 
            System.out.println(trackpy_dir);
            Process p1=Runtime.getRuntime().exec("xterm -j  -sb -title ERSN-OpenMC_Console  -sl 2000 -e  "+trackpy_dir+" -o "+project_full_path+"/"+track_file+".pvtp "+filename);// 
            p1.waitFor();
            JOptionPane.showMessageDialog(this, "The conversion of track file has been finished ");   
        } catch (IOException | InterruptedException ex) {  
            System.out.print(ex);  
        }
}

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            
        @Override
        public void run() {
            new ERSNOpenMC_RGB_COLOR().setVisible(true);
        }
        });    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void voxel_py( String filename){
        String d="";
        try { 
            File fileDir = new File(getJarContainingFolder(ERSNOpenMC_Main.class)+"/config/scripts.dir");
        try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
                String str;
                while ((str = in.readLine()) != null) {
                    d=d+str;
                }   
            }
        } 

        catch (UnsupportedEncodingException e) {
        System.out.println(e.getMessage());
    } 
    catch (IOException e) {
        System.out.println(e.getMessage());
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }

    Process process = null;  
    try {            
        String voxelpy_dir =scripts_dir+"/openmc-voxel-to-silovtk"; 
        System.out.print(voxelpy_dir);  
        System.out.print(filename);
 //       Runtime.getRuntime().exec("xterm -hold -e  "+voxelpy_dir+" "+filename+" --vtk -o "+filename+".vti ");
        Process p2=Runtime.getRuntime().exec("xterm -hold -e "+voxelpy_dir+" -o "+filename.replaceFirst("[.][^.]+$", "")+".vti " +filename);
            try {
                p2.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(ERSNOpenMC_Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {  
            System.out.print(ex);  
        }  
    }

    public void _3Dmesh_py( String filename){
        System.out.println("Selected file: " + filename);
        String d="";
        try {
            File fileDir = new File(getJarContainingFolder(ERSNOpenMC_Main.class)+"/config/scripts.dir");
            try (BufferedReader in = new BufferedReader(
                new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
                    String str;
                    while ((str = in.readLine()) != null) {
                           d=d+str;
                    }   
                }
            } 
    catch (UnsupportedEncodingException e) {
        System.out.println(e.getMessage());
    } 
    catch (IOException e) {
        System.out.println(e.getMessage());
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }
    Process process = null;  
        try {            
            String _3Dmeshpy_dir =scripts_dir+"/openmc-statepoint-3d"; 
            System.out.print(_3Dmeshpy_dir);  
            Runtime.getRuntime().exec("xterm -hold -e  "+_3Dmeshpy_dir+" "+filename+" --vtk -o "+filename+".vtm ");       
        } 
        catch (IOException ex) {  
            System.out.print(ex);  
        }  
    }

    public void tally_histogram_py(String filename){
        String d="";
        try {
            File fileDir = new File(getJarContainingFolder(ERSNOpenMC_Main.class)+"/config/scripts.dir");
            try (BufferedReader in = new BufferedReader(
                new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
                String str;
                while ((str = in.readLine()) != null) {
                    d=d+str;
                }           
                }
            } 
        catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        Process process = null;  
        try {            
            String tally_histogram_dir =scripts_dir+"/openmc-statepoint-histogram"; 
            System.out.print(tally_histogram_dir);  
            Runtime.getRuntime().exec("xterm -hold -e  "+tally_histogram_dir+" "+filename);
       
        } 
        catch (IOException ex) {  
            System.out.print(ex);  
        }  
}

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        FileNameExtensionFilter ppmfilter = new FileNameExtensionFilter("h5 voxel files (*.h5)", "h5");
        fc.setFileFilter(ppmfilter);
        fc.setDialogTitle("Open a binary Voxel file");
        java.io.File dir = new File(project_full_path);
        fc.setCurrentDirectory(dir);
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
            file_name = file.toString( );
            voxel_py(file_name);          
        }     }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        FileNameExtensionFilter ppmfilter = new FileNameExtensionFilter("2D image files (*.ppm; *.png)", "ppm", "png");
        fc.setFileFilter(ppmfilter);
        fc.setDialogTitle("Open a PPM file");
        java.io.File dir = new File(project_full_path);
        fc.setCurrentDirectory(dir);
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
            file_name = file.toString( );
            Process process = null;  
            try {  
            Runtime.getRuntime().exec("eog "+file_name);
            } catch (IOException ex) {  
            System.out.print(ex);  
            }
        }        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        FileNameExtensionFilter ppmfilter = new FileNameExtensionFilter("vti files (*.vti)", "vti");
        fc.setFileFilter(ppmfilter);
        fc.setDialogTitle("Open a VTI file");
        java.io.File dir = new File(project_full_path);
        fc.setCurrentDirectory(dir);
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
            file_name = file.toString( );
            Process process = null;  
            try {  
                Runtime.getRuntime().exec("paraview "+file_name);
            } catch (IOException ex) {  
                System.out.print(ex);  
            } 
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFrame frame = new JFrame("OpenMC Project Tree");
        frame.setForeground(Color.black);
        frame.setBackground(Color.yellow);
        Container cp = frame.getContentPane();
        cp.add(new ERSNOpenMC_FileTree(new File(project_full_path)));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JFileChooser fc = new JFileChooser(); 
        FileNameExtensionFilter ppmfilter = new FileNameExtensionFilter("pvtp files (*.pvtp)", "pvtp");
        fc.setFileFilter(ppmfilter);
        fc.setDialogTitle("Open a pvtp file");
        java.io.File dir = new File(project_full_path);
        fc.setCurrentDirectory(dir);
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
            file_name = file.toString( );
            Process process = null;  
            try {  
                Runtime.getRuntime().exec("paraview "+file_name);
            } catch (IOException ex) {  
                System.out.print(ex);  
            } 
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem_binary_track_to_pvtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_binary_track_to_pvtpActionPerformed

            java.io.File dir = new File(project_full_path);
            JFileChooser fc = new JFileChooser(dir);
            fc.setAcceptAllFileFilterUsed(false);
            fc.setDialogTitle("select track file");
            Tools.Description="track";
            fc.setFileFilter(new Filenamefilter());
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fc.getSelectedFile();
                track_file=selectedFile.getName(); 
                file_name = selectedFile.toString( );
                track_py(file_name,track_file);
            }   
    }//GEN-LAST:event_jMenuItem_binary_track_to_pvtpActionPerformed

    private void btn_confidence_intervalsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confidence_intervalsMouseExited
       btn_confidence_intervals.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);        
    }//GEN-LAST:event_btn_confidence_intervalsMouseExited

    private void btn_cross_sectionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cross_sectionsMouseExited
       btn_cross_sections.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_cross_sectionsMouseExited

    private void btn_cutoffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cutoffMouseExited
       btn_cutoff.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_cutoffMouseExited

    private void btn_eignvalueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eignvalueMouseExited
                        btn_eignvalue.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_eignvalueMouseExited

    private void btn_uniform_fsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_uniform_fsMouseExited
       btn_uniform_fs.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_uniform_fsMouseExited

    private void btn_comment_settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_settingsMouseExited
       btn_comment_settings.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_comment_settingsMouseExited

    private void btn_trackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_trackMouseExited
       btn_track.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_trackMouseExited

    private void btn_traceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_traceMouseExited
        btn_trace.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_traceMouseExited

    private void btn_threadsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_threadsMouseExited
        btn_threads.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_threadsMouseExited

    private void btn_survival_biasingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_survival_biasingMouseExited
        btn_survival_biasing.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_survival_biasingMouseExited

    private void btn_source_pointMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_source_pointMouseExited
        btn_source_point.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_source_pointMouseExited

    private void btn_state_pointMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_state_pointMouseExited
        btn_state_point.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_state_pointMouseExited

    private void btn_sourceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sourceMouseExited
        btn_source.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_sourceMouseExited

    private void btn_seedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seedMouseExited
        btn_seed.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_seedMouseExited

    private void btn_run_cmfdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_run_cmfdMouseExited
        btn_run_cmfd.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_run_cmfdMouseExited

    private void btn_ptablesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ptablesMouseExited
        btn_ptables.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_ptablesMouseExited

    private void btn_output_pathMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_output_pathMouseExited
        btn_output_path.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_output_pathMouseExited

    private void btn_outputMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_outputMouseExited
        btn_output.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_outputMouseExited

    private void btn_natural_elementsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_natural_elementsMouseExited
        btn_natural_elements.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_natural_elementsMouseExited

    private void btn_fixed_sourceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fixed_sourceMouseExited
        btn_fixed_source.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_fixed_sourceMouseExited

    private void btn_no_reduceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_no_reduceMouseExited
        btn_no_reduce.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_no_reduceMouseExited

    private void btn_entropyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entropyMouseExited
        btn_entropy.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_entropyMouseExited

    private void btn_energy_gridMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_energy_gridMouseExited
        btn_energy_grid.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_energy_gridMouseExited

    private void btn_cellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cellMouseExited
        btn_cell.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_cellMouseExited

    private void btn_latticeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_latticeMouseExited
        btn_lattice.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_latticeMouseExited

    private void btn_comment_geometryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_geometryMouseExited
        btn_comment_geometry.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_comment_geometryMouseExited

    private void btn_plot_sliceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plot_sliceMouseExited
        btn_plot_slice.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_plot_sliceMouseExited

    private void btn_plot_voxelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plot_voxelMouseExited
        btn_plot_voxel.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_plot_voxelMouseExited

    private void btn_comment_plottingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_plottingMouseExited
        btn_comment_plotting.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_comment_plottingMouseExited

    private void btn_comment_materialsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_materialsMouseExited
        btn_comment_materials.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_comment_materialsMouseExited

    private void btn_materialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_materialMouseExited
        btn_material.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_materialMouseExited

    private void btn_defaults_xsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_defaults_xsMouseExited
        btn_defaults_xs.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_defaults_xsMouseExited

    private void btn_tallyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tallyMouseExited
        btn_tally.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_tallyMouseExited

    private void btn_meshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_meshMouseExited
        btn_mesh.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_meshMouseExited

    private void btn_assume_separateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_assume_separateMouseExited
        btn_assume_separate.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_assume_separateMouseExited

    private void btn_comment_talliesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_talliesMouseExited
        btn_comment_tallies.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_comment_talliesMouseExited

    private void btn_dhat_setMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dhat_setMouseExited
        btn_dhat_set.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_dhat_setMouseExited

    private void btn_beginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_beginMouseExited
        btn_begin.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_beginMouseExited

    private void btn_feedbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_feedbackMouseExited
        btn_feedback.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_feedbackMouseExited

    private void btn_gauss_seidel_toleranceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gauss_seidel_toleranceMouseExited
        btn_gauss_seidel_tolerance.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_gauss_seidel_toleranceMouseExited

    private void btn_ktolMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ktolMouseExited
        btn_ktol.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_ktolMouseExited

    private void btn_stolMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stolMouseExited
        btn_stol.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_stolMouseExited

    private void btn_mesh_cmfdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mesh_cmfdMouseExited
        btn_mesh_cmfd.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_mesh_cmfdMouseExited

    private void btn_normMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_normMouseExited
        btn_norm.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_normMouseExited

    private void btn_downscatterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_downscatterMouseExited
        btn_downscatter.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_downscatterMouseExited

    private void btn_power_monitorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_power_monitorMouseExited
        btn_power_monitor.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_power_monitorMouseExited

    private void run_adjointMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_run_adjointMouseExited
        run_adjoint.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_run_adjointMouseExited

    private void btn_shiftMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_shiftMouseExited
        btn_shift.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_shiftMouseExited

    private void btn_spectralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_spectralMouseExited
        btn_spectral.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_spectralMouseExited

    private void btn_tally_resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tally_resetMouseExited
        btn_tally_reset.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_tally_resetMouseExited

    private void btn_comment_cmfdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comment_cmfdMouseExited
        btn_comment_cmfd.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_comment_cmfdMouseExited
    
    public void get_scripts_dir(){
        String d="";
        try {
        File fileDir = new File(getJarContainingFolder(ERSNOpenMC_Main.class)+"/config/scripts.dir");
        try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
            String str;
                while ((str = in.readLine()) != null) {
                    d=d+str;
                }
            }
        } 
    catch (UnsupportedEncodingException e) {
        System.out.println(e.getMessage());
    } 
    catch (IOException e) {
        System.out.println(e.getMessage());
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }
    scripts_dir=d;
    }
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        get_scripts_dir();
        Process process = null;  
        try {            
            String plot_mesh_tally_dir=scripts_dir+"/openmc-plot-mesh-tally"; 
            Runtime.getRuntime().exec("xterm -hold -e "+plot_mesh_tally_dir);       
        } catch (IOException ex) {  
            System.out.print(ex);  
        }  
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void _3d_mesh_plotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__3d_mesh_plotActionPerformed
//String vti_file="";
        JFileChooser fc = new JFileChooser(); 
        FileNameExtensionFilter ppmfilter = new FileNameExtensionFilter("vtm files (*.vtm)", "vtm");
        fc.setFileFilter(ppmfilter);
        fc.setDialogTitle("Open a VTM file");
        java.io.File dir = new File(project_full_path);
        fc.setCurrentDirectory(dir);
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File file = fc.getSelectedFile( );
        file_name = file.toString( );
//        vti_file=file.getName();
        
        Process process = null;  
        try {  
            Runtime.getRuntime().exec("paraview "+file_name);
        } catch (IOException ex) {  
            System.out.print(ex);  
        } 
}
    }//GEN-LAST:event__3d_mesh_plotActionPerformed

        private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // extract 3D mesh from statepoint file
            java.io.File dir = new File(project_full_path);
            JFileChooser fc = new JFileChooser(dir);
            fc.setCurrentDirectory(dir);
            fc.setAcceptAllFileFilterUsed(false);
            fc.setDialogTitle("select statepoint file");
            Tools.Description="statepoint";
            fc.setFileFilter(new Filenamefilter());
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            statepoint_file=selectedFile.toString();
            //  _3Dmesh_py(selectedFile.getAbsolutePath());
            _3Dmesh_py(statepoint_file);
    }                                          
    }
    
    private void geometryTxtAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_geometryTxtAncestorAdded
    }//GEN-LAST:event_geometryTxtAncestorAdded

    private void jMenuItem_run_openmcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_run_openmcActionPerformed
  ERSNOpenMC_Run_OpenMC  dialgo  =new     ERSNOpenMC_Run_OpenMC();
  dialgo.show();   dialgo.show();     }//GEN-LAST:event_jMenuItem_run_openmcActionPerformed

    private void jMenu_get_openmcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_get_openmcActionPerformed
 ERSNOpenMC_Get_OpenMC dialgo  =new     ERSNOpenMC_Get_OpenMC();
  dialgo.show();   dialgo.show();   dialgo.show();     }//GEN-LAST:event_jMenu_get_openmcActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ERSNOpenMC_View_hdf5_file().setVisible(true);                              
            }            
        });
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btn_hex_latticeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hex_latticeMouseEntered
        // TODO add your handling code here:
         btn_hex_lattice.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    
guidance (guide_geometry,"The <hex_lattice> can be used to represent repeating structures (e.g. fuel pins in an assembly) or other geometry which naturally fits onto a hexagonal grid or hexagonal prism grid. Each cell within the lattice is filled with a specified universe. This lattice uses the “flat-topped hexagon” scheme where two of the six edges are perpendicular to the y-axis. A <hex_lattice> accepts the following attributes or sub-elements:\n" +
"\n" +
"id:	\n" +
"A unique integer that can be used to identify the lattice.\n" +
"\n" +
"name:	\n" +
"An optional string name to identify the hex_lattice in summary output files. This string is limited to 52 characters for formatting purposes.\n" +
"\n" +
"Default: “”\n" +
"\n" +
"n_rings:	\n" +
"An integer representing the number of radial ring positions in the xy-plane. Note that this number includes the degenerate center ring which only has one element.\n" +
"\n" +
"Default: None\n" +
"\n" +
"n_axial:	\n" +
"An integer representing the number of positions along the z-axis. This element is optional.\n" +
"\n" +
"Default: None\n" +
"\n" +
"center:	\n" +
"The coordinates of the center of the lattice. If the lattice does not have axial sections then only the x- and y-coordinates are specified.\n" +
"\n" +
"Default: None\n" +
"\n" +
"pitch:	\n" +
"If the lattice is 3D, then two real numbers that express the distance between the centers of lattice cells in the xy-plane and along the z-axis, respectively. If the lattice is 2D, then omit the second value.\n" +
"\n" +
"Default: None\n" +
"\n" +
"outer:	\n" +
"The unique integer identifier of a universe that will be used to fill all space outside of the lattice. The universe will be tiled repeatedly as if it were placed in a lattice of infinite size. This element is optional.\n" +
"\n" +
"Default: An error will be raised if a particle leaves a lattice with no outer universe.\n" +
"\n" +
"universes:	\n" +
"A list of the universe numbers that fill each cell of the lattice.\n" +
"\n" +
"Default: None.  \n" +
"Here is an example of a properly defined 2d hexagonal lattice:\n"+
"<hex_lattice id=\"10\" n_rings=\"3\" outer=\"1\">\n"+
"    <center> 0.0 0.0 </center>\n"+
"    <pitch> 1.0 </pitch>\n"+
"    <universes>\n"+
"              202\n"+
"           202   202\n"+
"        202   202   202\n"+
"           202   202\n"+
"        202   101   202\n"+
"           202   202\n"+
"        202   202   202\n"+
"           202   202\n"+
"              202\n"+
"    </universes>\n"+
"</hex_lattice>\n"
        );
                 
        
    }//GEN-LAST:event_btn_hex_latticeMouseEntered

    private void btn_hex_latticeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hex_latticeMouseExited
        btn_hex_lattice.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_btn_hex_latticeMouseExited

    private void btn_hex_latticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hex_latticeActionPerformed
        geometryTxt.replaceSelection(
        "<hex_lattice id=\" \" n_rings=\" \" n_axial=\" \" outer=\" \">\n" 
       +"    <center>  </center>\n" 
       +"    <pitch>  </pitch>\n" 
       +"    <universes>\n\n" 
       +"    </universes>\n" 
       +"</hex_lattice>\n");         
    }//GEN-LAST:event_btn_hex_latticeActionPerformed

    private void btn_displayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_displayMouseExited
        btn_display.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE); 
    }//GEN-LAST:event_btn_displayMouseExited

    private void btn_log_grid_binsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_log_grid_binsMouseEntered
        btn_log_grid_bins.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"The <log_grid_bins> element indicates the number of bins to use for the logarithmic-mapped energy grid. Using more bins will result in energy grid searches over a smaller range at the expense of more memory. The default is based on the recommended value in LA-UR-14-24530.\n" +
"\n" +
"Default: 8000");        
    }//GEN-LAST:event_btn_log_grid_binsMouseEntered

    private void btn_log_grid_binsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_log_grid_binsMouseExited
        btn_log_grid_bins.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE); 
    }//GEN-LAST:event_btn_log_grid_binsMouseExited

    private void btn_log_grid_binsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_log_grid_binsActionPerformed
        settingsTxt.replaceSelection("<log_grid_bins>\n" +           
            "\n</log_grid_bins>\n");         
    }//GEN-LAST:event_btn_log_grid_binsActionPerformed

    private void btn_resonance_scatteringMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resonance_scatteringMouseEntered
        btn_resonance_scattering.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
guidance (Guide,"The resonance_scattering element can contain one or more of the following attributes or sub-elements:\n" +
"\n" +
"scatterer:	\n" +
"An element with attributes/sub-elements called nuclide, method, xs_label, xs_label_0K, E_min, and E_max. The nuclide attribute is the name, as given by the name attribute within the nuclide sub-element of the material element in materials.xml, of the nuclide to which a resonance scattering treatment is to be applied. The method attribute gives the type of resonance scattering treatment that is to be applied to the nuclide. Acceptable inputs - none of which are case-sensitive - for the method attribute are ARES, CXS, WCM, and DBRC. Descriptions of each of these methods are documented here. The xs_label attribute gives the label for the cross section data of the nuclide at a given temperature. The xs_label_0K gives the label for the 0 K cross section data for the nuclide. The E_min attribute gives the minimum energy above which the method is applied. The E_max attribute gives the maximum energy below which the method is applied. \nDefaults: None (scatterer), ARES (method), 0.01 eV (E_min), 1.0 keV (E_max)");            
    }//GEN-LAST:event_btn_resonance_scatteringMouseEntered

    private void btn_resonance_scatteringMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resonance_scatteringMouseExited
        btn_resonance_scattering.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE); 
    }//GEN-LAST:event_btn_resonance_scatteringMouseExited

    private void btn_resonance_scatteringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resonance_scatteringActionPerformed
        settingsTxt.replaceSelection("<resonance_scattering>\n" +
"  <scatterer>\n" +
"    <nuclide> </nuclide>\n" +
"    <method> </method>\n" +
"    <xs_label> </xs_label>\n" +
"    <xs_label_0K> </xs_label_0K>\n" +
"    <E_min> </E_min>\n" +
"    <E_max> </E_max>\n" +
" </scatterer>\n"+ "</resonance_scattering>\n");  
    }//GEN-LAST:event_btn_resonance_scatteringActionPerformed

    private void btn_triggerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_triggerMouseEntered
        btn_trigger.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guide,"OpenMC includes tally precision triggers which allow the user to define uncertainty thresholds on k_{eff} in the <eigenvalue> subelement of settings.xml, and/or tallies in tallies.xml. When using triggers, OpenMC will run until it completes as many batches as defined by <batches>. At this point, the uncertainties on all tallied values are computed and compared with their corresponding trigger thresholds. If any triggers have not been met, OpenMC will continue until either all trigger thresholds have been satisfied or <max_batches> has been reached.\n" +
"\n" +
"The <trigger> element provides an active “toggle switch” for tally precision trigger(s), the maximum number of batches and the batch interval. It has the following attributes/sub-elements:\n" +
"\n" +
"active:	\n" +
"This determines whether or not to use trigger(s). Trigger(s) are used when this tag is set to “true”.\n" +
"\n" +
"max_batches:	\n" +
"This describes the maximum number of batches allowed when using trigger(s).\n" +
"\n" +
"Note\n" +
"\n" +
"When max_batches is set, the number of batches shown in <eigenvalue> element represents minimum number of batches to simulate when using the trigger(s).\n" +
"batch_interval:	\n" +
"This tag describes the number of batches in between convergence checks. OpenMC will check if the trigger has been reached at each batch defined by batch_interval after the minimum number of batches is reached.\n" +
"\n" +
"Note\n" +
"\n" +
"If this tag is not present, the batch_interval is predicted dynamically by OpenMC for each convergence check. The predictive model assumes no correlation between fission sources distributions from batch-to-batch. This assumption is reasonable for fixed source and small criticality calculations, but is very optimistic for highly coupled full-core reactor problems.");
                             
    }//GEN-LAST:event_btn_triggerMouseEntered

    private void btn_triggerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_triggerMouseExited
        btn_trigger.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_triggerMouseExited

    private void btn_triggerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_triggerActionPerformed
        settingsTxt.replaceSelection("<trigger>\n" +
"  <active> </active>\n" +
"  <max_batches> </max_batches>\n" +
"  <batch_interval> </batch_interval>\n" +
"</trigger>\n");  
    }//GEN-LAST:event_btn_triggerActionPerformed

    private void btn_write_matricesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_write_matricesMouseEntered
        btn_write_matrices.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);  
guidance (Guidecmfd,"The <write_matrices> element is used to write the sparse matrices created when solving CMFD equations. This option can be turned on with “true” and off with “false”.\n" +
"\n" +
"Default: false");               
    }//GEN-LAST:event_btn_write_matricesMouseEntered

    private void btn_write_matricesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_write_matricesMouseExited
        btn_write_matrices.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);  
    }//GEN-LAST:event_btn_write_matricesMouseExited

    private void btn_write_matricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_write_matricesActionPerformed
        cmfdTxt.replaceSelection("<write_matrices>\n\n" +
"</write_matrices>\n");  
    }//GEN-LAST:event_btn_write_matricesActionPerformed

    private void btn_dhat_setActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dhat_setActionPerformed
        cmfdTxt.replaceSelection("<dhat_set>  </dhat_set>\n");                                            
    }//GEN-LAST:event_btn_dhat_setActionPerformed

    private void jMenuItem_openmc_xml_validationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_openmc_xml_validationActionPerformed
        get_openmcdir();
        System.out.println(openmcdir);
        String bashdir_xml_validation="";
        Process process = null;  
        try { 
            bashdir_xml_validation = getJarContainingFolder(ERSNOpenMC_Main.class) + "/scripts/openmc-xml-validation.sh";
        } 
        catch (Exception ex) {
            System.out.print(ex);
        }
        try {                
            String openmc_relaxng_dir=openmcdir.replace("/build/bin/openmc","/src/relaxng/");
            System.out.println(openmc_relaxng_dir);
            String open_xml_validation_bin=scripts_dir+"/openmc-validate-xml"; 
            Runtime.getRuntime().exec("xterm -e "+bashdir_xml_validation+" "+project_full_path+ " "+open_xml_validation_bin+" "+openmc_relaxng_dir);      
        } 
        catch (IOException ex) {  
            System.out.print(ex);  
        }  
    }//GEN-LAST:event_jMenuItem_openmc_xml_validationActionPerformed

    private void btn_meshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_meshMouseClicked
    }//GEN-LAST:event_btn_meshMouseClicked
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Process process = null;  
        try { 
            String memoryusagepy_dir =scripts_dir+"/openmc-memory-usage"; 
            System.out.print(memoryusagepy_dir);  
            Runtime.getRuntime().exec("xterm -hold -e  "+memoryusagepy_dir+" "+project_full_path+"/cross_sections.out"); } 
            catch (IOException ex) {  
                System.out.print(ex); }  }     
    
    /*
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    */

    private void jMenuPPM2PNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPPM2PNGActionPerformed
        JFileChooser fc = new JFileChooser(); 
        FileNameExtensionFilter ppmfilter = new FileNameExtensionFilter("ppm files (*.ppm)", "ppm");
        fc.setFileFilter(ppmfilter);
        fc.setDialogTitle("Open a PPM file");
        java.io.File dir = new File(project_full_path);
        fc.setCurrentDirectory(dir);
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
            file_name = file.toString( );
            Process process = null;  
            try {  
            Runtime.getRuntime().exec("convert "+file_name+ " "+file_name.replaceFirst("[.][^.]+$", "") +".png");
            } catch (IOException ex) {  
            System.out.print(ex);  
            }
        }        
    }//GEN-LAST:event_jMenuPPM2PNGActionPerformed

    private void btn_tally2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tally2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tally2MouseExited

    private void btn_tally2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tally2MouseEntered
        guidance (guide_tallies,"The <filter> element accepts the following sub-elements:\n\n" 
        +  "                type=``cell`` for example"
        +  "                bins\n\n"
        +  "<filter id=''1'' type=''cell''> \n"
        +  "     <bins>100</bins> \n"
        +  "</filter> \n\n"
        +  "<filter id=''2'' type=''energy''> \n"
        +  "     <bins>0 20.0e6</bins> \n"
        +  "</filter> \n\n"
        +  "<filter id=''3'' type=''energyout''> \n"
        +  "     <bins>0 20.0e6</bins> \n"
        +  "</filter> \n"  
        +  "allowed types : “cell”, “cellborn”, “material”, “universe”, “energy”, “energyout” \n"
        +  "“mesh”, “distribcell”, “mu”, “polar”, “azimutal”, and “delayedgroup”");
    }//GEN-LAST:event_btn_tally2MouseEntered

    private void btn_tally2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tally2ActionPerformed
talliesTxt.replaceSelection(
          "<filter id=\"\" type=\"\" >\n  "
        + "  <bins>  </bins>\n"
         + "</filter>\n");         // TODO add your handling code here:
    }//GEN-LAST:event_btn_tally2ActionPerformed

    public void get_openmcdir(){
        try {
            File fileDir = new File(getJarContainingFolder(ERSNOpenMC_Main.class)+"/config/openmc.dir");
            openmcdir=("");
            try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
            String str;
            while ((str = in.readLine()) != null) {
                openmcdir=openmcdir+str;
            }}} 
    catch (UnsupportedEncodingException e) {
        System.out.println(e.getMessage()); } 
    catch (IOException e) {
        System.out.println(e.getMessage());}
    catch (Exception e){
        System.out.println(e.getMessage());}

    openmcdir=openmcdir+"";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>
        //</editor-fold>
  
        /* Create and display the form */
       //
        java.awt.EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                new ERSNOpenMC_Main().setVisible(true);            
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Guide;
    private javax.swing.JTextArea GuidePlotting;
    private javax.swing.JTextArea Guidecmfd;
    private javax.swing.JMenu Menu_tools;
    private javax.swing.JMenuItem _3d_mesh_plot;
    private javax.swing.JMenuItem add_scorers;
    private javax.swing.JButton btn_assume_separate;
    private javax.swing.JButton btn_begin;
    private javax.swing.JButton btn_cell;
    private javax.swing.JButton btn_comment_cmfd;
    private javax.swing.JButton btn_comment_geometry;
    private javax.swing.JButton btn_comment_materials;
    private javax.swing.JButton btn_comment_plotting;
    private javax.swing.JButton btn_comment_settings;
    private javax.swing.JButton btn_comment_tallies;
    private javax.swing.JButton btn_confidence_intervals;
    private javax.swing.JButton btn_cross_sections;
    private javax.swing.JButton btn_cutoff;
    private javax.swing.JButton btn_defaults_xs;
    private javax.swing.JButton btn_dhat_set;
    private javax.swing.JButton btn_display;
    private javax.swing.JButton btn_downscatter;
    private javax.swing.JButton btn_eignvalue;
    private javax.swing.JButton btn_energy_grid;
    private javax.swing.JButton btn_entropy;
    private javax.swing.JButton btn_feedback;
    private javax.swing.JButton btn_fixed_source;
    private javax.swing.JButton btn_gauss_seidel_tolerance;
    private javax.swing.JButton btn_hex_lattice;
    private javax.swing.JButton btn_ktol;
    private javax.swing.JButton btn_lattice;
    private javax.swing.JButton btn_log_grid_bins;
    private javax.swing.JButton btn_material;
    private javax.swing.JButton btn_mesh;
    private javax.swing.JButton btn_mesh_cmfd;
    private javax.swing.JButton btn_natural_elements;
    private javax.swing.JButton btn_no_reduce;
    private javax.swing.JButton btn_norm;
    private javax.swing.JButton btn_output;
    private javax.swing.JButton btn_output_path;
    private javax.swing.JButton btn_plot_slice;
    private javax.swing.JButton btn_plot_voxel;
    private javax.swing.JButton btn_power_monitor;
    private javax.swing.JButton btn_ptables;
    private javax.swing.JButton btn_resonance_scattering;
    private javax.swing.JButton btn_run_cmfd;
    private javax.swing.JButton btn_seed;
    private javax.swing.JButton btn_shift;
    private javax.swing.JButton btn_source;
    private javax.swing.JButton btn_source_point;
    private javax.swing.JButton btn_spectral;
    private javax.swing.JButton btn_state_point;
    private javax.swing.JButton btn_stol;
    private javax.swing.JButton btn_surface;
    private javax.swing.JButton btn_survival_biasing;
    private javax.swing.JButton btn_tally;
    private javax.swing.JButton btn_tally2;
    private javax.swing.JButton btn_tally_reset;
    private javax.swing.JButton btn_threads;
    private javax.swing.JButton btn_trace;
    private javax.swing.JButton btn_track;
    private javax.swing.JButton btn_trigger;
    private javax.swing.JButton btn_uniform_fs;
    private javax.swing.JButton btn_verbosity;
    private javax.swing.JButton btn_write_matrices;
    private javax.swing.JEditorPane cmfdTxt;
    private javax.swing.JPanel cmfd_pnl;
    private javax.swing.JTabbedPane container;
    private javax.swing.JEditorPane geometryTxt;
    private javax.swing.JPanel geometry_pnl;
    private javax.swing.JTextArea guide_geometry;
    private javax.swing.JTextArea guide_materials;
    private javax.swing.JTextArea guide_tallies;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame10;
    private javax.swing.JInternalFrame jInternalFrame11;
    private javax.swing.JInternalFrame jInternalFrame12;
    private javax.swing.JInternalFrame jInternalFrame13;
    private javax.swing.JInternalFrame jInternalFrame14;
    private javax.swing.JInternalFrame jInternalFrame15;
    private javax.swing.JInternalFrame jInternalFrame16;
    private javax.swing.JInternalFrame jInternalFrame17;
    private javax.swing.JInternalFrame jInternalFrame18;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame7;
    private javax.swing.JInternalFrame jInternalFrame8;
    private javax.swing.JInternalFrame jInternalFrame9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem_binary_track_to_pvtp;
    private javax.swing.JMenuItem jMenuItem_openmc_xml_validation;
    private javax.swing.JMenuItem jMenuItem_run_openmc;
    private javax.swing.JMenuItem jMenuPPM2PNG;
    private javax.swing.JMenuItem jMenu_get_openmc;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbl;
    private javax.swing.JEditorPane materialsTxt;
    private javax.swing.JPanel materials_pnl;
    private javax.swing.JMenuItem menu_existing_project;
    private javax.swing.JMenuItem menu_exit;
    private javax.swing.JMenuItem menu_item_about;
    private javax.swing.JMenuItem menu_item_show_results;
    private javax.swing.JMenuItem menu_item_table_of_nuclides;
    private javax.swing.JMenuItem menu_new_openmc_project;
    private javax.swing.JMenuItem menu_save_project;
    private javax.swing.JEditorPane plottingTxt;
    private javax.swing.JPanel plotting_pnl;
    private javax.swing.JButton run_adjoint;
    private javax.swing.JEditorPane settingsTxt;
    private javax.swing.JPanel settings_pnl;
    private javax.swing.JEditorPane talliesTxt;
    private javax.swing.JPanel tallies_pnl;
    // End of variables declaration//GEN-END:variables

}
