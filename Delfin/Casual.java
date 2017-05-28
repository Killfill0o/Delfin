import java.time.LocalDate;

public class Casual //extends Members
{
    private String disiplin;
    private String trainer;
    private int result ;

    public Casual(/** String plan, String fname, String lname, int age, String cpr, String type, String status, double balance, */ String disiplin, String trainer, int result)
    {
        //super(plan, fname, lname, age, cpr, type, status, balance);
        this.disiplin = disiplin;
        this.trainer = trainer;
        this.result = result;
    }    

    // Metoder
    public String getDisiplin(){
        return disiplin;
    }

    public String getTrainer(){
        return trainer;
    }

    public int getResult(){ 
        return result;
    }

}