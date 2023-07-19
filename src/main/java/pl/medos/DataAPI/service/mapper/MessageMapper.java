package pl.medos.DataAPI.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.medos.DataAPI.model.Messaqe;
import pl.medos.DataAPI.respository.entity.MessageEntity;

import java.util.List;
import java.util.logging.Logger;

@Component
public class MessageMapper {
    private static final Logger LOGGER = Logger.getLogger(MessageMapper.class.getName());
    @Autowired
    private ModelMapper modelMapper;

    public Messaqe entityToModel(MessageEntity messageEntity) {
        LOGGER.info("entityToModel()");
        return modelMapper.map(messageEntity, Messaqe.class);
    }

    public MessageEntity modelToEntity(Messaqe messaqe) {
        LOGGER.info("modelToEntity()");
        return modelMapper.map(messaqe, MessageEntity.class);
    }

    public List<Messaqe> entitiesToModels(List<MessageEntity> messageEntities) {
        LOGGER.info("entitiesToModels()");
        return messageEntities.stream()
                .map(this::entityToModel)
                .toList();
    }

    public <R> R convertToType(Object source, Class<R> resultClass) {
        return modelMapper.map(source, resultClass);
    }
}
