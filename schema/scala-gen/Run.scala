import java.util.ArrayList
import java.util.LinkedHashSet
import java.util.List
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
@JsonPropertyOrder(Array("tool", "invocation", "files", "logicalLocations", "results", "toolNotifications", "configurationNotifications", "rules", "id", "stableId", "automationId", "baselineId", "architecture", "properties"))
class Run {

  @JsonProperty("tool")
  @JsonPropertyDescription("The analysis tool that was run.")
  @BeanProperty
  var tool: Tool = _

  @JsonProperty("invocation")
  @JsonPropertyDescription("The runtime environment of the analysis tool run.")
  @BeanProperty
  var invocation: Invocation = _

  @JsonProperty("files")
  @JsonPropertyDescription("A dictionary, each of whose keys is a URI and each of whose values is an array of file objects representing the location of a single file scanned during the run.")
  @BeanProperty
  var files: Files = _

  @JsonProperty("logicalLocations")
  @JsonPropertyDescription("A dictionary, each of whose keys specifies a logical location such as a namespace, type or function.")
  @BeanProperty
  var logicalLocations: LogicalLocations = _

  @JsonProperty("results")
  @JsonDeserialize(as = classOf[java.util.LinkedHashSet])
  @JsonPropertyDescription("The set of results contained in an SARIF log. The results array can be omitted when a run is solely exporting rules metadata. It must be present (but may be empty) in the event that a log file represents an actual scan.")
  @BeanProperty
  var results: Set[Result] = new LinkedHashSet[Result]()

  @JsonProperty("toolNotifications")
  @JsonPropertyDescription("A list of runtime conditions detected by the tool in the course of the analysis.")
  @BeanProperty
  var toolNotifications: List[Notification] = new ArrayList[Notification]()

  @JsonProperty("configurationNotifications")
  @JsonPropertyDescription("A list of conditions detected by the tool that are relevant to the tool's configuration.")
  @BeanProperty
  var configurationNotifications: List[Notification] = new ArrayList[Notification]()

  @JsonProperty("rules")
  @JsonPropertyDescription("A dictionary, each of whose keys is a string and each of whose values is a 'rule' object, that describe all rules associated with an analysis tool or a specific run of an analysis tool.")
  @BeanProperty
  var rules: Rules = _

  @JsonProperty("id")
  @JsonPropertyDescription("An identifier for the run.")
  @BeanProperty
  var id: String = _

  @JsonProperty("stableId")
  @JsonPropertyDescription("A stable identifier for a run, for example, 'nightly Clang analyzer run'. Multiple runs of the same type can have the same stableId.")
  @BeanProperty
  var stableId: String = _

  @JsonProperty("automationId")
  @JsonPropertyDescription("A global identifier that allows the run to be correlated with other artifacts produced by a larger automation process.")
  @BeanProperty
  var automationId: String = _

  @JsonProperty("baselineId")
  @JsonPropertyDescription("The 'id' property of a separate (potentially external) SARIF 'run' instance that comprises the baseline that was used to compute result 'baselineState' properties for the run.")
  @BeanProperty
  var baselineId: String = _

