import java.util.Date
import java.util.HashMap
import java.util.Map
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonValue
import Notification._
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

object Notification {

  object Level extends Enumeration {

    val NOTE = new Level("note")

    val WARNING = new Level("warning")

    val ERROR = new Level("error")

    class Level private (var value: String) extends Val {

      override def toString(): String = this.value
    }

    private val CONSTANTS = new HashMap[String, Notification.Level]()

    for (c <- values) {
      CONSTANTS.put(c.value, c)
    }

    @JsonCreator
    def fromValue(value: String): Notification.Level = {
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
@JsonPropertyOrder(Array("id", "ruleId", "ruleKey", "physicalLocation", "message", "level", "threadId", "time", "exception", "properties"))
class Notification {

  @JsonProperty("id")
  @JsonPropertyDescription("An identifier for the condition that was encountered.")
  @BeanProperty
  var id: String = _

  @JsonProperty("ruleId")
  @JsonPropertyDescription("The stable, unique identifier of the rule (if any) to which this notification is relevant. If 'ruleKey' is not specified, this member can be used to retrieve rule metadata from the rules dictionary, if it exists.")
  @BeanProperty
  var ruleId: String = _

  @JsonProperty("ruleKey")
  @JsonPropertyDescription("A key used to retrieve the rule metadata from the rules dictionary that is relevant to the notificationn.")
  @BeanProperty
  var ruleKey: String = _

  @JsonProperty("physicalLocation")
  @JsonPropertyDescription("A physical location relevant to a result. Specifies a reference to a programming artifact together with a range of bytes or characters within that artifact.")
  @BeanProperty
  var physicalLocation: PhysicalLocation = _

  @JsonProperty("message")
  @JsonPropertyDescription("A string that describes the condition that was encountered.")
  @BeanProperty
  var message: String = _

  @JsonProperty("level")
  @JsonPropertyDescription("A value specifying the severity level of the notification.")
  @BeanProperty
  var level: Notification.Level = Notification.Level.fromValue("warning")

  @JsonProperty("threadId")
  @JsonPropertyDescription("The thread identifier of the code that generated the notification.")
  @BeanProperty
  var threadId: java.lang.Integer = _

  @JsonProperty("time")
  @JsonPropertyDescription("The date and time at which the analysis tool generated the notification.")
  @BeanProperty
  var time: Date = _

  @JsonProperty("exception")
  @BeanProperty
  var exception: Exception = _

  @JsonProperty("properties")
  @JsonPropertyDescription("Key/value pairs that provide additional information about the notification.")
  @BeanProperty
  var properties: Properties__8 = _

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Notification].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("id")
    sb.append('=')
    sb.append((if ((this.id == null)) "<null>" else this.id))
    sb.append(',')
    sb.append("ruleId")
    sb.append('=')
    sb.append((if ((this.ruleId == null)) "<null>" else this.ruleId))
    sb.append(',')
    sb.append("ruleKey")
    sb.append('=')
    sb.append((if ((this.ruleKey == null)) "<null>" else this.ruleKey))
    sb.append(',')
    sb.append("physicalLocation")
    sb.append('=')
    sb.append((if ((this.physicalLocation == null)) "<null>" else this.physicalLocation))
    sb.append(',')
    sb.append("message")
    sb.append('=')
    sb.append((if ((this.message == null)) "<null>" else this.message))
    sb.append(',')
    sb.append("level")
    sb.append('=')
    sb.append((if ((this.level == null)) "<null>" else this.level))
    sb.append(',')
    sb.append("threadId")
    sb.append('=')
    sb.append((if ((this.threadId == null)) "<null>" else this.threadId))
    sb.append(',')
    sb.append("time")
    sb.append('=')
    sb.append((if ((this.time == null)) "<null>" else this.time))
    sb.append(',')
    sb.append("exception")
    sb.append('=')
    sb.append((if ((this.exception == null)) "<null>" else this.exception))
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
    result = ((result * 31) + (if ((this.threadId == null)) 0 else this.threadId.hashCode))
    result = ((result * 31) + (if ((this.exception == null)) 0 else this.exception.hashCode))
    result = ((result * 31) + (if ((this.physicalLocation == null)) 0 else this.physicalLocation.hashCode))
    result = ((result * 31) + (if ((this.level == null)) 0 else this.level.hashCode))
    result = ((result * 31) + (if ((this.id == null)) 0 else this.id.hashCode))
    result = ((result * 31) + (if ((this.time == null)) 0 else this.time.hashCode))
    result = ((result * 31) + (if ((this.ruleId == null)) 0 else this.ruleId.hashCode))
    result = ((result * 31) + (if ((this.message == null)) 0 else this.message.hashCode))
    result = ((result * 31) + (if ((this.ruleKey == null)) 0 else this.ruleKey.hashCode))
    result = ((result * 31) + (if ((this.properties == null)) 0 else this.properties.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Notification]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Notification]
    (((((((((((this.threadId == rhs.threadId) || ((this.threadId != null) && this.threadId == rhs.threadId)) && ((this.exception == rhs.exception) || ((this.exception != null) && this.exception == rhs.exception))) && ((this.physicalLocation == rhs.physicalLocation) || ((this.physicalLocation != null) && this.physicalLocation == rhs.physicalLocation))) && ((this.level == rhs.level) || ((this.level != null) && this.level == rhs.level))) && ((this.id == rhs.id) || ((this.id != null) && this.id == rhs.id))) && ((this.time == rhs.time) || ((this.time != null) && this.time == rhs.time))) && ((this.ruleId == rhs.ruleId) || ((this.ruleId != null) && this.ruleId == rhs.ruleId))) && ((this.message == rhs.message) || ((this.message != null) && this.message == rhs.message))) && ((this.ruleKey == rhs.ruleKey) || ((this.ruleKey != null) && this.ruleKey == rhs.ruleKey))) && ((this.properties == rhs.properties) || ((this.properties != null) && this.properties == rhs.properties)))
  }
}
