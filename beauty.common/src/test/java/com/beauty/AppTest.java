package com.beauty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.beauty.util.EncodeUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String pass = EncodeUtil.encryptPassword("123456");
		System.out.println(pass);

		String url1 = "http://localhost:8080/beauty/menu/load/main.action";
		String url = "http://localhost:8080/beauty/j_spring_security_check";
		HttpClient client = HttpClients.createDefault();
		// post 请求
		HttpPost post = new HttpPost(url);
		// 登陆参数
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("j_username", "admin"));
		formParams.add(new BasicNameValuePair("j_password", "123456"));
		if (!formParams.isEmpty()) {
			// 设置请求参数
			post.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
		}
		// 执行请求
		HttpResponse response = client.execute(post);
		System.out.println(EntityUtils.toString(response.getEntity()));
		while (true) {
			HttpGet get = new HttpGet(url1);
			response = client.execute(get);
			System.out.println(EntityUtils.toString(response.getEntity()));
		}

	}
}
