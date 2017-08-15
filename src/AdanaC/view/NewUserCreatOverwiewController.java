
package AdanaC.view;

/**
 * Created by AdanaC on 14.05.2017.
 */


import AdanaC.*;
import AdanaC.model.UsersGPU;
import AdanaC.model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class NewUserCreatOverwiewController {


    @FXML
    private Button CanselButton;
    @FXML
    private Button createNewUserButton;
    @FXML
    private Label userNameLabel;
    @FXML
    private TextField userInputName;


    @FXML
    private void createNewUserMetod() {

        byte idintif;
        String errorMessage = "";
        String userImputName = userInputName.getText();

        if (userImputName == null || userImputName.length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        userNameLabel.setText(errorMessage);

        idintif=UserChoos.newUserCreatedMetod(userImputName);

        if (idintif ==0){ userNameLabel.setText("UserWords named "+userImputName+" created");
            ObservableList<UserWords> e = FXCollections.observableArrayList();
            mainApp.setUsersData(userImputName);
            new SerializeblWorker().serrialiseUserWordCollect(e,"C:/1/Users",userImputName);
            Direktory.createDirectory("C:/1/Users",userImputName);
            Direktory.createDirectory("C:/1/Users/"+userImputName,userImputName+"File");
            mainApp.showUsersOverview();



        }else if (idintif==1){ userNameLabel.setText("UserWords named "+userImputName+" olredy exist. try with next name");

        }else if (idintif ==2){userNameLabel.setText(errorMessage);}



    }




    /**
     * Кнопка Cancel возврвщвет на уровень назад
     *
     */
    @FXML
    private void canchelButton() {

        mainApp.showUsersOverview();



    }


    private App mainApp;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public NewUserCreatOverwiewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {


    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;



    }

    private void showNewUserDetails(UsersGPU usersGPU) {

        if (usersGPU != null) {
            // Заполняем метки информацией из объекта word.
            userInputName.setVisible(false);
            userNameLabel.setText(usersGPU.getUsersName());




            // TODO: Нам нужен способ для перевода дня рождения в тип String!
            // birthdayLabel.setText(...);
        } else {
            // Если Person = null, то убираем весь текст.



        }
    }



}
