package abc.abc123;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("29\n" + "20\n" + "7\n" + "35\n" + "120", "215");
	}

	@Test
	void case2() {
		check("101\n" + "86\n" + "119\n" + "108\n" + "57", "481");
	}

	@Test
	void case3() {
		check("123\n" + "123\n" + "123\n" + "123\n" + "123", "643");
	}
}
