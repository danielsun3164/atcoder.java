package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem060Test extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 2 3 3 2 1", "5");
	}

	@Test
	void case2() {
		check("4\n" + "1 2 3 4", "4");
	}

	@Test
	void case3() {
		check("5\n" + "3 3 3 3 3", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/060");
	}
}
