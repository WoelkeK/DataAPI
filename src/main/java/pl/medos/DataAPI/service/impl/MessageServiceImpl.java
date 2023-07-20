package pl.medos.DataAPI.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.medos.DataAPI.exception.MessageException;
import pl.medos.DataAPI.model.Messaqe;
import pl.medos.DataAPI.respository.MessageRepository;
import pl.medos.DataAPI.respository.entity.MessageEntity;
import pl.medos.DataAPI.service.MessageService;
import pl.medos.DataAPI.service.mapper.MessageMapper;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private Logger logger;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Messaqe create(Messaqe messaqe) {
        logger.info("create() " + messaqe);
        return messageMapper.entityToModel(messageRepository.save(messageMapper.modelToEntity(messaqe)));
    }

    @Override
    public Messaqe read(Long id) throws MessageException {
        logger.info("read()");
        MessageEntity messageEntity = messageRepository.findById(id).orElseThrow(
                () -> new MessageException("Brak komunikatu o podanym id"));
        return messageMapper.entityToModel(messageEntity);
    }

    @Override
    public Messaqe update(Messaqe messaqe) {
        logger.info("update()");
        return messageMapper.entityToModel(messageRepository.save(messageMapper.modelToEntity(messaqe)));
    }

    @Override
    public Messaqe delete(Long id) throws MessageException {
        logger.info("delete()");
        Optional<MessageEntity> optionalMessageEntity = messageRepository.findById(id);
        MessageEntity messageEntity = optionalMessageEntity.orElseThrow(
                () -> new MessageException(("Błąd - brak komunikatu o podanym id")));
        messageRepository.deleteById(messageEntity.getId());
        return new Messaqe();
    }

    @Override
    public List<Messaqe> list() {
        logger.info("list()");
        return messageMapper.entitiesToModels(messageRepository.findAll());
    }
}
