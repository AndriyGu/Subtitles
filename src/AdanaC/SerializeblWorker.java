package AdanaC;

import AdanaC.model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by AdanaC on 17.02.2017.
 */
public class SerializeblWorker {
    private App mainApp;

    public static void serializblMetodUserList(List<UserWords> list, String path, String filName) {

      /* метод получает коллекцию конкретного пользователя будущего файла, путь и имя файла
                если файл есть копирует содержимое в userList2, идет по userList2 сравнивая
                с полученым userWordsList
       */

        List<UserWords> userWordsTemp = new LinkedList<>();
        try {
            String pathTemp = path + "/" + filName+".xxx";
            File myFile = new File(pathTemp);
            System.out.println("Имя файла: " + myFile.getName());
            System.out.println("Родительский каталог: " + myFile.getParent());
            if (myFile.exists()) {
                try {

                    FileInputStream fis = new FileInputStream(pathTemp);
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    List<UserWords> userWordsList2 = (List<UserWords>) oin.readObject();


                    for (UserWords userWords : userWordsList2) {
                        System.out.println(userWords.getWordGeneral());
                    }




                    if (userWordsList2.equals(UserWords.userWordsList)) {
                       // System.out.println("Считает равным");
                    } /*проверяем на соответствие коллекций
                скачаную и ту что была создана*/ else {
                       // System.out.println("Коллекции не равны");


                        for (UserWords userWords1 : UserWords.userWordsList) {
                            int temp = 0;
                            // get value from Current userWordsList
                            // System.out.println("Идем по Юзер 1, слово "+userWords1.getWordGeneral());


                            for (UserWords userWords2 : userWordsList2) {  // get value from Downloadet userWordsList
                                //System.out.println("Идем по юзер 2");
                                if (userWords1.getWordGeneral().equals(userWords2.getWordGeneral())) {
                                    temp = 1;
                                   // System.out.println("Совпадение");
                                } else {
                                    //System.out.println("Не соответствует");
                                }


                                ///System.out.println("Вышли из 2");


                            }//System.out.println("Вышли из 1");
                            if (temp == 0) {
                                userWordsList2.add(userWords1);
                                System.out.println("добавили                         " + userWords1.getWordGeneral());
                            }
                        }
                    }


                    for (UserWords userWords : userWordsList2) {
                        System.out.println(userWords.getWordGeneral());
                    }
                    System.out.println(userWordsList2.size());

                    FileOutputStream fos = new FileOutputStream(pathTemp);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(userWordsList2);
                    oos.flush();
                    oos.close();
                    System.out.println("Коллекция обновлена");


                } catch (Exception E) {
                    E.printStackTrace();
                    System.out.println("93 При попытке прочитать файл "+filName+".xxx");
                }

            } else {
                FileOutputStream fos = new FileOutputStream(pathTemp);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(list);
                oos.flush();
                oos.close();
                System.out.println("Коллекция записана");

            }


        } catch (Exception e) {
            System.out.println("from SerializeblWorker");
        }
    }



    public static String serialMetodEN_RU_Dic(Map<String, String> map, String path, String filName) {
        String status = "";
        try {

            String pathTemp = path + "/" + filName;
            File myFile = new File(pathTemp);
            //System.out.println("Имя файла: " + myFile.getName());
           // System.out.println("Родительский каталог: " + myFile.getParent());
            if (myFile.exists()) {
                status = "File " + pathTemp + " olredy is";
            } else {


                FileOutputStream fos = new FileOutputStream(pathTemp);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(map);
                oos.flush();
                oos.close();
               // System.out.println("Карта  записана");
                status = "File " + pathTemp + " is created";

            }


        } catch (Exception E) {

            System.out.println(E.fillInStackTrace());

            System.out.println("from SerializeblWorker");
        }
        System.out.println(status);
        return status;
    }

