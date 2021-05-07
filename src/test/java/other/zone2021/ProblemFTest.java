package other.zone2021;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import other.zone2021.ProblemF.DisjointSetUnion;
import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(4, 1, new int[] { 3 });
	}

	@Test
	void case2() {
		check(8, 0, new int[] {});
	}

	@Test
	void case3() {
		check("8 7\n" + "1 2 3 4 5 6 7", "-1");
	}

	private void check(int n, int m, int[] a) {
		StringBuilder sb = new StringBuilder();
		sb.append(n).append(" ").append(m).append("\n");
		sb.append(Arrays.stream(a).mapToObj(ai -> String.valueOf(ai)).collect(Collectors.joining(" ")));
		Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
		in.input(sb.toString());
		execute();
		DisjointSetUnion dsu = new DisjointSetUnion(n);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			IntStream.range(1, n).forEach(i -> {
				int u = scanner.nextInt(), v = scanner.nextInt();
				assertFalse(u + "^" + v + "=" + (u ^ v) + "はaに含まれている", set.contains(u ^ v));
				dsu.merge(u, v);
			});
			assertEquals(1, dsu.groupNum);
		} catch (IOException | NoSuchElementException e) {
			e.printStackTrace();
			fail();
		}
	}
}
