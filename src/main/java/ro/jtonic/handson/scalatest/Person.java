package ro.jtonic.handson.scalatest;

/**
 * Created by jtonic on 30.08.2014.
 */
public class Person {
    private String ssn;
    private final String antonel;
    private final String pazargic;
    private String firstName;
    private String lastName;

    public Person(String ssn, String antonel, String pazargic) {
        this.ssn = ssn;
        this.antonel = antonel;
        this.pazargic = pazargic;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("ssn='").append(ssn).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
