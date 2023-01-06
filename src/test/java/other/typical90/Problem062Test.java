package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem062Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "3 4\n" + "1 3\n" + "2 3\n" + "2 1", "4" + LF + "2" + LF + "1" + LF + "3");
	}

	@Test
	void case2() {
		check("3\n" + "1 1\n" + "2 2\n" + "3 3", "3" + LF + "2" + LF + "1");
	}

	@Test
	void case3() {
		check("5\n" + "3 4\n" + "4 5\n" + "1 1\n" + "5 1\n" + "3 2", "-1");
	}

	@Test
	void case4() {
		check("6\n" + "5 5\n" + "2 4\n" + "6 6\n" + "5 2\n" + "1 3\n" + "4 1",
				"1" + LF + "5" + LF + "3" + LF + "6" + LF + "4" + LF + "2");
	}

	@Test
	void case5() {
		check("10\n" + "5 1\n" + "3 9\n" + "7 8\n" + "9 3\n" + "3 7\n" + "10 10\n" + "3 5\n" + "4 7\n" + "1 1\n"
				+ "6 6", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/062");
	}
}
