package com.codingworld.encryptdecryptrsa;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.security.Key;

@XmlRootElement(name = "PID")
@XmlType(propOrder = { "phno", "name" })
@Component

public class PersonalInformation {
    private String phno;
    private String name;
    Key Sessionkey;

    @XmlAttribute
    public void setPhno(String phno) {
        this.phno = phno;
    }

    @XmlElement(name = "title")
    public void setName(String name) {
        this.name = name;

    }
    @XmlElement
    public void setSessionkey(Key Sessionkey){
        this.Sessionkey= Sessionkey;
    }
}
