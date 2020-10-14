package abc.abc123;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "2\n" + "4\n" + "8\n" + "9\n" + "15", "Yay!");
	}

	@Test
	void case2() {
		check("15\n" + "18\n" + "26\n" + "35\n" + "36\n" + "18", ":(");
	}
}
