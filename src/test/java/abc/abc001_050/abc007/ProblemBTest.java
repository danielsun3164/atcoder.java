package abc.abc001_050.abc007;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("xyz");
	}

	@Test
	void case2() {
		check("b");
	}

	@Test
	void case3() {
		check("a", "-1");
	}

	@Test
	void case4() {
		check("aaaaa");
	}

	private void check(String input) {
		in.input(input);
		ProblemB.main(null);
		assertTrue(out.toString().compareTo(input) < 0, "value is " + out.toString());
	}
}
