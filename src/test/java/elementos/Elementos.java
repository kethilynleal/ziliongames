package elementos;

import org.openqa.selenium.By;

public class Elementos {

    // Elementos privados cadastro

    private By cadastro = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/a[2]");
    private By nome = By.id("nome");
    private By email = By.id("email");
    private By dataNascimento = By.id("data_nasc");
    private By cep = By.id("cep");
    private By endereco = By.id("endereco");
    private By numeroResidencia = By.id("numero");
    private By bairro = By.id("bairro");
    private By cidade = By.id("cidade");
    private By estado = By.id("estado");
    private By cpf = By.xpath("//*[@id=\"cpf\"]");
    private By telefone = By.id("telefone");
    private By senha = By.id("senha");
    private By confirmarSenha = By.id("senha2");
    private By cadastrar = By.xpath("//*[@id=\"btCadastro\"]");
    private By validarTextoCadastro = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/a[1]");

    // Elementos Login

    private By login = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/a[1]");
    private By emailLogin = By.id("email");
    private By senhaLogin = By.id("senha");
    private By entrar = By.xpath("/html/body/div[4]/div/div/div[1]/div/div[4]");
    private By validarLogin = By.xpath("/html/body/div[4]/div/div/div/div[1]/a[5]/div/span");
    private By sair = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/a[2]");

    // Elementos Publicos

    public By getCadastro() {return cadastro;}
    public By getNome() {return nome;}
    public By getEmail() {return email;}
    public By getDataNascimento() {return dataNascimento;}
    public By getCep() {return cep;}
    public By getNumeroResidencia() {return numeroResidencia;}
    public By getEndereco() {return endereco;}
    public By getBairro() {return bairro;}
    public By getCidade() {return cidade;}
    public By getEstado() {return estado;}
    public By getCpf() {return cpf;}
    public By getTelefone() {return telefone;}
    public By getSenha() {return senha;}
    public By getConfirmarSenha() {return confirmarSenha;}
    public By getCadastrar() {return cadastrar;}
    public By getValidarTextoCadastro() {return validarTextoCadastro;}
    public By getLogin() {return login;}
    public By getEmailLogin() {return emailLogin;}
    public By getSenhaLogin() {return senhaLogin;}
    public By getEntrar() {return entrar;}
    public By getValidarLogin() {return validarLogin;}
    public By getSair() {return sair;}
}

