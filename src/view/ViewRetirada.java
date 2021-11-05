package view;

import dao.DAOEntrada;
import dao.DAOMovimentacao;
import dao.DAOPessoa;
import dao.DAOProduto;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloMovimentacao;
import modelo.ModeloOrigem;
import modelo.ModeloPessoa;
import modelo.ModeloProduto;

public class ViewRetirada extends javax.swing.JInternalFrame {

    DAOProduto daop = new DAOProduto();
    DAOPessoa daopess = new DAOPessoa();
    ModeloOrigem origem = new ModeloOrigem();
    ModeloProduto produto = new ModeloProduto();
    ModeloMovimentacao movimentacao = new ModeloMovimentacao();
    DAOMovimentacao mov = new DAOMovimentacao();

    public boolean validaCampos() {
        if (!(jcbxPessoa.getSelectedIndex() >= 1)) {
            JOptionPane.showMessageDialog(null, "Informe a pessoa!");
            jcbxPessoa.requestFocus();
            return false;
        }
        if (!(jcbxProduto.getSelectedIndex() >= 1)) {
            JOptionPane.showMessageDialog(null, "Informe o produto!");
            jcbxProduto.requestFocus();
            return false;
        }
        if (!(jtfQtdSaída.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade da saída!");
            jtfQtdSaída.requestFocus();
            return false;
        }

        if (jdcData.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data da saída!");
            jdcData.requestFocus();
            return false;
        }
        return true;
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jtbSaida.getModel();
        modelo.setNumRows(0);

        for (ModeloMovimentacao e : mov.readSaida()) {

            modelo.addRow(new Object[]{
                e.getIdMovimentacao(),
                Utilitarios.PadraoBR(e.getDataMovimentacao().toString()),
                e.getQtdMovimentacao(),
                e.getTempProduto(),
                e.getTemPessoa()

            });

        }

    }

    public ViewRetirada() {
        initComponents();
        readJTable();
        ((JTextField) jdcData.getDateEditor()).setEditable(false);

        
        for (ModeloPessoa o : daopess.readPessoa()) {
            jcbxPessoa.addItem(o);
        }

        for (ModeloProduto p : daop.readProduto()) {
            jcbxProduto.addItem(p);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jLabel5 = new javax.swing.JLabel();
        jTPEntradas = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPGerenciamentoEntrada = new javax.swing.JPanel();
        jbtnExcluirSaida = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbSaida = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbxProduto = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricaoSaida = new javax.swing.JTextArea();
        jlblFornecedor = new javax.swing.JLabel();
        jtfDestino = new javax.swing.JTextField();
        jdcData = new com.toedter.calendar.JDateChooser();
        jbtnSalvar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jcbxPessoa = new javax.swing.JComboBox();
        jtfQtdSaída = new javax.swing.JTextField();

        jLabel5.setText("jLabel5");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Saídas");
        setMinimumSize(new java.awt.Dimension(700, 472));
        setPreferredSize(new java.awt.Dimension(700, 472));

        jTPEntradas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPGerenciamentoEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciamento de saídas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jbtnExcluirSaida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnExcluirSaida.setText("Excluir");
        jbtnExcluirSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirSaidaActionPerformed(evt);
            }
        });

