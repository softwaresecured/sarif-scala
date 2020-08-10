import java.util.HashMap
import java.util.Map
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
//remove if not needed
import scala.collection.JavaConversions._

object SuppressionState extends Enumeration {

  val SUPPRESSED_IN_SOURCE = new SuppressionState("suppressedInSource")

  val SUPPRESSED_EXTERNALLY = new SuppressionState("suppressedExternally")

  class SuppressionState private (var value: String) extends Val {

    override def toString(): String = this.value
  }

  private val CONSTANTS = new HashMap[String, SuppressionState]()

  for (c <- values) {
    CONSTANTS.put(c.value, c)
  }

  @JsonCreator
  def fromValue(value: String): SuppressionState = {
    val constant = CONSTANTS.get(value)
    if (constant == null) {
      throw new IllegalArgumentException(value)
    } else {
      constant
    }
  }

  implicit def convertValue(v: Value): SuppressionState = v.asInstanceOf[SuppressionState]
}
