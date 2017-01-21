package com.kdemo.gcm;
import java.io.IOException;

import org.junit.Test;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class TestGCM {

	@Test
	public void test() {
		
		Sender sender = new Sender("AIzaSyA5S_CxFWak7INwRFgMAMQhPB0wLhOFeQ4");
		Message message = new Message.Builder()
			    .collapseKey("1")
			    .timeToLive(3)
			    .delayWhileIdle(true)
			    .addData("message",
			            "Hello").build();
		
		String to = "APA91bFAtSN6TxlgzedhhEtYPZWmub4EC-2QDJYy2ee89osm6tt05C2tVDhjB-zSrPBGifx59Pf8_sK2cJmYqXTFrhO0t-9Otr5ikuaKpLSI5SNkisY04UZG2jiQD5dCm0Tcnc4mZ1Te";
		try {
			Result sendNoRetry = sender.sendNoRetry(message, to);
			System.out.println(sendNoRetry);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
