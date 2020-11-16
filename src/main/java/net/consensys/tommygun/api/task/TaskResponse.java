package net.consensys.tommygun.api.task;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.consensys.tommygun.model.task.Task;

@Getter
@Setter
@NoArgsConstructor
public class TaskResponse {
  private String id;
  private String status;
  private String name;

  @JsonInclude(Include.NON_NULL)
  private String parentTaskID;

  @JsonInclude(Include.NON_NULL)
  private String errorMessage;

  public TaskResponse(final Task task) {
    this.id = task.getTaskID().toString();
    this.status = task.getStatus().name();
    this.name = task.getName();
    this.errorMessage = task.getErrorMessage();
    this.parentTaskID = task.getParentTaskID().map(UUID::toString).orElse(null);
  }
}