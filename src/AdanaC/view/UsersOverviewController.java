package AdanaC.view;

import AdanaC.App;
import AdanaC.model.Subtitles;
import AdanaC.model.UsersGPU;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.File;

/**
 * Created by AdanaC on 12.05.2017.
 */
public class UsersOverviewController {
    @FXML
    private TableView<UsersGPU> usersTable;
    @FXML
    private TableColumn<UsersGPU, String> usersColumn;
    @FXML
    private Button ok;
    @FXML
    private Button createNewUser;
    @FXML
    private Label userNameLabel;
    @FXML
    private TextField userInputName;




    @FXML
    private void createNewUserMetod() {

        mainApp.showNewUserCreatOverview();
}
    @FXML
    private void okMetod() {
        String userName=userNameLabel.getText();
       // mainApp.setUsersData(userName);
        mainApp.setUserCurrentName(userName);

        if(userNameLabel.getText().equals("")){
            System.out.println("oppa");
        }
        else {//mainApp.setUserWordsChenged("C:/1/Users",userName); //сейчас логика изменена

        /**Нужно создать код который берет список файлов из папки "UserName"+File и отображает его в табличке слева
         *
         *
         * */
            File file = new File("C:/1/Users/"+userName+"/"+userName+"File");
            File [] files = null;
            files = file.listFiles();

            if (mainApp.getSubtitlesData().isEmpty()){
                for (File f: files ) {
                mainApp.setSubtitlesData(f.getName().toString());}}





            mainApp.showSubtOverview();
        }}



    private boolean okClicked = false;


    // Ссылка на главное приложение.
    private App mainApp;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public UsersOverviewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {


        // Инициализация таблицы юзеров.


        usersColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<UsersGPU, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<UsersGPU, String> cellData) {

                return cellData.getValue().usersNameProperty();

            }
        });





        showWordsDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
        usersTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showWordsDetails(newValue));



    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(App mainApp) {
        System.out.println("setMainApp");
        this.mainApp = mainApp;
        userInputName.setVisible(false);

        // Добавление в таблицу данных из наблюдаемого списка

        usersTable.setItems(mainApp.getUsersData());
    }

    private void showWordsDetails(UsersGPU usersGPU) {

        if (usersGPU != null) {
            // Заполняем метки информацией из объекта word.
            userInputName.setVisible(false);
            userNameLabel.setText(usersGPU.getUsersName());

        } else {
            // Если Person = null, то убираем весь текст.



        }
    }


    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }


}
