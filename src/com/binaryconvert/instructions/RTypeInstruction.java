package com.binaryconvert.instructions;

import com.binaryconvert.InstructionLookup;

public class RTypeInstruction implements Instruction {
    /***
     * Data class for the R type instructions:
     *  and, or, add, sub
     *
     */

    private String ins;
    private String rd;
    private String rs;
    private String rt;

    public RTypeInstruction(String insStr){
        String[] tokens = insStr.split(",");
        String[] insTokens = tokens[0].split("\\$");
        ins = insTokens[0];
        rd = tokens[0].substring(ins.length());
        rs = tokens[1];
        rt = tokens[2];
    }

    public String toBinary(){
        StringBuilder res = new StringBuilder();
        res.append(InstructionLookup.getOpCode(ins) + " ");
        res.append(InstructionLookup.getReg(rs) + " ");
        res.append(InstructionLookup.getReg(rt) + " ");
        res.append(InstructionLookup.getReg(rd) + " ");
        res.append("00000 ");
        res.append(InstructionLookup.getFunc(ins) + " ");
        return res.toString();
    }

    @Override
    public String toString() {
        return "RTypeInstruction{" +
                "ins='" + ins + '\'' +
                ", rd='" + rd + '\'' +
                ", rs='" + rs + '\'' +
                ", rt='" + rt + '\'' +
                '}';
    }
}
