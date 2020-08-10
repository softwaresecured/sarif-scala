import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array())
class Rules {

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Rules].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    if (sb.charAt((sb.length - 1)) == ',') {
      sb.setCharAt((sb.length - 1), ']')
    } else {
      sb.append(']')
    }
    sb.toString
  }

  override def hashCode(): Int = {
    val result = 1
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Rules]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Rules]
    true
  }
}
