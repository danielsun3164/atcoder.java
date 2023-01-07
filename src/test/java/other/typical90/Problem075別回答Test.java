package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem075別回答Test extends TestBase {

	@Test
	void case1() {
		check("42", "2");
	}

	@Test
	void case2() {
		check("48", "3");
	}

	@Test
	void case3() {
		check("54", "2");
	}

	@Test
	void case4() {
		check("53", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/075");
	}
}
