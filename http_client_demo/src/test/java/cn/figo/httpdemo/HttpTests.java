package cn.figo.httpdemo;

import cn.figo.httpdemo.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author Figo
 * @Date 2020/1/18 20:20
 */
public class HttpTests {

    CloseableHttpClient httpClient;

    // 序列化与反序列化
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Before
    public void init() {
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void testGet() throws IOException {
        HttpGet request = new HttpGet("http://www.baidu.com/s?ie=UTF-8&wd=java");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
    }

    @Test
    public void testPost() throws IOException {
        HttpPost request = new HttpPost("https://www.oschina.net/");
        request.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
    }

    @Test
    public void testGetPojo() throws IOException {
        HttpGet request = new HttpGet("http://localhost:8888/user/42");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
        // 将json字符串序列化为 bean
        User user = MAPPER.readValue(response, User.class);
        System.out.println(user);
        // 将bean反序列化为json字符串
        String usertToString = MAPPER.writeValueAsString(user);
        System.out.println(usertToString);
    }
}
