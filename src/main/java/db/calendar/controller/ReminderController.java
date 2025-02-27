package db.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import db.calendar.model.Reminder;
import db.calendar.reusable.ApiResponse;
import db.calendar.service.ReminderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private ReminderService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Reminder>>> getAllReminders(){
        List<Reminder> response = service.findAllReminders();

        return ResponseEntity.ok().body(new ApiResponse<List<Reminder>>(true,response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Reminder>> getReminderById(@PathVariable("id") @Min(1) Long id) {
            Reminder responseBody = service.getReminderById(id);

            return ResponseEntity.ok()
                .body(new ApiResponse<Reminder>(true,responseBody));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Reminder>> createReminder(@RequestBody @Valid Reminder reminder) {
        Reminder reminder2 = service.createReminder(reminder);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ApiResponse<Reminder>(true,reminder2));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Reminder>> updateReminder(@RequestBody @Valid Reminder reminder,@PathVariable("id") @Min(1) Long id) {
        service.getReminderById(id);

        Reminder reminder2 = service.updateReminder(reminder,id);

        return ResponseEntity.status(HttpStatus.OK)
            .body(new ApiResponse<Reminder>(true,reminder2));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable("id") @Min(1) Long id) {
       try{
        service.hardDeleteReminder(id);

        return ResponseEntity.noContent().build();
       }catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().build();
       }
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<Reminder>>> getAllCurrentYearStartTodayActiveReminders(){
        List<Reminder> response = service.getAllCurrentYearStartTodayActiveReminders();

        return ResponseEntity.ok().body(new ApiResponse<List<Reminder>>(true,response));
    }
    
}
