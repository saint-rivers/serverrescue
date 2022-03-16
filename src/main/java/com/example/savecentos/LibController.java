package com.example.savecentos;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class LibController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getLib() {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
//        String tmp = "/liblber-2.4.so.2";
        String tmp = dir + File.separator + "liblber-2.4.so.2";
//        InputStream in = getClass().getResourceAsStream(tmp);
        try {
            File path = new File(tmp);
            return method(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "not working".getBytes();
    }

    public static byte[] method(File file) throws IOException {

        // Creating an object of FileInputStream to
        // read from a file
        FileInputStream fl = new FileInputStream(file);

        // Now creating byte array of same length as file
        byte[] arr = new byte[(int) file.length()];

        // Reading file content to byte array
        // using standard read() method
        fl.read(arr);

        // lastly closing an instance of file input stream
        // to avoid memory leakage
        fl.close();

        // Returning above byte array
        return arr;
    }
}
