/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spyfallaplication;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author aluno
 */
public class Menu extends javax.swing.JFrame {

    private SpyFallAplication jogo;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        esperarJogadores.setVisible(false);
        jogo = new SpyFallAplication();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gameName = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        playerName = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        esperarJogadores = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(227, 73, 71));

        gameName.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        gameName.setForeground(new java.awt.Color(255, 255, 255));
        gameName.setText("SPY");

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-espião-64.png"))); // NOI18N

        nome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nome.setForeground(new java.awt.Color(255, 255, 255));
        nome.setText("Nome");

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setForeground(new java.awt.Color(227, 73, 71));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorderPainted(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        esperarJogadores.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        esperarJogadores.setForeground(new java.awt.Color(255, 255, 255));
        esperarJogadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ball-1s-31px.gif"))); // NOI18N
        esperarJogadores.setText("Esperando jogadores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(image)
                            .addComponent(gameName)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(esperarJogadores)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nome)
                                .addGap(18, 18, 18)
                                .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(gameName)
                .addGap(18, 18, 18)
                .addComponent(image)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(esperarJogadores)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
    }// </editor-fold>                        

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Runnable j = new Runnable() {
            @Override
            public void run() {
                //Verifica se o jogador preencheu o campo do nome
                if(playerName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor insira seu nome");                    
                }
                else{
                    if (!(jogo.salaCompleta())) {
                        esperarJogadores.setVisible(true);
                    }
                    else {   // verifica se a sala está cheia, se estiver, não eh possivel se cadastrar
                        JOptionPane.showMessageDialog(null, "Sala cheia");
                        return;
                    }
                    
                    // verifica se o nome já foi cadastrado
                    for(int i = 0; i < jogo.quantJogadoresOn(); i++) {
                        if(jogo.getJogador(i) != null && (playerName.getText() == null ? jogo.getJogador(i).getNome() == null : playerName.getText().equals(jogo.getJogador(i).getNome()))) {
                            JOptionPane.showMessageDialog(null, "Por favor insira um nome diferente");
                            return;
                        }
                    }
                    //Cria o jogador e adiciona no arraylist
                    String name = playerName.getText().trim();
                    Jogador jogador = new Jogador(name);
                    jogo.setJogador(jogador); 
                    Chat discussao = new Chat();
                    if(jogo.salaCompleta())
                        esperarJogadores.setVisible(false);
                }
            }
        };
        
        SwingUtilities.invokeLater(j);
    
    }                                         

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        System.exit(0);
    }                                    

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel esperarJogadores;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel gameName;
    private javax.swing.JLabel image;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nome;
    private javax.swing.JTextField playerName;
    // End of variables declaration                   
}
