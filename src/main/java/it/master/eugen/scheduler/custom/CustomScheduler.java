package it.master.eugen.scheduler.custom;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomScheduler {

    public void execute() {
	new Thread() {
	    @Override
	    public void run() {
		CustomScheduler.log.info("CustomScheduler - execute - Start");
		CustomScheduler.this.process();
		CustomScheduler.log.info("CustomScheduler - execute - Finish");
	    }
	}.start();
    }

    protected void process() {
	CustomScheduler.log.info("CustomScheduler - process");
    }

}
