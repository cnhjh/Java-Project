package hm.java01.Day05;
  import java.util.Scanner;
public class SumOfSeq2 {
                           //1+1/2+1/3+...1/n=
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		System.out.println("请输入整数（例如10）：");
	        int n = scan.nextInt();
	       
            double result = 0;
            for(int i=1 ; i<n ; i++ ){
            	result += 1.0/i;
            	
            if (i==1){
                 System.out.print("1+");
            }else{
            	 System.out.print( "1/"+i +"+");
            }
              
            }
              result +=  1.0/n;
            System.out.print("1/"+n+"="+result);
	}

}
