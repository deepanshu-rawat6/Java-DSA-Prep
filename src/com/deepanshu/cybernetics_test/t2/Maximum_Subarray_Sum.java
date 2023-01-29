package com.deepanshu.cybernetics_test.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Maximum_Subarray_Sum {
    public static long maximumSum(List<Long> a, long m) {
        long ans = 0;
        TreeSet<Long> set = new TreeSet<>();
        long pre[] = new long[1 + a.size()];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = (a.get(i-1) + pre[i-1])%m;
            set.add(pre[i]);
            if (set.higher(pre[i]) != null) {
                long el = set.higher(pre[i]);
                long curr = (pre[i] - el + m)%m;
                ans = Math.max(ans, curr);
            }
            else {
                ans = Math.max(ans, pre[i]%m);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q > 0 ) {
            int n,m;
            n = sc.nextInt();
            m = sc.nextInt();
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                list.add(x);
            }
            System.out.println(maximumSum(list,m));
            q--;
        }
    }
}
