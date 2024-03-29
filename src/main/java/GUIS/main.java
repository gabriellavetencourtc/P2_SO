/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIS;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import MainClasses.IA;
import MainClasses.Administrador;
import MainClasses.Lista;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;


/**
 *
 * @author gabriellavetencourtc
 */
public class main extends javax.swing.JFrame {
    private IA CPU;
    private Ganadores ganadoresUI;
    /**
     * Creates new form main_UI
     */
    public main() {
        initComponents();
        
        Lista lganadores = new Lista();
        Lista lganadoresSM = new Lista();
        Lista lganadoresAvatar = new Lista();
        Semaphore mutex = new Semaphore(1);
        ganadoresUI = new Ganadores();
        
        this.CPU = new IA(mutex, lganadores,lganadoresSM,lganadoresAvatar, this, ganadoresUI);        
        Administrador admin = new Administrador(CPU, mutex, this);
        
        admin.start();
        this.CPU.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jPanel1 = new javax.swing.JPanel();
        PanelSM = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Contador_SM = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Cola1_CN = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        Cola2_CN = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Cola3_CN = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ColaR_CN = new javax.swing.JTextPane();
        PanelCPU = new javax.swing.JPanel();
        SMPanel = new javax.swing.JPanel();
        Personaje_SM = new javax.swing.JLabel();
        AvatarPanel = new javax.swing.JPanel();
        Personaje_Avatar = new javax.swing.JLabel();
        SetTime = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        DuracionCombate = new javax.swing.JTextField();
        FuerzaAvatar = new javax.swing.JLabel();
        FuerzaSM = new javax.swing.JLabel();
        VidaAvatar = new javax.swing.JLabel();
        VidaSM = new javax.swing.JLabel();
        TurnoSM = new javax.swing.JLabel();
        TurnoAvatar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Estado_CPU = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        verGanadores = new javax.swing.JButton();
        vs = new javax.swing.JLabel();
        PanelAvatar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Contador_Avatar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Cola1_Nick = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        Cola2_Nick = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        Cola3_Nick = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        ColaR_Nick = new javax.swing.JTextPane();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSM.setBackground(new java.awt.Color(255, 204, 153));
        PanelSM.setForeground(new java.awt.Color(255, 255, 102));
        PanelSM.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Colas de personajes");
        PanelSM.add(jLabel6);
        jLabel6.setBounds(0, 210, 199, 26);

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cola de Refuerzo");
        PanelSM.add(jLabel11);
        jLabel11.setBounds(10, 530, 111, 18);

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cola 3");
        PanelSM.add(jLabel12);
        jLabel12.setBounds(10, 440, 56, 18);

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cola 2");
        PanelSM.add(jLabel13);
        jLabel13.setBounds(10, 340, 116, 18);

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cola 1");
        PanelSM.add(jLabel14);
        jLabel14.setBounds(10, 250, 116, 18);
        PanelSM.add(jLabel16);
        jLabel16.setBounds(290, 6, 0, 0);

        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Ganadores");
        PanelSM.add(jLabel21);
        jLabel21.setBounds(70, 110, 130, 26);

        Contador_SM.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        Contador_SM.setForeground(new java.awt.Color(255, 255, 255));
        Contador_SM.setText("0");
        PanelSM.add(Contador_SM);
        Contador_SM.setBounds(110, 140, 152, 52);

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("UN SHOW MÁS");
        jLabel20.setMaximumSize(new java.awt.Dimension(120, 17));
        PanelSM.add(jLabel20);
        jLabel20.setBounds(30, 20, 230, 80);

        jScrollPane5.setViewportView(Cola1_CN);

        PanelSM.add(jScrollPane5);
        jScrollPane5.setBounds(30, 280, 200, 48);

        jScrollPane3.setViewportView(Cola2_CN);

        PanelSM.add(jScrollPane3);
        jScrollPane3.setBounds(30, 370, 201, 50);

        jScrollPane2.setViewportView(Cola3_CN);

        PanelSM.add(jScrollPane2);
        jScrollPane2.setBounds(30, 460, 201, 50);

        jScrollPane1.setViewportView(ColaR_CN);

        PanelSM.add(jScrollPane1);
        jScrollPane1.setBounds(30, 550, 204, 50);

        jPanel1.add(PanelSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 280, 620));

