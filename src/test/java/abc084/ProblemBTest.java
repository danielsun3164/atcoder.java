package abc084;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3 4\n" + "269-6650");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("1 1\n" + "---");
		ProblemB.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("1 2\n" + "7444");
		ProblemB.main(null);
		assertResultIs("No");
	}
}
