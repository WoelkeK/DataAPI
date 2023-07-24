package pl.medos.DataAPI.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.medos.DataAPI.exception.MessageException;
import pl.medos.DataAPI.model.Messaqe;
import pl.medos.DataAPI.service.MessageService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    public Messaqe create(@RequestBody Messaqe messaqe) {
        logger.info("create()");
        return messageService.create(messaqe);
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

    @GetMapping("/search")
    @Operation(summary = "Search between dates and/or hours")
    public List<Messaqe> searchBetweenDatesHours(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endTime) {

        return messageService.searchBetweenDatesHours(startTime, endTime);
    }

    @GetMapping("/test")
    public String testResponse(){
        return "Server connection estimated. ";
    }
}
