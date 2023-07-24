package pl.medos.DataAPI.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.medos.DataAPI.respository.MessageRepository;

@Component
public class Schedule {
    @Autowired
    private Logger logger;
    @Autowired
    private MessageRepository messageRepository;

    @Scheduled(cron = "1 * * * * *")
    public void doTask() {
        logger.info("Some task()");
        clearDatabase();
    }


    private void clearDatabase() {
        logger.info("clearDatabase()");
//        messageRepository.deleteAll();
    }
}
