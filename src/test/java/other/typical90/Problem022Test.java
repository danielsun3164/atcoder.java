package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem022Test extends TestBase {

	@Test
	void case1() {
		check("2 2 3", "4");
	}

	@Test
	void case2() {
		check("2 2 4", "1");
	}

	@Test
	void case3() {
		check("1000000000000000000 999999999999999999 999999999999999998", "2999999999999999994");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/022");
	}
}
