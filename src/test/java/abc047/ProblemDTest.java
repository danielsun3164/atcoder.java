package abc047;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 2\n" + "100 50 200");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("5 8\n" + "50 30 40 10 20");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case3() throws IOException {
		in.input("10 100\n" + "7 10 4 5 9 3 6 8 2 1");
		ProblemD.main(null);
		assertResultIs("2");
	}
}
