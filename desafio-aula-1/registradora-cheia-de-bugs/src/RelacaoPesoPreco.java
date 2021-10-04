public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            return precoTotal = 12.75 * (qtd * 60 / 1000);
        }

        if ("torta".equals(item)) {
            return precoTotal = 96.00 * (qtd / 16);
        }

        if ("leite".equals(item)) {
            return precoTotal = 4.48 * qtd;
        }

        if ("café".equals(item)) {
            return precoTotal = 9.56 * qtd;
        }

        if ("sanduiche".equals(item)) {
            return precoTotal = 4.5 * qtd;
        }

        return precoTotal;
    }
}
