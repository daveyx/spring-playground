package org.example.nonProblematic;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO extends BaseDTO {

    private String information;

    private LocalDate validFrom;

    private LocalDate validTo;

}
