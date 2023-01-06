package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem070Test extends TestBase {

	@Test
	void case1() {
		check("2\n" + "-1 2\n" + "1 1", "3");
	}

	@Test
	void case2() {
		check("2\n" + "1 0\n" + "0 1", "2");
	}

	@Test
	void case3() {
		check("5\n" + "2 5\n" + "2 5\n" + "-3 4\n" + "-4 -8\n" + "6 -2", "35");
	}

	@Test
	void case4() {
		check("4\n" + "1000000000 1000000000\n" + "-1000000000 1000000000\n" + "-1000000000 -1000000000\n"
				+ "1000000000 -1000000000", "8000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/070");
	}
}
