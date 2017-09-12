package com.mizeshuang.test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by mizeshuang on 2016/4/7.
 */
public class PipedIOTest {
    private static class send implements Runnable {
        private PipedOutputStream out=null;
        public send() {
            out=new PipedOutputStream();
        }
        public PipedOutputStream getOut() {
            return out;
        }
        String name="mizeshuang";
        @Override
        public void run() {
            try {
                out.write(name.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class recive implements Runnable {
        private PipedInputStream in=null;
        private int n;
        private byte[]b=new byte[1024];
        public recive() {
            in=new PipedInputStream();
        }

        public PipedInputStream getIn() {
            return in;
        }
        @Override
        public void run() {
            try {
                n=in.read(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(new String(b, 0, n));
        }
    }

    public static void main(String[] args) {
        send s=new send();
        recive r=new recive();
        try {
            s.getOut().connect(r.getIn());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t1=new Thread(s);
        Thread t2=new Thread(r);
        t1.start();
        t2.start();
    }
}
