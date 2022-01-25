import java.util.*;

import javax.sql.rowset.spi.SyncResolver;

public class practice {
    //static int ans;
    public static int add(int num1, int num2){
        return num1+num2;
    }
   public static void main(String[] str){
    Scanner arg= new Scanner(System.in);
    int a = arg.nextInt();
    int b = arg.nextInt();
    char symbol = arg.next().charAt(0);
    int ans=0;
    arg.close();
        switch(symbol){
            case '*':
                ans=a*b;
                break;
            case '+':
                 ans=add(a,b);
                break;
            case '-':
                ans=a-b;
                break;
            case '/':
                ans=a/b;
                break;
            case '%':
                ans=a%b;
                break;
            default:
                System.out.println("Invalid Symbol");
        }
    System.out.println(ans);
    }   
}