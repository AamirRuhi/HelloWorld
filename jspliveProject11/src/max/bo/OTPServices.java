package max.bo;

import java.util.Random;

public class OTPServices {

	public String generateOTP(String mobile)
	{
		if(mobile.length()==10)
		{
			return generate();
		}
		return "invlid";
	}
	
	
	private String generate()
	{
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<=9;i++)
		{
			sb.append(new Random().nextInt(10));
		}
		return sb.substring(5);
	}
	
}
