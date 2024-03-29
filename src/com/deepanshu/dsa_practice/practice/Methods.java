package com.deepanshu.dsa_practice.practice;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Methods {
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

    public static void main(String[] args)
            throws IOException
    {
        StringBuilder series= new StringBuilder();
        Reader s = new Reader();
        for (int i = 0; i < 26; i++) {
            char ch=(char)('a'+i);
            series.append(ch);
        }
        System.out.println(series.toString());
//        int n = s.nextInt();
//        int k = s.nextInt();
//        int count = 0;
//        while (n-- > 0) {
//            int x = s.nextInt();
//            if (x % k == 0)
//                count++;
//        }
        String str="DEEPANSHU RAWAT";
        System.out.println(Arrays.toString(str.toCharArray()));
        System.out.println(str.toLowerCase());
        System.out.println(str);
        System.out.println(str.indexOf('A'));
        System.out.println(str.lastIndexOf('A'));
        System.out.println("    DEEPANSHU    ".strip());
        System.out.println(Arrays.toString(str.split(" ")));
//        System.out.println(count);
//        double a=s.nextDouble();
//        System.out.printf("The formatted string is %.3f",a);
//        System.out.println();
//        System.out.printf("Pie: %.3f",Math.PI);


//        System.out.println(name+",I'm currently a fresher in BTech CSE at UPES!");
//        a=a+" Rawat";
//        System.out.println(a);
//        System.out.println(b);
        //System.out.println(Objects.equals(a, b))
    }
}
