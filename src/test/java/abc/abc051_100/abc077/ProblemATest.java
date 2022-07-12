package abc.abc051_100.abc077;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("pot\n" + "top", "YES");
	}

	@Test
	void case2() {
		check("tab\n" + "bet", "NO");
	}

	@Test
	void case3() {
		check("eye\n" + "eel", "NO");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC084/A");
	}
}