        jtbSaida.setAutoCreateRowSorter(true);
        jtbSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data saída", "Quantidade", "Produto", "Pessoa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtbSaida);
        if (jtbSaida.getColumnModel().getColumnCount() > 0) {
            jtbSaida.getColumnModel().getColumn(0).setPreferredWidth(7);
            jtbSaida.getColumnModel().getColumn(1).setPreferredWidth(60);
            jtbSaida.getColumnModel().getColumn(2).setPreferredWidth(40);
            jtbSaida.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtbSaida.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgens/update.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPGerenciamentoEntradaLayout = new javax.swing.GroupLayout(jPGerenciamentoEntrada);
        jPGerenciamentoEntrada.setLayout(jPGerenciamentoEntradaLayout);
        jPGerenciamentoEntradaLayout.setHorizontalGroup(
            jPGerenciamentoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGerenciamentoEntradaLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jbtnExcluirSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(217, 217, 217))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGerenciamentoEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPGerenciamentoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPGerenciamentoEntradaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPGerenciamentoEntradaLayout.setVerticalGroup(
            jPGerenciamentoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGerenciamentoEntradaLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnExcluirSaida)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGerenciamentoEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPGerenciamentoEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jTPEntradas.addTab("Listagem", jPanel3);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nova saída", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel1.setText("Produto:");

        jLabel2.setText("Quantidade:");

        jLabel3.setText("Data:");

        jcbxProduto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbxProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um produto..." }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("* Campo obrigatório");

        jLabel4.setText("Descrição:");

        jtaDescricaoSaida.setColumns(20);
        jtaDescricaoSaida.setRows(1);
        jScrollPane1.setViewportView(jtaDescricaoSaida);

        jlblFornecedor.setText("Destino:");

        jtfDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jdcData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jdcData.setMaxSelectableDate(new java.util.Date(253370779283000L));
        jdcData.setMinSelectableDate(new java.util.Date(-62135755117000L));

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

        jLabel19.setText("Nome:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");

        jcbxPessoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbxPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma pessoa..." }));

        jtfQtdSaída.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel20)
                                .addGap(28, 28, 28)
                                .addComponent(jcbxPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jcbxProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfDestino)
                                        .addGap(1, 1, 1)))))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblFornecedor)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jtfQtdSaída, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addGap(150, 150, 150)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jdcData, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1)))
                        .addGap(50, 50, 50))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel19))
                    .addComponent(jLabel20)
                    .addComponent(jcbxPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblFornecedor))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel11)
                        .addComponent(jLabel2)
                        .addComponent(jLabel10)
                        .addComponent(jtfQtdSaída, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLimpar)
                    .addComponent(jbtnSalvar))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPEntradas.addTab("Adicionar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPEntradas, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPEntradas, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed

        jcbxProduto.setSelectedIndex(0);
        jcbxProduto.setSelectedIndex(0);
        jdcData.setDate(null);
        jtfQtdSaída.setText("");
        jtfDestino.setText("");
        jtaDescricaoSaida.setText("");

    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jbtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarActionPerformed

        if (validaCampos()) {

            ModeloPessoa pessoa = new ModeloPessoa();
            pessoa = (ModeloPessoa) jcbxPessoa.getSelectedItem();
            movimentacao.setFKpessoa(pessoa.getIdPessoa());

            ModeloProduto produto = new ModeloProduto();
            produto = (ModeloProduto) jcbxProduto.getSelectedItem();
            movimentacao.setFKproduto(produto.getIdProduto());

            movimentacao.setTipoMovimentacao("Saída");

            movimentacao.setDestinoMovimentacao(jtfDestino.getText());
            movimentacao.setQtdMovimentacao(Integer.parseInt(jtfQtdSaída.getText()));

            java.util.Date RecebeData = jdcData.getDate();
            movimentacao.setDataMovimentacao(RecebeData);

            movimentacao.setDescricaoMovimentacao(jtaDescricaoSaida.getText());

            daopess.obterPessoa(pessoa);

            daop.obterProduto(produto);

            if (movimentacao.getQtdMovimentacao() < produto.getQtdEstoque()) {
                if (produto.getPatrimonio() == 0) {

                    mov.insereSaida(movimentacao);

                    jcbxProduto.setSelectedIndex(0);
                    jcbxProduto.setSelectedIndex(0);
                    jdcData.setDate(null);
                    jtfQtdSaída.setText("");
                    jtfDestino.setText("");
                    jtaDescricaoSaida.setText("");

                    readJTable();
                    jTPEntradas.setSelectedIndex(0);
                }else{
                JOptionPane.showMessageDialog(null, "Patrimônios não podem ser retirados do estoque!");
                }

            } else {
                JOptionPane.showMessageDialog(null, " Retirada insuficiente no estoque!");
            }

        }
    }//GEN-LAST:event_jbtnSalvarActionPerformed

    private void jbtnExcluirSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirSaidaActionPerformed
        //ação do botão alterar

        //verificar se há seleção de linha
        if (jtbSaida.getSelectedRow() != -1) {

            //confirmar a exclusão
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta saída?",
                    "Deletar", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                //Captura da origem selecionada e chamada do método delete
                movimentacao.setIdMovimentacao((int) jtbSaida.getValueAt(jtbSaida.getSelectedRow(), 0));
                movimentacao.setQtdMovimentacao((int) jtbSaida.getValueAt(jtbSaida.getSelectedRow(), 2));
                movimentacao.setTempProduto((String) jtbSaida.getValueAt(jtbSaida.getSelectedRow(), 3));

                DAOMovimentacao dao = new DAOMovimentacao();
                DAOEntrada daoe = new DAOEntrada();

               
                dao.obterIdProduto(movimentacao);
                dao.deleteSaida(movimentacao);

                readJTable();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma saída para excluir!");
        }

    }//GEN-LAST:event_jbtnExcluirSaidaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ação do botão atualizar
        
        readJTable();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPGerenciamentoEntrada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTPEntradas;
    private javax.swing.JButton jbtnExcluirSaida;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JComboBox jcbxPessoa;
    private javax.swing.JComboBox jcbxProduto;
    private com.toedter.calendar.JDateChooser jdcData;
    private javax.swing.JLabel jlblFornecedor;
    private javax.swing.JTextArea jtaDescricaoSaida;
    private javax.swing.JTable jtbSaida;
    private javax.swing.JTextField jtfDestino;
    private javax.swing.JTextField jtfQtdSaída;
    // End of variables declaration//GEN-END:variables
}
