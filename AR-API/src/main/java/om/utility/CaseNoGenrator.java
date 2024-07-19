package om.utility;

import java.security.SecureRandom;

public class CaseNoGenrator 
{
	 public static String genCaseNo(Integer length) {
		
		int arr[]= {1,2,3,4,5,6,7,8,9};
		
		SecureRandom random=new SecureRandom();
		
		StringBuilder s=new StringBuilder(length);
		
		for(int i=1;i<=length;i++) {
			int randomNumber=random.nextInt(arr.length);
			s.append(randomNumber);
		}
		return s.toString();
	}
	

}
