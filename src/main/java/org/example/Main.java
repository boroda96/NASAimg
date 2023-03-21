package org.example;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
//    public static final String url = "https://api.nasa.gov/planetary/apod?api_key=sB21wxCV036Go5UmcsQSNOiAbQb6PsiGQ23JgaBP";
//    public static final ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) throws TelegramApiException {
        MyTelegramBot telegramBot = new MyTelegramBot();
//        CloseableHttpClient httpClient = HttpClientBuilder.create()
//                .setDefaultRequestConfig(RequestConfig.custom()
//                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
//                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
//                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
//                        .build())
//                .build();
//        CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
//        //Scanner sc = new Scanner(response.getEntity().getContent());
//       // System.out.println(sc.nextLine());
//        NASA nasa = mapper.readValue(response.getEntity().getContent(), NASA.class);
//        System.out.println(nasa);
//
//        CloseableHttpResponse image = httpClient.execute(new HttpGet(nasa.getHdurl()));
//        String[] nasaArray = nasa.getHdurl().split("/");
//        String filName = nasaArray[nasaArray.length -1];
//
//
//        HttpEntity entity = image.getEntity();
//        if (entity != null) {
//            FileOutputStream fos = new FileOutputStream(filName);
//            entity.writeTo(fos);
//            fos.close();
//
//        }
    }
}