package com.binaryconvert.instructions;

import com.binaryconvert.InstructionLookup;

public class ShiftTypeInstruction implements Instruction {
    /***
     * Data class for the R type instructions:
     *  and, or, add, sub
     *
     */

    private String ins;
    private String rd;
    private String rs;
    private String rt;
    private String shamt;

    public ShiftTypeInstruction(String insStr){
        String[] tokens = insStr.split(",");
        String[] insTokens = tokens[0].split("\\$");
        ins = insTokens[0];
        rd = tokens[0].substring(ins.length());
        rs = "00000";
        rt = tokens[1];
        shamt = tokens[2];

    }

    public String toBinary(){
        StringBuilder res = new StringBuilder();
        res.append(InstructionLookup.getOpCode(ins) + " ");
        res.append(rs + " ");
        res.append(InstructionLookup.getReg(rt) + " ");
        res.append(InstructionLookup.getReg(rd) + " ");
        res.append(String.format("%5s",
                Integer.toBinaryString(Integer.parseInt(shamt))
                        .replace(' ', '0')) + " ");
        res.append("000000");
        return res.toString();
    }

    @Override
    public String toString() {
        return "ShiftTypeInstruction{" +
                "ins='" + ins + '\'' +
                ", rd='" + rd + '\'' +
                ", rt='" + rt + '\'' +
                ", shamt='" + shamt + '\'' +
                '}';
    }
}
