package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem030Test extends TestBase {

	@Test
	void case1() {
		check("15 2", "5");
	}

	@Test
	void case2() {
		check("30 2", "13");
	}

	@Test
	void case3() {
		check("200 4", "0");
	}

	@Test
	void case4() {
		check("869120 1", "869119");
	}

	@Test
	void case5() {
		check("10000000 3", "6798027");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/030");
	}
}
