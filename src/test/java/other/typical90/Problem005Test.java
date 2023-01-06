package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem005Test extends TestBase {

	@Test
	void case1() {
		check("3 7 3\n" + "1 4 9", "3");
	}

	@Test
	void case2() {
		check("5 2 3\n" + "1 4 9", "81");
	}

	@Test
	void case3() {
		check("10000 27 7\n" + "1 3 4 6 7 8 9", "989112238");
	}

	@Test
	void case4() {
		check("1000000000000000000 29 6\n" + "1 2 4 5 7 9", "853993813");
	}

	@Test
	void case5() {
		check("1000000000000000000 957 7\n" + "1 2 3 5 6 7 9", "205384995");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/005");
	}
}
