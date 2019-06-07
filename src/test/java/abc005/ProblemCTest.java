package abc005;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1\n" + "3\n" + "1 2 3\n" + "3\n" + "2 3 4");
		ProblemC.main(null);
		assertResultIs("yes");
	}

	@Test
	void test_Case2() {
		in.input("1\n" + "3\n" + "1 2 3\n" + "3\n" + "2 3 5");
		ProblemC.main(null);
		assertResultIs("no");
	}

	@Test
	void test_Case3() {
		in.input("1\n" + "3\n" + "1 2 3\n" + "10\n" + "1 2 3 4 5 6 7 8 9 10");
		ProblemC.main(null);
		assertResultIs("no");
	}

	@Test
	void test_Case4() {
		in.input("1\n" + "3\n" + "1 2 3\n" + "3\n" + "1 2 2");
		ProblemC.main(null);
		assertResultIs("no");
	}

	@Test
	void test_Case5() {
		in.input("2\n" + "5\n" + "1 3 6 10 15\n" + "3\n" + "4 8 16");
		ProblemC.main(null);
		assertResultIs("yes");
	}
}
