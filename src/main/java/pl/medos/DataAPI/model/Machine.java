package pl.medos.DataAPI.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.medos.DataAPI.respository.entity.MessageEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Machine {

    private Long id;
    private String name;
    private List<Messaqe> messages;

}
