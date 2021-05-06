package org.example.problematic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestProblematic {

    private static final String INFORMATION = "some info string";
    private static final LocalDate VALID_FROM = LocalDate.now();
    private static final LocalDate VALID_TO = LocalDate.now();

    private ChildDTO firstDTO;
    private ChildDTO secondDTO;


    @BeforeEach
    void beforeEach() {
        firstDTO = new ChildDTO(INFORMATION, VALID_FROM, VALID_TO);
        firstDTO.setId(1L);
        firstDTO.setModificationTime(Timestamp.valueOf(LocalDate.now().atStartOfDay()));

        secondDTO = new ChildDTO(INFORMATION, VALID_FROM, VALID_TO);
        secondDTO.setId(2L);
        secondDTO.setModificationTime(Timestamp.valueOf(LocalDate.now().atTime(LocalTime.MAX)));
    }

    @Test
    void test_list_success() {
        List<ChildDTO> list = new ArrayList<>();
        list.add(firstDTO);
        list.add(secondDTO);

        assertEquals(2, list.size());
    }

    @Test
    void test_hashSet_fails() {
        System.setProperty("lombok.equalsAndHashCode.callSuper", "call");
        Set<ChildDTO> hashSet = new HashSet<>();
        hashSet.add(firstDTO);
        hashSet.add(secondDTO);

        Assertions.assertThrows(AssertionFailedError.class, () -> assertEquals(2, hashSet.size()));
    }

    @Test
    void test_linkedHashSet_fails() {
        Set<ChildDTO> hashSet = new LinkedHashSet<>();
        hashSet.add(firstDTO);
        hashSet.add(secondDTO);


        Assertions.assertThrows(AssertionFailedError.class, () -> assertEquals(2, hashSet.size()));
    }

}
