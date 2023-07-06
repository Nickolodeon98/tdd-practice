//package api;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.BasicResponseHandler;
//import org.apache.http.impl.client.HttpClientBuilder;
//
//public class HttpClientGet {
//    private String key;
//
//    public HttpClientGet(String key) {
//        this.key = key;
//    }
//
//    public void get(String requestURL) {
//        try {
//            HttpClient client = HttpClientBuilder.create().build();
//            HttpGet getRequest = new HttpGet(requestURL);
//            getRequest.addHeader("api-key", key);
//
//            HttpResponse response = client.execute(getRequest);
//
//            if (response.getStatusLine().getStatusCode() == 200) {
//                ResponseHandler<String> handler = new BasicResponseHandler();
//                String body = handler.handleResponse(response);
//                System.out.println(body);
//            } else {
//                System.out.println("응답 오류입니다: " + response.getStatusLine().getStatusCode());
//            }
//
//        } catch (ClientProtocolException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
