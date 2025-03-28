package com.Healthcare_AI.Healthcare.AI.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class VoiceConversionRequestDTO {
    private MultipartFile multipartFile;
}
