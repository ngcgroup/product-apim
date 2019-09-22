/*
 * WSO2 API Manager - Publisher API
 * This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.0.4/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: v1.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.publisher.api.v1.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * LifecycleStateAvailableTransitionsDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-22T21:52:12.257+05:30")
public class LifecycleStateAvailableTransitionsDTO {
  @SerializedName("event")
  private String event = null;

  @SerializedName("targetState")
  private String targetState = null;

  public LifecycleStateAvailableTransitionsDTO event(String event) {
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(example = "Promote", value = "")
  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public LifecycleStateAvailableTransitionsDTO targetState(String targetState) {
    this.targetState = targetState;
    return this;
  }

   /**
   * Get targetState
   * @return targetState
  **/
  @ApiModelProperty(example = "Created", value = "")
  public String getTargetState() {
    return targetState;
  }

  public void setTargetState(String targetState) {
    this.targetState = targetState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifecycleStateAvailableTransitionsDTO lifecycleStateAvailableTransitions = (LifecycleStateAvailableTransitionsDTO) o;
    return Objects.equals(this.event, lifecycleStateAvailableTransitions.event) &&
        Objects.equals(this.targetState, lifecycleStateAvailableTransitions.targetState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, targetState);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifecycleStateAvailableTransitionsDTO {\n");
    
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    targetState: ").append(toIndentedString(targetState)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

