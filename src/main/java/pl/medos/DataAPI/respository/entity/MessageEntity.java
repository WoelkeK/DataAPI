package pl.medos.DataAPI.respository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "MESSAGES")

public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "device")
    private String device;
    @Column(name = "cycle")
    private int cycle;
    private Date createdAt;

}
