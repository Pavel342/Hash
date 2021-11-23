package com.kript;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws  NoSuchAlgorithmException, IOException {
	    System.out.println("Введите секретное сообщение");
	    Scanner in=new Scanner(System.in);
	    String text1="Top sicret dannie";
        String text2="Tor sicret dannie";
        String text3="Top secret dannie";
        byte[] tt1=text1.getBytes(StandardCharsets.UTF_8);
        byte[] tt2=text2.getBytes(StandardCharsets.UTF_8);
        byte[] tt3=text3.getBytes(StandardCharsets.UTF_8);
        Security.addProvider(new BouncyCastleProvider());
	    String vvod=in.nextLine();
	    byte[] inputMessage=vvod.getBytes(StandardCharsets.UTF_8);
	    final String[] codirovky={ "GOST3411", "RIPEMD320", "MD5", "SHA256",
                "RIPEMD128", "RIPEMD160", "SHA512", "SHA384", "RIPEMD256", "SHA224"};
        BufferedReader br1 = new BufferedReader(new FileReader("Lab5/src/com/min.txt"));
        String fil1=br1.readLine();
        BufferedReader br2 = new BufferedReader(new FileReader("Lab5/src/com/sredniy.txt"));
        String fil2=br2.readLine();
        BufferedReader br3 = new BufferedReader(new FileReader("/Fluter cours/1/1. Dart. Основы/[BOOMINFO.RU] lesson_01.dart.basics.pdf"));
        String fil3=br3.readLine();
        byte[] filebytecode1=fil1.getBytes(StandardCharsets.UTF_8);
        byte[] filebytecode2=fil2.getBytes(StandardCharsets.UTF_8);
        byte[] filebytecode3=fil3.getBytes(StandardCharsets.UTF_8);
	    for(String cod : codirovky){
	        System.out.println(cod);
            MessageDigest md = MessageDigest.getInstance(cod);
            byte[] resultHash = md.digest(inputMessage);
            System.out.println( new String(Hex.encode(resultHash)));
            resultHash = md.digest(inputMessage);
            System.out.println( new String(Hex.encode(resultHash)));
            resultHash = md.digest(inputMessage);
            System.out.println( new String(Hex.encode(resultHash)));
            resultHash = md.digest(tt1);
            System.out.println( new String(Hex.encode(resultHash)));
            resultHash = md.digest(tt2);
            System.out.println( new String(Hex.encode(resultHash)));
            resultHash = md.digest(tt3);
            System.out.println( new String(Hex.encode(resultHash)));
            resultHash = md.digest(filebytecode1);
            System.out.println( new String(Hex.encode(resultHash)));
            resultHash = md.digest(filebytecode2);
            System.out.println( new String(Hex.encode(resultHash)));
            resultHash = md.digest(filebytecode3);
            System.out.println( new String(Hex.encode(resultHash)));

        }
    }
}
