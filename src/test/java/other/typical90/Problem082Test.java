package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem082Test extends TestBase {

	@Test
	void case1() {
		check("3 5", "12");
	}

	@Test
	void case2() {
		check("98 100", "694");
	}

	@Test
	void case3() {
		check("1001 869120", "59367733");
	}

	@Test
	void case4() {
		check("381453331666495446 746254773042091083", "584127830");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/082");
	}
}
