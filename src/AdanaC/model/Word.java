package AdanaC.model;

/**
 * Created by AdanaC on 23.03.2017.
 */

import javafx.beans.property.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Word {

    private final IntegerProperty id;
    private final StringProperty en;
    private final LongProperty filmQuant;
    private final LongProperty enLenQuant;
    private final StringProperty ru;


    public Word() {
        this(0, null,0,0,null);
    }

    public Word(int id, String en, long filmQuant, long enLenQuant, String ru) {

        this.id= new SimpleIntegerProperty(id);
        this.en = new SimpleStringProperty(en);
        this.filmQuant= new SimpleLongProperty(filmQuant);
        this.enLenQuant= new SimpleLongProperty(enLenQuant);
        this.ru = new SimpleStringProperty(ru);



    }



    public int getId() {
        return id.get();
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public void setId(int id) {
        this.id.set(id);
    }



    public String getEn() {
        return en.get();
    }

    public StringProperty enProperty() {
        return en;
    }

    public void setEn(String en) {
        this.en.set(en);
    }



    public long getFilmQuant() {
        return filmQuant.get();
    }

    public LongProperty filmQuantProperty() {
        return filmQuant;
    }

    public void setFilmQuant(long filmQuant) {
        this.filmQuant.set(filmQuant);
    }



    public long getEnLenQuant() {
        return enLenQuant.get();
    }

    public LongProperty enLenQuantProperty() {
        return enLenQuant;
    }

    public void setEnLenQuant(long enLenQuant) {
        this.enLenQuant.set(enLenQuant);
    }



    public String getRu() {
        return ru.get();
    }

    public StringProperty ruProperty() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru.set(ru);
    }






}
