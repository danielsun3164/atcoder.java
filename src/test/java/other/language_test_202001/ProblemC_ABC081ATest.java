package other.language_test_202001;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemC_ABC081ATest extends TestBase {

	@Test
	void case1() {
		check("101", "2");
	}

	@Test
	void case2() {
		check("000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC086/A");
	}
}
