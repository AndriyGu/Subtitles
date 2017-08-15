package AdanaC.view;

/**
 * Created by AdanaC on 23.03.2017.
 */

import AdanaC.FileChooserSample;
import AdanaC.SerializeblWorker;
import AdanaC.SubtitlReader;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import AdanaC.App;
import AdanaC.model.Word;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WordsOverviewController {


    @FXML
    private TableView<Word> wordsTable;
    @FXML
    private TableColumn<Word, Integer> idColumn;
    @FXML
    private TableColumn<Word, String> enColumn;
    @FXML
    private TableColumn<Word, Integer> filmQuantColumn;
    @FXML
    private TableColumn<Word, Long> eNLquantColumn;

    @FXML
    private Label idLabel;
    @FXML
    private Label enLabel;
    @FXML
    private Label filmQuantLabel;
    @FXML
    private Label eNLquantLabel;
    @FXML
    private Text ruText;

    @FXML
    private Button back;
    @FXML
    private Button edit;
    @FXML
    private Button add;


    // Ссылка на главное приложение.
    private App mainApp;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public WordsOverviewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {


        // Инициализация таблицы адресатов с двумя столбцами.
        idColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Word, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Word, Integer> cellData) {


                return cellData.getValue().idProperty().asObject();
            }
        });

        enColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Word, String>,
                        ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Word, String> cellData) {

                return cellData.getValue().enProperty();

            }
        });

        filmQuantColumn.setCellValueFactory(new PropertyValueFactory<Word, Integer>("filmQuant"));


        eNLquantColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Word, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<Word, Long> cellData) {


                return cellData.getValue().enLenQuantProperty().asObject();
            }
        });


        showWordsDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
        wordsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showWordsDetails(newValue));


    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        wordsTable.setItems(mainApp.getWordsData());
    }

    private void showWordsDetails(Word word) {
        if (word != null) {
            // Заполняем метки информацией из объекта word.
            idLabel.setText(Integer.toString(word.getId()));
            enLabel.setText(word.getEn());
            filmQuantLabel.setText(Long.toString(word.getFilmQuant()));
            eNLquantLabel.setText(Long.toString(word.getEnLenQuant()));

            ruText.setText(word.getRu());


        } else {
            // Если Person = null, то убираем весь текст.
            idLabel.setText("");
            enLabel.setText("");
            filmQuantLabel.setText("");
            eNLquantLabel.setText("");

        }
    }

    @FXML
    private void backMetod() {
        mainApp.setSubtitlesData(mainApp.getUserCurrentName());

    }




}

