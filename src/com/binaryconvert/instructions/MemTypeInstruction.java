package com.binaryconvert.instructions;

import com.binaryconvert.InstructionLookup;

public class MemTypeInstruction implements Instruction {
    /***
     * Data class for the Mem type instructions:
     *  and, or, add, sub
     *
     */

    private String ins;
    private String rs;
    private String rt;
    private String offset;

    public MemTypeInstruction(String insStr){
        String[] tokens = insStr.split(",");
        String[] insTokens = tokens[0].split("\\$");
        ins = insTokens[0];
        rt = tokens[0].substring(ins.length());
        String[] subTokens = tokens[1].split("\\(");
        offset = subTokens[0];
        rs = subTokens[1].substring(subTokens[1].length() - 1);

    }

    public String toBinary(){
        StringBuilder res = new StringBuilder();
        res.append(InstructionLookup.getOpCode(ins) + " ");
        res.append(rs + " ");
        res.append(InstructionLookup.getReg(rt) + " ");
        res.append(DecimalToBinary.convertToBinary(offset, 16));
        return res.toString();
    }

    @Override
    public String toString() {
        return "ShiftTypeInstruction{" +
                "ins='" + ins + '\'' +
                ", rs='" + rs + '\'' +
                ", rt='" + rt + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
