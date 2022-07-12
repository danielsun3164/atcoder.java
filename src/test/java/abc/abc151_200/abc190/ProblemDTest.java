package abc.abc151_200.abc190;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("12", "4");
	}

	@Test
	void case2() {
		check("1", "2");
	}

	@Test
	void case3() {
		check("963761198400", "1920");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC190/D");
	}
}
