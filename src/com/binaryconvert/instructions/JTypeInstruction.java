package com.binaryconvert.instructions;

import com.binaryconvert.InstructionLookup;

public class JTypeInstruction implements Instruction {
    /***
     * Data class for the R type instructions:
     *  and, or, add, sub
     *
     */

    private String ins;
    private String target;

    public JTypeInstruction(String insStr){
        String stripped = insStr.replaceAll("\\s+","");
        String[] tokens = stripped.split(",");
        String[] insTokens = tokens[0].split("\\$");
        ins = insTokens[0];
    }

    public String toBinary(){
        StringBuilder res = new StringBuilder();
        res.append(InstructionLookup.getOpCode(ins) + " ");
        return res.toString();
    }

}
