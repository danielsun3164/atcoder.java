package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem052Test extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 2 3 5 7 11\n" + "4 6 8 9 10 12", "1421");
	}

	@Test
	void case2() {
		check("1\n" + "11 13 17 19 23 29", "112");
	}

	@Test
	void case3() {
		check("7\n" + "19 23 51 59 91 99\n" + "15 45 56 65 69 94\n" + "7 11 16 34 59 95\n" + "27 30 40 43 83 85\n"
				+ "19 23 25 27 45 99\n" + "27 48 52 53 60 81\n" + "21 36 49 72 82 84", "670838273");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/052");
	}
}
