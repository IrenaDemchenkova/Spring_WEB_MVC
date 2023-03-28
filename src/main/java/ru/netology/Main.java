package ru.netology;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;
import java.nio.file.Files;

public class Main {

    private static final int PORT = 9999;
    private static final String DIRECTORY_NAME = "tomcat";
    private static final String APP_BASE = ".";
    private static final String CONTEXT_PATH = "";
    private static final String DOC_BASE = ".";

    public static void main(String[] args) throws IOException, LifecycleException {
        final var tomcat = new Tomcat();
        final var baseDir = Files.createTempDirectory(DIRECTORY_NAME);
        baseDir.toFile().deleteOnExit();
        tomcat.setBaseDir(baseDir.toAbsolutePath().toString());

        final var connector = new Connector();
        connector.setPort(PORT);
        tomcat.setConnector(connector);

        tomcat.getHost().setAppBase(".");
        tomcat.addWebapp(CONTEXT_PATH, DOC_BASE);

        tomcat.start();
        tomcat.getServer().await();
    }
}