package pacote;

import exception.ValidacaoException;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Sala sala1 = new Sala("Bloco 1 - sala 1","Homem de Ferro");
        Sala sala2 = new Sala("Bloco 1 - sala 2","Matrix");
        Sala sala3 = new Sala("Bloco 2 - sala 1","Relâmpago McQueen");
        Sala sala4 = new Sala("Bloco 2 - sala 2","Os Minions");
        Sala sala5 = new Sala("Bloco 3 - sala 1","Transformers");
        Sala sala6 = new Sala("Bloco 3 - sala 2","Velozes e furiosos");

        Sala[][] cinema =
                {
                {sala1,sala2},
                {sala3,sala4},
                {sala5,sala6}
                };

        String op = "S";
        int menu = 0;

        do{
            int fila = 0;
            int cadeira = 0;
            int bloco = 0;
            int sala = 0;
            System.out.println("=========================== TeleCine ===========================");
            Cliente cliente = null;
            System.out.printf("Login%nNome: ");
            String nome = sc.nextLine();
            while(nome == null || nome.isBlank()){
                System.out.println("Digite um nome válido: ");
                nome = sc.nextLine();
            }
            System.out.print("E-mail: ");
            String email = sc.nextLine();
            while(email == null || email.isBlank() || email.length()<15) {
                System.out.println("Digite um e-mail válido: ");
                email = sc.nextLine();
            }
            try {
                cliente = new Cliente(nome, email);
            }catch(ValidacaoException e){
                System.err.println("Err - "+e.getMessage());
            }

            System.out.println("Cadastro concluído!");
            System.out.println(percorrerBlocosDeSalas(cinema));

            System.out.print("Selecione o bloco: ");
                bloco = sc.nextInt();
                while(bloco>cinema.length || bloco<=0){
                    System.out.printf("Digite bloco válido entre 1 e %d: ",cinema.length);
                    bloco = sc.nextInt();
                }
                --bloco;
            System.out.print("Selecione a sala: ");
            sala = sc.nextInt();
            while(sala>cinema.length || sala<=0){
                System.out.printf("Digite bloco válido entre 1 e %d: ",cinema.length);
                sala = sc.nextInt();
            }
            --sala;
            if(Sala.vagaDisponivel(cinema[bloco][sala])){
                System.out.printf("Você está no %s == opções de cadeira abaixo: %n",cinema[bloco][sala].getNomeDaSala());
                System.out.println(cinema[bloco][sala].exibirCadeiras());
                System.out.printf("Selecione sua cadeira de acordo com a ref f:c -> f = fila | c = cadeira%nFila: ");
                    fila = sc.nextInt();
                    while(fila>cinema[bloco][sala].getSalaDoCinema().length || fila<=0){
                        System.out.printf("%nDigite uma fila válida de 1 a %d: ",cinema[bloco][sala].getSalaDoCinema().length);
                        fila = sc.nextInt();
                    }
                    --fila;

                System.out.print("Cadeira: ");
                    cadeira = sc.nextInt();

                while(cadeira>cinema[bloco][sala].getSalaDoCinema()[fila].length || cadeira<=0){
                    System.out.printf("Digite uma cadeira válida de 1 a %d: ",cinema[bloco][sala].getSalaDoCinema()[fila].length);
                    cadeira = sc.nextInt();
                }
                --cadeira;
                if(cinema[bloco][sala].getSalaDoCinema()[fila][cadeira] == null){
                    cinema[bloco][sala].addCliente(cliente,fila,cadeira);
                }else{
                    while(cinema[bloco][sala].getSalaDoCinema()[fila][cadeira] != null){
                        System.out.printf("esta cadeira já está ocupada por %s! verifique outra novamente...%n",cinema[bloco][sala].getSalaDoCinema()[fila][cadeira].getNome());
                        System.out.printf("Selecione sua cadeira de acordo com a ref f:c -> f = fila | c = cadeira%nFila: ");
                        fila = sc.nextInt();
                        while(fila>cinema[bloco][sala].getSalaDoCinema().length || fila<=0){
                            System.out.printf("%nDigite uma fila válida de 1 a %d: ",cinema[bloco][sala].getSalaDoCinema().length);
                            fila = sc.nextInt();
                        }
                        --fila;

                        System.out.print("Cadeira: ");
                        cadeira = sc.nextInt();
                        while(cadeira>cinema[bloco][sala].getSalaDoCinema().length || cadeira<=0){
                            System.out.printf("Digite uma cadeira válida de 1 a %d: ",cinema[bloco][sala].getSalaDoCinema()[fila].length);
                            cadeira = sc.nextInt();
                        }
                        --cadeira;
                    }
                }
                cinema[bloco][sala].addCliente(cliente,fila,cadeira);
                System.out.println("Cadeira marcada com sucesso!");
            }else{
                System.out.println("Sala sem vagas");
            }




            System.out.print("Deseja encerrar o programa? (S/N): ");
            sc.nextLine();
            op = sc.nextLine();
        }while(!op.equalsIgnoreCase("S"));

        System.out.println("Acesso as salas -> ");
        for(int i = 0; i<cinema.length ; i++){
            for(int j = 0; j<cinema[i].length ; j++){
                System.out.printf("%s <%s>:%n",cinema[i][j].getNomeDaSala(),cinema[i][j].getNomeDoFilme());
                System.out.println(cinema[i][j].exibirCadeiras());
            }
            System.out.println("");
        }

    }


    public static StringBuilder percorrerBlocosDeSalas(Sala[][] salas){
        StringBuilder salasDoCinema = new StringBuilder();
        for(int i = 0; i<salas.length ; i++){
            for(int j = 0; j<salas[i].length ; j++){
                salasDoCinema.append(String.format("| %s -- Filme: %s |",salas[i][j].getNomeDaSala(),salas[i][j].getNomeDoFilme()));
            }
            salasDoCinema.append("\n");
        }
        return salasDoCinema;
    }
}