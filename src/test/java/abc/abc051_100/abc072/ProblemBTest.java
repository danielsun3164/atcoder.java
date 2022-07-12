package abc.abc051_100.abc072;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("atcoder", "acdr");
	}

	@Test
	void case2() {
		check("aaaa", "aa");
	}

	@Test
	void case3() {
		check("z", "z");
	}

	@Test
	void case4() {
		check("fukuokayamaguchi", "fkoaaauh");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC082/B");
	}
}
