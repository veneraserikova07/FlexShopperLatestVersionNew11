package helpers;

import javax.mail.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMail {
    public static void check(String host, String storeType, String user,
                                                 String password)
{
    try {
        String url=null;
        String userid =null;
        String pass=null;
        String passcode=null;

        //create properties field
        Properties properties = new Properties();

        properties.put("mail.imap.host",host);
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.starttls.enable", "true");
        properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",String.valueOf(993));
        Session emailSession = Session.getDefaultInstance(properties);

        //create the IMAP store object and connect with the IMAP server
        Store store = emailSession.getStore("imap");

        store.connect(host, user, password);

        //create the folder object and open it
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);

        // retrieve the messages from the folder in an array and perform email fetching actions
        Message[] messages = emailFolder.getMessages();
        //System.out.println("messages.length---" + messages.length);
        int n=messages.length;
        for (int i = 0; i<n; i++) {
            Message message = messages[i];
            //creating the object of Multipart class
            Multipart multipart = (Multipart) message.getContent();
            BodyPart part = multipart.getBodyPart(0);
            String responseMessage = part.getContent().toString();
            //System.out.println("================"+responseMessage);
            if(message.getSubject().contains("Your verification code"))
            {

                /*Get URL*/
                Pattern p2 = Pattern.compile("http(.+)");
                Matcher m2 = p2.matcher(responseMessage);

                if (m2.find()) {
                    url = m2.group();
                }
                //System.out.println("URL :="+ url);

                /*Get password from email*/

                Pattern p1 = Pattern.compile("code:(\\s*.+)");
                Matcher m1 = p1.matcher(responseMessage);

                if (m1.find()) {
                    pass = m1.group(1);
                    //To remove white spaces from String pass
                    passcode= pass.replaceAll("\\s+", " ");
                }
                System.out.println("Code :="+ passcode);

            }


            //System.out.println("---------------------------------");
            //System.out.println("Email Number " + (i + 1));
            //System.out.println("Subject: " + message.getSubject());
            //System.out.println("From: " + message.getFrom()[0]);
            //System.out.println("Text: " + message.getContent().toString());

        }
        //close the store and folder objects
        emailFolder.close(false);
        store.close();

    } catch (NoSuchProviderException e) {
        e.printStackTrace();
    } catch (MessagingException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return;
}
    public static void main(String[] args) {
// Creating object and calling method check
        CheckMail checkGmail = new CheckMail();
        checkGmail.check("imap.gmail.com", "imap", "nann40547@gmail.com", "elwtswjneifjlzor");
/*String host = "imap.gmail.com";
String storeType = "imap";
String user = "writetotestall@gmail.com";
//String password = "Gajanan$11";
String password = "wguygteyuwtaicef";
check(host, storeType, user, password);*/


    }


}
