import cmds.Wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.MatchResult;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {




    public static void main(String[] args) {
        //TODO create a prompt on console that will active when input from args is "ccwc -c"
        // We should also have a key that will exit from the prompt in console
        // There should be a class that will handle the text count for files

        // get user input here
        try {
            Scanner in = new Scanner(System.in);
            in.findInLine("(ccwc) (-c) (\\w+\\.txt)");
            MatchResult matchResult = in.match();
            String cmd = "";
            String flag = "";
            String fileName = "";
            byte[] numOfBytesInFile;
            long numOfBytes;
            if (matchResult.groupCount() == 3) {
                for (int index = 0; index <= matchResult.groupCount(); index++) {
                    if (matchResult.group(index).equals("ccwc")) {
                        cmd = matchResult.group(index);
                    } else if (matchResult.group(index).equals("-c")) {
                        flag = matchResult.group(index);
                    } else if (matchResult.group(index).matches("(\\w+)(\\.)(txt)")) {
                        fileName = matchResult.group(index);
                    }
                }
                //TODO find num of bytes
                //first get file data
                try(BufferedReader br = new BufferedReader(new FileReader("src\\resources\\"+fileName))) {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    numOfBytesInFile = sb.toString().getBytes();
                }
                // calcualte data into bytes
            System.out.println(numOfBytesInFile.length + " " + fileName);
             System.out.println("input received " + cmd + " " + flag + " " + fileName);

            } else {
                throw new InputMismatchException();
            }
//            if(fileName && flag && cmd == "ccwc")

        } catch (Exception e) {
            System.out.println("Invalid Input " + e);
        } finally {
            System.out.println("Exiting...");
        }


    }




}