  @JsonProperty("architecture")
  @JsonPropertyDescription("The hardware architecture for which the run was targeted.")
  @BeanProperty
  var architecture: String = _

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the run.")
  @BeanProperty
  var properties: Properties__9 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Run].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("tool")
    sb.append('=')
    sb.append((if ((this.tool == null)) "<null>" else this.tool))
    sb.append(',')
    sb.append("invocation")
    sb.append('=')
    sb.append((if ((this.invocation == null)) "<null>" else this.invocation))
    sb.append(',')
    sb.append("files")
    sb.append('=')
    sb.append((if ((this.files == null)) "<null>" else this.files))
    sb.append(',')
    sb.append("logicalLocations")
    sb.append('=')
    sb.append((if ((this.logicalLocations == null)) "<null>" else this.logicalLocations))
    sb.append(',')
    sb.append("results")
    sb.append('=')
    sb.append((if ((this.results == null)) "<null>" else this.results))
    sb.append(',')
    sb.append("toolNotifications")
    sb.append('=')
    sb.append((if ((this.toolNotifications == null)) "<null>" else this.toolNotifications))
    sb.append(',')
    sb.append("configurationNotifications")
    sb.append('=')
    sb.append((if ((this.configurationNotifications == null)) "<null>" else this.configurationNotifications))
    sb.append(',')
    sb.append("rules")
    sb.append('=')
    sb.append((if ((this.rules == null)) "<null>" else this.rules))
    sb.append(',')
    sb.append("id")
    sb.append('=')
    sb.append((if ((this.id == null)) "<null>" else this.id))
    sb.append(',')
    sb.append("stableId")
    sb.append('=')
    sb.append((if ((this.stableId == null)) "<null>" else this.stableId))
    sb.append(',')
    sb.append("automationId")
    sb.append('=')
    sb.append((if ((this.automationId == null)) "<null>" else this.automationId))
    sb.append(',')
    sb.append("baselineId")
    sb.append('=')
    sb.append((if ((this.baselineId == null)) "<null>" else this.baselineId))
    sb.append(',')
    sb.append("architecture")
    sb.append('=')
    sb.append((if ((this.architecture == null)) "<null>" else this.architecture))
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
    result = ((result * 31) + (if ((this.stableId == null)) 0 else this.stableId.hashCode))
    result = ((result * 31) + (if ((this.automationId == null)) 0 else this.automationId.hashCode))
    result = ((result * 31) + (if ((this.logicalLocations == null)) 0 else this.logicalLocations.hashCode))
    result = ((result * 31) + (if ((this.rules == null)) 0 else this.rules.hashCode))
    result = ((result * 31) + (if ((this.configurationNotifications == null)) 0 else this.configurationNotifications.hashCode))
    result = ((result * 31) + (if ((this.tool == null)) 0 else this.tool.hashCode))
    result = ((result * 31) + (if ((this.baselineId == null)) 0 else this.baselineId.hashCode))
    result = ((result * 31) + (if ((this.toolNotifications == null)) 0 else this.toolNotifications.hashCode))
    result = ((result * 31) + (if ((this.invocation == null)) 0 else this.invocation.hashCode))
    result = ((result * 31) + (if ((this.files == null)) 0 else this.files.hashCode))
    result = ((result * 31) + (if ((this.id == null)) 0 else this.id.hashCode))
    result = ((result * 31) + (if ((this.results == null)) 0 else this.results.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result = ((result * 31) + (if ((this.architecture == null)) 0 else this.architecture.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Run]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Run]
    (((((((((((((((this.stableId == rhs.stableId) || ((this.stableId != null) && this.stableId == rhs.stableId)) && ((this.automationId == rhs.automationId) || ((this.automationId != null) && this.automationId == rhs.automationId))) && ((this.logicalLocations == rhs.logicalLocations) || ((this.logicalLocations != null) && this.logicalLocations == rhs.logicalLocations))) && ((this.rules == rhs.rules) || ((this.rules != null) && this.rules == rhs.rules))) && ((this.configurationNotifications == rhs.configurationNotifications) || ((this.configurationNotifications != null) && this.configurationNotifications == rhs.configurationNotifications))) && ((this.tool == rhs.tool) || ((this.tool != null) && this.tool == rhs.tool))) && ((this.baselineId == rhs.baselineId) || ((this.baselineId != null) && this.baselineId == rhs.baselineId))) && ((this.toolNotifications == rhs.toolNotifications) || ((this.toolNotifications != null) && this.toolNotifications == rhs.toolNotifications))) && ((this.invocation == rhs.invocation) || ((this.invocation != null) && this.invocation == rhs.invocation))) && ((this.files == rhs.files) || ((this.files != null) && this.files == rhs.files))) && ((this.id == rhs.id) || ((this.id != null) && this.id == rhs.id))) && ((this.results == rhs.results) || ((this.results != null) && this.results == rhs.results))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties))) && ((this.architecture == rhs.architecture) || ((this.architecture != null) && this.architecture == rhs.architecture)))
  }
}
