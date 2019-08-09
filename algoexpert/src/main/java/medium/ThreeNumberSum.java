package medium;

public class ThreeNumberSum {

    public static Integer[] findThreeNumberSum(Integer[] in, int sum) {

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < in.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (in[i] + in[j] + in[k] == sum) {
                        return new Integer[]{in[i], in[j], in[k]};
                    }
                }
            }
        }

        return null;
    }
}
