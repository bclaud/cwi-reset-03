public class ReposicaoCozinha {

    static void reporItem(String item, DataProjeto horario) {

        if(horario.getDiaUtil() && horario.getHora() < 16 && horario.getMinuto() < 40){
            if ("pao".equals(item) && ItensPorQuantidade.pao < 600) {
                ItensPorQuantidade.pao = 3600;
                System.out.println("A cozinha esta repondo o " + item);
            }
            if ("torta".equals(item) && ItensPorQuantidade.torta < 1) {
                ItensPorQuantidade.torta = 4;
                System.out.println("A cozinha esta repondo a " + item);

            }
            if ("sanduiche".equals(item) && ItensPorQuantidade.sanduiche <= 1 ) {
                ItensPorQuantidade.sanduiche = 20;
                System.out.println("A cozinha esta repondo o " + item);

            }
        }else{
            System.out.println("A cozinha esta fechada");
        }
    }
}
