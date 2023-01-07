package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem033Test extends TestBase {

	@Test
	void case1() {
		check("2 3", "2");
	}

	@Test
	void case2() {
		check("3 4", "4");
	}

	@Test
	void case3() {
		check("3 6", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/033");
	}
}
