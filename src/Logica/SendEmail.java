/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.nio.cs.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;


/**
 *
 * @author Admin
 */
public class SendEmail {
    
    private static String xxx = "wYcnCtE3Mup4Jlnl64WPYw==";
    private static final String content = "La Nueva Contraseña De Tu Cuenta Es: ";    

       
//    public static String Encriptar(String texto) {
// 
//        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
//        String base64EncryptedString = "";
// 
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
//            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
// 
//            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
//            Cipher cipher = Cipher.getInstance("DESede");
//            cipher.init(Cipher.ENCRYPT_MODE, key);
// 
//            byte[] plainTextBytes = texto.getBytes("utf-8");
//            byte[] buf = cipher.doFinal(plainTextBytes);
//            byte[] base64Bytes = Base64.getEncoder().encode(buf);//.encodeBase64(buf);
//            base64EncryptedString = new String(base64Bytes);
// 
//        } catch (Exception ex) {
//        }
//        return base64EncryptedString;
//    }
    
    public static String Desencriptar(String textoEncriptado) throws Exception {
 
        String secretKey = "qualityinfosolutions"; //llave para desenciptar datos
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.getDecoder().decode(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
}   
  
  

   public static void EnviarCorreo(String mail,String pass) throws UnsupportedEncodingException {    
      // Recipient's email ID needs to be mentioned.
      String to = mail;

      // Sender's email ID needs to be mentioned
      String from = "medicomp@gmail.com";

      // Assuming you are sending email from localhost
      String host = "smtp.gmail.com";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
      
      properties.setProperty("mail.smtp.port", "587");
      
      properties.setProperty("mail.smtp.starttls.enable", "true");
      
      properties.setProperty("mail.smtp.auth", "true");
      

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
          
    @Override
    protected PasswordAuthentication getPasswordAuthentication()  {
        try {
            return new PasswordAuthentication("birdosamuel@gmail.com",SendEmail.Desencriptar(SendEmail.xxx));
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }   
      });

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from,"MediComp"));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Cambio de Contraseña");

         // Now set the actual message
         message.setText(content + pass);

         // Send message
         Transport.send(message);
         //System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}