    public static Map<String, String> unSerialMetodEN_RU_Dic(String path, String filName) {

        Map<String, String> mapTemp=null;
        try {
            String pathTemp = path + "/" + filName;
            ;
            File myFile = new File(pathTemp);
            //System.out.println("Имя файла: " + myFile.getName());
           // System.out.println("Родительский каталог: " + myFile.getParent());
            if (myFile.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(pathTemp);
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    mapTemp = (Map<String, String>) oin.readObject();

                } catch (Exception E) {
                    E.fillInStackTrace();
                    System.out.println("170 При попытке прочитать файл "+pathTemp);
                }

            } else {
                System.out.println("File " + pathTemp + " not founded");


            }


        } catch (Exception E) {

            System.out.println(E.fillInStackTrace());;

            System.out.println("from SerializeblWorker");
        }
        System.out.println("File " + filName + " read");
        return mapTemp;
    }



    public static String serialMetodReiting_EN(Map<String, Long> map, String path, String filName) {
        String status = "";
        try {

            String pathTemp = path + "/" + filName;
            File myFile = new File(pathTemp);
           // System.out.println("Имя файла: " + myFile.getName());
           // System.out.println("Родительский каталог: " + myFile.getParent());
            if (myFile.exists()) {
                status = "File " + pathTemp + " olredy is";
            } else {

           /* довести до ума пройти от загрузки до шоу
                        избавится от парсинга коллекции частоты повтарений

*/

                FileOutputStream fos = new FileOutputStream(pathTemp);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(map);
                oos.flush();
                oos.close();
                System.out.println("Карта  записана");
                status = "File " + pathTemp + " is created";

            }


        } catch (Exception E) {

            System.out.println(E.fillInStackTrace());

            System.out.println("from SerializeblWorker");
        }
        System.out.println(status);
        return status;
    }

    public static Map<String, Long> unSerialMetodReiting_EN(String path, String filName) {

        Map<String, Long> mapTemp=null;
        try {
            String pathTemp = path + "/" + filName;
            ;
            File myFile = new File(pathTemp);
            //System.out.println("Имя файла: " + myFile.getName());
            //System.out.println("Родительский каталог: " + myFile.getParent());
            if (myFile.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(pathTemp);
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    mapTemp = (Map<String, Long>) oin.readObject();

                } catch (Exception E) {
                   E.fillInStackTrace();


                    System.out.println("253 При попытке прочитать файл "+pathTemp);
                }

            } else {
                System.out.println("File " + pathTemp + " not founded");


            }


        } catch (Exception E) {
            System.out.println(E.getMessage());
            System.out.println(E.fillInStackTrace());;
            System.out.println(E.toString());
            System.out.println(E.getLocalizedMessage());
            System.out.println("from SerializeblWorker");
        }
        //System.out.println("mapTemp from MapDic have "+mapTemp.size());
        return mapTemp;
    }



    public static String serialUsers(Map<String, String> map, String path, String filName) {

        /**метод серриализует коллекцию юзеров после изменения
         *
         * */
        String status = "";
        try {

            String pathTemp = path + "/" + filName;;
            File myFile = new File(pathTemp);
            if (myFile.exists()) {

                status = "File with Users " + pathTemp + " olredy is";
            } else {


                FileOutputStream fos = new FileOutputStream(pathTemp);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(map);
                oos.flush();
                oos.close();
                // System.out.println("Карта  записана");
                status = "File with Users" + pathTemp + " is created";

            }


        } catch (Exception E) {
            System.out.println(E.getMessage());
            System.out.println(E.fillInStackTrace());
            System.out.println(E.toString());
            System.out.println(E.getLocalizedMessage());
            System.out.println("from Users metod SerializeblWorker");
        }
        System.out.println(status);
        return status;
    }

    public static Map<String, String> unSerialUsers(String path, String filName) {

        Map<String, String> mapTemp=null;
        try {
            String pathTemp = path + "/" + filName;
            File myFile = new File(pathTemp);
            //System.out.println("Имя файла: " + myFile.getName());
            //System.out.println("Родительский каталог: " + myFile.getParent());;
            if (myFile.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(pathTemp);
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    mapTemp = (Map<String, String>) oin.readObject();;

                } catch (Exception E) {
                    E.fillInStackTrace();
                    System.out.println("331 При попытке прочитать файл "+pathTemp);
                }

            } else {
                Map<String, String> e = new LinkedHashMap<String, String>();
SerializeblWorker.serialUsers(e,"C:/1/Users", "User_LIST.xxx");
mapTemp=unSerialUsers("C:/1/Users", "User_LIST.xxx");


            }


        } catch (Exception E) {
            System.out.println(E.getMessage());
            System.out.println(E.fillInStackTrace());;
            System.out.println(E.toString());;
            System.out.println(E.getLocalizedMessage());
            System.out.println("from SerializeblWorker");
        }
        //System.out.println("mapTemp from MapDic have "+mapTemp.size());
        return mapTemp;
}


