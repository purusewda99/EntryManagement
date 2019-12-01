import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.lang.System;

public class twiliosSndSms {
	public static final String ACCOUNT_SID =
            "ACc488155de3addc4317f3712b2685e317";
    public static final String AUTH_TOKEN =
            "074ac55abf7948f00775c57fdf70f023";

    public static void sendSMS(String number,String body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(number), // to
                        new PhoneNumber("+19384448701"), // from
                        body)
                .create();

        //System.out.println(message.getSid());
    }
	
}
