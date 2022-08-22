package steps;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import pages.*;
import util.Browser;

public class EnviarFeedbackSteps extends Browser {
    PaginaInicial paginaInicial = new PaginaInicial();
    PaginaCriarConta paginaCriarConta = new PaginaCriarConta();
    PaginaPrincipalLogado paginaPrincipalLogado = new PaginaPrincipalLogado();
    PaginaFeedback paginaFeedback = new PaginaFeedback();

    Faker faker = new Faker();

    String nomeEnviar = faker.name().fullName();
    String nomeReceber = faker.name().fullName();
    String emailEnviar = faker.name().firstName();
    String emailReceber = faker.name().firstName();

    @Test
    public void criarFeedbackComSucesso(){
        //Criar usuário que vai receber feedback
        paginaInicial.clicarBtnCriar();
        String nomeReceberVar = "";
        String emailReceberVar = emailReceber;
        if (nomeReceber.length() >= 20){
            nomeReceberVar = faker.name().firstName();
        }else {
            nomeReceberVar = nomeReceber;
        }
        paginaCriarConta.preencherNome(nomeReceberVar);
        paginaCriarConta.preencherEmail(emailReceberVar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();

        //Criar usuário que vai enviar feedback
        paginaInicial.clicarBtnCriar();
        String nomeEnviarVar = "";
        if (nomeEnviar.length() >= 20){
            nomeEnviarVar = faker.name().firstName();
        }else {
            nomeEnviarVar = nomeEnviar;
        }
        paginaCriarConta.preencherNome(nomeEnviarVar);
        paginaCriarConta.preencherEmail(emailEnviar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();

        //Enviar o feedback
        paginaPrincipalLogado.clicarEnviarFeedback();
        paginaFeedback.preencherNome(nomeReceberVar);
        paginaFeedback.clicarNomeLista();
        paginaFeedback.preencherMsg("Ótimo");
        paginaFeedback.preencherTag("Java");
        paginaFeedback.clicarTagLista();
        paginaFeedback.clicarBtnCriarFeedback();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();

        //Logar na conta de quem recebeu
        paginaInicial.preencherEmail(emailReceberVar+"@dbccompany.com.br");
        paginaInicial.preencherSenha("1234@aA");
        paginaInicial.clicarBtnEntrar();

        //Validações
        Assert.assertEquals(paginaPrincipalLogado.validarNomeFeed(),nomeEnviarVar);
        Assert.assertEquals(paginaPrincipalLogado.validarMsgFeed(),"Ótimo");
    }

    @Test
    public void criarFeedbackAnonimoComSucesso(){
        //Criar usuário que vai receber feedback
        paginaInicial.clicarBtnCriar();
        String nomeReceberVar = "";
        String emailReceberVar = emailReceber;
        if (nomeReceber.length() >= 20){
            nomeReceberVar = faker.name().firstName();
        }else {
            nomeReceberVar = nomeReceber;
        }
        paginaCriarConta.preencherNome(nomeReceberVar);
        paginaCriarConta.preencherEmail(emailReceberVar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();

        //Criar usuário que vai enviar feedback
        paginaInicial.clicarBtnCriar();
        String nomeEnviarVar = "";
        if (nomeEnviar.length() >= 20){
            nomeEnviarVar = faker.name().firstName();
        }else {
            nomeEnviarVar = nomeEnviar;
        }
        paginaCriarConta.preencherNome(nomeEnviarVar);
        paginaCriarConta.preencherEmail(emailEnviar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();

        //Enviar o feedback
        paginaPrincipalLogado.clicarEnviarFeedback();
        paginaFeedback.preencherNome(nomeReceberVar);
        paginaFeedback.clicarNomeLista();
        paginaFeedback.preencherMsg("Ótimo");
        paginaFeedback.preencherTag("Java");
        paginaFeedback.clicarTagLista();
        paginaFeedback.clicarAnonimo();
        paginaFeedback.clicarBtnCriarFeedback();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();

        //Logar na conta de quem recebeu
        paginaInicial.preencherEmail(emailReceberVar+"@dbccompany.com.br");
        paginaInicial.preencherSenha("1234@aA");
        paginaInicial.clicarBtnEntrar();

        //Validações
        Assert.assertEquals(paginaPrincipalLogado.validarNomeFeed(),"Anonimo");
        Assert.assertEquals(paginaPrincipalLogado.validarMsgFeed(),"Ótimo");
    }

    @Test
    public void criarFeedbackSemTagComSucesso(){
        //Criar usuário que vai receber feedback
        paginaInicial.clicarBtnCriar();
        String nomeReceberVar = "";
        String emailReceberVar = emailReceber;
        if (nomeReceber.length() >= 20){
            nomeReceberVar = faker.name().firstName();
        }else {
            nomeReceberVar = nomeReceber;
        }
        paginaCriarConta.preencherNome(nomeReceberVar);
        paginaCriarConta.preencherEmail(emailReceberVar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();

        //Criar usuário que vai enviar feedback
        paginaInicial.clicarBtnCriar();
        String nomeEnviarVar = "";
        if (nomeEnviar.length() >= 20){
            nomeEnviarVar = faker.name().firstName();
        }else {
            nomeEnviarVar = nomeEnviar;
        }
        paginaCriarConta.preencherNome(nomeEnviarVar);
        paginaCriarConta.preencherEmail(emailEnviar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();

        //Enviar o feedback
        paginaPrincipalLogado.clicarEnviarFeedback();
        paginaFeedback.preencherNome(nomeReceberVar);
        paginaFeedback.clicarNomeLista();
        paginaFeedback.preencherMsg("Ótimo");
        paginaFeedback.clicarBtnCriarFeedback();
        paginaPrincipalLogado.clicarUserIcon();
        paginaPrincipalLogado.clicarSair();

        //Logar na conta de quem recebeu
        paginaInicial.preencherEmail(emailReceberVar+"@dbccompany.com.br");
        paginaInicial.preencherSenha("1234@aA");
        paginaInicial.clicarBtnEntrar();

        //Validações
        Assert.assertEquals(paginaPrincipalLogado.validarNomeFeed(),nomeEnviarVar);
        Assert.assertEquals(paginaPrincipalLogado.validarMsgFeed(),"Ótimo");
    }

    @Test
    public void criarFeedbackSemDestinatario(){
        //Criar usuário que vai enviar feedback
        paginaInicial.clicarBtnCriar();
        String nomeEnviarVar = "";
        if (nomeEnviar.length() >= 20){
            nomeEnviarVar = faker.name().firstName();
        }else {
            nomeEnviarVar = nomeEnviar;
        }
        paginaCriarConta.preencherNome(nomeEnviarVar);
        paginaCriarConta.preencherEmail(emailEnviar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();

        //Enviar o feedback
        paginaPrincipalLogado.clicarEnviarFeedback();
        paginaFeedback.preencherMsg("Ótimo");

        //Validações
        Assert.assertEquals(paginaFeedback.validarMsgAtencaoNome(),"Obrigatório preencher.");
    }

    @Test
    public void criarFeedbackSemMensagem(){
        //Criar usuário que vai enviar feedback
        paginaInicial.clicarBtnCriar();
        String nomeEnviarVar = "";
        if (nomeEnviar.length() >= 20){
            nomeEnviarVar = faker.name().firstName();
        }else {
            nomeEnviarVar = nomeEnviar;
        }
        paginaCriarConta.preencherNome(nomeEnviarVar);
        paginaCriarConta.preencherEmail(emailEnviar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();

        //Enviar o feedback
        paginaPrincipalLogado.clicarEnviarFeedback();
        paginaFeedback.preencherNome("Teste");
        paginaFeedback.clicarCampoMsg();

        //Validações
        Assert.assertEquals(paginaFeedback.validarMsgAtencaoFeed(),"Obrigatório preencher.");
    }

    @Test
    public void criarFeedbackUsuarioInexistente(){
        //Criar usuário que vai enviar feedback
        paginaInicial.clicarBtnCriar();
        String nomeEnviarVar = "";
        if (nomeEnviar.length() >= 20){
            nomeEnviarVar = faker.name().firstName();
        }else {
            nomeEnviarVar = nomeEnviar;
        }
        paginaCriarConta.preencherNome(nomeEnviarVar);
        paginaCriarConta.preencherEmail(emailEnviar+"@dbccompany.com.br");
        paginaCriarConta.preencherSenha("1234@aA");
        paginaCriarConta.preencherConfirmarSenha("1234@aA");
        paginaCriarConta.selecionarCargo("ANALISTA_DE_DADOS");
        paginaCriarConta.clicarBtnCriarConta();

        //Enviar o feedback
        paginaPrincipalLogado.clicarEnviarFeedback();
        paginaFeedback.preencherNome("TESTE");
        paginaFeedback.preencherMsg("Ótimo");
        paginaFeedback.clicarBtnCriarFeedback();

        //Validações
        Assert.assertEquals(paginaFeedback.validarToastUsuarioInexistente(),"Usuário não encontrado");
    }
}
