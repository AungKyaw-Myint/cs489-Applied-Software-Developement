package org.cs489.userprofile.exception;

import java.time.Instant;

public record ApiError(

        String message,
        String path,
        Integer statusCode,
        Instant timeStamp
) {
}
