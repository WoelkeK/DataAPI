package pl.medos.DataAPI.respository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.medos.DataAPI.respository.entity.MessageEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findByCreatedAtBetween(Date startTime, Date endTime);
}
