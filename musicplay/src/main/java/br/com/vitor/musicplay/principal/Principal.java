package br.com.vitor.musicplay.principal;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MusicPlay =====");
            System.out.println("1 - Pesquisar dados do artista");
            System.out.println("2 - Buscar músicas por artista");
            System.out.println("3 - Listar músicas");
            System.out.println("4 - Cadastrar músicas");
            System.out.println("5 - Cadastrar artistas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1 -> pesquisarDadosDoArtista();
                case 2 -> buscarMusicasPorArtista();
                case 3 -> listarMusicas();
                case 4 -> cadastrarMusicas();
                case 5 -> cadastrarArtistas();
                case 0 -> System.out.println("Encerrando aplicação...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    private void pesquisarDadosDoArtista() {
    }

    private void buscarMusicasPorArtista() {
    }

    private void listarMusicas() {
    }

    private void cadastrarMusicas() {
    }

    private void cadastrarArtistas() {
    }
}