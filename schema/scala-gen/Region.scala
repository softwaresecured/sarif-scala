import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("startLine", "startColumn", "endLine", "endColumn", "offset", "length"))
class Region {

  @JsonProperty("startLine")
  @JsonPropertyDescription("The line number of the first character in the region.")
  @BeanProperty
  var startLine: java.lang.Integer = _

  @JsonProperty("startColumn")
  @JsonPropertyDescription("The column number of the first character in the region.")
  @BeanProperty
  var startColumn: java.lang.Integer = _

  @JsonProperty("endLine")
  @JsonPropertyDescription("The line number of the last character in the region.")
  @BeanProperty
  var endLine: java.lang.Integer = _

  @JsonProperty("endColumn")
  @JsonPropertyDescription("The column number of the last character in the region.")
  @BeanProperty
  var endColumn: java.lang.Integer = _

  @JsonProperty("offset")
  @JsonPropertyDescription("The zero-based offset from the beginning of the file of the first byte or character in the region.")
  @BeanProperty
  var offset: java.lang.Integer = _

  @JsonProperty("length")
  @JsonPropertyDescription("The length of the region in bytes or characters.")
  @BeanProperty
  var length: java.lang.Integer = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Region].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("startLine")
    sb.append('=')
    sb.append((if ((this.startLine == null)) "<null>" else this.startLine))
    sb.append(',')
    sb.append("startColumn")
    sb.append('=')
    sb.append((if ((this.startColumn == null)) "<null>" else this.startColumn))
    sb.append(',')
    sb.append("endLine")
    sb.append('=')
    sb.append((if ((this.endLine == null)) "<null>" else this.endLine))
    sb.append(',')
    sb.append("endColumn")
    sb.append('=')
    sb.append((if ((this.endColumn == null)) "<null>" else this.endColumn))
    sb.append(',')
    sb.append("offset")
    sb.append('=')
    sb.append((if ((this.offset == null)) "<null>" else this.offset))
    sb.append(',')
    sb.append("length")
    sb.append('=')
    sb.append((if ((this.length == null)) "<null>" else this.length))
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
    result = ((result * 31) + (if ((this.endLine == null)) 0 else this.endLine.hashCode))
    result = ((result * 31) + (if ((this.endColumn == null)) 0 else this.endColumn.hashCode))
    result = ((result * 31) + (if ((this.offset == null)) 0 else this.offset.hashCode))
    result = ((result * 31) + (if ((this.startColumn == null)) 0 else this.startColumn.hashCode))
    result = ((result * 31) + (if ((this.startLine == null)) 0 else this.startLine.hashCode))
    result = ((result * 31) + (if ((this.length == null)) 0 else this.length.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Region]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Region]
    (((((((this.endLine == rhs.endLine) || ((this.endLine != null) && this.endLine == rhs.endLine)) && ((this.endColumn == rhs.endColumn) || ((this.endColumn != null) && this.endColumn == rhs.endColumn))) && ((this.offset == rhs.offset) || ((this.offset != null) && this.offset == rhs.offset))) && ((this.startColumn == rhs.startColumn) || ((this.startColumn != null) && this.startColumn == rhs.startColumn))) && ((this.startLine == rhs.startLine) || ((this.startLine != null) && this.startLine == rhs.startLine))) && ((this.length == rhs.length) || ((this.length != null) && this.length == rhs.length)))
  }
}
