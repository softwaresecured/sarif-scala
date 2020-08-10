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
@JsonPropertyOrder(Array("message", "locations", "properties"))
class CodeFlow {

  @JsonProperty("message")
  @JsonPropertyDescription("A message relevant to the code flow")
  @BeanProperty
  var message: String = _

  @JsonProperty("locations")
  @JsonPropertyDescription("An array of 'annotatedCodeLocation' objects, each of which describes a single location visited by the tool in the course of producing the result.")
  @BeanProperty
  var locations: List[AnnotatedCodeLocation] = new ArrayList[AnnotatedCodeLocation]()

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the code flow.")
  @BeanProperty
  var properties: Properties__6 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[CodeFlow].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("message")
    sb.append('=')
    sb.append((if ((this.message == null)) "<null>" else this.message))
    sb.append(',')
    sb.append("locations")
    sb.append('=')
    sb.append((if ((this.locations == null)) "<null>" else this.locations))
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
    result = ((result * 31) + (if ((this.locations == null)) 0 else this.locations.hashCode))
    result = ((result * 31) + (if ((this.message == null)) 0 else this.message.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[CodeFlow]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[CodeFlow]
    ((((this.locations == rhs.locations) || ((this.locations != null) && this.locations == rhs.locations)) && ((this.message == rhs.message) || ((this.message != null) && this.message == rhs.message))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties)))
  }
}
