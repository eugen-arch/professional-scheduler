package it.master.eugen.scheduler.config;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import it.master.eugen.scheduler.constant.Application.SchedulerName;
import it.master.eugen.scheduler.custom.CustomScheduler;
import it.master.eugen.scheduler.exception.SchedulerException;
import it.master.eugen.scheduler.service.CronService;

@Configuration
public class SchedulerConfig implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);

    private final CronService cronService;

    SchedulerConfig(final CronService cronService) {
	this.cronService = cronService;
    }

    @Bean
    TaskScheduler taskScheduler() {
	return new ThreadPoolTaskScheduler();
    }

    @Bean
    CustomScheduler customScheduler() {
	return new CustomScheduler();
    }

    @Override
    public void configureTasks(final ScheduledTaskRegistrar taskRegistrar) {

	taskRegistrar.addTriggerTask(() -> this.customScheduler().execute(),
		(final TriggerContext triggerContext) -> this
			.createNewSchedule(SchedulerName.CUSTOM_SCHEDULER_NAME));

    }

    private Instant createNewSchedule(final String nameOfScheduler) {

	try {

	    final CronTrigger trigger = new CronTrigger(
		    this.cronService.getCronValue(nameOfScheduler).getValue());

	    final TriggerContext context = new TriggerContext() {
		@Override
		public Instant lastScheduledExecution() {
		    return null;
		}

		@Override
		public Instant lastActualExecution() {
		    return null;
		}

		@Override
		public Instant lastCompletion() {
		    return null;
		}
	    };

	    final Instant nextExecutionTime = trigger.nextExecution(context);

	    SchedulerConfig.logger.info("Cron {}: {}", nameOfScheduler,
		    nextExecutionTime);

	    return trigger.nextExecution(context);

	} catch (final SchedulerException e) {
	    SchedulerConfig.logger.info(e.getCustomMessage(), nameOfScheduler);
	    return null;
	}
    }
}
