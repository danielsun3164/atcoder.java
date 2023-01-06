package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem025別回答Test extends TestBase {

	@Test
	void case1() {
		check("999 434", "2");
	}

	@Test
	void case2() {
		check("255 15", "2");
	}

	@Test
	void case3() {
		check("9999999999 1", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/025");
	}
}
