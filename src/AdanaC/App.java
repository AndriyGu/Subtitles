package AdanaC;

import AdanaC.model.Subtitles;
import AdanaC.model.UsersGPU;
import AdanaC.model.Word;
import AdanaC.view.NewUserCreatOverwiewController;
import AdanaC.view.SubtitrUsersOwerviewController;
import AdanaC.view.UsersOverviewController;
import AdanaC.view.WordsOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */

public class App extends Application {

    private String userCurrentName=null; /** содержит имя пользователя которое выбрано в текущий момент*/
    private String userName=null;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Word> wordsData = FXCollections.observableArrayList();
    private ObservableList<Subtitles> subtitlesData = FXCollections.observableArrayList();

    private ObservableList<UsersGPU> usersData = FXCollections.observableArrayList();
    long userListLeng= UserWords.userWordsList.size();
    public class Practice {



            Boolean b = new Boolean("/true");


    }


    /* public void setSubtitlesDataChenged(){
        for (String ss :UserChoos.usersSets()) {
            subtitlesData.add(new Subtitles(ss));
            System.out.println("проверяем пользователей");

        }
    }*/
    public void setUsersDataChenged(){
        for (String ss :UserChoos.usersSets()) {
            usersData.add(new UsersGPU(ss));
            System.out.println("проверяем пользователей");

        }
    }

    public void setWordsData(String path, String userCurrentName){



    }
    public void setUserWordsChenged(String path, String userName){
        /**
         * метод получает имя пользователя и отправляет его на РОЗсеррлиазацию
         * в ответ получает коллекцию
         * и заполняет ею ObservableList<UsersGPU> usersData
         * */

        ObservableList<UserWords> listTemp=SerializeblWorker.unSerrialiseUserWordCollect(path,userName);



        for (UserWords userWords : listTemp) {

            wordsData.add(new Word(userWords.getId(), userWords.getWordGeneral(), userWords.getFilm_freq(), userWords.getRaiting_E_F(), userWords.getTranslatWordGeneral()));


        }}

    public App(){


        setUsersDataChenged();




    }



    @Override
    public void start(Stage primaryStage) {
        System.out.println("start");
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Subtitles");

        initRootLayout();

    showUsersOverview();


    }
    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();

            System.out.println("initRootLayout готовимся создать екземпляр Арр");
            loader.setLocation(App.class.getResource("view/RootLayout.fxml"));
            System.out.println("initRootLayout создали екземпляр Арр");
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public ObservableList<Subtitles> getSubtitlesData(){
        return subtitlesData;
    }
    public void setSubtitlesData(String fileName){subtitlesData.add(new Subtitles(fileName));}

    public ObservableList<Word> getWordsData() {
        return wordsData;
    }

    public ObservableList<UsersGPU>  getUsersData(){
        return usersData;
    }
    public void setUsersData(String ss) {
        usersData.add(new UsersGPU(ss));
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCurrentName() {
        return userCurrentName;
    }
    public void setUserCurrentName(String userCurrentName) {
        this.userCurrentName = userCurrentName;
    }





    /**
     * Показывает в корневом макете сведения об адресатах.
     */


    public void showUsersOverview() {
        try {

            System.out.println("showUsersOverview -- Загружаем сведения об users.");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/UserChuser.fxml"));
            AnchorPane userOverview = (AnchorPane) loader.load();


            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(userOverview);

            UsersOverviewController controller = loader.getController();

            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showSubtOverview() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/SubtitrUsers.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();


            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);


            SubtitrUsersOwerviewController controller = loader.getController();
            controller.setMainApp(this);;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showWordOverview() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/WordOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();


            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);;

            WordsOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showNewUserCreatOverview() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/NewUser.fxml"));
            AnchorPane NewUserCreatOverwieew = (AnchorPane) loader.load();


            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(NewUserCreatOverwieew);

            NewUserCreatOverwiewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает главную сцену.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }




    public static void main(String[] args) {
    try {



            /*    Translate translate = TranslateOptions.builder().apiKey("AIzaSyBHjoIYMXBj9LsbInjqpkP_Be0h8410ROo").build().service();
                // The text to translate
                String text = "Words";
                // Translates some text into Russian
                Translation translation = translate.translate(
                        text,
                        TranslateOption.sourceLanguage("en"),
                        TranslateOption.targetLanguage("ru")
                );
                System.out.printf("Text: %s%n", text);
                System.out.printf("Translation: %s%n", translation.translatedText());

*/
            for (String ss :UserChoos.usersSets()) {
                System.out.println("otparsili "+ss);

            }

           // String userName=UserChoos.userCHoos();




                /*// файл с сериализованой коллекцией
                     файл с сериализованым словарем Мюллера
                уже есть. эти три метода уже не актуальны
                Map<String, Long>  dict= DictionaryReader.read("C:/1/count_1w.txt");
                SerializeblWorker.serialMetodReiting_EN(dict, "C:/1", "Count_1W.xxx");
                SerializeblWorker.serialMetodEN_RU_Dic(EN_RU_DictionaryReader.mapEN_RU,"C:/1", "EN_RU_muller.xxx");

*/


                Map<String, Long> repydEN = SerializeblWorker.unSerialMetodReiting_EN("C:/1", "Count_1W.XXX");
                // парсим текстовый файл с частотой слов
                System.out.println("В частотной коллекции "+repydEN.size()+" слов");

                // парсим файл субтитров
                Map<String, Long> subtitl = SubtitlReader.read(repydEN,"C:/1/Next.SRT");
                System.out.println("Subtitl.size= "+subtitl.size());


                // парсим файл субтитров
              //  System.out.println("парсим файл субтитров "+ subtitl.size());
              //Map<String, Long> subtitl = SubtitlReader.read("C:/1/Sub.txt");


                Map<String,String> mapEN_RU = SerializeblWorker.unSerialMetodEN_RU_Dic("C:/1", "EN_RU_muller.xxx");
                System.out.println("В словаре мюллера "+mapEN_RU.size()+" слов");


              //  System.out.println("парсили словарь, получили "+ mapEN_RU.size()+" слов");
             // Map<String, String> readEN_RU = EN_RU_DictionaryReader.readEN_RU("C:/1/aemuller.txt");
                // парсим словарь



                // сортируем по значению, хотя Мар вроде не сортируююются
                Map<String, Long> result = new LinkedHashMap<>();
                result=SubtitlReader.sortByValue(SubtitlReader.mapSubt);
                int c =1;
                System.out.println("c= "+c);

                Raiting.filingReitingMap(subtitl, repydEN);
                System.out.println("Subtitl.size= "+subtitl.size());

              UserWords.filingUserList(mapEN_RU, subtitl, repydEN);  // заполняем коллекцию пользователя
              // UserWords.printingUserList();
              // UserWords.userWordsList.sort(UserWords::compareTo);
                System.out.println();
                System.out.println();




                //

                // КАК____________________________________________________________
                // РАБОТАЕТ
                // ЭТА
                // СТРОЧКА!!!!!!!!________________________________________________


             // System.out.println(UserWords.userWordsList.size());
                UserWords.userWordsList.sort(UserWords::compareTo);//
                UserWords.printingUserList();


               // подготавливаем коллекцию юзера для записи в файл с именем юзера
                List<UserWords> userWordsList = UserWords.userWordsList;
              //  SerializeblWorker.serializblMetodUserList(userWordsList,"C:/1/Users",userName);



            }
            catch (Exception e){   System.out.println(e.toString());
            }

        launch(args);







        }


}
