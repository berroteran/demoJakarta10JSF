package org.jugnicaragua.demos.demojakarta10jsf;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import org.jugnicaragua.demos.demojakarta10jsf.domain.Task;
import org.jugnicaragua.demos.demojakarta10jsf.domain.TaskRepository;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author omar berroteran
 */
@Startup
@Singleton
public class Bootstrap {

    @Inject
    Logger LOG;

    @Inject
    TaskRepository taskRepository;

    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "bootstraping application...");

        Stream.of("first", "second")
                .map(s -> {
                    Task task = new Task();
                    task.setName("My " + s + " task 2023");
                    task.setDescription("La descripcion de mi " + s + " task");
                    task.setStatus(Task.Status.TODO);
                    return task;
                })
                .map(data -> taskRepository.save(data))
                .collect(Collectors.toList())
                .forEach(task -> LOG.log(Level.INFO, " task saved: {0}", new Object[]{task}));
    }
}
