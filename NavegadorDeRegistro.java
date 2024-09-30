import java.sql.*; // importa classes para manipulação de bancos de dados SQL
import java.util.*; // importação de classes da biblioteca

public class NavegadorDeRegistro extends TelaDeAtualizacao { // classe NavegadorDeRegistro que estende TelaDeAtualizacao. esta classe é responsável por usar dados de uma tabela do banco de dados
    public static void popularIds(  ) {
        try {
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id"); // adiciona opção padrão
            Connection conexao = MySQLConnector.conectar(); // conector do MySQL
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;"; // arquivos selecionados do MySQL
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds); // consulta MySQL para recuperar todos os IDs da tabela
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id")); // repete pelos resultados e adiciona os IDs à lista
            }
            ids = idsTemp.toArray(new String[0]);// converte a lista para um array
            stmSqlPopularIds.close(); // fecha o Statement
        } catch (Exception e) { // exibe mensagem de erro em caso de erro
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente.")); // mensagem de aviso quando não encontrar ID
            System.err.println("Erro: " + e); // mensagem de erro
        }
    }

    public static void atualizarId() { // atualiza  as informaçãoes de um usuario, como nome, email e senha
        try {
            String atualizarNome = "";
            String atualizarEmail = "";
            String atualizarSenha = "";

            if (txtNome.getText().trim().equals(nomeAtual) == false) {
                atualizarNome = "`nome` = '" + txtNome.getText() + "'"; // verifica se o nome foi alterado
            }

            if (txtEmail.getText().trim().equals(emailAtual) == false) {
                if (atualizarNome.length() > 0) {
                    atualizarEmail = " and "; 
                }
                atualizarEmail += "`email` = '" + txtEmail.getText() + "'";  // verifica se o email foi alterado
            }

            if (String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual) == false) {
                if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                    atualizarSenha = " and ";
                }
                atualizarSenha += "`senha` = '" + txtSenha.getPassword().toString() + "'"; // verifica se a senha foi alterada
            }

            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {  // se houver atualizações, executa a consulta de atualização
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarId = "update `db_senac`.`tbl_senac` set " + atualizarNome + atualizarEmail + atualizarSenha + " where `id` = " + cbxId.getSelectedItem().toString() + ";";
                System.out.println(strSqlAtualizarId);
                Statement stmSqlAtualizarId = conexao.createStatement();
                stmSqlAtualizarId.addBatch(strSqlAtualizarId);
                stmSqlAtualizarId.executeBatch();
                nomeAtual = txtNome.getText();  // atualiza as variáveis com os novos valores
                emailAtual = txtEmail.getText();
                senhaAtual = String.valueOf(txtSenha.getPassword());
                stmSqlAtualizarId.close();
                lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi atualizado com sucesso!"); // notifica o usuário sobre o sucesso da operação
            } else {
                lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString()); // notifica que não houve alterações
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível atualizar o id! Por favor, verifique e tente novamente.")); 
            System.err.println("Erro: " + e);  // exibe mensagem de erro em caso de falha na atualização
        }
    }

    public static void limparCampos() { // limpa os campos de entrada de dados
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        cbxId.setSelectedIndex(0); // reseta a seleção do combo box
    }

    public static void atualizarCampos(String id) { //atualiza os campos de texto com os dados do registro correspondente ao ID selecionado
        try {
            if (cbxId.getSelectedIndex() > 0) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + id + ";";
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos); // carrega os dados nos campos se o registro for encontrado
                if (rstSqlAtualizarCampos.next()) {
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                    nomeAtual = txtNome.getText();
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                    emailAtual = txtEmail.getText();
                    txtSenha.setText(rstSqlAtualizarCampos.getString("senha"));
                    senhaAtual = String.valueOf(txtSenha.getPassword());
                    lblNotificacoes.setText("Campos atualizados com sucesso!"); // mensagem de sucesso com a atualização de ID
                } else {
                    lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente."); // mensagem de aviso caso nao encontre o ID selecionado
                }
                stmSqlAtualizarCampos.close();
            } else {
                lblNotificacoes.setText("Selecione um id para continuar.");
                limparCampos(); // solicita a seleção de um id válido
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente.")); // mensagem de erro em caso de falha na busca de dados
            System.err.println("Erro: " + e);
        }
    }
}