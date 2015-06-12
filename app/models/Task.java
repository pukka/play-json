package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;




import play.api.mvc.*;
import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.*;

@Entity
public class Task extends Model {
    @Id
    public Long id;
    @Required
    public String label;

    public static Finder<Long,Task>find = new Finder(Long.class, Task.class);


    public static JsonNode all() {
      List<Task> tasks = find.all();
      return Json.toJson(tasks);
    }

    public static void create(Forms.TaskForm addData) {
      Task task = new Task();
      task.label = addData.label;
      task.save();
    }
    public static String selectlabel(Long id){
        Task task  = Task.find.ref(id);
        return task.label;
    }

}
