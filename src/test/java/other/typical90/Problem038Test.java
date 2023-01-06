package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem038Test extends TestBase {

	@Test
	void case1() {
		check("4 6", "12");
	}

	@Test
	void case2() {
		check("1000000000000000000 3", "Large");
	}

	@Test
	void case3() {
		check("1000000000000000000 1", "1000000000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/038");
	}
}
