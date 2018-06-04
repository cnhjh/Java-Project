package hm.java01.Day04;
//1+2+3+4+...+99+100的结果
public class ForDemo {
      public static void main(String[] args) {
    	  
    	  
    		
    			
    			
	  
    	  
    	  
    	//1+2+3+4+...+99+100的结果
		/*
		int a =0;
		for(int b=1;b<=100;b++){
			a=a+b;
	    }
		System.out.println(a);	
		*/
		
    	  
    	  //3+33+333+...+33333的结果
    	  /*
		int a = 3;
		int b = a;
	 for (int c = 1;c<5;c++){
		 a = a*10+3;
		 b += a;          //结果
	 }
				System.out.println("3+33+...+33333="+b);
		*/	
			
		
		
		long a = 9;
		long b = a;//总
		for(int c= 1;c<10;c++){
			//if(c==3){   break;  }
			
			a = a*10+9;
			b += a;
		}
		System.out.println("9+99+999+...+9999999999="+b);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
	    // 数列求和
        long nine = 9;
        long result = nine;
        for (int i = 1; i < 10; i++) {
            nine = nine * 10 + 9;
            result += nine;
           // System.out.println("9+99+999+...+9999999999=" + result);
        }
      System.out.println("9+99+999+...+9999999999=" + result);
*/

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*long sum = 1;
		for(long num=1;num<=20;num++){
			sum = sum * num;
			   
		}
          
		System.out.println("sun="+sum);
		*/
		
		
		
		/*
		int sum = 0;
		for(int num=1;num<=100;num++){
			sum = sum + num;
		}
             System.out.println("sun="+sum);
             */
	}

}
