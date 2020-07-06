package abc166;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws IOException {
		in.input("4 3\n" + "1 2 3 4\n" + "1 3\n" + "2 3\n" + "2 4");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() throws IOException {
		in.input("6 5\n" + "8 6 9 1 2 1\n" + "1 3\n" + "4 2\n" + "4 3\n" + "4 6\n" + "4 6");
		ProblemC.main(null);
		assertResultIs("3");
	}
}
