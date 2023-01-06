package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem035Test extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 2\n" + "2 3\n" + "3 4\n" + "1 5\n" + "3 6\n" + "5\n" + "2 1 2\n" + "3 1 3 5\n" + "4 2 3 4 5\n"
				+ "5 1 2 3 5 6\n" + "6 1 2 3 4 5 6", "1" + LF + "3" + LF + "4" + LF + "4" + LF + "5");
	}

	@Test
	void case2() {
		check("6\n" + "1 2\n" + "2 3\n" + "3 4\n" + "1 5\n" + "3 6\n" + "5\n" + "2 1 2\n" + "2 3 4\n" + "2 4 6\n"
				+ "2 1 5\n" + "2 2 5", "1" + LF + "1" + LF + "2" + LF + "1" + LF + "2");
	}

	@Test
	void case3() {
		check("6\n" + "1 2\n" + "2 3\n" + "3 4\n" + "1 5\n" + "3 6\n" + "5\n" + "3 1 2 3\n" + "3 1 2 5\n" + "3 1 3 6\n"
				+ "3 3 4 5\n" + "3 4 5 6", "2" + LF + "2" + LF + "3" + LF + "4" + LF + "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/035");
	}
}
