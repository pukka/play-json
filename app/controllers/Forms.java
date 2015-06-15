package controllers;

import play.data.Form;
import play.mvc.Controller;



public class Forms extends Controller {
    public static class TaskForm{
        public String label;
    }

	public static class SearchForm {
		public Long id;
	}

    public static class DeleteForm {
        public Long deleteId;
    }
}

