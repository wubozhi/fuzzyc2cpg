package io.shiftleft.fuzzyc2cpg

import gremlin.scala.GraphAsScala
import io.shiftleft.codepropertygraph.Cpg
import io.shiftleft.fuzzyc2cpg.output.inmemory.OutputModuleFactory

case class CpgTestFixture(projectName: String) {

  val cpg: Cpg = {
    val dirName = String.format("src/test/resources/testcode/%s", projectName)
    val inmemoryOutputFactory = new OutputModuleFactory()
    val fuzzyc2Cpg = new FuzzyC2Cpg(inmemoryOutputFactory)
    fuzzyc2Cpg.runAndOutput(Set(dirName), Set(".c", ".cc", ".cpp", ".h", ".hpp"))
    inmemoryOutputFactory.getInternalGraph
  }

  def V = cpg.graph.asScala.V

}
