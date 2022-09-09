package com.deepanshu;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static java.lang.System.out;


public class RECURSION {
    final int inf = (int) 1e9 + 9;
    final long biginf  = (long)1e18 + 7 ;
    final long mod =  (long)1e9+7;
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

            public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    long pow(long a, long b) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) result = (result * a) % mod;
            b /= 2;
            a = (a * a) % mod;
        }
        return result;
    }
    long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main (String[] args) throws IOException
    {
        Main.Reader sc=new Main.Reader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n=sc.nextInt();
//        out.println(n);
//        int a=sc.nextInt();
//        System.out.println(a);
//        long n=sc.nextLong();
//        long sum=0;
//        for(long i=1;i<=n-1;i++) {
//            long x = sc.nextLong();
//            sum += x;
//        }
        print(n);
        out.flush(); // if you want to force the output use flush
        out.close();// don't forget to close the PrintWriter

        // your code goes here
    }
    static void print(int n){
        if(n>5){
            return;
        }
        out.println(n);
        print(n+1);
//        this is called Tail Recursion
        //this is the last function call and the executing part of each function is done before the recursive function call

    }
}
