package Citibanamex.consumeAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConsumeAPI {
	
	public String getJson() {
		String body = "https://www.banamex.com/localizador/jsonP/json5.json";
		HttpRequest request1 = HttpRequest.newBuilder().uri(URI.create(body)).header("Content-Type", "application/json")
				.GET().build();
		CompletableFuture<String> client = HttpClient.newHttpClient().sendAsync(request1, BodyHandlers.ofString())
				.thenApply(HttpResponse::body);
		String json = "";
		try {
			json = String.valueOf(client.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		json = json.replace("jsonCallback(", " ");
		json = json.replace(");", " ");
		return json;
	}
}
