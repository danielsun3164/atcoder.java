package abc.abc009;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "100\n" + "200\n" + "300\n" + "300", "200");
	}

	@Test
	void case2() {
		check("5\n" + "50\n" + "370\n" + "819\n" + "433\n" + "120", "433");
	}

	@Test
	void case3() {
		check("6\n" + "100\n" + "100\n" + "100\n" + "200\n" + "200\n" + "200", "100");
	}
}
