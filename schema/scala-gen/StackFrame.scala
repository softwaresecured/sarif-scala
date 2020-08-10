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
@JsonPropertyOrder(Array("message", "uri", "uriBaseId", "line", "column", "module", "threadId", "fullyQualifiedLogicalName", "logicalLocationKey", "address", "offset", "parameters", "properties"))
class StackFrame {

  @JsonProperty("message")
  @JsonPropertyDescription("A message relevant to this stack frame.")
  @BeanProperty
  var message: String = _

  @JsonProperty("uri")
  @JsonPropertyDescription("The uri of the source code file to which this stack frame refers.")
  @BeanProperty
  var uri: URI = _

  @JsonProperty("uriBaseId")
  @JsonPropertyDescription("A string that identifies the conceptual base for the 'uri' property (if it is relative), e.g.,'$(SolutionDir)' or '%SRCROOT%'.")
  @BeanProperty
  var uriBaseId: String = _

  @JsonProperty("line")
  @JsonPropertyDescription("The line of the location to which this stack frame refers.")
  @BeanProperty
  var line: java.lang.Integer = _

  @JsonProperty("column")
  @JsonPropertyDescription("The line of the location to which this stack frame refers.")
  @BeanProperty
  var column: java.lang.Integer = _

  @JsonProperty("module")
  @JsonPropertyDescription("The name of the module that contains the code of this stack frame.")
  @BeanProperty
  var module: String = _

  @JsonProperty("threadId")
  @JsonPropertyDescription("The thread identifier of the stack frame.")
  @BeanProperty
  var threadId: java.lang.Integer = _

  @JsonProperty("fullyQualifiedLogicalName")
  @JsonPropertyDescription("The fully qualified name of the method or function that is executing.")
  @BeanProperty
  var fullyQualifiedLogicalName: String = _

  @JsonProperty("logicalLocationKey")
  @JsonPropertyDescription("A key used to retrieve the stack frame logicalLocation from the logicalLocations dictionary, when the 'fullyQualifiedLogicalName' is not unique.")
  @BeanProperty
  var logicalLocationKey: String = _

  @JsonProperty("address")
  @JsonPropertyDescription("The address of the method or function that is executing.")
  @BeanProperty
  var address: java.lang.Integer = _

  @JsonProperty("offset")
  @JsonPropertyDescription("The offset from the method or function that is executing.")
  @BeanProperty
  var offset: java.lang.Integer = _

  @JsonProperty("parameters")
  @JsonPropertyDescription("The parameters of the call that is executing.")
  @BeanProperty
  var parameters: List[String] = new ArrayList[String]()

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the stack frame.")
  @BeanProperty
  var properties: Properties__3 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[StackFrame].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("message")
    sb.append('=')
    sb.append((if ((this.message == null)) "<null>" else this.message))
    sb.append(',')
    sb.append("uri")
    sb.append('=')
    sb.append((if ((this.uri == null)) "<null>" else this.uri))
    sb.append(',')
    sb.append("uriBaseId")
    sb.append('=')
    sb.append((if ((this.uriBaseId == null)) "<null>" else this.uriBaseId))
    sb.append(',')
    sb.append("line")
    sb.append('=')
    sb.append((if ((this.line == null)) "<null>" else this.line))
    sb.append(',')
    sb.append("column")
    sb.append('=')
    sb.append((if ((this.column == null)) "<null>" else this.column))
    sb.append(',')
    sb.append("module")
    sb.append('=')
    sb.append((if ((this.module == null)) "<null>" else this.module))
    sb.append(',')
    sb.append("threadId")
    sb.append('=')
    sb.append((if ((this.threadId == null)) "<null>" else this.threadId))
    sb.append(',')
    sb.append("fullyQualifiedLogicalName")
    sb.append('=')
    sb.append((if ((this.fullyQualifiedLogicalName == null)) "<null>" else this.fullyQualifiedLogicalName))
    sb.append(',')
    sb.append("logicalLocationKey")
    sb.append('=')
    sb.append((if ((this.logicalLocationKey == null)) "<null>" else this.logicalLocationKey))
    sb.append(',')
    sb.append("address")
    sb.append('=')
    sb.append((if ((this.address == null)) "<null>" else this.address))
    sb.append(',')
    sb.append("offset")
    sb.append('=')
    sb.append((if ((this.offset == null)) "<null>" else this.offset))
    sb.append(',')
    sb.append("parameters")
    sb.append('=')
    sb.append((if ((this.parameters == null)) "<null>" else this.parameters))
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
    result = ((result * 31) + (if ((this.address == null)) 0 else this.address.hashCode))
    result = ((result * 31) + (if ((this.offset == null)) 0 else this.offset.hashCode))
    result = ((result * 31) + (if ((this.line == null)) 0 else this.line.hashCode))
    result = ((result * 31) + (if ((this.module == null)) 0 else this.module.hashCode))
    result = ((result * 31) + (if ((this.column == null)) 0 else this.column.hashCode))
    result = ((result * 31) + (if ((this.message == null)) 0 else this.message.hashCode))
    result = ((result * 31) + (if ((this.uri == null)) 0 else this.uri.hashCode))
    result = ((result * 31) + (if ((this.threadId == null)) 0 else this.threadId.hashCode))
    result = ((result * 31) + (if ((this.fullyQualifiedLogicalName == null)) 0 else this.fullyQualifiedLogicalName.hashCode))
    result = ((result * 31) + (if ((this.logicalLocationKey == null)) 0 else this.logicalLocationKey.hashCode))
    result = ((result * 31) + (if ((this.parameters == null)) 0 else this.parameters.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result = ((result * 31) + (if ((this.uriBaseId == null)) 0 else this.uriBaseId.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[StackFrame]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[StackFrame]
    ((((((((((((((this.address == rhs.address) || ((this.address != null) && this.address == rhs.address)) && ((this.offset == rhs.offset) || ((this.offset != null) && this.offset == rhs.offset))) && ((this.line == rhs.line) || ((this.line != null) && this.line == rhs.line))) && ((this.module == rhs.module) || ((this.module != null) && this.module == rhs.module))) && ((this.column == rhs.column) || ((this.column != null) && this.column == rhs.column))) && ((this.message == rhs.message) || ((this.message != null) && this.message == rhs.message))) && ((this.uri == rhs.uri) || ((this.uri != null) && this.uri == rhs.uri))) && ((this.threadId == rhs.threadId) || ((this.threadId != null) && this.threadId == rhs.threadId))) && ((this.fullyQualifiedLogicalName == rhs.fullyQualifiedLogicalName) || ((this.fullyQualifiedLogicalName != null) && this.fullyQualifiedLogicalName == rhs.fullyQualifiedLogicalName))) && ((this.logicalLocationKey == rhs.logicalLocationKey) || ((this.logicalLocationKey != null) && this.logicalLocationKey == rhs.logicalLocationKey))) && ((this.parameters == rhs.parameters) || ((this.parameters != null) && this.parameters == rhs.parameters))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties))) && ((this.uriBaseId == rhs.uriBaseId) || ((this.uriBaseId != null) && this.uriBaseId == rhs.uriBaseId)))
  }
}
