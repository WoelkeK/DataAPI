package pl.medos.DataAPI.service;

import pl.medos.DataAPI.model.Machine;

import java.util.List;

public interface MachineService {

    Machine create(Machine machine);

    Machine read(Long id);

    Machine update(Machine machine);

    void delete(Long id);

    List<Machine> list();

}
