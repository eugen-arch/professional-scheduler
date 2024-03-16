package it.master.eugen.scheduler.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SchedulerException extends Exception {

    private static final long serialVersionUID = -4917847424841619739L;

    private final String customMessage;

    public SchedulerException(final String message) {
	this.customMessage = message;
    }

}
