package abc.abc101_150.abc110;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("azzel\n" + "apple", "Yes");
	}

	@Test
	void case2() {
		check("chokudai\n" + "redcoder", "No");
	}

	@Test
	void case3() {
		check("abcdefghijklmnopqrstuvwxyz\n" + "ibyhqfrekavclxjstdwgpzmonu", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC110/C");
	}
}
