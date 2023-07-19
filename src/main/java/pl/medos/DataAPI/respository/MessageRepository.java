package pl.medos.DataAPI.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.medos.DataAPI.respository.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
