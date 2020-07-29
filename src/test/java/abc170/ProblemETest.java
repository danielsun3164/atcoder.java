package abc170;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("6 3\n" + "8 1\n" + "6 2\n" + "9 3\n" + "1 1\n" + "2 2\n" + "1 3\n" + "4 3\n" + "2 1\n" + "1 2");
		ProblemE.main(null);
		assertResultIs("6" + LF + "2" + LF + "6");
	}

	@Test
	void case2() {
		in.input("2 2\n" + "4208 1234\n" + "3056 5678\n" + "1 2020\n" + "2 2020");
		ProblemE.main(null);
		assertResultIs("3056\n" + "4208");
	}
}
