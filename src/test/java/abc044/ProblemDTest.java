package abc044;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("87654\n" + "30");
		ProblemD.main(null);
		assertResultIs("10");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("87654\n" + "138");
		ProblemD.main(null);
		assertResultIs("100");
	}

	@Test
	void test_Case3() throws IOException {
		in.input("87654\n" + "45678");
		ProblemD.main(null);
		assertResultIs("-1");
	}

	@Test
	void test_Case4() throws IOException {
		in.input("31415926535\n" + "1");
		ProblemD.main(null);
		assertResultIs("31415926535");
	}

	@Test
	void test_Case5() throws IOException {
		in.input("1\n" + "31415926535");
		ProblemD.main(null);
		assertResultIs("-1");
	}
}
