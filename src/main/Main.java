package main;

import main.Processor.Cli;
import main.cmds.Wc;

import java.util.Scanner;
public class Main {




    public static void main(String[] args) {
        //TODO create a prompt on console that will active when input from args is "ccwc -c"
        // We should also have a key that will exit from the prompt in console
        // There should be a class that will handle the text count for files

        // get user input here
        try {
            Scanner in = new Scanner(System.in);
            Cli cli = new Cli(in);
            cli.parseInput();

            if(!cli.getCmd().equalsIgnoreCase("") && !cli.getFileName().equalsIgnoreCase("")) {
                Wc wc = new Wc(cli.getFlag(), cli.getFileName());
                String output =wc.processFlag();
                System.out.println(output);
            }

        } catch (Exception e) {
            System.out.println("Invalid Input " + e);
        } finally {
            System.out.println("Exiting...");
        }


    }


}