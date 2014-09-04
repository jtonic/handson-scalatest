package ro.jtonic.handson.scalatest;

/**
 * Created by jtonic on 04.09.2014.
 */
public class Teacher {

    private String fName;
    private Long id;

    public Teacher(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
