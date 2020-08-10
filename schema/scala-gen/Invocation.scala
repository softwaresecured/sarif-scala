import java.util.Date
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("commandLine", "responseFiles", "startTime", "endTime", "machine", "account", "processId", "fileName", "workingDirectory", "environmentVariables", "properties"))
class Invocation {

  @JsonProperty("commandLine")
  @JsonPropertyDescription("The command line used to invoke the tool.")
  @BeanProperty
  var commandLine: String = _

  @JsonProperty("responseFiles")
  @JsonPropertyDescription("The contents of any response files specified on the tool's command line.")
  @BeanProperty
  var responseFiles: ResponseFiles = _

  @JsonProperty("startTime")
  @JsonPropertyDescription("The date and time at which the run started. See \"Date/time properties\" in the SARIF spec for the required format.")
  @BeanProperty
  var startTime: Date = _

  @JsonProperty("endTime")
  @JsonPropertyDescription("The date and time at which the run ended. See \"Date/time properties\" in the  SARIF spec for the required format.")
  @BeanProperty
  var endTime: Date = _

  @JsonProperty("machine")
  @JsonPropertyDescription("The machine that hosted the analysis tool run.")
  @BeanProperty
  var machine: String = _

  @JsonProperty("account")
  @JsonPropertyDescription("The account that ran the analysis tool.")
  @BeanProperty
  var account: String = _

  @JsonProperty("processId")
  @JsonPropertyDescription("The process id for the analysis tool run.")
  @BeanProperty
  var processId: java.lang.Integer = _

  @JsonProperty("fileName")
  @JsonPropertyDescription("The fully qualified path to the analysis tool.")
  @BeanProperty
  var fileName: String = _

  @JsonProperty("workingDirectory")
  @JsonPropertyDescription("The working directory for the analysis rool run.")
  @BeanProperty
  var workingDirectory: String = _

  @JsonProperty("environmentVariables")
  @JsonPropertyDescription("The environment variables associated with the analysis tool process, expressed as key/value pairs.")
  @BeanProperty
  var environmentVariables: EnvironmentVariables = _

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the run.")
  @BeanProperty
  var properties: Properties__1 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Invocation].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("commandLine")
    sb.append('=')
    sb.append((if ((this.commandLine == null)) "<null>" else this.commandLine))
    sb.append(',')
    sb.append("responseFiles")
    sb.append('=')
    sb.append((if ((this.responseFiles == null)) "<null>" else this.responseFiles))
    sb.append(',')
    sb.append("startTime")
    sb.append('=')
    sb.append((if ((this.startTime == null)) "<null>" else this.startTime))
    sb.append(',')
    sb.append("endTime")
    sb.append('=')
    sb.append((if ((this.endTime == null)) "<null>" else this.endTime))
    sb.append(',')
    sb.append("machine")
    sb.append('=')
    sb.append((if ((this.machine == null)) "<null>" else this.machine))
    sb.append(',')
    sb.append("account")
    sb.append('=')
    sb.append((if ((this.account == null)) "<null>" else this.account))
    sb.append(',')
    sb.append("processId")
    sb.append('=')
    sb.append((if ((this.processId == null)) "<null>" else this.processId))
    sb.append(',')
    sb.append("fileName")
    sb.append('=')
    sb.append((if ((this.fileName == null)) "<null>" else this.fileName))
    sb.append(',')
    sb.append("workingDirectory")
    sb.append('=')
    sb.append((if ((this.workingDirectory == null)) "<null>" else this.workingDirectory))
    sb.append(',')
    sb.append("environmentVariables")
    sb.append('=')
    sb.append((if ((this.environmentVariables == null)) "<null>" else this.environmentVariables))
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
    result = ((result * 31) + (if ((this.fileName == null)) 0 else this.fileName.hashCode))
    result = ((result * 31) + (if ((this.processId == null)) 0 else this.processId.hashCode))
    result = ((result * 31) + (if ((this.workingDirectory == null)) 0 else this.workingDirectory.hashCode))
    result = ((result * 31) + (if ((this.machine == null)) 0 else this.machine.hashCode))
    result = ((result * 31) + (if ((this.environmentVariables == null)) 0 else this.environmentVariables.hashCode))
    result = ((result * 31) + (if ((this.responseFiles == null)) 0 else this.responseFiles.hashCode))
    result = ((result * 31) + (if ((this.startTime == null)) 0 else this.startTime.hashCode))
    result = ((result * 31) + (if ((this.endTime == null)) 0 else this.endTime.hashCode))
    result = ((result * 31) + (if ((this.commandLine == null)) 0 else this.commandLine.hashCode))
    result = ((result * 31) + (if ((this.account == null)) 0 else this.account.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Invocation]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Invocation]
    ((((((((((((this.fileName == rhs.fileName) || ((this.fileName != null) && this.fileName == rhs.fileName)) && ((this.processId == rhs.processId) || ((this.processId != null) && this.processId == rhs.processId))) && ((this.workingDirectory == rhs.workingDirectory) || ((this.workingDirectory != null) && this.workingDirectory == rhs.workingDirectory))) && ((this.machine == rhs.machine) || ((this.machine != null) && this.machine == rhs.machine))) && ((this.environmentVariables == rhs.environmentVariables) || ((this.environmentVariables != null) && this.environmentVariables == rhs.environmentVariables))) && ((this.responseFiles == rhs.responseFiles) || ((this.responseFiles != null) && this.responseFiles == rhs.responseFiles))) && ((this.startTime == rhs.startTime) || ((this.startTime != null) && this.startTime == rhs.startTime))) && ((this.endTime == rhs.endTime) || ((this.endTime != null) && this.endTime == rhs.endTime))) && ((this.commandLine == rhs.commandLine) || ((this.commandLine != null) && this.commandLine == rhs.commandLine))) && ((this.account == rhs.account) || ((this.account != null) && this.account == rhs.account))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties)))
  }
}
