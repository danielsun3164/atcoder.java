package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem031Test extends TestBase {

	@Test
	void case1() {
		check("1\n" + "0\n" + "2", "First");
	}

	@Test
	void case2() {
		check("2\n" + "10 10\n" + "10 10", "Second");
	}

	@Test
	void case3() {
		check("1\n" + "1\n" + "1", "Second");
	}

	@Test
	void case4() {
		check("6\n" + "3 1 4 1 5 9\n" + "2 7 1 8 2 8", "Second");
	}

	@Test
	void case5() {
		check("6\n" + "1 2 3 4 5 6\n" + "1 2 3 4 5 6", "First");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/031");
	}
}
