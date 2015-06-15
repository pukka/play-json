package controllers;

import controllers.Forms;

import controllers.routes;
import play.*;
import play.mvc.*;
import views.html.*;

import play.data.Form;
import models.*;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;

public class Application extends Controller {

    static Form<Forms.TaskForm> taskForm = Form.form(Forms.TaskForm.class);

    static Form<Forms.SearchForm> searchForm = Form.form(Forms.SearchForm.class);

    public Result index() {
        return ok(index.render(Task.all(),taskForm, searchForm));
    }

    public Result addTask() {
	Form<Forms.TaskForm>filledForm = taskForm.bindFromRequest();
        Task.create(filledForm.get());

        return redirect(routes.Application.index());
    }

    public Result searchJson() {
        Form<Forms.SearchForm>filledForm = searchForm.bindFromRequest();
        JsonNode json = Task.selectlabel(filledForm.get());

        return ok(search.render(json,taskForm, searchForm));
    }


}