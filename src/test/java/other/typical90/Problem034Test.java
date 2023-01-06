package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem034Test extends TestBase {

	@Test
	void case1() {
		check("5 1\n" + "1 2 3 4 5", "1");
	}

	@Test
	void case2() {
		check("5 4\n" + "1 1 2 4 2", "5");
	}

	@Test
	void case3() {
		check("10 2\n" + "1 2 3 4 4 3 2 1 2 3", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/034");
	}
}
