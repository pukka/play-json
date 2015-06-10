package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

import play.data.Form;

import models.*;

public class Application extends Controller {
    
    static Form<Forms.TaskForm> taskForm = Form.form(Forms.TaskForm.class);

    public Result index() {
        return ok(index.render(Task.all(),taskForm));
    }

    public Result addTask() {
	Form<Forms.TaskForm>filledForm = taskForm.bindFromRequest();
        Task.create(filledForm.get());

	return redirect(routes.Application.index());
    }
}
