import java.util.Random;

public class ReposicaoFornecedor {

    static void reporItem(String item, DataProjeto horario) {
        Random random = new Random();

        if ("leite".equals(item) && ItensPorQuantidade.leite < 12) {
            int disponibidadeFornecedor = random.nextInt(40) + 10;
            ItensPorQuantidade.leite = disponibidadeFornecedor;
            System.out.println("indo buscar " + disponibidadeFornecedor + " " + item);
        }

        if ("cafe".equals(item) && ItensPorQuantidade.cafe < 12) {
            int disponibidadeFornecedor = random.nextInt(40) + 10;
            ItensPorQuantidade.cafe = disponibidadeFornecedor;
            System.out.println("Indo buscar " + disponibidadeFornecedor + " " + item);
        }
    }
}
