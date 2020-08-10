import java.net.URI
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("uri", "uriBaseId", "region"))
class PhysicalLocation {

  @JsonProperty("uri")
  @JsonPropertyDescription("The location of the file as a valid URI.")
  @BeanProperty
  var uri: URI = _

  @JsonProperty("uriBaseId")
  @JsonPropertyDescription("A string that identifies the conceptual base for the 'uri' property (if it is relative), e.g.,'$(SolutionDir)' or '%SRCROOT%'.")
  @BeanProperty
  var uriBaseId: String = _

  @JsonProperty("region")
  @JsonPropertyDescription("A region within a file where a result was detected.")
  @BeanProperty
  var region: Region = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[PhysicalLocation].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("uri")
    sb.append('=')
    sb.append((if ((this.uri == null)) "<null>" else this.uri))
    sb.append(',')
    sb.append("uriBaseId")
    sb.append('=')
    sb.append((if ((this.uriBaseId == null)) "<null>" else this.uriBaseId))
    sb.append(',')
    sb.append("region")
    sb.append('=')
    sb.append((if ((this.region == null)) "<null>" else this.region))
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
    result = ((result * 31) + (if ((this.region == null)) 0 else this.region.hashCode))
    result = ((result * 31) + (if ((this.uri == null)) 0 else this.uri.hashCode))
    result = ((result * 31) + (if ((this.uriBaseId == null)) 0 else this.uriBaseId.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[PhysicalLocation]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[PhysicalLocation]
    ((((this.region == rhs.region) || ((this.region != null) && this.region == rhs.region)) && ((this.uri == rhs.uri) || ((this.uri != null) && this.uri == rhs.uri))) && ((this.uriBaseId == rhs.uriBaseId) || ((this.uriBaseId != null) && this.uriBaseId == rhs.uriBaseId)))
  }
}
