# **Entry Management System** 

This is an entry management software which records the entry of visitors into a house. Whenever a visitor check-in, the host got an email or sms regarding the information of the visitor. Whenever a visitor check-out, the visitor got an email or sms regarding the information of their visit. This is designed using Java Swing for FrontEnd, Java for Backend, and MySQL for Database Service.

### Source file for code is purusewda99/EntryManagement/src

### Database file is purusewda99/EntryManagement/vdb

In **src** file, there are five classes present :-
1. **DbManager** -- Through this class, you can get a connection to mysql from java. It takes the help of a mysql connector **mysql-connector-java-8.0.13.jar** file.
2. **JavasendMail** -- This class is used for sending mail, JavaSendMail.sendMail(*String recipient_email*,*String subject*,*String body*); that’s it. And it sends an email to recipient email having subject and body. Here we are using **JavaMail API** again as a **javax.mail.jar** file.
3. **System.java** -- This class displays the FrontEnd of the system. It is built using Java Swing. In this class, we defined all the buttons, text fields, labels, etc. Here we have defined an object of JTable in-built class of Java Swing, which shows the database of visitors to the user.
4. **VisitorClass** -- This class defines the attributes of the visitor. There is a method defined here addVisitor() which adds the details of a visitor to the database.
5. **twiliosSndSms** -- This class is used for sending sms. But do not work beacuse we needed a valid twilio account. I can't risk of exposing the details of my twilio account due to security reasons. That's why i have commented the line 262 and line 290 in System.java from which you can snd messages. And I have also removed account details and authetication details from twiliosSndSms.java because of security reasons. To send an SMS, our application makes an HTTP POST request to twilio and twilio sends a text message. To use twilio, we have a **twilio-7.9.1-jar-with-dependencies.jar** file.

In **vdb** database, there is an table **visitor** which stores the details of the visitor.
