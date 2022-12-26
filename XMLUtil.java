package com.codingworld.encryptdecryptrsa;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.security.Key;

@Component
public class XMLUtil {
    static PersonalInformation book = new PersonalInformation();
    public static String Marshal() throws JAXBException, IOException {

        book.setName("Rahul");
        book.setPhno("8953581883");
       // Key Sessionkey1=AESEncryption.GetSymmetricSessionKey();
        //book.setSessionkey(Sessionkey1);
        JAXBContext context = JAXBContext.newInstance(PersonalInformation.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw=new StringWriter();

        mar.marshal(book, sw);
        String xml=sw.toString();
        return xml;
    }
    }

