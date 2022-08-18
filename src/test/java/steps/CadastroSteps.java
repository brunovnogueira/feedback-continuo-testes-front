package steps;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import pages.PaginaCriarConta;
import pages.PaginaInicial;
import pages.PaginaPrincipalLogado;
import util.Browser;

public class CadastroSteps extends Browser {
    PaginaInicial paginaInicial = new PaginaInicial();
    PaginaCriarConta paginaCriarConta = new PaginaCriarConta();
    PaginaPrincipalLogado paginaPrincipalLogado = new PaginaPrincipalLogado();
    Faker faker = new Faker();

    String nome = faker.name().fullName();
    String email = faker.name().firstName();
    String msgAtencaoCampos = "Necessário preencher";

    /*CADASTRO----------------------------------------------------------------------------------------*/
    @Test
    public void cadastrarComSucesso(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();
        paginaCriarConta.clicarBtnCriarConta();

        Assert.assertEquals(paginaPrincipalLogado.validarNome(),nome);
        Assert.assertEquals(paginaPrincipalLogado.validarEmail(),email+"@dbccompany.com.br");
    }

    @Test
    public void cadastrarSemImagemComSucesso(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();

        Assert.assertEquals(paginaPrincipalLogado.validarNome(),nome);
        Assert.assertEquals(paginaPrincipalLogado.validarEmail(),email+"@dbccompany.com.br");
    }

    @Test
    public void cadastrarSemNome(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherEmail(email+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();

        Assert.assertEquals(paginaCriarConta.validarMsgNome(),msgAtencaoCampos);
    }

    @Test
    public void cadastrarSemEmail(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();

        Assert.assertEquals(paginaCriarConta.validarMsgEmail(),msgAtencaoCampos);
    }

    @Test
    public void cadastrarSemSenha(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email+"@dbccompany.com.br");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();

        Assert.assertEquals(paginaCriarConta.validarMsgSenha(),msgAtencaoCampos);
    }

    @Test
    public void cadastrarSemConfirmacaoSenha(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();

        Assert.assertEquals(paginaCriarConta.validarMsgConfirmacaoSenha(),msgAtencaoCampos);
    }

    @Test
    public void cadastrarSenhasDiferentes(){
        paginaInicial.clicarBtnCriar();
        paginaCriarConta.preencherNome(nome);
        paginaCriarConta.preencherEmail(email+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@a");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.adicionarImagem();

        Assert.assertEquals(paginaCriarConta.validarMsgSenhasIguais(),"As senhas precisam ser iguais.");
    }
}
