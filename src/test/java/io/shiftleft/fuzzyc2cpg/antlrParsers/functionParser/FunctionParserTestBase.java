package io.shiftleft.fuzzyc2cpg.antlrParsers.functionParser;


import io.shiftleft.fuzzyc2cpg.parser.FunctionParser;
import io.shiftleft.fuzzyc2cpg.parser.functions.AntlrCFunctionParserDriver;

public class FunctionParserTestBase
{
	protected FunctionParser createFunctionParser()
	{
		AntlrCFunctionParserDriver driver = new AntlrCFunctionParserDriver();

		FunctionParser functionParser = new FunctionParser(driver);
		return functionParser;
	}

}
