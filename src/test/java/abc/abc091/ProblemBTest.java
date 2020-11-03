package abc.abc091;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "apple\n" + "orange\n" + "apple\n" + "1\n" + "grape", "2");
	}

	@Test
	void case2() {
		check("3\n" + "apple\n" + "orange\n" + "apple\n" + "5\n" + "apple\n" + "apple\n" + "apple\n" + "apple\n"
				+ "apple", "1");
	}

	@Test
	void case3() {
		check("1\n" + "voldemort\n" + "10\n" + "voldemort\n" + "voldemort\n" + "voldemort\n" + "voldemort\n"
				+ "voldemort\n" + "voldemort\n" + "voldemort\n" + "voldemort\n" + "voldemort\n" + "voldemort", "0");
	}

	@Test
	void case4() {
		check("6\n" + "red\n" + "red\n" + "blue\n" + "yellow\n" + "yellow\n" + "red\n" + "5\n" + "red\n" + "red\n"
				+ "yellow\n" + "green\n" + "blue", "1");
	}
}
