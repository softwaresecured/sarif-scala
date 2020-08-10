import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("analysisTarget", "resultFile", "fullyQualifiedLogicalName", "logicalLocationKey", "decoratedName", "properties"))
class Location {

  @JsonProperty("analysisTarget")
  @JsonPropertyDescription("A physical location relevant to a result. Specifies a reference to a programming artifact together with a range of bytes or characters within that artifact.")
  @BeanProperty
  var analysisTarget: PhysicalLocation = _

  @JsonProperty("resultFile")
  @JsonPropertyDescription("A physical location relevant to a result. Specifies a reference to a programming artifact together with a range of bytes or characters within that artifact.")
  @BeanProperty
  var resultFile: PhysicalLocation = _

  @JsonProperty("fullyQualifiedLogicalName")
  @JsonPropertyDescription("The human-readable fully qualified name of the logical location where the analysis tool produced the result. If 'logicalLocationKey' is not specified, this member is can used to retrieve the location logicalLocation from the logicalLocations dictionary, if one exists.")
  @BeanProperty
  var fullyQualifiedLogicalName: String = _

  @JsonProperty("logicalLocationKey")
  @JsonPropertyDescription("A key used to retrieve the location logicalLocation from the logicalLocations dictionary, when the string specified by 'fullyQualifiedLogicalName' is not unique.")
  @BeanProperty
  var logicalLocationKey: String = _

  @JsonProperty("decoratedName")
  @JsonPropertyDescription("The machine-readable fully qualified name for the logical location where the analysis tool produced the result, such as the mangled function name provided by a C++ compiler that encodes calling convention, return type and other details along with the function name.")
  @BeanProperty
  var decoratedName: String = _

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the location.")
  @BeanProperty
  var properties: Properties__2 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Location].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("analysisTarget")
    sb.append('=')
    sb.append((if ((this.analysisTarget == null)) "<null>" else this.analysisTarget))
    sb.append(',')
    sb.append("resultFile")
    sb.append('=')
    sb.append((if ((this.resultFile == null)) "<null>" else this.resultFile))
    sb.append(',')
    sb.append("fullyQualifiedLogicalName")
    sb.append('=')
    sb.append((if ((this.fullyQualifiedLogicalName == null)) "<null>" else this.fullyQualifiedLogicalName))
    sb.append(',')
    sb.append("logicalLocationKey")
    sb.append('=')
    sb.append((if ((this.logicalLocationKey == null)) "<null>" else this.logicalLocationKey))
    sb.append(',')
    sb.append("decoratedName")
    sb.append('=')
    sb.append((if ((this.decoratedName == null)) "<null>" else this.decoratedName))
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
    result = ((result * 31) + (if ((this.fullyQualifiedLogicalName == null)) 0 else this.fullyQualifiedLogicalName.hashCode))
    result = ((result * 31) + (if ((this.logicalLocationKey == null)) 0 else this.logicalLocationKey.hashCode))
    result = ((result * 31) + (if ((this.decoratedName == null)) 0 else this.decoratedName.hashCode))
    result = ((result * 31) + (if ((this.resultFile == null)) 0 else this.resultFile.hashCode))
    result = ((result * 31) + (if ((this.analysisTarget == null)) 0 else this.analysisTarget.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Location]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Location]
    (((((((this.fullyQualifiedLogicalName == rhs.fullyQualifiedLogicalName) || ((this.fullyQualifiedLogicalName != null) && this.fullyQualifiedLogicalName == rhs.fullyQualifiedLogicalName)) && ((this.logicalLocationKey == rhs.logicalLocationKey) || ((this.logicalLocationKey != null) && this.logicalLocationKey == rhs.logicalLocationKey))) && ((this.decoratedName == rhs.decoratedName) || ((this.decoratedName != null) && this.decoratedName == rhs.decoratedName))) && ((this.resultFile == rhs.resultFile) || ((this.resultFile != null) && this.resultFile == rhs.resultFile))) && ((this.analysisTarget == rhs.analysisTarget) || ((this.analysisTarget != null) && this.analysisTarget == rhs.analysisTarget))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties)))
  }
}
