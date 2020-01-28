public class FastFib {
	int[] table;
	public int fib(int n) {
		if(n < 0) return -1;
		table = new int[n+1];
		for(int i = 0; i <= n; ++i) {
			table[i]--;
		}
		return subprobFib(n);
	}

	private int subprobFib(int n) {
		if(n == 0 || n == 1) {
			table[n] = n;
			return table[n];
		}
		if(table[n-2] < 0) {
			table[n-2] = subprobFib(n-2);
			System.out.println("call to subprobFib on "+(n-2));
		}
		if(table[n-1] < 0) {
			table[n-1] = subprobFib(n-1);
			System.out.println("call to subprobFib on "+(n-1));
		}
		table[n] = table[n-1] + table[n-2];
		return table[n];
	}

	public static void main(String[] args) {
		FastFib f = new FastFib();
		System.out.println(f.fib(6));
	}
}
