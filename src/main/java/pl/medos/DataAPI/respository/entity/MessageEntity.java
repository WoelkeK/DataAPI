package pl.medos.DataAPI.respository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.medos.DataAPI.model.Machine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MESSAGE")

public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "device")
    private String device;
    @Column(name = "cycle")
    private int cycle;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private MachineEntity machine;

}
