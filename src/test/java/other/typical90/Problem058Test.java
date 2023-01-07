package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem058Test extends TestBase {

	@Test
	void case1() {
		check("5 3", "13");
	}

	@Test
	void case2() {
		check("0 100", "0");
	}

	@Test
	void case3() {
		check("99999 1000000000000000000", "84563");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/058");
	}
}
