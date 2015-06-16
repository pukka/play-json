package controllers;

import java.util.List;
import akka.actor.dsl.Inbox.Get;
import models.*;
import play.data.Form;
import controllers.*;
import views.html.*;

import play.*;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import play.mvc.Http.Session;

public class Users extends Controller {
    static Form<Forms.Login> loginForm = Form.form(Forms.Login.class);
    // static Form<Forms.newUser> userForm = Form.form(Forms.newUser.class);

    /** ログイン用のメソッドです。 */
    public Result login(){
        return ok(login.render(loginForm));
    }

    /** ログイン認証 */
    public Result authenticate(){
        Form<Forms.Login> filledForm = loginForm.bindFromRequest();
        if(filledForm.hasErrors()){
	    return badRequest(login.render(filledForm));
	}
	session().clear();
	session("email", filledForm.get().email);
	return redirect(routes.Application.index());
    }
}
