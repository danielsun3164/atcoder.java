package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem051Test extends TestBase {

	@Test
	void case1() {
		check("5 2 10\n" + "3 8 7 5 11", "2");
	}

	@Test
	void case2() {
		check("5 1 10\n" + "7 7 7 7 7", "5");
	}

	@Test
	void case3() {
		check("40 20 100\n" + "1 3 1 3 4 1 3 5 5 3 3 4 1 5 4 4 3 1 3 4 1 3 2 4 4 1 5 2 5 3 1 3 3 3 5 5 5 2 3 5",
				"137846528820");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/051");
	}
}
