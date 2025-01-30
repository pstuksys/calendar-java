package db.calendar.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import db.calendar.model.Holidays;
import reactor.core.publisher.Mono;

@Service
public class ApiService {
    
    @Autowired
    private WebClient.Builder webClient;

      public Mono<Holidays[]> fetchHolidaysData(String url){
       return webClient.baseUrl(url).build().get()
        .retrieve()
        .bodyToMono(Holidays[].class)
        .timeout(Duration.ofSeconds(5))
        .onErrorResume(throwable -> {
            System.err.println("Error fetching data: " + throwable.getMessage());
            return Mono.empty();
        });
    }

    public <T> Mono<T> fetchData(String url, Class<T> response){
        return webClient.baseUrl(url).build().get()
         .retrieve()
         .bodyToMono(response)
         .timeout(Duration.ofSeconds(5))
         .onErrorResume(throwable -> {
             System.err.println("Error fetching data: " + throwable.getMessage());
             return Mono.empty();
         });
     }
}
