package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem045Test extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "0 1\n" + "1 2\n" + "2 0", "2");
	}

	@Test
	void case2() {
		check("5 3\n" + "0 0\n" + "1 1\n" + "0 2\n" + "2 3\n" + "3 1", "4");
	}

	@Test
	void case3() {
		check("10 4\n" + "0 3\n" + "3 5\n" + "2 7\n" + "9 0\n" + "5 6\n" + "4 3\n" + "7 8\n" + "6 5\n" + "9 9\n"
				+ "2 1", "20");
	}

	@Test
	void case4() {
		check("3 2\n" + "0 0\n" + "500000000 500000000\n" + "1000000000 1000000000", "500000000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/045");
	}
}
