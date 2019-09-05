package common;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author ceshi_chen
 * @version $Id: HttpUtils,  2019/9/5 18:23 ceshi_chen Exp$
 */
public class HttpUtils {
    static OkHttpClient client = null;
    static Headers headers = null;
    static {
        client = new OkHttpClient();
    }

    /**
     *http  Get 请求
     * @param url
     * @return
     * @throws IOException
     */
    public static String httpGet(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        return getHttpGet(request);
    }

    private static String getHttpGet(Request request) throws IOException {
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            return response.body().string();
        }

        return "返回的状态码: " + response.code();
    }

    /**
     * http 带header 的 get 请求
     * @param url
     * @param header
     * @return
     * @throws IOException
     */
    public static String httpGet(String url, Map<String, String> header) throws IOException {
        headers = Headers.of(header);
        Request request = new Request.Builder().url(url).headers(headers).build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            return response.body().string();
        }

        return "返回的状态码:" + response.code();
    }

    /**
     *
     * @param url
     * @param header
     * @return
     * @throws IOException
     */
    public static String httpGet1(String url, Map<String, String> header) throws IOException {
//		headers = Cookie.parse(url, setCookie)
        Request request = new Request.Builder().url(url).headers(headers).build();
        return getHttpGet(request);
    }


    /**
     * 带header的http请求  post
     * @param url
     * @param header
     * @param json
     * @return
     */
    public static String httpPost(String url, Map<String, String> header, JSONObject json) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json.toString());
        return getHttpPost(url, header, body);

    }

    private static String getHttpPost(String url, Map<String, String> header, RequestBody body) {
        headers = Headers.of(header);
        Request request = new Request.Builder().url(url).headers(headers).post(body).build();
        Response response = null;
        String value = "";
        try {
            response = client.newCall(request).execute();
            value = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("返回的状态码:" + response.code());
        }

        return value;
    }

    /**
     *http post 请求不带header
     * @param url
     * @param json
     * @return
     */
    public static String httpPost(String url, JSONObject json) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .build();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = null;
        String value = "";
        try {
            response = client.newCall(request).execute();
            value = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("返回的状态码::" + response.code());
        }
        return value;

    }

    /**
     *拼接参数的get请求
     * @param url
     * @param params
     * @return
     */
    public static String attachHttpGetParams(String url, LinkedHashMap<String, String> params) {

        Iterator<String> keys = params.keySet().iterator();
        Iterator<String> values = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");

        for (int i = 0; i < params.size(); i++) {
            String value = null;
            try {
                value = URLEncoder.encode(values.next(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

            stringBuffer.append(keys.next() + "=" + value);
            if (i != params.size() - 1) {
                stringBuffer.append("&");
            }

        }

        return url + stringBuffer.toString();
    }


}
