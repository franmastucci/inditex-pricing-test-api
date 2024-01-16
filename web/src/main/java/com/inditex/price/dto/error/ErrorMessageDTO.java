package com.inditex.price.dto.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * The Class ErrorMessageDTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "Error", description = "ErrorMessageDTO data")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDTO implements Serializable {


    /** The code. */
    private String code;

    /** The description. */
    private String description;

    /** The level. */
    private String level;

    /** The message. */
    private String message;

    @Override
    public String toString() {
        return "ErrorMessageDTO{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
