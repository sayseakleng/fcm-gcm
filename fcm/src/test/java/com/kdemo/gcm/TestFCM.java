package com.kdemo.gcm;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.commons.codec.Charsets;
import org.junit.Test;

import de.bytefish.fcmjava.client.FcmClient;
import de.bytefish.fcmjava.client.settings.PropertiesBasedSettings;
import de.bytefish.fcmjava.model.options.FcmMessageOptions;
import de.bytefish.fcmjava.requests.notification.NotificationPayload;
import de.bytefish.fcmjava.requests.notification.NotificationUnicastMessage;
import de.bytefish.fcmjava.responses.FcmMessageResponse;

public class TestFCM {

	@Test
	public void testMobile() throws URISyntaxException {
		
		URL resource = TestFCM.class.getResource("/fcmjava.properties");
		Path path = Paths.get(resource.toURI());
		FcmClient client = new FcmClient(
        		PropertiesBasedSettings.createFromFile(path, Charsets.UTF_8));

        // Message Options:
        FcmMessageOptions options = FcmMessageOptions.builder()
                .setTimeToLive(Duration.ofHours(1))
                .build();

        // Send a Message:
        String token = "APA91bFAtSN6TxlgzedhhEtYPZWmub4EC-2QDJYy2ee89osm6tt05C2tVDhjB-zSrPBGifx59Pf8_sK2cJmYqXTFrhO0t-9Otr5ikuaKpLSI5SNkisY04UZG2jiQD5dCm0Tcnc4mZ1Te";
        
        FcmMessageResponse send = client.send(new NotificationUnicastMessage(options, token, 
        		new NotificationPayload("test", "xx", null, null, "2",
        				null, null, null, null, 
        				null, "titleLocKey", null)));
        

        System.out.printf("Number of success: %s%n", send.getNumberOfSuccess());
        System.out.printf("Message Id: %s%n", send.getMessageId());
        System.out.printf("Error code: %s%n", send.getResults().get(0).getErrorCode());
        
	}
	
	@Test
	public void testWeb() throws URISyntaxException {
		
		URL resource = TestFCM.class.getResource("/fcmjava.properties");
		Path path = Paths.get(resource.toURI());
		FcmClient client = new FcmClient(
        		PropertiesBasedSettings.createFromFile(path, Charsets.UTF_8));

        // Message Options:
        FcmMessageOptions options = FcmMessageOptions.builder()
                .setTimeToLive(Duration.ofHours(1))
                .build();

        // Send a Message:
        String token = "eS-YYfT_7e8:APA91bFHAq_Yms84yhgTdCZjThqwMtCwy5wXrgBgTFGw7wQffRqO7-U2dj8a7H5BJ2Y5ohx-iDTkhwisWmn7VIT05X_D9lbIIKB6zmVlnwiCTpbeS6JHq0lewjWE_DHwxTD1DVSg9RTI";
        
        FcmMessageResponse send = client.send(new NotificationUnicastMessage(options, token, 
        		new NotificationPayload("Lifeon", "There is a new product", "https://shop.lifeon.com.kh/template/base/resources/images/logo_lifeon.png",
        				null, null, null, null, 
        				"http://localhost:8080/fcm/static/fcm.html", 
        				null, null, null, null)));
        

        System.out.printf("Number of success: %s%n", send.getNumberOfSuccess());
        System.out.printf("Message Id: %s%n", send.getMessageId());
        System.out.printf("Error code: %s%n", send.getResults().get(0).getErrorCode());
        
	}
}
