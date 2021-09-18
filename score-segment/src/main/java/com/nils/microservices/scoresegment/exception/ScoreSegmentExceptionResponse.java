package com.nils.microservices.scoresegment.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScoreSegmentExceptionResponse {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date timestamp;

    private String code;

    private String message;

    private String details;
}
