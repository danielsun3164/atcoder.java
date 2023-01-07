package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem049Test extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "1 1 1\n" + "1 2 2\n" + "10 1 2", "2");
	}

	@Test
	void case2() {
		check("2 3\n" + "1 1 1\n" + "10 2 2\n" + "1 1 2", "2");
	}

	@Test
	void case3() {
		check("4 5\n" + "3 1 2\n" + "5 2 4\n" + "9 3 4\n" + "4 1 4\n" + "8 2 4", "-1");
	}

	@Test
	void case4() {
		check("9 11\n" + "10 2 7\n" + "100 1 6\n" + "1 2 8\n" + "39 4 5\n" + "62 3 4\n" + "81 1 3\n" + "55 8 8\n"
				+ "91 5 5\n" + "14 8 9\n" + "37 5 5\n" + "41 7 9", "385");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/049");
	}
}
