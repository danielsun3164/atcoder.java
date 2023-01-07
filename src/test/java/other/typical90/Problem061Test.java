package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem061Test extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 2\n" + "1 1\n" + "2 3\n" + "3 1\n" + "3 2\n" + "3 3", "1" + LF + "2" + LF + "3");
	}

	@Test
	void case2() {
		check("6\n" + "2 1\n" + "3 1\n" + "2 2\n" + "3 1\n" + "2 3\n" + "3 1", "1" + LF + "1" + LF + "1");
	}

	@Test
	void case3() {
		check("6\n" + "1 1000000000\n" + "2 200000000\n" + "1 30000000\n" + "2 4000000\n" + "1 500000\n" + "3 3",
				"1000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/061");
	}
}
