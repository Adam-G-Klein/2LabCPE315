package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryConvertRunner {

    private String[] args;

    public BinaryConvertRunner(String[] args){
        this.args = args;
    }

    public void run(){
        Scanner sc = getScanner(args);
        System.out.println("Lookup result for and: ");
        System.out.println(InstructionLookup.getOpCode("and"));
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }

    
    private Scanner getScanner(String[] args){
        if(args.length == 0){
            System.out.println("Usage: binaryConverter filename");
            System.exit(-1);
        }
        File file = new File(args[0]);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("Error creating scanner: " + e);
            System.exit(-1);
        }
        return sc;
    }
}
