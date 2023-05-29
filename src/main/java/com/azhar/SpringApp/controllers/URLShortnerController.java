package com.azhar.SpringApp.controllers;

import com.azhar.SpringApp.dtos.URLShortnerPayload;
import com.azhar.SpringApp.dtos.URLShortnerResponse;
import com.azhar.SpringApp.services.URLShortnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/url-shortner")
public class URLShortnerController {

    private final URLShortnerService urlShortnerService;

    @PostMapping("create")
    public URLShortnerResponse createShortUrl(@RequestBody URLShortnerPayload request) {
        return urlShortnerService.createShortUrl(request);
    }

    @GetMapping("list")
    public List<URLShortnerResponse> getShortsURLs() {
        return urlShortnerService.getShortURLs();
    }
}
