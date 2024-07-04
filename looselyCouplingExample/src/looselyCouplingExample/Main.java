package looselyCouplingExample;

public class Main 
{
	 public static void main(String[] args) {
	        
	        MessageService emailService = new EmailService();
	        
	        NotificationService notificationService = new NotificationService(emailService);
	        
	        notificationService.notify("Hello, Email!", "email@example.com");

	        // Injecting SmsService dependency
	        MessageService smsService = new SmsService();
	        
	        NotificationService anotherNotificationService = new NotificationService(smsService);
	        
	        anotherNotificationService.notify("Hello, SMS!", "123-456-7890");
	    }

}
