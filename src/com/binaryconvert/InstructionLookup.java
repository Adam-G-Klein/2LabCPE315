package com.binaryconvert;

import java.util.HashMap;
import java.util.Map;

public class InstructionLookup {

    private static Map<String,String> opLookup = new HashMap<>(){{
        put("and", "000000");
        put("or", "000000");
        put("add", "000000");
        put("addi", "001000");
        put("sub", "000000");
        put("sll", "000000");
        put("slt", "000000");
        put("beq", "000100");
        put("bne", "000101");
        put("lw", "100011");
        put("sw", "101011");
        put("j", "000010");
        put("jr", "000000");
        put("jal", "000011");
    }};

    private static Map<String,String> funcLookup = new HashMap<>(){{
        put("and", "100100");
        put("or", "100101");
        put("add", "100000");
        put("sub", "100010");
        put("sll", "000000");
        put("slt", "101010");
        put("jr", "001000");
    }};

    private static Map<String,String> regLookup = new HashMap<>(){{
        put("$zero", "000000");
        put("$0", "000000");
        put("$at", "000001");
        put("$v0", "000010");
        put("$v1", "000011");
        put("$a0", "000100");
        put("$a1", "000101");
        put("$a2", "000110");
        put("$a3", "000111");
        put("$t0", "001000");
        put("$t1", "001001");
        put("$t2", "001010");
        put("$t3", "001011");
        put("$t4", "001100");
        put("$t5", "001101");
        put("$t6", "001110");
        put("$t7", "001111");
        put("$s0", "010000");
        put("$s1", "010001");
        put("$s2", "010010");
        put("$s3", "010011");
        put("$s4", "010100");
        put("$s5", "010101");
        put("$s6", "010110");
        put("$s7", "010111");
        put("$t8", "011000");
        put("$t9", "011001");
        put("$k0", "11010");
        put("$k1", "11011");
        put("$gp", "11100");
        put("$sp", "11101");
        put("$fp", "11110");
        put("$ra", "11111");

    }};

    public static String getOpCode(String ins){
        return opLookup.get(ins);
    }

    public static String getFunc(String ins){
        return funcLookup.get(ins);
    }

    public static String getReg(String ins){
        return regLookup.get(ins);
    }
}
