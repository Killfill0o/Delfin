// Imports
import java.io.PrintStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.time.LocalDate;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private String string;

    public Money() {
        this.string = string;
    }

    public static void runMenu() {
        Display ds = new Display();
        Scanner s = new Scanner(System.in);
        s.useLocale(Locale.US);
        boolean run_money = true;
        while(run_money){
                ds.clear();
                ds.print("   Welcome to money menu \r\n");
                ds.print("   1. Members in restance"+"\r\n"+"   2. Recharge balance"+"\r\n"+"   3. Calculate funds"+"\r\n"+"   4. Exit money menu"+"\r\n");
                ds.center(4);
                Scanner inninput = new Scanner(System.in);
                int innswi = inninput.nextInt();
                
            switch (innswi) {
                case 1:
                    restanceMember();
                    break;
        
                case 2:
                    rechargeBalance();
                    break;

                case 3:
                    calculate();
                    break;
                
                case 4:
                    run_money = false;
                    break;

                default:
                    ds.print("Please choose one of the given options!");
                    break;
                }
        }
    }


        public static void rechargeBalance() {
        Display ds = new Display();
        ArrayList<Elite> elites = new ArrayList<Elite>();
        ArrayList<Members> members = new ArrayList<Members>();
        Scanner s = new Scanner(System.in);
        s.useLocale(Locale.US);
        
        try{
            Scanner scan = new Scanner(new File("_members.log"));
            scan.useLocale(Locale.US);

            ds.print("   Select ID to recharge: ");
            int inp_id = s.nextInt();
            ds.print("   Select amount to insert: ");
            double ref = s.nextDouble();
            double newBalance = 0.0;
            if(ref > 0.0){newBalance = ref;;}
            while(scan.hasNext())
            {   
                String plan = scan.next();
                int id = scan.nextInt();
                String fname = scan.next();
                String lname = scan.next();
                int age = scan.nextInt();
                String cpr = scan.next();
                String type = scan.next();
                String status = scan.next();
                double balance = scan.nextDouble();
                String disiplin = scan.next();
                String trainer = scan.next();
                int result = scan.nextInt();

                if(id == inp_id){ balance = balance + newBalance;}

                elites.add(new Elite(disiplin, trainer, result));
                members.add(new Members(plan, id, fname, lname, age, cpr, type, status, balance));
           
            }
            
            PrintStream file = new PrintStream(new File("_members.log"));
            for(int i = 0; i < members.size();){
                file.print("\r\n"+members.get(i).getPlan()+" "+ members.get(i).getId()+" "+ members.get(i).getFname()+" "+ members.get(i).getLname()+" "+ members.get(i).getAge()+" "+ members.get(i).getCpr()+"\r\n"+ members.get(i).getType()+" "+ members.get(i).getStatus()+" "+ members.get(i).getBalance()+"\r\n"+elites.get(i).getDisiplin()+" "+elites.get(i).getTrainer()+" "+elites.get(i).getResult()+"\r\n");
                i++;
            }
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}
        }

        public static void oneYear() {
        Display ds = new Display();
        ArrayList<Elite> elites = new ArrayList<Elite>();
        ArrayList<Members> members = new ArrayList<Members>();
        Scanner s = new Scanner(System.in);
        
        try{
            Scanner scan = new Scanner(new File("_members.log"));
            scan.useLocale(Locale.US);

            while(scan.hasNext())
            {
                String plan = scan.next();
                int id = scan.nextInt();
                String fname = scan.next();
                String lname = scan.next();
                int age = scan.nextInt();
                String cpr = scan.next();
                String type = scan.next();
                String status = scan.next();
                double balance = scan.nextDouble();
                String disiplin = scan.next();
                String trainer = scan.next();
                int result = scan.nextInt();
                double price = 0;

                if(age < 18){price = 1000.00;}
                if(age > 18){price = 1600.00;}
                if(age > 60){price = 1600.00*0.75;}
                if(status.equalsIgnoreCase("pasive")){price = 500.00;}

                balance = balance - price;

                elites.add(new Elite(disiplin, trainer, result));
                members.add(new Members(plan, id, fname, lname, age, cpr, type, status, balance));
            }
            
            PrintStream file = new PrintStream(new File("_members.log"));
            for(int i = 0; i < members.size();){
                file.print("\r\n"+members.get(i).getPlan()+" "+ members.get(i).getId()+" "+ members.get(i).getFname()+" "+ members.get(i).getLname()+" "+ members.get(i).getAge()+" "+ members.get(i).getCpr()+"\r\n"+ members.get(i).getType()+" "+ members.get(i).getStatus()+" "+ members.get(i).getBalance()+"\r\n"+elites.get(i).getDisiplin()+" "+elites.get(i).getTrainer()+" "+elites.get(i).getResult()+"\r\n");
                i++;
            }
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}
        }

        public static void restanceMember() {
        Display ds = new Display();
        ArrayList<Elite> elites = new ArrayList<Elite>();
        ArrayList<Members> restance = new ArrayList<Members>();
        ArrayList<Members> members = new ArrayList<Members>();
        Scanner s = new Scanner(System.in);

        try{
            Scanner scan = new Scanner(new File("_members.log"));
            scan.useLocale(Locale.US);

            while(scan.hasNext())
            {
                String plan = scan.next();
                int id = scan.nextInt();
                String fname = scan.next();
                String lname = scan.next();
                int age = scan.nextInt();
                String cpr = scan.next();
                String type = scan.next();
                String status = scan.next();
                double balance = scan.nextDouble();
                String disiplin = scan.next();
                String trainer = scan.next();
                int result = scan.nextInt();

                if(balance < 0){
                    restance.add(new Members(plan,id,fname,lname,age,cpr,type,status,balance));
                }
            }
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}

        ds.clear();
        for(int j = 0; j<restance.size();){
        int j1 = j+1;
        ds.clear();
        ds.print("   Displaying member: "+j1+" / "+restance.size());
        ds.center(1);
        ds.print(ds.fixlen("Plan",restance.get(j).getPlan(),12)+ds.fixlen("ID",String.valueOf(restance.get(j).getId()),12)+ds.fixlen("Firstname",restance.get(j).getFname(),12)+ds.fixlen("Lastname",restance.get(j).getLname(),12)+ds.fixlen("Age",String.valueOf(restance.get(j).getAge()),12)+ds.fixlen("Cpr",restance.get(j).getCpr(),12)+ds.fixlen("Type",restance.get(j).getType(),12)+ds.fixlen("Status",restance.get(j).getStatus(),12)+ds.fixlen("Balance",String.valueOf(restance.get(j).getBalance()),12));
        ds.center(2);
        ds.print("   <  Last | exit | next  >   ");
        String in = s.next().toString();

        if(in.equalsIgnoreCase("last")){
            j--;
        }
        if(in.equalsIgnoreCase("next")){
            j++;
        }
        if(in.equalsIgnoreCase("exit")){
            j = 100000;
        }
        if(j == -1){j = 0;}
        }
    }

    public static void calculate() {
        Display ds = new Display();
        ArrayList<Elite> elites = new ArrayList<Elite>();
        ArrayList<Members> members = new ArrayList<Members>();
        Scanner s = new Scanner(System.in);
       
        double totalBalance = 0;
        double negBalance = 0;
        double posBalance = 0;

        try{
            Scanner scan = new Scanner(new File("_members.log"));
            scan.useLocale(Locale.US);

            while(scan.hasNext())
            {
                String plan = scan.next();
                int id = scan.nextInt();
                String fname = scan.next();
                String lname = scan.next();
                int age = scan.nextInt();
                String cpr = scan.next();
                String type = scan.next();
                String status = scan.next();
                double balance = scan.nextDouble();
                String disiplin = scan.next();
                String trainer = scan.next();
                int result = scan.nextInt();

                totalBalance = totalBalance + balance;
                
                if(balance < 0){
                    negBalance = negBalance + balance;
                }
                if(balance > 0){
                    posBalance = posBalance + balance;
                }
               
            }
            
            ds.clear();
            ds.print("   Svoemmeklub Delfinen");
            ds.center(1);
            ds.print(ds.fixlen("Total",String.valueOf(new BigDecimal(totalBalance).setScale(2, RoundingMode.HALF_UP).doubleValue()),8)+
            ds.fixlen("Negative",String.valueOf(new BigDecimal(negBalance).setScale(2, RoundingMode.HALF_UP).doubleValue()),8)+
            ds.fixlen("Positive",String.valueOf(new BigDecimal(posBalance).setScale(2, RoundingMode.HALF_UP).doubleValue()),8));
            ds.center(2);
            ds.print("   Hit enter to continue");
            ds.center(3);
            String pause = System.console().readLine();

        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}
    } // end calculate
} // end Money