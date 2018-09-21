import java.io.*;


public class Ch6_SieveOfEratosthenes {
	
	public boolean[] returnPrimes(int n) {
		boolean[] ret = new boolean[n + 1];
		for(int i=0; i<=n; i++) {
			ret[i] = true;
		}
		int prime = 2;
		int i=0;
		while(i < n) {
			
			for( i = prime*prime; i<=n; i += prime) {
				ret[i] = false;
			}
			
			for( i= prime+1; i<= n; i++) {
				if(ret[i]) {
					prime = i;
					break;
				}
			}
		}
		
		
		return ret;
	}
	
	public static void main(String[] args) {
		Ch6_SieveOfEratosthenes s = new Ch6_SieveOfEratosthenes();
		int n = 9999;
		boolean[] arr = s.returnPrimes(n);
		
		for(int i=2; i<=n; i++) {
			if(arr[i])
				System.out.println(i);
		}
	}
}
