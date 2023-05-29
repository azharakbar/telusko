package com.azhar.SpringApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class URLShortnerResponse {

    private String originalURL;

    private String shortURL;
}
