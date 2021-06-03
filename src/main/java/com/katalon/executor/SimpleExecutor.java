package com.katalon.executor;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;

import com.katalon.executor.constants.ExecutorArgument;
import com.katalon.executor.utils.OsUtils;

public class SimpleExecutor {
    private final static Logger logger = Logger.getLogger(SimpleExecutor.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        Options options = new Options();

        Arrays.stream(ExecutorArgument.values()).forEachOrdered(arg -> {
            Option input = new Option(arg.shortName, arg.name(), arg.hasArg, arg.description);
            input.setRequired(arg.isRequired);
            options.addOption(input);
        });

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException error) {
            logger.log(Level.SEVERE, error.getMessage());
            formatter.printHelp("Katalon Simple Executor", options);
            System.exit(1);
        }

        String kreDir = cmd.getOptionValue(ExecutorArgument.kre.name());
//        kreDir = "C:\\Users\\thongnmtran\\Desktop\\KRE-8.0.1\\Katalon_Studio_Engine_Windows_64-8.0.1";

        String katalonCommand = cmd.getOptionValue(ExecutorArgument.command.name());
//        katalonCommand = "katalonc -noSplash -runMode=console -projectPath=\"C:\\Users\\thongnmtran\\Desktop\\Samples\\Web 03\\test.prj\" -retry=0 -testSuitePath=\"Test Suites/TS_RegressionTest\" -executionProfile=\"default\" -browserType=\"Chrome\" -apiKey=\"36208c97-ecee-44ff-8373-4e3270e7e7d0\" --config -webui.autoUpdateDrivers=true";

        String x11DisplayArg = cmd.getOptionValue(ExecutorArgument.x11Display.name());
        String x11Display = StringUtils.defaultString(x11DisplayArg, ExecutorArgument.x11Display.defaultValue);

        String xvfbConfigurationArg = cmd.getOptionValue(ExecutorArgument.xvfbConfiguration.name());
        String xvfbConfiguration = StringUtils.defaultString(xvfbConfigurationArg, ExecutorArgument.xvfbConfiguration.defaultValue);

        System.exit(OsUtils.runCommand(kreDir, katalonCommand, x11Display, xvfbConfiguration));
    }

}
