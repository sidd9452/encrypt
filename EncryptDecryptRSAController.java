
package com.codingworld.encryptdecryptrsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static com.codingworld.encryptdecryptrsa.AESEncryption.SessionKey1;

@RestController
public class EncryptDecryptRSAController {

  @Autowired

  EncryptDecryptService encryptDecryptService;

  @GetMapping("/createKeys")
  public void createPrivatePublickey() {
    encryptDecryptService.createKeys();
  }

  @PostMapping("/encrpyt")
  public String encryptMessage(@RequestBody String plainString) {
    return encryptDecryptService.encryptMessage(plainString);
  }
  @PostMapping("/getname")
  public static String getname(@RequestBody String pid){

    return pid;
  }
  @PostMapping("/getno")
  public String getno(@RequestBody String pid){
    return pid;
  }


  @PostMapping("/decrpyt")
  public String decryptMessage(@RequestBody String encryptString) {
    return encryptDecryptService.decryptMessage(encryptString);

  }
  @PostMapping("/encrpytSessionKey")
  public String encryptSessionKey() throws NoSuchAlgorithmException {
    String encoded=EncryptDecryptService.convertSessionKeyToString(SessionKey1);
    System.out.println(encoded);

    return encryptDecryptService.encryptMessage(encoded);

  }

  @GetMapping("/sessionkey")
  public void SessionKey(){
    Key Session=AESEncryption.GetSymmetricSessionKey();

  }
  @PostMapping("/AESencryption")
  public String AESEncryption(@RequestBody String plainString)
  {
    return AESEncryption.EncryptData(plainString);
  }
  @PostMapping ("/XML")
  public String XML() throws JAXBException, IOException {
    String xml=XMLUtil.Marshal();
    return xml;
  }
  @PostMapping("/AESDecryption")
  public String AESDecryption(@RequestBody String plainString)
  {
    return AESEncryption.DecryptDataSymmetrically(plainString);
  }



}
