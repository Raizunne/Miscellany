/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.handler;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckVeneer {

	public static boolean checkerino(String name) throws Exception{
		int timeout = 10000;
        URL url = new URL("https://raw.githubusercontent.com/Raizunne/Miscellany/master/Donors.txt");
        URLConnection text = url.openConnection();
        text.setConnectTimeout(timeout);
        text.setReadTimeout(timeout);
        
		@SuppressWarnings("resource")
		Scanner scannerino = new Scanner(text.getInputStream());
		List<String> list = new ArrayList<String>();

		while(scannerino.hasNextLine()){
			list.add(scannerino.nextLine());
		}
//		System.out.println("Updating List for Miscellany dontors");
//		System.out.println(list);
		if(list.contains(name)){
			return true;
		}else{
			return false;
		}
	}
	
}
