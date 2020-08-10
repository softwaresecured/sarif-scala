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
import AnnotatedCodeLocation._
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

object AnnotatedCodeLocation {

  object Importance extends Enumeration {

    val IMPORTANT = new Importance("important")

    val ESSENTIAL = new Importance("essential")

    val UNIMPORTANT = new Importance("unimportant")

    class Importance private (var value: String) extends Val {

      override def toString(): String = this.value
    }

    private val CONSTANTS = new HashMap[String, AnnotatedCodeLocation.Importance]()

    for (c <- values) {
      CONSTANTS.put(c.value, c)
    }

    @JsonCreator
    def fromValue(value: String): AnnotatedCodeLocation.Importance = {
      val constant = CONSTANTS.get(value)
      if (constant == null) {
        throw new IllegalArgumentException(value)
      } else {
        constant
      }
    }

    implicit def convertValue(v: Value): Importance = v.asInstanceOf[Importance]
  }

  object Kind extends Enumeration {

    val ALIAS = new Kind("alias")

    val ASSIGNMENT = new Kind("assignment")

    val BRANCH = new Kind("branch")

    val CALL = new Kind("call")

    val CALL_RETURN = new Kind("callReturn")

    val CONTINUATION = new Kind("continuation")

    val DECLARATION = new Kind("declaration")

    val FUNCTION_ENTER = new Kind("functionEnter")

    val FUNCTION_EXIT = new Kind("functionExit")

    val FUNCTION_RETURN = new Kind("functionReturn")

    val USAGE = new Kind("usage")

    class Kind private (var value: String) extends Val {

      override def toString(): String = this.value
    }

    private val CONSTANTS = new HashMap[String, AnnotatedCodeLocation.Kind]()

    for (c <- values) {
      CONSTANTS.put(c.value, c)
    }

    @JsonCreator
    def fromValue(value: String): AnnotatedCodeLocation.Kind = {
      val constant = CONSTANTS.get(value)
      if (constant == null) {
        throw new IllegalArgumentException(value)
      } else {
        constant
      }
    }

    implicit def convertValue(v: Value): Kind = v.asInstanceOf[Kind]
  }

  object TaintKind extends Enumeration {

    val SOURCE = new TaintKind("source")

    val SINK = new TaintKind("sink")

    val SANITIZER = new TaintKind("sanitizer")

    class TaintKind private (var value: String) extends Val {

      override def toString(): String = this.value
    }

    private val CONSTANTS = new HashMap[String, AnnotatedCodeLocation.TaintKind]()

    for (c <- values) {
      CONSTANTS.put(c.value, c)
    }

    @JsonCreator
    def fromValue(value: String): AnnotatedCodeLocation.TaintKind = {
      val constant = CONSTANTS.get(value)
      if (constant == null) {
        throw new IllegalArgumentException(value)
      } else {
        constant
      }
    }

    implicit def convertValue(v: Value): TaintKind = v.asInstanceOf[TaintKind]
  }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("id", "step", "physicalLocation", "fullyQualifiedLogicalName", "logicalLocationKey", "module", "threadId", "message", "kind", "taintKind", "target", "values", "state", "targetKey", "essential", "importance", "snippet", "annotations", "properties"))
class AnnotatedCodeLocation {

  @JsonProperty("id")
  @JsonPropertyDescription("OBSOLETE (use \"step\" instead): An identifier for the location, unique within the scope of the code flow within which it occurs.")
  @BeanProperty
  var id: java.lang.Integer = _

  @JsonProperty("step")
  @JsonPropertyDescription("The 0-based sequence number of the location in the code flow within which it occurs.")
  @BeanProperty
  var step: java.lang.Integer = _

  @JsonProperty("physicalLocation")
  @JsonPropertyDescription("A physical location relevant to a result. Specifies a reference to a programming artifact together with a range of bytes or characters within that artifact.")
  @BeanProperty
  var physicalLocation: PhysicalLocation = _

  @JsonProperty("fullyQualifiedLogicalName")
  @JsonPropertyDescription("The fully qualified name of the method or function that is executing.")
  @BeanProperty
  var fullyQualifiedLogicalName: String = _

  @JsonProperty("logicalLocationKey")
  @JsonPropertyDescription("A key used to retrieve the annotation's logicalLocation from the logicalLocations dictionary.")
  @BeanProperty
  var logicalLocationKey: String = _

  @JsonProperty("module")
  @JsonPropertyDescription("The name of the module that contains the code that is executing.")
  @BeanProperty
  var module: String = _

  @JsonProperty("threadId")
  @JsonPropertyDescription("The thread identifier of the code that is executing.")
  @BeanProperty
  var threadId: java.lang.Integer = _

