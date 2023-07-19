package pl.medos.DataAPI.service;

import pl.medos.DataAPI.exception.MessageException;
import pl.medos.DataAPI.model.Messaqe;

import java.util.List;

public interface MessageService {

    Messaqe create(Messaqe messaqe);

    Messaqe read(Long id) throws MessageException;

    Messaqe update(Messaqe messaqe);
    Messaqe delete(Long id) throws MessageException;

    List<Messaqe> list();

}