public static ObservableList<UserWords> unSerrialiseUserWordCollect(String path, String userName){
        /**
         * метод должен достать коллекцию из слов конкретного пользователя
         * и отправить на отображение
         *
         * если коллекции еще не создано то запустить метод для создания(метод создания должен
         * не только создавать но и менять)
         *
         * */
    ObservableList<UserWords> listTemp=FXCollections.observableArrayList();
    List<UserWords> listList=null;
        try {
             String pathTemp = path + "/" + userName+".slo";
             File myFile = new File(pathTemp);

            if (myFile.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(pathTemp);
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    listList = (List<UserWords>) oin.readObject();
                    for (UserWords userWords: listList) {
                        listTemp.add(userWords);

                    }

                } catch (Exception E) {
                    E.fillInStackTrace();
                    E.printStackTrace();
                    System.out.println("375 При попытке прочитать файл "+pathTemp);
                }

            } else {
                List<UserWords> e = new LinkedList<UserWords>();
                SerializeblWorker serializeblWorker = new SerializeblWorker();
                serializeblWorker.serrialiseUserWordCollect(e, path, userName);
                listList=unSerrialiseUserWordCollect(path,userName);
                for (UserWords userWords: listList) {
                    listTemp.add(userWords);

                }


            }


        } catch (Exception E) {
            System.out.println(E.getMessage());
            System.out.println(E.fillInStackTrace());;
            System.out.println(E.toString());;
            System.out.println(E.getLocalizedMessage());
            System.out.println("from SerializeblWorker");
        }
        //System.out.println("mapTemp from MapDic have "+mapTemp.size());
        return listTemp;
    }

      public void serrialiseUserWordCollect(List<UserWords> list, String path, String userName){
                /** проверяет есть ли коллекция, если нет создает
                 *  если есть заменяет
                 *
                 *
                 * */

          try {

              String pathTemp = path + "/" +mainApp.getUserCurrentName()+ userName+".slo";
              File myFile = new File(pathTemp);
              if (myFile.exists()) {
                  myFile.delete(); // удаляем старый записываем новый
                  FileOutputStream fos = new FileOutputStream(pathTemp);
                  ObjectOutputStream oos = new ObjectOutputStream(fos);

                  oos.writeObject(list);
                  oos.flush();
                  oos.close();
                  System.out.println(userName+".slo  записан");



              } else {


                  FileOutputStream fos = new FileOutputStream(pathTemp);
                  ObjectOutputStream oos = new ObjectOutputStream(fos);

                  oos.writeObject(list);
                  oos.flush();
                  oos.close();
                   System.out.println(userName+".slo  записан");


              }


          } catch (Exception E) {
              System.out.println(E.getMessage());
              System.out.println(E.fillInStackTrace());
              System.out.println(E.toString());
              System.out.println(E.getLocalizedMessage());
              System.out.println("from Users metod SerializeblWorker");
          }


      }
}





