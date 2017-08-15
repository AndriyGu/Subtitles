package AdanaC.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by AdanaC on 14.05.2017.
 */
public class UserModel {




        private final StringProperty newUsersName;


        public UserModel() {
            this(null);
        }

        public UserModel(String newUsersName) {


            this.newUsersName = new SimpleStringProperty(newUsersName);



        }


        public String getNewUsersName() {
            return newUsersName.get();
        }

        public StringProperty newUsersNameProperty() {
            return newUsersName;
        }

        public void setNewUsersName(String newUsersName) {
            this.newUsersName.set(newUsersName);
        }





    }
