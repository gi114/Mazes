import java.io.{BufferedWriter, FileWriter}

import MazePosition.Trajectory

import scala.collection.mutable.ListBuffer
import scala.util.Random
import au.com.bytecode.opencsv.CSVWriter



object CSVWriter {

  def clearFile = {
    lazy val outputFile = new BufferedWriter(new FileWriter("output.csv", false))
    outputFile.flush()
    outputFile.close()
  }

/*  def write(nameList: Int, trajectory: Trajectory) = {
    lazy val outputFile = new BufferedWriter(new FileWriter("/output.csv", true))
    val csvWriter = new CSVWriter(outputFile)
    val csvField = Array("trajectory " + nameList.toString)
    var listOfRecords = new ListBuffer[Array[String]]()
    listOfRecords += csvField

  }*/



}