  @JsonProperty("message")
  @JsonPropertyDescription("A message relevant to this annotation.")
  @BeanProperty
  var message: String = _

  @JsonProperty("kind")
  @JsonPropertyDescription("Categorizes the location.")
  @BeanProperty
  var kind: AnnotatedCodeLocation.Kind = _

  @JsonProperty("taintKind")
  @JsonPropertyDescription("Classifies state transitions in code locations relevant to a taint analysis.")
  @BeanProperty
  var taintKind: AnnotatedCodeLocation.TaintKind = _

  @JsonProperty("target")
  @JsonPropertyDescription("The fully qualified name of the target on which this location operates. For an annotation of kind 'call', for example, the target refers to the fully qualified logical name of the function called from this location.")
  @BeanProperty
  var target: String = _

  @JsonProperty("values")
  @JsonPropertyDescription("An ordered set of strings that comprise input or return values for the current operation. For an annotation of kind 'call', for example, this property may hold the ordered list of arguments passed to the callee.")
  @BeanProperty
  var values: List[String] = new ArrayList[String]()

  @JsonProperty("state")
  @JsonPropertyDescription("A dictionary, each of whose keys specifies a variable or expression, the associated value of which represents the variable or expression value. For an annotation of kind 'continuation', for example, this dictionary might hold the current assumed values of a set of global variables.")
  @BeanProperty
  var state: State = _

  @JsonProperty("targetKey")
  @JsonPropertyDescription("A key used to retrieve the target's logicalLocation from the logicalLocations dictionary.")
  @BeanProperty
  var targetKey: String = _

  @JsonProperty("essential")
  @JsonPropertyDescription("OBSOLETE (use \"importance\" instead): True if this location is essential to understanding the code flow in which it occurs.")
  @BeanProperty
  var essential: java.lang.Boolean = _

  @JsonProperty("importance")
  @JsonPropertyDescription("Specifies the importance of this location in understanding the code flow in which it occurs. The order from most to least important is \"essential\", \"important\", \"unimportant\". Default: \"important\".")
  @BeanProperty
  var importance: AnnotatedCodeLocation.Importance = _

  @JsonProperty("snippet")
  @JsonPropertyDescription("The source code at the specified location.")
  @BeanProperty
  var snippet: String = _

