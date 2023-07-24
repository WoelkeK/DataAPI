package pl.medos.DataAPI.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.medos.DataAPI.model.Machine;
import pl.medos.DataAPI.respository.MachineRepository;
import pl.medos.DataAPI.service.MachineService;

import java.util.List;

@RestController
@RequestMapping("/api/machine")
@Tag(name = "Machine Management")
public class MachineController {
    @Autowired
    private Logger logger;
    @Autowired
    private MachineService machineService;
    @Autowired
    private MachineRepository machineRepository;

    @PostMapping("/create")
    public Machine create(@RequestBody Machine machine) {
        logger.info("create()");
        return machineService.create(machine);
    }

    @GetMapping("/read/{id}")
    public Machine read(@PathVariable(name = "id") Long id) {
        logger.info("read()");
        return machineService.read(id);
    }

    @PutMapping("/update")
    public Machine update(Machine machine) {
        logger.info("update()");
        return machineService.update(machine);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        logger.info("delete()");
        machineService.delete(id);
    }

    @GetMapping("/list")
    public List<Machine> list() {
        logger.info("list()");
        return machineService.list();
    }
}
