package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem085Test extends TestBase {

	@Test
	void case1() {
		check("42", "5");
	}

	@Test
	void case2() {
		check("7", "1");
	}

	@Test
	void case3() {
		check("192", "16");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/085");
	}
}
