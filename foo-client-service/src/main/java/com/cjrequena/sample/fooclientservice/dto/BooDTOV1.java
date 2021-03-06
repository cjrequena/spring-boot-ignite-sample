package com.cjrequena.sample.fooclientservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cjrequena.sample.fooclientservice.dto.serializer.LocalDateDeserializer;
import com.cjrequena.sample.fooclientservice.dto.serializer.LocalDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author cjrequena
 * @version 1.0
 * @since JDK1.8
 * @see
 *
 */
@Data
@JsonPropertyOrder(value = {
  "id",
  "name",
  "description",
  "creationDate"
})
@JsonTypeName("boo")
@ApiModel(value = "Boo", description = "BooDTOV1")
@XmlRootElement
public class BooDTOV1 extends DTO implements Serializable {

  //@NotNull(message = "id is required field")
  @JsonProperty(value = "id")
  @Getter(onMethod = @__({@JsonProperty("id")}))
  @ApiModelProperty(value = "id", position = 1, readOnly = true)
  private Long id;

  @NotNull(message = "name is a required field")
  @JsonProperty(value = "name", required = true)
  @Getter(onMethod = @__({@JsonProperty("name")}))
  @ApiModelProperty(value = "name", position = 2, required = true)
  private String name;

  //@NotNull(message = "description is a required field")
  @JsonProperty(value = "description")
  @Getter(onMethod = @__({@JsonProperty("description")}))
  @ApiModelProperty(value = "description", allowEmptyValue = true, position = 3)
  private String description;

  //@NotNull(message = "Creation Date is a required field")
  @JsonProperty(value = "creation_date")
  @Getter(onMethod = @__({@JsonProperty("creation_date")}))
  @ApiModelProperty(example = "yyyy-MM-dd", value = "creation_date", readOnly = true, position = 4)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate creationDate;

}
