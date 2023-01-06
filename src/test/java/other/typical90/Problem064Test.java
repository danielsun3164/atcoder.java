package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem064Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2 3\n" + "2 3 1\n" + "1 2 -1\n" + "1 3 2", "3" + LF + "4" + LF + "4");
	}

	@Test
	void case2() {
		check("20 10\n" + "61 51 92 -100 -89 -65 -89 -64 -74 7 87 -2 51 -39 -50 63 -23 36 74 37\n" + "2 2 -45\n"
				+ "6 19 82\n" + "2 9 36\n" + "7 13 71\n" + "16 20 90\n" + "18 20 -24\n" + "14 17 -78\n" + "10 11 -55\n"
				+ "7 19 -26\n" + "20 20 -7",
				"1164" + LF + "1328" + LF + "1256" + LF + "1350" + LF + "1440" + LF + "1416" + LF + "1572" + LF + "1482"
						+ LF + "1430" + LF + "1437");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/064");
	}
}
