public class Display {
    private String string;

    public Display() {
        this.string = string;
        }
    
    public static void clear() {  
        // printer intet (altså blankt) i antal gange (Kommer vel an på om vi viser det frem i cmd eller i VSC)
        for (int i = 0; i < 50; ++i) print(""); 
    } 
    public String fixlen(String i, String s, int ls){
        
        String tempString = i;
        int titlelen = tempString.length();
        int fixlen = 10 - tempString.length();
        String addlen = "";
        for(int fl = 0; fl<fixlen;){
            addlen += " ";
            fl++;
        }
        tempString = s;
        titlelen = tempString.length();
        fixlen = ls - tempString.length();
        String addlen2 = "";
        for(int fl = 0; fl<fixlen;){
            addlen += " ";
            fl++;
        }
        String pr = "\r\n"+"   "+i+": ";
        return pr + addlen + s + addlen2;
        
    }

    public static void center(int j){
        // printer intet (altså blankt) i antal gange (kan bruges efter en menu, til at centre den)
        for (int i = 0; i < j; ++i) print(""); 
    }

    public static void print(String s){
        System.out.println(s);
    }

    public static void size()
    {
        print("start here");
        print("2");
        print("3");
        print("4");
        print("5");
        print("6");
        print("7");
        print("8   < 1 line = center(7)");
        print("9   < 2-3 lines = center(6)");
        print("10  < 4-5 lines = center(5)");
        print("11  < 6-7 lines = center(4)");
        print("12  < 8-9 lines = center(3)");
        print("13  < 10-11 lines = center(2)");
        print("14");
        print("end here");String pause = System.console().readLine();
    }
} // Display end