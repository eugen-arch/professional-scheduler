package it.master.eugen.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.master.eugen.scheduler.entity.Cron;

public interface CronRepository extends JpaRepository<Cron, String> {

}
