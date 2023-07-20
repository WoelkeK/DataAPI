package pl.medos.DataAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Messaqe {

    private Long id;
    private String device;
    private int cycle;
    private LocalDateTime event = LocalDateTime.now(ZoneId.systemDefault());


}
