public class ItensPorQuantidade {

    static int pao = 3600;
    static double torta = 4;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static boolean verificaEstoque(String item, int quantidade){
        if(item.equals("pao")){
            if(pao >= quantidade){
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
}