        PanelCPU.setBackground(new java.awt.Color(204, 204, 255));
        PanelCPU.setLayout(null);

        SMPanel.setBackground(new java.awt.Color(153, 153, 255));

        Personaje_SM.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Personaje_SM.setForeground(new java.awt.Color(255, 255, 255));
        Personaje_SM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Personaje_SM.setText("Personaje 1");
        Personaje_SM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout SMPanelLayout = new javax.swing.GroupLayout(SMPanel);
        SMPanel.setLayout(SMPanelLayout);
        SMPanelLayout.setHorizontalGroup(
            SMPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SMPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Personaje_SM, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SMPanelLayout.setVerticalGroup(
            SMPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SMPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Personaje_SM)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        PanelCPU.add(SMPanel);
        SMPanel.setBounds(0, 170, 170, 40);

        AvatarPanel.setBackground(new java.awt.Color(153, 153, 255));
        AvatarPanel.setForeground(new java.awt.Color(153, 153, 255));

        Personaje_Avatar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Personaje_Avatar.setForeground(new java.awt.Color(255, 255, 255));
        Personaje_Avatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Personaje_Avatar.setText("Personaje 2");

        javax.swing.GroupLayout AvatarPanelLayout = new javax.swing.GroupLayout(AvatarPanel);
        AvatarPanel.setLayout(AvatarPanelLayout);
        AvatarPanelLayout.setHorizontalGroup(
            AvatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvatarPanelLayout.createSequentialGroup()
                .addComponent(Personaje_Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        AvatarPanelLayout.setVerticalGroup(
            AvatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvatarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Personaje_Avatar)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        PanelCPU.add(AvatarPanel);
        AvatarPanel.setBounds(240, 170, 180, 40);

        SetTime.setBackground(new java.awt.Color(153, 153, 255));
        SetTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SetTime.setForeground(new java.awt.Color(255, 255, 255));
        SetTime.setText("Aceptar");
        SetTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetTimeActionPerformed(evt);
            }
        });
        PanelCPU.add(SetTime);
        SetTime.setBounds(300, 400, 102, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CONTROL DE TIEMPOS");
        PanelCPU.add(jLabel3);
        jLabel3.setBounds(130, 350, 200, 30);

        DuracionCombate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DuracionCombate.setText("1");
        DuracionCombate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DuracionCombateActionPerformed(evt);
            }
        });
        PanelCPU.add(DuracionCombate);
        DuracionCombate.setBounds(180, 400, 100, 30);

        FuerzaAvatar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FuerzaAvatar.setForeground(new java.awt.Color(255, 255, 255));
        FuerzaAvatar.setText("Fuerza Avatar");
        PanelCPU.add(FuerzaAvatar);
        FuerzaAvatar.setBounds(250, 250, 160, 17);

        FuerzaSM.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FuerzaSM.setForeground(new java.awt.Color(255, 255, 255));
        FuerzaSM.setText("Fuerza Show Mas");
        PanelCPU.add(FuerzaSM);
        FuerzaSM.setBounds(10, 250, 190, 17);

        VidaAvatar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        VidaAvatar.setForeground(new java.awt.Color(255, 255, 255));
        VidaAvatar.setText("Vida Avatar");
        PanelCPU.add(VidaAvatar);
        VidaAvatar.setBounds(250, 280, 160, 17);

        VidaSM.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        VidaSM.setForeground(new java.awt.Color(255, 255, 255));
        VidaSM.setText("Vida Show Mas");
        PanelCPU.add(VidaSM);
        VidaSM.setBounds(10, 280, 200, 17);

        TurnoSM.setBackground(new java.awt.Color(255, 255, 255));
        TurnoSM.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TurnoSM.setForeground(new java.awt.Color(255, 255, 255));
        TurnoSM.setText("Agilidad Show Mas");
        PanelCPU.add(TurnoSM);
        TurnoSM.setBounds(10, 220, 180, 20);

        TurnoAvatar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TurnoAvatar.setForeground(new java.awt.Color(255, 255, 255));
        TurnoAvatar.setText("Agilidad Avatar");
        PanelCPU.add(TurnoAvatar);
        TurnoAvatar.setBounds(250, 220, 160, 20);

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("DURACION (MS)");
        PanelCPU.add(jLabel15);
        jLabel15.setBounds(10, 400, 160, 30);

        Estado_CPU.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        Estado_CPU.setForeground(new java.awt.Color(255, 255, 255));
        Estado_CPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Estado_CPU.setText("ESTADO CPU");
        PanelCPU.add(Estado_CPU);
        Estado_CPU.setBounds(40, 90, 340, 20);

        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 255));
        jLabel19.setText("CPU");
        PanelCPU.add(jLabel19);
        jLabel19.setBounds(160, 20, 140, 60);

        verGanadores.setBackground(new java.awt.Color(153, 153, 255));
        verGanadores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        verGanadores.setForeground(new java.awt.Color(255, 255, 255));
        verGanadores.setText("Ver Ganadores");
        verGanadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verGanadoresActionPerformed(evt);
            }
        });
        PanelCPU.add(verGanadores);
        verGanadores.setBounds(110, 520, 220, 31);

        vs.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        vs.setForeground(new java.awt.Color(153, 153, 255));
        vs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vs.setText("VS");
        PanelCPU.add(vs);
        vs.setBounds(180, 180, 50, 28);

        jPanel1.add(PanelCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 6, 420, 620));

        PanelAvatar.setBackground(new java.awt.Color(102, 204, 255));
        PanelAvatar.setPreferredSize(new java.awt.Dimension(309, 594));
        PanelAvatar.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cola de Refuerzo");
        PanelAvatar.add(jLabel2);
        jLabel2.setBounds(10, 510, 111, 18);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ganadores");
        PanelAvatar.add(jLabel7);
        jLabel7.setBounds(80, 100, 140, 26);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cola 2");
        PanelAvatar.add(jLabel8);
        jLabel8.setBounds(10, 320, 116, 18);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cola 3");
        PanelAvatar.add(jLabel9);
        jLabel9.setBounds(10, 410, 56, 18);

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cola 1");
        PanelAvatar.add(jLabel10);
        jLabel10.setBounds(10, 230, 116, 18);
        PanelAvatar.add(jLabel18);
        jLabel18.setBounds(287, 6, 0, 64);

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Colas de personajes");
        PanelAvatar.add(jLabel17);
        jLabel17.setBounds(10, 200, 199, 26);

        Contador_Avatar.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        Contador_Avatar.setForeground(new java.awt.Color(255, 255, 255));
        Contador_Avatar.setText("0");
        PanelAvatar.add(Contador_Avatar);
        Contador_Avatar.setBounds(120, 130, 140, 52);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AVATAR");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 17));
        PanelAvatar.add(jLabel1);
        jLabel1.setBounds(70, 20, 160, 80);

        jScrollPane9.setViewportView(Cola1_Nick);

        PanelAvatar.add(jScrollPane9);
        jScrollPane9.setBounds(20, 260, 178, 50);

        jScrollPane8.setViewportView(Cola2_Nick);

        PanelAvatar.add(jScrollPane8);
        jScrollPane8.setBounds(20, 350, 180, 50);

        jScrollPane7.setViewportView(Cola3_Nick);

        PanelAvatar.add(jScrollPane7);
        jScrollPane7.setBounds(20, 440, 188, 50);

        jScrollPane6.setBackground(new java.awt.Color(153, 0, 0));
        jScrollPane6.setViewportView(ColaR_Nick);

        PanelAvatar.add(jScrollPane6);
        jScrollPane6.setBounds(20, 540, 190, 50);

        jPanel1.add(PanelAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 6, 260, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DuracionCombateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DuracionCombateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DuracionCombateActionPerformed

    private void SetTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetTimeActionPerformed
        // TODO add your handling code here:
        try {
            int dur = Integer.parseInt(this.DuracionCombate.getText());
            if (dur < 0) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido");
            } else {
                this.CPU.setDur(dur);
            }
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número entero válido.");
        }
    }//GEN-LAST:event_SetTimeActionPerformed

    private void verGanadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verGanadoresActionPerformed
    if (Integer.parseInt(this.Contador_SM.getText()) == 0 || Integer.parseInt(this.Contador_Avatar.getText()) == 0){
             JOptionPane.showMessageDialog(this, "Se necesitan ganadores de ambos equipos");
            }else{
            this.ganadoresUI.setVisible(true);

            this.ganadoresUI.getListSM().setText(this.CPU.listaGANADORESsm.mostrarLista());
            this.ganadoresUI.getListAvatar().setText(this.CPU.listaGANADORESavatar.mostrarLista());
            }
    }//GEN-LAST:event_verGanadoresActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new main().setVisible(true);
            }
        });
    }
    
        public void setAgilidadAvatar(String Avatar) {
        this.TurnoAvatar.setText(Avatar);

    }

    public void setAgilidadSM(String SM) {
        this.TurnoSM.setText(SM);

    }

    public void setVidaSM(String SM) {
        this.VidaSM.setText(SM);

    }

    public void setFuerzaSM(String SM) {
        this.FuerzaSM.setText(SM);
    }

    public void setFuerzaAvatar(String Avatar) {
        this.FuerzaAvatar.setText(Avatar);
    }

    public void setVidaAvatar(String Avatar) {
        this.VidaAvatar.setText(Avatar);

    }

    public JTextPane getColaR_CN() {
        return ColaR_CN;
    }

    public JTextPane getCola3_CN() {
        return Cola3_CN;
    }

    public JTextPane getCola2_CN() {
        return Cola2_CN;
    }

    public JTextPane getCola1_CN() {
        return Cola1_CN;
    }

    public JTextPane getColaR_Nick() {
        return ColaR_Nick;
    }

    public JTextPane getCola3_Nick() {
        return Cola3_Nick;
    }

    public JTextPane getCola2_Nick() {
        return Cola2_Nick;
    }

    public JTextPane getCola1_Nick() {
        return Cola1_Nick;
    }
    
    
    public JLabel getSMWin(){
        return Contador_SM;
    }
    
    public JLabel getAvatarWin(){
        return Contador_Avatar;
    }
    public JLabel getEstadoCPU() {
        return Estado_CPU;
    }
    
    public JLabel getPersonajeSMLabel() {
        return Personaje_SM; 
    }

    public void setPersonajeSMLabel(String text) {
        Personaje_SM.setText(text);
    }

    public JLabel getPersonajeAvatarLabel() {
        return Personaje_Avatar; 
    }

    public void setPersonajeAvatarLabel(String text) {
        Personaje_Avatar.setText(text);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AvatarPanel;
    private javax.swing.JTextPane Cola1_CN;
    private javax.swing.JTextPane Cola1_Nick;
    private javax.swing.JTextPane Cola2_CN;
    private javax.swing.JTextPane Cola2_Nick;
    private javax.swing.JTextPane Cola3_CN;
    private javax.swing.JTextPane Cola3_Nick;
    private javax.swing.JTextPane ColaR_CN;
    private javax.swing.JTextPane ColaR_Nick;
    private javax.swing.JLabel Contador_Avatar;
    private javax.swing.JLabel Contador_SM;
    private javax.swing.JTextField DuracionCombate;
    private javax.swing.JLabel Estado_CPU;
    private javax.swing.JLabel FuerzaAvatar;
    private javax.swing.JLabel FuerzaSM;
    private javax.swing.JPanel PanelAvatar;
    private javax.swing.JPanel PanelCPU;
    private javax.swing.JPanel PanelSM;
    private javax.swing.JLabel Personaje_Avatar;
    private javax.swing.JLabel Personaje_SM;
    private javax.swing.JPanel SMPanel;
    private javax.swing.JButton SetTime;
    private javax.swing.JLabel TurnoAvatar;
    private javax.swing.JLabel TurnoSM;
    private javax.swing.JLabel VidaAvatar;
    private javax.swing.JLabel VidaSM;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton verGanadores;
    private javax.swing.JLabel vs;
    // End of variables declaration//GEN-END:variables
}
