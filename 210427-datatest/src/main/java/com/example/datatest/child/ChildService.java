package com.example.datatest.child;

import com.example.datatest.AbstractService;
import com.example.datatest.parent.ParentEntity;
import com.example.datatest.parent.ParentService;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class ChildService extends AbstractService<ChildEntity> {

    private final ParentService parentService;


    public ChildService(ChildRepository childRepository,
                        ParentService parentService) {
        super(childRepository);
        this.parentService = parentService;
    }

    @Override
    public ChildEntity save(ChildEntity childEntity) {
        ParentEntity parentEntity = parentService.findById(childEntity.getParentEntity().getId());
        Objects.requireNonNull(parentEntity);

        parentService.touch(parentEntity);

        return super.save(childEntity);
    }

}
