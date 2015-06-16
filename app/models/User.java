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
public class User extends Model {
    @Id
    public Long id;
    @Required
    public String name;
    public String password;
    public String email;
    public Boolean admin;

    public static Finder<Long,User>find = new Finder(Long.class, User.class);


    public static List<User> all() {
    	return find.all();
    }

    public static void create(Forms.newUser newUser) {
    	User user = new User();
    	user.id = newUser.id;
    	user.name = newUser.name;
    	user.password = newUser.password;
    	user.email = newUser.email;
    	user.admin = newUser.admin;
    	user.save();
    }

    public static User authenticate(String email,String password){
        return find.where().eq("email", email).eq("password", password).findUnique();
    }

    /** ユーザ名の完全一致で、レコードを返す */
    public static User checkName(String name){
        return find.where().eq("name", name).findUnique();
    }

    /** Emailの完全一致で、レコードを返す */
    public static User checkEmail(String email){
        return find.where().eq("email", email).findUnique();
    }


}
