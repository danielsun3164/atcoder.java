package abc043;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("needed");
		ProblemD.main(null);
		assertResultIs("2 3");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("atcoder");
		ProblemD.main(null);
		assertResultIs("-1 -1");
	}
}
