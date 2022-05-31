// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            int m = Integer.parseInt(s[2]);
            Solution obj = new Solution();
            int ans = obj.nCrModM(n, r, m);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	ArrayList<Integer> findPrimeFactors(int x) {
	    ArrayList<Integer> factors = new ArrayList<>();
	    int square_root = (int) Math.sqrt(x);
	    int factor = 2;
	    while (factor <= square_root && x != 1) {
	        if (x % factor == 0) {
	            factors.add(factor);
	            x /= factor;
	            square_root = (int) Math.sqrt(x);
	        }
	        factor++;
	    }
    	if (x != 1) {
        	factors.add(x);
    	}
    	return factors;
	}
	
	
	int findByCrt(ArrayList<Integer> x, ArrayList<Integer> r) {
	    int kN = x.size();
	    int min_x = 0;
	    while (true) {
	        boolean found = true;
	        for (int i = 0; i < kN; i++) {
	            if (min_x % x.get(i) != r.get(i)) {
	                found = false;
	                break;
	            }
	        }
	        
	        if (found) {
	            return min_x;
	        }
	        
	        min_x++;
	    }
	}
	
	int rCnModP(int n, int r, int p) {
	    if (r == 0 || r == n) {
	        return 1;
	    }
	    int [] triangle = new int[r+1];
	//    std::memset(triangle, 0, sizeof(triangle));
	    triangle[0] = 1;
	    for (int i = 1; i <= n; i++) {
	        for (int j = Math.min(i,r); j > 0; j--) {
	            triangle[j] = (triangle[j]+triangle[j-1]) % p;
	        }
	    }
	    return triangle[r];
	}
	
	int rCnModPrimeLucas(int n, int r, int p) {
	    if (r == 0) {
	        return 1;
	    }
	    int ni = n % p;
	    int ri = r % p;
	    return rCnModPrimeLucas(n/p, r/p, p) * rCnModP(ni, ri, p) % p;
	}
	
	public int nCrModM(int n, int r, int m) {
	    ArrayList<Integer> primes = findPrimeFactors(m);
	    
	    ArrayList<Integer> rem = new ArrayList<>();
	    for (int p : primes) {
	        rem.add(rCnModPrimeLucas(n, r, p));
	    }
	    
	    return findByCrt(primes, rem);
	}

}
