package ch09.ex03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MultipleException {

    public void process() throws IOException {
        try {
            new FileInputStream("");
            InetAddress.getByName("");
        } catch (FileNotFoundException | UnknownHostException ex) {
            throw ex;
        }
    }

}
