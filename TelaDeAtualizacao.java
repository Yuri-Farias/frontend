import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // importação da biblioteca 

public class TelaDeAtualizacao extends JFrame { // declaração de classe e abertura do bloco de codigo
    public static JLabel lblId; // 
    public static JComboBox<String> cbxId; // comboBox de id
    public static String[] ids; // string de id

    public static JLabel lblNome; // label do nome
    public static JTextField txtNome; // campo de texto do nome
    public static String nomeAtual; // string de nome atual

    public static JLabel lblEmail; // label de email
    public static JTextField txtEmail;// campo de texto de email
    public static String emailAtual; // string de email atual

    public static JLabel lblSenha; // label de senha
    public static JPasswordField txtSenha; // campo de texto da senha
    public static String senhaAtual; // string de senha atual

    public static JLabel lblNotificacoes; // label de netificação para o usuario

    public static JButton btnAtualizar; // botão de atualizar
    public static JButton btnCancelar; // botão de cancelar

    public static int tamanhoInputs = 20; // tamanho de inputs

    public TelaDeAtualizacao() //inicio de bloco de codigo da classe
    {
        super("Tela de Atualização"); // nome superior
        setLayout(new GridLayout(6,1,5,5)); // linhas colunas e espaçamento

        JPanel linha_id = new JPanel(new GridLayout(1, 2)); // painel de id

        lblId = new JLabel("Id:", SwingConstants.RIGHT); // nome "id" e posicionamento
        linha_id.add(lblId); // adiciona lblId na linha_id

        NavegadorDeRegistro.popularIds(); // metodo invoca construtor
        cbxId = new JComboBox(ids); // nova comboBox ids
        linha_id.add(cbxId); // adiciona cbxId na linha_id

        add(linha_id); //  adiciona na linha_id

        JPanel linha_nome = new JPanel(new GridLayout(1, 2)); // painel de nome

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // nome "Nome" e posicionamento
        linha_nome.add(lblNome); // adiciona a lblNome ma linha_nome

        txtNome = new JTextField(tamanhoInputs); // // tamanho do campo de texto na linha_nome
        linha_nome.add(txtNome); // adiciona txtnome na linha_nome

        add(linha_nome); // adiciona aa linha_nome

        JPanel linha_email = new JPanel(new GridLayout(1, 2)); // painel de email

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // nome "Email" e posicionamento
        linha_email.add(lblEmail); // adiciona a lblEmail na linha_email

        txtEmail = new JTextField(tamanhoInputs); // tamanho do campo de texto na linha_email
        linha_email.add(txtEmail); // adiciona txtemail na linha_email

        add(linha_email); // adiciona na linha_email

        JPanel linha_senha = new JPanel(new GridLayout(1, 2)); // painel de senha

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // nome "Senha" e posicionamento
        linha_senha.add(lblSenha); // adiciona a lblSenha na linha_senha

        txtSenha = new JPasswordField(tamanhoInputs); // tamanho do campo de texto na linha_senha
        linha_senha.add(txtSenha); // adiciona txtsenha na linha_senha

        add(linha_senha); // adiciona na linha_senha

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2)); // painel de botoes

        btnAtualizar = new JButton("Atualizar"); // nome do botão atualizar
        linha_botoes.add(btnAtualizar); // adiciona o botão a linha_botoes

        btnCancelar = new JButton("Cancelar"); // nome do botão cancelar
        linha_botoes.add(btnCancelar); // adiciona o botão  a linha_botoes

        add(linha_botoes); // adiciona a linha_botoes

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1)); // painel notificaçãoes

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // nome "notificações" e posicionamento
        linha_notificacoes.add(lblNotificacoes); // adiciona a lblnotificacoes na linha_notificacoes

        add(linha_notificacoes); // adiciona a linha_notificacoes

        btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.atualizarId();
                }
            }
        );                 // botão atualizar recebe a função de atulizar ID's

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.limparCampos();
                }
            }
        );                // botão cancelar recebe a função de cancelar ação
                          
        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        NavegadorDeRegistro.atualizarCampos(cbxId.getSelectedItem().toString());        
                    }
                } 
            }
        );               // 

        setSize(250, 300); // tamanho do frame
        ImageIcon img = new ImageIcon("./senac-logo.png"); // logo do freme 
        setIconImage(img.getImage()); // icone da imagem do frame
        setVisible(true); // freme ser visivel
        cbxId.requestFocus();
    } // fim do bloco de codigo da classe

    public static String setHtmlFormat(String strTexto) { 
        return "<html><body>" + strTexto + "</body></html>";
    }   // formato do texto de notificaçãoes

    public static void main(String[] args) {
        TelaDeAtualizacao appTelaDeAtualizacao = new TelaDeAtualizacao();
        appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }   // ação de fechar ao sair
} // fim do bloco de codigo