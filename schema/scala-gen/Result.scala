import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import java.util.Set
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import Result._
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

object Result {

  object BaselineState extends Enumeration {

    val NEW = new BaselineState("new")

    val EXISTING = new BaselineState("existing")

    val ABSENT = new BaselineState("absent")

    class BaselineState private (var value: String) extends Val {

      override def toString(): String = this.value
    }

    private val CONSTANTS = new HashMap[String, Result.BaselineState]()

    for (c <- values) {
      CONSTANTS.put(c.value, c)
    }

    @JsonCreator
    def fromValue(value: String): Result.BaselineState = {
      val constant = CONSTANTS.get(value)
      if (constant == null) {
        throw new IllegalArgumentException(value)
      } else {
        constant
      }
    }

    implicit def convertValue(v: Value): BaselineState = v.asInstanceOf[BaselineState]
  }

  object Level extends Enumeration {

    val NOT_APPLICABLE = new Level("notApplicable")

    val PASS = new Level("pass")

    val NOTE = new Level("note")

    val WARNING = new Level("warning")

    val ERROR = new Level("error")

    class Level private (var value: String) extends Val {

      override def toString(): String = this.value
    }

    private val CONSTANTS = new HashMap[String, Result.Level]()

    for (c <- values) {
      CONSTANTS.put(c.value, c)
    }

    @JsonCreator
    def fromValue(value: String): Result.Level = {
      val constant = CONSTANTS.get(value)
      if (constant == null) {
        throw new IllegalArgumentException(value)
      } else {
        constant
      }
    }

    implicit def convertValue(v: Value): Level = v.asInstanceOf[Level]
  }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("ruleId", "ruleKey", "level", "message", "formattedRuleMessage", "locations", "snippet", "id", "toolFingerprintContribution", "stacks", "codeFlows", "relatedLocations", "suppressionStates", "baselineState", "fixes", "properties"))
class Result {

  @JsonProperty("ruleId")
  @JsonPropertyDescription("The stable, unique identifier of the rule (if any) to which this notification is relevant. If 'ruleKey' is not specified, this member can be used to retrieve rule metadata from the rules dictionary, if it exists.")
  @BeanProperty
  var ruleId: String = _

  @JsonProperty("ruleKey")
  @JsonPropertyDescription("A key used to retrieve the rule metadata from the rules dictionary that is relevant to the notificationn.")
  @BeanProperty
  var ruleKey: String = _

  @JsonProperty("level")
  @JsonPropertyDescription("A value specifying the severity level of the result. If this property is not present, its implied value is 'warning'.")
  @BeanProperty
  var level: Result.Level = Result.Level.fromValue("warning")

  @JsonProperty("message")
  @JsonPropertyDescription("A string that describes the result. The first sentence of the message only will be displayed when visible space is limited.")
  @BeanProperty
  var message: String = _

  @JsonProperty("formattedRuleMessage")
  @JsonPropertyDescription("Contains information that can be used to construct a formatted message that describes a result.")
  @BeanProperty
  var formattedRuleMessage: FormattedRuleMessage = _

  @JsonProperty("locations")
  @JsonDeserialize(as = classOf[java.util.LinkedHashSet])
  @JsonPropertyDescription("One or more locations where the result occurred. Specify only one location unless the problem indicated by the result can only be corrected by making a change at every specified location.")
  @BeanProperty
  var locations: Set[Location] = new LinkedHashSet[Location]()

  @JsonProperty("snippet")
  @JsonPropertyDescription("A source code or other file fragment that illustrates the result.")
  @BeanProperty
  var snippet: String = _

  @JsonProperty("id")
  @JsonPropertyDescription("A unique identifer for the result.")
  @BeanProperty
  var id: String = _

  @JsonProperty("toolFingerprintContribution")
  @JsonPropertyDescription("A string that contributes to the unique identity of the result.")
  @BeanProperty
  var toolFingerprintContribution: String = _

  @JsonProperty("stacks")
  @JsonDeserialize(as = classOf[java.util.LinkedHashSet])
  @JsonPropertyDescription("An array of 'stack' objects relevant to the result.")
  @BeanProperty
  var stacks: Set[Stack] = new LinkedHashSet[Stack]()

  @JsonProperty("codeFlows")
  @JsonDeserialize(as = classOf[java.util.LinkedHashSet])
  @JsonPropertyDescription("An array of 'codeFlow' objects relevant to the result.")
  @BeanProperty
  var codeFlows: Set[CodeFlow] = new LinkedHashSet[CodeFlow]()

  @JsonProperty("relatedLocations")
  @JsonDeserialize(as = classOf[java.util.LinkedHashSet])
  @JsonPropertyDescription("A grouped set of locations and messages, if available, that represent code areas that are related to this result.")
  @BeanProperty
  var relatedLocations: Set[AnnotatedCodeLocation] = new LinkedHashSet[AnnotatedCodeLocation]()

  @JsonProperty("suppressionStates")
  @BeanProperty
  var suppressionStates: List[SuppressionState] = new ArrayList[SuppressionState]()

  @JsonProperty("baselineState")
  @JsonPropertyDescription("The state of a result relative to a baseline of a previous run.")
  @BeanProperty
  var baselineState: Result.BaselineState = _

