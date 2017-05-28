// Imports
import java.io.PrintStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.time.LocalDate;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

//Class start
public class Main
{
    //Main start
    public static void main(String[] args)
    {
        Create create = new Create();
        Money money = new Money();
        Display ds = new Display();
        boolean run_main = true;

try{ ds.clear(); Scanner scan = new Scanner(new File(".delfin.png")); while(scan.hasNext()){ds.print("   "+scan.nextLine());} String pause = System.console().readLine();} catch(FileNotFoundException e){System.out.println(e);}catch(Exception e){System.out.println(e);}  

        while(run_main){  
            ds.clear();
            ds.print("   Welcome to main menu \r\n");
            ds.print("   1. Create menu"+"\r\n"+"   2. Money menu "+"\r\n"+"   3. Exit programm"+"\r\n");
            ds.center(4);
            Scanner input = new Scanner(System.in);
            int swi = input.nextInt();
            
                switch (swi) {
                    case 1:
                        create.runMenu();
                        break;

                    case 2:
                        money.runMenu();
                        break;

                    case 3:
                        run_main = false;
                        break;
                    
                    case 365:
                        money.oneYear();
                        break;

                    case 404:
                        main(args);
                        break;

                    default:
                        ds.print("Please choose one of the given options!");
                        break;

                }
            ds.print("CLOSING");
       

        } //run_main

    } //End Main

} //End Class