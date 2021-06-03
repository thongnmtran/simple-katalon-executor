package com.katalon.executor.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class OsUtils {
    private final static Logger logger = Logger.getLogger(OsUtils.class.getName());

    public static int runCommand(String workingDir, final String command, String x11Display, String xvfbConfiguration)
            throws IOException, InterruptedException {

        String[] commands;
        if (SystemUtils.IS_OS_WINDOWS) {
            commands = Arrays.asList("cmd", "/c", command).toArray(new String[] {});
        } else {
            String runCommand = "";
            if (!StringUtils.isBlank(x11Display)) {
                runCommand = "DISPLAY=" + x11Display + " " + command;
            }
            if (!StringUtils.isBlank(xvfbConfiguration)) {
                runCommand = "xvfb-run " + xvfbConfiguration + " " + command;
            }
            List<String> cmdlist = Arrays.asList("sh", "-c", runCommand);
            commands = cmdlist.toArray(new String[] {});
        }

        logger.info("Execute " + Arrays.toString(commands) + " in " + workingDir);

        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        processBuilder.directory(new File(workingDir));
        processBuilder.redirectErrorStream(true);
        try {
            Process process = processBuilder.start();
            InputStreamReader inputStream = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
            try (BufferedReader reader = new BufferedReader(inputStream)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                try {
                    process.waitFor();
                } catch (InterruptedException error) {
                    error.printStackTrace();
                }
                return process.exitValue();
            }
        } catch (IOException error) {
            return -1;
        }
    }
}
