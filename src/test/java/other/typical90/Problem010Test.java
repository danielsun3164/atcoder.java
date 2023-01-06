package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem010Test extends TestBase {

	@Test
	void case1() {
		check("7\n" + "1 72\n" + "2 78\n" + "2 94\n" + "1 23\n" + "2 89\n" + "1 40\n" + "1 75\n" + "1\n" + "2 6",
				"63 261");
	}

	@Test
	void case2() {
		check("7\n" + "1 72\n" + "2 78\n" + "2 94\n" + "1 23\n" + "2 89\n" + "1 40\n" + "1 75\n" + "10\n" + "1 3\n"
				+ "2 4\n" + "3 5\n" + "4 6\n" + "5 7\n" + "1 5\n" + "2 6\n" + "3 7\n" + "1 6\n" + "2 7",
				"72 172" + LF + "23 172" + LF + "23 183" + LF + "63 89" + LF + "115 89" + LF + "95 261" + LF + "63 261"
						+ LF + "138 183" + LF + "135 261" + LF + "138 261");
	}

	@Test
	void case3() {
		check("20\n" + "2 90\n" + "1 67\n" + "2 9\n" + "2 17\n" + "2 85\n" + "2 43\n" + "2 11\n" + "1 32\n" + "2 16\n"
				+ "1 19\n" + "2 65\n" + "1 14\n" + "1 51\n" + "2 94\n" + "1 4\n" + "1 55\n" + "2 90\n" + "1 89\n"
				+ "1 35\n" + "2 81\n" + "20\n" + "3 17\n" + "5 5\n" + "11 11\n" + "8 10\n" + "3 13\n" + "2 6\n"
				+ "3 7\n" + "3 5\n" + "12 18\n" + "4 8\n" + "3 16\n" + "6 8\n" + "3 20\n" + "1 12\n" + "1 6\n"
				+ "5 16\n" + "3 10\n" + "17 19\n" + "4 4\n" + "7 15",
				"175 430" + LF + "0 85" + LF + "0 65" + LF + "51 16" + LF + "116 246" + LF + "67 154" + LF + "0 165"
						+ LF + "0 111" + LF + "213 184" + LF + "32 156" + LF + "175 340" + LF + "32 54" + LF + "299 511"
						+ LF + "132 336" + LF + "67 244" + LF + "175 314" + LF + "51 181" + LF + "124 90" + LF + "0 17"
						+ LF + "120 186");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/010");
	}
}
