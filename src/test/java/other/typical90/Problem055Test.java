package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem055Test extends TestBase {

	@Test
	void case1() {
		check("6 7 1\n" + "1 2 3 4 5 6", "1");
	}

	@Test
	void case2() {
		check("10 1 0\n" + "0 0 0 0 0 0 0 0 0 0", "252");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/055");
	}
}
