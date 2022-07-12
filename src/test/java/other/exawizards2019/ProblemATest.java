package other.exawizards2019;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 2 2", "Yes");
	}

	@Test
	void case2() {
		check("3 4 5", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("2019exa/A");
	}
}
