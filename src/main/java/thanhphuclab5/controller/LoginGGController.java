package thanhphuclab5.controller;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import thanhphuclab5.entity.Constants;
import thanhphuclab5.entity.Root;

//@RestController
@Controller
public class LoginGGController {
	
//	@GetMapping("logingg")
//	public Map<String, Object> currentUser(OAuth2AuthenticationToken auth2AuthenticationToken){
//	    Map<String, Object> attributes = auth2AuthenticationToken.getPrincipal().getAttributes();
//	    String name = (String) attributes.get("name");
//	    String email = (String) attributes.get("email");
//	    System.out.println(name);
//	    return attributes;
//	}
	
	@GetMapping("logingg")
	public void currentUser(OAuth2AuthenticationToken auth2AuthenticationToken, @RequestParam("code") String code) throws ClientProtocolException, IOException{
//	    Map<String, Object> attributes = auth2AuthenticationToken.getPrincipal().getAttributes();
//	    String name = (String) attributes.get("name");
//	    String email = (String) attributes.get("email");
//	    System.out.println(name);
//	    return attributes;
		System.out.println("COde: "+code);
		String token = getToken(code);
		Root root = getUserInfo(token);
		System.out.println(root);
	}
	
	@GetMapping("viewgg")
	public String viewGG() {
		return"testlogin";
	}
	
	public static String getToken(String code) throws ClientProtocolException, IOException {
		String respose = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
							.add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
							.add("redirect_uri", Constants.GOOGLE_REDIRECT_URL).add("code", code)
							.add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();
		
		JsonObject jsonObject = new Gson().fromJson(respose, JsonObject.class);
		String accessToken = jsonObject.get("access_token").toString().replaceAll("\"", "");
		return accessToken; 
	}
	
	public static Root getUserInfo(String accesToken) throws ClientProtocolException, IOException {
		String link = Constants.GOOGLE_LINK_GET_USER_INFO+ accesToken;
		String respose = Request.Get(link).execute().returnContent().asString();
		System.out.println("repose: "+respose);
		Root root = new Gson().fromJson(respose, Root.class);
		///dsjdhsjhdjsh
		return root;
	}
}
