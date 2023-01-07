package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem019Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "6 2 3 9 8 6", "2");
	}

	@Test
	void case2() {
		check("3\n" + "1 3 5 5 3 1", "0");
	}

	@Test
	void case3() {
		check("4\n" + "1 2 4 8 16 32 64 128", "85");
	}

	@Test
	void case4() {
		check("15\n" + "73 8 55 26 97 48 37 47 35 55 5 17 62 2 60 23 99 73 34 75 7 46 82 84 29 41 32 31 52 32", "207");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/019");
	}
}
