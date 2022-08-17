package steps;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import pages.PaginaCriarConta;
import pages.PaginaInicial;
import pages.PaginaPrincipalLogado;
import util.Browser;

public class LoginSteps extends Browser {
    CadastroSteps cadastroSteps = new CadastroSteps();
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
        paginaCriarConta.adicionarImagem();
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();
        paginaInicial.preencherEmail(email);
        paginaInicial.preencherSenha("1234@aA");
        paginaInicial.clicarBtnEntrar();

        Assert.assertEquals(paginaPrincipalLogado.validarNome(),nome);
        Assert.assertEquals(paginaPrincipalLogado.validarEmail(),email);
    }
}
