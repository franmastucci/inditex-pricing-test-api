package com.inditex.price.dto.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * The Class ErrorListMessageDTO.
 */

@Schema(name = "Error", description = "ErrorListMessageDTO data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorListMessageDTO implements Serializable {

    private List<ErrorMessageDTO> errors;

}
