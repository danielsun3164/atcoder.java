package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem032Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 10 100\n" + "10 1 100\n" + "100 10 1\n" + "1\n" + "1 2", "111");
	}

	@Test
	void case2() {
		check("4\n" + "1 2 3 4\n" + "5 6 7 8\n" + "9 10 11 12\n" + "13 14 15 16\n" + "3\n" + "1 2\n" + "1 3\n" + "2 3",
				"-1");
	}

	@Test
	void case3() {
		check("3\n" + "1 10 100\n" + "10 1 100\n" + "100 10 1\n" + "0", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/032");
	}
}
