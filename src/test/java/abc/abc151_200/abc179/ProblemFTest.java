package abc.abc151_200.abc179;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "1 3\n" + "2 3\n" + "1 4\n" + "2 2\n" + "1 2", "1");
	}

	@Test
	void case2() {
		check("200000 0", "39999200004");
	}

	@Test
	void case3() {
		check("176527 15\n" + "1 81279\n" + "2 22308\n" + "2 133061\n" + "1 80744\n" + "2 44603\n" + "1 170938\n"
				+ "2 139754\n" + "2 15220\n" + "1 172794\n" + "1 159290\n" + "2 156968\n" + "1 56426\n" + "2 77429\n"
				+ "1 97459\n" + "2 71282", "31159505795");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC179/F");
	}
}
