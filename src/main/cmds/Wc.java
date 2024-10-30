package main.cmds;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Wc {
    private String fileName;
    private String flag;
    StringBuilder sb = new StringBuilder();
    private long numOfLines = 0;

    public Wc(String flag, String fileName) {
        this.flag = flag;
        this.fileName = fileName;
    }

    private void readFile(){
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\"+fileName))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                numOfLines++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found in resources directory. Please Put File in appropriate Directory. Stack trace: ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String processFlag() {
        readFile();
        if (flag.equals("-c")) {
            return getNumOfBytes();
        } else if (flag.equals("-l")) {
            return getNumOfLines();
        } else if (flag.equals("-m")) {
            return getNumOfChars();
        } else if (flag.equals("-w")) {
            return getNumOfWords();
        } else if (flag.isEmpty()) {
            return getNumOfWords() + " " + getNumOfChars() + " " + getNumOfLines() + " " + getNumOfBytes();
        }
        return "invalid flag";
    }

    private String getNumOfChars() {
        return String.valueOf(sb.toString().length());
    }
// was not worth the trade off
    private String getNumOfWords() {
        return String.valueOf(sb.toString().split("\\s+").length);
    }
// better to get num of lines when reading file. No point to do it again. Since there is not a tradeoff
    private String getNumOfLines() {
        return String.valueOf(numOfLines);
    }
// was not worth the trade off
    private String getNumOfBytes() {
        return String.valueOf(sb.toString().getBytes().length);
    }


}
