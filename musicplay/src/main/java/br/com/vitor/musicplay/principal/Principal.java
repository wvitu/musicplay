package br.com.vitor.musicplay.principal;

import br.com.vitor.musicplay.model.Artista;
import br.com.vitor.musicplay.model.Musica;
import br.com.vitor.musicplay.model.TipoArtista;
import br.com.vitor.musicplay.repository.ArtistaRepository;
import br.com.vitor.musicplay.service.ConsultaLastFm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {

    private final ArtistaRepository repositorio;
    private final ConsultaLastFm consultaAudioDB;
    private Scanner leitura = new Scanner(System.in);


    public Principal(ArtistaRepository repositorio, ConsultaLastFm consultaAudioDB) {
        this.repositorio = repositorio;
        this.consultaAudioDB = consultaAudioDB;
    }

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
        System.out.println("Pesquisar informações sobre qual artista? ");
        String nome = leitura.nextLine();

        String resposta = consultaAudioDB.obterInformacao(nome);
        System.out.println(resposta);
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Buscar músicas de qual artista? ");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscaMusicasPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar música de qual Artista? ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()) {
            System.out.println("Informe o título da música: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado!");
        }
    }

    private void cadastrarArtistas() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome do artista: ");
            var nome = leitura.nextLine();
            System.out.println("Informe o tipo do artista: (Solo, Dupla ou Banda)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.println("Gostaria de cadastrar mais um artista? [S/N]");
            cadastrarNovo = leitura.nextLine();
        }
    }
}