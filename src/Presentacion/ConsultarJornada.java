/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ControladorUsuarios;
import Logica.Direccion;
import Logica.DtConsulta;
import Logica.DtEntidad;
import Logica.DtPaciente;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContPaciente;
import Logica.IContUsuario;
import Utils.JFrameConFondo;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ConsultarJornada extends JFrameConFondo {

    /**
     * Creates new form EntidadesGlobales
     */
    Date Fechajor;
    boolean controlhora = false;
    IContUsuario Usr;
    List<Direccion> dire;
    List<DtEntidad> enti;
    List<DtPaciente> dtpac;
    List<DtConsulta> consultas = new ArrayList();
    private IContPaciente Pac;
    public ConsultarJornada() {
        initComponents();
        this.setImagen("Fondo.jpg");
        Usr = Fabrica.getUsuario();
        Pac = Fabrica.getPaciente();
        setTitle("Nueva Jornada");
        listarjornadas();
        listarPacientes("");
        listarEntidades();
        listarDirecciones();
        EntiTable.setSelectionMode(0);
    }
    
    public void listarjornadas(){
        DefaultTableModel modelo = (DefaultTableModel)JorTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        consultas = Usr.getListadoJornadas();
        for (DtConsulta d : consultas) {
            LocalDateTime localDate = d.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            int year  = localDate.getYear();
            int month = localDate.getMonthValue();
            int day   = localDate.getDayOfMonth();
            int hr = localDate.getHour();
            int min = localDate.getMinute();
            String[] datos = {day+"/"+month+"/"+year,"0"+hr+":"+"0"+min,d.getEntidad()!=null ? d.getEntidad().getNombre() : d.getDir().getDepartamento()+" "+d.getDir().getCiudad()+" "+d.getDir().getCalle()+" "+d.getDir().getNumero(),ConvertirString(d.getDtp().getNombre()+" "+d.getDtp().getApellido()),d.getDtp().getCi()};
            modelo.addRow(datos);
        }
    }
    
    public void listarPacientes(String x) {
        DefaultTableModel modelo = (DefaultTableModel) PaciTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        dtpac = Pac.getPacientesMedico(x);
        for (DtPaciente d : dtpac) {
            String[] datos = {d.getCi(),ConvertirString(d.getNombre()),ConvertirString(d.getApellido())};
            modelo.addRow(datos);
        }
    }
    
    public void listarEntidades() {
        DefaultTableModel modelo = (DefaultTableModel) EntiTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        enti = Pac.getDtEntidades("",1);
        for (DtEntidad a : enti) {
            String[] datos = {ConvertirString(a.getNombre()),a.getCorreo(),a.getTelefonosString(),a.getImagen()!=null ? "Si" : "No",a.getDireccion().getCiudad()+", "+a.getDireccion().getDepartamento(),a.getDireccion().getCalle()+" "+a.getDireccion().getNumero()};
            modelo.addRow(datos);
        }
    }
    
    public void listarDirecciones() {
        DefaultTableModel modelo = (DefaultTableModel) DireTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        dire = Usr.getMisDirecciones();
        for (Direccion d : dire) {
            String[] datos = {ConvertirString(d.getCiudad())+", "+ConvertirString(d.getDepartamento()),ConvertirString(d.getCalle())+" "+d.getNumero()};
            modelo.addRow(datos);
        }
        
    }
    
    public void centrar() {
        //este metodo devuelve el tamaÃ±o de la pantalla
        int x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        int h = this.getHeight();
        int z = this.getWidth();
        this.setLocation(x / 2 - z / 2, y / 2 - h / 2);
    }
    
    String ConvertirString(String cad) {
        cad = cad.toLowerCase();
        String[] palabras = cad.split("\\s+");
        cad = "";
        for (int i = 0; i < palabras.length; i++) {
            palabras[i].toLowerCase();
            palabras[i] = palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1);
            if (i == 0) {
                cad = cad + palabras[i];
            } else {
                cad = cad + " " + palabras[i];
            }
        }
        return cad;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        particular = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hora = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        min = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        PaciTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ConTable = new javax.swing.JTable();
        buscarIngTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        EntiTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        DireTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JorTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Fecha:");

        particular.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        particular.setText("Particular");
        particular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                particularActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Entidades/Direcciones");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("Seleccionar Entidad o Dirección");

        hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", " " }));
        hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setText("Agregar Consultas");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setText("Hora:Min");

        min.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setText(":");

        PaciTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        PaciTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PaciTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        PaciTable.setGridColor(new java.awt.Color(204, 204, 204));
        PaciTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaciTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(PaciTable);
        PaciTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (PaciTable.getColumnModel().getColumnCount() > 0) {
            PaciTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            PaciTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            PaciTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setText("Consultas Agendadas");

        ConTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ConTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula Paciente", "Fecha y Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ConTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ConTable.setColumnSelectionAllowed(true);
        ConTable.setGridColor(new java.awt.Color(204, 204, 204));
        ConTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(ConTable);
        ConTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (ConTable.getColumnModel().getColumnCount() > 0) {
            ConTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            ConTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        buscarIngTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarIngTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Buscar Paciente:");

        contenedor.setLayout(new java.awt.CardLayout());

        EntiTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        EntiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Correo", "Teléfonos", "Imagen", "Ciudad - Departamento", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EntiTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        EntiTable.setColumnSelectionAllowed(true);
        EntiTable.setGridColor(new java.awt.Color(204, 204, 204));
        EntiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EntiTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(EntiTable);
        EntiTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (EntiTable.getColumnModel().getColumnCount() > 0) {
            EntiTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            EntiTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            EntiTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            EntiTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            EntiTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            EntiTable.getColumnModel().getColumn(4).setHeaderValue("Ciudad - Departamento");
            EntiTable.getColumnModel().getColumn(5).setResizable(false);
            EntiTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            EntiTable.getColumnModel().getColumn(5).setHeaderValue("Dirección");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
        );

        contenedor.add(jPanel1, "card2");

        DireTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        DireTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Departamento", "Ciudad", "Calle", "Número"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DireTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        DireTable.setGridColor(new java.awt.Color(204, 204, 204));
        DireTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DireTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(DireTable);
        DireTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (DireTable.getColumnModel().getColumnCount() > 0) {
            DireTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            DireTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            DireTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            DireTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 243, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
        );

        contenedor.add(jPanel2, "card3");

        jButton1.setText("Agendar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Jornada", "Hora Consulta", "Entidad/Dirección", "Nombre Paciente", "Cédula"
            }
        ));
        jScrollPane1.setViewportView(JorTable);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Seleccionar mes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buscarIngTextField)
                                                .addGap(2, 2, 2)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(7, 7, 7)
                                            .addComponent(jLabel10)
                                            .addGap(6, 6, 6)
                                            .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(particular, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(81, 81, 81)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel7)
                        .addGap(269, 269, 269))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(particular)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(14, 14, 14))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EntiTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntiTableMouseClicked
        if (EntiTable.getSelectedRow() > -1 && EntiTable.isEnabled()) {}
         
    }//GEN-LAST:event_EntiTableMouseClicked

    private void PaciTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaciTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PaciTableMouseClicked

    private void ConTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ConTableMouseClicked

    private void buscarIngTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarIngTextFieldKeyReleased
        listarPacientes(buscarIngTextField.getText());
    }//GEN-LAST:event_buscarIngTextFieldKeyReleased

    private void DireTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DireTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DireTableMouseClicked

    private void particularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_particularActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) contenedor.getLayout();
        
        if(particular.isSelected())
        {            
            cl.show(contenedor, "jPanel1");
            jPanel1.setVisible(false);
            jPanel2.setVisible(true);
            DireTable.setVisible(true);
        }
        else
        {
            cl.show(contenedor, "jPanel2");
            jPanel1.setVisible(true);
            jPanel2.setVisible(false);
            DireTable.setVisible(false);
        }  
    }//GEN-LAST:event_particularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean control = true;
        String g = ((JTextField)date.getDateEditor().getUiComponent()).getText();
        if (!g.equals("") && (PaciTable.getSelectedRow() > -1) && controlhora==true){
            DefaultTableModel modelo = (DefaultTableModel) ConTable.getModel();
            DtPaciente p = dtpac.get(PaciTable.getSelectedRow());
            for (int i=0;i<modelo.getRowCount();i++){
                String j = (String) modelo.getValueAt(i,1);
                if (j.contains(hora.getSelectedItem().toString()+":"+min.getSelectedItem().toString()))
                    control = false;
            }
            if (control){
                String fechahora = g+" "+hora.getSelectedItem().toString()+":"+min.getSelectedItem().toString();
                String[] datos = {p.getCi(),fechahora};
                modelo.addRow(datos);
                DtConsulta dt = new DtConsulta();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm");
                Date d = null;
                try {
                    d = sdf.parse(fechahora);
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultarJornada.class.getName()).log(Level.SEVERE, null, ex);
                }
                dt.setPaciente(p.getCi());
                dt.setFecha(d);
                consultas.add(dt);
                SimpleDateFormat adf = new SimpleDateFormat("dd/M/yyyy");
                try {
                    this.Fechajor = adf.parse(g);
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultarJornada.class.getName()).log(Level.SEVERE, null, ex);
                }
                date.setEnabled(false);
            }
            else
            JOptionPane.showMessageDialog(this,"Hora ya seleccionada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this,"Selecciona una fecha, una hora y un paciente para agendar la consulta","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (consultas.isEmpty())
            JOptionPane.showMessageDialog(this,"No has agendado ninguna consulta","Error",JOptionPane.ERROR_MESSAGE);
        else if (!particular.isSelected() && EntiTable.getSelectedRow() >-1){
            DtEntidad dt = enti.get(EntiTable.getSelectedRow());
            if (Usr.IngresarJornada(consultas,particular.isSelected(),dt,Fechajor)){
                JOptionPane.showMessageDialog(this,"Se ha agregado la jornada a realizarce en la entidad "+dt.getNombre(),"Operación Exitosa",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
                JOptionPane.showMessageDialog(this,"Ya tienes una jornada esta fecha","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if (particular.isSelected() && DireTable.getSelectedRow()>-1){
            Direccion d = dire.get(DireTable.getSelectedRow());
            if (Usr.IngresarJornada(consultas,particular.isSelected(),d,Fechajor)){
                JOptionPane.showMessageDialog(this,"Se ha agregado la jornada a realizarce en la dirección particular","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
                JOptionPane.showMessageDialog(this,"Ya tienes una jornada esta fecha","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(this,"Selecciona una entidad o una dirección");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaActionPerformed
        // TODO add your handling code here:
        this.controlhora = true;
    }//GEN-LAST:event_horaActionPerformed
    
   
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarJornada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ConTable;
    private javax.swing.JTable DireTable;
    private javax.swing.JTable EntiTable;
    private javax.swing.JTable JorTable;
    private javax.swing.JTable PaciTable;
    private javax.swing.JTextField buscarIngTextField;
    private javax.swing.JPanel contenedor;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JComboBox<String> hora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JComboBox<String> min;
    private javax.swing.JCheckBox particular;
    // End of variables declaration//GEN-END:variables
}
