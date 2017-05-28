public class Members
{
   private String plan;
   private int id;
   private String fname;
   private String lname;
   private int age;
   private String cpr;
   private String type;
   private String status;
   private double balance;


    public Members(String plan, int id, String fname, String lname, int age, String cpr, String type, String status, double balance)
    {
        this.plan = plan;
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.cpr = cpr;
        this.type = type;
        this.status =  status;
        this.balance = balance;
    }   

    public String getPlan(){
        return plan;
    }

    public int getId(){
        return id;
    }
    
    public String getFname(){
        return fname;
    }

    public String getLname(){
        return lname;
    }

    public int getAge(){
        return age;
    }

    public String getCpr(){
        return cpr;
    }

    public String getType(){
        return type;
    }

    public String getStatus(){
        return status;
    }

    public double getBalance(){
        return balance;
    }
}