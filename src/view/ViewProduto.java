package view;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import dao.DAOProduto;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloProduto;

public class ViewProduto extends javax.swing.JInternalFrame {

    ModeloProduto produto = new ModeloProduto();
    DAOProduto dao = new DAOProduto();

    public boolean validaCampos() {

        if (jtfNomeProd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo PRODUTO não pode retornar vazio!");
            jtfNomeProd.requestFocus();
            return false;
        }

        if (jtfLocProd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo LOCALIZAÇÃO não pode retornar vazio!");
            jtfLocProd.requestFocus();
            return false;
        }

        if (jdcValidade.isEnabled() && jdcValidade.getDate() == null) {
            JOptionPane.showMessageDialog(null, "O campo VALIDADE não pode retornar vazio!");
            jdcValidade.requestFocus();
            return false;
        }

        return true;
    }

    public boolean validaCamposAlteracao() {

        if (jtfNomeProdAlterar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo PRODUTO não pode retornar vazio!");
            jtfNomeProdAlterar.requestFocus();
            return false;
        }

        if (jtfLocProdAlterar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo LOCALIZAÇÃO não pode retornar vazio!");
            jtfLocProdAlterar.requestFocus();
            return false;
        }

        if (jdcValidadeAlterar.isEnabled() && jdcValidadeAlterar.getDate() == null) {
            JOptionPane.showMessageDialog(null, "O campo VALIDADE não pode retornar vazio!");
            jdcValidadeAlterar.requestFocus();

            return false;
        }

        return true;
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jtbProdutos.getModel();
        modelo.setNumRows(0);
        DAOProduto pdao = new DAOProduto();

        for (ModeloProduto p : pdao.readProduto()) {

            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getNomeProduto(),
                p.getQtdEstoque(),
                p.getLocalizacaoProduto()
            });

        }

    }

    public ViewProduto() {
        initComponents();
        readJTable();

        ((JTextField) jdcValidade.getDateEditor()).setEditable(false);
        ((JTextField) jdcValidadeAlterar.getDateEditor()).setEditable(false);

        jTPPrduto.setEnabledAt(2, false);

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPPrduto = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbProdutos = new javax.swing.JTable();
        jbtnAlterarproduto = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlblNomeProd1 = new javax.swing.JLabel();
        jlblValidProd1 = new javax.swing.JLabel();
        jlblLocProd1 = new javax.swing.JLabel();
        jlblDescProd1 = new javax.swing.JLabel();
        jbtnCampoObrigatorio = new javax.swing.JLabel();
        jtfNomeProd = new javax.swing.JTextField();
        jtfLocProd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfDescProd = new javax.swing.JTextArea();
        jcbValidade = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jcbPatrimonio = new javax.swing.JCheckBox();
        jbntLimpar = new javax.swing.JButton();
        jbtnSalvarProd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jdcValidade = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jpAlterarProduto = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jtfNomeProdAlterar = new javax.swing.JTextField();
        jdcValidadeAlterar = new com.toedter.calendar.JDateChooser();
        jtfLocProdAlterar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtfDescProdAlterar = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jlblNomeProd2 = new javax.swing.JLabel();
        jlblValidProd2 = new javax.swing.JLabel();
        jlblLocProd2 = new javax.swing.JLabel();
        jlblDescProd2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jbtnCampoObrigatorio1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Produtos");
        setMinimumSize(new java.awt.Dimension(610, 443));
        setPreferredSize(new java.awt.Dimension(610, 443));

        jTPPrduto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciamento de Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jtbProdutos.setAutoCreateRowSorter(true);
        jtbProdutos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Quantidade", "Localização"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbProdutos.setFillsViewportHeight(true);
        jtbProdutos.setFocusCycleRoot(true);
        jtbProdutos.setGridColor(new java.awt.Color(102, 102, 102));
        jtbProdutos.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jtbProdutos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtbProdutos.setSurrendersFocusOnKeystroke(true);
        jtbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProdutosMouseClicked(evt);
            }
        });
        jtbProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbProdutosKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtbProdutos);
        if (jtbProdutos.getColumnModel().getColumnCount() > 0) {
            jtbProdutos.getColumnModel().getColumn(0).setPreferredWidth(25);
            jtbProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtbProdutos.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtbProdutos.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jbtnAlterarproduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnAlterarproduto.setText("Alterar");
        jbtnAlterarproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAlterarprodutoActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Excluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgens/update.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jbtnAlterarproduto, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(192, 192, 192)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAlterarproduto)
                    .addComponent(jButton4))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPPrduto.addTab("Listagem", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jlblNomeProd1.setText("Produto:");

        jlblValidProd1.setText("Validade:");

        jlblLocProd1.setText("Localização:");

        jlblDescProd1.setText("Descrição:");

        jbtnCampoObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnCampoObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jbtnCampoObrigatorio.setText("* Campo obrigatório");

        jtfDescProd.setColumns(20);
        jtfDescProd.setLineWrap(true);
        jtfDescProd.setRows(3);
        jScrollPane1.setViewportView(jtfDescProd);

        jcbValidade.setText("Sem Validade");
        jcbValidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbValidadeActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        jcbPatrimonio.setText("Patrimônio");
        jcbPatrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPatrimonioActionPerformed(evt);
            }
        });

        jbntLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbntLimpar.setText("Limpar");
        jbntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbntLimparActionPerformed(evt);
            }
        });

        jbtnSalvarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSalvarProd.setText("Salvar");
        jbtnSalvarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalvarProdActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jdcValidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlblLocProd1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlblNomeProd1)
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfLocProd)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfNomeProd)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbPatrimonio))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblDescProd1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jlblValidProd1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jdcValidade, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addGap(46, 46, 46)
                                .addComponent(jcbValidade)
                                .addGap(141, 141, 141))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnCampoObrigatorio)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jbtnSalvarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addComponent(jbntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jlblNomeProd1)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbPatrimonio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblValidProd1)
                            .addComponent(jLabel10))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbValidade)
                            .addComponent(jdcValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLocProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblLocProd1)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jlblDescProd1)))
                .addGap(18, 18, 18)
                .addComponent(jbtnCampoObrigatorio)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbntLimpar)
                    .addComponent(jbtnSalvarProd))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTPPrduto.addTab("Adicionar", jPanel4);

        jpAlterarProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        jdcValidadeAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jtfDescProdAlterar.setColumns(20);
        jtfDescProdAlterar.setLineWrap(true);
        jtfDescProdAlterar.setRows(3);
        jScrollPane3.setViewportView(jtfDescProdAlterar);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jlblNomeProd2.setText("Produto:");

        jlblValidProd2.setText("Validade:");

        jlblLocProd2.setText("Localização:");

        jlblDescProd2.setText("Descrição:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");

        jbtnCampoObrigatorio1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnCampoObrigatorio1.setForeground(new java.awt.Color(255, 0, 0));
        jbtnCampoObrigatorio1.setText("* Campo obrigatório");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAlterarProdutoLayout = new javax.swing.GroupLayout(jpAlterarProduto);
        jpAlterarProduto.setLayout(jpAlterarProdutoLayout);
        jpAlterarProdutoLayout.setHorizontalGroup(
            jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jlblValidProd2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jdcValidadeAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                            .addComponent(jlblDescProd2)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3))
                        .addComponent(jbtnCampoObrigatorio1)
                        .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                            .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                                    .addComponent(jlblLocProd2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                                    .addComponent(jlblNomeProd2)
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel13)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfNomeProdAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfLocProdAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(200, 200, 200)
                .addComponent(jbtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72))
        );
        jpAlterarProdutoLayout.setVerticalGroup(
            jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jlblNomeProd2)))
                    .addComponent(jtfNomeProdAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAlterarProdutoLayout.createSequentialGroup()
                        .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblValidProd2)
                            .addComponent(jLabel14))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAlterarProdutoLayout.createSequentialGroup()
                        .addComponent(jdcValidadeAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLocProdAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblLocProd2)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jlblDescProd2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnCampoObrigatorio1)
                .addGap(52, 52, 52)
                .addGroup(jpAlterarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbtnCancelar))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpAlterarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jpAlterarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPPrduto.addTab("Alterar", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPrduto)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTPPrduto, javax.swing.GroupLayout.PREFERRED_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 610, 443);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSalvarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarProdActionPerformed
        //ação do botão salvar -- PRODUTO

        //verificar o preenchimento dos campos
        if (validaCampos()) {
            //verificar se há validade -- caso tenha
            if (jdcValidade.isEnabled() == true) {
                produto.setNomeProduto(jtfNomeProd.getText());

                java.util.Date RecebeData = jdcValidade.getDate();
                produto.setValidadeProduto(RecebeData);

                produto.setLocalizacaoProduto(jtfLocProd.getText());

                //verificar se há descrição preenchida            
                if (jtfDescProd.getText().isEmpty()) {
                    produto.setDescricaoProduto("Nenhuma");
                } else {
                    produto.setDescricaoProduto(jtfDescProd.getText());
                }

                dao.insereProdutoValidade(produto);
                readJTable();
                jtfNomeProd.setText("");
                jtfLocProd.setText("");
                jdcValidade.setDate(null);
                jdcValidade.setEnabled(true);
                jtfDescProd.setText("");
                jcbValidade.setSelected(false);
                jcbPatrimonio.setSelected(false);

                jTPPrduto.setSelectedIndex(0);

            } else {
                if (jdcValidade.isEnabled() == false) {

                    produto.setNomeProduto(jtfNomeProd.getText());
                    //verificar se há localização preenchida
                    if (jtfLocProd.getText().isEmpty()) {
                        produto.setLocalizacaoProduto("Nenhuma");
                    } else {
                        produto.setLocalizacaoProduto(jtfLocProd.getText());
                    }
                    //verificar se há descrição preenchida
                    if (jtfDescProd.getText().isEmpty()) {
                        produto.setDescricaoProduto("Nenhuma");
                    } else {
                        produto.setDescricaoProduto(jtfDescProd.getText());
                    }
                    dao.insereProduto(produto);
                    readJTable();

                    jtfNomeProd.setText("");
                    jtfLocProd.setText("");
                    jdcValidade.setDate(null);
                    jdcValidade.setEnabled(true);
                    jtfDescProd.setText("");
                    jcbValidade.setSelected(false);
                    jcbPatrimonio.setSelected(false);

                    jTPPrduto.setSelectedIndex(0);

                }
            }

        }

    }//GEN-LAST:event_jbtnSalvarProdActionPerformed

    private void jcbValidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbValidadeActionPerformed
        //Ação do evento do CheckBox da validade

        if (jcbValidade.isSelected()) {
            jdcValidade.setEnabled(false);
            jdcValidade.setDate(null);
        } else {
            jdcValidade.setEnabled(true);
        }

    }//GEN-LAST:event_jcbValidadeActionPerformed

    private void jbntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbntLimparActionPerformed
        // apaga os dados preenchidos

        jtfNomeProd.setText("");
        jtfLocProd.setText("");
        jdcValidade.setDate(null);
        jtfDescProd.setText("");
        jcbValidade.setSelected(false);
        jdcValidade.setEnabled(true);
        jcbPatrimonio.setSelected(false);
    }//GEN-LAST:event_jbntLimparActionPerformed

    private void jtbProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbProdutosKeyReleased


    }//GEN-LAST:event_jtbProdutosKeyReleased

    private void jtbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProdutosMouseClicked

    }//GEN-LAST:event_jtbProdutosMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (jtbProdutos.getSelectedRow() != -1) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este produto?",
                    "Deletar", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                produto.setIdProduto((int) jtbProdutos.getValueAt(jtbProdutos.getSelectedRow(), 0));
                dao.delete(produto);
                readJTable();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir!");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbtnAlterarprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAlterarprodutoActionPerformed
        //ação do botão alterar

        //verificar se há seleção de linha
        if (jtbProdutos.getSelectedRow() != -1) {

            produto.setIdProduto((int) jtbProdutos.getValueAt(jtbProdutos.getSelectedRow(), 0));
            dao.obterProduto(produto);

            jtfNomeProdAlterar.setText(produto.getNomeProduto());

            jtfLocProdAlterar.setText(produto.getLocalizacaoProduto());
            jtfDescProdAlterar.setText(produto.getDescricaoProduto());

            if (produto.getValidadeProduto() == null) {

                jdcValidadeAlterar.setEnabled(false);

            } else {
                jdcValidadeAlterar.setEnabled(true);

                java.util.Date RecebeData = produto.getValidadeProduto();
                //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy")

                jdcValidadeAlterar.setDate(RecebeData);
            }

            jTPPrduto.setEnabledAt(0, false);
            jTPPrduto.setEnabledAt(1, false);
            jTPPrduto.setEnabledAt(2, true);
            jTPPrduto.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para alterar!");

        }
    }//GEN-LAST:event_jbtnAlterarprodutoActionPerformed

    private void jcbPatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPatrimonioActionPerformed
        //Ação do evento do CheckBox Patrimonio
        if (jcbPatrimonio.isSelected()) {
            produto.setPatrimonio(1);
        } else {
            produto.setPatrimonio(0);
        }
    }//GEN-LAST:event_jcbPatrimonioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //ação do botão de salvar -- ALTERAÇÕES 

        //verificar o preenchimento dos campos
        if (validaCamposAlteracao()) {
            //verificar se há validade -- caso tenha
            if (jdcValidadeAlterar.isEnabled()) {

                produto.setNomeProduto(jtfNomeProdAlterar.getText());

                java.util.Date RecebeData = jdcValidadeAlterar.getDate();
                // SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                produto.setValidadeProduto(RecebeData);
                //verificar se há localização preenchida 
                if (jtfLocProdAlterar.getText().isEmpty()) {
                    produto.setLocalizacaoProduto("Nenhuma");
                } else {
                    produto.setLocalizacaoProduto(jtfLocProdAlterar.getText());
                }
                //verificar se há descrição preenchida
                if (jtfDescProdAlterar.getText().isEmpty()) {
                    produto.setDescricaoProduto("Nenhuma");
                } else {
                    produto.setDescricaoProduto(jtfDescProdAlterar.getText());
                }

                dao.alteraProduto(produto);
                readJTable();

                jtfNomeProdAlterar.setText("");
                jtfLocProdAlterar.setText("");
                jdcValidadeAlterar.setDate(null);
                jtfDescProdAlterar.setText("");

                jTPPrduto.setEnabledAt(0, true);
                jTPPrduto.setEnabledAt(1, true);
                jTPPrduto.setEnabledAt(2, false);
                jTPPrduto.setSelectedIndex(0);

            } else {
                //verificar se há validade -- caso não tenha
                if (jdcValidadeAlterar.isEnabled() == false) {

                    produto.setNomeProduto(jtfNomeProdAlterar.getText());
                    //verificar se há localização preenchida 
                    if (jtfLocProdAlterar.getText().isEmpty()) {
                        produto.setLocalizacaoProduto("Nenhuma");
                    } else {
                        produto.setLocalizacaoProduto(jtfLocProdAlterar.getText());
                    }
                    //verificar se há descrição preenchida
                    if (jtfDescProdAlterar.getText().isEmpty()) {
                        produto.setDescricaoProduto("Nenhuma");
                    } else {
                        produto.setDescricaoProduto(jtfDescProdAlterar.getText());
                    }
                    dao.alteraProdutoSemValidade(produto);
                    readJTable();

                    jtfNomeProdAlterar.setText("");
                    jtfLocProdAlterar.setText("");
                    jdcValidadeAlterar.setDate(null);
                    jtfDescProdAlterar.setText("");

                    jTPPrduto.setEnabledAt(0, true);
                    jTPPrduto.setEnabledAt(1, true);
                    jTPPrduto.setEnabledAt(2, false);
                    jTPPrduto.setSelectedIndex(0);

                }
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        //Ação do botão cancelar

        jtfNomeProdAlterar.setText("");
        jtfLocProdAlterar.setText("");
        jdcValidadeAlterar.setDate(null);
        jtfDescProdAlterar.setText("");

        jTPPrduto.setEnabledAt(0, true);
        jTPPrduto.setEnabledAt(1, true);
        jTPPrduto.setEnabledAt(2, false);
        jTPPrduto.setSelectedIndex(0);


    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // ação do botão atualizar
        readJTable();


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTPPrduto;
    private javax.swing.JButton jbntLimpar;
    private javax.swing.JButton jbtnAlterarproduto;
    private javax.swing.JLabel jbtnCampoObrigatorio;
    private javax.swing.JLabel jbtnCampoObrigatorio1;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnSalvarProd;
    private javax.swing.JCheckBox jcbPatrimonio;
    private javax.swing.JCheckBox jcbValidade;
    private com.toedter.calendar.JDateChooser jdcValidade;
    private com.toedter.calendar.JDateChooser jdcValidadeAlterar;
    private javax.swing.JLabel jlblDescProd1;
    private javax.swing.JLabel jlblDescProd2;
    private javax.swing.JLabel jlblLocProd1;
    private javax.swing.JLabel jlblLocProd2;
    private javax.swing.JLabel jlblNomeProd1;
    private javax.swing.JLabel jlblNomeProd2;
    private javax.swing.JLabel jlblValidProd1;
    private javax.swing.JLabel jlblValidProd2;
    private javax.swing.JPanel jpAlterarProduto;
    public javax.swing.JTable jtbProdutos;
    private javax.swing.JTextArea jtfDescProd;
    private javax.swing.JTextArea jtfDescProdAlterar;
    private javax.swing.JTextField jtfLocProd;
    private javax.swing.JTextField jtfLocProdAlterar;
    private javax.swing.JTextField jtfNomeProd;
    private javax.swing.JTextField jtfNomeProdAlterar;
    // End of variables declaration//GEN-END:variables

}
