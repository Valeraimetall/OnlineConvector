import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpExchangeRateRequest {

    URI uri = URI.create("https://api.exchangerate.host/latest?base=UAH");

    public double exchangeRateRequest(User user) {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header("Accept", "application/json")
                .build();

        HttpClient client = HttpClient.newHttpClient();


        HttpResponse<String> response;

        {
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        JsonElement jsonElement = JsonParser.parseString(response.body());


        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("rates");
        double userRate = rates.get(user.getCurrency().name()).getAsDouble();


        return userRate;
    }
}


