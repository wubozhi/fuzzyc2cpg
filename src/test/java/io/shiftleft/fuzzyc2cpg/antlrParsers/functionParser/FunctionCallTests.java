package io.shiftleft.fuzzyc2cpg.antlrParsers.functionParser;

import static org.junit.Assert.assertTrue;

import io.shiftleft.fuzzyc2cpg.parser.FunctionParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class FunctionCallTests extends FunctionParserTestBase
{

	@Test
	public void testFunctionCall()
	{
		String input = "foo(x);";
		FunctionParser functionParser = createFunctionParser();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("function_argument_list"));
	}

	@Test
	public void testTwoParameters()
	{
		String input = "foo(x,y);";
		FunctionParser functionParser = createFunctionParser();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains(", (function_argument"));
	}

	@Test
	public void testCallViaPtr()
	{
		String input = "ptr->foo(x);";
		FunctionParser functionParser = createFunctionParser();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("function_argument_list"));
	}

	@Test
	public void testCallWithExprInArg()
	{
		String input = "foo(x == 1, x++);";
		FunctionParser functionParser = createFunctionParser();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("function_argument_list"));
	}
}
