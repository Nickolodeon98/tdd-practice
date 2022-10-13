package api;

public class HttpClientGetMain {
    public static void main(String[] args) {
        HttpClientGet httpClientGet = new HttpClientGet("devU01TX0FVVEgyMDIyMTAxMzE1MDkwMzExMzA1MTY=");

        httpClientGet.get("https://www.juso.go.kr/addrlink/addrLinkUrl.do");
    }
}
