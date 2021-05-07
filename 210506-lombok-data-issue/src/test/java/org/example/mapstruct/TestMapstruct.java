package org.example.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.opentest4j.AssertionFailedError;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMapstruct {

    private IMapper mapper = Mappers.getMapper(IMapper.class);

    private static final String INFORMATION = "some info string";
    private static final LocalDate VALID_FROM = LocalDate.now();
    private static final LocalDate VALID_TO = LocalDate.now();


    private Wrapper getWrapper() {
        Child first = new Child(INFORMATION, VALID_FROM, VALID_TO);
        first.setId(1L);
        first.setModificationTime(Timestamp.valueOf(LocalDate.now().atStartOfDay()));

        Child second = new Child(INFORMATION, VALID_FROM, VALID_TO);
        second.setId(2L);
        second.setModificationTime(Timestamp.valueOf(LocalDate.now().atTime(LocalTime.MAX)));

        Set<Child> children = new HashSet<>();
        children.add(first);
        children.add(second);

        Wrapper wrapper = new Wrapper();
        wrapper.setChildren(children);

        assertEquals(2, wrapper.getChildren().size());

        return wrapper;
    }
    
    @Test
    void test() {
        WrapperDTO wrapperDTO = mapper.mapToDTO(getWrapper());

        Assertions.assertThrows(AssertionFailedError.class, () -> assertEquals(2, wrapperDTO.getChildren().size()));
    }

}
