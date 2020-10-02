package com.binaryconvert;

import com.binaryconvert.instructions.Instruction;
import com.binaryconvert.instructions.InstructionFactory;
import com.binaryconvert.instructions.RTypeInstruction;

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
        while (sc.hasNextLine()){
            String rawLine = sc.nextLine();
            System.out.println("Line: " + rawLine);
            // get everything before the comment
            String strippedLine = stripComments(rawLine.replaceAll("\\s+",""));
            System.out.println("Comment Stripped Line: " + strippedLine);
            strippedLine = processLabels(strippedLine);



            if(!strippedLine.isBlank()){
                Instruction ins = InstructionFactory.createInstruction(strippedLine);
                System.out.println("Obj: " + ins.toString());
                System.out.println("Binary: " + ins.toBinary());
                //output binary to outfile here
            }
        }
    }

    private String processLabels(String inString){
        return inString;
    }

    private String stripComments(String strippedLine){
        int commIndex = strippedLine.indexOf("#");
        if (commIndex == -1){
            return strippedLine;
        } else {
            return strippedLine.substring(0, commIndex);
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
