package abc.abc051_100.abc090;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("11009 11332", "4");
	}

	@Test
	void case2() {
		check("31415 92653", "612");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC091/B");
	}
}
