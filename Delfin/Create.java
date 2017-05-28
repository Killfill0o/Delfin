// Imports
import java.io.PrintStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.time.LocalDate;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Create {
    private String string;

    public Create() {
        this.string = string;
    }

    public static void runMenu() {
    Display ds = new Display();
    Scanner s = new Scanner(System.in);
    s.useLocale(Locale.US);
    
    boolean run_create = true;  
    while(run_create){
        ds.clear();
        ds.print("   Welcome to create menu \r\n");
        ds.print("   1. Create new member"+"\r\n"+"   2. List of members"+"\r\n"+"   3. Set new time "+"\r\n"+"   4. Calculate best time "+"\r\n"+"   5. Exit create menu"+"\r\n");
        ds.center(3);
        Scanner ininput = new Scanner(System.in);
        int inswi = ininput.nextInt();
                        
        switch (inswi) {
                case 1:
                    newMember();
                    break;

                case 2:
                    listMember();
                    break;
                
                case 3:
                    newResult();
                    break;

                case 4:
                    bestResult();
                    break;
                
                case 5:
                    run_create = false;
                    break;

                default:
                    ds.print("Please choose one of the given options!");
                    break;
                }
    }
    }

    public static void bestResult() {
    Display ds = new Display();
    ArrayList<Elite> elites = new ArrayList<Elite>();
    ArrayList<Members> members = new ArrayList<Members>();
    ArrayList<Integer> results = new ArrayList<Integer>();
    Scanner s = new Scanner(System.in);
    s.useLocale(Locale.US);
    
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

            elites.add(new Elite(disiplin, trainer, result));
            members.add(new Members(plan, id, fname, lname, age, cpr, type, status, balance));

            if(!plan.equalsIgnoreCase("competetive")){result = 1000;}
            results.add(new Integer(result));
        }

        int r1 = 200; String n1 = "";
        int r2 = 200; String n2 = "";
        int r3 = 200; String n3 = "";

        for(int i = 0; i < results.size();){
            ds.print("time: "+results.get(i));

            if(results.get(i)<r3){
                if(results.get(i)<r2){
                    if(results.get(i)<r1){
                        r3 = r2; n3 = n2;
                        r2 = r1; n2 = n1;
                        r1 = results.get(i);
                        n1 = members.get(i).getFname()+" "+members.get(i).getLname();
                    }
                    if(results.get(i)!=r1){
                        r3 = r2; n3 = n2;
                        r2 = results.get(i);
                        n2 = members.get(i).getFname()+" "+members.get(i).getLname();
                    }
                if(results.get(i)!=r2){
                    if(results.get(i)!=r1){
                        r3 = results.get(i);
                        n3 = members.get(i).getFname()+" "+members.get(i).getLname();
                    }
                }
                }
            }
            i++;
        }
    ds.center(9);
    ds.print("   Best results: \r\n");
    ds.print("   1st: "+n1+" with time "+r1);
    ds.print("   2nd: "+n2+" with time "+r2);
    ds.print("   3rd: "+n3+" with time "+r3);
    ds.center(1);
    ds.print("   Hit enter to continue");
    ds.center(4);
    String pause = System.console().readLine();
    } catch(FileNotFoundException e){System.out.println(e);}
    catch(Exception e){System.out.println(e);}
    }

    public static void newResult() {
    Display ds = new Display();
    ArrayList<Elite> elites = new ArrayList<Elite>();
    ArrayList<Members> members = new ArrayList<Members>();
    Scanner s = new Scanner(System.in);
    s.useLocale(Locale.US);
    
    try{
        Scanner scan = new Scanner(new File("_members.log"));
        scan.useLocale(Locale.US);
        ds.clear();
        ds.print("   Select ID to change: ");
        ds.center(7);
        int inp_id = s.nextInt();
        ds.clear();
        ds.print("   Enter new time: ");
        ds.center(7);
        int nt = s.nextInt();
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

            if(id == inp_id){if(nt < result);result = nt;}

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

    public static void listMember() {
        Display ds = new Display();
        ArrayList<Elite> elites = new ArrayList<Elite>();
        ArrayList<Members> members = new ArrayList<Members>();
        Scanner s = new Scanner(System.in);

        String disiplin = "";
        String trainer = "";
        int result = 0;
        ds.clear();
         try{
            Scanner scan = new Scanner(new File("_members.log"));
            scan.useLocale(Locale.US);

            while(scan.hasNext())
            {
                members.add(new Members(scan.next(), scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.next(), scan.next(),scan.nextDouble()));
                int i = members.size()-1;
                elites.add(new Elite(scan.next(), scan.next(), scan.nextInt()));
                i++;
            }
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}  
        
        ds.clear();
        for(int i = 0; i<members.size();){
        int i1 = i+1;
        ds.clear();
        ds.print("   Displaying member: "+i1+" / "+members.size());
        ds.print(ds.fixlen("Plan",members.get(i).getPlan(),12)+ds.fixlen("ID",String.valueOf(members.get(i).getId()),12)+ ds.fixlen("Firstname",members.get(i).getFname(),12)+ds.fixlen("Lastname",members.get(i).getLname(),12)+ds.fixlen("age",String.valueOf(members.get(i).getAge()),12)+ds.fixlen("cpr",members.get(i).getCpr(),12)+ds.fixlen("type",members.get(i).getType(),12)+ds.fixlen("status",members.get(i).getStatus(),12)+ds.fixlen("balance",String.valueOf(members.get(i).getBalance()),12)+ds.fixlen("disiplin",elites.get(i).getDisiplin(),12)+ds.fixlen("Trainer",elites.get(i).getTrainer(),12)+ds.fixlen("Result",String.valueOf(elites.get(i).getResult()),12));
        ds.center(1);
        ds.print("   <  Last | exit | next  >   ");
        String in = s.next().toString();
        if(in.equalsIgnoreCase("last")){
            i--;
        }
        if(in.equalsIgnoreCase("next")){
            i++;
        }
        if(in.equalsIgnoreCase("exit")){
            i = 100000;
        }
        if(i == -1){i = 0;}
        }
    
    }

    public static void newMember() {
        Display ds = new Display();
        ArrayList<Elite> elites = new ArrayList<Elite>();
        ArrayList<Members> members = new ArrayList<Members>();
        Scanner s = new Scanner(System.in);
        LocalDate ldate = LocalDate.now();
        String date = ldate.toString();
        File f = new File("_members.log");
        
        ds.clear();
        ds.print("   Enter first and last name: ");
        ds.center(7);
        String fname = s.next().toString();
        String lname = s.next().toString();

        ds.clear();
        ds.print("   Enter CPR-number (xxxxxx-xxxx): ");
        ds.center(7);
        String cpr = s.next().toString();
        while(cpr.length()<10){
            ds.clear();
            ds.print("   CPR-number is to short. Please ensure to enter 10 numbers.");
            ds.center(7);
            cpr = s.next().toString();
        }
        while(cpr.length()>11){
            ds.clear();
            ds.print("   CPR-number is to long. Please ensure to enter 10 numbers.");
            ds.center(7);
            cpr = s.next().toString();
        }

        ds.clear();
        ds.print("   Active or pasive member: ");
        ds.center(7);
        String status = s.next().toString();
            
        ds.clear();
        ds.print("   casual or competetive member: ");
        ds.center(7);
        String plan = s.next().toString();
        
        int day = Integer.valueOf(String.valueOf(date.charAt(8)-48) + String.valueOf(date.charAt(9)-48));
        int month = Integer.valueOf(String.valueOf(date.charAt(5)-48) + String.valueOf(date.charAt(6)-48));
        int year = Integer.valueOf(String.valueOf(date.charAt(2)-48) + String.valueOf(date.charAt(3)-48));
        
        int md = Integer.valueOf(String.valueOf(cpr.charAt(0)-48) + String.valueOf(cpr.charAt(1)-48));
        int mm = Integer.valueOf(String.valueOf(cpr.charAt(2)-48) + String.valueOf(cpr.charAt(3)-48));
        int my = Integer.valueOf(String.valueOf(cpr.charAt(4)-48) + String.valueOf(cpr.charAt(5)-48));

        int mc = Integer.valueOf(String.valueOf(cpr.charAt(6)-48) + String.valueOf(cpr.charAt(7)-48)
        + String.valueOf(cpr.charAt(8)-48) + String.valueOf(cpr.charAt(9)-48));
        

        int age;
        String type;
        int balance = 0;
        String disiplin = "";
        String trainer = "";
        int result = 0;
        /** Hvis dit cpr-nummer er 010118 er du ikke født næste år, men for 99 år siden.
        Dit fødselsår er her x. er x mere end year (det nuværende år) så finder den din alder
        ved at trække dit fødselsår - nuværende år + 100.*/
        if(my>year) {age = 100+year-my;} else {age = year-my;}
        if(mm>month){ds.print("m");age = age-1;} if(mm==month){ds.print("mm");if(md>day){age = age-1;}}
        if(age>=18){ds.print("Senior");type = "Senior";}else{ds.print("Junior");type = "Junior";}

        // Simple correction of Upper- and lowercase
        fname = fname.substring(0,1).toUpperCase() + fname.substring(1).toLowerCase();
        lname = lname.substring(0,1).toUpperCase() + lname.substring(1).toLowerCase();
        plan = plan.substring(0,1).toUpperCase() + plan.substring(1).toLowerCase();
        status = status.substring(0,1).toUpperCase() + status.substring(1).toLowerCase();    

        String mfd = String.valueOf(md); String mfm = String.valueOf(mm);
        String mfy = String.valueOf(my); String mfc = String.valueOf(mc);
        if(String.valueOf(md).length()==1){mfd = "0"+md;}
        if(String.valueOf(mm).length()==1){mfm = "0"+mm;}
        if(String.valueOf(my).length()==1){mfy = "0"+my;}
        if(String.valueOf(mc).length()==3){mfc = "0"+mc;}
        if(cpr.length()==10){cpr = String.valueOf(mfd)+String.valueOf(mfm)+String.valueOf(mfy)+"-"+String.valueOf(mfc);}
        
        try{
            Scanner scan = new Scanner(new File("_members.log"));
            scan.useLocale(Locale.US);

            while(scan.hasNext())
            {
                members.add(new Members(scan.next(), scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.next(), scan.next(),scan.nextDouble()));
                int i = members.size()-1;
                elites.add(new Elite(scan.next(), scan.next(), scan.nextInt()));
            
            }
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}
        int id = members.size();
        ds.clear();
        ds.print("   ID: "+id);
        ds.print("   Firstname: "+fname);
        ds.print("   Lastname: "+lname);
        ds.print("   Age: "+age);
        ds.print("   CPR: "+cpr);
        ds.print("   Type: "+type);
        ds.print("   Status: "+status);
        ds.print("   Plan: "+plan);
        ds.print("   Balance: "+balance);
        ds.center(1);
        ds.print("   OK | EDIT | EXIT ");
        ds.center(2);
        String in = s.next().toString();

        if(in.equalsIgnoreCase("OK")){
            int i = 0;

            if(plan.equalsIgnoreCase("casual")){
                ds.clear();
                ds.print("   Member created: ");
                ds.center(7);
                elites.add(new Elite("null","null",0));
                members.add(new Members(plan, id, fname, lname, age, cpr, type, status, balance));
                i = members.size()-1;
                ds.clear();
                ds.print("   Plan "+ members.get(i).getPlan()+"\r\n Firstname "+ members.get(i).getFname()+"\r\n Lastname "+ members.get(i).getLname()+"\r\n Age "+ members.get(i).getAge()+"\r\n CPR "+ members.get(i).getCpr()+"\r\n Type "+ members.get(i).getType()+ "\r\n Status "+ members.get(i).getStatus()+"\r\n Balance "+ members.get(i).getBalance());
                ds.center(2);
            }

            if(plan.equalsIgnoreCase("competetive")){
                ds.clear();
                ds.print("   Which disiplin will you attend: ");
                ds.center(7);
                disiplin = s.next().toString();
                ds.clear();
                ds.print("   Your trainer will be: ");
                ds.center(1);
                if(members.get(i).getType().equalsIgnoreCase("Senior")){
                    trainer = "Morten";
                }
                if(members.get(i).getType().equalsIgnoreCase("Junior")){
                    trainer = "Peter";
                }
                if(disiplin.equalsIgnoreCase("Synkron")){
                    trainer = "Helle";
                }
                ds.print("   "+trainer);
                ds.center(5);
                ds.clear();
                ds.print("   What is your best result: ");
                ds.center(7);
                result = s.nextInt();
                //print
                elites.add(new Elite(disiplin, trainer, result));
                members.add(new Members(plan, id, fname, lname, age, cpr, type, status, balance));
                /** Sørger for at der printes sidste tilføjede object til listen. */
                i = members.size()-1;
                ds.print("\r\n Plan "+ members.get(i).getPlan()+"\r\n ID "+ members.get(i).getId()+"\r\n Firstname "+ members.get(i).getFname()+"\r\n Lastname "+ members.get(i).getLname()+"\r\n Age "+ members.get(i).getAge()+"\r\n CPR "+ members.get(i).getCpr()+"\r\n Type "+ members.get(i).getType()+"\r\n Status "+ members.get(i).getStatus()+"\r\n Balance "+ members.get(i).getBalance());
                ds.print("\r\n Disiplin "+elites.get(i).getDisiplin()+"\r\n Trainer "+elites.get(i).getTrainer()+"\r\n Result "+elites.get(i).getResult()+" ");
            }

            if(!plan.equalsIgnoreCase("competetive") && !plan.equalsIgnoreCase("casual")){
                ds.clear();
                ds.print("   Error creating member. Retype your information and check for spelling errors. ");
                ds.center(1);
                ds.print("   Press enter to continue ");
                ds.center(6);
                newMember();
            }
        }
        if(in.equalsIgnoreCase("EDIT")){
            newMember();
        }
        else{
            ds.clear();

        try{
            PrintStream file = new PrintStream(new File("_members.log"));

            for(int i = 0; i < members.size();){
                file.print("\r\n"+members.get(i).getPlan()+" "+ members.get(i).getId()+" "+ members.get(i).getFname()+" "+ members.get(i).getLname()+" "+ members.get(i).getAge()+" "+ members.get(i).getCpr()+"\r\n"+ members.get(i).getType()+" "+ members.get(i).getStatus()+" "+ members.get(i).getBalance());
                file.print("\r\n"+elites.get(i).getDisiplin()+" "+elites.get(i).getTrainer()+" "+elites.get(i).getResult()+"\r\n");   
                i++;
            }
            
            } catch(FileNotFoundException e){System.out.println(e);}
            catch(Exception e){System.out.println(e);}  
            
            ds.print("EXIT");
            ds.center(7);
        }
    }

} //End create