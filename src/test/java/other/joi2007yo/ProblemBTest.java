package other.joi2007yo;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1\n" + "4\n" + "5\n" + "7\n" + "9\n" + "6\n" + "10\n" + "11\n" + "12\n" + "13\n" + "14\n"
				+ "15\n" + "16\n" + "17\n" + "18\n" + "19\n" + "20\n" + "21\n" + "22\n" + "23\n" + "24\n" + "25\n"
				+ "26\n" + "27\n" + "28\n" + "29\n" + "30", "2" + LF + "8");
	}

	@Test
	void case2() {
		check("9\n" + "30\n" + "6\n" + "12\n" + "10\n" + "20\n" + "21\n" + "11\n" + "7\n" + "5\n" + "28\n" + "4\n"
				+ "18\n" + "29\n" + "17\n" + "19\n" + "27\n" + "13\n" + "16\n" + "26\n" + "14\n" + "23\n" + "22\n"
				+ "15\n" + "3\n" + "1\n" + "24\n" + "25", "2" + LF + "8");
	}
}
