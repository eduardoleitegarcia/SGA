package view;

import dao.DAOEntrada;
import dao.DAOOrigem;
import dao.DAOProduto;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloEntrada;
import modelo.ModeloOrigem;
import modelo.ModeloPessoa;
import modelo.ModeloProduto;

public class ViewEntrada extends javax.swing.JInternalFrame {

    DAOProduto daop = new DAOProduto();
    DAOOrigem dao = new DAOOrigem();
    ModeloOrigem origem = new ModeloOrigem();
    ModeloProduto produto = new ModeloProduto();
    ModeloEntrada entrada = new ModeloEntrada();
    DAOEntrada daoe = new DAOEntrada();

    public boolean validaCampos() {
        if (!(jcbxOrigem.getSelectedIndex() >= 1)) {
            JOptionPane.showMessageDialog(null, "Informe a origem!");
            jcbxOrigem.requestFocus();
            return false;
        }
        if (!(jcbxProduto.getSelectedIndex() >= 1)) {
            JOptionPane.showMessageDialog(null, "Informe o produto!");
            jcbxProduto.requestFocus();
            return false;
        }
        if (!(jtfQtdEntrada.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade da entrada!");
            jtfQtdEntrada.requestFocus();
            return false;
        }

        if (jdcData.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data da entrada!");
            jtfQtdEntrada.requestFocus();
            return false;
        }
        return true;
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jtbEntradas.getModel();
        modelo.setNumRows(0);

        for (ModeloEntrada e : daoe.readEntrada()) {

            modelo.addRow(new Object[]{
                e.getIdEntrada(),
                Utilitarios.PadraoBR(e.getDataEntrada().toString()),
                e.getProdutoTemp(),
                e.getQtdEntrada(),
                e.getFornecedorEntrada(),
                e.getOrigemTemp()

            });

        }

    }

    public ViewEntrada() {
        initComponents();
        readJTable();
        ((JTextField) jdcData.getDateEditor()).setEditable(false);

        for (ModeloOrigem o : dao.readOrigem()) {
            jcbxOrigem.addItem(o);
        }

        for (ModeloProduto p : daop.readProduto()) {
            jcbxProduto.addItem(p);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPEntradas = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPGerenciamentoEntrada = new javax.swing.JPanel();
        jbtnExcluirEntrada = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbEntradas = new javax.swing.JTable();
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
        jtfQtdEntrada = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jlblOrigem = new javax.swing.JLabel();
        jcbxOrigem = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricaoEntrada = new javax.swing.JTextArea();
        jlblFornecedor = new javax.swing.JLabel();
        jtfFornecedor = new javax.swing.JTextField();
        jdcData = new com.toedter.calendar.JDateChooser();
        jbtnSalvar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Entradas");
        setMinimumSize(new java.awt.Dimension(653, 488));
        setPreferredSize(new java.awt.Dimension(653, 488));

        jTPEntradas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPGerenciamentoEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciamento de entradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jbtnExcluirEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnExcluirEntrada.setText("Excluir");
        jbtnExcluirEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirEntradaActionPerformed(evt);
            }
        });

