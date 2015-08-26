package MavenDemo.first;

import org.junit.Test;

import junit.framework.TestCase;

public class mytest extends TestCase {
	private static http http_test=new http();
	

	@Test
	public void test_http2(){
		assertEquals(200,http_test.request("http://www.baidu.com/1.html"));
	}

}
