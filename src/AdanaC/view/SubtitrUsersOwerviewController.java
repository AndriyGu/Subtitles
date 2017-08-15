package AdanaC.view;

import AdanaC.App;
import AdanaC.SerializeblWorker;
import AdanaC.SubtitlReader;
import AdanaC.model.Subtitles;
import AdanaC.model.UsersGPU;
import AdanaC.model.Word;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.File;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by AdanaC on 02.06.2017.
 */
public class SubtitrUsersOwerviewController {
    @FXML
    private TableView<Subtitles> subtitlesTableView;
    @FXML
    private TableColumn<Subtitles, String> stringTableColumn;
    @FXML
    private Button allWords;
    @FXML
    private Button ok;
    @FXML
    private Button back;
    @FXML
    private Button add;
    @FXML
    private Button smartSerch;
    @FXML
    private Button lerning;
    @FXML
    private Label nameSubtitleLabel;
    @FXML
    private TextField userInputName;


    private App mainApp;

    String nameFile=null;


    public SubtitrUsersOwerviewController() {
    }

    private void showSubtitlesDetails(Subtitles subtitles) {

        if (subtitles != null) {
            // Заполняем метки информацией из объекта word.
            userInputName.setVisible(false);
            nameSubtitleLabel.setText(subtitles.getFileNames());

        } else {
            // Если Person = null, то убираем весь текст.



        }
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        try {
            stringTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Subtitles, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Subtitles, String> cellData) {

                    return cellData.getValue().fileNamesProperty();

                }
            });
        } catch (Exception E){
            E.printStackTrace();
        }
        System.out.println("прошли через ошибку");

        showSubtitlesDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
        subtitlesTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSubtitlesDetails(newValue));

    }


    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;

            subtitlesTableView.setItems(mainApp.getSubtitlesData());

    }




    @FXML
    private void addMetod() throws Exception {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        File fileTwo = new File("C:/1/Users/"+mainApp.getUserCurrentName()+"/"+mainApp.getUserCurrentName()
                +"File/"+file.getName());

        if (file != null) {
            nameFile = file.getAbsoluteFile().toString();

            Files.copy(file.toPath(), fileTwo.toPath());

            System.out.println(nameFile);

            /**

             Вот теперь надо в коллекцию которая содержит слова юзера добавить слова из новых субтитров

             Поместить файл с отпарсеными субтитрами в папку юзера

             и закинуть на отображение в таблицу список отпарсеных субтитров из папки юзера

             */

            //SerializeblWorker.serializblMetodUserList();


            /**
             * добавляем в таблицу юзера строчку с названием только-что выбраных субтитров*/


            mainApp.setSubtitlesData(file.getName());

            mainApp.showSubtOverview();





        }

    }
    @FXML
    private void okMetod() throws Exception {
        Map<String, Long> repydEN = SerializeblWorker.unSerialMetodReiting_EN("C:/1", "Count_1W.XXX");
        Map<String, Long> subtitl = SubtitlReader.read(repydEN,"C:/1/Users/"+mainApp.getUserCurrentName()+
                "/"+mainApp.getUserCurrentName()+"File/"+nameSubtitleLabel.getText());


        System.out.println("Subtitl.size= "+subtitl.size()+"        file name is "+nameSubtitleLabel.getText());

//        mainApp.set

    mainApp.showWordOverview();
    }
    @FXML
    private void backMetod() {

        mainApp.setUserCurrentName(null);
        mainApp.showUsersOverview();

    }
}
