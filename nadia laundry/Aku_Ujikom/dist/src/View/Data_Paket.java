/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class Data_Paket extends javax.swing.JFrame {
Connection conn;
    Statement stm;
    ResultSet rs;
    /**
     * Creates new form Data_Paket
     */
    public Data_Paket() {
        initComponents();
        siapIsi(false);
        tombolNormal();
        tampildaftarpaket();
        id_outlet();
    }
     public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/laundry_db","root","");
            stm=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }
    
    private void auto_number(){
        try {
            setKoneksi();
            String sql="select right (id_paket,2)+1 from tb_paket ";
            ResultSet rs=stm.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    Id_Paket.setText("KPA"+no);}
                }
            else
            {
                Id_Paket.setText("KPA001"); 
        }
        } catch (Exception e) 
        {
        } 
    }
    
    private void id_outlet(){
        String sql = "SELECT * FROM tb_outlet";
        try{
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Id_Outlet.addItem(rs.getString("Id_Outlet"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void siapIsi(boolean a){
        Id_Paket.setEnabled(a);
        Id_Outlet.setEnabled(a);
        jenis_cucian.setEnabled(a);
        Nama_Paket.setEnabled(a);
        Harga.setEnabled(a);
    }
    
    private void tombolNormal(){
        tambah.setEnabled(true);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
        Cari.setEnabled(true);
        
    }
    
    private void bersih(){
        Id_Paket.setText("");
        Id_Outlet.setSelectedItem("");     
        jenis_cucian.setSelectedItem("");
        Nama_Paket.setText("");
        Harga.setText("");
    }
    
    private void simpan(){
        try{
            setKoneksi();
            String sql="insert into tb_paket values('"+Id_Paket.getText()
                    +"','"+Id_Outlet.getSelectedItem()
                    +"','"+jenis_cucian.getSelectedItem()
                    +"','"+Nama_Paket.getText()
                    +"','"+Harga.getText() +"')";
            stm.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null,"SIMPAN DATA PAKET BERHASIL :)");
            }
            catch (Exception e) {
        }
        tampildaftarpaket();
       
    }
    
    private void perbarui(){
        try{
            setKoneksi();
            String sql="update tb_paket set id_outlet='"+Id_Outlet.getSelectedItem()
                    +"',jenis='"+jenis_cucian.getSelectedItem()
                    +"',nama_paket='"+Nama_Paket.getText()
                    +"',harga='"+Harga.getText()
                    +"' where id_paket='"+Id_Paket.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"EDIT DATA PAKET BERHASIL","",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch(Exception e){
        }
        tampildaftarpaket();
        
    }
    
    private void hapus(){
        try{
            String sql="delete from tb_paket where id_paket='"+ Id_Paket.getText() +"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "DATA PAKET TELAH DIHAPUS");
            }
            catch (Exception e) {
            }
        tampildaftarpaket();
    }
    
    public void tampildaftarpaket(){
        Object header[]={"Id Paket","Id Outlet","Jenis","Nama Paket","Harga"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tb_paket.setModel(data);
        setKoneksi();
        String sql="select*from tb_paket";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Id_Paket = new javax.swing.JTextField();
        Id_Outlet = new javax.swing.JComboBox<>();
        jenis_cucian = new javax.swing.JComboBox<>();
        Nama_Paket = new javax.swing.JTextField();
        Harga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_paket = new javax.swing.JTable();
        pencarian = new javax.swing.JTextField();
        Cari = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Id Paket");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Id Outlet");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Jenis Cucian");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Nama Paket");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Harga");

        Id_Paket.setPreferredSize(new java.awt.Dimension(10, 20));

        Id_Outlet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-PILIH-" }));
        Id_Outlet.setPreferredSize(new java.awt.Dimension(10, 20));

        jenis_cucian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -", "Cuci Basah", "Cuci Kering", "Cuci Setrika", "Lain" }));
        jenis_cucian.setPreferredSize(new java.awt.Dimension(10, 20));
        jenis_cucian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenis_cucianActionPerformed(evt);
            }
        });

        Nama_Paket.setPreferredSize(new java.awt.Dimension(10, 20));

        Harga.setPreferredSize(new java.awt.Dimension(10, 20));
        Harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HargaActionPerformed(evt);
            }
        });

        tb_paket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb_paket);

        pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencarianActionPerformed(evt);
            }
        });

        Cari.setText("Cari");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        tambah.setBackground(new java.awt.Color(102, 102, 102));
        tambah.setText("Tambah");
        tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        simpan.setBackground(new java.awt.Color(102, 102, 102));
        simpan.setText("Simpan");
        simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(102, 102, 102));
        edit.setText("Edit");
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(102, 102, 102));
        hapus.setText("Hapus");
        hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tambah)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(Id_Outlet, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(simpan)
                        .addGap(18, 18, 18)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(hapus)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jenis_cucian, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nama_Paket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Harga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Id_Paket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Id_Paket, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Id_Outlet, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jenis_cucian, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Nama_Paket, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambah)
                            .addComponent(simpan)
                            .addComponent(edit)
                            .addComponent(hapus)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pencarianActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
        Object header[]={"Id Paket", "Id Outlet", "Jenis", "Nama Paket", "Harga"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tb_paket.setModel(data);
        String sql="Select * from tb_paket where id_paket like '%" + pencarian.getText() + "%'" + "or nama_paket like '%" +pencarian.getText()+"%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);

                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5};
                data.addRow(kolom);
            }

        } catch (Exception e) {
        }
        }

        private void pencarianKeyPressed(java.awt.event.KeyEvent evt) {
            // TODO add your handling code here:
            Object header[]={"Id Paket", "Id Outlet", "Jenis", "Nama Paket", "Harga"};
            DefaultTableModel data=new DefaultTableModel(null,header);
            tb_paket.setModel(data);
            String sql="Select * from tb_paket where id_paket like '%" + pencarian.getText() + "%'" + "or nama_paket like '%" +pencarian.getText()+"%'";
            try {
                ResultSet rs=stm.executeQuery(sql);
                while (rs.next())
                {
                    String kolom1=rs.getString(1);
                    String kolom2=rs.getString(2);
                    String kolom3=rs.getString(3);
                    String kolom4=rs.getString(4);
                    String kolom5=rs.getString(5);

                    String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5};
                    data.addRow(kolom);
                }

            } catch (Exception e) {
            }
    }//GEN-LAST:event_CariActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        if(tambah.getText().equalsIgnoreCase("tambah")){
            tambah.setText("Refresh");
            bersih();
            siapIsi(true);
            auto_number();

            Id_Paket.setEnabled(true);
            Nama_Paket.setEnabled(true);
            tambah.setEnabled(true);
            simpan.setEnabled(true);
            hapus.setEnabled(false);
            edit.setEnabled(false);
            Cari.setEnabled(false);

        } else{
            tambah.setText("Tambah");
            bersih();
            siapIsi(false);
            tombolNormal();
            tampildaftarpaket();
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        if(Id_Paket.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Id Paket Harus di Isi");
        }if(Id_Outlet.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Id Outlet Harus di Pilih");
        }if(jenis_cucian.getSelectedIndex()== 0){
            JOptionPane.showMessageDialog(null, "Jenis Harus di Pilih");
        }if(Nama_Paket.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Harus di Isi");
        }if(Harga.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harga Harus di Isi");
        }else{
            if(tambah.getText().equalsIgnoreCase("Refresh")){
                if(tambah.getText().equalsIgnoreCase("Refresh")){
                    simpan();
                } else{
                    JOptionPane.showMessageDialog(null, "SIMPAN DATA GAGAL, PERIKSA KEMBALI :( ","",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(edit.getText().equalsIgnoreCase("batal")){
                if(edit.getText().equalsIgnoreCase("batal")){
                    perbarui();
                } else{
                    JOptionPane.showMessageDialog(null, "EDIT DATA GAGAL, PERIKSA KEMBALI :( ","",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            bersih();
            siapIsi(false);
            tambah.setText("Tambah");
            edit.setText("Edit");
            tombolNormal();
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        if(edit.getText().equalsIgnoreCase("edit")){
            edit.setText("Batal");
            siapIsi(true);
            Id_Paket.setEnabled(false);
            tambah.setEnabled(false);
            simpan.setEnabled(true);
            hapus.setEnabled(false);
            edit.setEnabled(true);
            Cari.setEnabled(false);
        } else{
            edit.setText("Edit");
            bersih();
            siapIsi(false);
            tombolNormal();
        }
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int pesan=JOptionPane.showConfirmDialog(null, "YAKIN DATA AKAN DIHAPUS ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(pesan==JOptionPane.YES_OPTION){
            if(pesan==JOptionPane.YES_OPTION){
                hapus();
                bersih();
                siapIsi(false);
                tombolNormal();
            } else{
                JOptionPane.showMessageDialog(null, "HAPUS DATA GAGAL :(");
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jenis_cucianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenis_cucianActionPerformed
        // TODO add your handling code here:
        if (jenis_cucian.getSelectedItem(). toString(). equalsIgnoreCase("Cuci kering")){
          Harga.setText("6000");
      }else if (jenis_cucian.getSelectedItem(). toString(). equalsIgnoreCase("Cuci basah")){
          Harga.setText("8000");
      }else if (jenis_cucian.getSelectedItem(). toString(). equalsIgnoreCase("Cuci setrika")){
          Harga.setText("12000");
      }
    }//GEN-LAST:event_jenis_cucianActionPerformed

    private void HargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HargaActionPerformed

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
            java.util.logging.Logger.getLogger(Data_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Paket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cari;
    private javax.swing.JTextField Harga;
    private javax.swing.JComboBox<String> Id_Outlet;
    private javax.swing.JTextField Id_Paket;
    private javax.swing.JTextField Nama_Paket;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenis_cucian;
    private javax.swing.JTextField pencarian;
    private javax.swing.JButton simpan;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tb_paket;
    // End of variables declaration//GEN-END:variables
}
