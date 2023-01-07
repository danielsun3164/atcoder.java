package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem063Test extends TestBase {

	@Test
	void case1() {
		check("4 6\n" + "1 1 1 1 1 2\n" + "1 2 2 2 2 2\n" + "1 2 2 3 2 3\n" + "1 2 3 2 2 3", "6");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2 3\n" + "4 5 6\n" + "7 8 9", "1");
	}

	@Test
	void case3() {
		check("5 3\n" + "7 7 7\n" + "7 7 7\n" + "7 7 7\n" + "7 7 7\n" + "7 7 7", "15");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/063");
	}
}
