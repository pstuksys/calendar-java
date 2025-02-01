package db.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.calendar.model.Reminder;
import db.calendar.repository.ReminderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ReminderService {
    
    @Autowired
    private final ReminderRepository repository;

    public ReminderService(ReminderRepository repository){
        this.repository = repository;
    }

    public List<Reminder> findAllReminders(){
       return repository.findAll();
    }
   
    
    @Transactional
    public Reminder createReminder(Reminder reminder){
       return repository.save(reminder);
    }

    @Transactional
    public Reminder updateReminder(Reminder reminder, Long id){
        repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Reminder not found"));

        Reminder updatedReminder = Reminder.buildUpdated(reminder, id);
       return repository.save(updatedReminder);
    }

    @Transactional
    public void hardDeleteReminder(Long id) {
        repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Reminder not found"));
       
        repository.deleteById(id);
    }

    @Transactional
    public void softDeleteReminder(Long id) {
        repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Reminder not found"));
       
        repository.customDeleteById(id);
    }

    public Reminder getReminderById(Long id) {
        return repository.customFindById(id)
            .orElseThrow(() -> new EntityNotFoundException("Reminder not found"));
    }
}
