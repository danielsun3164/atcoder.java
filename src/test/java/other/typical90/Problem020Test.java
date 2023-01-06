package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem020Test extends TestBase {

	@Test
	void case1() {
		check("4 3 2", "Yes");
	}

	@Test
	void case2() {
		check("16 3 2", "No");
	}

	@Test
	void case3() {
		check("8 3 2", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/020");
	}
}
