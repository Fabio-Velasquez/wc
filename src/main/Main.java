package main;

import main.Processor.Cli;
import main.cmds.Wc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main {




    public static void main(String[] args) {
        //TODO Optimization tatic: instead of using Scanner use an alternative library
        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner in = new Scanner(System.in);
            Cli cli = new Cli(in);
            cli.parseInput();

            if(!cli.getCmd().equalsIgnoreCase("") && !cli.getFileName().equalsIgnoreCase("")) {
                Wc wc = new Wc(cli.getFlag(), cli.getFileName());
                String output = wc.processFlag();
                System.out.println(output);
            }

        } catch (Exception e) {
            System.out.println("Invalid Input " + e);
        } finally {
            System.out.println("Exiting...");
        }


    }


}