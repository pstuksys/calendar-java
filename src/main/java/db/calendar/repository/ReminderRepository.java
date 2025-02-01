package db.calendar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import db.calendar.model.Reminder;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder,Long> {
    
    @Query("SELECT r FROM Reminder r WHERE r.deletedAt IS NULL ORDER BY r.date ASC")
    List<Reminder> customFindAllReminders(); 

    @Query("SELECT r FROM Reminder r WHERE r.deletedAt IS NULL AND r.id = :id")
    Optional<Reminder> customFindById(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Reminder u WHERE u.id=:id AND u.deletedAt IS NULL")
    public Integer customDeleteById(@Param("id") Long id);
}

