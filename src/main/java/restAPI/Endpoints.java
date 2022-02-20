package restAPI;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Endpoints {


    BOOKING("CRUD form for bookings","/booking");

    String summary;
    String path;

    Endpoints(String summary, String path){
        this.summary = summary;
        this.path = path;
    }

    public String getSummary(){
        return this.summary;
    }

    public String getPath(){
        return this.path;
    }
}