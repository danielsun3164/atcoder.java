package abc.abc101_150.abc149;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("oder atc", "atcoder");
	}

	@Test
	void case2() {
		check("humu humu", "humuhumu");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC149/A");
	}
}
