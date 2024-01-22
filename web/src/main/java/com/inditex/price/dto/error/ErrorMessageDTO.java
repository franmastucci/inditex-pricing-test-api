package com.inditex.price.dto.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * The Class ErrorMessageDTO.
 */

@Schema(name = "Error", description = "ErrorMessageDTO data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageDTO implements Serializable {

    /** The code. */
    private String code;

    /** The description. */
    private String description;

}
