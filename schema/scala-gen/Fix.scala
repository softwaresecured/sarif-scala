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
@JsonPropertyOrder(Array("description", "fileChanges"))
class Fix {

  @JsonProperty("description")
  @JsonPropertyDescription("A string that describes the proposed fix, enabling viewers to present a proposed change to an end user.")
  @BeanProperty
  var description: String = _

  @JsonProperty("fileChanges")
  @JsonPropertyDescription("One or more file changes that comprise a fix for a result.")
  @BeanProperty
  var fileChanges: List[FileChange] = new ArrayList[FileChange]()

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Fix].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("description")
    sb.append('=')
    sb.append((if ((this.description == null)) "<null>" else this.description))
    sb.append(',')
    sb.append("fileChanges")
    sb.append('=')
    sb.append((if ((this.fileChanges == null)) "<null>" else this.fileChanges))
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
    result = ((result * 31) + (if ((this.description == null)) 0 else this.description.hashCode))
    result = ((result * 31) + (if ((this.fileChanges == null)) 0 else this.fileChanges.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Fix]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Fix]
    (((this.description == rhs.description) || ((this.description != null) && this.description == rhs.description)) && ((this.fileChanges == rhs.fileChanges) || ((this.fileChanges != null) && this.fileChanges == rhs.fileChanges)))
  }
}
