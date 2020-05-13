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
import java.util.ArrayList;
import java.util.List;
import org.wso2.am.integration.clients.publisher.api.v1.dto.AlertConfigDTO;

/**
 * AlertDTO
 */

public class AlertDTO {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("configuration")
  private List<AlertConfigDTO> _configuration = null;

  public AlertDTO id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * The alert Id
   * @return id
  **/
  @ApiModelProperty(example = "1", value = "The alert Id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AlertDTO name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the alert.
   * @return name
  **/
  @ApiModelProperty(example = "AbnormalRequestsPerMin", value = "The name of the alert.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AlertDTO _configuration(List<AlertConfigDTO> _configuration) {
    this._configuration = _configuration;
    return this;
  }

  public AlertDTO addConfigurationItem(AlertConfigDTO _configurationItem) {
    if (this._configuration == null) {
      this._configuration = new ArrayList<>();
    }
    this._configuration.add(_configurationItem);
    return this;
  }

   /**
   * Get _configuration
   * @return _configuration
  **/
  @ApiModelProperty(value = "")
  public List<AlertConfigDTO> getConfiguration() {
    return _configuration;
  }

  public void setConfiguration(List<AlertConfigDTO> _configuration) {
    this._configuration = _configuration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlertDTO alert = (AlertDTO) o;
    return Objects.equals(this.id, alert.id) &&
        Objects.equals(this.name, alert.name) &&
        Objects.equals(this._configuration, alert._configuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, _configuration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlertDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
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

