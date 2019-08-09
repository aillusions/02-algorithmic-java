package medium;

import java.util.HashSet;
import java.util.Set;

public class ThreeNumberSum {

    public static Integer[] findThreeNumberSum(Integer[] in, int sum) {

        final Set<Integer> checking = new HashSet<>();

        for (int i = 0; i < in.length; i++) {
            if (checking.contains(i)) {
                continue;
            } else {
                checking.add(i);
            }
            for (int j = 0; j < in.length; j++) {
                if (checking.contains(j)) {
                    continue;
                } else {
                    checking.add(j);
                }
                for (int k = 0; k < in.length; k++) {
                    if (checking.contains(k)) {
                        continue;
                    } else {
                        checking.add(k);
                    }
                    if (in[i] + in[j] + in[k] == sum) {
                        return new Integer[]{in[i], in[j], in[k]};
                    }
                    checking.remove(k);
                }
                checking.remove(j);
            }
            checking.remove(i);
        }

        return null;
    }
}
