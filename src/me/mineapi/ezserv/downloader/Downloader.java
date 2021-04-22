package me.mineapi.ezserv.downloader;

import com.google.gson.Gson;
import me.mineapi.ezserv.Main;

import javax.net.ssl.*;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;

public class Downloader {
    public static void downloadSpigot(String version) {
        try {
            Gson gson = new Gson();

            Reader reader = new BufferedReader(new FileReader(Downloader.class.getResource("spigot.json").getFile()));

            SpigotVersion[] spigotVersions = gson.fromJson(reader, SpigotVersion[].class);

            for (SpigotVersion spigotVer : spigotVersions) {
                if (spigotVer.version.equals(version)) {
                    /*
                    Thanks Dash1e on StackOverflow!
                     */

                    TrustManager[] trustAllCerts = new TrustManager[]{
                            new X509TrustManager() {
                                @Override
                                public X509Certificate[] getAcceptedIssuers() {
                                    return null;
                                }

                                @Override
                                public void checkClientTrusted(X509Certificate[] certs, String authType) { }

                                @Override
                                public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                            }
                    };

                    try {
                        SSLContext sc = SSLContext.getInstance("SSL");
                        sc.init(null, trustAllCerts, new SecureRandom());
                        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(spigotVer.getUrl()).openStream());
                         FileOutputStream fileOutputStream = new FileOutputStream("./server/server.jar")) {
                            byte dataBuffer[] = new byte[1024];
                            int bytesRead;

                            while ((bytesRead = bufferedInputStream.read(dataBuffer, 0, 1024)) != -1) {
                                fileOutputStream.write(dataBuffer, 0, bytesRead);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadVanilla(String version) {
        try {
            Gson gson = new Gson();

            Reader reader = new BufferedReader(new FileReader(Downloader.class.getResource("vanilla.json").getFile()));

            VanillaVersion[] vanillaVersions = gson.fromJson(reader, VanillaVersion[].class);

            for (VanillaVersion vanillaVer : vanillaVersions) {
                if (vanillaVer.version.equals(version)) {
                    /*
                    Thanks Dash1e on StackOverflow!
                     */

                    TrustManager[] trustAllCerts = new TrustManager[]{
                            new X509TrustManager() {
                                @Override
                                public X509Certificate[] getAcceptedIssuers() {
                                    return null;
                                }

                                @Override
                                public void checkClientTrusted(X509Certificate[] certs, String authType) { }

                                @Override
                                public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                            }
                    };

                    try {
                        SSLContext sc = SSLContext.getInstance("SSL");
                        sc.init(null, trustAllCerts, new SecureRandom());
                        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(vanillaVer.getUrl()).openStream());
                         FileOutputStream fileOutputStream = new FileOutputStream("./server/server.jar")) {
                        byte dataBuffer[] = new byte[1024];
                        int bytesRead;

                        while ((bytesRead = bufferedInputStream.read(dataBuffer, 0, 1024)) != -1) {
                            fileOutputStream.write(dataBuffer, 0, bytesRead);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadPaper(String version) {
        try {
            Gson gson = new Gson();

            Reader reader = new BufferedReader(new FileReader(Downloader.class.getResource("vanilla.json").getFile()));

            PaperVersion[] paperVersions = gson.fromJson(reader, PaperVersion[].class);

            for (PaperVersion paperVer : paperVersions) {
                if (paperVer.version.equals(version)) {
                    /*
                    Thanks Dash1e on StackOverflow!
                     */

                    TrustManager[] trustAllCerts = new TrustManager[]{
                            new X509TrustManager() {
                                @Override
                                public X509Certificate[] getAcceptedIssuers() {
                                    return null;
                                }

                                @Override
                                public void checkClientTrusted(X509Certificate[] certs, String authType) { }

                                @Override
                                public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                            }
                    };

                    try {
                        SSLContext sc = SSLContext.getInstance("SSL");
                        sc.init(null, trustAllCerts, new SecureRandom());
                        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(paperVer.getUrl()).openStream());
                         FileOutputStream fileOutputStream = new FileOutputStream("./server/server.jar")) {
                        byte dataBuffer[] = new byte[1024];
                        int bytesRead;

                        while ((bytesRead = bufferedInputStream.read(dataBuffer, 0, 1024)) != -1) {
                            fileOutputStream.write(dataBuffer, 0, bytesRead);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
