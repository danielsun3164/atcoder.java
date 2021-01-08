package abc.abc001_050.abc037;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() throws IOException {
		check("2 3\n" + "1 4 5\n" + "2 4 9", "18");
	}

	@Test
	void case2() throws IOException {
		check("6 6\n" + "1 3 4 6 7 5\n" + "1 2 4 8 8 7\n" + "2 7 9 2 7 2\n" + "9 4 2 7 6 5\n" + "2 8 4 6 7 6\n"
				+ "3 7 9 1 2 7", "170");
	}
}
