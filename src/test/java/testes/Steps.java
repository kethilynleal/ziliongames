package testes;

import elementos.Elementos;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import paginas.Metodos;

import java.io.IOException;

public class Steps {

    Metodos metodos = new Metodos();
    Elementos el = new Elementos();


    @Dado("que eu acesse o site {string}")
    public void que_eu_acesse_o_site(String site) throws IOException {
        metodos.abrirNavegador(site, "Firefox", "abro_navegador");
    }

    @Quando("clico em cadastro")
    public void clico_em_cadastro() throws IOException, InterruptedException {
        metodos.pausa(1000,"espero_um_segundo");
        metodos.printScreen("01_tela_principal");
        metodos.clicar(el.getCadastro(),"clico_em_cadastro");

    }

    @Quando("insiro dados para cadastro")
    public void insiro_dados_para_cadastro() throws IOException, InterruptedException {
        metodos.pausa(1000,"espero_um_segundo");
        metodos.printScreen("02_tela_cadastro");
        metodos.escrever(el.getNome(),"Projeto teste", "insiro_o_nome");
        metodos.escrever(el.getEmail(),"beyix59701@songsign.com","insiro_o_email");
        metodos.escrever(el.getDataNascimento(),"01021991","insiro_data_de_nascimento");
        metodos.escrever(el.getCep(),"08340_010","insiro_o_cpf");
        metodos.esperarClicavel(el.getEndereco(),"espero_elemento_ficar_clicavel");
        metodos.clicar(el.getEndereco(),"clico_em_endreco");
        metodos.clicar(el.getNumeroResidencia(),"clico_para_digitar_o_numero_da_residencia");
        metodos.escrever(el.getNumeroResidencia(),"123","insiro_numero_da_residencia");
        metodos.clicar(el.getBairro(),"clico_em_bairro");
        metodos.clicar(el.getCidade(),"clico_en_cidade");
        metodos.clicar(el.getEstado(),"clico_em_estado");
        metodos.esperarClicavel(el.getCpf(),"espero_elemento_ficar_clicavel");
        metodos.escrever(el.getCpf(),"337_371_813_90","insiro_o_cpf");
        metodos.escrever(el.getTelefone(),"11_95364_2146","insiro_numero_de_telefone_com_ddd");
        metodos.escrever(el.getSenha(),"Mudar@321","insiro_a_senha");
        metodos.escrever(el.getConfirmarSenha(),"Mudar@321","confirmo_a_senha");
        metodos.esperarClicavel(el.getCadastrar(),"espero_elemento_ficar_clicavel");
        metodos.clicar(el.getCadastrar(),"confirmo_o_cadastro");
        metodos.esperarClicavel(el.getValidarTextoCadastro(),"espero_elemento_ficar_clicavel");
        metodos.validarTexto(el.getValidarTextoCadastro(),"Área do cliente");
        metodos.printScreen("03_cadastro_feito_com_sucesso");

    }

    @Quando("clico em login")
    public void clico_em_login() throws IOException, InterruptedException {
        metodos.clicar(el.getLogin(),"clico_em_login");

    }

    @Quando("dados para login")
    public void dados_para_login() throws IOException, InterruptedException {
        metodos.clicar(el.getLogin(),"clico_em_login");
        metodos.pausa(1000,"espero_um_segundos");
        metodos.printScreen("04_tela_de_login");
        metodos.escrever(el.getEmailLogin(),"beyix59701@songsign.com","insiro_email_de_login");
        metodos.esperarClicavel(el.getSenhaLogin(),"espero_elemento_ficar_clicavel");
        metodos.escrever(el.getSenhaLogin(),"Mudar321","insiro_senha_de_login");
        metodos.clicar(el.getEntrar(),"clico_em_entrar");
        metodos.esperarClicavel(el.getValidarLogin(),"espero_elemento_ficar_clicavel");
        metodos.validarTexto(el.getValidarLogin(),"Sair");
        metodos.pausa(1000,"espero_um_segundos");
        metodos.printScreen("05_login_feito_com_sucesso");
        metodos.clicar(el.getSair(),"clico_em_sair");

    }

    @Entao("finalizo o teste")
    public void finalizo_o_teste() throws IOException, InterruptedException {
        metodos.fecharNavegador("fecho_o_site");

    }
}
