package com.azhar.SpringApp.services;

import com.azhar.SpringApp.dtos.URLShortnerPayload;
import com.azhar.SpringApp.dtos.URLShortnerResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class URLShortnerService {

    Map<String, String> urlMap = new HashMap<String, String>();

    final String URL_SHORT_DOMAIN = "http://telus.ko/";

    public URLShortnerResponse createShortUrl(URLShortnerPayload request) {
        String originalUrl = request.getUrl();
        String shortUrl;

        if (urlMap.containsKey(originalUrl)) {
            shortUrl = urlMap.get(originalUrl);
            return URLShortnerResponse
                    .builder()
                    .originalURL(originalUrl)
                    .shortURL(shortUrl)
                    .build();
        }

        shortUrl = doShortenURL(originalUrl);

        return URLShortnerResponse
                .builder()
                .originalURL(originalUrl)
                .shortURL(shortUrl)
                .build();
    }

    private String doShortenURL(String originalUrl) {
        String uuid = UUID.randomUUID().toString();

        String uniqueId;

        do {
            uniqueId = uuid.split("-", 0)[0];
        } while (urlMap.values().contains(uniqueId));

        String shortURL = URL_SHORT_DOMAIN + uniqueId;

        urlMap.put(originalUrl, shortURL);

        return shortURL;
    }

    public List<URLShortnerResponse> getShortURLs() {
        return urlMap
                .keySet()
                .stream()
                .map(key -> URLShortnerResponse
                        .builder()
                        .originalURL(key)
                        .shortURL(urlMap.get(key))
                        .build())
                .collect(Collectors.toList());
    }

}
