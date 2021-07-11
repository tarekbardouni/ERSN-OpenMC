/*
 * The MIT License
 *
 * Copyright 2015-2020 Jaafar EL Bakkali & Tarek El Bardouni.
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @authors Jaafar EL Bakkali & Tarek El Bardouni  
 *          Radiations and Nuclear Systems Laboratory
 *          University Abdelmalek Essaadi, Tetouan, Morocco
 */
public class ERSNOpenMC_Get_OpenMC extends javax.swing.JFrame {

    String str_cmake = " cmake ",
            str_gfortran = " gfortran ",
            str_hdf5_tools = " hdf5-tools ",
            str_hdf5_dev = " libhdf5-dev ",
            str_hdf5_helpers = " hdf5-helpers ",
            str_git = " git ",
            str_eog = " eog ",
            str_setuptools = "python-setuptools",
            str_six = "python-six",
            str_pip = " python3-pip ",
            str_mutt = " ",
            str_mpich2 = " ",
            str_openmpi = " ",
            str_openmp_status = "NOT_USED",
            str_debug_status = "NOT_USED",
            str_openmc_version = "0.10.0",            
            str_vtk = " ",
            str_paraview = " ",            
            str_gedit = " ",
            bashdir_hdf5 = "";
    Boolean parallel_mode = false,
            _repository_pip_ = false,
            _repository_ubuntu_ = false;
    String  bashdir_openmc = "";
    String  bashdir_nndc = "";
    String  bashdir_convert_nndc = "";
    String  str_repository = "", 
            str_python_h5py = "",
            str_matplotlib = " ",
            str_numpy = " ",
            str_scipy = " ",
            str_ipython = " ",
            str_python_pandas = "",
            str_lxml = " ",
            str_install_command = " sudo apt install -y ";

    public ERSNOpenMC_Get_OpenMC() {
        initComponents();
        //    getContentPane().setBackground(new Color(0, 0, 128));
        buttonGroup1.add(_SEQ_MODE);
        buttonGroup1.add(DISTRIB_OpenMPI_MODE);
        buttonGroup1.add(DISTRIB_MODE);
        buttonGroup1.add(_OPENMP_MODE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btn_get_prerequisites = new javax.swing.JButton();
        _gfortran_ = new javax.swing.JCheckBox();
        _cmake_ = new javax.swing.JCheckBox();
        _mpich2_ = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        _openmpi_ = new javax.swing.JCheckBox();
        _git_ = new javax.swing.JCheckBox();
        _eog_ = new javax.swing.JCheckBox();
        _matplotlib_ = new javax.swing.JCheckBox();
        _vtk_ = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        _paraview_ = new javax.swing.JCheckBox();
        _numpy_ = new javax.swing.JCheckBox();
        _scipy_ = new javax.swing.JCheckBox();
        _ipython_ = new javax.swing.JCheckBox();
        _hdf5_ = new javax.swing.JCheckBox();
        _pandas_ = new javax.swing.JCheckBox();
        _hdf5_group = new javax.swing.JCheckBox();
        btn_close2 = new javax.swing.JButton();
        _mutt1_ = new javax.swing.JCheckBox();
        _h5py_ = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        setuptools = new javax.swing.JCheckBox();
        _vtk_conda = new javax.swing.JCheckBox();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        _lxml_ = new javax.swing.JCheckBox();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        _PIP_REPO_ = new javax.swing.JRadioButton();
        _UBUNTU_REPO_ = new javax.swing.JRadioButton();
        pip_command = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btn_get_openmc = new javax.swing.JButton();
        lbl_dir = new javax.swing.JLabel();
        btn_dir = new javax.swing.JButton();
        install_dir = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        _SEQ_MODE = new javax.swing.JRadioButton();
        DISTRIB_OpenMPI_MODE = new javax.swing.JRadioButton();
        DISTRIB_MODE = new javax.swing.JRadioButton();
        jCheckBox_openmp = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        btn_close1 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jCheckBox_Debug = new javax.swing.JCheckBox();
        _OPENMP_MODE = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        _DEVELOP_VERSION_ = new javax.swing.JCheckBox();
        _VERSION_10_ = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btn_get_nndc = new javax.swing.JButton();
        lbl_dir1 = new javax.swing.JLabel();
        btn_xs_dir = new javax.swing.JButton();
        XS_install_dir = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        btn_close3 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_convert_nndc = new javax.swing.JButton();
        lbl_dir2 = new javax.swing.JLabel();
        btn_nndc_dir = new javax.swing.JButton();
        nndc_dir = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        btn_close4 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        openmc_main_dir = new javax.swing.JTextField();
        lbl_dir3 = new javax.swing.JLabel();
        btn_nndc_dir1 = new javax.swing.JButton();
        btn_openmc_main_dir = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        jFormattedTextField1.setText("jFormattedTextField1");

        setTitle("ERSN-OpenMC_get_OpenMC");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane2.setMaximumSize(new java.awt.Dimension(99999, 99526));
        jTabbedPane2.setMinimumSize(new java.awt.Dimension(1000, 470));
        jTabbedPane2.setName(""); // NOI18N
        jTabbedPane2.setOpaque(true);
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1000, 470));
        jTabbedPane2.setRequestFocusEnabled(false);
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setFocusable(false);
        jPanel1.setMinimumSize(new java.awt.Dimension(1350, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 250));
        jPanel1.setRequestFocusEnabled(false);

