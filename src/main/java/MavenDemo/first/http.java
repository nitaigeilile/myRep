package MavenDemo.first;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import java.util.Scanner;

@SuppressWarnings("deprecation")
public class http {
	//HttpClient 代表Http客户端
	//HttpEntity 消息载体,发送或者接收消息的载体,可以通过客户端请求或者服务器响应获取实例 
	//HttpConnection 代表http连接  
	/** 
	 * @param args 
	 */  
	public static void main(String[] args) {
	    //创建默认的客户端实例
		HttpClient httpClient = new DefaultHttpClient();
		
		// 创建get请求实例
		Scanner s=new Scanner(System.in);
		String str=null;
		System.out.println("Please input the website!");
		str=s.next();
		System.out.println(request(str));
		
	}
	
	public static int request(String str){
		HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(str); 
        int status=-1;
		
		System.out.println("executing request"+httpget.getURI());
		
		try
		{
			
			//客户端执行get请求 返回响应实体
			HttpResponse response=httpClient.execute(httpget);
			status=response.getStatusLine().getStatusCode();
			
			//服务器响应状态行
			//System.out.println(response.getStatusLine().getStatusCode());
			
		}catch(ClientProtocolException e){
			e.printStackTrace();
	    }catch(IOException e){
	    	e.printStackTrace();
	    }finally{
	    	httpClient.getConnectionManager().shutdown();
		}
		return status;
	}

}