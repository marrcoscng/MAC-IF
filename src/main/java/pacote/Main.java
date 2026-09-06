package pacote;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        String[][] matriz = {
                            {"Disponível","Disponível","Disponível","Disponível","Disponível"},
                            {"Disponível","Disponível","Disponível","Disponível","Disponível"},
                            {"Disponível","Disponível","Disponível","Disponível","Disponível"},
                            {"Disponível","Disponível","Disponível","Disponível","Disponível"}
        };

        Scanner sc = new Scanner(System.in);
        int fila;
        int cadeira;
        String opcao = "S";



        do{
            try {
                System.out.printf("%nDigite uma coordenada para reservar sua cadeira: %n");
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        System.out.printf("| " + matriz[i][j] + " - ref: %d:%d |", i, j);
                    }
                    System.out.println("");
                }
                System.out.print("Digite aqui a numeração da fila: ");
                fila = sc.nextInt();
                sc.nextLine();

                if (fila > matriz.length || fila < -1) {
                    while (fila > matriz.length || fila <= -1) {
                        System.out.printf("Digite uma opção válida entre 0 e %d: ", matriz.length - 1);
                        fila = sc.nextInt();
                        sc.nextLine();

                    }
                }

                System.out.print("Digite aqui a numeração da cadeira: ");
                cadeira = sc.nextInt();
                sc.nextLine();

                if (cadeira > matriz.length || cadeira < -1) {
                    while (cadeira > matriz.length || cadeira <= -1) {
                        System.out.printf("Digite uma opção válida entre 0 e %d: ", matriz[fila].length - 1);
                        cadeira = sc.nextInt();
                        sc.nextLine();
                    }
                }

                if(matriz[fila][cadeira].equals("Ocupado")){
                    System.out.printf("Cadeira já ocupada, deseja fazer essa alteração mesmo assim? (S/N): ");
                    String op = sc.nextLine();
                    if(op.equalsIgnoreCase("S")){
                        System.out.println("Alteração realizada com sucesso!");
                        matriz[fila][cadeira] = "Disponível";
                    }
                }else if (matriz[fila][cadeira].equals("Disponível")) {
                    matriz[fila][cadeira] = (matriz[fila][cadeira].equals("Disponível")) ? "Ocupado" : "Disponível";
                }
            }catch(InputMismatchException e){
                System.out.println("ERRO AO INSERIR DADOS INCORRETOS! ");
            }
            System.out.print("Deseja encerrar o Programa? (S/N): ");
            opcao = sc.nextLine();



        }while(opcao.equalsIgnoreCase("N"));

        System.out.println("Sala fechada com sucesso! Segue abaixo a informação de cada cadeira: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("| " + matriz[i][j] + " - ref: %d:%d |", i, j);
            }
            System.out.println("");
        }

    }
}
