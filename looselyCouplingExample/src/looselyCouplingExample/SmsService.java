package looselyCouplingExample;

public class SmsService implements MessageService {

	@Override
	public void sendMessage(String message, String recipient) 
	{
		System.out.println("Email sent to " + recipient + " with message: " + message);
		
	}

}
