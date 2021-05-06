package org.example.problematicWithLombokConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO extends BaseDTO {

    private String information;

    private LocalDate validFrom;

    private LocalDate validTo;

}
