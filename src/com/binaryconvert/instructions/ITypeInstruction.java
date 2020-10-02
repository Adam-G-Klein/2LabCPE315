package com.binaryconvert.instructions;

import com.binaryconvert.InstructionLookup;

public class ITypeInstruction implements Instruction {
    /***
     * Data class for the R type instructions:
     *  and, or, add, sub
     *
     */

    private String ins;
    private String rs;
    private String rt;
    private String imm;

    public ITypeInstruction(String insStr){
        String stripped = insStr.replaceAll("\\s+","");
        String[] tokens = stripped.split(",");
        String[] insTokens = tokens[0].split("\\$");
        ins = insTokens[0];
        rt = tokens[0].substring(ins.length());
        rs = tokens[1];
        imm = tokens[2];
    }

    public String toBinary(){
        StringBuilder res = new StringBuilder();
        res.append(InstructionLookup.getOpCode(ins) + " ");
        res.append(InstructionLookup.getReg(rs) + " ");
        res.append(InstructionLookup.getReg(rt) + " ");
        // This doesn't work. please fix it Brandon lmao
        // it still has spaces instead of 0's, and -1 makes
        // more than 16 bits
        res.append(String.format("%16s",
                Integer.toBinaryString(Integer.parseInt(imm))
                        .replace(' ', '0')));
        return res.toString();
    }

    @Override
    public String toString() {
        return "ITypeInstruction{" +
                "ins='" + ins + '\'' +
                ", rs='" + rs + '\'' +
                ", rt='" + rt + '\'' +
                ", imm='" + imm + '\'' +
                '}';
    }
}