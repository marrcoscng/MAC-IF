package pacote;

public class Sala {

    private static int fila = 3;
    private static int cadeiras = 4;

    private String nomeDaSala;
    private String nomeDoFilme;
    private Cliente[][] salaDoCinema;

    public Sala(String nomeDaSala, String nomeDoFilme){
        this.nomeDaSala = nomeDaSala;
        this.nomeDoFilme = nomeDoFilme;
        salaDoCinema  = new Cliente[fila][cadeiras];
    }

    public String getNomeDaSala(){
        return nomeDaSala;
    }
    public String getNomeDoFilme(){
        return nomeDoFilme;
    }

    public Cliente[][] getSalaDoCinema(){
        return salaDoCinema;
    }

    public void addCliente(Cliente cliente, int fila, int cadeira){
        salaDoCinema[fila][cadeira] = cliente;
    }


    public StringBuilder exibirCadeiras(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<fila ; i++){
            for(int j = 0; j<cadeiras ; j++){
                String representacaoDaCadeira = (salaDoCinema[i][j] == null)?String.format
                        ("| Cadeira Vazia - Ref : %d-%d |",i+1,j+1):String.format("| Cadeira Ocupada por %s - Ref : %d-%d |",salaDoCinema[i][j].getNome(),i+1,j+1);
                stringBuilder.append(representacaoDaCadeira);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    public static boolean vagaDisponivel(Sala sala){
        int totalDeVagas = 0;
        for(int i = 0; i<sala.getSalaDoCinema().length ; i++){
            for(int j = 0; j<sala.getSalaDoCinema()[i].length ; j++){
                if(sala.getSalaDoCinema()[i][j] == null){
                    totalDeVagas++;
                }
            }
        }
        if(totalDeVagas>0){
            return true;
        }else{
            return false;
        }
    }

}
