import java.util.Random;

/**
 * Esta classe foi criada com o intuito de facilitar a verificação do horário de funcionamento de forma didática
 */
public class DataProjeto {

    private boolean diaUtil;
    private int hora;
    private int minuto;

    public DataProjeto(){

    }

    public void criarDataComCozinhaFuncionando() {
        Random random = new Random();
        int hora = random.nextInt(10) + 5;
        int minuto = hora == 16 ? random.nextInt(40) : random.nextInt(60);

        setDiaUtil(true);
        setHora(hora);
        setMinuto(minuto);
    }

    public void criarDataComCozinhaEncerradaMasComDiaUtil() {
        int hora = 16;
        int minuto = 60;

        setDiaUtil(true);
        setHora(hora);
        setMinuto(minuto);
    }

    public void criarDataComCozinhaEncerradaSemDiaUtil() {
        int hora = 24;
        int minuto = 60;

        setDiaUtil(false);
        setHora(hora);
        setMinuto(minuto);
    }

    public boolean cozinhaEmFuncionamento() {
        boolean isHorarioFuncionamento = hora > 6 && hora <= 16;
        boolean isMinutoFuncionamento = hora == 16 ? minuto <= 40 : minuto < 60;

        return diaUtil && isHorarioFuncionamento && isMinutoFuncionamento;
    }

    public boolean getDiaUtil(){
        return this.diaUtil;
    }

    public void setDiaUtil(boolean diaUtil){
        this.diaUtil = diaUtil;
    }

    public int getHora(){
        return this.hora;
    }

    public void setHora(int hora){
        this.hora = hora;
    }

    public int getMinuto(){
        return this.minuto;
    }

    public void setMinuto(int minuto){
        this.minuto = minuto;
    }
    
}
