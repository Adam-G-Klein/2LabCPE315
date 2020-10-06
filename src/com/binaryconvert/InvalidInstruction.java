
public class InvalidInstruction implements Instruction{
    private String ins;
    public InvalidInstruction(String ins){
        this.ins = ins;
    };

    @Override
    public String toBinary() {
        return "invalid instruction: " + ins;
    }
}