  @JsonProperty("fixes")
  @JsonDeserialize(as = classOf[java.util.LinkedHashSet])
  @JsonPropertyDescription("An array of 'fix' objects, each of which represents a proposed fix to the problem indicated by the result.")
  @BeanProperty
  var fixes: Set[Fix] = new LinkedHashSet[Fix]()

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the result.")
  @BeanProperty
  var properties: Properties__7 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Result].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("ruleId")
    sb.append('=')
    sb.append((if ((this.ruleId == null)) "<null>" else this.ruleId))
    sb.append(',')
    sb.append("ruleKey")
    sb.append('=')
    sb.append((if ((this.ruleKey == null)) "<null>" else this.ruleKey))
    sb.append(',')
    sb.append("level")
    sb.append('=')
    sb.append((if ((this.level == null)) "<null>" else this.level))
    sb.append(',')
    sb.append("message")
    sb.append('=')
    sb.append((if ((this.message == null)) "<null>" else this.message))
    sb.append(',')
    sb.append("formattedRuleMessage")
    sb.append('=')
    sb.append((if ((this.formattedRuleMessage == null)) "<null>" else this.formattedRuleMessage))
    sb.append(',')
    sb.append("locations")
    sb.append('=')
    sb.append((if ((this.locations == null)) "<null>" else this.locations))
    sb.append(',')
    sb.append("snippet")
    sb.append('=')
    sb.append((if ((this.snippet == null)) "<null>" else this.snippet))
    sb.append(',')
    sb.append("id")
    sb.append('=')
    sb.append((if ((this.id == null)) "<null>" else this.id))
    sb.append(',')
    sb.append("toolFingerprintContribution")
    sb.append('=')
    sb.append((if ((this.toolFingerprintContribution == null)) "<null>" else this.toolFingerprintContribution))
    sb.append(',')
    sb.append("stacks")
    sb.append('=')
    sb.append((if ((this.stacks == null)) "<null>" else this.stacks))
    sb.append(',')
    sb.append("codeFlows")
    sb.append('=')
    sb.append((if ((this.codeFlows == null)) "<null>" else this.codeFlows))
    sb.append(',')
    sb.append("relatedLocations")
    sb.append('=')
    sb.append((if ((this.relatedLocations == null)) "<null>" else this.relatedLocations))
    sb.append(',')
    sb.append("suppressionStates")
    sb.append('=')
    sb.append((if ((this.suppressionStates == null)) "<null>" else this.suppressionStates))
    sb.append(',')
    sb.append("baselineState")
    sb.append('=')
    sb.append((if ((this.baselineState == null)) "<null>" else this.baselineState))
    sb.append(',')
    sb.append("fixes")
    sb.append('=')
    sb.append((if ((this.fixes == null)) "<null>" else this.fixes))
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
    result = ((result * 31) + (if ((this.snippet == null)) 0 else this.snippet.hashCode))
    result = ((result * 31) + (if ((this.toolFingerprintContribution == null)) 0 else this.toolFingerprintContribution.hashCode))
    result = ((result * 31) + (if ((this.level == null)) 0 else this.level.hashCode))
    result = ((result * 31) + (if ((this.stacks == null)) 0 else this.stacks.hashCode))
    result = ((result * 31) + (if ((this.suppressionStates == null)) 0 else this.suppressionStates.hashCode))
    result = ((result * 31) + (if ((this.message == null)) 0 else this.message.hashCode))
    result = ((result * 31) + (if ((this.ruleKey == null)) 0 else this.ruleKey.hashCode))
    result = ((result * 31) + (if ((this.fixes == null)) 0 else this.fixes.hashCode))
    result = ((result * 31) + (if ((this.relatedLocations == null)) 0 else this.relatedLocations.hashCode))
    result = ((result * 31) + (if ((this.codeFlows == null)) 0 else this.codeFlows.hashCode))
    result = ((result * 31) + (if ((this.formattedRuleMessage == null)) 0 else this.formattedRuleMessage.hashCode))
    result = ((result * 31) + (if ((this.locations == null)) 0 else this.locations.hashCode))
    result = ((result * 31) + (if ((this.id == null)) 0 else this.id.hashCode))
    result = ((result * 31) + (if ((this.baselineState == null)) 0 else this.baselineState.hashCode))
    result = ((result * 31) + (if ((this.ruleId == null)) 0 else this.ruleId.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Result]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Result]
    (((((((((((((((((this.snippet == rhs.snippet) || ((this.snippet != null) && this.snippet == rhs.snippet)) && ((this.toolFingerprintContribution == rhs.toolFingerprintContribution) || ((this.toolFingerprintContribution != null) && this.toolFingerprintContribution == rhs.toolFingerprintContribution))) && ((this.level == rhs.level) || ((this.level != null) && this.level == rhs.level))) && ((this.stacks == rhs.stacks) || ((this.stacks != null) && this.stacks == rhs.stacks))) && ((this.suppressionStates == rhs.suppressionStates) || ((this.suppressionStates != null) && this.suppressionStates == rhs.suppressionStates))) && ((this.message == rhs.message) || ((this.message != null) && this.message == rhs.message))) && ((this.ruleKey == rhs.ruleKey) || ((this.ruleKey != null) && this.ruleKey == rhs.ruleKey))) && ((this.fixes == rhs.fixes) || ((this.fixes != null) && this.fixes == rhs.fixes))) && ((this.relatedLocations == rhs.relatedLocations) || ((this.relatedLocations != null) && this.relatedLocations == rhs.relatedLocations))) && ((this.codeFlows == rhs.codeFlows) || ((this.codeFlows != null) && this.codeFlows == rhs.codeFlows))) && ((this.formattedRuleMessage == rhs.formattedRuleMessage) || ((this.formattedRuleMessage != null) && this.formattedRuleMessage == rhs.formattedRuleMessage))) && ((this.locations == rhs.locations) || ((this.locations != null) && this.locations == rhs.locations))) && ((this.id == rhs.id) || ((this.id != null) && this.id == rhs.id))) && ((this.baselineState == rhs.baselineState) || ((this.baselineState != null) && this.baselineState == rhs.baselineState))) && ((this.ruleId == rhs.ruleId) || ((this.ruleId != null) && this.ruleId == rhs.ruleId))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties)))
  }
}
