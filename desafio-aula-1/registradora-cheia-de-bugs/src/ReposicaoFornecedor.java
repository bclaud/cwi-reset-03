import java.util.Random;

public class ReposicaoFornecedor {

    static void reporItem(String item) {
        Random random = new Random();

        if ("leite".equals(item) && ItensPorQuantidade.leite < 12) {
            ItensPorQuantidade.leite = random.nextInt(40) + 10;
        }

        if ("cafe".equals(item) && ItensPorQuantidade.cafe < 12) {
            ItensPorQuantidade.cafe = random.nextInt(40) + 10;
        }
    }
}
