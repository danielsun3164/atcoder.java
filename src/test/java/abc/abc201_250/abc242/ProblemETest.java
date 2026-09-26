package abc.abc201_250.abc242;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3\n" + "AXA\n" + "6\n" + "ABCZAZ\n" + "30\n" + "QWERTYUIOPASDFGHJKLZXCVBNMQWER\n" + "28\n"
				+ "JVIISNEOXHSNEAAENSHXOENSIIVJ\n" + "31\n" + "KVOHEEMSOZZASHENDIGOJRTJVMVSDWW",
				"24" + LF + "29" + LF + "212370247" + LF + "36523399" + LF + "231364016");
	}

	@Test
	void case2() {
		check("1\n" + "30\n" + "QWERTYUIOPASDFGHJKLZXCVBNMQWER", "212370247");
	}

	@Test
	void case3() {
		check("2\n" + "28\n" + "JVIISNEOXHSNEAAENSHXOENSIIVJ\n" + "31\n" + "KVOHEEMSOZZASHENDIGOJRTJVMVSDWW",
				"36523399" + LF + "231364016");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc242/E");
	}
}
