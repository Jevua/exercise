package com.example.exercise.WordToPDF;

import java.io.File;
import java.io.IOException;

public class TestTransfer {
    //官网：www.xdocin.com
    public static void main(String[] args) {
        XDocService service = new XDocService();
        try {
            service.to("x:/日常.docx", new File("x:/日常.pdf"));
            System.out.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
