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
@JsonPropertyOrder(Array("kind", "message", "stack", "innerExceptions"))
class Exception {

  @JsonProperty("kind")
  @JsonPropertyDescription("A string that identifies the kind of exception, for example, the fully qualified type name of an object that was thrown, or the symbolic name of a signal.")
  @BeanProperty
  var kind: String = _

  @JsonProperty("message")
  @JsonPropertyDescription("A string that describes the exception.")
  @BeanProperty
  var message: String = _

  @JsonProperty("stack")
  @JsonPropertyDescription("A call stack that is relevant to a result.")
  @BeanProperty
  var stack: Stack = _

  @JsonProperty("innerExceptions")
  @JsonPropertyDescription("An array of exception objects each of which is considered a cause of this exception.")
  @BeanProperty
  var innerExceptions: List[Exception] = new ArrayList[Exception]()

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Exception].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("kind")
    sb.append('=')
    sb.append((if ((this.kind == null)) "<null>" else this.kind))
    sb.append(',')
    sb.append("message")
    sb.append('=')
    sb.append((if ((this.message == null)) "<null>" else this.message))
    sb.append(',')
    sb.append("stack")
    sb.append('=')
    sb.append((if ((this.stack == null)) "<null>" else this.stack))
    sb.append(',')
    sb.append("innerExceptions")
    sb.append('=')
    sb.append((if ((this.innerExceptions == null)) "<null>" else this.innerExceptions))
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
    result = ((result * 31) + (if ((this.stack == null)) 0 else this.stack.hashCode))
    result = ((result * 31) + (if ((this.innerExceptions == null)) 0 else this.innerExceptions.hashCode))
    result = ((result * 31) + (if ((this.message == null)) 0 else this.message.hashCode))
    result = ((result * 31) + (if ((this.kind == null)) 0 else this.kind.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Exception]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Exception]
    (((((this.stack == rhs.stack) || ((this.stack != null) && this.stack == rhs.stack)) && ((this.innerExceptions == rhs.innerExceptions) || ((this.innerExceptions != null) && this.innerExceptions == rhs.innerExceptions))) && ((this.message == rhs.message) || ((this.message != null) && this.message == rhs.message))) && ((this.kind == rhs.kind) || ((this.kind != null) && this.kind == rhs.kind)))
  }
}
