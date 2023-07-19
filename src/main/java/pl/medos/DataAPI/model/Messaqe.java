package pl.medos.DataAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Messaqe {

    private Long id;
    private String device;
    private int cycle;
    private LocalDateTime event;

}
