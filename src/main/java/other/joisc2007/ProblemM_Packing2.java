package other.joisc2007;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * http://hydra.nat.uni-magdeburg.de/packing/csq/csq11.html のデータを使用
 */
public class ProblemM_Packing2 {

	public static void main(String[] args) {
		int[][] result = new int[][] { { 14239924, 14239924 }, { 42719771, 14239924 }, { 84329673, 15670327 },
				{ 58250656, 38112363 }, { 14239924, 42719771 }, { 85760076, 45483490 }, { 38112363, 58250656 },
				{ 65621783, 65621783 }, { 15670327, 84329673 }, { 45483490, 85760076 }, { 85760076, 85760076 } };
		for (int[] a : result) {
			System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
