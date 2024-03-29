package other.language_test_202001;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemK_ABC086CTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3 1 2\n" + "6 1 1", "Yes");
	}

	@Test
	void case2() {
		check("1\n" + "2 100 100", "No");
	}

	@Test
	void case3() {
		check("2\n" + "5 1 1\n" + "100 1 1", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC089/C");
	}
}
