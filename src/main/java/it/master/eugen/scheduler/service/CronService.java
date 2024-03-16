package it.master.eugen.scheduler.service;

import it.master.eugen.scheduler.entity.Cron;
import it.master.eugen.scheduler.exception.SchedulerException;

public interface CronService {

    Cron getCronValue(String type) throws SchedulerException;

}
