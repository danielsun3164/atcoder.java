package abc.abc001_050.abc046;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("gpg", "0");
	}

	@Test
	void case2() {
		check("ggppgggpgg", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC062/D");
	}
}
