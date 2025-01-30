package db.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import db.calendar.model.Holidays;
import db.calendar.service.HolidaysService;
import reactor.core.publisher.Mono;


@RestController
// @CrossOrigin(origins = "http://localhost:3000") //alternative
public class HolidaysController {

    @Autowired
    private HolidaysService holidaysService;

    @GetMapping("/holidays")
    public Mono<ResponseEntity<Holidays[]>> getHolidays() {
        return holidaysService.getHolidays2()
                .map(holidays -> ResponseEntity.ok().body(holidays))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
