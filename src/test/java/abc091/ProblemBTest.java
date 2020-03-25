package abc091;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "apple\n" + "orange\n" + "apple\n" + "1\n" + "grape");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("3\n" + "apple\n" + "orange\n" + "apple\n" + "5\n" + "apple\n" + "apple\n" + "apple\n" + "apple\n"
				+ "apple");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("1\n" + "voldemort\n" + "10\n" + "voldemort\n" + "voldemort\n" + "voldemort\n" + "voldemort\n"
				+ "voldemort\n" + "voldemort\n" + "voldemort\n" + "voldemort\n" + "voldemort\n" + "voldemort");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("6\n" + "red\n" + "red\n" + "blue\n" + "yellow\n" + "yellow\n" + "red\n" + "5\n" + "red\n" + "red\n"
				+ "yellow\n" + "green\n" + "blue");
		ProblemB.main(null);
		assertResultIs("1");
	}
}