  @JsonProperty("annotations")
  @JsonDeserialize(as = classOf[java.util.LinkedHashSet])
  @JsonPropertyDescription("A set of messages relevant to the current annotated code location.")
  @BeanProperty
  var annotations: Set[Annotation] = new LinkedHashSet[Annotation]()

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the code location.")
  @BeanProperty
  var properties: Properties__5 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[AnnotatedCodeLocation].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("id")
    sb.append('=')
    sb.append((if ((this.id == null)) "<null>" else this.id))
    sb.append(',')
    sb.append("step")
    sb.append('=')
    sb.append((if ((this.step == null)) "<null>" else this.step))
    sb.append(',')
    sb.append("physicalLocation")
    sb.append('=')
    sb.append((if ((this.physicalLocation == null)) "<null>" else this.physicalLocation))
    sb.append(',')
    sb.append("fullyQualifiedLogicalName")
    sb.append('=')
    sb.append((if ((this.fullyQualifiedLogicalName == null)) "<null>" else this.fullyQualifiedLogicalName))
    sb.append(',')
    sb.append("logicalLocationKey")
    sb.append('=')
    sb.append((if ((this.logicalLocationKey == null)) "<null>" else this.logicalLocationKey))
    sb.append(',')
    sb.append("module")
    sb.append('=')
    sb.append((if ((this.module == null)) "<null>" else this.module))
    sb.append(',')
    sb.append("threadId")
    sb.append('=')
    sb.append((if ((this.threadId == null)) "<null>" else this.threadId))
    sb.append(',')
    sb.append("message")
    sb.append('=')
    sb.append((if ((this.message == null)) "<null>" else this.message))
    sb.append(',')
    sb.append("kind")
    sb.append('=')
    sb.append((if ((this.kind == null)) "<null>" else this.kind))
    sb.append(',')
    sb.append("taintKind")
    sb.append('=')
    sb.append((if ((this.taintKind == null)) "<null>" else this.taintKind))
    sb.append(',')
    sb.append("target")
    sb.append('=')
    sb.append((if ((this.target == null)) "<null>" else this.target))
    sb.append(',')
    sb.append("values")
    sb.append('=')
    sb.append((if ((this.values == null)) "<null>" else this.values))
    sb.append(',')
    sb.append("state")
    sb.append('=')
    sb.append((if ((this.state == null)) "<null>" else this.state))
    sb.append(',')
    sb.append("targetKey")
    sb.append('=')
    sb.append((if ((this.targetKey == null)) "<null>" else this.targetKey))
    sb.append(',')
    sb.append("essential")
    sb.append('=')
    sb.append((if ((this.essential == null)) "<null>" else this.essential))
    sb.append(',')
    sb.append("importance")
    sb.append('=')
    sb.append((if ((this.importance == null)) "<null>" else this.importance))
    sb.append(',')
    sb.append("snippet")
    sb.append('=')
    sb.append((if ((this.snippet == null)) "<null>" else this.snippet))
    sb.append(',')
    sb.append("annotations")
    sb.append('=')
    sb.append((if ((this.annotations == null)) "<null>" else this.annotations))
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
    result = ((result * 31) + (if ((this.physicalLocation == null)) 0 else this.physicalLocation.hashCode))
    result = ((result * 31) + (if ((this.kind == null)) 0 else this.kind.hashCode))
    result = ((result * 31) + (if ((this.importance == null)) 0 else this.importance.hashCode))
    result = ((result * 31) + (if ((this.module == null)) 0 else this.module.hashCode))
    result = ((result * 31) + (if ((this.values == null)) 0 else this.values.hashCode))
    result = ((result * 31) + (if ((this.taintKind == null)) 0 else this.taintKind.hashCode))
    result = ((result * 31) + (if ((this.annotations == null)) 0 else this.annotations.hashCode))
    result = ((result * 31) + (if ((this.message == null)) 0 else this.message.hashCode))
    result = ((result * 31) + (if ((this.targetKey == null)) 0 else this.targetKey.hashCode))
    result = ((result * 31) + (if ((this.target == null)) 0 else this.target.hashCode))
    result = ((result * 31) + (if ((this.threadId == null)) 0 else this.threadId.hashCode))
    result = ((result * 31) + (if ((this.fullyQualifiedLogicalName == null)) 0 else this.fullyQualifiedLogicalName.hashCode))
    result = ((result * 31) + (if ((this.logicalLocationKey == null)) 0 else this.logicalLocationKey.hashCode))
    result = ((result * 31) + (if ((this.step == null)) 0 else this.step.hashCode))
    result = ((result * 31) + (if ((this.id == null)) 0 else this.id.hashCode))
    result = ((result * 31) + (if ((this.state == null)) 0 else this.state.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result = ((result * 31) + (if ((this.essential == null)) 0 else this.essential.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[AnnotatedCodeLocation]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[AnnotatedCodeLocation]
    ((((((((((((((((((((this.snippet == rhs.snippet) || ((this.snippet != null) && this.snippet == rhs.snippet)) && ((this.physicalLocation == rhs.physicalLocation) || ((this.physicalLocation != null) && this.physicalLocation == rhs.physicalLocation))) && ((this.kind == rhs.kind) || ((this.kind != null) && this.kind == rhs.kind))) && ((this.importance == rhs.importance) || ((this.importance != null) && this.importance == rhs.importance))) && ((this.module == rhs.module) || ((this.module != null) && this.module == rhs.module))) && ((this.values == rhs.values) || ((this.values != null) && this.values == rhs.values))) && ((this.taintKind == rhs.taintKind) || ((this.taintKind != null) && this.taintKind == rhs.taintKind))) && ((this.annotations == rhs.annotations) || ((this.annotations != null) && this.annotations == rhs.annotations))) && ((this.message == rhs.message) || ((this.message != null) && this.message == rhs.message))) && ((this.targetKey == rhs.targetKey) || ((this.targetKey != null) && this.targetKey == rhs.targetKey))) && ((this.target == rhs.target) || ((this.target != null) && this.target == rhs.target))) && ((this.threadId == rhs.threadId) || ((this.threadId != null) && this.threadId == rhs.threadId))) && ((this.fullyQualifiedLogicalName == rhs.fullyQualifiedLogicalName) || ((this.fullyQualifiedLogicalName != null) && this.fullyQualifiedLogicalName == rhs.fullyQualifiedLogicalName))) && ((this.logicalLocationKey == rhs.logicalLocationKey) || ((this.logicalLocationKey != null) && this.logicalLocationKey == rhs.logicalLocationKey))) && ((this.step == rhs.step) || ((this.step != null) && this.step == rhs.step))) && ((this.id == rhs.id) || ((this.id != null) && this.id == rhs.id))) && ((this.state == rhs.state) || ((this.state != null) && this.state == rhs.state))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties))) && ((this.essential == rhs.essential) || ((this.essential != null) && this.essential == rhs.essential)))
  }
}
