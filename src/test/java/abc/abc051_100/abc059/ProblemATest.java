package abc.abc051_100.abc059;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("atcoder beginner contest", "ABC");
	}

	@Test
	void case2() {
		check("resident register number", "RRN");
	}

	@Test
	void case3() {
		check("k nearest neighbor", "KNN");
	}

	@Test
	void case4() {
		check("async layered coding", "ALC");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC072/A");
	}
}
