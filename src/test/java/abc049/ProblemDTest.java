package abc049;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4 3 1\n" + "1 2\n" + "2 3\n" + "3 4\n" + "2 3");
		ProblemD.main(null);
		assertResultIs("1 2 2 1");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("4 2 2\n" + "1 2\n" + "2 3\n" + "1 4\n" + "2 3");
		ProblemD.main(null);
		assertResultIs("1 2 2 1");
	}

	@Test
	void test_Case3() throws IOException {
		in.input("7 4 4\n" + "1 2\n" + "2 3\n" + "2 5\n" + "6 7\n" + "3 5\n" + "4 5\n" + "3 4\n" + "6 7");
		ProblemD.main(null);
		assertResultIs("1 1 2 1 2 2 2");
	}
}
