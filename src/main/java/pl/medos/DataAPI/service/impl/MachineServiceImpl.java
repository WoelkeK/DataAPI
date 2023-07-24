package pl.medos.DataAPI.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.medos.DataAPI.model.Machine;
import pl.medos.DataAPI.respository.MachineRepository;
import pl.medos.DataAPI.respository.entity.MachineEntity;
import pl.medos.DataAPI.service.MachineService;
import pl.medos.DataAPI.service.mapper.Mapper;

import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {
    @Autowired
    private Logger logger;
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private Mapper mapper;

    @Override
    public Machine create(Machine machine) {
        logger.info("create()");
        return mapper.convertToType(machineRepository.save(mapper.convertToType(machine, MachineEntity.class)), Machine.class);
    }

    @Override
    public Machine read(Long id) {
        logger.info("read()");
        return mapper.convertToType(machineRepository.findById(id), Machine.class);
    }

    @Override
    public Machine update(Machine machine) {
        logger.info("update()");
        return mapper.convertToType(machineRepository.save(mapper.convertToType(machine, MachineEntity.class)), Machine.class);
    }

    @Override
    public void delete(Long id) {
        logger.info("delete()");
        machineRepository.deleteById(id);
    }

    @Override
    public List<Machine> list() {
        logger.info("list()");
        List<MachineEntity> machineEntities = machineRepository.findAll();
        return machineEntities.stream()
                .map(machineEntity -> mapper.convertToType(machineEntity, Machine.class))
                .toList();
    }
}
