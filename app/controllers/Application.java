package controllers;

import controllers.Forms;
import controllers.routes;
import play.*;
import play.mvc.*;
import views.html.*;
import play.data.Form;
import models.*;

public class Application extends Controller {

    static Form<Forms.TaskForm> taskForm = Form.form(Forms.TaskForm.class);

    static Form<Forms.SearchForm> searchForm = Form.form(Forms.SearchForm.class);

    public Result index() {
        return ok(index.render(Task.all(),taskForm));
    }

    public Result addTask() {
	Form<Forms.TaskForm>filledForm = taskForm.bindFromRequest();
        Task.create(filledForm.get());

	return redirect(routes.Application.index());
    }

    public Result searchJson() {
    
    	return TODO;
    }
}