package view;

import java.sql.*;
import controle.ConexaoBd;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Belmiro-Mungoi
 */
public class TelaUsuario extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int flag = 1;
    

    public TelaUsuario() {
        initComponents();
        conexao = ConexaoBd.conector();
    }
    
    private void adicionar() {
        String sql = "insert into tbusuario(idusuer, usuario, biuser, cell, login, senha, perfil) values(?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,jTextFieldID.getText());
            pst.setString(2,jTextFieldNome.getText());
            pst.setString(3,jTextFieldBI.getText());
            pst.setString(4,jTextFieldCell.getText());
            pst.setString(5,jTextFieldLogin.getText());
            pst.setString(6,jTextFieldSenha.getText());
            pst.setString(7,jComboBoxPerfil.getSelectedItem().toString());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel adicionar usuario\n"+e.getMessage());
        }
    }
    
    private void deletar() {
        String sql = "delete from tbusuario where idusuer = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldID.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario Excluido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir:\n"+ e.getMessage());
        }
    }
    
    private void editar(){
        String sql = "update tbusuario set usuario = ?,biuser = ?,cell = ?,login = ?,senha = ?, perfil = ? where idusuer = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNome.getText());
            pst.setString(2, jTextFieldBI.getText());
            pst.setString(3, jTextFieldCell.getText());
            pst.setString(4, jTextFieldLogin.getText());
            pst.setString(5, jTextFieldSenha.getText());
            pst.setString(6, jComboBoxPerfil.getSelectedItem().toString());
            pst.setString(7, jTextFieldID.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados editados com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel editar\n" + e.getMessage());
        }
    }
    
    private void pesquisar() {
        String sql = "select * from tbusuario where idusuer = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldID.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                jTextFieldNome.setText(rs.getString(2));
                jTextFieldBI.setText(rs.getString(3));
                jTextFieldCell.setText(rs.getString(4));     
                jTextFieldLogin.setText(rs.getString(5));
                jTextFieldSenha.setText(rs.getString(6));
                jComboBoxPerfil.setSelectedItem(rs.getString(7));
            } else {
                JOptionPane.showMessageDialog(null, "Usuario nao registado");
                jTextFieldNome.setText("");
                jTextFieldCell.setText("");
                jTextFieldBI.setText("");
                jTextFieldLogin.setText("");
                jTextFieldSenha.setText("");
                jTextFieldNome.setEnabled(false);
                jTextFieldCell.setEnabled(false);
                jTextFieldBI.setEnabled(false);
                jTextFieldLogin.setEnabled(false);
                jTextFieldSenha.setEnabled(false);
                jComboBoxPerfil.setEnabled(false);        
                jButtonEditar.setEnabled(false);
                jButtonApagar.setEnabled(false);   
                jButtonSalvar.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario nao existe:\n" +e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCell = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldBI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JTextField();
        jComboBoxPerfil = new javax.swing.JComboBox<>();
        jButtonNovo = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonProcurar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(660, 560));

        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("ID:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Nome:");

        jTextFieldNome.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Cell:");

        jTextFieldCell.setEnabled(false);

        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("BI:");

        jTextFieldBI.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Perfi:");

        jTextFieldLogin.setEnabled(false);

        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Login:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Senha:");

        jTextFieldSenha.setEnabled(false);

        jComboBoxPerfil.setForeground(new java.awt.Color(0, 0, 102));
        jComboBoxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "normal" }));
        jComboBoxPerfil.setEnabled(false);

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newUser.png"))); // NOI18N
        jButtonNovo.setToolTipText("Novo Usuário");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteUser.png"))); // NOI18N
        jButtonApagar.setToolTipText("Apagar Usuário");
        jButtonApagar.setEnabled(false);
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editUser.png"))); // NOI18N
        jButtonEditar.setToolTipText("Editar Usuário");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/procurar.png"))); // NOI18N
        jButtonProcurar.setToolTipText("Procurar Usuário");
        jButtonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcurarActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo00.png"))); // NOI18N

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saveAll.png"))); // NOI18N
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        jButtonCancel.setToolTipText("Cancelar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(28, 28, 28)
                            .addComponent(jTextFieldBI, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxPerfil, 0, 240, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldSenha))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldCell)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNovo)
                                .addGap(25, 25, 25)
                                .addComponent(jButtonApagar)
                                .addGap(25, 25, 25)
                                .addComponent(jButtonEditar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSalvar)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancel)
                            .addComponent(jButtonProcurar))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel4)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonApagar)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonProcurar)
                    .addComponent(jButtonNovo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancel)
                            .addComponent(jButtonSalvar))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setBounds(0, 0, 660, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProcurarActionPerformed
        if (jTextFieldID.getText().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Preencha o campo ID");
           jTextFieldID.requestFocus();
           jButtonApagar.setEnabled(false);
           jButtonEditar.setEnabled(false);
           jButtonSalvar.setEnabled(false);
        } else {
            pesquisar();
            jTextFieldNome.setEnabled(false);
            jTextFieldCell.setEnabled(false);
            jTextFieldBI.setEnabled(false);
            jTextFieldLogin.setEnabled(false);
            jTextFieldSenha.setEnabled(false);
            jComboBoxPerfil.setEnabled(false);        
            jButtonEditar.setEnabled(true);
            jButtonApagar.setEnabled(true); 
            jButtonSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonProcurarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        flag = 2;
        jTextFieldNome.setEnabled(true);
        jTextFieldCell.setEnabled(true);
        jTextFieldBI.setEnabled(true); 
        jTextFieldLogin.setEnabled(true);
        jTextFieldSenha.setEnabled(true);        
        jComboBoxPerfil.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jTextFieldID.setEnabled(false);
        jButtonApagar.setEnabled(false);
        jButtonNovo.setEnabled(false);
        jButtonEditar.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag = 1;
        jTextFieldNome.setEnabled(true);
        jTextFieldCell.setEnabled(true);
        jTextFieldBI.setEnabled(true);
        jTextFieldLogin.setEnabled(true);
        jTextFieldSenha.setEnabled(true);
        jComboBoxPerfil.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNovo.setEnabled(true);  
        jButtonEditar.setEnabled(false);
        jButtonApagar.setEnabled(false);
        jTextFieldID.setText("");
        jTextFieldNome.setText("");
        jTextFieldCell.setText("");
        jTextFieldBI.setText("");
        jTextFieldLogin.setText("");
        jTextFieldSenha.setText("");                     
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (jTextFieldID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo ID");
            jTextFieldID.requestFocus();
        } else if (jTextFieldBI.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o campo BI");
            jTextFieldBI.requestFocus();
        } else if (jTextFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo NOME");
            jTextFieldNome.requestFocus();
        } else if (jTextFieldLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo LOGIN");
            jTextFieldLogin.requestFocus();
        } else if (jTextFieldSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo SENHA");
            jTextFieldSenha.requestFocus();
        } else if (flag == 1) {
            adicionar();
            jTextFieldID.setText("");
            jTextFieldNome.setText("");
            jTextFieldCell.setText("");
            jTextFieldBI.setText("");
            jTextFieldLogin.setText("");
            jTextFieldSenha.setText(""); 
            jTextFieldNome.setEnabled(false);
            jTextFieldCell.setEnabled(false);
            jTextFieldBI.setEnabled(false);
            jTextFieldLogin.setEnabled(false);
            jTextFieldSenha.setEnabled(false);
            jComboBoxPerfil.setEnabled(false);        
            jButtonSalvar.setEnabled(false);
            jButtonApagar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jTextFieldID.setEnabled(true);
        } else {
            editar();
            jTextFieldID.setText("");
            jTextFieldNome.setText("");
            jTextFieldCell.setText("");
            jTextFieldBI.setText("");
            jTextFieldLogin.setText("");
            jTextFieldSenha.setText(""); 
            jTextFieldNome.setEnabled(false);
            jTextFieldCell.setEnabled(false);
            jTextFieldBI.setEnabled(false);
            jTextFieldLogin.setEnabled(false);
            jTextFieldSenha.setEnabled(false);
            jComboBoxPerfil.setEnabled(false);        
            jButtonSalvar.setEnabled(false);
            jButtonApagar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jTextFieldID.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        jTextFieldID.setText("");
        jTextFieldNome.setText("");
        jTextFieldCell.setText("");
        jTextFieldBI.setText("");
        jTextFieldLogin.setText("");
        jTextFieldSenha.setText(""); 
        jTextFieldNome.setEnabled(false);
        jTextFieldCell.setEnabled(false);
        jTextFieldBI.setEnabled(false);
        jTextFieldLogin.setEnabled(false);
        jTextFieldSenha.setEnabled(false);
        jComboBoxPerfil.setEnabled(false);        
        jButtonSalvar.setEnabled(false);
        jButtonApagar.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonProcurar.setEnabled(true);
        jTextFieldID.setEnabled(true);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed
        int del = JOptionPane.showConfirmDialog(null, "Deseja deletar o usuario?", "Atencao", JOptionPane.YES_NO_OPTION);
        if (del == JOptionPane.YES_OPTION) {
            deletar();
            jTextFieldID.setText("");
            jTextFieldNome.setText("");
            jTextFieldCell.setText("");
            jTextFieldBI.setText("");
            jTextFieldLogin.setText("");
            jTextFieldSenha.setText(""); 
            jTextFieldNome.setEnabled(false);
            jTextFieldCell.setEnabled(false);
            jTextFieldBI.setEnabled(false);
            jTextFieldLogin.setEnabled(false);
            jTextFieldSenha.setEnabled(false);
            jComboBoxPerfil.setEnabled(false);        
            jButtonSalvar.setEnabled(false);
            jButtonApagar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jButtonProcurar.setEnabled(true);
            jTextFieldID.setEnabled(true);
        }
     
    }//GEN-LAST:event_jButtonApagarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonProcurar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldBI;
    private javax.swing.JTextField jTextFieldCell;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    // End of variables declaration//GEN-END:variables
}
