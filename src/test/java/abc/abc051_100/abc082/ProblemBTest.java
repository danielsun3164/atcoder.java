package abc.abc051_100.abc082;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("yx\n" + "axy", "Yes");
	}

	@Test
	void case2() {
		check("ratcode\n" + "atlas", "Yes");
	}

	@Test
	void case3() {
		check("cd\n" + "abc", "No");
	}

	@Test
	void case4() {
		check("w\n" + "ww", "Yes");
	}

	@Test
	void case5() {
		check("zzz\n" + "zzz", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC087/B");
	}
}
