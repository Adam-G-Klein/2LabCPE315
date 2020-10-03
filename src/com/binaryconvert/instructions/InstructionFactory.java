package com.binaryconvert.instructions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstructionFactory {

    private static final List<String> rTypes = Arrays.asList("and", "or", "add", "sub", "slt");
    private static final List<String> iTypes = Arrays.asList("addi");
    private static final List<String> jumpTypes = Arrays.asList("j", "jr", "jal");
    private static final List<String> branchTypes = Arrays.asList("beq", "bne");
    private static final List<String> shiftTypes = Arrays.asList("sll");
    private static final List<String> memTypes = Arrays.asList("sw", "lw");

    public static Instruction createInstruction(Integer pcCount, String instructionLine){
        String ins = getInsFromLine(instructionLine);
        switch(ins){
            case "and", "or", "add", "sub", "slt" :
                return new RTypeInstruction(instructionLine);
            case "addi":
                return new ITypeInstruction(instructionLine);
            case "j", "jal", "jr":
                return new JTypeInstruction(instructionLine);
            default:
                return new InvalidInstruction(ins);
        }

    }

    public static String getInsFromLine(String instructionLine){
        if(instructionLine == null || instructionLine.isBlank()){
            return null;
        }
        if(instructionLine.charAt(0) == 'j') {
            if(instructionLine.indexOf("jal") == 0){
                return "jal";
            }
            if(instructionLine.indexOf("jr") == 0){
                return "jr";
            }
            return "j";
        } else {
            // pretty sure this works for all cases if it's not j type
            // please do check me though
            String stripped = instructionLine.replaceAll("\\s+","");
            String[] tokens = stripped.split(",");
            String[] insTokens = tokens[0].split("\\$");
            return insTokens[0];
        }
    }
}
