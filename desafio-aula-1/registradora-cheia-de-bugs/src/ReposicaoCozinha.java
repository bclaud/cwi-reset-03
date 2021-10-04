public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("pao".equals(item) && ItensPorQuantidade.pao < 600) {
            ItensPorQuantidade.pao = 3600;
        }
        if ("torta".equals(item) && ItensPorQuantidade.torta < 1) {
            ItensPorQuantidade.torta = 4;
        }
        if ("sanduiche".equals(item) && ItensPorQuantidade.sanduiche <= 1 ) {
            ItensPorQuantidade.sanduiche = 20;
        }
    }
}
