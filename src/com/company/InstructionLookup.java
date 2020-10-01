package com.company;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class InstructionLookup {

    private static Map<String,String> lookup = new HashMap<>(){{
        put("and", "100100");
        put("or", "100101");
        put("add", "100000") ;
        put("addi", "001000");
        put("sub", "100010");
        put("sll", "000000");
        put("slt", "101010");
        put("beq", "000100");
        put("bne", "000101");
        put("lw", "100011");
        put("sw", "101011");
        put("j", "000010");
        put("jr", "001000");
        put("jal", "000011");
    }};


    public static String getOpCode(String ins){
        return lookup.get(ins);
    }

    public static String getFunc(String ins){
        return "stubbedResponse";
    }
}
