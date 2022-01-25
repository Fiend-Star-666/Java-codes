import java.util.*;
public class tictactoe {
    static int place;
    static char value;
    static int flag=0;
    static Scanner inpt = new Scanner(System.in);

private static void print(char[] ttt){
    for(int i=0;i<9;i++) {	
        if(i==2||i==5||i==8) {	
            System.out.print(ttt[i]+" \n");
            System.out.println("---------");}
        else
            System.out.print(ttt[i]+" | ");
    }
}
private static int rwmjr(int place){
    int M=place/10-1;
	int N=place%10-1;
    return (3*M + N);
}
private static void greet(char[] ttt){
    System.out.println("Enter the value then Place:");
    value=inpt.next().charAt(0);		
    place=inpt.nextInt();
    ttt[rwmjr(place)]=value;
}
private static int checker(char[] ttt, int flag){
    for(int i=0;i<3;i++){
        if(ttt[i]==ttt[i+3]&&ttt[i]==ttt[i+6])	flag=1;
    }
    for(int i=0;i<9;i+=3){
        if(flag==1)	break;
        if(ttt[i]==ttt[i+1]&&ttt[i]==ttt[i+2])	flag=1;
    }
    for(int i=1;i<3;i++) {
        if(flag==1)	break;
        if(ttt[0]==ttt[4]&&ttt[0]==ttt[8]||ttt[2]==ttt[4]&&ttt[2]==ttt[6])	flag=1;
    }
    return flag;
}
public static void main(String[] str) {
	System.out.println("Enter the X or O in the tic-tac-toe by using the co-ordinate format:");
	char[] ttt=new char[9];
    print(ttt);
	//no check required for first 4 turns
	for(int i=0;i<4;i++){
        greet(ttt);
        print(ttt);
	}
	//check required with every input at every turn
    for(int j=5;j<9;j++){
		greet(ttt);
	    if(checker(ttt, flag)==1){
            if(j%2==0)   System.out.println("\nO-Wins\n");  
            else    System.out.println("\nX-Wins\n");
	    print(ttt);
        break;
	    }
        else    System.out.println("\nNo player Won\n");
    }
}
}