package steps;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import pages.PaginaCriarConta;
import pages.PaginaInicial;
import pages.PaginaPrincipalLogado;
import util.Browser;

public class LoginSteps extends Browser {
    PaginaCriarConta paginaCriarConta = new PaginaCriarConta();
    PaginaInicial paginaInicial = new PaginaInicial();
    PaginaPrincipalLogado paginaPrincipalLogado = new PaginaPrincipalLogado();
    Faker faker = new Faker();

    String nome = faker.name().fullName();
    String email = faker.name().firstName()+"@dbccompany.com.br";

    @Test
    public void loginComSucesso(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email);
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();
        paginaInicial.preencherEmail(email);
        paginaInicial.preencherSenha("1234@aA");
        paginaInicial.clicarBtnEntrar();

        Assert.assertEquals(paginaPrincipalLogado.validarNome(),nome);
        Assert.assertEquals(paginaPrincipalLogado.validarEmail(),email);
    }
    @Test
    public void loginSemEmail(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email);
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();
        paginaInicial.preencherSenha("1234@aA");

        Assert.assertEquals(paginaInicial.validarMsgEmail(),"Obrigatório preencher!");
    }
    @Test
    public void loginSemSenha(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email);
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();
        paginaInicial.preencherEmail(email);

        Assert.assertEquals(paginaInicial.validarMsgSenha(),"obrigatorio preencher");
    }

    @Test
    public void loginSenhaErrada(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email);
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();
        paginaInicial.preencherEmail(email);
        paginaInicial.preencherSenha("1234@a");
        paginaInicial.clicarBtnEntrar();

        Assert.assertEquals(paginaInicial.validarToastErroLogin(),"Erro de login. Email ou senha invalido.");
    }

    @Test
    public void loginComEmailErrado(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email);
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();
        paginaInicial.preencherEmail("erro"+email);
        paginaInicial.preencherSenha("1234@aA");
        paginaInicial.clicarBtnEntrar();

        Assert.assertEquals(paginaInicial.validarToastErroLogin(),"Erro de login. Email ou senha invalido.");
    }
}
