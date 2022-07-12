package abc.abc151_200.abc171;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

/**
 * 注意：OpenJDK11.0.6で実行するとエラーになるため、必ずほかのバージョンのJDKで実行すること
 */
class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "oof", "575111451");
	}

	@Test
	void case2() {
		check("37564\n" + "whydidyoudesertme", "318008117");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC171/F");
	}
}
