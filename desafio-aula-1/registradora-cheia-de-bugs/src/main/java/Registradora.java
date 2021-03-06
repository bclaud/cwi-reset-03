
public class Registradora {

    public static void main(String[] args) {
        
        System.out.println("-----Primeiro Bug -----");
        primeiroBug();
        
        System.out.println("-----Segundo Bug -----");
        segundoBug();
        
        System.out.println("-----Terceiro Bug-----");
        terceiroBug();
        
        System.out.println("-----Quarto Bug-----");
        quartoBug();
        
        System.out.println("-----Quinto Bug-----");
        quintoBug();
        
        System.out.println("-----Sexto Bug-----");
        sextoBug();
    }

    private static double registrarItem(String item, int quantidade, DataProjeto horarioDeFuncionamento) {

        double precoItem = 0;
        
        if(ItensPorQuantidade.verificaEstoque(item, quantidade)){
            precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            ItensPorQuantidade.consumirEstoque(item, quantidade);
        }else{
            System.out.println("Sinto muito, temos apenas "+ ItensPorQuantidade.verificarQuantidade(item) + " " + item + " no momento. Ja estamos trabalhando para resolver. Por favor, volte mais tarde");
        }
        ReposicaoCozinha.reporItem(item, horarioDeFuncionamento);
        ReposicaoFornecedor.reporItem(item, horarioDeFuncionamento);

        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto dataPedido = new DataProjeto();
        dataPedido.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade, dataPedido);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto dataPedido = new DataProjeto();
        dataPedido.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade, dataPedido);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto horario = new DataProjeto();
        horario.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade,horario);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        // Cliente 1
        DataProjeto horario = new DataProjeto();
        horario.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade, horario);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        DataProjeto horario2 = new DataProjeto();
        horario2.criarDataComCozinhaFuncionando();
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2, horario2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto horario = new DataProjeto();
        horario.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade, horario);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        // Cliente 1
        DataProjeto horario = new DataProjeto();
        horario.criarDataComCozinhaEncerradaSemDiaUtil();
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade, horario);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        DataProjeto horario2 = new DataProjeto();
        horario2.criarDataComCozinhaEncerradaSemDiaUtil();
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2, horario2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }
}
