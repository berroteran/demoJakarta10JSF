package org.jugnicaragua.demos.demojakarta10jsf.web;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import org.jugnicaragua.demos.demojakarta10jsf.domain.Task;
import org.jugnicaragua.demos.demojakarta10jsf.domain.TaskNotFoundException;
import org.jugnicaragua.demos.demojakarta10jsf.domain.TaskRepository;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar berroteran
 *
 */
@Named("viewTaskAction")
@ViewScoped()
public class ViewTaskDetailsAction implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(ViewTaskDetailsAction.class.getName());

    @Inject
    private TaskRepository taskRepository;

    @NotNull
    private Long taskId;

    private Task task;

    public void init() {

        LOGGER.log(Level.INFO, "get task details of id @{0}", taskId);

        task = taskRepository.findOptionalById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Task getTask() {
        return task;
    }

}
