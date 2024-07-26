package br.com.filme.screenmatch;

import br.com.filme.screenmatch.model.DadosSerie;
import br.com.filme.screenmatch.service.ConsumoApi;
import br.com.filme.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=Game%20of%20Thrones&apikey=dd4ed54d");
		System.out.println(json);
		ConverterDados conversor = new ConverterDados();
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);
	}
}
