package br.com.querosala.app;

import java.util.Scanner;

public class App {

    Scanner leitura = new Scanner(System.in);

    public void iniciar(){

        var opcao = 0;

        do{

            switch (opcao){
                case 1:
                    cadastrarSala();
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }while(opcao == 0);


    }

    private void cadastrarSala() {

    }

    private void exibirMenu(){
        String menu = """
                Bem vindo ao QueroSala
                
                Escolha uma opção abaixo: 
                
                1- Adicionar uma sala
                
                0- sair
                
                """;

        System.out.println(menu);
    }
}
