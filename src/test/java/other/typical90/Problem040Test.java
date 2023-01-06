package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem040Test extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "5 2 10 3 6\n" + "1 3\n" + "1 3\n" + "0\n" + "1 5\n" + "0", "2");
	}

	@Test
	void case2() {
		check("6 10\n" + "8 6 9 1 2 0\n" + "1 3\n" + "2 3 4\n" + "1 5\n" + "1 5\n" + "1 6\n" + "0", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/040");
	}
}
