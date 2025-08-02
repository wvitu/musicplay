package br.com.vitor.musicplay.service;

import br.com.vitor.musicplay.model.LastFmArtistResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaLastFm {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_KEY = "eb9ae752796cd797f8bb83d2f20fbd03";

    public String obterInformacao(String nomeArtista) {
        String url = "https://ws.audioscrobbler.com/2.0/?method=artist.getinfo"
                + "&artist=" + nomeArtista.replace(" ", "+")
                + "&api_key=" + API_KEY
                + "&lang=pt"
                + "&format=json";

        LastFmArtistResponse response = restTemplate.getForObject(url, LastFmArtistResponse.class);

        if (response != null && response.getArtist() != null) {
            var artist = response.getArtist();

            String genero = (artist.getTags() != null && artist.getTags().getTag().length > 0)
                    ? artist.getTags().getTag()[0].getName()
                    : "Gênero não encontrado";

            String resumo = artist.getBio() != null ? artist.getBio().getSummary() : "";

            return "🎤 Artista: " + artist.getName()
                    + "\n🎶 Gênero: " + genero
                    + "\n📖 Bio: " + resumo;
        } else {
            return "Artista não encontrado na base do Last.fm.";
        }
    }
}
