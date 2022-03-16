package com.example.savecentos;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class LibController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> getLib() {
        String tmp = "/lib64/liblber-2.4.so.2";
        String filename = "/home/saintrivers/howToStartNetwork.txt";
        InputStream in = getClass().getResourceAsStream(tmp);
        try {
            assert in != null;
            return ResponseEntity.ok(in.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
