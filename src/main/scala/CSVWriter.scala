import java.io.{BufferedWriter, FileWriter}

import MazePosition.Trajectory

import scala.collection.mutable.ListBuffer
import scala.util.Random
import au.com.bytecode.opencsv.CSVWriter
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer



object CSVWriter {

  def clearFile = {
    try {
      lazy val outputFile = new BufferedWriter(new FileWriter("output.csv", false))
      outputFile.flush()
      outputFile.close()
    } catch {
      case e: Exception => println(e.getMessage)
    }
  }

  def write(nameList: Int, trajectory: Trajectory) = {
    lazy val outputFile = new BufferedWriter(new FileWriter("output.csv", true))
    val csvWriter = new CSVWriter(outputFile)

    val csvFieldx = List("trajectory_" + nameList.toString + "_x", trajectory.x.toString())
    val csvFieldy = List("trajectory_" + nameList.toString + "_y", trajectory.y.toString())

    val listOfRecords = new ListBuffer[Array[String]]()
    listOfRecords += csvFieldx.toArray
    listOfRecords += csvFieldy.toArray


    csvWriter.writeAll(listOfRecords.toList)
    outputFile.close()
  }



}

