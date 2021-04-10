/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author lenovo
 */
public class Data_Outlet extends javax.swing.JFrame {
Connection conn;
    Statement stm;
    ResultSet rs;
    /**
     * Creates new form Data_Outlet
     */
    public Data_Outlet() {
        initComponents();
    siapIsi(false);
        tombolNormal();
        tampildaftartoko();
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
            String sql="select right (id_outlet,2)+1 from tb_outlet ";
            ResultSet rs=stm.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    Id_Outlet.setText("KOUT"+no);}
                }
            else
            {
                Id_Outlet.setText("KOUT001"); 
        }
        } catch (Exception e) 
        {
        } 
    }
    
    private void siapIsi(boolean a){
        Id_Outlet.setEnabled(a);
        Nama.setEnabled(a);
        Alamat.setEnabled(a);
        Telp.setEnabled(a);
    }
    
    private void tombolNormal(){
        tambah.setEnabled(true);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
        cari.setEnabled(true);
        
    }
    
    private void bersih(){
        Id_Outlet.setText("");
        Nama.setText("");
        Alamat.setText(""); 
        Telp.setText("");
    }
    
    private void simpan(){
        try{
            setKoneksi();
            String sql="insert into tb_outlet values('"+Id_Outlet.getText()
                    +"','"+Nama.getText()
                    +"','"+Alamat.getText()
                    +"','"+Telp.getText() +"')";
            stm.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null,"SIMPAN DATA OUTLET BERHASIL :)");
            }
            catch (Exception e) {
        }
        tampildaftartoko();
    }
    
    
    
    private void perbarui(){
        try{
            setKoneksi();
            String sql="update tb_outlet set nama='"+Nama.getText()
                    +"',alamat='"+Alamat.getText()
                    +"',tlp='"+Telp.getText()
                    +"' where id_outlet='"+Id_Outlet.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"EDIT DATA OUTLET BERHASIL","",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch(Exception e){
        }
        tampildaftartoko();
        
    }
    
    private void hapus(){
        try{
            String sql="delete from tb_outlet where id_outlet='"+ Id_Outlet.getText() +"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "DATA OUTLET TELAH DIHAPUS");
            }
            catch (Exception e) {
            }
        tampildaftartoko();
    }
    
    public void tampildaftartoko(){
        Object header[]={"Id Outlet","Nama","Alamat","Telepon"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tboutlet.setModel(data);
        setKoneksi();
        String sql="select*from tb_outlet";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4};
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
        Id_Outlet = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Alamat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tboutlet = new javax.swing.JTable();
        cari = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        pencarian = new javax.swing.JTextField();
        Telp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1133, 472));

        Id_Outlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_OutletActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Id Outlet");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Nama");

        Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaActionPerformed(evt);
            }
        });

        Alamat.setColumns(20);
        Alamat.setRows(5);
        jScrollPane1.setViewportView(Alamat);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("No.Telp");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Alamat");

        tboutlet.setModel(new javax.swing.table.DefaultTableModel(
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
        tboutlet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tboutletMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tboutlet);

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
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

        tambah.setBackground(new java.awt.Color(102, 102, 102));
        tambah.setText("Tambah");
        tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
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

        pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pencarianKeyPressed(evt);
            }
        });

        Telp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelpActionPerformed(evt);
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
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(tambah)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(Nama)
                            .addComponent(Id_Outlet)
                            .addComponent(Telp, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cari))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(simpan)
                        .addGap(26, 26, 26)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hapus)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Id_Outlet, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Telp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(simpan)
                    .addComponent(edit)
                    .addComponent(hapus)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Id_OutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_OutletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_OutletActionPerformed

    private void NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaActionPerformed

    private void tboutletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tboutletMouseClicked
        // TODO add your handling code here:
        int row = tboutlet.getSelectedRow();
        Id_Outlet.setText((String)tboutlet.getValueAt(row, 0));
        Nama.setText((String)tboutlet.getValueAt(row, 1));
        Alamat.setText((String)tboutlet.getValueAt(row, 2));
        Telp.setText((String)tboutlet.getValueAt(row, 3));
        hapus.setEnabled(true);
        edit.setEnabled(true);
    }//GEN-LAST:event_tboutletMouseClicked

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        Object header[]={"Id Outlet","Nama","Alamat","Telepon"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tboutlet.setModel(data);
        String sql="Select * from tb_outlet where id_outlet like '%" + pencarian.getText() + "%'" + "or nama like '%" +pencarian.getText()+"%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cariActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        if(Id_Outlet.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Id User Harus di Isi");
        }if(Nama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Harus di Isi");
        }if(Alamat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Alamat Harus di Isi");
        }if(Telp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Telepon Harus di Isi");
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

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        if(tambah.getText().equalsIgnoreCase("tambah")){
            tambah.setText("Refresh");
            bersih();
            siapIsi(true);
            auto_number();

            Id_Outlet.setEnabled(true);
            Nama.setEnabled(true);
            tambah.setEnabled(true);
            simpan.setEnabled(true);
            hapus.setEnabled(false);
            edit.setEnabled(false);

        } else{
            tambah.setText("Tambah");
            bersih();
            siapIsi(false);
            tombolNormal();
            tampildaftartoko();
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        if(edit.getText().equalsIgnoreCase("edit")){
            edit.setText("Batal");
            siapIsi(true);
            Id_Outlet.setEnabled(false);
            tambah.setEnabled(false);
            simpan.setEnabled(true);
            hapus.setEnabled(false);
            edit.setEnabled(true);
            cari.setEnabled(false);
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

    private void pencarianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pencarianKeyPressed
        // TODO add your handling code here:
        Object header[]={"Id Outlet","Nama","Alamat","Telepon"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tboutlet.setModel(data);
        String sql="Select * from tb_outlet where id_outlet like '%" + pencarian.getText() + "%'" + "or nama like '%" +pencarian.getText()+"%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);

                String kolom[]={kolom1,kolom2,kolom3,kolom4};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pencarianKeyPressed

    private void TelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Data_Outlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Outlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Outlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Outlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Outlet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Alamat;
    private javax.swing.JTextField Id_Outlet;
    private javax.swing.JTextField Nama;
    private javax.swing.JTextField Telp;
    private javax.swing.JButton cari;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField pencarian;
    private javax.swing.JButton simpan;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tboutlet;
    // End of variables declaration//GEN-END:variables
}