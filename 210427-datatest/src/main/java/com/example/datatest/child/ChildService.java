package com.example.datatest.child;

import com.example.datatest.AbstractService;
import org.springframework.stereotype.Service;


@Service
public class ChildService extends AbstractService<ChildEntity> {

    public ChildService(ChildRepository childRepository) {
        super(childRepository);
    }

}
