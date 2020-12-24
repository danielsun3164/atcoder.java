package abc.abc132;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws IOException {
		check("6\n" + "9 1 4 4 6 7", "2");
	}

	@Test
	void case2() throws IOException {
		check("8\n" + "9 1 14 5 5 4 4 14", "0");
	}

	@Test
	void case3() throws IOException {
		check("14\n" + "99592 10342 29105 78532 83018 11639 92015 77204 30914 21912 34519 80835 100000 1", "42685");
	}
}
