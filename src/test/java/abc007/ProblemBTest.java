package abc007;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		String input = "xyz";
		in.input(input);
		ProblemB.main(null);
		assertTrue(out.toString().compareTo(input) < 0);
	}

	@Test
	void case2() {
		String input = "b";
		in.input(input);
		ProblemB.main(null);
		assertTrue(out.toString().compareTo(input) < 0);
	}

	@Test
	void case3() {
		in.input("a");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void case4() {
		String input = "aaaaa";
		in.input(input);
		ProblemB.main(null);
		assertTrue(out.toString().compareTo(input) < 0);
	}
}
