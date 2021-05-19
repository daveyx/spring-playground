package com.example.datatest.child;

import com.example.datatest.AbstractService;
import com.example.datatest.parent.ParentService;
import org.springframework.stereotype.Service;


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
        childEntity = super.save(childEntity);
        parentService.save(childEntity.getParentEntity());

        return childEntity;
    }

}
