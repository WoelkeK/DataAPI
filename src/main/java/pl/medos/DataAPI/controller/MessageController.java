package pl.medos.DataAPI.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.medos.DataAPI.exception.MessageException;
import pl.medos.DataAPI.model.Messaqe;
import pl.medos.DataAPI.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/message")
@Tag(name = "Data Management")
public class MessageController {
    @Autowired
    private Logger logger;
    @Autowired
    private MessageService messageService;

    @PostMapping("/create")
    @Operation(summary = "Save new data message")
    public Messaqe create() {
        logger.info("create()");
        return messageService.create(new Messaqe());
    }

    @GetMapping("/read/{id}")
    @Operation(summary = "Find data message by id")
    public Messaqe read(@PathVariable(name = "id") Long id) throws MessageException {
        logger.info("read()");
        return messageService.read(id);
    }

    @PutMapping("/update")
    @Operation(summary = "Update data message ")
    public Messaqe update() {
        logger.info("udpate()");
        return messageService.update(new Messaqe());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete data message by id")
    public Messaqe delete(@PathVariable(name = "id") Long id) throws MessageException {
        return messageService.delete(id);
    }

    @GetMapping("/list")
    @Operation(summary = "Data list")
    public List<Messaqe> list() {
        logger.info("list()");
        return messageService.list();
    }
}
