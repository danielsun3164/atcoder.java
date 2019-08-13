package abc046;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("gpg");
		ProblemD.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("ggppgggpgg");
		ProblemD.main(null);
		assertResultIs("2");
	}
}
