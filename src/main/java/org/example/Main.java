package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String url = "https://api.nasa.gov/planetary/apod?api_key=sB21wxCV036Go5UmcsQSNOiAbQb6PsiGQ23JgaBP";
    public static final ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();
        CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
        //Scanner sc = new Scanner(response.getEntity().getContent());
       // System.out.println(sc.nextLine());
        NASA nasa = mapper.readValue(response.getEntity().getContent(), NASA.class);
        System.out.println(nasa);

        CloseableHttpResponse image = httpClient.execute(new HttpGet(nasa.getHdurl()));
        String[] nasaArray = nasa.getHdurl().split("/");
        String filName = nasaArray[nasaArray.length -1];


        HttpEntity entity = image.getEntity();
        if (entity != null) {
            FileOutputStream fos = new FileOutputStream(filName);
            entity.writeTo(fos);
            fos.close();

        }
    }
}