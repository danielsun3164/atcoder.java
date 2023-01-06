package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem013Test extends TestBase {

	@Test
	void case1() {
		check("7 9\n" + "1 2 2\n" + "1 3 3\n" + "2 5 2\n" + "3 4 1\n" + "3 5 4\n" + "4 7 5\n" + "5 6 1\n" + "5 7 6\n"
				+ "6 7 3", "8" + LF + "8" + LF + "9" + LF + "9" + LF + "8" + LF + "8" + LF + "8");
	}

	@Test
	void case2() {
		check("4 3\n" + "1 2 1\n" + "2 3 10\n" + "3 4 100", "111" + LF + "111" + LF + "111" + LF + "111");
	}

	@Test
	void case3() {
		check("4 3\n" + "1 2 314\n" + "1 3 159\n" + "1 4 265", "265" + LF + "893" + LF + "583" + LF + "265");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/013");
	}
}
