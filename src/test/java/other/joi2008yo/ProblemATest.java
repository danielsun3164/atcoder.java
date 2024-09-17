package other.joi2008yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("380", "4");
	}

	@Test
	void case2() {
		check("1", "15");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2008yo/A");
	}
}
