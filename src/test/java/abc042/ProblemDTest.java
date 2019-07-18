package abc042;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 3 1 1");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("10 7 3 4");
		ProblemD.main(null);
		assertResultIs("3570");
	}

	@Test
	void test_Case3() {
		in.input("100000 100000 99999 99999");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case4() {
		in.input("100000 100000 44444 55555");
		ProblemD.main(null);
		assertResultIs("738162020");
	}
}
