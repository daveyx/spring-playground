package org.example.mapstruct;

import org.mapstruct.Mapper;


@Mapper
public interface IMapper {

    WrapperDTO mapToDTO(Wrapper wrapper);

}
