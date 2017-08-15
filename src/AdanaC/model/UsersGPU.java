package AdanaC.model;

import javafx.beans.property.*;

/**
 * Created by AdanaC on 12.05.2017.
 */
public class UsersGPU {



    private final StringProperty usersName;


    public UsersGPU() {
        this(null);
    }

    public UsersGPU(String usersName) {


        this.usersName = new SimpleStringProperty(usersName);



    }


    public String getUsersName() {
        return usersName.get();
    }

    public StringProperty usersNameProperty() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName.set(usersName);
    }





}
