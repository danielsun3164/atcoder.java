package abc.abc181;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() throws IOException {
		check("2\n" + "1 3\n" + "3 5", "18");
	}

	@Test
	void case2() throws IOException {
		check("3\n" + "11 13\n" + "17 47\n" + "359 44683", "998244353");
	}

	@Test
	void case3() throws IOException {
		check("1\n" + "1 1000000", "500000500000");
	}
}
