package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem074Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "aba", "2");
	}

	@Test
	void case2() {
		check("10\n" + "aaaaaaaaaa", "0");
	}

	@Test
	void case3() {
		check("5\n" + "baaca", "17");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/074");
	}
}
