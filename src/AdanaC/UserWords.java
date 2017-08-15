package AdanaC;

//странно работает если я не хочу создать нового пользователя всеравно запускает парсинг субтитров
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by AdanaC on 06.02.2017.
 */
public class UserWords implements Comparable<UserWords>, Serializable {

    static  List<UserWords> userWordsList = new LinkedList<>();

    private  int id;
    private String wordGeneral;
    private String translatWordGeneral;
    private long eng_freq;              //частота в англ языке
    private long film_freq;             //частота в фильме
    private long raiting_E_F;           //частота придуманая
    private long raitingTO_Find;        //частота для поиска, ориентир для ф-ции SHOW
    private long userGhoss;
    private int raitingFind;


    public long getEng_freq(){
        return eng_freq;
    }
    public void setEng_freq(long eng_freq){
        this.eng_freq=eng_freq;
    }


    public long getFilm_freq() {
        return film_freq;
    }
    public void setFilm_freq(long film_freq) {
        this.film_freq = film_freq;
    }

    public long getRaiting_E_F(){return  raiting_E_F;}
    public void  setRaiting_E_F(long eng_freq, long film_freq){
        raiting_E_F = (eng_freq/300000)*film_freq;
        if (raiting_E_F <1){raiting_E_F = 1;}

    }
    public void  setRaiting_E_F(long eng_freq){
        raiting_E_F = eng_freq;}



    public long getRaitingTO_Find() {
        return raitingTO_Find;
    }
    public void setRaitingTO_Find(long raitingTO_Find) {
        this.raitingTO_Find = raitingTO_Find;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getWordGeneral() {
        return wordGeneral;
    }
    public void setWordGeneral(String wordGeneral) {
        this.wordGeneral = wordGeneral;
    }

    public String getTranslatWordGeneral() {
        return translatWordGeneral;
    }
    public void setTranslatWordGeneral(String translatWordGeneral) {
        this.translatWordGeneral = translatWordGeneral;
    }

    public long getUserGhoss() {
        return userGhoss;
    }
    public void setUserGhoss(long userGhoss) {
        this.userGhoss = userGhoss;
    }

    public int getRaitingFind() {
        return raitingFind;
    }
    public void setRaitingFind(int raitingFind) {
        this.raitingFind = raitingFind;
    }

    ** метод получает задание на РОЗсереализацию файла отпарсеных субтитров
     *
     * серриализация и парсинг должны происходить прежде,
     * вызыватся из метода где добавляются субтитры,
     * также должны происходить изменения в файле "глобальной пользовательской" коллекции
     *

    @Override
    public int compareTo(UserWords emp) {
        //давайте будем сортировать объекты Employee по значению поля id от меньшего к большему
        //будем возвращать отрицательное число, 0 или положительное число по каждому сравнению объектов
        // здесь мы просто отнимаем значение поля одного объекта от значения поля другого объекта
        // в результате получим 1 из 3 вариантов описанных выше вариантов
        return (int) (emp.raiting_E_F-this.raiting_E_F);
    }

    @Override
    // переопределяем метод таким образом, чтобы
    // он возвращаем информацию об объекте в читабельном виде
    public String toString() {
        return "[id=" + this.id + ", En=" + this.wordGeneral + ", Ru=" + this.translatWordGeneral + ", " +
                "REF=" + this.raiting_E_F +", user="+userGhoss+ "]";
    }




    public static void filingUserList(Map<String,String> mapEN_RU, Map<String, Long> subtitl, Map<String, Long> repydEN) {


        for (String key : SubtitlReader.mapSubt.keySet()) {
            UserWords usertemp = new UserWords();

            int temp = 0;
            for (UserWords userWords1 : userWordsList) {


                if (userWords1.getWordGeneral().equals(key)){temp = 1;}
                else {}
                }

            if(temp == 0){

                usertemp.setId(0);
                usertemp.setWordGeneral(key);

                usertemp.setTranslatWordGeneral("");

                usertemp.setTranslatWordGeneral(mapEN_RU.get(key));
               // System.out.println("key "+ key+"/в добавлении пользовательской коллекции");//translatorTest.transletion(key));
              //  System.out.println("добавляем перевод "+mapEN_RU.get(key));

                usertemp.setEng_freq(repydEN.get(key));

               // System.out.println(subtitl.size());
                usertemp.setFilm_freq(subtitl.get(key));

               // System.out.println("SubtitlReader "+subtitl.get(key));
                usertemp.setRaiting_E_F(usertemp.getEng_freq(),usertemp.getFilm_freq());
                usertemp.setRaitingTO_Find(0);
                usertemp.setUserGhoss(0);
                usertemp.setRaitingTO_Find(0);


                userWordsList.add(usertemp);

            }
        }
    }


    public static void printingUserList(){
        int i = 0;
        for (UserWords userWords : userWordsList) {

            System.out.println("[id= "+i + ",       En= " +  userWords.wordGeneral + ",  " +
                    " film_freq= "+ userWords.film_freq+     ",      REF= " + userWords.raiting_E_F +
                   ",          Ru= " + userWords.translatWordGeneral + ", " +

                    ", userWords="+ userWords.getUserGhoss()+ "]");
            i++;

        } i=0;
    }




}
