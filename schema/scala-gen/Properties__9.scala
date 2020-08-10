import java.util.LinkedHashSet
import java.util.Set
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("tags"))
class Properties__9 {

  @JsonProperty("tags")
  @JsonDeserialize(as = classOf[java.util.LinkedHashSet])
  @JsonPropertyDescription("A set of distinct strings that provide additional information about the run.")
  @BeanProperty
  var tags: Set[String] = new LinkedHashSet[String]()

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Properties__9].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("tags")
    sb.append('=')
    sb.append((if ((this.tags == null)) "<null>" else this.tags))
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
    result = ((result * 31) + (if ((this.tags == null)) 0 else this.tags.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Properties__9]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Properties__9]
    ((this.tags == rhs.tags) || ((this.tags != null) && this.tags == rhs.tags))
  }
}
