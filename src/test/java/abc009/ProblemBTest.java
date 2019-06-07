package abc009;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "100\n" + "200\n" + "300\n" + "300");
		ProblemB.main(null);
		assertResultIs("200");
	}

	@Test
	void test_Case2() {
		in.input("5\n" + "50\n" + "370\n" + "819\n" + "433\n" + "120");
		ProblemB.main(null);
		assertResultIs("433");
	}

	@Test
	void test_Case3() {
		in.input("6\n" + "100\n" + "100\n" + "100\n" + "200\n" + "200\n" + "200");
		ProblemB.main(null);
		assertResultIs("100");
	}
}
