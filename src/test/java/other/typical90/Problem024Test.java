package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem024Test extends TestBase {

	@Test
	void case1() {
		check("2 5\n" + "1 3\n" + "2 1", "Yes");
	}

	@Test
	void case2() {
		check("3 1\n" + "7 8 9\n" + "7 8 9", "No");
	}

	@Test
	void case3() {
		check("7 999999999\n" + "3 1 4 1 5 9 2\n" + "1 2 3 4 5 6 7", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/024");
	}
}
