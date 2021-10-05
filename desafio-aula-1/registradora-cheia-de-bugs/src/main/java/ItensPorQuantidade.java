public class ItensPorQuantidade {

    static int pao = 3600;
    static double torta = 4;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static boolean verificaEstoque(String item, int quantidade){
        if(item.equals("pao")){
            if(pao >= quantidade * 60){
                return true;   
            }
        }

        if(item.equals("torta")){
            if(torta >= (double) quantidade  / (double) 16){
                return true;   
            }
        }

        if(item.equals("sanduiche")){
            if(sanduiche >= quantidade){
                return true;   
            }
        }

        if(item.equals("leite")){
            if(leite >= quantidade){
                return true;   
            }
        }

        if(item.equals("cafe")){
            if(cafe >= quantidade){
                return true;   
            }
        }

        return false;
    }

    public static void consumirEstoque(String item, int qtd){
        if ("pao".equals(item)){
            pao -= ((double) qtd * 60 / 1000);
        }

        if ("torta".equals(item)) {
            torta -= ((double)qtd / (double) 16);
        }

        if ("leite".equals(item)) {
            leite -= qtd;
        }

        if ("cafe".equals(item)) {
            cafe -= qtd;
        }

        if ("sanduiche".equals(item)) {
            sanduiche -= qtd;
        }
    }

    public static int verificarQuantidade(String item){
        int quantidade = 0;
        if ("pao".equals(item)){
            quantidade = pao;
        }else if("torta".equals(item)){
            quantidade = (int) torta;
        }else if("leite".equals(item)){
            quantidade = leite;
        }else if("cafe".equals(item)){
            quantidade = cafe;
        }else if("sanduiche".equals(item)){
            quantidade = sanduiche;
        }

        return quantidade;
    }
}
