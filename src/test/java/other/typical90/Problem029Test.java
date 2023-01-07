package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem029Test extends TestBase {

	@Test
	void case1() {
		check("100 4\n" + "27 100\n" + "8 39\n" + "83 97\n" + "24 75", "1" + LF + "2" + LF + "2" + LF + "3");
	}

	@Test
	void case2() {
		check("3 5\n" + "1 2\n" + "2 2\n" + "2 3\n" + "3 3\n" + "1 2", "1" + LF + "2" + LF + "3" + LF + "4" + LF + "4");
	}

	@Test
	void case3() {
		check("10 10\n" + "1 3\n" + "3 5\n" + "5 7\n" + "7 9\n" + "2 4\n" + "4 6\n" + "6 8\n" + "3 5\n" + "5 7\n"
				+ "4 6",
				"1" + LF + "2" + LF + "3" + LF + "4" + LF + "3" + LF + "4" + LF + "5" + LF + "5" + LF + "6" + LF + "7");
	}

	@Test
	void case4() {
		check("500000 7\n" + "1 500000\n" + "500000 500000\n" + "1 500000\n" + "1 1\n" + "1 500000\n"
				+ "500000 500000\n" + "1 500000",
				"1" + LF + "2" + LF + "3" + LF + "4" + LF + "5" + LF + "6" + LF + "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/029");
	}
}
