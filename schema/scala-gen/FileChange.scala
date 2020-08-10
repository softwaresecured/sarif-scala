import java.net.URI
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
@JsonPropertyOrder(Array("uri", "uriBaseId", "replacements"))
class FileChange {

  @JsonProperty("uri")
  @JsonPropertyDescription("A string that represents the location of the file to change as a valid URI.")
  @BeanProperty
  var uri: URI = _

  @JsonProperty("uriBaseId")
  @JsonPropertyDescription("A string that identifies the conceptual base for the 'uri' property (if it is relative), e.g.,'$(SolutionDir)' or '%SRCROOT%'.")
  @BeanProperty
  var uriBaseId: String = _

  @JsonProperty("replacements")
  @JsonPropertyDescription("An array of replacement objects, each of which represents the replacement of a single range of bytes in a single file specified by 'uri'.")
  @BeanProperty
  var replacements: List[Replacement] = new ArrayList[Replacement]()

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[FileChange].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("uri")
    sb.append('=')
    sb.append((if ((this.uri == null)) "<null>" else this.uri))
    sb.append(',')
    sb.append("uriBaseId")
    sb.append('=')
    sb.append((if ((this.uriBaseId == null)) "<null>" else this.uriBaseId))
    sb.append(',')
    sb.append("replacements")
    sb.append('=')
    sb.append((if ((this.replacements == null)) "<null>" else this.replacements))
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
    result = ((result * 31) + (if ((this.replacements == null)) 0 else this.replacements.hashCode))
    result = ((result * 31) + (if ((this.uri == null)) 0 else this.uri.hashCode))
    result = ((result * 31) + (if ((this.uriBaseId == null)) 0 else this.uriBaseId.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[FileChange]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[FileChange]
    ((((this.replacements == rhs.replacements) || ((this.replacements != null) && this.replacements == rhs.replacements)) && ((this.uri == rhs.uri) || ((this.uri != null) && this.uri == rhs.uri))) && ((this.uriBaseId == rhs.uriBaseId) || ((this.uriBaseId != null) && this.uriBaseId == rhs.uriBaseId)))
  }
}
