package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem028別回答Test extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 1 3 2\n" + "2 1 4 2", "2" + LF + "1");
	}

	@Test
	void case2() {
		check("2\n" + "1 1 3 4\n" + "3 4 6 5", "9" + LF + "0");
	}

	@Test
	void case3() {
		check("20\n" + "61 98 76 100\n" + "70 99 95 100\n" + "10 64 96 91\n" + "12 37 99 66\n" + "63 93 65 95\n"
				+ "16 18 18 67\n" + "30 47 88 56\n" + "33 6 38 8\n" + "37 19 40 68\n" + "4 56 12 84\n" + "3 16 92 78\n"
				+ "39 24 67 96\n" + "46 1 69 57\n" + "40 34 65 65\n" + "20 38 51 92\n" + "5 32 100 73\n"
				+ "7 33 92 55\n" + "4 46 97 85\n" + "43 18 57 87\n" + "15 29 54 74",
				"1806" + LF + "990" + LF + "1013" + LF + "1221" + LF + "567" + LF + "839" + LF + "413" + LF + "305" + LF
						+ "228" + LF + "121" + LF + "58" + LF + "40" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF
						+ "0" + LF + "0" + LF + "0" + LF + "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/028");
	}
}
