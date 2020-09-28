package other.joi2006yo;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "A a\n" + "0 5\n" + "5 4\n" + "10\n" + "A\n" + "B\n" + "C\n" + "0\n" + "1\n" + "4\n" + "5\n"
				+ "a\n" + "b\n" + "A", "aBC5144aba");
	}
}
