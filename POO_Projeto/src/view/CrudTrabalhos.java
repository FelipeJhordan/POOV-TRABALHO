package view;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.TableModelTrabalho;
import model.Trabalho;
import model.TrabalhoDao;
import util.TextFieldsUtils;

public class CrudTrabalhos extends javax.swing.JInternalFrame {

    private TableModelTrabalho tableModelTrabalho;
    public CrudTrabalhos(Connection con) {
         connection = con;
         trabalhoDao = new TrabalhoDao(con);
        initComponents();
        tableModelTrabalho = new TableModelTrabalho();
        this.tabelaTrabalhos.setModel(tableModelTrabalho);
        adicionaElementosLista();
    }

     public void adicionaElementosLista(){
         List<Trabalho> listaTrabalhos = this.trabalhoDao.getLista();
         for (Trabalho trabalho : listaTrabalhos) {
             this.tableModelTrabalho.addTrabalho(trabalho);
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

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabelId1 = new javax.swing.JLabel();
        jLabelId2 = new javax.swing.JLabel();
        tfOrientador = new javax.swing.JTextField();
        tfAluno = new javax.swing.JTextField();
        tfTitulo = new javax.swing.JTextField();
        jLabelId4 = new javax.swing.JLabel();
        tfEquipamentos = new javax.swing.JTextField();
        jLabelId5 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabelId6 = new javax.swing.JLabel();
        tfCoorientador = new javax.swing.JTextField();
        jLabelId7 = new javax.swing.JLabel();
        tfEvento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaTrabalhos = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabelId8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaResumo = new javax.swing.JTextArea();

        jButton3.setText("jButton3");

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1100, 600));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 240, 250));
        jPanel1.setAutoscrolls(true);

        jLabel9.setBackground(new java.awt.Color(235, 240, 240));
        jLabel9.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Crud Trabalhos");

        jLabelId.setBackground(new java.awt.Color(235, 240, 235));
        jLabelId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelId.setForeground(new java.awt.Color(13, 15, 0));
        jLabelId.setText("      ID:");

        tfId.setEditable(false);
        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        jLabelId1.setBackground(new java.awt.Color(235, 240, 235));
        jLabelId1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelId1.setForeground(new java.awt.Color(13, 15, 0));
        jLabelId1.setText("EVENTO:");

        jLabelId2.setBackground(new java.awt.Color(235, 240, 235));
        jLabelId2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelId2.setForeground(new java.awt.Color(13, 15, 0));
        jLabelId2.setText("ALUNO:");

        tfOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOrientadorActionPerformed(evt);
            }
        });

        tfAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlunoActionPerformed(evt);
            }
        });

        tfTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTituloActionPerformed(evt);
            }
        });

        jLabelId4.setBackground(new java.awt.Color(235, 240, 235));
        jLabelId4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelId4.setForeground(new java.awt.Color(13, 15, 0));
        jLabelId4.setText("         TÍTULO:");

        tfEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEquipamentosActionPerformed(evt);
            }
        });

        jLabelId5.setBackground(new java.awt.Color(235, 240, 235));
        jLabelId5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelId5.setForeground(new java.awt.Color(13, 15, 0));
        jLabelId5.setText("EQUIPAMENTOS:");

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");

        jLabelId6.setBackground(new java.awt.Color(235, 240, 235));
        jLabelId6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelId6.setForeground(new java.awt.Color(13, 15, 0));
        jLabelId6.setText("COORIENTADOR:");

        tfCoorientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCoorientadorActionPerformed(evt);
            }
        });

        jLabelId7.setBackground(new java.awt.Color(235, 240, 235));
        jLabelId7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelId7.setForeground(new java.awt.Color(13, 15, 0));
        jLabelId7.setText("ORIENTADOR:");

        tfEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEventoActionPerformed(evt);
            }
        });

        tabelaTrabalhos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaTrabalhos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTrabalhosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaTrabalhos);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabelId8.setBackground(new java.awt.Color(235, 240, 235));
        jLabelId8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelId8.setForeground(new java.awt.Color(13, 15, 0));
        jLabelId8.setText("RESUMO:");

        textAreaResumo.setColumns(20);
        textAreaResumo.setRows(5);
        jScrollPane1.setViewportView(textAreaResumo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jLabelId4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelId)
                                .addComponent(jLabelId7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelId2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelId6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfCoorientador, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelId8)
                            .addComponent(jLabelId5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelId1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEvento))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane1)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btnAdicionar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeletar)
                            .addComponent(btnFechar)
                            .addComponent(btnAtualizar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelId2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelId6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCoorientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelId7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelId4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelId5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelId1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelId8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnAdicionar))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void tfOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOrientadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfOrientadorActionPerformed

    private void tfAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAlunoActionPerformed

    private void tfTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTituloActionPerformed

    private void tfEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEquipamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEquipamentosActionPerformed

    private void tfCoorientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCoorientadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCoorientadorActionPerformed

    private void tfEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEventoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        if(tfId.getText() == ""){
            JOptionPane.showMessageDialog(this, "Id vazio");
        } else{
            if(trabalhoDao.removeTrabalho(Long.parseLong(this.tfId.getText()))){
                tableModelTrabalho.removeTrabalho(tabelaTrabalhos.getSelectedRow());
                 new TextFieldsUtils().clearTextFields(rootPane);
            }
            
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        new TextFieldsUtils().clearTextFields(rootPane);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        List <String> strings = new ArrayList<String>();
       new TextFieldsUtils().getTfs(rootPane, strings);
        if (new TextFieldsUtils().verificandoVazios(strings)) {
            JOptionPane.showMessageDialog(this, "Campos vazios");
        } else {
            try {
                Trabalho novoTrabalho = new Trabalho();
                  if(tfId.getText().equals("") == false){
                    novoTrabalho.setId(Long.parseLong(tfId.getText()));
                }
                novoTrabalho.setAlunoLider(Long.parseLong(this.tfAluno.getText()));
                novoTrabalho.setOrientador(Long.parseLong(this.tfOrientador.getText()));
                novoTrabalho.setCoorientador(Long.parseLong(this.tfCoorientador.getText()));
                novoTrabalho.setTitulo(this.tfTitulo.getText());
                novoTrabalho.setEventoTrabalho(Integer.parseInt(this.tfEvento.getText()));
                novoTrabalho.setResumo(this.textAreaResumo.getText());
                novoTrabalho.setEquipamentos(this.tfEquipamentos.getText());
                if(trabalhoDao.salvar(novoTrabalho)){
                if(novoTrabalho.getId() == null){
                      novoTrabalho.setId(trabalhoDao.getLista().get(trabalhoDao.getLista().size()-1).getId());
                    tableModelTrabalho.addTrabalho(novoTrabalho);
                }  else { 
                    tableModelTrabalho.edita(novoTrabalho);
                }
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
                
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tabelaTrabalhosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTrabalhosMouseClicked
         int linha = this.tabelaTrabalhos.getSelectedRow();
        Trabalho trabalho = this.tableModelTrabalho.getTrabalho(linha);
        this.tfId.setText(""+trabalho.getId());
        this.tfTitulo.setText(""+trabalho.getTitulo());
        this.tfEquipamentos.setText(""+trabalho.getEquipamentos());
        this.textAreaResumo.setText(""+trabalho.getResumo());
        this.tfAluno.setText(""+trabalho.getAlunoLider());
        this.tfOrientador.setText(""+trabalho.getOrientador());
        this.tfCoorientador.setText(""+trabalho.getCoorientador());
    }//GEN-LAST:event_tabelaTrabalhosMouseClicked
    public void atualizarTabela(){
        this.tabelaTrabalhos.removeAll();
        adicionaElementosLista();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelId1;
    private javax.swing.JLabel jLabelId2;
    private javax.swing.JLabel jLabelId4;
    private javax.swing.JLabel jLabelId5;
    private javax.swing.JLabel jLabelId6;
    private javax.swing.JLabel jLabelId7;
    private javax.swing.JLabel jLabelId8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaTrabalhos;
    private javax.swing.JTextArea textAreaResumo;
    private javax.swing.JTextField tfAluno;
    private javax.swing.JTextField tfCoorientador;
    private javax.swing.JTextField tfEquipamentos;
    private javax.swing.JTextField tfEvento;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfOrientador;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
    private Connection connection;
    private TrabalhoDao trabalhoDao;
}
