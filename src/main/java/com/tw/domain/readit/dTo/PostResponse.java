package com.tw.domain.readit.dTo;

public record PostResponse(int id,
                           String author,
                           String title,
                           String date,
                           String content) {
}
