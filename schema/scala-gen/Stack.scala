import java.util.ArrayList
import java.util.List
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("message", "frames", "properties"))
class Stack {

  @JsonProperty("message")
  @JsonPropertyDescription("A message relevant to this call stack.")
  @BeanProperty
  var message: String = _

  @JsonProperty("frames")
  @JsonPropertyDescription("An array of stack frames that represent a sequence of calls, rendered in reverse chronological order, that comprise the call stack.")
  @BeanProperty
  var frames: List[StackFrame] = new ArrayList[StackFrame]()

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the stack.")
  @BeanProperty
  var properties: Properties__4 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Stack].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("message")
    sb.append('=')
    sb.append((if ((this.message == null)) "<null>" else this.message))
    sb.append(',')
    sb.append("frames")
    sb.append('=')
    sb.append((if ((this.frames == null)) "<null>" else this.frames))
    sb.append(',')
    sb.append("properties")
    sb.append('=')
    sb.append((if ((this.properties == null)) "<null>" else this.properties))
    sb.append(',')
    if (sb.charAt((sb.length - 1)) == ',') {
      sb.setCharAt((sb.length - 1), ']')
    } else {
      sb.append(']')
    }
    sb.toString
  }

  override def hashCode(): Int = {
    var result = 1
    result = ((result * 31) + (if ((this.message == null)) 0 else this.message.hashCode))
    result = ((result * 31) + (if ((this.frames == null)) 0 else this.frames.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Stack]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Stack]
    ((((this.message == rhs.message) || ((this.message != null) && this.message == rhs.message)) && ((this.frames == rhs.frames) || ((this.frames != null) && this.frames == rhs.frames))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties)))
  }
}
