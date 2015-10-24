package br.com.gabrielrtakeda.api.mappers;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Test {

    private String Firstname;
    private String Lastname;

    public Test()
    {
    }

    public Test(String firstname, String lastname)
    {
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}
