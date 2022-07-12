package other.language_test_202001;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF_ABC083BTest extends TestBase {

	@Test
	void case1() {
		check("20 2 5", "84");
	}

	@Test
	void case2() {
		check("10 1 2", "13");
	}

	@Test
	void case3() {
		check("100 4 16", "4554");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC088/B");
	}
}
