package abc051;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 3\n" + "1 2 1\n" + "1 3 1\n" + "2 3 3");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("3 2\n" + "1 2 1\n" + "2 3 1");
		ProblemD.main(null);
		assertResultIs("0");
	}
}
