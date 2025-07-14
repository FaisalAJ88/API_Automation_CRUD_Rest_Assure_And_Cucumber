import java.util.*;

public class reverseSherlock {

        static final int MOD = 1000000007;
        static int maxN = 1001;
        static long[] fact = new long[maxN];
        static long[] invFact = new long[maxN];

        // Fast exponentiation
        static long pow(long a, long b) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) == 1)
                    res = (res * a) % MOD;
                a = (a * a) % MOD;
                b >>= 1;
            }
            return res;
        }

        // Modular inverse
        static long modInverse(long a) {
            return pow(a, MOD - 2);
        }

        // Precompute factorials and inverse factorials
        static void init() {
            fact[0] = invFact[0] = 1;
            for (int i = 1; i < maxN; i++) {
                fact[i] = (fact[i - 1] * i) % MOD;
                invFact[i] = modInverse(fact[i]);
            }
        }

        // Multinomial coefficient: n! / (k1! * k2! * ... * kr!)
        static long multinomial(int[] counts) {
            int sum = 0;
            for (int c : counts) sum += c;
            long res = fact[sum];
            for (int c : counts) res = (res * invFact[c]) % MOD;
            return res;
        }

        public static void main(String[] args) {
            init();
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] A = new int[n];
            for(int i = 0; i < n; i++) A[i] = sc.nextInt();

            // Count number of ways to partition A into rounds such that
            // each round forms the front of active arrays
            // We'll simulate rounds where each round we extract x elements

            // dp[i]: number of ways to split first i elements
            long[] dp = new long[n + 1];
            dp[0] = 1;

            for (int i = 1; i <= n; i++) {
                // Try all possible number of elements in current round
                for (int j = 1; j <= i; j++) {
                    // Number of ways to split previous i-j elements and add j sorted elements
                    dp[i] = (dp[i] + dp[i - j] * multinomial(new int[]{j})) % MOD;
                }
            }

            System.out.println(dp[n]);
        }
    }
