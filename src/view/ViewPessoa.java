package view;

import conexao.Conexao;
import dao.DAOOrigem;

import dao.DAOPessoa;
import dao.DAOProduto;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloOrigem;

import modelo.ModeloPessoa;
import modelo.ModeloProduto;

public class ViewPessoa extends javax.swing.JInternalFrame {

    private Connection connection;
    String sql;

    DAOPessoa daop = new DAOPessoa();
    ModeloPessoa pessoa = new ModeloPessoa();

    // PessoaDao dao = new PessoaDao();
    public boolean ValidaCampos() {
        if (!(jtfNomePessoa.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o nome da pessoa!");
            jtfNomePessoa.requestFocus();
            return false;
        }

        if (!(jcbxCategoriaPessoa.getSelectedIndex() >= 1)) {
            JOptionPane.showMessageDialog(null, "Informe o tipo da pessoa!");
            jcbxCategoriaPessoa.requestFocus();
            return false;
        }
        return true;
    }

    public boolean ValidaCamposALterar() {
        if (!(jtfNomePessoaAlterar.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o nome da pessoa!");
            jtfNomePessoaAlterar.requestFocus();
            return false;
        }

        if (!(jcbxCategoriaPessoaAlterar.getSelectedIndex() >= 1)) {
            JOptionPane.showMessageDialog(null, "Informe o tipo da pessoa!");
            jcbxCategoriaPessoaAlterar.requestFocus();
            return false;
        }
        return true;
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jtbPessoa.getModel();
        modelo.setNumRows(0);

        for (ModeloPessoa p : daop.readPessoa()) {

            modelo.addRow(new Object[]{
                p.getIdPessoa(),
                p.getNomePessoa(),
                p.getCategoria()

            });

        }

    }

    public ViewPessoa() {
        initComponents();
        readJTable();

       // jtfNomePessoa.setDocument(new TeclasPermitidas_Letras());

        jTPPessoa.setEnabledAt(2, false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jTPPessoa = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPGerenciamentoPessoas = new javax.swing.JPanel();
        jbtnExcluirPessoa = new javax.swing.JButton();
        jbtnAlterarPessoa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbPessoa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanelCadPessoas = new javax.swing.JPanel();
        jlblNomePessoa = new javax.swing.JLabel();
        jlblTipoPessoa = new javax.swing.JLabel();
        jtfNomePessoa = new javax.swing.JTextField();
        jcbxCategoriaPessoa = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtnSalvarPessoa = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanelCadPessoaAlterar = new javax.swing.JPanel();
        jlblNomePessoa1 = new javax.swing.JLabel();
        jlblTipoPessoa1 = new javax.swing.JLabel();
        jtfNomePessoaAlterar = new javax.swing.JTextField();
        jcbxCategoriaPessoaAlterar = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jbtnCancelar = new javax.swing.JButton();
        jbtnSalvarPessoaAlterar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pessoas");
        setMinimumSize(new java.awt.Dimension(658, 405));
        setPreferredSize(new java.awt.Dimension(658, 405));

        jPGerenciamentoPessoas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciamento de pessoas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jbtnExcluirPessoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnExcluirPessoa.setText("Excluir");
        jbtnExcluirPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirPessoaActionPerformed(evt);
            }
        });

        jbtnAlterarPessoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnAlterarPessoa.setText("Alterar");
        jbtnAlterarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAlterarPessoaActionPerformed(evt);
            }
        });

        jtbPessoa.setAutoCreateRowSorter(true);
        jtbPessoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbPessoa);
        if (jtbPessoa.getColumnModel().getColumnCount() > 0) {
            jtbPessoa.getColumnModel().getColumn(0).setPreferredWidth(7);
            jtbPessoa.getColumnModel().getColumn(1).setPreferredWidth(225);
            jtbPessoa.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgens/update.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPGerenciamentoPessoasLayout = new javax.swing.GroupLayout(jPGerenciamentoPessoas);
        jPGerenciamentoPessoas.setLayout(jPGerenciamentoPessoasLayout);
        jPGerenciamentoPessoasLayout.setHorizontalGroup(
            jPGerenciamentoPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGerenciamentoPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPGerenciamentoPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPGerenciamentoPessoasLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jbtnAlterarPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addGap(146, 146, 146)
                        .addComponent(jbtnExcluirPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGerenciamentoPessoasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPGerenciamentoPessoasLayout.setVerticalGroup(
            jPGerenciamentoPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGerenciamentoPessoasLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPGerenciamentoPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnExcluirPessoa)
                    .addComponent(jbtnAlterarPessoa))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGerenciamentoPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPGerenciamentoPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPPessoa.addTab("Listagem", jPanel2);

        jPanelCadPessoas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nova pessoa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanelCadPessoas.setPreferredSize(new java.awt.Dimension(566, 203));

        jlblNomePessoa.setText("Nome:");

        jlblTipoPessoa.setText("Tipo:");

        jtfNomePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomePessoaKeyTyped(evt);
            }
        });

        jcbxCategoriaPessoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbxCategoriaPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um tipo...", "Professor", "Funcionário Administrativo", "Funcionário Limpeza", "Aluno", "Visitante" }));
        jcbxCategoriaPessoa.setToolTipText("");
        jcbxCategoriaPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxCategoriaPessoaItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("* Campo obrigatório");

        jbtnSalvarPessoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSalvarPessoa.setText("Salvar");
        jbtnSalvarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalvarPessoaActionPerformed(evt);
            }
        });

        jbtnLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnLimpar.setText("Limpar");
        jbtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadPessoasLayout = new javax.swing.GroupLayout(jPanelCadPessoas);
        jPanelCadPessoas.setLayout(jPanelCadPessoasLayout);
        jPanelCadPessoasLayout.setHorizontalGroup(
            jPanelCadPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadPessoasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelCadPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadPessoasLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelCadPessoasLayout.createSequentialGroup()
                        .addComponent(jlblTipoPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbxCategoriaPessoa, 0, 529, Short.MAX_VALUE))
                    .addGroup(jPanelCadPessoasLayout.createSequentialGroup()
                        .addComponent(jlblNomePessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jtfNomePessoa)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadPessoasLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jbtnSalvarPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(125, 125, 125)
                .addComponent(jbtnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addGap(124, 124, 124))
        );
        jPanelCadPessoasLayout.setVerticalGroup(
            jPanelCadPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNomePessoa)
                    .addComponent(jtfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTipoPessoa)
                    .addComponent(jLabel2)
                    .addComponent(jcbxCategoriaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanelCadPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalvarPessoa)
                    .addComponent(jbtnLimpar))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelCadPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 138, Short.MAX_VALUE))
        );

        jTPPessoa.addTab("Adicionar", jPanel1);

        jPanelCadPessoaAlterar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar Pessoa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jlblNomePessoa1.setText("Nome:");

        jlblTipoPessoa1.setText("Tipo:");

        jtfNomePessoaAlterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomePessoaAlterarKeyTyped(evt);
            }
        });

        jcbxCategoriaPessoaAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbxCategoriaPessoaAlterar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um tipo...", "Professor", "Funcionario Limpeza", "Aluno", "Visitante" }));
        jcbxCategoriaPessoaAlterar.setToolTipText("");
        jcbxCategoriaPessoaAlterar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxCategoriaPessoaAlterarItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("* Campo obrigatório");

        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnSalvarPessoaAlterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSalvarPessoaAlterar.setText("Salvar");
        jbtnSalvarPessoaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalvarPessoaAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadPessoaAlterarLayout = new javax.swing.GroupLayout(jPanelCadPessoaAlterar);
        jPanelCadPessoaAlterar.setLayout(jPanelCadPessoaAlterarLayout);
        jPanelCadPessoaAlterarLayout.setHorizontalGroup(
            jPanelCadPessoaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadPessoaAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadPessoaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadPessoaAlterarLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelCadPessoaAlterarLayout.createSequentialGroup()
                        .addComponent(jlblTipoPessoa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jcbxCategoriaPessoaAlterar, 0, 529, Short.MAX_VALUE))
                    .addGroup(jPanelCadPessoaAlterarLayout.createSequentialGroup()
                        .addComponent(jlblNomePessoa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addComponent(jtfNomePessoaAlterar)))
                .addContainerGap())
            .addGroup(jPanelCadPessoaAlterarLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jbtnSalvarPessoaAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(125, 125, 125)
                .addComponent(jbtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(126, 126, 126))
        );
        jPanelCadPessoaAlterarLayout.setVerticalGroup(
            jPanelCadPessoaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadPessoaAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadPessoaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNomePessoa1)
                    .addComponent(jtfNomePessoaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadPessoaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTipoPessoa1)
                    .addComponent(jLabel10)
                    .addComponent(jcbxCategoriaPessoaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(27, 27, 27)
                .addGroup(jPanelCadPessoaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalvarPessoaAlterar)
                    .addComponent(jbtnCancelar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadPessoaAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanelCadPessoaAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(118, 118, 118))
        );

        jTPPessoa.addTab("Alterar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPessoa, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPessoa)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSalvarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarPessoaActionPerformed

        if (ValidaCampos()) {

            pessoa.setNomePessoa(jtfNomePessoa.getText());
            pessoa.setCategoria(String.valueOf(jcbxCategoriaPessoa.getSelectedItem()));

            daop.inserePessoa(pessoa);

            //Limpa todos os campos
            jtfNomePessoa.setText("");
            jcbxCategoriaPessoa.setSelectedIndex(0);

            readJTable();
            jTPPessoa.setSelectedIndex(0);

        }

    }//GEN-LAST:event_jbtnSalvarPessoaActionPerformed

    private void jtfNomePessoaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomePessoaKeyTyped

        String caracteres = "0987654321-+=)(*&¨%$#@!,;:?/|\'][}{";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNomePessoaKeyTyped

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed
        //Limpa todos os campos

        jtfNomePessoa.setText("");
        jcbxCategoriaPessoa.setSelectedIndex(0);


    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jcbxCategoriaPessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxCategoriaPessoaItemStateChanged

    }//GEN-LAST:event_jcbxCategoriaPessoaItemStateChanged

    private void jbtnExcluirPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirPessoaActionPerformed
        //ação do botão alterar

        //verificar se há seleção de linha
        if (jtbPessoa.getSelectedRow() != -1) {
            if (jtbPessoa.getSelectedRow() != -1) {

                //confirmar a exclusão
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta pessoa?",
                        "Deletar", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    //Captura da origem selecionada e chamada do método delete
                    pessoa.setIdPessoa(Integer.parseInt(jtbPessoa.getValueAt(jtbPessoa.getSelectedRow(), 0).toString()));
                    daop.delete(pessoa);
                    readJTable();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma origem para excluir!");
            }
        }

    }//GEN-LAST:event_jbtnExcluirPessoaActionPerformed

    private void jbtnAlterarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAlterarPessoaActionPerformed
        //ação do botão alterar

        //verificar se há seleção de linha
        if (jtbPessoa.getSelectedRow() > -1) {

            pessoa.setIdPessoa((int) jtbPessoa.getValueAt(jtbPessoa.getSelectedRow(), 0));
            daop.obterPessoa(pessoa);

            jtfNomePessoaAlterar.setText(pessoa.getNomePessoa());
            jcbxCategoriaPessoaAlterar.setSelectedItem(pessoa.getCategoria());

            jTPPessoa.setEnabledAt(0, false);
            jTPPessoa.setEnabledAt(1, false);
            jTPPessoa.setEnabledAt(2, true);
            jTPPessoa.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione algo para alterar!");
        }


    }//GEN-LAST:event_jbtnAlterarPessoaActionPerformed

    private void jtfNomePessoaAlterarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomePessoaAlterarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomePessoaAlterarKeyTyped

    private void jcbxCategoriaPessoaAlterarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxCategoriaPessoaAlterarItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxCategoriaPessoaAlterarItemStateChanged

    private void jbtnSalvarPessoaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarPessoaAlterarActionPerformed

        if (ValidaCamposALterar()) {

            pessoa.setNomePessoa(jtfNomePessoaAlterar.getText());
            pessoa.setCategoria(jcbxCategoriaPessoaAlterar.getSelectedItem().toString());

            daop.alteraPessoa(pessoa);

            jtfNomePessoaAlterar.setText("");
            jcbxCategoriaPessoaAlterar.setSelectedIndex(0);
        }
        readJTable();
        jTPPessoa.setEnabledAt(0, true);
        jTPPessoa.setEnabledAt(1, true);
        jTPPessoa.setEnabledAt(2, false);
        jTPPessoa.setSelectedIndex(0);


    }//GEN-LAST:event_jbtnSalvarPessoaAlterarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // Ação do botão CANCELAR

        readJTable();
        jTPPessoa.setEnabledAt(0, true);
        jTPPessoa.setEnabledAt(1, true);
        jTPPessoa.setEnabledAt(2, false);
        jTPPessoa.setSelectedIndex(0);

        jtfNomePessoaAlterar.setText("");
        jcbxCategoriaPessoaAlterar.setSelectedIndex(0);
    }//GEN-LAST:event_jbtnCancelarActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPGerenciamentoPessoas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCadPessoaAlterar;
    private javax.swing.JPanel jPanelCadPessoas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTPPessoa;
    private javax.swing.JButton jbtnAlterarPessoa;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnExcluirPessoa;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnSalvarPessoa;
    private javax.swing.JButton jbtnSalvarPessoaAlterar;
    private javax.swing.JComboBox jcbxCategoriaPessoa;
    private javax.swing.JComboBox jcbxCategoriaPessoaAlterar;
    private javax.swing.JLabel jlblNomePessoa;
    private javax.swing.JLabel jlblNomePessoa1;
    private javax.swing.JLabel jlblTipoPessoa;
    private javax.swing.JLabel jlblTipoPessoa1;
    private javax.swing.JTable jtbPessoa;
    private javax.swing.JTextField jtfNomePessoa;
    private javax.swing.JTextField jtfNomePessoaAlterar;
    // End of variables declaration//GEN-END:variables
}
