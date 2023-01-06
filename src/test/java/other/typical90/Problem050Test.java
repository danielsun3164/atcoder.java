package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem050Test extends TestBase {

	@Test
	void case1() {
		check("3 2", "3");
	}

	@Test
	void case2() {
		check("4 4", "2");
	}

	@Test
	void case3() {
		check("5 2", "8");
	}

	@Test
	void case4() {
		check("6783 125", "674508908");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/050");
	}
}
