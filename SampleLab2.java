package lab1project;


import java.util.Scanner;


public class Main {

	
public static void main(String[] args) {

		
// int s = calculateSum(10);
		
// int s = calculateDifference(5);
	
	
		
Scanner sc = new Scanner(System.in);
		
		
System.out.println("enter one integer");

		
int num = sc.nextInt();
		
sc.close();
		

boolean b = checkNumber(num);

		
if (b) {
			
System.out.println(num + " is increasing number");
		
} else 
{
			
System.out.println(num + " is not increasing number");
		
}
	
}

	

// Method to check whether a number is increasing number
	
static boolean checkNumber(int n) {

		
int nextDigit = n % 10; 

		
while (n > 0) {
			
n = n / 10; 
			
int digit = n % 10; 

			
if (digit > nextDigit)
				
return false;
			
			
nextDigit = digit;
		
}

		
return true;
	
}

	
	

// this method adds n natural numbers divisible by 3 or 5
	
static int calculateSum(int n) {

		
int sum = 0;

		
for (int i = 1; i <= n; i++) {

			
if (i % 3 == 0 || i % 5 == 0) {
				
sum = sum + i; // sum += i;
			
}
		
}

		
return sum;
	
}


	
// this function calculates difference between sum of squares and square of
	
// sum of n natural numbers
	
static int calculateDifference(int n) {

		
int sum = 0;
		
int sumSqr = 0;

		
for (int i = 1; i <= n; i++) {
			
sum = sum + i;
			
sumSqr = sumSqr + i * i;
		
}

		
sum = sum * sum;

		
int result = sumSqr - sum;

		
return result;
	}

}
