package it.master.eugen.scheduler.service.impl;

import org.springframework.stereotype.Service;

import it.master.eugen.scheduler.entity.Cron;
import it.master.eugen.scheduler.exception.SchedulerException;
import it.master.eugen.scheduler.repository.CronRepository;
import it.master.eugen.scheduler.service.CronService;

@Service
public class CronServiceImpl implements CronService {

    private final CronRepository cronRepo;

    CronServiceImpl(final CronRepository cronRepo) {
	this.cronRepo = cronRepo;
    }

    @Override
    public Cron getCronValue(final String type) throws SchedulerException {

	return this.cronRepo.findById(type)
		.orElseThrow(() -> new SchedulerException("Scheduler '{}' not found"));
    }

}
