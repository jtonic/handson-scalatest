package ro.jtonic.handson.scalatest;

/**
 * Created by jtonic on 30.08.2014.
 */
public class Person {
    private String ssn;
    private String firstName;
    private String lastName;

    public Person(String ssn, String fName, String lName) {
        this.ssn = ssn;
        this.firstName = fName;
        this.lastName = lName;
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
