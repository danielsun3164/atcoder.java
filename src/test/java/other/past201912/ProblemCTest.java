package other.past201912;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws IOException {
		check("4 18 25 20 9 13", "18");
	}

	@Test
	void case2() throws IOException {
		check("95 96 97 98 99 100", "98");
	}

	@Test
	void case3() throws IOException {
		check("19 92 3 35 78 1", "35");
	}
}
