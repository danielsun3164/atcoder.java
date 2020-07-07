package abc167;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + ")\n" + "(()");
		ProblemF.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("2\n" + ")(\n" + "()");
		ProblemF.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("4\n" + "((()))\n" + "((((((\n" + "))))))\n" + "()()()");
		ProblemF.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case4() {
		in.input("3\n" + "(((\n" + ")\n" + ")");
		ProblemF.main(null);
		assertResultIs("No");
	}
}
