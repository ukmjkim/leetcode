I use when trying to decide whether or not to use dynamic programming for a given problem:
* Can the problem be divided into subproblems of the same kind?
* Can I define the previous division by a recurrence definition? That is, define F(n) as a function of F(n-1)
* Will I need the results to the sub-problems multiple times or just once?
* Does it make more sense to use a top-down or a bottom-up approach?
* Do I need to worry about the stack if I use a memoized recursive approach?
* Do I need to keep all previous results or can I optimize the space and keep just some of them?

(Example) fibonacci => F(n) = F(n-1) + F(n-2) and F(1) = F(2) = 1

// Classic solution using recursive method
public static long fibonacci(int n) {
    if (n < 3) return 1;
    return fibonacci(n-2) + fibonacci(n-1);
}

// DP
public static long fibonacciDP(int n) {
    long[] results = new long[n+1];
    results[1] = 1;
    results[2] = 1;
    for (int i = 3; i <= n; i++) {
        results[i] = results[i-1] + results[i-2];
    }
    return results[n];
}

