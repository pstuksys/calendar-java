package db.calendar.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import db.calendar.model.Holidays;
import reactor.core.publisher.Mono;


@Service
public class HolidaysService {
    @Value("${holidays.api.url}")
    private String apiUrl;

    private final ApiService apiService;

    public HolidaysService(ApiService apiService) {
        this.apiService = apiService;
    }

    public Mono<Holidays[]> getHolidays(){
        return apiService.fetchHolidaysData(apiUrl);
    }

    public Mono<Holidays[]> getHolidays2(){
        return apiService.fetchData(apiUrl,Holidays[].class);
    }
}