        jtbEntradas.setAutoCreateRowSorter(true);
        jtbEntradas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data Entrada", "Produto", "Quantidade", "Fornecedor", "Origem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtbEntradas);
        if (jtbEntradas.getColumnModel().getColumnCount() > 0) {
            jtbEntradas.getColumnModel().getColumn(0).setPreferredWidth(10);
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
            .addGroup(jPGerenciamentoEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPGerenciamentoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPGerenciamentoEntradaLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGerenciamentoEntradaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(12, 12, 12))))
            .addGroup(jPGerenciamentoEntradaLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jbtnExcluirEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(221, 221, 221))
        );
        jPGerenciamentoEntradaLayout.setVerticalGroup(
            jPGerenciamentoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGerenciamentoEntradaLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnExcluirEntrada)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGerenciamentoEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPGerenciamentoEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPEntradas.addTab("Listagem", jPanel3);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nova entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

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

        jtfQtdEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfQtdEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQtdEntradaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("* Campo obrigatório");

        jlblOrigem.setText("Origem:");

        jcbxOrigem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbxOrigem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma origem..." }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel4.setText("Descrição:");

        jtaDescricaoEntrada.setColumns(20);
        jtaDescricaoEntrada.setRows(1);
        jScrollPane1.setViewportView(jtaDescricaoEntrada);

        jlblFornecedor.setText("Fornecedor:");

        jtfFornecedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jtfQtdEntrada)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblOrigem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addComponent(jlblFornecedor))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jtfFornecedor))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbxProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jcbxOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(33, 33, 33))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jbtnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(154, 154, 154)
                .addComponent(jbtnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOrigem)
                    .addComponent(jcbxOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblFornecedor)
                    .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel10)
                        .addComponent(jtfQtdEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalvar)
                    .addComponent(jbtnLimpar))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
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
            .addComponent(jTPEntradas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPEntradas, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed

        jcbxProduto.setSelectedIndex(0);
        jcbxOrigem.setSelectedIndex(0);
        jdcData.setDate(null);
        jtfQtdEntrada.setText("");
        jtfFornecedor.setText("");
        jtaDescricaoEntrada.setText("");


    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jbtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarActionPerformed

        if (validaCampos()) {

            entrada.setOrigemTemp(jcbxOrigem.getSelectedItem().toString());
            entrada.setProdutoTemp(jcbxProduto.getSelectedItem().toString());

            entrada.setQtdEntrada(Integer.parseInt(jtfQtdEntrada.getText()));

            java.util.Date RecebeData = jdcData.getDate();
            entrada.setDataEntrada(RecebeData);

            // SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            if (jtaDescricaoEntrada.getText() == null) {
                entrada.setDescricaoEntrada("Nenhuma");
            } else {
                entrada.setDescricaoEntrada(jtaDescricaoEntrada.getText());
            }
            if (jtfFornecedor.getText() == null) {
                entrada.setFornecedorEntrada("Nenhum");
            } else {
                entrada.setFornecedorEntrada(jtfFornecedor.getText());
            }
            entrada.setTipoMovimentacao("Entrada");
            daoe.obteridOrigem(entrada);
            daoe.obterIdProduto(entrada);

            daoe.insereEntrada(entrada);

            jcbxProduto.setSelectedIndex(0);
            jcbxOrigem.setSelectedIndex(0);
            jdcData.setDate(null);
            jtfQtdEntrada.setText("");
            jtfFornecedor.setText("");
            jtaDescricaoEntrada.setText("");

            readJTable();
            jTPEntradas.setSelectedIndex(0);

        }


    }//GEN-LAST:event_jbtnSalvarActionPerformed

    private void jtfQtdEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQtdEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfQtdEntradaActionPerformed

    private void jbtnExcluirEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirEntradaActionPerformed
//excluir

        //verificar se há seleção de linha
        if (jtbEntradas.getSelectedRow() != -1) {

            //confirmar a exclusão
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta entrada?",
                    "Deletar", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                //Captura da origem selecionada e chamada do método delete
                entrada.setIdEntrada((int) jtbEntradas.getValueAt(jtbEntradas.getSelectedRow(), 0));
                entrada.setQtdEntrada((int) jtbEntradas.getValueAt(jtbEntradas.getSelectedRow(), 3));
                entrada.setProdutoTemp((String) jtbEntradas.getValueAt(jtbEntradas.getSelectedRow(), 2));

                DAOEntrada dao = new DAOEntrada();
                dao.obterIdProduto(entrada);
                dao.delete(entrada);
                readJTable();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma entrada para excluir!");
        }


    }//GEN-LAST:event_jbtnExcluirEntradaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //botão para atualizar a tabela
        readJTable();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPGerenciamentoEntrada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTPEntradas;
    private javax.swing.JButton jbtnExcluirEntrada;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JComboBox jcbxOrigem;
    private javax.swing.JComboBox jcbxProduto;
    private com.toedter.calendar.JDateChooser jdcData;
    private javax.swing.JLabel jlblFornecedor;
    private javax.swing.JLabel jlblOrigem;
    private javax.swing.JTextArea jtaDescricaoEntrada;
    private javax.swing.JTable jtbEntradas;
    private javax.swing.JTextField jtfFornecedor;
    private javax.swing.JTextField jtfQtdEntrada;
    // End of variables declaration//GEN-END:variables
}