        btn_get_prerequisites.setForeground(java.awt.Color.black);
        btn_get_prerequisites.setText("Get Prerequisites");
        btn_get_prerequisites.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_get_prerequisites.setMaximumSize(new java.awt.Dimension(77, 26));
        btn_get_prerequisites.setMinimumSize(new java.awt.Dimension(77, 26));
        btn_get_prerequisites.setPreferredSize(new java.awt.Dimension(77, 26));
        btn_get_prerequisites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_get_prerequisitesActionPerformed(evt);
            }
        });

        _gfortran_.setBackground(java.awt.SystemColor.activeCaption);
        _gfortran_.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        _gfortran_.setForeground(java.awt.Color.yellow);
        _gfortran_.setSelected(true);
        _gfortran_.setText("gfortran: the GNU Fortran compiler.");
        _gfortran_.setEnabled(false);
        _gfortran_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _gfortran_ActionPerformed(evt);
            }
        });

        _cmake_.setBackground(java.awt.SystemColor.activeCaption);
        _cmake_.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        _cmake_.setForeground(java.awt.Color.yellow);
        _cmake_.setSelected(true);
        _cmake_.setText("cmake:  a cross-platform and open-source build system.");
        _cmake_.setEnabled(false);

        _mpich2_.setBackground(java.awt.SystemColor.activeCaption);
        _mpich2_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _mpich2_.setForeground(java.awt.Color.yellow);
        _mpich2_.setText("MPICH: a standard for Message-Passing Interface.");
        _mpich2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _mpich2_ActionPerformed(evt);
            }
        });

        _openmpi_.setBackground(java.awt.SystemColor.activeCaption);
        _openmpi_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _openmpi_.setForeground(java.awt.Color.yellow);
        _openmpi_.setText("OPENMPI: Open Source High Performance parallel Computing.");
        _openmpi_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _openmpi_ActionPerformed(evt);
            }
        });

        _git_.setBackground(java.awt.SystemColor.activeCaption);
        _git_.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        _git_.setForeground(java.awt.Color.yellow);
        _git_.setSelected(true);
        _git_.setText("git : a distributed revision control system.");
        _git_.setEnabled(false);

        _eog_.setBackground(java.awt.SystemColor.activeCaption);
        _eog_.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        _eog_.setForeground(java.awt.Color.yellow);
        _eog_.setSelected(true);
        _eog_.setText("eog: Eye of Gnome, a graphics viewer program.");
        _eog_.setEnabled(false);
        _eog_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _eog_ActionPerformed(evt);
            }
        });

        _matplotlib_.setBackground(java.awt.SystemColor.activeCaption);
        _matplotlib_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _matplotlib_.setForeground(new java.awt.Color(255, 255, 0));
        _matplotlib_.setText("matplotlib : a python 2D plotting library.");
        _matplotlib_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _matplotlib_ActionPerformed(evt);
            }
        });

        _vtk_.setBackground(java.awt.SystemColor.activeCaption);
        _vtk_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _vtk_.setForeground(new java.awt.Color(255, 255, 0));
        _vtk_.setText("VTK : The Visualization Toolkit.");
        _vtk_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _vtk_ActionPerformed(evt);
            }
        });

        _paraview_.setBackground(java.awt.SystemColor.activeCaption);
        _paraview_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _paraview_.setForeground(new java.awt.Color(255, 255, 0));
        _paraview_.setText("ParaView : an open-source data analysis and visualization.");
        _paraview_.setMaximumSize(new java.awt.Dimension(308, 24));
        _paraview_.setMinimumSize(new java.awt.Dimension(308, 24));
        _paraview_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _paraview_ActionPerformed(evt);
            }
        });

        _numpy_.setBackground(java.awt.SystemColor.activeCaption);
        _numpy_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _numpy_.setForeground(new java.awt.Color(255, 255, 0));
        _numpy_.setText("NumPy : the fundamental package for scientific computing with Python.");
        _numpy_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _numpy_ActionPerformed(evt);
            }
        });

        _scipy_.setBackground(java.awt.SystemColor.activeCaption);
        _scipy_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _scipy_.setForeground(new java.awt.Color(255, 255, 0));
        _scipy_.setText("SciPy: a package of tools for science and engineering for Python.");
        _scipy_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _scipy_ActionPerformed(evt);
            }
        });

        _ipython_.setBackground(java.awt.SystemColor.activeCaption);
        _ipython_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _ipython_.setForeground(new java.awt.Color(255, 255, 0));
        _ipython_.setText("IPython: interactive computing in Python.");
        _ipython_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _ipython_ActionPerformed(evt);
            }
        });

        _hdf5_.setBackground(java.awt.SystemColor.activeCaption);
        _hdf5_.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        _hdf5_.setForeground(java.awt.Color.yellow);
        _hdf5_.setSelected(true);
        _hdf5_.setText("hdf5: a file format for storing and managing data.");
        _hdf5_.setEnabled(false);
        _hdf5_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _hdf5_ActionPerformed(evt);
            }
        });

        _pandas_.setBackground(java.awt.SystemColor.activeCaption);
        _pandas_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _pandas_.setForeground(new java.awt.Color(255, 255, 0));
        _pandas_.setText("pandas: Python Data Analysis Library. It contains some of the below packages.");
        _pandas_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _pandas_ActionPerformed(evt);
            }
        });

        _hdf5_group.setBackground(java.awt.SystemColor.activeCaption);
        _hdf5_group.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        _hdf5_group.setForeground(java.awt.Color.yellow);
        _hdf5_group.setText("hdf5 from the HDF group web site");
        _hdf5_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _hdf5_groupActionPerformed(evt);
            }
        });

        btn_close2.setForeground(java.awt.Color.black);
        btn_close2.setText("close");
        btn_close2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_close2ActionPerformed(evt);
            }
        });

        _mutt1_.setBackground(java.awt.SystemColor.activeCaption);
        _mutt1_.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        _mutt1_.setForeground(java.awt.Color.yellow);
        _mutt1_.setText("mutt: email sender");
        _mutt1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _mutt1_ActionPerformed(evt);
            }
        });

        _h5py_.setBackground(java.awt.SystemColor.activeCaption);
        _h5py_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _h5py_.setForeground(new java.awt.Color(255, 255, 0));
        _h5py_.setText("h5py: a Pythonic interface to the HDF5 binary data format.");
        _h5py_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _h5py_ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 255, 0));
        jLabel2.setText("Check one package at a time !");

        setuptools.setBackground(java.awt.SystemColor.activeCaption);
        setuptools.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        setuptools.setForeground(java.awt.Color.yellow);
        setuptools.setSelected(true);
        setuptools.setText("python-setuptools: required for openmc python modules install");
        setuptools.setEnabled(false);
        setuptools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setuptoolsActionPerformed(evt);
            }
        });

        _vtk_conda.setBackground(java.awt.SystemColor.activeCaption);
        _vtk_conda.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _vtk_conda.setForeground(new java.awt.Color(255, 255, 0));
        _vtk_conda.setText("VTK : if python under anaconda2 is called by GUI.");
        _vtk_conda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _vtk_condaActionPerformed(evt);
            }
        });

        _lxml_.setBackground(java.awt.SystemColor.activeCaption);
        _lxml_.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _lxml_.setForeground(new java.awt.Color(255, 255, 0));
        _lxml_.setText("lxml: library to process xml in phython language");
        _lxml_.setMinimumSize(new java.awt.Dimension(200, 23));
        _lxml_.setPreferredSize(new java.awt.Dimension(200, 23));
        _lxml_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _lxml_ActionPerformed(evt);
            }
        });

        _PIP_REPO_.setForeground(new java.awt.Color(255, 255, 0));
        _PIP_REPO_.setText(" install packages from PyPI");
        _PIP_REPO_.setOpaque(false);
        _PIP_REPO_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _PIP_REPO_ActionPerformed(evt);
            }
        });

        _UBUNTU_REPO_.setForeground(new java.awt.Color(255, 255, 0));
        _UBUNTU_REPO_.setSelected(true);
        _UBUNTU_REPO_.setText("install packages from ubuntu repo.");
        _UBUNTU_REPO_.setOpaque(false);
        _UBUNTU_REPO_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _UBUNTU_REPO_ActionPerformed(evt);
            }
        });

        pip_command.setBackground(java.awt.SystemColor.activeCaption);
        pip_command.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        pip_command.setForeground(java.awt.Color.yellow);
        pip_command.setSelected(true);
        pip_command.setText("pip: required to install python modules");
        pip_command.setEnabled(false);
        pip_command.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pip_commandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btn_get_prerequisites, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(223, 223, 223)
                                .addComponent(btn_close2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(_paraview_, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(_openmpi_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(pip_command, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(_mutt1_, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(_hdf5_group, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(_hdf5_, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(_gfortran_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(_git_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(_eog_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                                                    .addComponent(_cmake_, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(setuptools, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(_mpich2_))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(_PIP_REPO_)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(_UBUNTU_REPO_)
                                        .addGap(32, 32, 32))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(_pandas_, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_h5py_, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_numpy_, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_scipy_, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_matplotlib_, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_ipython_, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_lxml_, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_vtk_conda, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_vtk_, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 12, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(_eog_, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(_cmake_, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(_gfortran_, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(_git_, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(_hdf5_, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_PIP_REPO_)
                            .addComponent(_UBUNTU_REPO_))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_pandas_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(_mutt1_, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_h5py_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setuptools, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_numpy_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pip_command, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(_scipy_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_matplotlib_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_hdf5_group, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_ipython_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_openmpi_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_lxml_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_mpich2_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_vtk_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_paraview_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_vtk_conda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_get_prerequisites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_close2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Install Prerequisites", jPanel1);

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 300));

        btn_get_openmc.setForeground(java.awt.Color.black);
        btn_get_openmc.setText("Get OpenMC");
        btn_get_openmc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_get_openmcActionPerformed(evt);
            }
        });

        lbl_dir.setBackground(java.awt.SystemColor.activeCaption);
        lbl_dir.setForeground(java.awt.Color.yellow);
        lbl_dir.setText("Choose your install dir");

        btn_dir.setText("...");
        btn_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dirActionPerformed(evt);
            }
        });

        install_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                install_dirActionPerformed(evt);
            }
        });

        _SEQ_MODE.setBackground(java.awt.SystemColor.activeCaption);
        _SEQ_MODE.setForeground(java.awt.Color.yellow);
        _SEQ_MODE.setText("Sequential mode");
        _SEQ_MODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _SEQ_MODEActionPerformed(evt);
            }
        });

        DISTRIB_OpenMPI_MODE.setBackground(java.awt.SystemColor.activeCaption);
        DISTRIB_OpenMPI_MODE.setForeground(java.awt.Color.yellow);
        DISTRIB_OpenMPI_MODE.setText("Distributed memory OPENMPI mode");
        DISTRIB_OpenMPI_MODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DISTRIB_OpenMPI_MODEActionPerformed(evt);
            }
        });

        DISTRIB_MODE.setBackground(java.awt.SystemColor.activeCaption);
        DISTRIB_MODE.setForeground(java.awt.Color.yellow);
        DISTRIB_MODE.setText("Distributed memory MPICH mode");
        DISTRIB_MODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DISTRIB_MODEActionPerformed(evt);
            }
        });

        jCheckBox_openmp.setBackground(java.awt.SystemColor.activeCaption);
        jCheckBox_openmp.setForeground(java.awt.Color.yellow);
        jCheckBox_openmp.setText("Shared Memory can be used in hybrid mode OPENMP-MPI");
        jCheckBox_openmp.setEnabled(false);
        jCheckBox_openmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_openmpMouseClicked(evt);
            }
        });
        jCheckBox_openmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_openmpActionPerformed(evt);
            }
        });

        jLabel1.setBackground(java.awt.SystemColor.info);
        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("The OpenMC Monte Carlo code will be compiled with one of the following four modes. Choose the mode :");

        btn_close1.setForeground(java.awt.Color.black);
        btn_close1.setText("close");
        btn_close1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_close1ActionPerformed(evt);
            }
        });

        jCheckBox_Debug.setBackground(java.awt.SystemColor.activeCaption);
        jCheckBox_Debug.setForeground(java.awt.Color.yellow);
        jCheckBox_Debug.setText("Debug mode");
        jCheckBox_Debug.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_DebugMouseClicked(evt);
            }
        });
        jCheckBox_Debug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DebugActionPerformed(evt);
            }
        });

        _OPENMP_MODE.setBackground(java.awt.SystemColor.activeCaption);
        _OPENMP_MODE.setForeground(java.awt.Color.yellow);
        _OPENMP_MODE.setText("Enable shared-memory parallelism with OpenMP");
        _OPENMP_MODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _OPENMP_MODEActionPerformed(evt);
            }
        });
        _OPENMP_MODE.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                _OPENMP_MODEPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 252, 1));
        jLabel3.setText("Check one mode at least !");

        jLabel5.setBackground(java.awt.SystemColor.info);
        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Choose the desired version of OpenMC (Default = 0.10) :");

        _DEVELOP_VERSION_.setBackground(java.awt.SystemColor.activeCaption);
        _DEVELOP_VERSION_.setForeground(java.awt.Color.yellow);
        _DEVELOP_VERSION_.setText("develop version");
        _DEVELOP_VERSION_.setEnabled(false);
        _DEVELOP_VERSION_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _DEVELOP_VERSION_MouseClicked(evt);
            }
        });
        _DEVELOP_VERSION_.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                _DEVELOP_VERSION_ComponentHidden(evt);
            }
        });
        _DEVELOP_VERSION_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _DEVELOP_VERSION_ActionPerformed(evt);
            }
        });

        _VERSION_10_.setBackground(java.awt.SystemColor.activeCaption);
        _VERSION_10_.setForeground(java.awt.Color.yellow);
        _VERSION_10_.setSelected(true);
        _VERSION_10_.setText("Version 0.10");
        _VERSION_10_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _VERSION_10_MouseClicked(evt);
            }
        });
        _VERSION_10_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _VERSION_10_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox_openmp)
                                .addGap(265, 265, 265)
                                .addComponent(jCheckBox_Debug))
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DISTRIB_MODE)
                            .addComponent(DISTRIB_OpenMPI_MODE)
                            .addComponent(_OPENMP_MODE)
                            .addComponent(_SEQ_MODE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_dir)
                                .addGap(69, 69, 69)
                                .addComponent(install_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btn_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(114, 114, 114)
                                .addComponent(_DEVELOP_VERSION_)
                                .addGap(73, 73, 73)
                                .addComponent(_VERSION_10_)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addGap(220, 220, 220)
                .addComponent(btn_get_openmc, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213)
                .addComponent(btn_close1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(install_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_dir)
                            .addComponent(btn_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(_DEVELOP_VERSION_)
                            .addComponent(_VERSION_10_))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(_SEQ_MODE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_OPENMP_MODE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DISTRIB_OpenMPI_MODE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DISTRIB_MODE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_openmp)
                    .addComponent(jCheckBox_Debug))
                .addGap(12, 12, 12)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_get_openmc)
                    .addComponent(btn_close1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Install OpenMC", jPanel2);

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1100, 300));

        btn_get_nndc.setForeground(java.awt.Color.black);
        btn_get_nndc.setText("Get nndc XS");
        btn_get_nndc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_get_nndcActionPerformed(evt);
            }
        });

        lbl_dir1.setBackground(java.awt.SystemColor.activeCaption);
        lbl_dir1.setForeground(java.awt.Color.yellow);
        lbl_dir1.setText("Choose openmc parent dir");

        btn_xs_dir.setText("...");
        btn_xs_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xs_dirActionPerformed(evt);
            }
        });

        XS_install_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XS_install_dirActionPerformed(evt);
            }
        });

        jLabel4.setBackground(java.awt.SystemColor.info);
        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("NNDC cross sections library at 293.6°K in ACE format will be downloaded and installed in the chosen directory ./data/nndc");

        btn_close3.setForeground(java.awt.Color.black);
        btn_close3.setText("close");
        btn_close3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_close3ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(java.awt.SystemColor.info);
        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Data  are converted from ACE to H5 format to fit the requirements of OpenMC release 0.10 and directory ./nndc_hdf5 will be created");

        jLabel7.setBackground(java.awt.SystemColor.info);
        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.yellow);
        jLabel7.setText("If OpenMC develop version was installed download data manually in ACE format and convert them to h5 format with the pytthon script.");

        jLabel8.setBackground(java.awt.SystemColor.info);
        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.yellow);
        jLabel8.setText("openmc-ace-to-hdf5 provided in openmc package. Then the /config/cross_sections.dir file must be modified to point new data. ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(682, 682, 682)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 1192, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(btn_get_nndc, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(397, 397, 397)
                .addComponent(btn_close3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_dir1)
                .addGap(31, 31, 31)
                .addComponent(XS_install_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_xs_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_xs_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(XS_install_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_dir1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(21, 21, 21)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_get_nndc)
                    .addComponent(btn_close3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Download NNDC", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);
        jPanel4.setPreferredSize(new java.awt.Dimension(1100, 300));

        btn_convert_nndc.setForeground(java.awt.Color.black);
        btn_convert_nndc.setText("convert nndc XS to hdf5");
        btn_convert_nndc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_convert_nndcActionPerformed(evt);
            }
        });

        lbl_dir2.setBackground(java.awt.SystemColor.activeCaption);
        lbl_dir2.setForeground(java.awt.Color.yellow);
        lbl_dir2.setText("Choose your nndc directory");

        btn_nndc_dir.setText("...");
        btn_nndc_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nndc_dirActionPerformed(evt);
            }
        });

        nndc_dir.setMinimumSize(new java.awt.Dimension(4, 25));
        nndc_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nndc_dirActionPerformed(evt);
            }
        });

        btn_close4.setForeground(java.awt.Color.black);
        btn_close4.setText("close");
        btn_close4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_close4ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(java.awt.SystemColor.info);
        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Existing nndc data  will be converted from ACE to hdf5 format and new directory  will be created");

        openmc_main_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openmc_main_dirActionPerformed(evt);
            }
        });

        lbl_dir3.setBackground(java.awt.SystemColor.activeCaption);
        lbl_dir3.setForeground(java.awt.Color.yellow);
        lbl_dir3.setText("OpenMC main directory");

        btn_nndc_dir1.setText("...");
        btn_nndc_dir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nndc_dir1ActionPerformed(evt);
            }
        });

        btn_openmc_main_dir.setText("...");
        btn_openmc_main_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openmc_main_dirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_dir3)
                        .addGap(65, 65, 65)
                        .addComponent(openmc_main_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_dir2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nndc_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_openmc_main_dir, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(btn_nndc_dir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_nndc_dir1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(682, 682, 682)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 1192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(btn_convert_nndc, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(383, 383, 383)
                        .addComponent(btn_close4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nndc_dir1)
                    .addComponent(nndc_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dir2)
                    .addComponent(btn_nndc_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openmc_main_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dir3)
                    .addComponent(btn_openmc_main_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel9)
                        .addGap(83, 83, 83)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_close4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_convert_nndc)
                        .addGap(76, 76, 76))))
        );

        jTabbedPane2.addTab("Convert NNDC", jPanel4);

        getContentPane().add(jTabbedPane2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_get_openmcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_get_openmcActionPerformed
        System.out.print("ERSN-OPENMC/CONSOLE:-------INSTALLING  OPENMC MONTE CARLO CODE.");
        try {
            System.out.println("\n ******  Version : " + str_openmc_version + "\n");
            Process pb = Runtime.getRuntime().exec("xterm  -j  -sb -sl 2000 -title ERSN-OpenMC_Console -e "
                    + bashdir_openmc + " " + install_dir.getText() + " " + str_debug_status + " " + str_openmp_status + " " + str_openmc_version);
            pb.waitFor();
        } catch (IOException | InterruptedException ex) {
            System.out.print(ex);
        }

        save_openmcdir_file(install_dir.getText());
        save_scriptsdir_file(install_dir.getText());
        save_cross_sectiondir_file(install_dir.getText());
    }//GEN-LAST:event_btn_get_openmcActionPerformed

    public void get_prerequisites() throws IOException, InterruptedException {
        try {
            _PIP_REPO_.setEnabled(false);
             System.out.println("\n ******  software : " +  str_paraview + " choosen\n");
            String command_apt = "xterm -c -j  -sb -sl 2000 -title ERSN-OpenMC_Default -e sudo apt-get install -y " + str_cmake + str_gfortran + str_git + str_eog + str_six + str_setuptools + str_hdf5_tools + str_hdf5_dev + str_hdf5_helpers 
                    + str_pip + str_mutt + str_mpich2 + str_openmpi + str_paraview; 
            Process pb1 = Runtime.getRuntime().exec(command_apt);
            pb1.waitFor();
            JOptionPane.showMessageDialog(this, "The default packages have been installed successfully or already exist ! ");
            
            if ( _PIP_REPO_.isSelected() == true ) {
                    String command = "xterm -c -j  -sb -sl 2000 -title ERSN-OpenMC_Python -e sudo pip install "  
                           +  str_python_pandas + str_python_h5py + str_numpy + str_scipy + str_matplotlib + str_ipython + str_lxml + str_vtk;
                    Process pb2 = Runtime.getRuntime().exec(command);
                    pb2.waitFor();
                    JOptionPane.showMessageDialog(this, "The checked packages have been installed successfully from " + str_repository + " repository ");
                } else if ( _UBUNTU_REPO_.isSelected() == true ) {
                    String command = "xterm -c -j  -sb -sl 2000 -title ERSN-OpenMC_Python -e sudo apt install " 
                            + str_python_h5py + str_numpy + str_scipy + str_matplotlib + str_ipython + str_lxml + str_vtk + str_paraview;
                    Process pb2 = Runtime.getRuntime().exec(command);
                    pb2.waitFor();
                    System.out.print(command);
                    JOptionPane.showMessageDialog(this, "The checked packages have been installed successfully from " + str_repository + " repository ");
                    if (_pandas_.isSelected() == true) {
                        String command_pandas = "xterm -c -j  -sb -sl 2000 -title ERSN-OpenMC_Python -e sudo pip install "  
                           +  str_python_pandas ;
                        Process pb3 = Runtime.getRuntime().exec(command_pandas);
                        pb3.waitFor();
                    }   
                }           
        } catch (IOException | InterruptedException ex) {
            System.out.print(ex);
        }        
   
        if (_hdf5_group.isSelected() == true) {
            try {
                bashdir_hdf5 = getJarContainingFolder(ERSNOpenMC_Main.class) + "/scripts/get_hdf5.sh";
                File f = new File("/opt/hdf5");
                if (f.exists() && f.isDirectory()) {
                    System.out.println("\n The HDF5 package is already installed in your OS \n");
                } else {
                    Process pb3 = Runtime.getRuntime().exec("xterm -title ERSN-OpenMC_Console -e  " + bashdir_hdf5);
                    pb3.waitFor();
                    JOptionPane.showMessageDialog(this, "The HDF5 package packages has been  installed successfully ");
                }
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    }

    public void get_ERSMOpenMC_Config(String openmc_path, String openmc_target, String ersnopenmc_config_file) {
        try {
            FileWriter lu = new FileWriter(getJarContainingFolder(ERSNOpenMC_Main.class) + ersnopenmc_config_file);// Créer un objet java.io.FileWriter avec comme argument le mon du fichier dans lequel enregsitrer
            try (BufferedWriter fluxS = new BufferedWriter(lu) // Mettre le flux en tampon (en cache)
                    ) {
                fluxS.write(openmc_path + openmc_target); //Balancer dans le flux le contenu de la zone de texte
                fluxS.close();                            // Fermer le flux (c’est toujours mieux de le fermer explicitement)
            }  
        } catch (Exception er) {
        }
    }

    public void save_openmcdir_file(String openmc_path) {
        if (_DEVELOP_VERSION_.isSelected() == true) {
            get_ERSMOpenMC_Config(openmc_path, "/openmc/build/bin/openmc", "/config/openmc.dir");
        } else {
            get_ERSMOpenMC_Config(openmc_path, "/openmc-" + str_openmc_version + "/build/bin/openmc", "/config/openmc.dir");
        }
    }

    public void save_scriptsdir_file(String openmc_path) {
        if (_DEVELOP_VERSION_.isSelected() == true) {
        get_ERSMOpenMC_Config(openmc_path, "/openmc/scripts", "/config/scripts.dir");
        } else {
            get_ERSMOpenMC_Config(openmc_path, "/openmc-" + str_openmc_version + "/scripts", "/config/scripts.dir");
        }
    }

    public void save_cross_sectiondir_file(String openmc_path) {
        get_ERSMOpenMC_Config(openmc_path, "/data/nndc_hdf5/cross_sections.xml", "/config/cross_sections.dir");
    }

    private void btn_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dirActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open an existing OpenMC project");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile();
            install_dir.setText(file.toString());
            ERSNOpenMC_Singleton singleton = ERSNOpenMC_Singleton.getInstance();
            singleton.setOpenMCPath(install_dir.getText());
            save_openmcdir_file(file.toString());
        }
    }//GEN-LAST:event_btn_dirActionPerformed
    
    private void _SEQ_MODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__SEQ_MODEActionPerformed
        jCheckBox_openmp.setEnabled(false);
        try {
            bashdir_openmc = getJarContainingFolder(ERSNOpenMC_Main.class) + "/scripts/get_openmc.sh";  //load bash file for sequentiel application.
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event__SEQ_MODEActionPerformed

    private void DISTRIB_OpenMPI_MODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DISTRIB_OpenMPI_MODEActionPerformed
        jCheckBox_openmp.setEnabled(true);
        try {
            bashdir_openmc = getJarContainingFolder(ERSNOpenMC_Main.class) + "/scripts/get_openmc-with-openmpi.sh"; // load bash file for shared memory application.
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event_DISTRIB_OpenMPI_MODEActionPerformed

    private void DISTRIB_MODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DISTRIB_MODEActionPerformed
        jCheckBox_openmp.setEnabled(true);
        try {
            bashdir_openmc = getJarContainingFolder(ERSNOpenMC_Main.class) + "/scripts/get_openmc-with-mpich2.sh";  // load bash file for distributed memory application.
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event_DISTRIB_MODEActionPerformed

    private void jCheckBox_openmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_openmpActionPerformed
        if (jCheckBox_openmp.isSelected() == true) {
            str_openmp_status = "USED";
        } else {
            str_openmp_status = "NOT-USED";
        }
        System.out.print("ERSN-OPENMC/CONSOLE " + str_openmp_status);
    }//GEN-LAST:event_jCheckBox_openmpActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        System.out.print("ERSN-OPENMC/CONSOLE:-------OPENMP mode: " + str_openmp_status);
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void jCheckBox_openmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_openmpMouseClicked
        str_openmp_status = "USED";
    }//GEN-LAST:event_jCheckBox_openmpMouseClicked

    private void btn_close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_close1ActionPerformed
        this.show(false);
    }//GEN-LAST:event_btn_close1ActionPerformed

    private void jCheckBox_DebugMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_DebugMouseClicked
        str_debug_status = "USED";
    }//GEN-LAST:event_jCheckBox_DebugMouseClicked

    private void jCheckBox_DebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DebugActionPerformed
        if (jCheckBox_Debug.isSelected() == true) {
            str_debug_status = "USED";
        }
        if (jCheckBox_Debug.isSelected() == false) {
            str_debug_status = "NOT-USED";
        }
        System.out.print("ERSN-OPENMC/CONSOLE :-------DEBUG mode:" + str_debug_status);

    }//GEN-LAST:event_jCheckBox_DebugActionPerformed

    private void install_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_install_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_install_dirActionPerformed

    private void _OPENMP_MODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__OPENMP_MODEActionPerformed
    //    jCheckBox_openmp.setEnabled(true);
        str_openmp_status = "USED";
        try {
            bashdir_openmc = getJarContainingFolder(ERSNOpenMC_Main.class) + "/scripts/get_openmc-with-openmp.sh";  //load bash file for sequentiel application.
            System.out.println("\n *******************" + bashdir_openmc + "\n");
        } catch (Exception ex) {
            System.out.print(ex);
        }

    }//GEN-LAST:event__OPENMP_MODEActionPerformed

    private void btn_get_nndcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_get_nndcActionPerformed
        try {
            bashdir_nndc = getJarContainingFolder(ERSNOpenMC_Main.class) + "/scripts/get_nndc.sh";  //load bash file for sequentiel application.
            } catch (Exception ex) {
            System.out.print(ex);
            }
        System.out.print("ERSN-OPENMC/CONSOLE:-------INSTALLING NNDC DATA LIBRARY.");
        try {
            Process pb = Runtime.getRuntime().exec("xterm  -j  -sb -sl 2000 -title ERSN-OpenMC_Console -e "
                    + bashdir_nndc + " " + XS_install_dir.getText() + " " + XS_install_dir.getText() + "/openmc-" + str_openmc_version + "/scripts");
            pb.waitFor();

        } catch (IOException | InterruptedException ex) {
            System.out.print(ex);
            }
        save_cross_sectiondir_file(XS_install_dir.getText());
    }//GEN-LAST:event_btn_get_nndcActionPerformed

    private void btn_xs_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xs_dirActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open an existing OpenMC project");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile();
            XS_install_dir.setText(file.toString());
            ERSNOpenMC_Singleton singleton = ERSNOpenMC_Singleton.getInstance();
            singleton.setOpenMCPath(XS_install_dir.getText());
            save_openmcdir_file(file.toString());
        }
    }//GEN-LAST:event_btn_xs_dirActionPerformed

    private void XS_install_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XS_install_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XS_install_dirActionPerformed

    private void btn_close3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_close3ActionPerformed
        this.show(false);
    }//GEN-LAST:event_btn_close3ActionPerformed

    private void btn_convert_nndcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_convert_nndcActionPerformed
        try {
            bashdir_convert_nndc = getJarContainingFolder(ERSNOpenMC_Main.class) + "/scripts/convert_nndc2hdf5.sh";  //load bash file for sequentiel application.
        } catch (Exception ex) {
            System.out.print(ex);
        }

        System.out.print("ERSN-OPENMC/CONSOLE:-------INSTALLING NNDC DATA LIBRARY.");
        try {
            Process pb = Runtime.getRuntime().exec("xterm  -j  -sb -sl 2000 -title ERSN-OpenMC_Console -e "
                    + bashdir_convert_nndc + " " + nndc_dir.getText() + " " + openmc_main_dir.getText());
            pb.waitFor();

        } catch (IOException | InterruptedException ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event_btn_convert_nndcActionPerformed

    private void btn_nndc_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nndc_dirActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open an existing OpenMC project");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile();
            nndc_dir.setText(file.toString());
            ERSNOpenMC_Singleton singleton = ERSNOpenMC_Singleton.getInstance();
            singleton.setOpenMCPath(nndc_dir.getText());
            save_openmcdir_file(file.toString());
        }
    }//GEN-LAST:event_btn_nndc_dirActionPerformed

    private void nndc_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nndc_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nndc_dirActionPerformed

    private void btn_close4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_close4ActionPerformed
        this.show(false);
    }//GEN-LAST:event_btn_close4ActionPerformed

    private void openmc_main_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openmc_main_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openmc_main_dirActionPerformed

    private void btn_nndc_dir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nndc_dir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nndc_dir1ActionPerformed

    private void btn_openmc_main_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openmc_main_dirActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open an existing OpenMC project");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile();
            openmc_main_dir.setText(file.toString());
            ERSNOpenMC_Singleton singleton = ERSNOpenMC_Singleton.getInstance();
            singleton.setOpenMCPath(openmc_main_dir.getText());
            save_openmcdir_file(file.toString());
        }
    }//GEN-LAST:event_btn_openmc_main_dirActionPerformed

    private void _OPENMP_MODEPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event__OPENMP_MODEPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event__OPENMP_MODEPropertyChange

    private void _DEVELOP_VERSION_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__DEVELOP_VERSION_MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event__DEVELOP_VERSION_MouseClicked

    private void _DEVELOP_VERSION_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__DEVELOP_VERSION_ActionPerformed
        if (_DEVELOP_VERSION_.isSelected() == true) {
            str_openmc_version = "develop";
            _VERSION_10_.setEnabled(false);
            System.out.println("\ndevelop version selected\n");
        } else {
            str_openmc_version = "0.10.0";
            _VERSION_10_.setEnabled(true);
        }
    }//GEN-LAST:event__DEVELOP_VERSION_ActionPerformed

    private void _VERSION_10_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__VERSION_10_MouseClicked
        if (_VERSION_10_.isSelected() == true) {
            str_openmc_version = "0.10.0";
            _DEVELOP_VERSION_.setEnabled(false);
            System.out.println("\n version 0.10.0 selected\n");

        } else {
            str_openmc_version = "develop";
            _DEVELOP_VERSION_.setEnabled(true);
        }
    }//GEN-LAST:event__VERSION_10_MouseClicked

    private void _VERSION_10_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__VERSION_10_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__VERSION_10_ActionPerformed

    private void _lxml_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__lxml_ActionPerformed
        if (_lxml_.isSelected() == true) {
                if ( _PIP_REPO_.isSelected() == true ) {
                        str_lxml = " lxml ";
                } else {
                        str_lxml = " python_lxml ";
                }  
        } else {
                str_lxml = " ";
        }                                         
    }//GEN-LAST:event__lxml_ActionPerformed

    private void _vtk_condaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__vtk_condaActionPerformed
        if (_vtk_conda.isSelected() == true) {
            try {
                Process pb = Runtime.getRuntime().exec("xterm -j  -sb -sl 2000 -title ERSN-OpenMC_Console -e /home/tarek/anaconda2/bin/pip install vtk " );
                pb.waitFor();
                JOptionPane.showMessageDialog(this, "The vtk packages have been installed successfully or already exist ! ");
            } catch (IOException | InterruptedException ex) {
                System.out.print(ex);
            }
        }
    }//GEN-LAST:event__vtk_condaActionPerformed

    private void setuptoolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setuptoolsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setuptoolsActionPerformed

    private void _h5py_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__h5py_ActionPerformed
        if (_h5py_.isSelected() == true) {
            if ( _PIP_REPO_.isSelected() == true ) {
                str_python_h5py = " h5py ";
            } else {  
                str_python_h5py = " python-h5py ";
            }
        } else {    
              str_python_h5py = " ";
        }
    }//GEN-LAST:event__h5py_ActionPerformed
    
    private void _mutt1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__mutt1_ActionPerformed
        if (_mutt1_.isSelected() == true) {
            str_mutt = " mutt ";

        } else {
            str_mutt = "  ";
        }
    }//GEN-LAST:event__mutt1_ActionPerformed

    private void btn_close2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_close2ActionPerformed
        this.show(false);
    }//GEN-LAST:event_btn_close2ActionPerformed

    private void _hdf5_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__hdf5_groupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__hdf5_groupActionPerformed

    private void _pandas_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__pandas_ActionPerformed
        if (_pandas_.isSelected() == true) {
            if ( _PIP_REPO_.isSelected() == true ) {
                str_python_pandas = " pandas ";
            } else {
                str_python_pandas = " pandas ";    // python-pandas is no longer provided by ubuntu repository
            }  
        } else {
            str_python_pandas = " ";
        }
    }//GEN-LAST:event__pandas_ActionPerformed

    private void _hdf5_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__hdf5_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__hdf5_ActionPerformed

    private void _ipython_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__ipython_ActionPerformed
        if (_ipython_.isSelected() == true) {
                if ( _PIP_REPO_.isSelected() == true ) {
                        str_ipython = " ipython ";
                } else {
                        str_ipython = " python-ipython ";
                }  
        } else {
            str_ipython = " ";
    }//GEN-LAST:event__ipython_ActionPerformed
}
    
    private void _scipy_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__scipy_ActionPerformed
        if (_scipy_.isSelected() == true) {
                if ( _PIP_REPO_.isSelected() == true ) {
                        str_scipy = " scipy ";
                } else {
                        str_scipy = " python-scipy ";
                }  
       } else {
                str_scipy = "  ";
        }
    }//GEN-LAST:event__scipy_ActionPerformed

    private void _numpy_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__numpy_ActionPerformed
        if (_numpy_.isSelected() == true) {
            if ( _PIP_REPO_.isSelected() == true ) {
                        str_numpy = " numpy ";
                } else {
                        str_numpy = " python-numpy ";
                }
        } else {
            str_numpy = " ";
        }
    }//GEN-LAST:event__numpy_ActionPerformed

    private void _paraview_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__paraview_ActionPerformed
        if (_paraview_.isSelected() == true) {
            str_paraview = " paraview ";
        } else {
            str_paraview = "  ";
        }
    }//GEN-LAST:event__paraview_ActionPerformed

    private void _vtk_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__vtk_ActionPerformed
        str_vtk = " python-vtk ";
        if (_vtk_.isSelected() == true) {
            if ( _PIP_REPO_.isSelected() == true ) {
                        str_vtk = " vtk ";
                } else {
                        str_vtk = " vtk6 ";   // python-vtk is no longer provided by ubuntu repository it is replaced by vtk6 or vtk7
                }
        } else {
            str_vtk = " ";
        }
    }//GEN-LAST:event__vtk_ActionPerformed

    private void _matplotlib_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__matplotlib_ActionPerformed
        if (_matplotlib_.isSelected() == true) {
            if ( _PIP_REPO_.isSelected() == true ) {
                        str_matplotlib = " matplotlib ";
                } else {
                        str_matplotlib = " python-matplotlib ";
                }
        } else {
            str_matplotlib = " ";
        }
    }//GEN-LAST:event__matplotlib_ActionPerformed

    private void _eog_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__eog_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__eog_ActionPerformed

    private void _openmpi_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__openmpi_ActionPerformed
        if (_openmpi_.isSelected() == true) {
            str_openmpi = " openmpi-bin libopenmpi1.6 libopenmpi-dev";
            parallel_mode = true;
        } else {
            str_openmpi = "  ";
            parallel_mode = false;
        }
    }//GEN-LAST:event__openmpi_ActionPerformed

    private void _mpich2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__mpich2_ActionPerformed

        if (_mpich2_.isSelected() == true) {
            str_mpich2 = " mpich libmpich-dev ";
            parallel_mode = true;

        } else {
            str_mpich2 = " ";
            parallel_mode = false;
        }
    }//GEN-LAST:event__mpich2_ActionPerformed

    private void _gfortran_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__gfortran_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__gfortran_ActionPerformed

    private void btn_get_prerequisitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_get_prerequisitesActionPerformed
        try {
            // Get ALL Prerequisites packages selected by the user.
            get_prerequisites();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ERSNOpenMC_Get_OpenMC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_get_prerequisitesActionPerformed

    private void _PIP_REPO_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__PIP_REPO_ActionPerformed
        if (_PIP_REPO_.isSelected() == true) {
            str_install_command = " sudo pip install ";
            _UBUNTU_REPO_.setEnabled(false);
            str_repository = " PYPi ";
            System.out.println("\n Packages from PYPi repository will be installed\n");
        } else {
            str_install_command = " sudo apt install -y ";
            str_repository = " UBUNTU ";
            _UBUNTU_REPO_.setEnabled(true);
        }
    }//GEN-LAST:event__PIP_REPO_ActionPerformed

    private void _UBUNTU_REPO_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__UBUNTU_REPO_ActionPerformed
        if (_UBUNTU_REPO_.isSelected() == true) {
            str_install_command = " sudo apt install ";
            str_repository = " UBUNTU ";
            _PIP_REPO_.setEnabled(false);
            System.out.println("\n Packages from UBUNTU repository will be installed\n");

        } else {
            str_install_command = " sudo pip install ";
            str_repository = " PYPi ";
            _PIP_REPO_.setEnabled(true);
        }
    }//GEN-LAST:event__UBUNTU_REPO_ActionPerformed

    private void pip_commandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pip_commandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pip_commandActionPerformed

    private void _DEVELOP_VERSION_ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event__DEVELOP_VERSION_ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event__DEVELOP_VERSION_ComponentHidden

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
            java.util.logging.Logger.getLogger(ERSNOpenMC_Get_OpenMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ERSNOpenMC_Get_OpenMC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DISTRIB_MODE;
    private javax.swing.JRadioButton DISTRIB_OpenMPI_MODE;
    private javax.swing.JTextField XS_install_dir;
    private javax.swing.JCheckBox _DEVELOP_VERSION_;
    private javax.swing.JRadioButton _OPENMP_MODE;
    private javax.swing.JRadioButton _PIP_REPO_;
    private javax.swing.JRadioButton _SEQ_MODE;
    private javax.swing.JRadioButton _UBUNTU_REPO_;
    private javax.swing.JCheckBox _VERSION_10_;
    private javax.swing.JCheckBox _cmake_;
    private javax.swing.JCheckBox _eog_;
    private javax.swing.JCheckBox _gfortran_;
    private javax.swing.JCheckBox _git_;
    private javax.swing.JCheckBox _h5py_;
    private javax.swing.JCheckBox _hdf5_;
    private javax.swing.JCheckBox _hdf5_group;
    private javax.swing.JCheckBox _ipython_;
    private javax.swing.JCheckBox _lxml_;
    private javax.swing.JCheckBox _matplotlib_;
    private javax.swing.JCheckBox _mpich2_;
    private javax.swing.JCheckBox _mutt1_;
    private javax.swing.JCheckBox _numpy_;
    private javax.swing.JCheckBox _openmpi_;
    private javax.swing.JCheckBox _pandas_;
    private javax.swing.JCheckBox _paraview_;
    private javax.swing.JCheckBox _scipy_;
    private javax.swing.JCheckBox _vtk_;
    private javax.swing.JCheckBox _vtk_conda;
    private javax.swing.JButton btn_close1;
    private javax.swing.JButton btn_close2;
    private javax.swing.JButton btn_close3;
    private javax.swing.JButton btn_close4;
    private javax.swing.JButton btn_convert_nndc;
    private javax.swing.JButton btn_dir;
    private javax.swing.JButton btn_get_nndc;
    private javax.swing.JButton btn_get_openmc;
    private javax.swing.JButton btn_get_prerequisites;
    private javax.swing.JButton btn_nndc_dir;
    private javax.swing.JButton btn_nndc_dir1;
    private javax.swing.JButton btn_openmc_main_dir;
    private javax.swing.JButton btn_xs_dir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JTextField install_dir;
    private javax.swing.JCheckBox jCheckBox_Debug;
    private javax.swing.JCheckBox jCheckBox_openmp;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbl_dir;
    private javax.swing.JLabel lbl_dir1;
    private javax.swing.JLabel lbl_dir2;
    private javax.swing.JLabel lbl_dir3;
    private javax.swing.JTextField nndc_dir;
    private javax.swing.JTextField openmc_main_dir;
    private javax.swing.JCheckBox pip_command;
    private javax.swing.JCheckBox setuptools;
    // End of variables declaration//GEN-END:variables
}


