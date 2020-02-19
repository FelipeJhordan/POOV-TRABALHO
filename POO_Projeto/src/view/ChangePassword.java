package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pessoa;
import util.CriptoPessoa;

public class ChangePassword extends javax.swing.JDialog {

    /**
     * Creates new form changePassword
     */
    public ChangePassword(java.awt.Frame parent, boolean modal, Connection con, Pessoa pessoa) {
        super(parent, modal);
        connection = con;
        pessoaLogada = pessoa;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnMudar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jOldPassword = new javax.swing.JPasswordField();
        jNewPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(230, 234, 234));
        jPanel2.setPreferredSize(new java.awt.Dimension(430, 440));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 26, 19));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Digite a senha antiga");

        btnMudar.setBackground(new java.awt.Color(47, 130, 55));
        btnMudar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        btnMudar.setForeground(new java.awt.Color(244, 244, 244));
        btnMudar.setText("Mudar");
        btnMudar.setBorderPainted(false);
        btnMudar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMudar.setFocusPainted(false);
        btnMudar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMudarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMudarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMudarMouseExited(evt);
            }
        });
        btnMudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMudarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(47, 130, 55));
        btnSair.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(244, 244, 244));
        btnSair.setText("Sair");
        btnSair.setBorderPainted(false);
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.setFocusPainted(false);
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Senha Antiga");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("Senha Nova");

        jOldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOldPasswordActionPerformed(evt);
            }
        });

        jNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnMudar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jOldPassword)
                            .addComponent(jNewPassword, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMudar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(47, 157, 55));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(244, 244, 244));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nova senha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMudarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMudarMouseClicked
        String senhaAntiga = new String(jOldPassword.getPassword());
        String senhaNova = new String(jNewPassword.getPassword());
        if (senhaAntiga.equals("") || senhaAntiga.equals("")) {
            if (senhaAntiga.equals("") && senhaNova.equals("")) {
                JOptionPane.showMessageDialog(this, "Campos em branco");
            } else if (senhaAntiga.equals("")) {
                JOptionPane.showMessageDialog(this, "Senha antiga em branco");
                this.jOldPassword.requestFocus();
            } else if (senhaNova.equals("")) {
                JOptionPane.showMessageDialog(this, "Campo senha em branco");
                this.jNewPassword.requestFocus();
            }
        }
    }//GEN-LAST:event_btnMudarMouseClicked

    private void btnMudarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMudarMouseEntered
        btnMudar.setBackground(new Color(50, 170, 60));
        btnMudar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnMudarMouseEntered

    private void btnMudarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMudarMouseExited
        btnMudar.setBackground(new Color(50, 130, 60));
        btnMudar.setForeground(new Color(244, 244, 244));
    }//GEN-LAST:event_btnMudarMouseExited
    private boolean verificarSenha() {
        if (new CriptoPessoa().criptografa(new String(this.jOldPassword.getPassword())).equals(pessoaLogada.getSenha())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificarCampos() {
        String senhaAntiga = new String(this.jOldPassword.getPassword());
        String senhaNova = new String(this.jNewPassword.getPassword());
        if (senhaAntiga.equals("") || senhaNova.equals("")) {
            if (senhaAntiga.equals("") && senhaNova.equals("")) {
                JOptionPane.showMessageDialog(this, "Campos em branco");
            } else if (senhaAntiga.equals("")) {
                JOptionPane.showMessageDialog(this, "Senha antiga em branco");
            } else {
                JOptionPane.showMessageDialog(this, "Senha nova em branco");
            }
            return false;
        }
        return true;

    }
    private void btnMudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMudarActionPerformed
        if (verificarCampos()) {
            if (verificarSenha()) {
                mudarSenha();
            } else {
                JOptionPane.showMessageDialog(this, "Senha atual inválida");
            }
        }
    }//GEN-LAST:event_btnMudarActionPerformed
    public void mudarSenha() {
        try {
            PreparedStatement stmt = connection.prepareStatement("update pessoa set senha=? where id=?");
            stmt.setString(1, new CriptoPessoa().criptografa(new String(this.jNewPassword.getPassword())));
            stmt.setLong(2, this.pessoaLogada.getId());
            if (stmt.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Senha alterada com sucesso");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao alterar");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        btnSair.setBackground(new Color(50, 170, 60));
        btnMudar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        btnSair.setBackground(new Color(50, 130, 60));
        btnSair.setForeground(new Color(244, 244, 244));
    }//GEN-LAST:event_btnSairMouseExited

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void jOldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jOldPasswordActionPerformed

    private void jNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNewPasswordActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMudar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jNewPassword;
    private javax.swing.JPasswordField jOldPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    private Pessoa pessoaLogada;
    private Connection connection;
}
