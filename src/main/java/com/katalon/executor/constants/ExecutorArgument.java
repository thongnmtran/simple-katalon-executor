package com.katalon.executor.constants;

public enum ExecutorArgument {
    kre("KRE installation folder", true),
    command("Katalon Command", true),
    x11Display("This value will be used as the \"DISPLAY\" environment variable. (e.g. :1)", ":1", "d"),
    xvfbConfiguration("e.g. \"-a -n 0 -s \"-screen 0 1024x768x24\"\"", "-a -n 0 -s \"-screen 0 1024x768x24\"", "x");

    private ExecutorArgument() {
        this.hasArg = true;
        this.shortName = this.name().substring(0, 1).toLowerCase();
    }

    private ExecutorArgument(String description) {
        this();
        this.description = description;
    }

    private ExecutorArgument(String description, boolean isRequired) {
        this(description);
        this.isRequired = isRequired;
    }

    private ExecutorArgument(String description, String defaultValue) {
        this(description);
        this.defaultValue = defaultValue;
    }

    private ExecutorArgument(String description, String defaultValue, String shortName) {
        this(description, defaultValue);
        this.shortName = shortName;
    }

    public boolean hasArg;

    public boolean isRequired;

    public String shortName;

    public String description;

    public String defaultValue;
}
