package seleniumpackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;



public class Java_Class {
	
	static int Instance_Variable = 20;
	
	static public void main(String args[]) {
		Java_Class obj = new Java_Class();
		
		System.out.println("This is the first run");
		
		int Integer_Value = 10;
		char Character = 'J';
		boolean flag = true;
		double Float_value = 8.345;
		System.out.println(Instance_Variable);
		obj.MethodOne();
		
		System.out.println("=====================================================");
		
		
		//Unary Operator
		
		int i=10;
		System.out.println(i++);  //10
		System.out.println(i);  //11
		System.out.println(i--); //11
		System.out.println(i); //10
		
		System.out.println(++i);  //11
		System.out.println(i);  //11
		System.out.println(--i);  //10
		System.out.println(i);  //10
		
		System.out.println("=======================================================");
		
		//Arithmetic Operator
		// +, -, *, /, %
		
		int j=20;
		
		System.out.println(i+j);
		System.out.println(j-i);
		System.out.println(j*i);
		
		System.out.println(j/i); // 2
		System.out.println(j%i); // 0
		
		System.out.println("======================================================");
		
		/*
		 * ==
		 * !=
		 * <=
		 * >=
		 * <
		 * >
		 */
		
		System.out.println(i<j); //true
		System.out.println(i>j); //false
		System.out.println(i==j); //false
		System.out.println(i!=j); //true;
		
		System.out.println("=====================================================");
		
		//Logical Operator

		// AND  &&
		// OR   ||
		int k=20;
		System.out.println(i<j||j==k); //true   //true
		System.out.println(i>j||j==k); //false  //true
		System.out.println(i>j||j<k); //false   //false
		
		System.out.println("========================================================");
		
		//Looping statements
		//for loop
		
		for(int x=i;x<=j;x++) {
/*			if(x==15) {
			//	System.out.println(x);
				continue;
			}else if(x==19){
				break;
			}else if(x==12) {
				System.out.println("This is the value of "+x);
			}else {
				System.out.println(x);
			}*/
			
			switch(x) {
			case 15:
				continue;
			case 19:
				break;
			case 12:
				System.out.println("This is the value of "+x);
			default:
				System.out.println(x);
			}
			
			
			
			
			

		}
		
		System.out.println("======================================================");
		
		int x=i;
		while(x<=j) {
			System.out.println(x);
			x++;
		}
		
		System.out.println("======================================================");
		int y=i;
		do {
			System.out.println(y);
			y++;
		}while(y<=j);
		
		System.out.println("======================================================");
		
		
		//Fibonacci series
		
/*		0 1 1 2 3 5 8 13 21...
		
		int i=0;
		int j=1;
		
		int temp = i+j;
		
		i=j; //5
		j=temp // 8   */
		
		//Prime number
		
/*		A number that has two factors - one and itself
		13
		
		13/2 = 6.5 = 7
		
		13/1, 13/2, 13/3...13/7 = more than one factor then it is a prime number
		
		12/2=6
		1*12=12
		2*6=12
		3*4=12
		4*3=12
		6*2=12
		
		13%1 = 0
		13%2 = 0
		13%3 = 0
		
		int counter=0
		counter=counter+1
		*/
		
		
		
		//Factorial
		
		/*		10! = 10*9*8*7*6*5*4*3*2*1 = 
				
		for(int fact=10;fact>=1;fact--) {
			factorial = factorial*fact;
		}
		
		*/
		
		//Amstrong numbers
/*		1634 = 1^4+6^4+3^4+4^4 = 1634
			
		
		10)1634(163
		   1630
		   -----
		      4     counter=counter+1;
		   -----
		
		   10)163(16
		      160
		      ----
		        3         counter=counter+1 
		      ----*/
		System.out.println("================================================");
	//Arrays
		int Array1[] = new int[5];
		int[] Array2 = new int[5];
		int []Array3 = new int[5];
		char []Arry4 = new char[10];
		
		Array1[0] = 1;
		Array1[1] = 2;
		//Array1[2] = 3;
		Array1[3] = 4;
		Array1[4] = 5;
		//Array1[5] = 6;
		
		for(int arr=0;arr<Array1.length;arr++) {
			System.out.println(Array1[arr]);
		}
		
		System.out.println(Array1[3]);
		
		System.out.println("==============================================");
		
		LocalDate Date = LocalDate.now();
		System.out.println(Date);
		
		LocalTime Time = LocalTime.now();
		System.out.println(Time);
		
		LocalDateTime Date_Time = LocalDateTime.now();
		System.out.println(Date_Time);
		
		ZoneId zid = ZoneId.of("America/Chicago");
		LocalDateTime Date_Time1 = LocalDateTime.now(zid);
		System.out.println(Date_Time1);
		
		System.out.println("==============================================");
		
		String str1 = new String();
		str1= "This is a Java String";
		String str2 = "This is a second string in Java";
		
		System.out.println(str2.charAt(3));
		System.out.println(str2.length());
		System.out.println(str2.compareTo(str1));
		System.out.println(str2.concat(str1));
		System.out.println(str2.contains("Java"));
		System.out.println(str2.indexOf('s'));
		System.out.println(str2.isEmpty());
		System.out.println(str2.replace('s', 'Z'));
		System.out.println(str2.substring(3, 15));
		//System.out.println(str2.);
		
		String Split_String[] = str2.split(" ");
		
		for(int SS=0;SS<Split_String.length;SS++) {
			System.out.println(Split_String[SS]);
		}
		
		System.out.println("=====================================================");
		
		int integer_value = 20;
		String String_Value = "10";
		
		System.out.println(Integer.toString(integer_value)+String_Value); // 2010
		System.out.println(Integer_Value+Integer.parseInt(String_Value)); // 30
		
		System.out.println("=====================================================");
		
		//Collections
		
		ArrayList<Integer> AL = new ArrayList<Integer>();
		AL.add(10);
		AL.add(11);
		AL.add(12);
		AL.add(13);
		AL.add(14);
		
		System.out.println(AL);
		
		LinkedList<Integer> LL = new LinkedList<Integer>();
		LL.add(100);
		LL.addAll(AL);
		System.out.println(LL);
		System.out.println(LL.contains(100));
		System.out.println(LL.indexOf(13));
		System.out.println(LL.remove(4));
		System.out.println(LL);
		System.out.println(LL.size());
		System.out.println(LL.get(0));
	//	System.out.println(LL.);
		LL.add(11);
		LL.add(12);
		LL.add(14);
		System.out.println(LL);
		
		
	System.out.println("=========================================================");	
		
		HashSet<Integer> HS = new HashSet<Integer>();
		HS.add(1000);
		HS.addAll(LL);
		HS.addAll(AL);
		System.out.println(HS);
	System.out.println("=========================================================");
	
		LinkedHashSet<Integer> LHS = new LinkedHashSet<Integer>();
		LHS.add(5000);
		LHS.addAll(HS);
		LHS.addAll(AL);
	System.out.println(LHS);
		HashMap<Integer, String> HM = new HashMap<Integer, String>();
		HM.put(1001, "String1001");
		HM.put(1002, "String1002");
		HM.put(1003, "String1003");
		HM.put(1004, "String1004");
		HM.put(1005, "String1004");
		HM.put(1006, "String1006");
		HM.put(1007, "String1007");
		HM.put(1008, "String1008");
		System.out.println(HM);
	System.out.println("==========================================================");
		LinkedHashMap<Integer, String> LHM = new LinkedHashMap<Integer, String>();
		LHM.put(2001, "String2001");
		LHM.putAll(HM);
		System.out.println(LHM);
		System.out.println(LHM.containsKey(2001));
		System.out.println(LHM.get(1003));
		System.out.println(LHM.remove(1004));
		System.out.println(LHM);
		System.out.println(LHM.replace(1005, "String5001"));
		System.out.println(LHM);
		System.out.println(LHM.size());
	//	System.out.println(LHM.);
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void MethodOne() {
		System.out.println(Instance_Variable);
		int i=10;
		System.out.println(i);
		System.out.println(Instance_Variable);
		//System.out.println(Integer_Value);
		
		/*
		 * 
		 *  Unary Operator
 Arithmetic Operator
 Shift Operator
 Relational Operator
 Logical Operator
 Assignment Operator

		 * 
		 * 
		 * 
		 * 
		 */
		
		//Unary Operator
		
		//int i=10;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void MethodTwo() {
		
	}
	
	public void MethodThree() {
		
	}
	
	public void MethodFour() {
		
	}
	
	public void MethodFive() {
		
	}
}
