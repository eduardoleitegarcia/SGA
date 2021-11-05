package view;

import dao.DAOOrigem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloOrigem;

public class ViewOrigem extends javax.swing.JInternalFrame {

    //instância de classes
    ModeloOrigem origem = new ModeloOrigem();
    DAOOrigem dao = new DAOOrigem();

    //verificação de preenchimento do campo NomeOrigem
    public boolean ValidaCamposOrigem() {
        if (!(jtfNomeOrigem.getText().length() > 0)) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da origem!");
            jtfNomeOrigem.requestFocus();
            return false;
        }
        return true;
    }

//verificação de preenchimento do campo NomeOrigemAlterar
    public boolean validaCamposAlteracaoOrigem() {
        if (!(jtfNomeOrigemAlterar.getText().length() > 0)) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da origem!");
            jtfNomeOrigemAlterar.requestFocus();
            return false;
        }
        return true;
    }

    //método para atualizar a tabela de origens
    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtbOrigens.getModel();
        modelo.setNumRows(0);

        for (ModeloOrigem p : dao.readOrigem()) {
            modelo.addRow(new Object[]{
                p.getIdOrigem(),
                p.getNomeOrigem()
            });
        }
    }

    public ViewOrigem() {
        initComponents();
        //desativar a gui para alterar origem
        jtbpOrigem.setEnabledAt(2, false);
        //Atualizar tabela de origens
        readJTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jtbpOrigem = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPGerenciamentoOrigem = new javax.swing.JPanel();
        jbtnExcluirOrigem = new javax.swing.JButton();
        jbtnAlterarOrigem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbOrigens = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jpOrigem = new javax.swing.JPanel();
        jlblOrigem = new javax.swing.JLabel();
        jtfNomeOrigem = new javax.swing.JTextField();
        jlblAviso = new javax.swing.JLabel();
        blblAviso = new javax.swing.JLabel();
        jbtnSalvar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlblOrigem1 = new javax.swing.JLabel();
        jtfNomeOrigemAlterar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbtnSalvarAlteracao = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Origens");
        setMinimumSize(new java.awt.Dimension(448, 350));
        setPreferredSize(new java.awt.Dimension(448, 350));

        jtbpOrigem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPGerenciamentoOrigem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciamento de origens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jbtnExcluirOrigem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnExcluirOrigem.setText("Excluir");
        jbtnExcluirOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirOrigemActionPerformed(evt);
            }
        });

        jbtnAlterarOrigem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnAlterarOrigem.setText("Alterar");
        jbtnAlterarOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAlterarOrigemActionPerformed(evt);
            }
        });

        jtbOrigens.setAutoCreateRowSorter(true);
        jtbOrigens.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbOrigens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Origem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbOrigens.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(jtbOrigens);
        if (jtbOrigens.getColumnModel().getColumnCount() > 0) {
            jtbOrigens.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtbOrigens.getColumnModel().getColumn(1).setPreferredWidth(275);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgens/update.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPGerenciamentoOrigemLayout = new javax.swing.GroupLayout(jPGerenciamentoOrigem);
        jPGerenciamentoOrigem.setLayout(jPGerenciamentoOrigemLayout);
        jPGerenciamentoOrigemLayout.setHorizontalGroup(
            jPGerenciamentoOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGerenciamentoOrigemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPGerenciamentoOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPGerenciamentoOrigemLayout.createSequentialGroup()
                        .addComponent(jbtnAlterarOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addGap(141, 141, 141)
                        .addComponent(jbtnExcluirOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGerenciamentoOrigemLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPGerenciamentoOrigemLayout.setVerticalGroup(
            jPGerenciamentoOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGerenciamentoOrigemLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPGerenciamentoOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnExcluirOrigem)
                    .addComponent(jbtnAlterarOrigem))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGerenciamentoOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPGerenciamentoOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtbpOrigem.addTab("Listagem", jPanel2);

        jpOrigem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nova origem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jlblOrigem.setText("Nome:");

        jtfNomeOrigem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jlblAviso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblAviso.setForeground(new java.awt.Color(255, 0, 0));
        jlblAviso.setText("* Campo obrigatório");

        blblAviso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        blblAviso.setForeground(new java.awt.Color(255, 0, 0));
        blblAviso.setText("*");

        jbtnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSalvar.setText("Salvar");
        jbtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalvarActionPerformed(evt);
            }
        });

        jbtnLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnLimpar.setText("Limpar");
        jbtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOrigemLayout = new javax.swing.GroupLayout(jpOrigem);
        jpOrigem.setLayout(jpOrigemLayout);
        jpOrigemLayout.setHorizontalGroup(
            jpOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOrigemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOrigemLayout.createSequentialGroup()
                        .addGroup(jpOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpOrigemLayout.createSequentialGroup()
                                .addComponent(jlblOrigem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(blblAviso)
                                .addGap(14, 14, 14)
                                .addComponent(jtfNomeOrigem))
                            .addGroup(jpOrigemLayout.createSequentialGroup()
                                .addComponent(jlblAviso)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOrigemLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jbtnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(90, 90, 90)
                        .addComponent(jbtnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                        .addGap(39, 39, 39))))
        );
        jpOrigemLayout.setVerticalGroup(
            jpOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOrigemLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOrigem)
                    .addComponent(jtfNomeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blblAviso))
                .addGap(18, 18, 18)
                .addComponent(jlblAviso)
                .addGap(34, 34, 34)
                .addGroup(jpOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalvar)
                    .addComponent(jbtnLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jtbpOrigem.addTab("Adicionar", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar origem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jlblOrigem1.setText("Nome:");

        jtfNomeOrigemAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("* Campo obrigatório");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*");

        jbtnSalvarAlteracao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSalvarAlteracao.setText("Salvar");
        jbtnSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalvarAlteracaoActionPerformed(evt);
            }
        });

        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jlblOrigem1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addGap(14, 14, 14)
                                .addComponent(jtfNomeOrigemAlterar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jbtnSalvarAlteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(90, 90, 90)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(45, 45, 45))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOrigem1)
                    .addComponent(jtfNomeOrigemAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalvarAlteracao)
                    .addComponent(jbtnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jtbpOrigem.addTab("Alterar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpOrigem)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpOrigem)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed
        //Ação do botão LIMPAR

        jtfNomeOrigem.setText("");
    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jbtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarActionPerformed
//ação do botão salvar origem

        //verificação do retorno do método ValidaCamposOrigem()
        if (ValidaCamposOrigem()) {
            //Captura do texto digitado, salvo na classe ModeloOrigem
            origem.setNomeOrigem(jtfNomeOrigem.getText());
            //chamada do método para inserir no banco de dados
            dao.insereOrigem(origem);
            //Limpando o campo de texto
            jtfNomeOrigem.setText("");
            readJTable();
            jtbpOrigem.setSelectedIndex(0);
        }


    }//GEN-LAST:event_jbtnSalvarActionPerformed

    private void jbtnExcluirOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirOrigemActionPerformed
//ação do botão alterar

        //verificar se há seleção de linha
        if (jtbOrigens.getSelectedRow() != -1) {

            //confirmar a exclusão
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir esta origem?",
                    "Deletar", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                //Captura da origem selecionada e chamada do método delete
                origem.setIdOrigem(Integer.parseInt(jtbOrigens.getValueAt(jtbOrigens.getSelectedRow(), 0).toString()));
                dao.delete(origem);
                readJTable();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma origem para excluir!");
        }


    }//GEN-LAST:event_jbtnExcluirOrigemActionPerformed

    private void jbtnAlterarOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAlterarOrigemActionPerformed
//ação do botão alterar

        //verificar se há seleção de linha
        if (jtbOrigens.getSelectedRow() > -1) {

            origem.setIdOrigem((int) jtbOrigens.getValueAt(jtbOrigens.getSelectedRow(), 0));
            dao.obterOrigem(origem);

            jtfNomeOrigemAlterar.setText(origem.getNomeOrigem());

            jtbpOrigem.setEnabledAt(0, false);
            jtbpOrigem.setEnabledAt(1, false);
            jtbpOrigem.setEnabledAt(2, true);
            jtbpOrigem.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione algo para alterar!");
        }
    }//GEN-LAST:event_jbtnAlterarOrigemActionPerformed

    private void jbtnSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarAlteracaoActionPerformed

        //instanciando as classes ModeloOrigem e DAOOrigem
        //verificação do retorno do método ValidaCamposOrigem()
        if (validaCamposAlteracaoOrigem()) {

            origem.setNomeOrigem(jtfNomeOrigemAlterar.getText());
            dao.alterarOrigem(origem);
        }
        readJTable();
        jtbpOrigem.setEnabledAt(0, true);
        jtbpOrigem.setEnabledAt(1, true);
        jtbpOrigem.setEnabledAt(2, false);
        jtbpOrigem.setSelectedIndex(0);
    }//GEN-LAST:event_jbtnSalvarAlteracaoActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        //Ação do botão CANCELAR

        jtfNomeOrigemAlterar.setText("");

        readJTable();
        jtbpOrigem.setEnabledAt(0, true);
        jtbpOrigem.setEnabledAt(1, true);
        jtbpOrigem.setEnabledAt(2, false);
        jtbpOrigem.setSelectedIndex(0);

    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ação do botão atualiar
        readJTable();


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blblAviso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPGerenciamentoOrigem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnAlterarOrigem;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnExcluirOrigem;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JButton jbtnSalvarAlteracao;
    private javax.swing.JLabel jlblAviso;
    private javax.swing.JLabel jlblOrigem;
    private javax.swing.JLabel jlblOrigem1;
    private javax.swing.JPanel jpOrigem;
    private javax.swing.JTable jtbOrigens;
    private javax.swing.JTabbedPane jtbpOrigem;
    private javax.swing.JTextField jtfNomeOrigem;
    private javax.swing.JTextField jtfNomeOrigemAlterar;
    // End of variables declaration//GEN-END:variables
}
