package abc092;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("600\n" + "300\n" + "220\n" + "420");
		ProblemA.main(null);
		assertResultIs("520");
	}

	@Test
	void case2() {
		in.input("555\n" + "555\n" + "400\n" + "200");
		ProblemA.main(null);
		assertResultIs("755");
	}

	@Test
	void case3() {
		in.input("549\n" + "817\n" + "715\n" + "603");
		ProblemA.main(null);
		assertResultIs("1152");
	}
}
