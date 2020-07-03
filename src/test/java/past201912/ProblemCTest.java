package past201912;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws IOException {
		in.input("4 18 25 20 9 13");
		ProblemC.main(null);
		assertResultIs("18");
	}

	@Test
	void case2() throws IOException {
		in.input("95 96 97 98 99 100");
		ProblemC.main(null);
		assertResultIs("98");
	}

	@Test
	void case3() throws IOException {
		in.input("19 92 3 35 78 1");
		ProblemC.main(null);
		assertResultIs("35");
	}
}
