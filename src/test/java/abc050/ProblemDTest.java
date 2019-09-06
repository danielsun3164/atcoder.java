package abc050;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("1422");
		ProblemD.main(null);
		assertResultIs("52277");
	}

	@Test
	void test_Case3() throws IOException {
		in.input("1000000000000000000");
		ProblemD.main(null);
		assertResultIs("787014179");
	}
}
