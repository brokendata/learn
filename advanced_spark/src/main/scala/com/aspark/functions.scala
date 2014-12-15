package com.aspark

/**
 * Created by ryan on 12/15/14.
 */

case class MatchData(id1: Int, id2: Int,
                     scores: Array[Double], matched: Boolean)

object functions {

  def isHeader(line: String): Boolean = {
    line.contains("id_1")
  }

  def toDouble(s: String) =
    if ("?".equals(s)) Double.NaN else s.toDouble

  def parse(line: String) = {
    val field = line.split(",")
    val id1 = field(0).toInt
    val id2 = field(1).toInt
    val scores = field.slice(2,11).map(toDouble)
    val matched = field(11).toBoolean
    MatchData(id1, id2, scores, matched)

  }

}
