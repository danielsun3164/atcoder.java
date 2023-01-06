package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem086Test extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "1 2 3 50\n" + "2 3 4 45", "13");
	}

	@Test
	void case2() {
		check("8 2\n" + "2 3 6 1152886174205865983\n" + "1 2 8 1116611213275394047", "395781543");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/086");
	}
}
