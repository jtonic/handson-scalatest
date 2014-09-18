package ro.jtonic.handson.scalatest;

/**
 * Created by jtonic on 01.09.2014.
 */
public class Teacher {

    private Long id;
    private String name;
    private String userName;

    public Teacher(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }
}
