/*
 * WSO2 API Manager - Store
 * This document specifies a **RESTful API** for WSO2 **API Manager** - Store.  It is written with [swagger 2](http://swagger.io/). 
 *
 * OpenAPI spec version: v1.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.store.api.v1.dto;

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
 * APIURLsDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-22T21:52:19.732+05:30")
public class APIURLsDTO {
  @SerializedName("http")
  private String http = null;

  @SerializedName("https")
  private String https = null;

  @SerializedName("ws")
  private String ws = null;

  @SerializedName("wss")
  private String wss = null;

  public APIURLsDTO http(String http) {
    this.http = http;
    return this;
  }

   /**
   * HTTP environment URL
   * @return http
  **/
  @ApiModelProperty(example = "http://localhost:8280/phoneverify/1.0.0", value = "HTTP environment URL")
  public String getHttp() {
    return http;
  }

  public void setHttp(String http) {
    this.http = http;
  }

  public APIURLsDTO https(String https) {
    this.https = https;
    return this;
  }

   /**
   * HTTPS environment URL
   * @return https
  **/
  @ApiModelProperty(example = "https://localhost:8243/phoneverify/1.0.0", value = "HTTPS environment URL")
  public String getHttps() {
    return https;
  }

  public void setHttps(String https) {
    this.https = https;
  }

  public APIURLsDTO ws(String ws) {
    this.ws = ws;
    return this;
  }

   /**
   * WS environment URL
   * @return ws
  **/
  @ApiModelProperty(example = "ws://localhost:9099/phoneverify/1.0.0", value = "WS environment URL")
  public String getWs() {
    return ws;
  }

  public void setWs(String ws) {
    this.ws = ws;
  }

  public APIURLsDTO wss(String wss) {
    this.wss = wss;
    return this;
  }

   /**
   * WSS environment URL
   * @return wss
  **/
  @ApiModelProperty(example = "wss://localhost:9099/phoneverify/1.0.0", value = "WSS environment URL")
  public String getWss() {
    return wss;
  }

  public void setWss(String wss) {
    this.wss = wss;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    APIURLsDTO apIURLs = (APIURLsDTO) o;
    return Objects.equals(this.http, apIURLs.http) &&
        Objects.equals(this.https, apIURLs.https) &&
        Objects.equals(this.ws, apIURLs.ws) &&
        Objects.equals(this.wss, apIURLs.wss);
  }

  @Override
  public int hashCode() {
    return Objects.hash(http, https, ws, wss);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APIURLsDTO {\n");
    
    sb.append("    http: ").append(toIndentedString(http)).append("\n");
    sb.append("    https: ").append(toIndentedString(https)).append("\n");
    sb.append("    ws: ").append(toIndentedString(ws)).append("\n");
    sb.append("    wss: ").append(toIndentedString(wss)).append("\n");
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

