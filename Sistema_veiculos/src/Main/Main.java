package Main;

import Veiculos.*;
import java.util.Scanner;
import Conexao.Conexao;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
    	Connection conexao = Conexao.conectar();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Criação de um Sistema CLI
        do {
            System.out.println("Escolha um veículo:");
            System.out.println("1. Carro");
            System.out.println("2. Moto");
            System.out.println("3. Bicicleta");
            System.out.println("4. Skate");
            System.out.println("5. Caminhão");
            System.out.println("0. Sair");
            System.out.print("Digite sua escolha: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer após a leitura do número

            // Criação de objetos de cada tipo de veículo antes de coletar os dados
            switch (opcao) {
                case 1:
                	
                    Carro.inserirCarro(scanner, conexao);
                    break;

                case 2:
                    Moto.inserirMoto(scanner, conexao);
                    break;

                case 3:
                	 Bicicleta.inserirBicicleta(scanner, conexao);
                    break;

                case 4:
                    Skate.inserirSkate(scanner, conexao);
                    break;

                case 5:
                  Caminhao.inserirCaminhao(scanner, conexao);
                    break;

                case 0:
                    System.out.println("Saindo... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Linha em branco para melhor visualização
        } while (opcao != 0);

        scanner.close();
    }
}
