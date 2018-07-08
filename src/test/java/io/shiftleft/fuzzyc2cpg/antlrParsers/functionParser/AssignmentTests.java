package io.shiftleft.fuzzyc2cpg.antlrParsers.functionParser;


import static org.junit.Assert.assertTrue;

import io.shiftleft.fuzzyc2cpg.parser.FunctionParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class AssignmentTests extends FunctionParserTestBase
{

	@Test
	public void testAssignmentExpr()
	{
		String input = "x = y + 1;";
		FunctionParser functionParser = createFunctionParser();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output.contains("assign_expr"));
	}

	@Test
	public void testComplexAssignment()
	{
		String input = "k += ((c = text[k]) >= sBMHCharSetSize) ? patlen : skip[c];";
		FunctionParser functionParser = createFunctionParser();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output.contains("assign_expr"));
	}

	@Test
	public void testPrivateInName()
	{
		String input = "struct acpi_battery *battery = m->private;";
		FunctionParser functionParser = createFunctionParser();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output.contains("simple_decl"));
	}

}
