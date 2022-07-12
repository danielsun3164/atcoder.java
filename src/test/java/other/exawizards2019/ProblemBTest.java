package other.exawizards2019;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "RRBR", "Yes");
	}

	@Test
	void case2() {
		check("4\n" + "BRBR", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("2019exa/B");
	}
}
