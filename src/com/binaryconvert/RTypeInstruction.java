
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

    public RTypeInstruction(String ins, String insStr){
        this.ins = ins;
        String[] tokens = insStr.split(",");
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
