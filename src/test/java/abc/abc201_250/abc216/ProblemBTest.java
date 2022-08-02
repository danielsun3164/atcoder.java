package abc.abc201_250.abc216;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "tanaka taro\n" + "sato hanako\n" + "tanaka taro", "Yes");
	}

	@Test
	void case2() {
		check("3\n" + "saito ichiro\n" + "saito jiro\n" + "saito saburo", "No");
	}

	@Test
	void case3() {
		check("4\n" + "sypdgidop bkseq\n" + "bajsqz hh\n" + "ozjekw mcybmtt\n" + "qfeysvw dbo", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc216/B");
	}
}
