package abc048;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("aba");
		ProblemD.main(null);
		assertResultIs("Second");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("abc");
		ProblemD.main(null);
		assertResultIs("First");
	}

	@Test
	void test_Case3() throws IOException {
		in.input("abcab");
		ProblemD.main(null);
		assertResultIs("First");
	}
}
