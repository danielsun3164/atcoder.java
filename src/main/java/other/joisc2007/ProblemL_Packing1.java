package other.joisc2007;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * http://hydra.nat.uni-magdeburg.de/packing/csq/csq6.html のデータを使用
 */
public class ProblemL_Packing1 {

	public static void main(String[] args) {
		int[][] result = new int[][] { { 18768060, 18768060 }, { 81231940, 18768060 }, { 50000000, 39589353 },
				{ 18768060, 60410647 }, { 81231940, 60410647 }, { 50000000, 81231940 } };
		for (int[] a : result) {
			System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
