package abc.abc001_050.abc046;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "2");
	}

	@Test
	void case2() {
		check("1 10", "10");
	}

	@Test
	void case3() {
		check("10 8", "322828856");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC062/B");
	}
}
