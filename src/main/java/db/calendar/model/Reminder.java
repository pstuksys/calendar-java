package db.calendar.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String about;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private LocalDateTime date;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    public static Reminder buildUpdated(Reminder reminder,Long id) {
        return Reminder.builder()
        .id(id)
        .name(reminder.getName())
        .about(reminder.getAbout())
        .time(reminder.getTime())
        .date(reminder.getDate())
        .build();
    }
}
