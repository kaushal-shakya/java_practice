import java.util.Scanner;
import java.util.*;
	
class Solution{
		void pattern(int n){
		
			for(int j=1; j<=n; j++){
				for(int i=n-j; i>0; i--){
					System.out.print(" ");
				}
				
				for(int i=j; i>0; i--){
					System.out.print("* ");	
				}
				
				System.out.println();
			}
			
			for(int j=1; j<n; j++){
				
				for(int i=1;i<=j; i++){
					System.out.print(" ");
				}
				
				
				for(int i=j; i<n; i++){
					System.out.print("* ");	
				}
				
				System.out.println();
			}
			
		}
		
	
		
		void reverseIndividualWord(String s){
			char[] charArr=s.toCharArray();
			int size=charArr.length;
			for(int i=size-1;i>=0;i--)
			{
				System.out.print(charArr[i]);
			}
			
		}
		
		void primeNumber(){
			double n = 0.0;
			
			System.out.print(2+" ");
			for(int j=2; j < 30; j++){
				
				n = Math.ceil(Math.sqrt(j));
				for(int i=2; i <= n;i++){
					
				//	System.out.println(n);
					
					if(n < 2.0)
						System.out.print(j+" ");
					
					if(j%i == 0){
					
						break;
					}
					System.out.print(j+" ");
					break;
					
				
				}
				
				
			}
		}
		
		HashMap<Character,Integer> letterFrequency(String s){
			HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
			
			for(int i=0; i<s.length(); i++){
				if(hash.containsKey(s.charAt(i))){
					hash.put(s.charAt(i), hash.get(s.charAt(i))+1);
				}else
					hash.put(s.charAt(i),1);	
			}
			
			
			return hash;
		}
		
		void ArmstrongNumber(){
			int result = 0;
			int n = 0;
			int number = 0;
			for(int i=1; i<10000; i++){
				result = 0;
				number = i;
				n = i;
				
				while(n>0){
					int remainder = n%10;
					result += Math.pow(remainder,3);
					n = n/10;
				}
				
				if(number == result)
					System.out.print(number+" ");
		
			}
			
		}
		
}



class Assignment{
	public static void main(String []args){
		
		Scanner scan  = new Scanner(System.in);
		Solution s = new Solution();

 		System.out.println();
		System.out.println("SOLUTION 3:CountLetterFrequency");
		
		System.out.print("Enter the word: ");
		String s1 = scan.nextLine();
	
		HashMap<Character,Integer> h = s.letterFrequency(s1);
		for (Map.Entry<Character, Integer> entry : h.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		
		System.out.println();
		System.out.println("SOLUTION2: letterFrequency");
		System.out.print("Enter a line: ");
		String s2 = scan.nextLine();
		s.reverseIndividualWord(s2);
		
		
		
		System.out.println();
		System.out.println("SOLUTION 1:Print a pattern");
		
		System.out.print("Enter a number to print diamond: ");
		s.pattern(scan.nextInt());
		
		System.out.println();
		System.out.println("SOLUTION 5:First 10 Prime Number");
		
		s.primeNumber();
		
		System.out.println();
		System.out.println();
		
		System.out.println("SOLUTION 4: Armstrong Number");
		s.ArmstrongNumber();
		
	}
}