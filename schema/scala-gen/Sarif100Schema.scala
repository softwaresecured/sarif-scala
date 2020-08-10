import java.net.URI
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonValue
import Sarif100Schema._
import scala.beans.{BeanProperty, BooleanBeanProperty}
//remove if not needed
import scala.collection.JavaConversions._

object Sarif100Schema {

  object Version extends Enumeration {

    val _1_0_0 = new Version("1.0.0")

    class Version private (var value: String) extends Val {

      override def toString(): String = this.value
    }

    private val CONSTANTS = new HashMap[String, Sarif100Schema.Version]()

    for (c <- values) {
      CONSTANTS.put(c.value, c)
    }

    @JsonCreator
    def fromValue(value: String): Sarif100Schema.Version = {
      val constant = CONSTANTS.get(value)
      if (constant == null) {
        throw new IllegalArgumentException(value)
      } else {
        constant
      }
    }

    implicit def convertValue(v: Value): Version = v.asInstanceOf[Version]
  }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(Array("$schema", "version", "runs"))
class Sarif100Schema {

  @JsonProperty("$schema")
  @JsonPropertyDescription("The URI of the JSON schema corresponding to the version.")
  private var $schema: URI = _

  @JsonProperty("version")
  @JsonPropertyDescription("The SARIF format version of this log file.")
  @BeanProperty
  var version: Sarif100Schema.Version = _

  @JsonProperty("runs")
  @JsonPropertyDescription("The set of runs contained in this log file.")
  @BeanProperty
  var runs: List[Run] = new ArrayList[Run]()

  @JsonProperty("$schema")
  def get$schema(): URI = $schema

  @JsonProperty("$schema")
  def set$schema($schema: URI) {
    this.$schema = $schema
  }

  override def toString(): String = {
    val sb = new StringBuilder()
    sb.append(classOf[Sarif100Schema].getName).append('@').append(java.lang.Integer.toHexString(System.identityHashCode(this))).append('[')
    sb.append("$schema")
    sb.append('=')
    sb.append((if ((this.$schema == null)) "<null>" else this.$schema))
    sb.append(',')
    sb.append("version")
    sb.append('=')
    sb.append((if ((this.version == null)) "<null>" else this.version))
    sb.append(',')
    sb.append("runs")
    sb.append('=')
    sb.append((if ((this.runs == null)) "<null>" else this.runs))
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
    result = ((result * 31) + (if ((this.$schema == null)) 0 else this.$schema.hashCode))
    result = ((result * 31) + (if ((this.version == null)) 0 else this.version.hashCode))
    result = ((result * 31) + (if ((this.runs == null)) 0 else this.runs.hashCode))
    result
  }

  override def equals(other: Any): Boolean = {
    if (other == this) {
      return true
    }
    if ((other.isInstanceOf[Sarif100Schema]) == false) {
      return false
    }
    val rhs = other.asInstanceOf[Sarif100Schema]
    ((((this.$schema == rhs.$schema) || ((this.$schema != null) && this.$schema == rhs.$schema)) && ((this.version == rhs.version) || ((this.version != null) && this.version == rhs.version))) && ((this.runs == rhs.runs) || ((this.runs != null) && this.runs == rhs.runs)))
  }
}
