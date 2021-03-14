package abc.abc101_150.abc142;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 5\n" + "1 2\n" + "2 3\n" + "2 4\n" + "4 1\n" + "4 3", 3, Set.of(1, 2, 4));
	}

	@Test
	void case2() {
		check("4 5\n" + "1 2\n" + "2 3\n" + "2 4\n" + "1 4\n" + "4 3", "-1");
	}

	@Test
	void case3() {
		check("6 9\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "5 6\n" + "5 1\n" + "5 2\n" + "6 1\n" + "6 2", 4,
				Set.of(2, 3, 4, 5));
	}

	private void check(String input, int expectedK, Set<Integer> expectedVs) {
		in.input(input);
		execute();
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int k = scanner.nextInt();
			assertEquals(expectedK, k);
			Set<Integer> vs = IntStream.range(0, k).map(i -> scanner.nextInt()).boxed().collect(Collectors.toSet());
			assertEquals(expectedVs, vs);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}
