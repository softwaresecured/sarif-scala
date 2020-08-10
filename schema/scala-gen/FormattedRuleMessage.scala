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
@JsonPropertyOrder(Array("formatId", "arguments"))
class FormattedRuleMessage {

  @JsonProperty("formatId")
  @JsonPropertyDescription("A string that identifies the message format used to format the message that describes this result. The value of formatId must correspond to one of the names in the set of name/value pairs contained in the 'messageFormats' property of the rule object whose 'id' property matches the 'ruleId' property of this result.")
  @BeanProperty
  var formatId: String = _

  @JsonProperty("arguments")
  @JsonPropertyDescription("An array of strings that will be used, in combination with a message format, to construct a result message.")
  @BeanProperty
  var arguments: List[String] = new ArrayList[String]()

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[FormattedRuleMessage].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("formatId")
    sb.append('=')
    sb.append((if ((this.formatId == null)) "<null>" else this.formatId))
    sb.append(',')
    sb.append("arguments")
    sb.append('=')
    sb.append((if ((this.arguments == null)) "<null>" else this.arguments))
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
    result = ((result * 31) + (if ((this.arguments == null)) 0 else this.arguments.hashCode))
    result = ((result * 31) + (if ((this.formatId == null)) 0 else this.formatId.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[FormattedRuleMessage]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[FormattedRuleMessage]
    (((this.arguments == rhs.arguments) || ((this.arguments != null) && this.arguments == rhs.arguments)) && ((this.formatId == rhs.formatId) || ((this.formatId != null) && this.formatId == rhs.formatId)))
  }
}
