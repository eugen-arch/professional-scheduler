package it.master.eugen.scheduler.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cron", schema = "db_scheduler", catalog = "db_scheduler")
public class Cron implements Serializable {

    private static final long serialVersionUID = 7078994967594911314L;

    @Id
    private String id;

    @Column(name = "cron_value")
    private String value;

    private String description;

}