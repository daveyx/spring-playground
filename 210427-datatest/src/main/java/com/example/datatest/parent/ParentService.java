package com.example.datatest.parent;

import com.example.datatest.AbstractService;
import org.springframework.stereotype.Service;


@Service
public class ParentService extends AbstractService<ParentEntity> {

    public ParentService(ParentRepository parentRepository) {
        super(parentRepository);
    }

}
