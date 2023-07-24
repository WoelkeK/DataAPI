package pl.medos.DataAPI.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.medos.DataAPI.respository.entity.MachineEntity;

public interface MachineRepository extends JpaRepository<MachineEntity, Long> {
}
