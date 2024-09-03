package com.mystore.utilities;

import java.util.Random;

public class RandomEmailGenerator {
	
	 String chart="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int leng_email=10;
	public String emailGenerator() {
		
		
		
		
		String domain="@gmail.com";
		StringBuilder email=new StringBuilder();
		Random random=new Random();
		
		
		for(int i=0;i<leng_email;i++) {
			int index=random.nextInt(chart.length());
			email.append(chart.charAt(index));
		}
		email.append(domain);
		return email.toString();
		
	}

}
