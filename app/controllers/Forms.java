package controllers;

import play.data.Form;
import play.mvc.Controller;

import models.*;

public class Forms extends Controller {
    /** 作成用フォーム */
    public static class TaskForm{
        public String label;
    }

    /** 検索フォーム */
    public static class SearchForm {
	public Long id;
    }

    /** ログイン用フォーム */
    public static class Login {
        public String email;
        public String password;
        public String validate(){
            if (User.authenticate(email,password) == null){
                return "パスワード、またはユーザ名が有効ではありません。";
            }
            return null;
        }
    }
    /** 新規ユーザ用 */
    public static class newUser {
	    public Long id;
        public String name;
	    public String password;
        public String email;
	    public Boolean admin;

  /*    public String validate(){
            if (User.checkName(name) != null){
                return "すでに存在しています。";
            }else if(User.checkEmail(email) != null){
                return "すでに存在しています。";
            }
            return null;
        } */
    }
}


