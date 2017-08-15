package AdanaC.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by AdanaC on 02.06.2017.
 */
public class Subtitles {

    private final StringProperty fileNames;

    public Subtitles(String fileNames){
        this.fileNames=new SimpleStringProperty(fileNames);
    }

    public String getFileNames() {
        return fileNames.get();
    }

    public StringProperty fileNamesProperty() {
        return fileNames;
    }

    public void setFileNames(String fileNames) {
        this.fileNames.set(fileNames);
    }


}
