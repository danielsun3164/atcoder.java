package abc.abc051_100.abc059;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("36\n" + "24", "GREATER");
	}

	@Test
	void case2() {
		check("850\n" + "3777", "LESS");
	}

	@Test
	void case3() {
		check("9720246\n" + "22516266", "LESS");
	}

	@Test
	void case4() {
		check("123456789012345678901234567890\n" + "234567890123456789012345678901", "LESS");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC072/B");
	}
}
