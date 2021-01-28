package algo4.utils.In;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.Socket;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class In{

    private static final String CHARSET_NAME = "UTF-8";
    private static final Locale LOCALE = Locale.CHINA;

    private Scanner scanner;


    public In(){
        scanner = new Scanner(new BufferedInputStream(System.in),CHARSET_NAME);
        scanner.useLocale(LOCALE);
    }

    public In(String name) {
        if (name == null) {
            throw new IllegalArgumentException("参数为空");

        }
        if (name.length() == 0){
            throw new IllegalArgumentException("传入的是空字符串");
            
        }
        try{
            File file = new File(name);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis),CHARSET_NAME);
                scanner.useLocale(LOCALE);
                return;

            }
            URL url = getClass().getResource(name);

            if (url == null) {
                url = getClass().getClassLoader().getResource(name);

            }
            if (url == null) {
                url = new URL(name);

            }
            URLConnection site = url.openConnection();

            InputStream is = site.getInputStream();
            scanner = new Scanner(new BufferedInputStream(is),CHARSET_NAME);
            scanner.useLocale(LOCALE);

        }catch(IOException ioe) {
            throw new IllegalArgumentException("无法打开"+name,ioe);
        }
    }

    public int[] readAllInts(){
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0;i < fields.length;i++){
            vals[i] = Integer.parseInt(fields[i]);
        }
    }
    
    public static int[] readInts(String filename){
        return new In(filename).readAllInts();

    }

}
