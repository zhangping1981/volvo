package com.example.demo.web.controller.view;


import lombok.Data;

@Data
public class PageView {

    private int page;
    private int size;
    private int total;
}
