package other.language_test_202001;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemB_ABC086ATest extends TestBase {

	@Test
	void case1() {
		check("3 4", "Even");
	}

	@Test
	void case2() {
		check("1 21", "Odd");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC089/A");
	}
}
