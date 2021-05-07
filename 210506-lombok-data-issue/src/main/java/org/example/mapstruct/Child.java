package org.example.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Child extends Base {

    private String information;

    private LocalDate validFrom;

    private LocalDate validTo;

}
