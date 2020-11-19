package other.abl;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1\n" + "1\n" + "2\n" + "3", "2");
	}

	@Test
	void case2() {
		check("5\n" + "30\n" + "10\n" + "20\n" + "40\n" + "20\n" + "10\n" + "10\n" + "30\n" + "50\n" + "60", "516");
	}
}
