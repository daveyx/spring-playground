package org.example.nonProblematic;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;


@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {

    protected Long id;

    protected Timestamp modificationTime;

}
