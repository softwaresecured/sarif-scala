import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("name", "fullName", "version", "semanticVersion", "fileVersion", "sarifLoggerVersion", "language", "properties"))
class Tool {

  @JsonProperty("name")
  @JsonPropertyDescription("The name of the tool.")
  @BeanProperty
  var name: String = _

  @JsonProperty("fullName")
  @JsonPropertyDescription("The name of the tool along with its version and any other useful identifying information, such as its locale.")
  @BeanProperty
  var fullName: String = _

  @JsonProperty("version")
  @JsonPropertyDescription("The tool version, in whatever format the tool natively provides.")
  @BeanProperty
  var version: String = _

  @JsonProperty("semanticVersion")
  @JsonPropertyDescription("The tool version in the format specified by Semantic Versioning 2.0.")
  @BeanProperty
  var semanticVersion: String = _

  @JsonProperty("fileVersion")
  @JsonPropertyDescription("The binary version of the tool's primary executable file (for operating systems such as Windows that provide that information).")
  @BeanProperty
  var fileVersion: String = _

  @JsonProperty("sarifLoggerVersion")
  @JsonPropertyDescription("A version that uniquely identifies the SARIF logging component that generated this file, if it is versioned separately from the tool.")
  @BeanProperty
  var sarifLoggerVersion: String = _

  @JsonProperty("language")
  @JsonPropertyDescription("The tool language (expressed as an ISO 649 two-letter lowercase culture code) and region (expressed as an ISO 3166 two-letter uppercase subculture code associated with a country or region).")
  @BeanProperty
  var language: String = _

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the tool.")
  @BeanProperty
  var properties: Properties = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Tool].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("name")
    sb.append('=')
    sb.append((if ((this.name == null)) "<null>" else this.name))
    sb.append(',')
    sb.append("fullName")
    sb.append('=')
    sb.append((if ((this.fullName == null)) "<null>" else this.fullName))
    sb.append(',')
    sb.append("version")
    sb.append('=')
    sb.append((if ((this.version == null)) "<null>" else this.version))
    sb.append(',')
    sb.append("semanticVersion")
    sb.append('=')
    sb.append((if ((this.semanticVersion == null)) "<null>" else this.semanticVersion))
    sb.append(',')
    sb.append("fileVersion")
    sb.append('=')
    sb.append((if ((this.fileVersion == null)) "<null>" else this.fileVersion))
    sb.append(',')
    sb.append("sarifLoggerVersion")
    sb.append('=')
    sb.append((if ((this.sarifLoggerVersion == null)) "<null>" else this.sarifLoggerVersion))
    sb.append(',')
    sb.append("language")
    sb.append('=')
    sb.append((if ((this.language == null)) "<null>" else this.language))
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
    result = ((result * 31) + (if ((this.sarifLoggerVersion == null)) 0 else this.sarifLoggerVersion.hashCode))
    result = ((result * 31) + (if ((this.name == null)) 0 else this.name.hashCode))
    result = ((result * 31) + (if ((this.semanticVersion == null)) 0 else this.semanticVersion.hashCode))
    result = ((result * 31) + (if ((this.fullName == null)) 0 else this.fullName.hashCode))
    result = ((result * 31) + (if ((this.language == null)) 0 else this.language.hashCode))
    result = ((result * 31) + (if ((this.version == null)) 0 else this.version.hashCode))
    result = ((result * 31) + (if ((this.fileVersion == null)) 0 else this.fileVersion.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Tool]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Tool]
    (((((((((this.sarifLoggerVersion == rhs.sarifLoggerVersion) || ((this.sarifLoggerVersion != null) && this.sarifLoggerVersion == rhs.sarifLoggerVersion)) && ((this.name == rhs.name) || ((this.name != null) && this.name == rhs.name))) && ((this.semanticVersion == rhs.semanticVersion) || ((this.semanticVersion != null) && this.semanticVersion == rhs.semanticVersion))) && ((this.fullName == rhs.fullName) || ((this.fullName != null) && this.fullName == rhs.fullName))) && ((this.language == rhs.language) || ((this.language != null) && this.language == rhs.language))) && ((this.version == rhs.version) || ((this.version != null) && this.version == rhs.version))) && ((this.fileVersion == rhs.fileVersion) || ((this.fileVersion != null) && this.fileVersion == rhs.fileVersion))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties)))
  }
}
