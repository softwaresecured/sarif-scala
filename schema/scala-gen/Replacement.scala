import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("offset", "deletedLength", "insertedBytes"))
class Replacement {

  @JsonProperty("offset")
  @JsonPropertyDescription("A non-negative integer specifying the offset in bytes from the beginning of the file at which bytes are to be removed, inserted or both. An offset of 0 shall denote the first byte in the file.")
  @BeanProperty
  var offset: java.lang.Integer = _

  @JsonProperty("deletedLength")
  @JsonPropertyDescription("The number of bytes to delete, starting at the byte offset specified by offset, measured from the beginning of the file.")
  @BeanProperty
  var deletedLength: java.lang.Integer = _

  @JsonProperty("insertedBytes")
  @JsonPropertyDescription("The MIME Base64-encoded byte sequence to be inserted at the byte offset specified by the 'offset' property, measured from the beginning of the file.")
  @BeanProperty
  var insertedBytes: String = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Replacement].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("offset")
    sb.append('=')
    sb.append((if ((this.offset == null)) "<null>" else this.offset))
    sb.append(',')
    sb.append("deletedLength")
    sb.append('=')
    sb.append((if ((this.deletedLength == null)) "<null>" else this.deletedLength))
    sb.append(',')
    sb.append("insertedBytes")
    sb.append('=')
    sb.append((if ((this.insertedBytes == null)) "<null>" else this.insertedBytes))
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
    result = ((result * 31) + (if ((this.deletedLength == null)) 0 else this.deletedLength.hashCode))
    result = ((result * 31) + (if ((this.offset == null)) 0 else this.offset.hashCode))
    result = ((result * 31) + (if ((this.insertedBytes == null)) 0 else this.insertedBytes.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Replacement]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Replacement]
    ((((this.deletedLength == rhs.deletedLength) || ((this.deletedLength != null) && this.deletedLength == rhs.deletedLength)) && ((this.offset == rhs.offset) || ((this.offset != null) && this.offset == rhs.offset))) && ((this.insertedBytes == rhs.insertedBytes) || ((this.insertedBytes != null) && this.insertedBytes == rhs.insertedBytes)))
  }
}
