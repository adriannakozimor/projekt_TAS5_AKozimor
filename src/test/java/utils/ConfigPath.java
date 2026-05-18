package utils;

import java.nio.file.Path;

public class ConfigPath {
    public static final String IMAGE_ERROR_PATH =
            Path.of(System.getProperty("user.dir"), "target", "screenshots", "errors").toString() + "/";    }

