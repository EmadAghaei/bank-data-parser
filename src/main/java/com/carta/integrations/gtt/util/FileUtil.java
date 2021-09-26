package com.carta.integrations.gtt.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
    private static final Logger LOG = Logger.getLogger(FileUtil.class.toString());

    public static List<String>  readTxtFile(String file) {
//        try (Stream<String> lines = Files.lines(Paths.get(file), Charset.defaultCharset())) {
        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "error in parsing GTT Bank file");
            e.printStackTrace();
        }
        return null;
    }
}
