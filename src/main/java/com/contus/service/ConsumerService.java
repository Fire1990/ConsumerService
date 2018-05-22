package com.contus.service;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Component
public class ConsumerService {
	
	@Value("${http_url}")
	private String httpUrl;
	
	@Value("${user_key}")
	private String key;
	
	@Value("${user_value}")
	private String value;
	
	@Value("${get_url}")
	private  String getUrl;
	
	@Value("${post_url}")
	private  String postUrl;
	
	@Value("${delete_url}")
	private  String deleteUrl;
	
	@Value("${put_url}")
	private  String putUrl;
	
	public  void test(String host,String port) {
		ConsumerService s=new ConsumerService();
		Client client=Client.create();
		String url=httpUrl+host+":"+port;
		WebResource resource=client.resource(url);
		ClientResponse clientResponse=(ClientResponse) resource.get(ClientResponse.class);
		String msg=(String) clientResponse.getEntity(String.class);
		System.out.println(msg);
	}
	public  void get(String host,String port) {
		Client client=Client.create();
		String url=httpUrl+host+":"+port+getUrl;
		WebResource web=client.resource(url);
		ClientResponse response=web.header(key,value).get(ClientResponse.class);
		String message=response.getEntity(String.class);
		System.out.println(message);
	}
	public  void post(String host,String port) {
		Client client=Client.create();
		String url=httpUrl+host+":"+port+postUrl;
		String data="{\"truckDriverName\": \"jagan\",\"truckDriverAddress\":\"gwl\",\"truckDriverContact\": \"236\"}";
		WebResource web=client.resource(url);
		ClientResponse response=web.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, data);
		String message=response.getEntity(String.class);
		System.out.println(message);
	}
	public  void delete(String host,String port) {
		Client client=Client.create();
		String url=httpUrl+host+":"+port+deleteUrl;
		WebResource web=client.resource(url);
		ClientResponse response=web.delete(ClientResponse.class);
		String message=response.getEntity(String.class);
		System.out.println(message);
	}
	public  void put(String host,String port) {
		Client client=Client.create();
		String url=httpUrl+host+":"+port+putUrl;
		String data="{\"truckDriverId\":\"6\",\"truckDriverName\": \"jagan\",\"truckDriverAddress\":\"gwl\",\"truckDriverContact\": \"236\"}";
		WebResource web=client.resource(url);
		ClientResponse response=web.type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, data);
		String message=response.getEntity(String.class);
		System.out.println(message);
	}

}
