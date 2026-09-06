package pacote;

import exception.ValidacaoException;

public class Cliente {

    private String nome;
    private String email;



    public Cliente(String nome, String email){
        if(nome == null || nome.isBlank()){
            throw new ValidacaoException("erro com nome do usuário");
        }
        validadorEmail(email);

        this.nome = nome;
        this.email = email;

    }

    public String getNome() {
        return nome;
    }

    private static void validadorEmail(String email){
        if(email == null || email.length() < 15){
            throw new ValidacaoException("E-mail com tamanho inválido!");
        }
    }


}
