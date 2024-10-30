package main.Processor;

import java.util.Scanner;

public class Cli {
    private Scanner cliInput;
    private String cmd = "";
    private String flag = "";
    private String fileName = "";

    public Cli(Scanner cliInput) {
        this.cliInput = cliInput;
    }

    public void parseInput() {
        try {
            String[] tokens = cliInput.findInLine("(ccwc)(\\s+)?(-[clmw])? (\\w+\\.txt)").split(" ");
            for (int index = 0; index < tokens.length; index++) {
                if (tokens[index].equals("ccwc")) {
                    cmd = tokens[index];
                } else if (tokens[index].equals("-c") || tokens[index].equals("-m") || tokens[index].equals("-l") || tokens[index].equals("-w")) {
                    flag = tokens[index];
                } else if (tokens[index].matches("(\\w+)(\\.)(txt)")) {
                    fileName = tokens[index];
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Scanner getCliInput() {
        return cliInput;
    }

    public void setCliInput(Scanner cliInput) {
        this.cliInput = cliInput;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}