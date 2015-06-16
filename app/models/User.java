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

    /** ログイン用 */
    public static User authenticate(String name,String password){
         return find.where().eq("name", name).eq("password", password).findUnique();
    }   
}
