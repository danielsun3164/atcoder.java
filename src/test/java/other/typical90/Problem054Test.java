package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem054Test extends TestBase {

	@Test
	void case1() {
		check("6 3\n" + "3\n" + "1 2 3\n" + "2\n" + "3 4\n" + "2\n" + "5 6",
				"0" + LF + "1" + LF + "1" + LF + "2" + LF + "-1" + LF + "-1");
	}

	@Test
	void case2() {
		check("4 3\n" + "2\n" + "1 2\n" + "2\n" + "2 3\n" + "2\n" + "3 4", "0" + LF + "1" + LF + "2" + LF + "3");
	}

	@Test
	void case3() {
		check("4 1\n" + "3\n" + "2 3 4", "0" + LF + "-1" + LF + "-1" + LF + "-1");
	}

	@Test
	void case4() {
		check("11 5\n" + "4\n" + "2 6 9 10\n" + "3\n" + "1 3 8\n" + "5\n" + "2 4 6 8 10\n" + "2\n" + "6 7\n" + "4\n"
				+ "5 6 7 8",
				"0" + LF + "2" + LF + "1" + LF + "2" + LF + "2" + LF + "2" + LF + "2" + LF + "1" + LF + "3" + LF + "2"
						+ LF + "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/054");
	}
}
