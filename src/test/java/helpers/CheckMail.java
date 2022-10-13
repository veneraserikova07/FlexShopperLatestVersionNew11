package helpers;

import javax.mail.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMail

{
    public static String check(String host, String storeType, String user, String password)
    {
        String url="";
        String userid ="";
        String pass="";
        String passcode="";

        try {

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
               if((message.getMessageNumber()==n)&&message.getSubject().contains("Your verification code"));
                //if(message.getSubject().contains("Your verification code"))
                {
                    Pattern p1 = Pattern.compile("code:         [^a-zA-Z0-9](\\s*.*)");
                    Matcher m1 = p1.matcher(responseMessage);

                    if (m1.find())
                    {
                        pass = m1.group(1);
                        //To remove white spaces from String pass
                        //passcode= pass.replaceAll("\\s+", "");
                        //System.out.println("Code :="+ passcode);
                        passcode= pass.replaceAll("[^a-zA-Z0-9]", "");


                    }
                }
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

        return passcode;

    }

}









